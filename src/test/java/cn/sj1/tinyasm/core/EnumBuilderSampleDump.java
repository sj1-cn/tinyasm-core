package cn.sj1.tinyasm.core;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class EnumBuilderSampleDump implements Opcodes {

	public static byte[] dump() throws Exception {

		ClassWriter cw = new ClassWriter(0);
		FieldVisitor fv;
		MethodVisitor mv;

		cw.visit(53, ACC_PUBLIC + ACC_FINAL + ACC_SUPER + ACC_ENUM, "com/nebula/dropwizard/core/Status", "Ljava/lang/Enum<Lcom/nebula/dropwizard/core/Status;>;",
		        "java/lang/Enum", null);

		cw.visitSource("Status.java", null);

		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC + ACC_ENUM, "STARTED", "Lcom/nebula/dropwizard/core/Status;", null, null);
			fv.visitEnd();
		}
		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC + ACC_ENUM, "FAILED", "Lcom/nebula/dropwizard/core/Status;", null, null);
			fv.visitEnd();
		}
		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC + ACC_ENUM, "COMPLETED", "Lcom/nebula/dropwizard/core/Status;", null, null);
			fv.visitEnd();
		}
		{
			fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC + ACC_SYNTHETIC, "ENUM$VALUES", "[Lcom/nebula/dropwizard/core/Status;", null, null);
			fv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitLineNumber(4, l0);
			mv.visitTypeInsn(NEW, "com/nebula/dropwizard/core/Status");
			mv.visitInsn(DUP);
			mv.visitLdcInsn("STARTED");
			mv.visitInsn(ICONST_0);
			mv.visitMethodInsn(INVOKESPECIAL, "com/nebula/dropwizard/core/Status", "<init>", "(Ljava/lang/String;I)V", false);
			mv.visitFieldInsn(PUTSTATIC, "com/nebula/dropwizard/core/Status", "STARTED", "Lcom/nebula/dropwizard/core/Status;");
			mv.visitTypeInsn(NEW, "com/nebula/dropwizard/core/Status");
			mv.visitInsn(DUP);
			mv.visitLdcInsn("FAILED");
			mv.visitInsn(ICONST_1);
			mv.visitMethodInsn(INVOKESPECIAL, "com/nebula/dropwizard/core/Status", "<init>", "(Ljava/lang/String;I)V", false);
			mv.visitFieldInsn(PUTSTATIC, "com/nebula/dropwizard/core/Status", "FAILED", "Lcom/nebula/dropwizard/core/Status;");
			mv.visitTypeInsn(NEW, "com/nebula/dropwizard/core/Status");
			mv.visitInsn(DUP);
			mv.visitLdcInsn("COMPLETED");
			mv.visitInsn(ICONST_2);
			mv.visitMethodInsn(INVOKESPECIAL, "com/nebula/dropwizard/core/Status", "<init>", "(Ljava/lang/String;I)V", false);
			mv.visitFieldInsn(PUTSTATIC, "com/nebula/dropwizard/core/Status", "COMPLETED", "Lcom/nebula/dropwizard/core/Status;");
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitLineNumber(3, l1);
			mv.visitInsn(ICONST_3);
			mv.visitTypeInsn(ANEWARRAY, "com/nebula/dropwizard/core/Status");
			mv.visitInsn(DUP);
			mv.visitInsn(ICONST_0);
			mv.visitFieldInsn(GETSTATIC, "com/nebula/dropwizard/core/Status", "STARTED", "Lcom/nebula/dropwizard/core/Status;");
			mv.visitInsn(AASTORE);
			mv.visitInsn(DUP);
			mv.visitInsn(ICONST_1);
			mv.visitFieldInsn(GETSTATIC, "com/nebula/dropwizard/core/Status", "FAILED", "Lcom/nebula/dropwizard/core/Status;");
			mv.visitInsn(AASTORE);
			mv.visitInsn(DUP);
			mv.visitInsn(ICONST_2);
			mv.visitFieldInsn(GETSTATIC, "com/nebula/dropwizard/core/Status", "COMPLETED", "Lcom/nebula/dropwizard/core/Status;");
			mv.visitInsn(AASTORE);
			mv.visitFieldInsn(PUTSTATIC, "com/nebula/dropwizard/core/Status", "ENUM$VALUES", "[Lcom/nebula/dropwizard/core/Status;");
			mv.visitInsn(RETURN);
			mv.visitMaxs(4, 0);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PRIVATE, "<init>", "(Ljava/lang/String;I)V", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitLineNumber(3, l0);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitVarInsn(ILOAD, 2);
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Enum", "<init>", "(Ljava/lang/String;I)V", false);
			mv.visitInsn(RETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitLocalVariable("this", "Lcom/nebula/dropwizard/core/Status;", null, l0, l1, 0);
			mv.visitLocalVariable("name", "Ljava/lang/String;", null, l0, l1, 1);
			mv.visitLocalVariable("value", "I", null, l0, l1, 2);
			mv.visitMaxs(3, 3);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "values", "()[Lcom/nebula/dropwizard/core/Status;", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitLineNumber(1, l0);
			mv.visitFieldInsn(GETSTATIC, "com/nebula/dropwizard/core/Status", "ENUM$VALUES", "[Lcom/nebula/dropwizard/core/Status;");
			mv.visitInsn(DUP);
			mv.visitVarInsn(ASTORE, 0);
			mv.visitInsn(ICONST_0);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitInsn(ARRAYLENGTH);
			mv.visitInsn(DUP);
			mv.visitVarInsn(ISTORE, 1);
			mv.visitTypeInsn(ANEWARRAY, "com/nebula/dropwizard/core/Status");
			mv.visitInsn(DUP);
			mv.visitVarInsn(ASTORE, 2);
			mv.visitInsn(ICONST_0);
			mv.visitVarInsn(ILOAD, 1);
			mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
			mv.visitVarInsn(ALOAD, 2);
			mv.visitInsn(ARETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitLocalVariable("vs", "[Lcom/nebula/dropwizard/core/Status;", null, l0, l1, 0);
			mv.visitLocalVariable("length", "I", null, l0, l1, 1);
			mv.visitLocalVariable("newvs", "[Lcom/nebula/dropwizard/core/Status;", null, l0, l1, 2);
			mv.visitMaxs(5, 3);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "valueOf", "(Ljava/lang/String;)Lcom/nebula/dropwizard/core/Status;", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitLineNumber(1, l0);
			mv.visitLdcInsn(Type.getType("Lcom/nebula/dropwizard/core/Status;"));
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESTATIC, "java/lang/Enum", "valueOf", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;", false);
			mv.visitTypeInsn(CHECKCAST, "com/nebula/dropwizard/core/Status");
			mv.visitInsn(ARETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitLocalVariable("name", "Ljava/lang/String;", null, l0, l1, 0);
			mv.visitMaxs(2, 1);
			mv.visitEnd();
		}
		cw.visitEnd();

		return cw.toByteArray();
	}
}
