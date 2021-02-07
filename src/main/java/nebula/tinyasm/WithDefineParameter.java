package nebula.tinyasm;

import java.util.List;

public interface WithDefineParameter<T> {

	default T parameter(List<Field> fields) {
		T t = null;
		for (Field field : fields) {
			t = parameter(0, field.name, TypeUtils.generic(field.clazz));
		}
		return t;
	}

	default T parameter(String name, String clazz) {
		return parameter(0, name, TypeUtils.generic(clazz));
	}

	default T parameter(String name, String clazz,boolean array) {
		return parameter(0, name, TypeUtils.generic(clazz,array));
	}

	default T parameter(String name, Class<?> clazz,boolean array) {
		return parameter(0, name, TypeUtils.generic(clazz,array));
	}

	default T parameter(String name, Class<?> clazz) {
		return parameter(0, name, TypeUtils.generic(clazz));
	}

	default T parameter(int access, String name, String clazz) {
		return parameter(access, name, TypeUtils.generic(clazz));
	}

	default T parameter(int access, String name, Class<?> clazz) {
		return parameter(access, name, TypeUtils.generic(clazz));
	}

	default T parameter(String name, GenericClazz clazz) {
		return parameter(0, name, clazz);
	}

	T parameter(int access, String name, GenericClazz clazz);

	default T parameter(Class<?> annotation, String name, String clazz) {
		return parameter(Annotation.annotation(annotation), name, TypeUtils.generic(clazz));
	}

	default T parameter(Class<?> annotation, String name, Class<?> clazz) {
		return parameter(Annotation.annotation(annotation), name, TypeUtils.generic(clazz));
	}

	default T parameter(Class<?> annotation, String name, GenericClazz clazz) {
		return parameter(Annotation.annotation(annotation), name, TypeUtils.generic(clazz));
	}

	default T parameter(Annotation annotation, String name, String clazz) {
		return parameter(Annotation.annotation(annotation), name, TypeUtils.generic(clazz));
	}

	default T parameter(Annotation annotation, String name, Class<?> clazz) {
		return parameter(Annotation.annotation(annotation), name, TypeUtils.generic(clazz));
	}

	T parameter(Annotation annotation, String name, GenericClazz clazz);
}