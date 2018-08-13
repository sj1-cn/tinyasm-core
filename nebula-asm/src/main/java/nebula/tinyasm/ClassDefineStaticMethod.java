package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.namesOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

import org.objectweb.asm.Type;

public interface ClassDefineStaticMethod {

	MethodHeaderAdv<MethodStaticCode> mvStaticMethod(int access, Type returnType, String methodName, String[] exceptionClasses);

	default MethodHeaderAdv<MethodStaticCode> privateStaticMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PRIVATE, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> privateStaticMethod(Class<?> returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PRIVATE, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> privateStaticMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PRIVATE, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> privateStaticMethod(String methodName, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PRIVATE, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> protectdStaticMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PROTECTED, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> protectdStaticMethod(Class<?> returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PROTECTED, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> protectdStaticMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PROTECTED, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> protectdStaticMethod(String methodName, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PROTECTED, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> publicStaticMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PUBLIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> publicStaticMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PUBLIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> publicStaticMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PUBLIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> publicStaticMethod(String methodName, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PUBLIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> staticMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> staticMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> staticMethod(int access, Class<?> returnClass, String methodName,
			Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + access, Type.getType(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> staticMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodStaticCode> staticMethod(String methodName, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

}
