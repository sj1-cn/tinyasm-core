package nebula.tinyasm.data;

import static nebula.tinyasm.util.TypeUtils.nameOf;

public interface WithAnnotation<B> {

	default B annotation(Class<?> clazz) {
		return annotation(nameOf(clazz), null);
	}

	default B annotation(String clazz) {
		return annotation(nameOf(clazz), null);
	}

	default B annotation(Class<?> clazz, Object value) {
		return annotation(nameOf(clazz), value);
	}

	default B annotation(String clazz, Object value) {
		return annotation(clazz, value, null, null);
	}

	default B annotation(String clazz, Object value, String[] names, Object[] values) {
		return annotation(Annotation.annotation(clazz, value, names, values));
	}

	B annotation(Annotation annotation);

	default B annotation(String clazz, String[] names, Object[] values) {
		return annotation(clazz, null, names, values);
	}

	default B annotation(Class<?> annotationClass, String[] names, Object[] values) {
		return annotation(nameOf(annotationClass), names, values);
	}

	default B annotation(Class<?> annotationClass, String name, Object value) {
		return annotation(nameOf(annotationClass), new String[] { name }, new Object[] { value });
	}

	default B annotation(String annotationClass, String name, Object value) {
		return annotation(nameOf(annotationClass), new String[] { name }, new Object[] { value });
	}

	default B annotation(Class<?> annotationClass, Object value, String[] names, Object[] values) {
		return annotation(nameOf(annotationClass), value, names, values);
	}

}