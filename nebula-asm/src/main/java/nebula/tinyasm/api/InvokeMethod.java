package nebula.tinyasm.api;

public interface InvokeMethod<M, C extends MethodCode<M, C>> extends ToType {
	C code();
}
