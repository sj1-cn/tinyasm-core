package nebula.tinyasm.util;

import static org.objectweb.asm.Opcodes.*;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ARETURN;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.IRETURN;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.PUTFIELD;
import static org.objectweb.asm.Opcodes.RETURN;

import java.util.List;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

@Deprecated
public class AsmBuilder {
	public static String toCamelLower(String name) {
		return Character.toLowerCase(name.charAt(0)) + name.substring(1);
	}

	public static String toCamelUpper(String name) {
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}

	protected static String toPropertyGetName(String fieldName) {
		return "get" + toPropertyName(fieldName);
	}

	protected static String toPropertyName(String fieldName) {
		return Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
	}

	protected static String toPropertySetName(String fieldName) {
		return "set" + toPropertyName(fieldName);
	}

	public static String toSimpleName(String name) {
		int index = name.lastIndexOf('.');
		if (index < 0)
			index = name.lastIndexOf('/');

		return name.substring(index + 1);
	}

	public static Type[] toTypes(List<Type> types) {
		return types.toArray(new Type[0]);
	}

	public static void visitAnnotation(ClassVisitor cv, Type annotationType, Object annotationValue) {
		AnnotationVisitor av0 = cv.visitAnnotation(annotationType.getDescriptor(), true);
		if (annotationValue != null) {
			AnnotationVisitor av1 = av0.visitArray("value");
			av1.visit(null, annotationValue);
			av1.visitEnd();
		}
		av0.visitEnd();
	}

	public static void visitAnnotation(FieldVisitor fv, Type annotationType, Object value) {
		AnnotationVisitor av0 = fv.visitAnnotation(annotationType.getDescriptor(), true);
		if (value != null) {
			AnnotationVisitor av1 = av0.visitArray("value");
			av1.visit(null, value);
			av1.visitEnd();
		}
		av0.visitEnd();
	}

	public static void visitAnnotation(MethodVisitor mv, Type annotationType, Object value) {
		AnnotationVisitor av0 = mv.visitAnnotation(annotationType.getDescriptor(), true);
		if (value != null) {
			AnnotationVisitor av1 = av0.visitArray("value");
			av1.visit(null, value);
			av1.visitEnd();
		}
		av0.visitEnd();
	}

	public static void visitAnnotation(MethodVisitor mv, Type annotationType, String name, Object value) {
		AnnotationVisitor av0 = mv.visitAnnotation(annotationType.getDescriptor(), true);
		if (value != null) {
			if (name != null) {
				av0.visit(name, value);
			} else {
				av0.visit("value", value);
			}
		}
		av0.visitEnd();
	}

	public static void visitDefine_init_withNothing(ClassVisitor cw, Type objectType) {
		MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitCode();
		Label l0 = new Label();
		mv.visitLabel(l0);
		{
			visitInitObject(mv, 0);

			mv.visitInsn(RETURN);
		}
		Label l1 = new Label();
		mv.visitLabel(l1);
		mv.visitLocalVariable("this", objectType.getDescriptor(), null, l0, l1, 0);
		mv.visitMaxs(1, 1);
		mv.visitEnd();
	}

	public static void visitDefineField(ClassVisitor cw, String fieldName, Type fieldType) {
		visitDefineField(cw, ACC_PRIVATE, fieldName, fieldType);
	}

	public static FieldVisitor visitDefineField(ClassVisitor cw, String fieldName, Type fieldType, String signature) {
		return visitDefineField(cw, ACC_PRIVATE, fieldName, fieldType, signature);
	}

	public static FieldVisitor visitDefineField(ClassVisitor cw, String fieldName, Type fieldType, String signature,
			Type annotationType, Object value) {
		return visitDefineField(cw, ACC_PRIVATE, fieldName, fieldType, signature, annotationType, value);
	}

	public static FieldVisitor visitDefineField(ClassVisitor cw, String fieldName, Type fieldType, Type annotationType,
			Object value) {
		return visitDefineField(cw, fieldName, fieldType, null, annotationType, value);
	}

	public static void visitDefineField(ClassVisitor cw, int access, String fieldName, Type fieldType) {
		FieldVisitor fv = cw.visitField(access, fieldName, fieldType.getDescriptor(), null, null);
		fv.visitEnd();
	}

	public static FieldVisitor visitDefineField(ClassVisitor cw, int access, String fieldName, Type fieldType,
			String signature) {
		FieldVisitor fv = cw.visitField(access, fieldName, fieldType.getDescriptor(), signature, null);
		fv.visitEnd();
		return fv;
	}

