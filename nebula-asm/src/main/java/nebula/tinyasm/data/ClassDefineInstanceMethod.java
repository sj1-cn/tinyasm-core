package nebula.tinyasm.data;

import static nebula.tinyasm.util.TypeUtils.namesOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

import org.objectweb.asm.Type;

interface ClassDefineInstanceMethod {

	default MethodHeader method(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PUBLIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader method(Class<?> returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return mvMethod(ACC_PUBLIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader method(int access, Class<?> returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return mvMethod(access, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader method(int access, String returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return mvMethod(access, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader method(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PUBLIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader method(String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PUBLIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	MethodHeader mvMethod(int access, Type returnType, String methodName,
			String... exceptionClasses);

	default MethodHeader privateMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PRIVATE, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader privateMethod(Class<?> returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return mvMethod(ACC_PRIVATE, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader privateMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PRIVATE, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader privateMethod(String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PRIVATE, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader protectdMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PROTECTED, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader protectdMethod(Class<?> returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return mvMethod(ACC_PROTECTED, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader protectdMethod(String returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return mvMethod(ACC_PROTECTED, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader protectdMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PROTECTED, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader protectdMethod(String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PROTECTED, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader publicMethod(String returnClass, String methodName) {
		return mvMethod(ACC_PUBLIC, typeOf(returnClass), methodName);
	}

	default MethodHeader publicMethod(Class<?> returnClass, String methodName) {
		return mvMethod(ACC_PUBLIC, typeOf(returnClass), methodName);
	}

	default MethodHeader publicMethod(Class<?> returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return mvMethod(ACC_PUBLIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader publicMethod(String returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return mvMethod(ACC_PUBLIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeader publicMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PUBLIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeader publicMethod(String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PUBLIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

}
