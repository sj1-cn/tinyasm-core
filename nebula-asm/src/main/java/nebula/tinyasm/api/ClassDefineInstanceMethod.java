package nebula.tinyasm.api;

import static nebula.tinyasm.util.TypeUtils.namesOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

import org.objectweb.asm.Type;

public interface ClassDefineInstanceMethod<MC>  {

	default MethodHeader<MC> method(int access, Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return method(access, Type.getType(returnClass), methodName, exceptionClasses);
	}

	MethodHeader<MC> method(int access, Type returnType, String methodName, String[] exceptionClasses);

//	MethodHeader<C> method(int access, String name, String desc, String signature, String[] exceptions);

	default MethodHeader<MC> method(int access, Type returnType, String methodName, Class<?>... exceptionClasses) {
		return method(access, returnType, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> method(Class<?> returnClass, String methodName) {
		return method(0, typeOf(returnClass), methodName);
	}

	default MethodHeader<MC> method(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return method(0, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<MC> method(String methodName) {
		return method(0, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<MC> method(String methodName, Class<?>... exceptionClasses) {
		return method(0, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<MC> method(Type returnType, String methodName) {
		return method(0, returnType, methodName);
	}

	default MethodHeader<MC> method(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return method(0, returnType, methodName, exceptionClasses);
	}

	default MethodHeader<MC> privateMethod(Class<?> returnClass, String methodName) {
		return method(ACC_PRIVATE, typeOf(returnClass), methodName);
	}

	default MethodHeader<MC> privateMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PRIVATE, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<MC> privateMethod(String methodName) {
		return method(ACC_PRIVATE, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<MC> privateMethod(String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PRIVATE, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<MC> privateMethod(Type returnType, String methodName) {
		return method(ACC_PRIVATE, returnType, methodName);
	}

	default MethodHeader<MC> privateMethod(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PRIVATE, returnType, methodName, exceptionClasses);
	}

	default MethodHeader<MC> protectdMethod(Class<?> returnClass, String methodName) {
		return method(ACC_PROTECTED, typeOf(returnClass), methodName);
	}

	default MethodHeader<MC> protectdMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PROTECTED, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<MC> protectdMethod(String methodName) {
		return method(ACC_PROTECTED, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<MC> protectdMethod(String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PROTECTED, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<MC> protectdMethod(Type returnType, String methodName) {
		return method(ACC_PROTECTED, returnType, methodName);
	}

	default MethodHeader<MC> protectdMethod(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PROTECTED, returnType, methodName, exceptionClasses);
	}

	default MethodHeader<MC> publicMethod(Class<?> returnClass, String methodName) {
		return method(ACC_PUBLIC, typeOf(returnClass), methodName);
	}

	default MethodHeader<MC> publicMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PUBLIC, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<MC> publicMethod(String methodName) {
		return method(ACC_PUBLIC, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<MC> publicMethod(String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PUBLIC, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<MC> publicMethod(Type returnType, String methodName) {
		return method(ACC_PUBLIC, returnType, methodName);
	}

	default MethodHeader<MC> publicMethod(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PUBLIC, returnType, methodName, exceptionClasses);
	}

}
