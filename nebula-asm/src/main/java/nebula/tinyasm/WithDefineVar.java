package nebula.tinyasm;

import java.util.List;

import nebula.tinyasm.data.ClassAnnotation;
import nebula.tinyasm.data.Field;

interface WithDefineVar<T> {

	default T define(List<Field> fields) {
		T t = null;
		for (Field field : fields) {
			t = define(field.name, GenericClazz.clazz(field.clazz));
		}
		return t;
	}

	default T define(String name, String clazz) {
		return define(name, GenericClazz.clazz(clazz));
	}

	default T define(String name, Class<?> clazz) {
		return define(name, GenericClazz.clazz(clazz));
	}

	T define(String name, GenericClazz clazz);

	default T define(Class<?> annotation, String name, String clazz) {
		return define(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T define(Class<?> annotation, String name, Class<?> clazz) {
		return define(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T define(Class<?> annotation, String name, GenericClazz clazz) {
		return define(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T define(ClassAnnotation annotation, String name, String clazz) {
		return define(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T define(ClassAnnotation annotation, String name, Class<?> clazz) {
		return define(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T define(String name, String clazz, boolean isarray) {
		return define(name, GenericClazz.clazz(clazz, isarray));
	}

	default T define(String name, Class<?> clazz, boolean isarray) {
		return define(name, GenericClazz.clazz(clazz, isarray));
	}

	default T define(Class<?> annotation, String name, String clazz, boolean isarray) {
		return define(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T define(Class<?> annotation, String name, Class<?> clazz, boolean isarray) {
		return define(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T define(Class<?> annotation, String name, GenericClazz clazz, boolean isarray) {
		return define(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T define(ClassAnnotation annotation, String name, String clazz, boolean isarray) {
		return define(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T define(ClassAnnotation annotation, String name, Class<?> clazz, boolean isarray) {
		return define(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	T define(ClassAnnotation annotation, String name, GenericClazz clazz);
}