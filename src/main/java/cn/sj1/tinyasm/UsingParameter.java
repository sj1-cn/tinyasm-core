package cn.sj1.tinyasm;

import java.util.List;

public interface UsingParameter<T> {

	default T parameter(List<Field> fields) {
		T t = null;
		for (Field field : fields) {
			t = parameter(field.name, field.clazz);
		}
		return t;
	}

	default T parameter(String name, String clazz) {
		return parameter(name, Clazz.of(clazz));
	}

	default T parameter(String name, Class<?> clazz) {
		return parameter(name, Clazz.of(clazz));
	}

	default T parameter(String name, String clazz, boolean isarray) {
		return parameter(name, Clazz.of(clazz, isarray));
	}

	default T parameter(String name, Class<?> clazz, boolean isarray) {
		return parameter(name, Clazz.of(clazz, isarray));
	}
	
	default T parameter(String name, Clazz clazz) {
		return parameter(0, name, clazz);
	}

	default T parameter(int access, String name, Class<?> clazz) {
		return parameter(access, name, Clazz.of(clazz));
	}
	T parameter(int access, String name, Clazz clazz);

	default T parameter(Annotation annotation, String name, Clazz clazz) {
		return parameter(0, annotation, name, clazz);
	}

	T parameter(int access, Annotation annotation, String name, Clazz clazz);
}