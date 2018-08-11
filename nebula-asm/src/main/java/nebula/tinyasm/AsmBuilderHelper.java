package nebula.tinyasm;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import nebula.tinyasm.api.Field;
import nebula.tinyasm.util.AsmBuilder;

public class AsmBuilderHelper extends AsmBuilder implements Opcodes {

	public static int[] computerLocals(List<Type> types) {
		int[] locals = new int[types.size()];
		int cntLocal = 0;
		for (int i = 0; i < types.size(); i++) {
			locals[i] = cntLocal;
			cntLocal += types.get(i)
					.getSize();
		}
		return locals;
	}

	public static int[] computerLocals(Type objectType, Type... types) {
		List<Type> locals = new ArrayList<>();
		locals.add(objectType);
		for (Type type : types) {
			locals.add(type);
		}
		return computerLocals(locals);
	}

	// Begin 5 Private return class,with classes
	public static IndependentInstanceMethodBuilder definePrivateMethod(ClassVisitor cw, Type objectType, Class<?> returnClass,
			String methodName) {
		return definePrivate(cw, objectType, typeOf(returnClass), methodName);
	}

	// Begin 1 Private return void,with void params
	public static IndependentInstanceMethodBuilder definePrivate(ClassVisitor cw, Type objectType, String methodName) {
		return definePrivate(cw, objectType, Type.VOID_TYPE, methodName);
	}
	// End Private

	public static IndependentInstanceMethodBuilder definePrivate(ClassVisitor cw, Type objectType, Type returnType,
			String methodName) {
		return new IndependentInstanceMethodBuilder(cw, objectType, ACC_PRIVATE, returnType, methodName);
	}

	// Begin 5 Protected return class,with classes
	public static IndependentInstanceMethodBuilder defineProtected(ClassVisitor cw, Type objectType, Class<?> returnClass,
			String methodName) {
		return defineProtected(cw, objectType, typeOf(returnClass), methodName);
	}

	// Begin 1 Protected return void,with void params
	public static IndependentInstanceMethodBuilder defineProtected(ClassVisitor cw, Type objectType, String methodName) {
		return defineProtected(cw, objectType, Type.VOID_TYPE, methodName);
	}

	// End Private

	public static IndependentInstanceMethodBuilder defineProtected(ClassVisitor cw, Type objectType, Type returnType,
			String methodName) {
		return new IndependentInstanceMethodBuilder(cw, objectType, ACC_PROTECTED, returnType, methodName);
	}

	// Begin 5 Public return class,with classes
	public static IndependentInstanceMethodBuilder definePublic(ClassVisitor cw, Type objectType, Class<?> returnClass,
			String methodName) {
		return definePublic(cw, objectType, typeOf(returnClass), methodName);
	}

	// Begin 1 Public return void,with void params
	public static IndependentInstanceMethodBuilder definePublic(ClassVisitor cw, Type objectType, String methodName) {
		return definePublic(cw, objectType, Type.VOID_TYPE, methodName);
	}

	public static IndependentInstanceMethodBuilder definePublic(ClassVisitor cw, Type objectType, Type returnType,
			String methodName) {
		return new IndependentInstanceMethodBuilder(cw, objectType, ACC_PUBLIC, returnType, methodName);
	}

	public static Type typeOf(Class<?> clz) {
		return Type.getType(clz);
	}

	public static Type[] typesOf(Class<?>... paramClasses) {
		Type[] paramTypes = new Type[paramClasses.length];
		for (int i = 0; i < paramClasses.length; i++) {
			paramTypes[i] = Type.getType(paramClasses[i]);
		}
		return paramTypes;
	}

	public static Type[] typesOf(Field[] fields) {
		Type[] types = new Type[fields.length];
		for (int i = 0; i < fields.length; i++) {
			types[i] = fields[i].type;
		}
		return types;
	}

	public static Type[] typesOf(List<Field> fields) {
		Type[] params = new Type[fields.size()];
		for (int i = 0; i < fields.size(); i++) {
			params[i] = fields.get(i).type;
		}
		return params;
	}

	public static void visitAnnotation(ClassVisitor mv, Class<?> annotationClass) {
		visitAnnotation(mv, typeOf(annotationClass), null);
	}

	public static void visitAnnotation(MethodVisitor mv, Class<?> annotationClass) {
		visitAnnotation(mv, typeOf(annotationClass), null);
	}

	public static void visitAnnotation(MethodVisitor mv, Class<?> annotationClass, String value) {
		visitAnnotation(mv, typeOf(annotationClass), value);
	}

