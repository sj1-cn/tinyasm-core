package nebula.tinyasm;

public interface WithAnnotation<B> {

	default B annotation(Class<?> clazz) {
		return annotation(clazz.getName(), null);
	}

	default B annotation(String clazz) {
		return annotation(clazz, null);
	}

	default B annotation(Class<?> clazz, Object value) {
		return annotation(clazz.getName(), value);
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
		return annotation(annotationClass.getName(), names, values);
	}

	default B annotation(Class<?> annotationClass, String name, Object value) {
		return annotation(annotationClass.getName(), new String[] { name }, new Object[] { value });
	}

	default B annotation(String annotationClass, String name, Object value) {
		return annotation(annotationClass, new String[] { name }, new Object[] { value });
	}

	default B annotation(Class<?> annotationClass, Object value, String[] names, Object[] values) {
		return annotation(annotationClass.getName(), value, names, values);
	}

}