package nebula.tinyasm.api;

public interface InstanceMethodCode extends MethodInstanceMethodCode<MethodCallerInInstanceMethod, InstanceMethodCode> {

	@Deprecated
	Field fieldOfThis(String fieldName);

	@Deprecated
	InstanceMethodCode init();

	@Deprecated
	ClassThisInstance deperatedLoadThis();

	default InstanceMethodCode putTopTo(String fieldName) {
		return putTopTo(fieldOfThis(fieldName));
	};
}
