package cn.sj1.tinyasm.core;

import java.util.List;

public interface UsingDefineField {
	default void field(List<Field> fields) {
		for (Field field : fields) {
			field(field.name, field.clazz);
		}
	}

	default int field(String name, String clazz) {
		return field(name, Clazz.of(clazz));
	}

	default int field(String name, Class<?> clazz) {
		return field(name, Clazz.of(clazz));
	}

	default int field(String name, String clazz, boolean isarray) {
		return field(name, Clazz.of(clazz, isarray));
	}

	default int field(String name, Class<?> clazz, boolean isarray) {
		return field(name, Clazz.of(clazz, isarray));
	}

	int field(String name, Clazz clazz);

	int field(int access, String name, Clazz clazz);

	int field(Annotation annotation, String name, Clazz clazz);

	int field(int access, Annotation annotation, String name, Clazz clazz);
}