	public static void visitParameterAnnotation(MethodVisitor mv, int parameter, Class<?> annotationClass) {
		visitParameterAnnotation(mv, parameter, typeOf(annotationClass), null);
	}

	public static void visitParameterAnnotation(MethodVisitor mv, int parameter, Type annotationType) {
		visitParameterAnnotation(mv, parameter, annotationType, null);
	}

	public static void visitAnnotation(ClassVisitor mv, Class<?> annotationClass, String value) {
		visitAnnotation(mv, typeOf(annotationClass), value);
	}

	public static void visitDefineField(ClassVisitor cw, String fieldName, Class<?> fieldClass) {
		visitDefineField(cw, fieldName, Type.getType(fieldClass), null, null);
	}

	public static FieldVisitor visitDefineField(ClassVisitor cw, String fieldName, Class<?> fieldClass,
			Class<?> annotationClass) {
		return visitDefineField(cw, fieldName, Type.getType(fieldClass), typeOf(annotationClass), null);
	}

	public static void visitAnnotation(FieldVisitor fv, Type annotationType) {
		visitAnnotation(fv, annotationType, null);
	}

	public static void visitAnnotation(FieldVisitor fv, Class<?> annotationClass) {
		visitAnnotation(fv, typeOf(annotationClass), null);
	}

	public static void visitDefineField(ClassVisitor cw, String fieldName, Class<?> fieldClass,
			Class<?> annotationClass, Object value) {
		visitDefineField(cw, fieldName, Type.getType(fieldClass), typeOf(annotationClass), value);
	}

	public static void visitGetField(MethodVisitor mv, int objectIndex, Type objectType, String fieldName,
			Class<?> fieldClass) {
		visitGetField(mv, objectIndex, objectType, fieldName, Type.getType(fieldClass));
	}

	public static void visitInitTypeWithAllFields(MethodVisitor mv, Class<?> objectClass, Class<?>... paramClasses) {
		visitInitTypeWithAllFields(mv, Type.getType(objectClass), paramClasses);
	}

	public static void visitInitTypeWithAllFields(MethodVisitor mv, Type objectType, Class<?>... paramClasses) {
		visitInitTypeWithAllFields(mv, objectType, typesOf(paramClasses));
	}

	public static void visitInvokeInterface(MethodVisitor mv, Class<?> objectClass, Class<?> returnClass,
			String methodName) {
		visitInvokeInterface(mv, Type.getType(objectClass), Type.getType(returnClass), methodName);
	}

	public static void visitInvokeInterface(MethodVisitor mv, Class<?> objectClass, Class<?> returnClass,
			String methodName, Class<?>... paramClasses) {
		visitInvokeInterface(mv, Type.getType(objectClass), Type.getType(returnClass), methodName,
				typesOf(paramClasses));
	}

	public static void visitInvokeInterface(MethodVisitor mv, Class<?> objectClass, Class<?> returnClass,
			String methodName, Type... params) {
		visitInvokeInterface(mv, Type.getType(objectClass), Type.getType(returnClass), methodName, params);
	}

	public static void visitInvokeInterface(MethodVisitor mv, Class<?> objectClass, String methodName,
			Class<?>... paramClasses) {
		visitInvokeInterface(mv, Type.getType(objectClass), Type.VOID_TYPE, methodName, typesOf(paramClasses));
	}

	public static void visitInvokeInterface(MethodVisitor mv, Type objectType, Class<?> returnClass, String methodName,
			Class<?>... paramClasses) {
		visitInvokeInterface(mv, objectType, Type.getType(returnClass), methodName, typesOf(paramClasses));
	}

	public static void visitInvokeInterface(MethodVisitor mv, Type objectType, String methodName, Type... params) {
		visitInvokeInterface(mv, objectType, Type.VOID_TYPE, methodName, params);
	}

	public static void visitInvokeInterface(MethodVisitor mv, Type objectType, Type returnType, String methodName,
			Class<?>... paramClasses) {
		visitInvokeInterface(mv, objectType, returnType, methodName, typesOf(paramClasses));
	}

	public static void visitInvokeSpecial(MethodVisitor mv, Class<?> objectClass, Class<?> returnClass,
			String methodName, Class<?>... paramClasses) {
		visitInvokeSpecial(mv, Type.getType(objectClass), Type.getType(returnClass), methodName, typesOf(paramClasses));
	}

	public static void visitInvokeSpecial(MethodVisitor mv, int objectIndex, Type objectType, String methodName) {
		visitInvokeSpecial(mv, objectIndex, objectType, Type.VOID_TYPE, methodName);
	}

