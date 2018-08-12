package nebula.tinyasm.api;

@Deprecated
public interface ClassThisInstance extends Instance<MethodCallerInInstanceMethod, InstanceMethodCode> {
	Field fieldOf(String fieldName);
}
