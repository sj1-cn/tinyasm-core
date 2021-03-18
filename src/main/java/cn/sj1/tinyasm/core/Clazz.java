package cn.sj1.tinyasm.core;

import static cn.sj1.tinyasm.core.TypeUtils.arrayOf;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.objectweb.asm.Type;

/**
 * TODO 暂时为了回避调用方式是的对象是否是接口的逻辑修改成抽象类。回头还是改回去吧
 * 
 * @author wangshilian
 *
 */
public abstract class Clazz {
	public abstract Type getType();

	public abstract String signatureAnyway();

	public abstract String signatureWhenNeed();

	public abstract boolean needSignature();

	public abstract String signatureOf();

	public abstract String getDescriptor();

	public String getDescriptor(List<ClazzFormalTypeParameter> formalTypeParameters) {
		return this.getDescriptor();
	}

	public String signatureOf(List<ClazzFormalTypeParameter> formalTypeParameters) {
		return signatureOf();
	}

	public static Clazz of(java.lang.reflect.Type type) {
		if (type instanceof ParameterizedType) {
			Clazz clazz = Clazz.of(((ParameterizedType) type).getRawType().getTypeName());
			java.lang.reflect.Type[] types = ((ParameterizedType) type).getActualTypeArguments();
			ClazzTypeArgument[] clazzes = new ClazzTypeArgument[types.length];
			for (int j = 0; j < types.length; j++) {
				clazzes[j] = Clazz.typeArgument(Clazz.of(types[j]));
			}
			return Clazz.of(clazz, clazzes);
		} else if (type instanceof Class<?>) {
			return Clazz.of((Class<?>) type);
		} else {
			return null;
		}
	}

	public static ClazzSimple of(String classname) {
		return new ClazzSimple(classname);
	}

	public static ClazzSimple of(String classname, boolean isarray) {
		return new ClazzSimple(arrayOf(typeOf(classname), isarray));
	}

	public static ClazzSimple of(Class<?> classname) {
		return classname != null ? new ClazzSimple(classname) : null;
	}

	public static ClazzSimple of(Class<?> classname, boolean isarray) {
		if (isarray) {
			return new ClazzSimple(arrayOf(typeOf(classname), isarray));
		} else {
			return of(classname);
		}
	}

	public static ClazzSimple of(Type classname) {
		return new ClazzSimple(classname);
	}

	public static ClazzSimple of(Type classname, boolean isarray) {
		return new ClazzSimple(arrayOf(classname, isarray));
	}

	public static ClazzVariable typeVariableOf(String name) {
		return new ClazzVariable(name);
	}

	public static ClazzVariable typeVariableOf(String name, boolean isarray) {
		return new ClazzVariable(name, isarray);
	}

	public static ClazzVariableWithClazz typeVariableOf(String name, Clazz clazz) {
		return new ClazzVariableWithClazz(name, clazz);
	}

	public static ClazzVariableWithClazz typeVariableOf(String name, Clazz clazz, boolean isarray) {
		return new ClazzVariableWithClazz(name, clazz, isarray);
	}

	public static ClazzTypeArgument typeUnboundedTypeArgument() {
		return new ClazzTypeArgument('*');
	}

	public static ClazzFormalTypeParameter formalTypeParameterOf(String name, Clazz clazz) {
		return new ClazzFormalTypeParameter(name, clazz);
	}

	public static Clazz of(String originclazzName, String... genericParameterClazz) {
		ClazzSimple baseType = new ClazzSimple(originclazzName);
		ClazzTypeArgument[] gClazz = new ClazzTypeArgument[genericParameterClazz.length];
		for (int i = 0; i < genericParameterClazz.length; i++) {
			gClazz[i] = Clazz.typeArgument(Clazz.of(genericParameterClazz[i]));

		}
		return new ClazzWithTypeArguments(baseType, gClazz);
	}

