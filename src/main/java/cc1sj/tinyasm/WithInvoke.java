package cc1sj.tinyasm;

public interface WithInvoke<T> {

	default MethodCaller<T> STATIC(Class<?> objectType, String methodName) {
		return STATIC(objectType.getName(), methodName);
	}
	default MethodCaller<T> STATIC(String objectType, String methodName) {
		return STATIC(Clazz.of(objectType), methodName);
	}

	MethodCaller<T> STATIC(Clazz objectType, String methodName);

	default MethodCaller<T> INTERFACE(Class<?> objectType, String methodName) {
		return INTERFACE(Clazz.of(objectType), methodName);
	}
	default MethodCaller<T> INTERFACE(String objectType, String methodName) {
		return INTERFACE(Clazz.of(objectType), methodName);
	}

	MethodCaller<T> INTERFACE(Clazz objectType, String methodName);

	default MethodCaller<T> SPECIAL(Class<?> objectType, String methodName) {
		return SPECIAL(Clazz.of(objectType), methodName);
	}
	
	default MethodCaller<T> SPECIAL(String objectType, String methodName) {
		return SPECIAL(Clazz.of(objectType), methodName);
	}

	MethodCaller<T> SPECIAL(Clazz objectType, String methodName);

	default MethodCaller<T> VIRTUAL(Class<?> objectType, String methodName) {
		return VIRTUAL(Clazz.of(objectType), methodName);
	}
	
	default MethodCaller<T> VIRTUAL(String objectType, String methodName) {
		return VIRTUAL(Clazz.of(objectType), methodName);
	}

	MethodCaller<T> VIRTUAL(Clazz objectType, String methodName);
	
	MethodCaller<T> VIRTUAL(String methodName);

}
