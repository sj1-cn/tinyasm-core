package cn.sj1.tinyasm.core;

public interface MethodCallerAfterDynamic {

	default MethodCallerAfterDynamic parameter(Class<?> clazz) {
		return parameter(Clazz.of(clazz));
	}

	default MethodCallerAfterDynamic parameter(Class<?> clazz, boolean isarray) {
		return parameter(Clazz.of(clazz, isarray));
	}

	MethodCallerAfterDynamic parameter(Clazz clazz);

	default MethodCallerAfterDynamic parameter(Clazz... clazzes) {
		for (Clazz clazz : clazzes) {
			parameter(clazz);
		}
		return this;
	}

	default MethodCallerAfterDynamic parameter(Class<?>... clazzes) {
		for (Class<?> clazz : clazzes) {
			parameter(clazz);
		}
		return this;
	}

	default MethodCallerAfterDynamic parameter(String clazz) {
		String[] genericParameterClazz = {};
		return parameter(Clazz.of(clazz, genericParameterClazz));
	}

	default MethodCallerAfterDynamic parameter(String... clazz) {
		for (String string : clazz) {
			String[] genericParameterClazz = {};
			parameter(Clazz.of(string, genericParameterClazz));
		}
		return this;
	}

	default MethodCallerAfterDynamic parameter(String clazz, boolean isarray) {
		return parameter(Clazz.of(clazz, isarray));
	}

	default MethodCallerAfterDynamic return_(Class<?> clazz) {
		return return_(Clazz.of(clazz));
	}

	default MethodCallerAfterDynamic return_(Class<?> clazz, boolean isarray) {
		return return_(Clazz.of(clazz, isarray));
	}

	MethodCallerAfterDynamic return_(Clazz clazz);

	default MethodCallerAfterDynamic return_(String clazz) {
		String[] genericParameterClazz = {};
		return return_(Clazz.of(clazz, genericParameterClazz));
	}
	
	MethodCallerAfterDynamic withThis();

	//	void INVOKE();

	default LamdaMethodCaller LAMBDA(Class<?> objectType, String methodName) {
		return LAMBDA(objectType.getName(), methodName);
	}

	LamdaMethodCaller LAMBDA(String objectType, String methodName);
}
