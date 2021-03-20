package cn.sj1.tinyasm.core.analyze;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import cn.sj1.tinyasm.core.Field;

public class ConvertFromParamsToClassMethodVisitor extends MethodVisitor {
//	private final Type eventType;
//	private final Field[] params;
//
	public ConvertFromParamsToClassMethodVisitor(ClassVisitor cv, int access, String name, String desc,
			String signature, String[] exceptions, Type eventType, Field[] params) {
		super(Opcodes.ASM8, cv.visitMethod(access, name, Type.getMethodDescriptor(Type.VOID_TYPE, eventType), signature,
				exceptions));
//		this.eventType = eventType;
//		this.params = params;

//		AsmBuilderHelper.visitAnnotation(mv, EventHandler.class);
	}
//
//	// Replace visit param to invoke event's property
//	@Override
//	public void visitVarInsn(int opcode, int var) {
//		if (0 < var && var <= params.length) {
//			super.visitVarInsn(ALOAD, 1);
//			Field field = params[var - 1];
//			mv.visitMethodInsn(INVOKEVIRTUAL, eventType.getInternalName(), toPropertyGetName(field.name),
//					Type.getMethodDescriptor(typeOf(field.clazz.clazz)), false);
//		} else {
//			super.visitVarInsn(opcode, var);
//		}
//	}
//
//	@Override
//	public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
//		if (index == 0) {
//			super.visitLocalVariable(name, desc, signature, start, end, index);
//			super.visitLocalVariable("event", eventType.getDescriptor(), signature, start, end, 1);
//		} else if (index <= params.length) {
//		} else {
//			super.visitLocalVariable(name, desc, signature, start, end, index - params.length + 1);
//		}
//	}
//
//	boolean doneVisitParameter = false;
//
//	@Override
//	public void visitParameter(String name, int access) {
//		if (access == 0) {
//			super.visitParameter("event", 0);
//		}
//	}
//
//	@Override
//	public void visitInsn(int opcode) {
//		if (opcode == Opcodes.RETURN) {
////			AsmBuilderHelper.visitPrintObject(mv,1);
////			AsmBuilderHelper.visitPrintObject(mv,"after event: ", 0);
//		}
//		super.visitInsn(opcode);
//	}
//
//	// mv.visitInsn(fieldType.getOpcode(IRETURN));
//	@Override
//	public void visitEnd() {
//		super.visitEnd();
//	}
}