	public static void visitInvokeSpecial(MethodVisitor mv, Type objectType, Class<?> returnClass, String methodName,
			Class<?>... paramClasses) {
		visitInvokeSpecial(mv, objectType, Type.getType(returnClass), methodName, typesOf(paramClasses));
	}

	public static void visitInvokeSpecial(MethodVisitor mv, Type objectType, String methodName, Type... params) {
		visitInvokeSpecial(mv, objectType, Type.VOID_TYPE, methodName, params);
	}

	public static void visitInvokeSpecial(MethodVisitor mv, Type objectType, Type returnType, String methodName,
			Class<?>... paramClasses) {
		visitInvokeSpecial(mv, objectType, returnType, methodName, typesOf(paramClasses));
	}

	public static void visitInvokeStatic(MethodVisitor mv, Class<?> objectClass, Class<?> returnClass,
			String methodName, Class<?>... paramClasses) {
		visitInvokeStatic(mv, Type.getType(objectClass), Type.getType(returnClass), methodName, typesOf(paramClasses));
	}

	public static void visitInvokeStatic(MethodVisitor mv, int objectIndex, Type objectType, String methodName) {
		visitInvokeStatic(mv, objectIndex, objectType, Type.VOID_TYPE, methodName);
	}

	public static void visitInvokeStatic(MethodVisitor mv, int objectIndex, Type objectType, Type returnType,
			String methodName) {
		visitInvokeStatic(mv, objectIndex, objectType, returnType, methodName);
	}

	public static void visitInvokeStatic(MethodVisitor mv, Type objectType, Class<?> returnClass, String methodName,
			Class<?>... paramClasses) {
		visitInvokeStatic(mv, objectType, Type.getType(returnClass), methodName, typesOf(paramClasses));
	}

	public static void visitInvokeStatic(MethodVisitor mv, Type objectType, String methodName, Type... params) {
		visitInvokeStatic(mv, objectType, Type.VOID_TYPE, methodName, params);
	}

	public static void visitInvokeStatic(MethodVisitor mv, Type objectType, Type returnType, String methodName,
			Class<?>... paramClasses) {
		visitInvokeStatic(mv, objectType, returnType, methodName, typesOf(paramClasses));
	}

	public static void visitInvokeVirtual(MethodVisitor mv, Class<?> objectClass, Class<?> returnClass,
			String methodName, Class<?>... paramClasses) {
		visitInvokeVirtual(mv, Type.getType(objectClass), Type.getType(returnClass), methodName, typesOf(paramClasses));
	}

	public static void visitInvokeVirtual(MethodVisitor mv, Class<?> objectClass, Type returnType, String methodName,
			Class<?>... paramClasses) {
		visitInvokeVirtual(mv, Type.getType(objectClass), returnType, methodName, typesOf(paramClasses));
	}

	public static void visitInvokeVirtual(MethodVisitor mv, int objectIndex, Type objectType, String methodName,
			Type... params) {
		visitInvokeVirtual(mv, objectIndex, objectType, Type.VOID_TYPE, methodName, params);
	}

	public static void visitInvokeVirtual(MethodVisitor mv, Type objectType, Class<?> returnClass, String methodName,
			Class<?>... paramClasses) {
		visitInvokeVirtual(mv, objectType, Type.getType(returnClass), methodName, typesOf(paramClasses));
	}

	public static void visitInvokeVirtual(MethodVisitor mv, Type objectType, String methodName, Type... params) {
		visitInvokeVirtual(mv, objectType, Type.VOID_TYPE, methodName, params);
	}

	public static void visitInvokeVirtual(MethodVisitor mv, Type objectType, Type returnType, String methodName,
			Class<?>... paramClasses) {
		visitInvokeVirtual(mv, objectType, returnType, methodName, typesOf(paramClasses));
	}

	public static void visitNewObject(MethodVisitor mv, Class<?> objectClass) {
		visitNewObject(mv, Type.getType(objectClass));
	}

	public static void visitPutField(MethodVisitor mv, int objectIndex, Type objectType, int dataIndex,
			String fieldName, Class<?> fieldClass) {
		visitPutField(mv, objectIndex, objectType, dataIndex, fieldName, Type.getType(fieldClass));
	}

	// public static void print(byte[] code){
	// ClassReader cr = new ClassReader(code);
	// ClassVisitor visitor = new TraceClassVisitor(null, new ASMifier(), new
	// PrintWriter(System.out));
	// cr.accept(visitor, ClassReader.EXPAND_FRAMES);
	// }
}
