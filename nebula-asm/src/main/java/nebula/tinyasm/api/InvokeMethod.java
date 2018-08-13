package nebula.tinyasm.api;

public interface InvokeMethod<C extends MethodCode<C>> extends ToType {
	C code();
}
