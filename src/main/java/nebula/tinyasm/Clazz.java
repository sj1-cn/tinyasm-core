package nebula.tinyasm;

import org.objectweb.asm.Type;

interface Clazz {
	Type getType();

	String signatureAnyway();

	String signatureWhenNeed();

	boolean needSignature();

	String getDescriptor();

	static  Clazz of(String classname) {
		return new ClazzType(classname);
	}

	static Clazz of(Class<?> classname) {
		return new ClazzType(classname);
	}

	static Clazz of(Type classname) {
		return new ClazzType(classname);
	}
}