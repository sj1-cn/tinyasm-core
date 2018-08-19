package nebula.tinyasm.data;

public interface WithInvoke<T> {

	default MethodCaller<T> STATIC(Class<?> objectType, String methodName) {
		return STATIC(objectType.getName(), methodName);
	}

	MethodCaller<T> STATIC(String objectType, String methodName);

	default MethodCaller<T> INTERFACE(Class<?> objectType, String methodName) {
		return INTERFACE(objectType.getName(), methodName);
	}

	MethodCaller<T> INTERFACE(String objectType, String methodName);

	default MethodCaller<T> SPECIAL(Class<?> objectType, String methodName) {
		return SPECIAL(objectType.getName(), methodName);
	}

	MethodCaller<T> SPECIAL(String objectType, String methodName);

	default MethodCaller<T> VIRTUAL(Class<?> objectType, String methodName) {
		return VIRTUAL(objectType.getName(), methodName);
	}

	MethodCaller<T> VIRTUAL(String objectType, String methodName);


}