	public static FieldVisitor visitDefineField(ClassVisitor cw, int access, String fieldName, Type fieldType,
			String signature, Type annotationType, Object value) {
		FieldVisitor fv = cw.visitField(access, fieldName, fieldType.getDescriptor(), signature, null);
		if (annotationType != null)
			visitAnnotation(fv, annotationType, value);
		fv.visitEnd();
		return fv;
	}

	public static FieldVisitor visitDefineField(ClassVisitor cw, int access, String fieldName, Type fieldType,
			Type annotationType, Object value) {

		return visitDefineField(cw, access, fieldName, fieldType, null, annotationType, value);
	}

	public static MethodVisitor visitDefineMethod(ClassVisitor cw, int access, Type returnType, String methodName,
			Type[] paramTypes, String signature, String[] exceptions) {
		MethodVisitor mv = cw.visitMethod(access, methodName, Type.getMethodDescriptor(returnType, paramTypes),
				signature, exceptions);
		return mv;
	}

	public static MethodVisitor visitDefineMethod(ClassVisitor cw, Type returnType, String methodName,
			Type... paramTypes) {
		MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, methodName, Type.getMethodDescriptor(returnType, paramTypes),
				null, null);
		return mv;
	}

	public static void visitDefinePropertyGet(ClassVisitor cw, Type objectType, String fieldName, Type fieldType) {
		MethodVisitor mv;
		mv = cw.visitMethod(ACC_PUBLIC, toPropertyGetName(fieldName), Type.getMethodDescriptor(fieldType), null, null);
		mv.visitCode();
		Label l0 = new Label();
		mv.visitLabel(l0);
		mv.visitLineNumber(22, l0);
		{
			visitGetField(mv, 0, objectType, fieldName, fieldType);
			visitReturn(mv, fieldType);
		}
		Label l1 = new Label();
		mv.visitLabel(l1);
		mv.visitLocalVariable("this", objectType.getDescriptor(), null, l0, l1, 0);
		mv.visitMaxs(0, 0);
		mv.visitEnd();
	}

	public static void visitDefinePropertySet(ClassVisitor cw, Type objectType, String fieldName, Type fieldType) {
		MethodVisitor mv;
		{
			mv = cw.visitMethod(ACC_PUBLIC, toPropertySetName(fieldName),
					Type.getMethodDescriptor(Type.VOID_TYPE, fieldType), null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitLineNumber(56, l0);
			{
				visitPutField(mv, 0, objectType, 1, fieldName, fieldType);
				visitReturn(mv);
			}
			Label l2 = new Label();
			mv.visitLabel(l2);
			mv.visitLocalVariable("this", objectType.getDescriptor(), null, l0, l2, 0);
			mv.visitLocalVariable(fieldName, fieldType.getDescriptor(), null, l0, l2, 1);
			mv.visitMaxs(2, 2);
			mv.visitEnd();
		}
	}

	public static void visitGetField(MethodVisitor mv, int objectIndex, Type objectType, String fieldName,
			Type fieldType) {
		mv.visitVarInsn(ALOAD, objectIndex);
		mv.visitFieldInsn(GETFIELD, objectType.getInternalName(), fieldName, fieldType.getDescriptor());
	}

	public static void visitGetField(MethodVisitor mv, Type objectType, String fieldName, Type fieldType) {
		mv.visitFieldInsn(GETFIELD, objectType.getInternalName(), fieldName, fieldType.getDescriptor());
	}

	public static void visitGetProperty(MethodVisitor mv, int objectIndex, Type objectType, String fieldName,
			Type fieldType) {
		mv.visitVarInsn(ALOAD, objectIndex);
		mv.visitMethodInsn(INVOKEVIRTUAL, objectType.getInternalName(), toPropertyGetName(fieldName),
				Type.getMethodDescriptor(fieldType), false);
	}

	public static void visitGetProperty(MethodVisitor mv, Type objectType, String fieldName, Type fieldType) {
		mv.visitMethodInsn(INVOKEVIRTUAL, objectType.getInternalName(), toPropertyGetName(fieldName),
				Type.getMethodDescriptor(fieldType), false);
	}

	public static void visitGetStaticField(MethodVisitor mv, Type objectType, String fieldName, Type fieldType) {
		mv.visitFieldInsn(GETSTATIC, objectType.getInternalName(), fieldName, fieldType.getDescriptor());
	}

	public static void visitInitObject(MethodVisitor mv, int index) {
		mv.visitVarInsn(ALOAD, index);
		mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
	}

	public static void visitInitTypeWithAllFields(MethodVisitor mv, Type objectType, Type... paramTypes) {
		mv.visitMethodInsn(INVOKESPECIAL, objectType.getInternalName(), "<init>",
				Type.getMethodDescriptor(Type.VOID_TYPE, paramTypes), false);
	}

	public static void visitInvoke(int opcode, MethodVisitor mv, Type objectType, Type returnType, String methodName,
			Type... paramTypes) {
		mv.visitMethodInsn(opcode, objectType.getInternalName(), methodName,
				Type.getMethodDescriptor(returnType, paramTypes), opcode == INVOKEINTERFACE);
	}

	public static void visitInvokeInterface(MethodVisitor mv, int objectIndex, Type objectType, Type returnType,
			String methodName, Type... paramTypes) {
		mv.visitVarInsn(ALOAD, objectIndex);
		mv.visitMethodInsn(INVOKEINTERFACE, objectType.getInternalName(), methodName,
				Type.getMethodDescriptor(returnType, paramTypes), true);
	}

	public static void visitInvokeInterface(MethodVisitor mv, Type objectType, Type returnType, String methodName,
			Type... paramTypes) {
		mv.visitMethodInsn(INVOKEINTERFACE, objectType.getInternalName(), methodName,
				Type.getMethodDescriptor(returnType, paramTypes), true);
	}

	public static void visitInvokeSpecial(MethodVisitor mv, int objectIndex, Type objectType, Type returnType,
			String methodName, Type... paramTypes) {
		mv.visitVarInsn(ALOAD, objectIndex);
		mv.visitMethodInsn(INVOKESPECIAL, objectType.getInternalName(), methodName,
				Type.getMethodDescriptor(returnType, paramTypes), false);
	}

	public static void visitInvokeSpecial(MethodVisitor mv, Type objectType, Type returnType, String methodName,
			Type... paramTypes) {
		mv.visitMethodInsn(INVOKESPECIAL, objectType.getInternalName(), methodName,
				Type.getMethodDescriptor(returnType, paramTypes), false);
	}

	public static void visitInvokeStatic(MethodVisitor mv, int objectIndex, Type objectType, Type returnType,
			String methodName, Type... paramTypes) {
		mv.visitVarInsn(ALOAD, objectIndex);
		mv.visitMethodInsn(INVOKESTATIC, objectType.getInternalName(), methodName,
				Type.getMethodDescriptor(returnType, paramTypes), false);
	}

	public static void visitInvokeStatic(MethodVisitor mv, Type objectType, Type returnType, String methodName,
			Type... paramTypes) {
		mv.visitMethodInsn(INVOKESTATIC, objectType.getInternalName(), methodName,
				Type.getMethodDescriptor(returnType, paramTypes), false);
	}

	public static void visitInvokeVirtual(MethodVisitor mv, int objectIndex, Type objectType, Type returnType,
			String methodName, Type... paramTypes) {
		mv.visitVarInsn(ALOAD, objectIndex);
		mv.visitMethodInsn(INVOKEVIRTUAL, objectType.getInternalName(), methodName,
				Type.getMethodDescriptor(returnType, paramTypes), false);
	}

	public static void visitInvokeVirtual(MethodVisitor mv, Type objectType, Type returnType, String methodName,
			Type... paramTypes) {
		mv.visitMethodInsn(INVOKEVIRTUAL, objectType.getInternalName(), methodName,
				Type.getMethodDescriptor(returnType, paramTypes), false);
	}

	public static void visitNewObject(MethodVisitor mv, Type objectType) {
		mv.visitTypeInsn(NEW, objectType.getInternalName());
	}
	//
	// public static void visitPrintObject(MethodVisitor mv, int objectIndex) {
	// mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out",
	// "Ljava/io/PrintStream;");
	// mv.visitVarInsn(ALOAD, objectIndex);
	// mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println",
	// "(Ljava/lang/Object;)V", false);
	// }
	//
	// public static void visitPrintObject(MethodVisitor mv, String message, int
	// objectIndex) {
	// mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out",
	// "Ljava/io/PrintStream;");
	// mv.visitLdcInsn(message);
	// mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print",
	// "(Ljava/lang/String;)V", false);
	//
	// mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out",
	// "Ljava/io/PrintStream;");
	// mv.visitVarInsn(ALOAD, objectIndex);
	// mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println",
	// "(Ljava/lang/Object;)V", false);
	// }
	//
	// public static void visitPrintStaticMessage(MethodVisitor mv, String
	// staticMessage) {
	// mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out",
	// "Ljava/io/PrintStream;");
	// mv.visitLdcInsn(staticMessage);
	// mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println",
	// "(Ljava/lang/String;)V", false);
	// }
	//
	// public static void visitPrintString(MethodVisitor mv, int stringIndex) {
	// mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out",
	// "Ljava/io/PrintStream;");
	// mv.visitLdcInsn(stringIndex);
	// mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println",
	// "(Ljava/lang/String;)V", false);
	// }

	public static void visitParameterAnnotation(MethodVisitor mv, int parameter, Type annotationType, Object value) {
		AnnotationVisitor av0 = mv.visitParameterAnnotation(parameter, annotationType.getDescriptor(), true);
		if (value != null) {
			AnnotationVisitor av1 = av0.visitArray("value");
			av1.visit(null, value);
			av1.visitEnd();
		}
		av0.visitEnd();
	}

	public static void visitPutField(MethodVisitor mv, int objectIndex, Type objectType, int dataIndex,
			String fieldName, Type fieldType) {
		mv.visitVarInsn(ALOAD, objectIndex);
		mv.visitVarInsn(fieldType.getOpcode(ILOAD), dataIndex);
		mv.visitFieldInsn(PUTFIELD, objectType.getInternalName(), fieldName, fieldType.getDescriptor());
	}

	public static void visitPutField(MethodVisitor mv, Type objectType, String fieldName, Type fieldType) {
		mv.visitFieldInsn(PUTFIELD, objectType.getInternalName(), fieldName, fieldType.getDescriptor());
	}

	public static void visitPutStaticField(MethodVisitor mv, Type objectType, String fieldName, Type fieldType) {
		mv.visitFieldInsn(PUTSTATIC, objectType.getInternalName(), fieldName, fieldType.getDescriptor());
	}

	public static void visitReturn(MethodVisitor mv) {
		mv.visitInsn(RETURN);
	}

	public static void visitReturn(MethodVisitor mv, Type fieldType) {
		mv.visitInsn(fieldType.getOpcode(IRETURN));
	}

	public static void visitReturnObject(MethodVisitor mv) {
		mv.visitInsn(ARETURN);
	}

	public static void visitReturnType(MethodVisitor mv, Type type) {
		mv.visitInsn(type.getOpcode(IRETURN));
	}

	public static void visitSetProperty(MethodVisitor mv, Type objectType, String fieldName, Type fieldType) {
		mv.visitMethodInsn(INVOKEVIRTUAL, objectType.getInternalName(), toPropertySetName(fieldName),
				Type.getMethodDescriptor(Type.VOID_TYPE, fieldType), false);
	}

	public static void visitTypeInsn(MethodVisitor mv, int opcode, String type) {
		mv.visitTypeInsn(opcode, type);
	}

	// public static void visitSetProperty(MethodVisitor mv, int objectIndex,
	// Type objectType, String fieldName, Type fieldType) {
	// mv.visitVarInsn(ALOAD, objectIndex);
	// mv.visitMethodInsn(INVOKEVIRTUAL, objectType.getInternalName(),
	// toPropertySetName(fieldName), Type.getMethodDescriptor(Type.VOID_TYPE,
	// fieldType),
	// false);
	// }
	//
	// public static void visitSetProperty(MethodVisitor mv, Type objectType,
	// String fieldName, Type fieldType) {
	// mv.visitMethodInsn(INVOKEVIRTUAL, objectType.getInternalName(),
	// toPropertySetName(fieldName), Type.getMethodDescriptor(Type.VOID_TYPE,
	// fieldType),
	// false);
	// }

	// public static void visitLOGGER(MethodVisitor mv, String message) {
	// mv.visitFieldInsn(GETSTATIC, Type.getInternalName(ASMBuilder.class),
	// "LOGGER", Type.getDescriptor(Logger.class));
	// mv.visitLdcInsn(message);
	// mv.visitMethodInsn(INVOKEINTERFACE, Type.getInternalName(Logger.class),
	// "debug", "(Ljava/lang/String;)V", true);
	// }
	//
	// public static void visitLOGGER(MethodVisitor mv, String message, int
	// objectIndex) {
	// mv.visitFieldInsn(GETSTATIC, Type.getInternalName(ASMBuilder.class),
	// "LOGGER", Type.getDescriptor(Logger.class));
	// mv.visitLdcInsn(message);
	// mv.visitVarInsn(ALOAD, objectIndex);
	// mv.visitMethodInsn(INVOKEINTERFACE, Type.getInternalName(Logger.class),
	// "debug", "(Ljava/lang/String;Ljava/lang/Object;)V", true);
	// }
}