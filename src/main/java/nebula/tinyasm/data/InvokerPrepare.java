package nebula.tinyasm.data;

import java.util.function.Consumer;

public interface InvokerPrepare {
	InvokerPrepare parameter(GenericClazz clazz);

	default InvokerPrepare parameter(Class<?> clazz) {
		return parameter(GenericClazz.generic(clazz));
	}

	default InvokerPrepare parameter(String clazz) {
		return parameter(GenericClazz.generic(clazz));
	}

	void invokeVoid(Consumer<MethodCode>[] invocations);

	Invoker returnObject(GenericClazz returnClazz);

	default Invoker returnObject(Class<?> returnClazz) {
		return returnObject(GenericClazz.generic(returnClazz));
	}

	default Invoker returnObject(String returnClazz) {
		return returnObject(GenericClazz.generic(returnClazz));
	}
}