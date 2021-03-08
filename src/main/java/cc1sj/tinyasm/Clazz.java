package cc1sj.tinyasm;

import static cc1sj.tinyasm.TypeUtils.arrayOf;

import org.objectweb.asm.Type;

public interface Clazz {
	Type getType();

	String signatureAnyway();

	String signatureWhenNeed();

	boolean needSignature();

	String getDescriptor();

	static Clazz of(String classname) {
		return new ClazzType(classname);
	}

	static Clazz of(String classname, boolean isarray) {
		return new ClazzType(arrayOf(typeOf(classname), isarray));
	}

	static Clazz of(Class<?> classname) {
		return classname!=null?new ClazzType(classname):null;
	}

	static Clazz of(Class<?> classname, boolean isarray) {
		if(isarray) {
			return new ClazzType(arrayOf(typeOf(classname), isarray));
		}else {
			return of(classname);
		}
	}

	static Clazz of(Type classname) {
		return new ClazzType(classname);
	}

	static Clazz of(Type classname, boolean isarray) {
		return new ClazzType(arrayOf(classname, isarray));
	}

	static Clazz typeVariableOf(String name) {
		return new ClazzVariable(name);
	}
	
	static Clazz typeUnboundedVariable() {
		return new ClazzVariable("*");
	}

	static Clazz formalTypeParameterOf(String name, Clazz clazz) {
		return new ClazzFormalTypeParameter(name, clazz);
	}

	static Clazz of(String originclazzName, String... genericParameterClazz) {
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

	static Clazz of(Class<?> originclazzName, Class<?>... genericParameterClazz) {
		ClazzType baseType = new ClazzType(originclazzName);
		Clazz[] gClazz = new Clazz[genericParameterClazz.length];
		for (int i = 0; i < genericParameterClazz.length; i++) {
			gClazz[i] = Clazz.of(genericParameterClazz[i]);

		}
		return new ClazzComplex(baseType, gClazz);
	}

	static Clazz of(Class<?> originclazzName, Clazz... genericParameterClazz) {
		ClazzType baseType = new ClazzType(originclazzName);

		return new ClazzComplex(baseType, genericParameterClazz);
	}
	static Clazz of(Clazz baseType, Clazz... genericParameterClazz) {

		return new ClazzComplex(baseType, genericParameterClazz);
	}
	static Type typeOf(String name) {
		Type type;
		if (name == null) type = Type.VOID_TYPE;
		if (TypeUtils.primaryTypeMaps.containsKey(name)) type = TypeUtils.primaryTypeMaps.get(name);
		type = Type.getObjectType(name.replace('.', '/'));
		return type;
	}

	static Type typeOf(Class<?> clazz) {
		return Type.getType(clazz);
	}

	String signatureOf();

}