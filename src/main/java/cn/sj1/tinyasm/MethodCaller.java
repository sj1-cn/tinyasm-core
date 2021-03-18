package cn.sj1.tinyasm;

public interface MethodCaller<T> {

	default MethodCaller<T> parameter(Class<?> clazz) {
		return parameter(Clazz.of(clazz));
	}

	default MethodCaller<T> parameter(Class<?> clazz, boolean isarray) {
		return parameter(Clazz.of(clazz, isarray));
	}

	MethodCaller<T> parameter(Clazz clazz);

	default MethodCaller<T> parameter(Clazz... clazzes) {
		for (Clazz clazz : clazzes) {
			parameter(clazz);
		}
		return this;
	}

	default MethodCaller<T> parameter(Class<?>... clazzes) {
		for (Class<?> clazz : clazzes) {
			parameter(clazz);
		}
		return this;
	}

	default MethodCaller<T> parameter(String clazz) {
		String[] genericParameterClazz = {};
		return parameter(Clazz.of(clazz, genericParameterClazz));
	}

	default MethodCaller<T> parameter(String... clazz) {
		for (String string : clazz) {
			String[] genericParameterClazz = {};
			parameter(Clazz.of(string, genericParameterClazz));
		}
		return this;
	}

	default MethodCaller<T> parameter(String clazz, boolean isarray) {
		return parameter(Clazz.of(clazz, isarray));
	}

	default MethodCaller<T> return_(Class<?> clazz) {
		return return_(Clazz.of(clazz));
	}

	default MethodCaller<T> return_(Class<?> clazz, boolean isarray) {
		return return_(Clazz.of(clazz, isarray));
	}

	MethodCaller<T> return_(Clazz clazz);

	default MethodCaller<T> return_(String clazz) {
		String[] genericParameterClazz = {};
		return return_(Clazz.of(clazz, genericParameterClazz));
	}

	void INVOKE();

	default MethodCaller<T> LAMBDA(Class<?> objectType, String methodName) {
		return LAMBDA(objectType.getName(), methodName);
	}

	MethodCaller<T> LAMBDA(String objectType, String methodName);
}