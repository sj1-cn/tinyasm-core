package nebula.tinyasm.api;

import static nebula.tinyasm.util.TypeUtils.arrayOf;
import static nebula.tinyasm.util.TypeUtils.namesOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

import org.objectweb.asm.Type;

public interface ClassDefineStaticMethod<MC> {

	default MethodHeader<MC> privateStaticMethod(Class<?> returnClass, String methodName) {
		return staticMethod(ACC_STATIC + ACC_PRIVATE, typeOf(returnClass), methodName);
	}

	default MethodHeader<MC> privateStaticMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PRIVATE, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<MC> privateStaticMethod(String methodName) {
		return staticMethod(ACC_STATIC + ACC_PRIVATE, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<MC> privateStaticMethod(String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PRIVATE, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<MC> privateStaticMethod(Type returnType, String methodName) {
		return staticMethod(ACC_STATIC + ACC_PRIVATE, returnType, methodName);
	}

	default MethodHeader<MC> privateStaticMethod(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PRIVATE, returnType, methodName, exceptionClasses);
	}

	default MethodHeader<MC> protectdStaticMethod(Class<?> returnClass, String methodName) {
		return staticMethod(ACC_STATIC + ACC_PROTECTED, typeOf(returnClass), methodName);
	}

	default MethodHeader<MC> protectdStaticMethod(Class<?> returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PROTECTED, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<MC> protectdStaticMethod(String methodName) {
		return staticMethod(ACC_STATIC + ACC_PROTECTED, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<MC> protectdStaticMethod(String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PROTECTED, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<MC> protectdStaticMethod(Type returnType, String methodName) {
		return staticMethod(ACC_STATIC + ACC_PROTECTED, returnType, methodName);
	}

	default MethodHeader<MC> protectdStaticMethod(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PROTECTED, returnType, methodName, exceptionClasses);
	}

	default MethodHeader<MC> publicStaticMethod(Class<?> returnClass, String methodName) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, typeOf(returnClass), methodName);
	}

	default MethodHeader<MC> publicStaticMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<MC> publicStaticMethod(String methodName) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<MC> publicStaticMethod(String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<MC> publicStaticMethod(Type returnType, String methodName) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, returnType, methodName);
	}

	default MethodHeader<MC> publicStaticMethod(Type returnType, boolean array, String methodName) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, arrayOf(returnType, array), methodName);
	}

	default MethodHeader<MC> publicStaticMethod(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, returnType, methodName, exceptionClasses);
	}

	default MethodHeader<MC> staticMethod(Class<?> returnClass, String methodName) {
		return staticMethod(ACC_STATIC, typeOf(returnClass), methodName);
	}

	default MethodHeader<MC> staticMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC, typeOf(returnClass), methodName, exceptionClasses);
	}

	default MethodHeader<MC> staticMethod(int access, Class<?> returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC + access, Type.getType(returnClass), methodName, exceptionClasses);
	}

	MethodHeader<MC> staticMethod(int access, Type returnType, String methodName, String[] exceptionClasses);

	default MethodHeader<MC> staticMethod(int access, Type returnType, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(access, returnType, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> staticMethod(String methodName) {
		return staticMethod(ACC_STATIC, Type.VOID_TYPE, methodName);
	}

	default MethodHeader<MC> staticMethod(String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC, Type.VOID_TYPE, methodName, exceptionClasses);
	}

	default MethodHeader<MC> staticMethod(Type returnType, String methodName) {
		return staticMethod(ACC_STATIC, returnType, methodName);
	}

	default MethodHeader<MC> staticMethod(Type returnType, String methodName, Class<?>... exceptionClasses) {
		return staticMethod(ACC_STATIC, returnType, methodName, exceptionClasses);
	}

}
