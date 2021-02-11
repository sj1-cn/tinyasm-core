package nebula.tinyasm;

import java.util.List;

import static org.objectweb.asm.Opcodes.*;

public interface WithDefineField<T> {

	default T field(List<Field> fields) {
		T t = null;
		for (Field field : fields) {
			t = field(field.name, field.clazz);
		}
		return t;
	}

	default T field(String name, String clazz) {
		return field(name, Clazz.of(clazz));
	}

	default T field(String name, Class<?> clazz) {
		return field(name, Clazz.of(clazz));
	}

	default T field(String name, String clazz, boolean isarray) {
		return field(name, Clazz.of(clazz, isarray));
	}

	default T field(String name, Class<?> clazz, boolean isarray) {
		return field(name, Clazz.of(clazz, isarray));
	}

	default T field(String name, Clazz clazz) {
		return field(ACC_PRIVATE, name, clazz);
	}

	T field(int access, String name, Clazz clazz);

	default T field(Annotation annotation, String name, Clazz clazz) {
		return field(0, annotation, name, clazz);
	}

	T field(int access, Annotation annotation, String name, Clazz clazz);
}