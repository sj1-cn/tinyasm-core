package cc1sj.tinyasm;

import static cc1sj.tinyasm.TypeUtils.arrayOf;

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

	public static Clazz of(String classname) {
		return new ClazzType(classname);
	}

	public static Clazz of(String classname, boolean isarray) {
		return new ClazzType(arrayOf(typeOf(classname), isarray));
	}

	public static Clazz of(Class<?> classname) {
		return classname != null ? new ClazzType(classname) : null;
	}

	public static Clazz of(Class<?> classname, boolean isarray) {
		if (isarray) {
			return new ClazzType(arrayOf(typeOf(classname), isarray));
		} else {
			return of(classname);
		}
	}

	public static Clazz of(Type classname) {
		return new ClazzType(classname);
	}

	public static Clazz of(Type classname, boolean isarray) {
		return new ClazzType(arrayOf(classname, isarray));
	}

	public static Clazz typeVariableOf(String name) {
		return new ClazzVariable(name);
	}

	public static Clazz typeVariableOf(String name, boolean isarray) {
		return new ClazzVariable(name, isarray);
	}

	public static Clazz typeUnboundedTypeArgument() {
		return new ClazzTypeArgument('*');
	}

	public static Clazz formalTypeParameterOf(String name, Clazz clazz) {
		return new ClazzFormalTypeParameter(name, clazz);
	}

	public static Clazz of(String originclazzName, String... genericParameterClazz) {
		ClazzType baseType = new ClazzType(originclazzName);
		Clazz[] gClazz = new Clazz[genericParameterClazz.length];
		for (int i = 0; i < genericParameterClazz.length; i++) {
			gClazz[i] = Clazz.of(genericParameterClazz[i]);

		}
		return new ClazzComplex(baseType, gClazz);
	}

	public static Clazz of(Class<?> originclazzName, String... genericParameterClazz) {
		ClazzType baseType = new ClazzType(originclazzName);
		Clazz[] gClazz = new Clazz[genericParameterClazz.length];
		for (int i = 0; i < genericParameterClazz.length; i++) {
			gClazz[i] = Clazz.of(genericParameterClazz[i]);

		}
		return new ClazzComplex(baseType, gClazz);
	}

	public static Clazz of(Class<?> originclazzName, Class<?>... genericParameterClazz) {
		ClazzType baseType = new ClazzType(originclazzName);
		Clazz[] gClazz = new Clazz[genericParameterClazz.length];
		for (int i = 0; i < genericParameterClazz.length; i++) {
			gClazz[i] = Clazz.of(genericParameterClazz[i]);

		}
		return new ClazzComplex(baseType, gClazz);
	}

	public static Clazz of(Class<?> originclazzName, Clazz... genericParameterClazz) {
		ClazzType baseType = new ClazzType(originclazzName);

		return new ClazzComplex(baseType, genericParameterClazz);
	}

	public static Clazz of(Clazz baseType, Clazz... genericParameterClazz) {

		return new ClazzComplex(baseType, genericParameterClazz);
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

	public static Clazz typeArgument(char wildcard) {
		return new ClazzTypeArgument(wildcard);
	}

}