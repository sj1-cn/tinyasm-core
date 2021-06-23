package cn.sj1.tinyasm.core;

public interface WithInvoke {

	default MethodCaller STATIC(Class<?> objectType, String methodName) {
		return STATIC(objectType.getName(), methodName);
	}

	default MethodCaller STATIC(String objectType, String methodName) {
		return STATIC(Clazz.of(objectType), methodName);
	}

	MethodCaller STATIC(Clazz objectType, String methodName);

	default MethodCaller INTERFACE(Class<?> objectType, String methodName) {
		return INTERFACE(Clazz.of(objectType), methodName);
	}

	default MethodCaller INTERFACE(String objectType, String methodName) {
		return INTERFACE(Clazz.of(objectType), methodName);
	}

	MethodCaller INTERFACE(Clazz objectType, String methodName);

	default MethodCaller SPECIAL(Class<?> objectType, String methodName) {
		return SPECIAL(Clazz.of(objectType), methodName);
	}

	default MethodCaller SPECIAL(String objectType, String methodName) {
		return SPECIAL(Clazz.of(objectType), methodName);
	}

	MethodCaller SPECIAL(Clazz objectType, String methodName);

	default MethodCaller VIRTUAL(Class<?> objectType, String methodName) {
		return VIRTUAL(Clazz.of(objectType), methodName);
	}

	default MethodCaller VIRTUAL(String objectType, String methodName) {
		return VIRTUAL(Clazz.of(objectType), methodName);
	}

	MethodCaller VIRTUAL(Clazz objectType, String methodName);

	MethodCaller VIRTUAL(String methodName);

}
