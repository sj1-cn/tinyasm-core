package nebula.tinyasm;

import java.util.function.Consumer;

public interface MethodHeader extends WithAccess<MethodHeader>, WithReturn<MethodHeader>, WithThrow<MethodHeader>,
		WithDefineParameter<MethodHeader>, WithAnnotation<MethodHeader> {
	MethodCode begin();

	MethodHeader code(Consumer<MethodCode> invocation);

	MethodHeader friendly(Consumer<MethodCodeFriendly> invocation);
	
	
//	void makeBridgeMathod();

}