package nebula.tinyasm;

import java.util.List;

public interface WithDefineVar {

	default void define(List<Field> fields) {
		for (Field field : fields) {
			define(field.name, GenericClazz.generic(field.clazz));
		}
	}

	default void define(String name, String clazz) {
		define(name, GenericClazz.generic(clazz));
	}
	

	default void define(String name, Class<?> clazz) {
		define(name, GenericClazz.generic(clazz));
	}

	void define(String name, GenericClazz clazz);

	default void define(Class<?> annotation, String name, String clazz) {
		define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default void define(Class<?> annotation, String name, Class<?> clazz) {
		define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default void define(Class<?> annotation, String name, GenericClazz clazz) {
		define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default void define(Annotation annotation, String name, String clazz) {
		define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default void define(Annotation annotation, String name, Class<?> clazz) {
		define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default void define(String name, String clazz, boolean isarray) {
		define(name, GenericClazz.generic(clazz, isarray));
	}

	default void define(String name, Class<?> clazz, boolean isarray) {
		define(name, GenericClazz.generic(clazz, isarray));
	}

	default void define(Class<?> annotation, String name, String clazz, boolean isarray) {
		define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}

	default void define(Class<?> annotation, String name, Class<?> clazz, boolean isarray) {
		define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}

	default void define(Class<?> annotation, String name, GenericClazz clazz, boolean isarray) {
		define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default void define(Annotation annotation, String name, String clazz, boolean isarray) {
		define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}

	default void define(Annotation annotation, String name, Class<?> clazz, boolean isarray) {
		define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}

	void define(Annotation annotation, String name, GenericClazz clazz);
}