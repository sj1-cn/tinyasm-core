package nebula.tinyasm;

public interface WithThrow<T> {

	default MethodHeader tHrow(Class<?> clazz) {
		return tHrow(GenericClazz.generic(clazz));
	}

	default MethodHeader tHrow(Class<?>... clazzes) {
		MethodHeader mh = null;
		for (Class<?> clazz : clazzes) {
			mh = tHrow(GenericClazz.generic(clazz));
		}
		return mh;
	}

	default MethodHeader tHrow(String... clazzes) {
		MethodHeader mh = null;
		for (String clazz : clazzes) {
			mh = tHrow(GenericClazz.generic(clazz));
		}
		return mh;
	}

	MethodHeader tHrow(GenericClazz clazz);

	default MethodHeader tHrow(String clazz) {
		return tHrow(GenericClazz.generic(clazz));
	}
}