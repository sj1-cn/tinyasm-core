package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.namesOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

import org.objectweb.asm.Type;

interface ClassDefineInstanceMethod  {

	default MethodHeaderAdv<MethodInstanceCode> method(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(0, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodInstanceCode> method(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return mvMethod(0, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

//	MethodHeader<C> method(int access, String name, String desc, String signature, String[] exceptions);

	default MethodHeaderAdv<MethodInstanceCode> method(int access, Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return mvMethod(access, Type.getType(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodInstanceCode> method(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(0, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodInstanceCode> method(String methodName, Class<?>... exceptionClasses) {
		return mvMethod(0, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	MethodHeaderAdv<MethodInstanceCode> mvMethod(int access, Type returnType, String methodName, String[] exceptionClasses);

	default MethodHeaderAdv<MethodInstanceCode> privateMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PRIVATE, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodInstanceCode> privateMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PRIVATE, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodInstanceCode> privateMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PRIVATE, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodInstanceCode> privateMethod(String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PRIVATE, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodInstanceCode> protectdMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PROTECTED, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodInstanceCode> protectdMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PROTECTED, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodInstanceCode> protectdMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PROTECTED, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodInstanceCode> protectdMethod(String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PROTECTED, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodInstanceCode> publicMethod(Class<?> returnClass, String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PUBLIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodInstanceCode> publicMethod(Class<?> returnClass, String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PUBLIC, typeOf(returnClass), methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodInstanceCode> publicMethod(String methodName) {
		Class<?>[] exceptionClasses = {};
		return mvMethod(ACC_PUBLIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

	default MethodHeaderAdv<MethodInstanceCode> publicMethod(String methodName, Class<?>... exceptionClasses) {
		return mvMethod(ACC_PUBLIC, Type.VOID_TYPE, methodName, namesOf(exceptionClasses));
	}

}
