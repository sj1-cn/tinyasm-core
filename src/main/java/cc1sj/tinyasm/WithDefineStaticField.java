package cc1sj.tinyasm;

import static org.objectweb.asm.Opcodes.*;

import java.util.List;

public interface WithDefineStaticField<T> {

	default T staticField(List<Field> fields) {
		T t = null;
		for (Field field : fields) {
			t = staticField(field.name,field.clazz);
		}
		return t;
	}

	default T staticField(String name, String clazz) {
		return staticField(name, Clazz.of(clazz));
	}

	default T staticField(String name, Class<?> clazz) {
		return staticField(name, Clazz.of(clazz));
	}

	default T staticField(String name, String clazz, boolean isarray) {
		return staticField(name, Clazz.of(clazz, isarray));
	}

	default T staticField(String name, Class<?> clazz, boolean isarray) {
		return staticField(name, Clazz.of(clazz, isarray));
	}

	default T staticField(String name, Clazz clazz) {
		return staticField(ACC_PUBLIC, name, clazz);
	}

	T staticField(int access, String name, Clazz clazz);

	default T staticField(Annotation annotation, String name, Clazz clazz) {
		return staticField(0, annotation, name, clazz);
	}

	T staticField(int access, Annotation annotation, String name, Clazz clazz);
}