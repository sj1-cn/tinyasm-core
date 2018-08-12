package nebula.tinyasm.api;

public interface Instance<M, C extends MethodCode<M, C>> extends InvokeMethod<M, C>, ToType {

	@Deprecated
	C code();

}