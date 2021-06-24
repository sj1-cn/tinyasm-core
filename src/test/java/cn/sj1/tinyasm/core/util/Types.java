package cn.sj1.tinyasm.core.util;

import org.objectweb.asm.Type;

public interface Types {
	public static Type typeOf(Class<?> clazz) {
		return Type.getType(clazz);
	}

	public static Type typeOf(String clazz) {
		return Type.getType(clazz);
	}

	public static Type typeOf(String clazz, boolean isArray) {
		Type type = Type.getType(clazz);
		if (isArray) {
			return Type.getType("[" + type.getDescriptor());
		} else {
			return type;
		}
	}

	public static Type typeOf(Class<?> clazz, boolean isArray) {
		Type type = Type.getType(clazz);
		if (isArray) {
			return Type.getType("[" + type.getDescriptor());
		} else {
			return type;
		}
	}

}
