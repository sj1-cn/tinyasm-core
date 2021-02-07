package nebula.tinyasm;

import java.util.function.Consumer;

public interface InvokerPrepare {
	InvokerPrepare parameter(Clazz clazz);

	default InvokerPrepare parameter(Class<?> clazz,boolean array) {
		return parameter(TypeUtils.generic(clazz,array));
	}
	default InvokerPrepare parameter(Class<?> clazz) {
		return parameter(TypeUtils.generic(clazz));
	}

	default InvokerPrepare parameter(String clazz) {
		return parameter(TypeUtils.generic(clazz));
	}

	@SuppressWarnings("unchecked")
	default void invokeVoid(Consumer<MethodCode> p0) {
		invokeVoid(new Consumer[] { p0 });
	}

	@SuppressWarnings("unchecked")
	default void invokeVoid(Consumer<MethodCode> p0, Consumer<MethodCode> p1) {
		invokeVoid(new Consumer[] { p0, p1, });
	}

	@SuppressWarnings("unchecked")
	default void invokeVoid(Consumer<MethodCode> p0, Consumer<MethodCode> p1, Consumer<MethodCode> p2) {
		invokeVoid(new Consumer[] { p0, p1, p2 });
	}

	@SuppressWarnings("unchecked")
	default void invokeVoid(Consumer<MethodCode> p0, Consumer<MethodCode> p1, Consumer<MethodCode> p2, Consumer<MethodCode> p3) {
		invokeVoid(new Consumer[] { p0, p1, p2, p3 });
	}

	@SuppressWarnings("unchecked")
	default void invokeVoid(Consumer<MethodCode> p0, Consumer<MethodCode> p1, Consumer<MethodCode> p2, Consumer<MethodCode> p3,
			Consumer<MethodCode> p4) {
		invokeVoid(new Consumer[] { p0, p1, p2, p3, p4 });
	}

	void invokeVoid(Consumer<MethodCode>[] invocations);

	void invokeVoid(String... varname);

	Invoker returnObject(Clazz returnClazz);

	default Invoker reTurn(Class<?> returnClazz) {
		return returnObject(TypeUtils.generic(returnClazz));
	}

	default Invoker reTurn(String returnClazz) {
		return returnObject(TypeUtils.generic(returnClazz));
	}

}