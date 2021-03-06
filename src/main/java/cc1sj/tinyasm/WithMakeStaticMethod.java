package cc1sj.tinyasm;

import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

public interface WithMakeStaticMethod {

	default MethodHeader privateStaticMethod(Class<?> returnClass, String name) {
		return staticMethod(ACC_STATIC + ACC_PRIVATE, Clazz.of(returnClass), name);
	}

	default MethodHeader privateStaticMethod(String name) {
		return staticMethod(ACC_STATIC + ACC_PRIVATE, name);
	}

	default MethodHeader privateStaticMethod(String returnClass, String name) {
		return staticMethod(ACC_STATIC + ACC_PRIVATE, Clazz.of(returnClass), name);
	}

	default MethodHeader protectdStaticMethod(Class<?> returnClass, String name) {
		return staticMethod(ACC_STATIC + ACC_PROTECTED, Clazz.of(returnClass), name);
	}

	default MethodHeader protectdStaticMethod(String name) {
		return staticMethod(ACC_STATIC + ACC_PROTECTED, name);
	}

	default MethodHeader protectdStaticMethod(String returnClass, String name) {
		return staticMethod(ACC_STATIC + ACC_PROTECTED, Clazz.of(returnClass), name);
	}

	default MethodHeader publicStaticMethod(Class<?> returnClass, String name) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, Clazz.of(returnClass), name);
	}

	default MethodHeader publicStaticMethod(String name) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, name);
	}

	default MethodHeader publicStaticMethod(String returnClass, String name) {
		return staticMethod(ACC_STATIC + ACC_PUBLIC, Clazz.of(returnClass), name);
	}

	default MethodHeader staticMethod(String name) {
		return staticMethod(ACC_STATIC, name);
	}

	default MethodHeader staticMethod(String returnType, String name) {
		return staticMethod(ACC_STATIC, Clazz.of(returnType), name);
	}

	default MethodHeader staticMethod(Class<?> returnClass, String name) {
		return staticMethod(ACC_STATIC, Clazz.of(returnClass), name);
	}

	default MethodHeader staticMethod(int access, Class<?> returnClass, String name) {
		return staticMethod(access, Clazz.of(returnClass), name);
	}

	MethodHeader staticMethod(int access, String name);

	MethodHeader staticMethod(int access, Clazz returnType, String name);

}
