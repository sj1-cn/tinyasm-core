package nebula.tinyasm.api;

import java.util.function.Consumer;

public interface MethodCaller<M, C extends MethodCode<M, C>> extends InvokeMethod<M, C>, ToType {
	M addParam(String varName);
	
	void returnValue();

	M with(Consumer<C> invocation);
}
