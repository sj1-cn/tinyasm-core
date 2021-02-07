package nebula.tinyasm;

public interface MethodCaller<T> {

	default MethodCaller<T> parameter(Class<?> clazz) {
		return parameter(TypeUtils.generic(clazz));
	}

	default MethodCaller<T> parameter(Class<?> clazz, boolean isarray) {
		return parameter(TypeUtils.generic(clazz, isarray));
	}

	MethodCaller<T> parameter(Clazz clazz);

	default MethodCaller<T> parameter(Clazz... clazzes) {
		MethodCaller<T> mh = null;
		for (Clazz clazz : clazzes) {
			mh = parameter(clazz);
		}
		return mh;
	}default MethodCaller<T> parameter(Class<?>... clazzes) {
		MethodCaller<T> mh = null;
		for (Class<?> clazz : clazzes) {
			mh = parameter(clazz);
		}
		return mh;
	}

	default MethodCaller<T> parameter(String clazz) {
		return parameter(TypeUtils.generic(clazz));
	}

	default MethodCaller<T> parameter(String... clazz) {
		MethodCaller<T> mh = null;
		for (String string : clazz) {
			mh = parameter(TypeUtils.generic(string));
		}
		return mh;
	}

	default MethodCaller<T> parameter(String clazz, boolean isarray) {
		return parameter(TypeUtils.generic(clazz, isarray));
	}

	default MethodCaller<T> reTurn(Class<?> clazz) {
		return reTurn(TypeUtils.generic(clazz));
	}

	default MethodCaller<T> reTurn(Class<?> clazz, boolean isarray) {
		return reTurn(TypeUtils.generic(clazz, isarray));
	}

	MethodCaller<T> reTurn(Clazz clazz);

	default MethodCaller<T> reTurn(String clazz) {
		return reTurn(TypeUtils.generic(clazz));
	}

	default MethodCaller<T> reTurn(String clazz, boolean isarray) {
		return reTurn(TypeUtils.generic(clazz, isarray));
	}

	void INVOKE();

	default MethodCaller<T> LAMBDA(Class<?> objectType, String methodName) {
		return LAMBDA(objectType.getName(), methodName);
	}

	MethodCaller<T> LAMBDA(String objectType, String methodName);
}