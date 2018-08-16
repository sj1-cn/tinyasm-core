package nebula.tinyasm;

import java.util.List;

import nebula.tinyasm.data.ClassAnnotation;
import nebula.tinyasm.data.Field;

interface WithDefineParameter<T> {

	default T parameter(List<Field> fields) {
		T t = null;
		for (Field field : fields) {
			t = parameter(field.name, GenericClazz.clazz(field.clazz));
		}
		return t;
	}

	default T parameter(String name, String clazz) {
		return parameter(name, GenericClazz.clazz(clazz));
	}

	default T parameter(String name, Class<?> clazz) {
		return parameter(name, GenericClazz.clazz(clazz));
	}

	T parameter(String name, GenericClazz clazz);

	default T parameter(Class<?> annotation, String name, String clazz) {
		return parameter(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T parameter(Class<?> annotation, String name, Class<?> clazz) {
		return parameter(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T parameter(Class<?> annotation, String name, GenericClazz clazz) {
		return parameter(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T parameter(ClassAnnotation annotation, String name, String clazz) {
		return parameter(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T parameter(ClassAnnotation annotation, String name, Class<?> clazz) {
		return parameter(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	T parameter(ClassAnnotation annotation, String name, GenericClazz clazz);
}