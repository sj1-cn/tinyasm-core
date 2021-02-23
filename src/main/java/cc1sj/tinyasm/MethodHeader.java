package cc1sj.tinyasm;

import java.util.function.Consumer;

import org.objectweb.asm.MethodVisitor;

public interface MethodHeader extends WithAccess<MethodHeader>, WithReturn<MethodHeader>, WithThrow<MethodHeader>,
		WithDefineParameter<MethodHeader>, WithAnnotation<MethodHeader> {
	MethodCode begin();
	void end();

	void code(Consumer<MethodCode> invocation);
	MethodCode code();
	
	MethodVisitor getMethodVisitor();

//	MethodHeader friendly(Consumer<MethodCodeAdv> invocation);
	
	
//	void makeBridgeMathod();

}