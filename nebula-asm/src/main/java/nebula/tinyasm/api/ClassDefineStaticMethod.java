package nebula.tinyasm.api;

import static nebula.tinyasm.api.TypeUtils.arrayOf;
import static nebula.tinyasm.api.TypeUtils.namesOf;
import static nebula.tinyasm.api.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

import org.objectweb.asm.Type;

public interface ClassDefineStaticMethod<C> {

	default MethodHeader<C> privateStaticMethod(Class<?> returnClass, String methodName) {
		return staticMethod(ACC_STATIC + ACC_PRIVATE, typeOf(returnClass), methodName);
	}

	default MethodHeader<C> privateStaticMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PRIVATE, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<C> privateStaticMethod(String methodName) {
		return staticMethod(ACC_STATIC + ACC_PRIVATE, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<C> privateStaticMethod(String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PRIVATE, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<C> privateStaticMethod(Type returnType, String methodName) {
		return staticMethod(ACC_STATIC + ACC_PRIVATE, returnType, methodName);
	}

	default MethodHeader<C> privateStaticMethod(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PRIVATE, returnType, methodName, exceptionClasses);
	}

	default MethodHeader<C> protectdStaticMethod(Class<?> returnClass, String methodName) {
		return staticMethod(ACC_STATIC + ACC_PROTECTED, typeOf(returnClass), methodName);
	}

	default MethodHeader<C> protectdStaticMethod(Class<?> returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PROTECTED, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<C> protectdStaticMethod(String methodName) {
		return staticMethod(ACC_STATIC + ACC_PROTECTED, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<C> protectdStaticMethod(String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PROTECTED, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<C> protectdStaticMethod(Type returnType, String methodName) {
		return staticMethod(ACC_STATIC + ACC_PROTECTED, returnType, methodName);
	}

	default MethodHeader<C> protectdStaticMethod(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PROTECTED, returnType, methodName, exceptionClasses);
	}

	default MethodHeader<C> publicStaticMethod(Class<?> returnClass, String methodName) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, typeOf(returnClass), methodName);
	}

	default MethodHeader<C> publicStaticMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<C> publicStaticMethod(String methodName) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<C> publicStaticMethod(String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<C> publicStaticMethod(Type returnType, String methodName) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, returnType, methodName);
	}

	default MethodHeader<C> publicStaticMethod(Type returnType, boolean array, String methodName) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, arrayOf(returnType, array), methodName);
	}

	default MethodHeader<C> publicStaticMethod(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, returnType, methodName, exceptionClasses);
	}

	default MethodHeader<C> staticMethod(Class<?> returnClass, String methodName) {
		return staticMethod(ACC_STATIC, typeOf(returnClass), methodName);
	}

	default MethodHeader<C> staticMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<C> staticMethod(int access, Class<?> returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + access, Type.getType(returnClass), methodName, exceptionClasses);
	}

	MethodHeader<C> staticMethod(int access, Type returnType, String methodName, String[] exceptionClasses);

	default MethodHeader<C> staticMethod(int access, Type returnType, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(access, returnType, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<C> staticMethod(String methodName) {
		return staticMethod(ACC_STATIC, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<C> staticMethod(String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<C> staticMethod(Type returnType, String methodName) {
		return staticMethod(ACC_STATIC, returnType, methodName);
	}

	default MethodHeader<C> staticMethod(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC, returnType, methodName, exceptionClasses);
	}

}
