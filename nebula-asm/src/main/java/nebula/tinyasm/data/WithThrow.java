package nebula.tinyasm.data;

public interface WithThrow<T> {

	default MethodHeader tHrow(Class<?> clazz) {
		return tHrow(GenericClazz.clazz(clazz));
	}

	default MethodHeader tHrow(Class<?>... clazzes) {
		MethodHeader mh = null;
		for (Class<?> clazz : clazzes) {
			mh = tHrow(GenericClazz.clazz(clazz));
		}
		return mh;
	}

	default MethodHeader tHrow(String... clazzes) {
		MethodHeader mh = null;
		for (String clazz : clazzes) {
			mh = tHrow(GenericClazz.clazz(clazz));
		}
		return mh;
	}

	MethodHeader tHrow(GenericClazz clazz);

	default MethodHeader tHrow(String clazz) {
		return tHrow(GenericClazz.clazz(clazz));
	}
}