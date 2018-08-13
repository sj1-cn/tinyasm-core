package nebula.tinyasm.api;

import static nebula.tinyasm.util.TypeUtils.namesOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

import org.objectweb.asm.Type;

public interface ClassDefineStaticMethod<MC> {

	MethodHeader<MC> mvStaticMethod(int access, Type returnType, String methodName, String[] exceptionClasses);

	default MethodHeader<MC> privateStaticMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PRIVATE, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> privateStaticMethod(Class<?> returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PRIVATE, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> privateStaticMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PRIVATE, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> privateStaticMethod(String methodName, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PRIVATE, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> protectdStaticMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PROTECTED, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> protectdStaticMethod(Class<?> returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PROTECTED, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> protectdStaticMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PROTECTED, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> protectdStaticMethod(String methodName, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PROTECTED, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> publicStaticMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PUBLIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> publicStaticMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PUBLIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> publicStaticMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PUBLIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> publicStaticMethod(String methodName, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PUBLIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> staticMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> staticMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> staticMethod(int access, Class<?> returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + access, Type.getType(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> staticMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> staticMethod(String methodName, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

}
