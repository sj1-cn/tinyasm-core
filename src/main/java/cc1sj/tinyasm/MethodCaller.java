package cc1sj.tinyasm;

public interface MethodCaller<T> {

	default MethodCaller<T> parameter(Class<?> clazz) {
		return parameter(Clazz.of(clazz));
	}

	default MethodCaller<T> parameter(Class<?> clazz, boolean isarray) {
		return parameter(Clazz.of(clazz, isarray));
	}

	MethodCaller<T> parameter(Clazz clazz);

	default MethodCaller<T> parameter(Clazz... clazzes) {
		MethodCaller<T> mh = null;
		for (Clazz clazz : clazzes) {
			mh = parameter(clazz);
		}
		return mh;
	}

	default MethodCaller<T> parameter(Class<?>... clazzes) {
		MethodCaller<T> mh = null;
		for (Class<?> clazz : clazzes) {
			mh = parameter(clazz);
		}
		return mh;
	}

	default MethodCaller<T> parameter(String clazz) {
		String[] genericParameterClazz = {};
		return parameter(Clazz.of(clazz, genericParameterClazz));
	}

	default MethodCaller<T> parameter(String... clazz) {
		MethodCaller<T> mh = null;
		for (String string : clazz) {
			String[] genericParameterClazz = {};
			mh = parameter(Clazz.of(string, genericParameterClazz));
		}
		return mh;
	}

	default MethodCaller<T> parameter(String clazz, boolean isarray) {
		return parameter(Clazz.of(clazz, isarray));
	}

	default MethodCaller<T> reTurn(Class<?> clazz) {
		return reTurn(Clazz.of(clazz));
	}

	default MethodCaller<T> reTurn(Class<?> clazz, boolean isarray) {
		return reTurn(Clazz.of(clazz, isarray));
	}

	MethodCaller<T> reTurn(Clazz clazz);

	default MethodCaller<T> reTurn(String clazz) {
		String[] genericParameterClazz = {};
		return reTurn(Clazz.of(clazz, genericParameterClazz));
	}

	default MethodCaller<T> reTurn(String clazz, boolean isarray) {
		return reTurn(Clazz.of(clazz, isarray));
	}

	void INVOKE();

	default MethodCaller<T> LAMBDA(Class<?> objectType, String methodName) {
		return LAMBDA(objectType.getName(), methodName);
	}

	MethodCaller<T> LAMBDA(String objectType, String methodName);
}