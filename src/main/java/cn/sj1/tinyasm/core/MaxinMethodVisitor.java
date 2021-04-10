package cn.sj1.tinyasm.core;

import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;

public class MaxinMethodVisitor extends MethodVisitor {

	public MaxinMethodVisitor(int api, MethodVisitor methodVisitor) {
		super(api, methodVisitor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visitInvokeDynamicInsn(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
		// TODO Auto-generated method stub
		super.visitInvokeDynamicInsn(name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments);
	}

}
