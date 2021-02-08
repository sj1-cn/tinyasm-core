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
		return field(name, TypeUtils.generic(clazz));
	}

	default T field(String name, Class<?> clazz) {
		return field(name, TypeUtils.generic(clazz));
	}

	default T field(String name, Clazz clazz) {
		return field(ACC_PRIVATE, name, clazz);
	}

	default T field(Class<?> annotation, String name, String clazz) {
		return field(Annotation.annotation(annotation), name, TypeUtils.generic(clazz));
	}

	default T field(Class<?> annotation, String name, Class<?> clazz) {
		return field(Annotation.annotation(annotation), name, TypeUtils.generic(clazz));
	}

	default T field(Annotation annotation, String name, Clazz clazz) {
		return field(ACC_PRIVATE, annotation, name, clazz);
	}

	default T field(String name, String clazz, boolean isarray) {
		return field(name, TypeUtils.generic(clazz, isarray));
	}

	default T field(String name, Class<?> clazz, boolean isarray) {
		return field(name, TypeUtils.generic(clazz, isarray));
	}

	default T field(int access, String name, String clazz) {
		return field(access, name, TypeUtils.generic(clazz));
	}

	default T field(int access, String name, Class<?> clazz) {
		return field(access, name, TypeUtils.generic(clazz));
	}

	T field(int access, String name, Clazz clazz);

	T field(int access, Annotation annotation, String name, Clazz clazz);
}