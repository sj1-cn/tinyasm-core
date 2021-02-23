package cc1sj.tinyasm;

public interface WithThrow<T> {

	default MethodHeader tHrow(Class<?> clazz) {
		return tHrow(Clazz.of(clazz));
	}

	default MethodHeader tHrow(Class<?>... clazzes) {
		MethodHeader mh = null;
		for (Class<?> clazz : clazzes) {
			mh = tHrow(Clazz.of(clazz));
		}
		return mh;
	}

	default MethodHeader tHrow(String... clazzes) {
		MethodHeader mh = null;
		for (String clazz : clazzes) {
			String[] genericParameterClazz = {};
			mh = tHrow(Clazz.of(clazz, genericParameterClazz));
		}
		return mh;
	}

	MethodHeader tHrow(Clazz clazz);

	default MethodHeader tHrow(String clazz) {
		String[] genericParameterClazz = {};
		return tHrow(Clazz.of(clazz, genericParameterClazz));
	}
}