	public static Clazz of(Class<?> originclazzName, String... genericParameterClazz) {
		ClazzSimple baseType = new ClazzSimple(originclazzName);
		ClazzTypeArgument[] gClazz = new ClazzTypeArgument[genericParameterClazz.length];
		for (int i = 0; i < genericParameterClazz.length; i++) {
			gClazz[i] = Clazz.typeArgument(Clazz.of(genericParameterClazz[i]));
		}
		return new ClazzWithTypeArguments(baseType, gClazz);
	}

	public static Clazz of(Class<?> originclazzName, Class<?>... genericParameterClazz) {
		ClazzSimple baseType = new ClazzSimple(originclazzName);
		ClazzTypeArgument[] gClazz = new ClazzTypeArgument[genericParameterClazz.length];
		for (int i = 0; i < genericParameterClazz.length; i++) {
			gClazz[i] = Clazz.typeArgument(Clazz.of(genericParameterClazz[i]));
		}
		return new ClazzWithTypeArguments(baseType, gClazz);
	}

	public static Clazz of(Class<?> originclazzName, Clazz... genericParameterClazz) {
		ClazzSimple baseType = new ClazzSimple(originclazzName);
		ClazzTypeArgument[] gClazz = new ClazzTypeArgument[genericParameterClazz.length];
		for (int i = 0; i < genericParameterClazz.length; i++) {
			if (genericParameterClazz[i] instanceof ClazzTypeArgument) {
				gClazz[i] = (ClazzTypeArgument) genericParameterClazz[i];
			} else {
				gClazz[i] = Clazz.typeArgument(genericParameterClazz[i]);
			}
		}
		return new ClazzWithTypeArguments(baseType, gClazz);
	}

	public static Clazz of(Clazz baseType, Clazz... genericParameterClazz) {
		ClazzTypeArgument[] gClazz = new ClazzTypeArgument[genericParameterClazz.length];
		for (int i = 0; i < genericParameterClazz.length; i++) {
			if (genericParameterClazz[i] instanceof ClazzTypeArgument) {
				gClazz[i] = (ClazzTypeArgument) genericParameterClazz[i];
			} else {
				gClazz[i] = Clazz.typeArgument(genericParameterClazz[i]);
			}
		}
		return new ClazzWithTypeArguments(baseType, gClazz);
	}

	public static Clazz of(ClazzSimple baseType, ClazzTypeArgument... genericParameterClazz) {
		return new ClazzWithTypeArguments(baseType, genericParameterClazz);
	}

	public static Type typeOf(String name) {
		Type type;
		if (name == null) type = Type.VOID_TYPE;
		if (TypeUtils.primaryTypeMaps.containsKey(name)) type = TypeUtils.primaryTypeMaps.get(name);
		type = Type.getObjectType(name.replace('.', '/'));
		return type;
	}

	public static Type typeOf(Class<?> clazz) {
		return Type.getType(clazz);
	}

	public static ClazzTypeArgument typeArgument(char wildcard, Class<?> clazz, Class<?>... genericParameterClazz) {
		return new ClazzTypeArgument(wildcard, Clazz.of(clazz, genericParameterClazz));
	}

	public static ClazzTypeArgument typeArgument(char wildcard, Class<?> clazz, Clazz... genericParameterClazz) {
		return new ClazzTypeArgument(wildcard, Clazz.of(clazz, genericParameterClazz));
	}

	public static ClazzTypeArgument typeArgument(char wildcard, Class<?> clazz) {
		return new ClazzTypeArgument(wildcard, Clazz.of(clazz));
	}

	public static ClazzTypeArgument typeArgument(char wildcard, Clazz clazz) {
		return new ClazzTypeArgument(wildcard, clazz);
	}

	public static ClazzTypeArgument typeArgument(Clazz clazz) {
		return new ClazzTypeArgument('=', clazz);
	}

	public static ClazzTypeArgument typeArgument(char wildcard) {
		return new ClazzTypeArgument(wildcard);
	}

}