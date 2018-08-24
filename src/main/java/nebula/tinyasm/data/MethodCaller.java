package nebula.tinyasm.data;

public interface MethodCaller<T> {

	default MethodCaller<T> parameter(Class<?> clazz) {
		return parameter(GenericClazz.generic(clazz));
	}

	default MethodCaller<T> parameter(Class<?> clazz, boolean isarray) {
		return parameter(GenericClazz.generic(clazz, isarray));
	}

	MethodCaller<T> parameter(GenericClazz clazz);

	default MethodCaller<T> parameter(GenericClazz... clazzes) {
		MethodCaller<T> mh = null;
		for (GenericClazz clazz : clazzes) {
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
		return parameter(GenericClazz.generic(clazz));
	}

	default MethodCaller<T> parameter(String... clazz) {
		MethodCaller<T> mh = null;
		for (String string : clazz) {
			mh = parameter(GenericClazz.generic(string));
		}
		return mh;
	}

	default MethodCaller<T> parameter(String clazz, boolean isarray) {
		return parameter(GenericClazz.generic(clazz, isarray));
	}

	default MethodCaller<T> reTurn(Class<?> clazz) {
		return reTurn(GenericClazz.generic(clazz));
	}

	default MethodCaller<T> reTurn(Class<?> clazz, boolean isarray) {
		return reTurn(GenericClazz.generic(clazz, isarray));
	}

	MethodCaller<T> reTurn(GenericClazz clazz);

	default MethodCaller<T> reTurn(String clazz) {
		return reTurn(GenericClazz.generic(clazz));
	}

	default MethodCaller<T> reTurn(String clazz, boolean isarray) {
		return reTurn(GenericClazz.generic(clazz, isarray));
	}

	void INVOKE();

	default MethodCaller<T> LAMBDA(Class<?> objectType, String methodName) {
		return LAMBDA(objectType.getName(), methodName);
	}

	MethodCaller<T> LAMBDA(String objectType, String methodName);
}