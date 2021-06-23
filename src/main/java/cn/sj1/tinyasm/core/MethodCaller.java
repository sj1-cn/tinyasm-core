package cn.sj1.tinyasm.core;

public interface MethodCaller {

	default MethodCaller parameter(Class<?> clazz) {
		return parameter(Clazz.of(clazz));
	}

	default MethodCaller parameter(Class<?> clazz, boolean isarray) {
		return parameter(Clazz.of(clazz, isarray));
	}

	MethodCaller parameter(Clazz clazz);

	default MethodCaller parameter(Clazz... clazzes) {
		for (Clazz clazz : clazzes) {
			parameter(clazz);
		}
		return this;
	}

	default MethodCaller parameter(Class<?>... clazzes) {
		for (Class<?> clazz : clazzes) {
			parameter(clazz);
		}
		return this;
	}

	default MethodCaller parameter(String clazz) {
		String[] genericParameterClazz = {};
		return parameter(Clazz.of(clazz, genericParameterClazz));
	}

	default MethodCaller parameter(String... clazz) {
		for (String string : clazz) {
			String[] genericParameterClazz = {};
			parameter(Clazz.of(string, genericParameterClazz));
		}
		return this;
	}

	default MethodCaller parameter(String clazz, boolean isarray) {
		return parameter(Clazz.of(clazz, isarray));
	}

	default MethodCaller return_(Class<?> clazz) {
		return return_(Clazz.of(clazz));
	}

	default MethodCaller return_(Class<?> clazz, boolean isarray) {
		return return_(Clazz.of(clazz, isarray));
	}

	MethodCaller return_(Clazz clazz);

	default MethodCaller return_(String clazz) {
		String[] genericParameterClazz = {};
		return return_(Clazz.of(clazz, genericParameterClazz));
	}

	void INVOKE();

	default LamdaMethodCaller LAMBDA(Class<?> objectType, String methodName) {
		return LAMBDA(objectType.getName(), methodName);
	}

	LamdaMethodCaller LAMBDA(String objectType, String methodName);
}