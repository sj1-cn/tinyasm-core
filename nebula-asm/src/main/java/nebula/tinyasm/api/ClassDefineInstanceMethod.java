package nebula.tinyasm.api;

import static nebula.tinyasm.util.TypeUtils.namesOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

import org.objectweb.asm.Type;

public interface ClassDefineInstanceMethod<MC>  {

	default MethodHeader<MC> method(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(0, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> method(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return mvMethod(0, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

//	MethodHeader<C> method(int access, String name, String desc, String signature, String[] exceptions);

	default MethodHeader<MC> method(int access, Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return mvMethod(access, Type.getType(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> method(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(0, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> method(String methodName, Class<?>... exceptionClasses) {
		return mvMethod(0, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	MethodHeader<MC> mvMethod(int access, Type returnType, String methodName, String[] exceptionClasses);

	default MethodHeader<MC> privateMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PRIVATE, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> privateMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PRIVATE, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> privateMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PRIVATE, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> privateMethod(String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PRIVATE, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> protectdMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PROTECTED, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> protectdMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PROTECTED, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> protectdMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PROTECTED, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> protectdMethod(String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PROTECTED, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> publicMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PUBLIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> publicMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PUBLIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> publicMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PUBLIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader<MC> publicMethod(String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PUBLIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

}
