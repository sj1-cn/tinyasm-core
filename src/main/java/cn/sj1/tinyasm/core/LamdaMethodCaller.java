package cn.sj1.tinyasm.core;

public interface LamdaMethodCaller {

	default LamdaMethodCaller parameter(Class<?> clazz) {
		return parameter(Clazz.of(clazz));
	}

	default LamdaMethodCaller parameter(Class<?> clazz, boolean isarray) {
		return parameter(Clazz.of(clazz, isarray));
	}

	LamdaMethodCaller parameter(Clazz clazz);

	default LamdaMethodCaller parameter(Clazz... clazzes) {
		for (Clazz clazz : clazzes) {
			parameter(clazz);
		}
		return this;
	}

	default LamdaMethodCaller parameter(Class<?>... clazzes) {
		for (Class<?> clazz : clazzes) {
			parameter(clazz);
		}
		return this;
	}

	default LamdaMethodCaller parameter(String clazz) {
		String[] genericParameterClazz = {};
		return parameter(Clazz.of(clazz, genericParameterClazz));
	}

	default LamdaMethodCaller parameter(String... clazz) {
		for (String string : clazz) {
			String[] genericParameterClazz = {};
			parameter(Clazz.of(string, genericParameterClazz));
		}
		return this;
	}

	default LamdaMethodCaller parameter(String clazz, boolean isarray) {
		return parameter(Clazz.of(clazz, isarray));
	}

	default LamdaMethodCaller return_(Class<?> clazz) {
		return return_(Clazz.of(clazz));
	}

	default LamdaMethodCaller return_(Class<?> clazz, boolean isarray) {
		return return_(Clazz.of(clazz, isarray));
	}

	LamdaMethodCaller return_(Clazz clazz);

	default LamdaMethodCaller return_(String clazz) {
		String[] genericParameterClazz = {};
		return return_(Clazz.of(clazz, genericParameterClazz));
	}

	void INVOKE();
}
