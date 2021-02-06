package nebula.tinyasm;

import java.util.List;

import static org.objectweb.asm.Opcodes.*;

public interface WithDefineField<T> {

	default T field(List<Field> fields) {
		T t = null;
		for (Field field : fields) {
			t = field(field.name, GenericClazz.generic(field.clazz));
		}
		return t;
	}

	default T field(String name, String clazz) {
		return field(name, GenericClazz.generic(clazz));
	}

	default T field(String name, Class<?> clazz) {
		return field(name, GenericClazz.generic(clazz));
	}

	default T field(String name, GenericClazz clazz) {
		return field(ACC_PRIVATE, name, GenericClazz.generic(clazz));
	}

	default T field(Class<?> annotation, String name, String clazz) {
		return field(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T field(Class<?> annotation, String name, Class<?> clazz) {
		return field(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T field(Class<?> annotation, String name, GenericClazz clazz) {
		return field(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T field(Annotation annotation, String name, String clazz) {
		return field(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T field(Annotation annotation, String name, Class<?> clazz) {
		return field(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T field(Annotation annotation, String name, GenericClazz clazz) {
		return field(ACC_PRIVATE, annotation, name, clazz);
	}

	default T field(String name, String clazz, boolean isarray) {
		return field(name, GenericClazz.generic(clazz, isarray));
	}

	default T field(String name, Class<?> clazz, boolean isarray) {
		return field(name, GenericClazz.generic(clazz, isarray));
	}

	default T field(Class<?> annotation, String name, String clazz, boolean isarray) {
		return field(Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}

	default T field(Class<?> annotation, String name, Class<?> clazz, boolean isarray) {
		return field(Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}

	default T field(Annotation annotation, String name, String clazz, boolean isarray) {
		return field(Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}

	default T field(Annotation annotation, String name, Class<?> clazz, boolean isarray) {
		return field(Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}

	default T field(int access, String name, String clazz) {
		return field(access, name, GenericClazz.generic(clazz));
	}

	default T field(int access, String name, Class<?> clazz) {
		return field(access, name, GenericClazz.generic(clazz));
	}

	T field(int access, String name, GenericClazz clazz);

	default T field(int access, Class<?> annotation, String name, String clazz) {
		return field(access, Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T field(int access, Class<?> annotation, String name, Class<?> clazz) {
		return field(access, Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T field(int access, Class<?> annotation, String name, GenericClazz clazz) {
		return field(access, Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T field(int access, Annotation annotation, String name, String clazz) {
		return field(access, Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T field(int access, Annotation annotation, String name, Class<?> clazz) {
		return field(access, Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	T field(int access, Annotation annotation, String name, GenericClazz clazz);

	default T field(int access, String name, String clazz, boolean isarray) {
		return field(access, name, GenericClazz.generic(clazz, isarray));
	}

	default T field(int access, String name, Class<?> clazz, boolean isarray) {
		return field(access, name, GenericClazz.generic(clazz, isarray));
	}

	default T field(int access, Class<?> annotation, String name, String clazz, boolean isarray) {
		return field(access, Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}

	default T field(int access, Class<?> annotation, String name, Class<?> clazz, boolean isarray) {
		return field(access, Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}

	default T field(int access, Annotation annotation, String name, String clazz, boolean isarray) {
		return field(access, Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}

	default T field(int access, Annotation annotation, String name, Class<?> clazz, boolean isarray) {
		return field(access, Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}
}