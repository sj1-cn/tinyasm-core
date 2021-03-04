package cc1sj.tinyasm;

import static org.objectweb.asm.Opcodes.ACC_PRIVATE;

import java.util.List;

public interface WithDefineField {

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

	default int field(String name, Clazz clazz) {
		return field(ACC_PRIVATE, name, clazz);
	}

	int field(int access, String name, Clazz clazz);

	default int field(Annotation annotation, String name, Clazz clazz) {
		return field(0, annotation, name, clazz);
	}

	int field(int access, Annotation annotation, String name, Clazz clazz);
}