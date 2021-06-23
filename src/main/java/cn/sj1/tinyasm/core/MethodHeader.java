package cn.sj1.tinyasm.core;

import java.util.function.Consumer;

import org.objectweb.asm.MethodVisitor;

public interface MethodHeader extends
		UsingAccess<MethodHeader>, UsingReturn<MethodHeader>, UsingThrows<MethodHeader>,
		UsingParameter<MethodHeader>, UsingAnnotation<MethodHeader>, UsingSignature<MethodHeader> {
	MethodCode begin();
//	void end();

	void code(Consumer<MethodCode> invocation);
//	MethodCode code();

	MethodVisitor getMethodVisitor();

//	MethodHeader friendly(Consumer<MethodCodeAdv> invocation);

//	void makeBridgeMathod();

}