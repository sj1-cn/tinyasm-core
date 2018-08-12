package nebula.tinyasm.api;

import static nebula.tinyasm.api.TypeUtils.typeOf;

public interface Instance<M, C extends MethodCode<M, C>> extends InvokeMethod<M, C>, ToType {

	@Deprecated
	C code();

	@Deprecated
	M use();
}