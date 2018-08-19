package nebula.tinyasm.data;

import java.util.List;

public interface WithDefineVar<T> {

	default T define(List<Field> fields) {
		T t = null;
		for (Field field : fields) {
			t = define(field.name, GenericClazz.generic(field.clazz));
		}
		return t;
	}

	default T define(String name, String clazz) {
		return define(name, GenericClazz.generic(clazz));
	}

	default T define(String name, Class<?> clazz) {
		return define(name, GenericClazz.generic(clazz));
	}

	T define(String name, GenericClazz clazz);

	default T define(Class<?> annotation, String name, String clazz) {
		return define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T define(Class<?> annotation, String name, Class<?> clazz) {
		return define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T define(Class<?> annotation, String name, GenericClazz clazz) {
		return define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T define(Annotation annotation, String name, String clazz) {
		return define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T define(Annotation annotation, String name, Class<?> clazz) {
		return define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T define(String name, String clazz, boolean isarray) {
		return define(name, GenericClazz.generic(clazz, isarray));
	}

	default T define(String name, Class<?> clazz, boolean isarray) {
		return define(name, GenericClazz.generic(clazz, isarray));
	}

	default T define(Class<?> annotation, String name, String clazz, boolean isarray) {
		return define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}

	default T define(Class<?> annotation, String name, Class<?> clazz, boolean isarray) {
		return define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}

	default T define(Class<?> annotation, String name, GenericClazz clazz, boolean isarray) {
		return define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T define(Annotation annotation, String name, String clazz, boolean isarray) {
		return define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}

	default T define(Annotation annotation, String name, Class<?> clazz, boolean isarray) {
		return define(Annotation.annotation(annotation), name, GenericClazz.generic(clazz, isarray));
	}

	T define(Annotation annotation, String name, GenericClazz clazz);
}