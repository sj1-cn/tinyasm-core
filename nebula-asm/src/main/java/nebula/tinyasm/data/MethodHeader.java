package nebula.tinyasm.data;

import java.util.function.Consumer;

public interface MethodHeader extends WithAccess<MethodHeader>, WithReturn<MethodHeader>, WithThrow<MethodHeader>,
		WithDefineParameter<MethodHeader>, WithAnnotation<MethodHeader> {
	MethodCode begin();

	void code(Consumer<MethodCode> invocation);

}