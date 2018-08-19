package nebula.tinyasm.data;

import java.util.List;

public interface WithDefineParameter<T> {

	default T parameter(List<Field> fields) {
		T t = null;
		for (Field field : fields) {
			t = parameter(field.name, GenericClazz.generic(field.clazz));
		}
		return t;
	}

	default T parameter(String name, String clazz) {
		return parameter(name, GenericClazz.generic(clazz));
	}

	default T parameter(String name, Class<?> clazz) {
		return parameter(name, GenericClazz.generic(clazz));
	}

	T parameter(String name, GenericClazz clazz);

	default T parameter(Class<?> annotation, String name, String clazz) {
		return parameter(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T parameter(Class<?> annotation, String name, Class<?> clazz) {
		return parameter(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T parameter(Class<?> annotation, String name, GenericClazz clazz) {
		return parameter(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T parameter(Annotation annotation, String name, String clazz) {
		return parameter(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T parameter(Annotation annotation, String name, Class<?> clazz) {
		return parameter(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	T parameter(Annotation annotation, String name, GenericClazz clazz);
}