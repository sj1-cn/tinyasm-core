package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.namesOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

import org.objectweb.asm.Type;

public interface ClassDefineStaticMethod {

	MethodHeader<MethodCode> mvStaticMethod(int access, Type returnType, String name, String[] exceptionClasses);

	default MethodHeader<MethodCode> privateStaticMethod(Class<?> returnClass, String name) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PRIVATE, typeOf(returnClass), name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> privateStaticMethod(Class<?> returnClass, String name,
			Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PRIVATE, typeOf(returnClass), name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> privateStaticMethod(String name) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PRIVATE, Type.VOID_TYPE, name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> privateStaticMethod(String name, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PRIVATE, Type.VOID_TYPE, name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> protectdStaticMethod(Class<?> returnClass, String name) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PROTECTED, typeOf(returnClass), name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> protectdStaticMethod(Class<?> returnClass, String name,
			Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PROTECTED, typeOf(returnClass), name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> protectdStaticMethod(String name) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PROTECTED, Type.VOID_TYPE, name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> protectdStaticMethod(String name, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PROTECTED, Type.VOID_TYPE, name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> publicStaticMethod(Class<?> returnClass, String name) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PUBLIC, typeOf(returnClass), name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> publicStaticMethod(Class<?> returnClass, String name,
			Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PUBLIC, typeOf(returnClass), name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> publicStaticMethod(String name) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC + ACC_PUBLIC, Type.VOID_TYPE, name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> publicStaticMethod(String name, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + ACC_PUBLIC, Type.VOID_TYPE, name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> staticMethod(Class<?> returnClass, String name) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC, typeOf(returnClass), name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> staticMethod(Class<?> returnClass, String name,
			Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC, typeOf(returnClass), name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> staticMethod(int access, Class<?> returnClass, String name,
			Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC + access, Type.getType(returnClass), name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> staticMethod(String name) {
		Class<?>[] exceptionClasses = {};
		return mvStaticMethod(ACC_STATIC, Type.VOID_TYPE, name, namesOf(exceptionClasses));
	}

	default MethodHeader<MethodCode> staticMethod(String name, Class<?>... exceptionClasses) {
		return mvStaticMethod(ACC_STATIC, Type.VOID_TYPE, name, namesOf(exceptionClasses));
	}

}
