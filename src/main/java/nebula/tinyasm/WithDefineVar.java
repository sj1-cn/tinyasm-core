package nebula.tinyasm;

import java.util.List;

import nebula.tinyasm.util.GenericClazz;
import nebula.tinyasm.util.TypeUtils;

public interface WithDefineVar {

	default void define(List<Field> fields) {
		for (Field field : fields) {
			define(field.name, TypeUtils.generic(field.clazz));
		}
	}

	default void define(String name, String clazz) {
		define(name, TypeUtils.generic(clazz));
	}
	

	default void define(String name, Class<?> clazz) {
		define(name, TypeUtils.generic(clazz));
	}

	void define(String name, GenericClazz clazz);

	default void define(Class<?> annotation, String name, String clazz) {
		define(Annotation.annotation(annotation), name, TypeUtils.generic(clazz));
	}

	default void define(Class<?> annotation, String name, Class<?> clazz) {
		define(Annotation.annotation(annotation), name, TypeUtils.generic(clazz));
	}

	default void define(Class<?> annotation, String name, GenericClazz clazz) {
		define(Annotation.annotation(annotation), name, TypeUtils.generic(clazz));
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

	default void define(Class<?> annotation, String name, GenericClazz clazz, boolean isarray) {
		define(Annotation.annotation(annotation), name, TypeUtils.generic(clazz));
	}

	default void define(Annotation annotation, String name, String clazz, boolean isarray) {
		define(Annotation.annotation(annotation), name, TypeUtils.generic(clazz, isarray));
	}

	default void define(Annotation annotation, String name, Class<?> clazz, boolean isarray) {
		define(Annotation.annotation(annotation), name, TypeUtils.generic(clazz, isarray));
	}

	void define(Annotation annotation, String name, GenericClazz clazz);
}