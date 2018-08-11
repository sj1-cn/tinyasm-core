package nebula.tinyasm.api;

public interface MethodCallerInInstanceMethod extends MethodCaller<MethodCallerInInstanceMethod, InstanceMethodCode> {
	default public Instance<MethodCallerInInstanceMethod, InstanceMethodCode> get(String fieldName) {
		return get(code().fieldOfThis(fieldName));
	}

	default public InstanceMethodCode putTo(String fieldName) {
		return putTo(code().fieldOfThis(fieldName));
	}
}
