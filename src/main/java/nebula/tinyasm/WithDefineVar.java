package nebula.tinyasm;

import java.util.List;

public interface WithDefineVar {

	default void define(List<Field> fields) {
		for (Field field : fields) {
			define(field.name, field.clazz);
		}
	}

	default void define(String name, String clazz) {
		define(name, TypeUtils.generic(clazz));
	}

	default void define(String name, Class<?> clazz) {
		define(name, TypeUtils.generic(clazz));
	}

	void define(String name, Clazz clazz);

	default void define(Class<?> annotation, String name, String clazz) {
		define(Annotation.annotation(annotation), name, TypeUtils.generic(clazz));
	}

	default void define(Class<?> annotation, String name, Class<?> clazz) {
		define(Annotation.annotation(annotation), name, TypeUtils.generic(clazz));
	}

	default void define(Class<?> annotation, String name, Clazz clazz) {
		define(Annotation.annotation(annotation), name, clazz);
	}

	default void define(Annotation annotation, String name, String clazz) {
		define(Annotation.annotation(annotation), name, TypeUtils.generic(clazz));
	}

	default void define(Annotation annotation, String name, Class<?> clazz) {
		define(Annotation.annotation(annotation), name, TypeUtils.generic(clazz));
	}

	default void define(String name, String clazz, boolean isarray) {
		define(name, TypeUtils.generic(clazz, isarray));
	}

	default void define(String name, Class<?> clazz, boolean isarray) {
		define(name, TypeUtils.generic(clazz, isarray));
	}

	default void define(Class<?> annotation, String name, String clazz, boolean isarray) {
		define(Annotation.annotation(annotation), name, TypeUtils.generic(clazz, isarray));
	}

	default void define(Class<?> annotation, String name, Class<?> clazz, boolean isarray) {
		define(Annotation.annotation(annotation), name, TypeUtils.generic(clazz, isarray));
	}

	default void define(Annotation annotation, String name, String clazz, boolean isarray) {
		define(Annotation.annotation(annotation), name, TypeUtils.generic(clazz, isarray));
	}

	default void define(Annotation annotation, String name, Class<?> clazz, boolean isarray) {
		define(Annotation.annotation(annotation), name, TypeUtils.generic(clazz, isarray));
	}

	void define(Annotation annotation, String name, Clazz clazz);
}