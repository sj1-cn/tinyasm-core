package nebula.tinyasm;

import org.objectweb.asm.Type;
import static nebula.tinyasm.TypeUtils.*;

interface Clazz {
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
		return new ClazzType(classname);
	}

	static Clazz of(Class<?> classname, boolean isarray) {
		return new ClazzType(arrayOf(typeOf(classname), isarray));
	}

	static Clazz of(Type classname) {
		return new ClazzType(classname);
	}

	static Clazz of(Type classname, boolean isarray) {
		return new ClazzType(arrayOf(classname, isarray));
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
}