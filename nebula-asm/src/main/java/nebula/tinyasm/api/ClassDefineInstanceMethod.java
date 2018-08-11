package nebula.tinyasm.api;

import static nebula.tinyasm.api.TypeUtils.namesOf;
import static nebula.tinyasm.api.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

import org.objectweb.asm.Type;

public interface ClassDefineInstanceMethod<C>  {

	default MethodHeader<C> method(int access, Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return method(access, Type.getType(returnClass), methodName, exceptionClasses);
	}

	MethodHeader<C> method(int access, Type returnType, String methodName, String[] exceptionClasses);

//	MethodHeader<C> method(int access, String name, String desc, String signature, String[] exceptions);

	default MethodHeader<C> method(int access, Type returnType, String methodName, Class<?>... exceptionClasses) {
		return method(access, returnType, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<C> method(Class<?> returnClass, String methodName) {
		return method(0, typeOf(returnClass), methodName);
	}

	default MethodHeader<C> method(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return method(0, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<C> method(String methodName) {
		return method(0, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<C> method(String methodName, Class<?>... exceptionClasses) {
		return method(0, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<C> method(Type returnType, String methodName) {
		return method(0, returnType, methodName);
	}

	default MethodHeader<C> method(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return method(0, returnType, methodName, exceptionClasses);
	}

	default MethodHeader<C> privateMethod(Class<?> returnClass, String methodName) {
		return method(ACC_PRIVATE, typeOf(returnClass), methodName);
	}

	default MethodHeader<C> privateMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PRIVATE, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<C> privateMethod(String methodName) {
		return method(ACC_PRIVATE, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<C> privateMethod(String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PRIVATE, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<C> privateMethod(Type returnType, String methodName) {
		return method(ACC_PRIVATE, returnType, methodName);
	}

	default MethodHeader<C> privateMethod(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PRIVATE, returnType, methodName, exceptionClasses);
	}

	default MethodHeader<C> protectdMethod(Class<?> returnClass, String methodName) {
		return method(ACC_PROTECTED, typeOf(returnClass), methodName);
	}

	default MethodHeader<C> protectdMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PROTECTED, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<C> protectdMethod(String methodName) {
		return method(ACC_PROTECTED, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<C> protectdMethod(String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PROTECTED, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<C> protectdMethod(Type returnType, String methodName) {
		return method(ACC_PROTECTED, returnType, methodName);
	}

	default MethodHeader<C> protectdMethod(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PROTECTED, returnType, methodName, exceptionClasses);
	}

	default MethodHeader<C> publicMethod(Class<?> returnClass, String methodName) {
		return method(ACC_PUBLIC, typeOf(returnClass), methodName);
	}

	default MethodHeader<C> publicMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PUBLIC, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<C> publicMethod(String methodName) {
		return method(ACC_PUBLIC, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<C> publicMethod(String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PUBLIC, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<C> publicMethod(Type returnType, String methodName) {
		return method(ACC_PUBLIC, returnType, methodName);
	}

	default MethodHeader<C> publicMethod(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return method(ACC_PUBLIC, returnType, methodName, exceptionClasses);
	}

}
