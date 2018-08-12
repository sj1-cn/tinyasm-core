package nebula.tinyasm;

import java.util.function.Consumer;

import nebula.tinyasm.api.InvokeMethod;
import nebula.tinyasm.api.MethodCode;
import nebula.tinyasm.api.ToType;

public interface MethodCaller<M, C extends MethodCode<M, C>> extends InvokeMethod<M, C>, ToType {
	M addParam(String varName);

	M with(Consumer<C> invocation);
}
