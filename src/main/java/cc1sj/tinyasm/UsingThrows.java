package cc1sj.tinyasm;

public interface UsingThrows<T> {

	default MethodHeader throws_(Class<?> clazz) {
		return throws_(Clazz.of(clazz));
	}

	default MethodHeader throws_(Class<?>... clazzes) {
		MethodHeader mh = null;
		for (Class<?> clazz : clazzes) {
			mh = throws_(Clazz.of(clazz));
		}
		return mh;
	}

	default MethodHeader throws_(String... clazzes) {
		MethodHeader mh = null;
		for (String clazz : clazzes) {
			String[] genericParameterClazz = {};
			mh = throws_(Clazz.of(clazz, genericParameterClazz));
		}
		return mh;
	}

	MethodHeader throws_(Clazz clazz);

	default MethodHeader throws_(String clazz) {
		String[] genericParameterClazz = {};
		return throws_(Clazz.of(clazz, genericParameterClazz));
	}
}