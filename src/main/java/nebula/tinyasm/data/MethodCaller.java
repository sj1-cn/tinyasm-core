package nebula.tinyasm.data;

public interface MethodCaller<T> {

	default MethodCaller<T> param(Class<?> clazz) {
		return param(GenericClazz.clazz(clazz));
	}

	default MethodCaller<T> param(Class<?> clazz, boolean isarray) {
		return param(GenericClazz.clazz(clazz, isarray));
	}

	MethodCaller<T> param(GenericClazz clazz);

	default MethodCaller<T> param(GenericClazz... clazzes) {
		MethodCaller<T> mh = null;
		for (GenericClazz clazz : clazzes) {
			mh = param(clazz);
		}
		return mh;
	}

	default MethodCaller<T> param(String clazz) {
		return param(GenericClazz.generic(clazz));
	}

	default MethodCaller<T> param(String... clazz) {
		MethodCaller<T> mh = null;
		for (String string : clazz) {
			mh = param(GenericClazz.generic(string));
		}
		return mh;
	}

	default MethodCaller<T> param(String clazz, boolean isarray) {
		return param(GenericClazz.clazz(clazz, isarray));
	}

	default MethodCaller<T> reTurn(Class<?> clazz) {
		return reTurn(GenericClazz.clazz(clazz));
	}

	default MethodCaller<T> reTurn(Class<?> clazz, boolean isarray) {
		return reTurn(GenericClazz.clazz(clazz, isarray));
	}

	MethodCaller<T> reTurn(GenericClazz clazz);

	default MethodCaller<T> reTurn(String clazz) {
		return reTurn(GenericClazz.generic(clazz));
	}

	default MethodCaller<T> reTurn(String clazz, boolean isarray) {
		return reTurn(GenericClazz.clazz(clazz, isarray));
	}

	void INVOKE();

	default MethodCaller<T> LAMBDA(Class<?> objectType, String methodName) {
		return LAMBDA(objectType.getName(), methodName);
	}

	MethodCaller<T> LAMBDA(String objectType, String methodName);
}