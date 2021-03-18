package cn.sj1.tinyasm.core;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

import java.util.List;

public interface UsingDefineStaticField {

	default void staticField(List<Field> fields) {
		for (Field field : fields) {
			staticField(field.name, field.clazz);
		}
	}

	default int staticField(String name, String clazz) {
		return staticField(name, Clazz.of(clazz));
	}

	default int staticField(String name, Class<?> clazz) {
		return staticField(name, Clazz.of(clazz));
	}

	default int staticField(String name, String clazz, boolean isarray) {
		return staticField(name, Clazz.of(clazz, isarray));
	}

	default int staticField(String name, Class<?> clazz, boolean isarray) {
		return staticField(name, Clazz.of(clazz, isarray));
	}

	default int staticField(String name, Clazz clazz) {
		return staticField(ACC_PUBLIC, name, clazz);
	}

	int staticField(int access, String name, Clazz clazz);

	default int staticField(Annotation annotation, String name, Clazz clazz) {
		return staticField(0, annotation, name, clazz);
	}

	int staticField(int access, Annotation annotation, String name, Clazz clazz);
}