package nebula.tinyasm.data;

import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

interface WithMakeInstanceMethod {

	default MethodHeader privateMethod(Class<?> returnClass, String name) {
		return method(ACC_PRIVATE, returnClass.getName(), name);
	}

	default MethodHeader privateMethod(String returnClass, String name) {
		return method(ACC_PRIVATE, returnClass, name);
	}

	default MethodHeader privateMethod(String name) {
		return method(ACC_PRIVATE, name);
	}

	default MethodHeader protectdMethod(Class<?> returnClass, String name) {
		return method(ACC_PROTECTED, returnClass.getName(), name);
	}

	default MethodHeader protectdMethod(String name) {
		return method(ACC_PROTECTED, name);
	}

	default MethodHeader protectdMethod(String returnClass, String name) {
		return method(ACC_PROTECTED, returnClass, name);
	}

	default MethodHeader publicMethod(Class<?> returnClass, String name) {
		return method(ACC_PUBLIC, returnClass.getName(), name);
	}

	default MethodHeader publicMethod(String name) {
		return method(ACC_PUBLIC, name);
	}

	default MethodHeader publicMethod(String returnClass, String name) {
		return method(ACC_PUBLIC, returnClass, name);
	}

	default MethodHeader method(Class<?> returnClass, String name) {
		return method(ACC_PUBLIC, returnClass.getName(), name);
	}

	default MethodHeader method(int access, Class<?> returnClass, String name) {
		return method(access, returnClass.getName(), name);
	}

	MethodHeader method(int access, String name);

	MethodHeader method(int access, String returnType, String name);

	default MethodHeader method(String name) {
		return method(ACC_PUBLIC, name);
	}

	default MethodHeader method(String returnType, String name) {
		return method(ACC_PUBLIC, returnType, name);
	}

}
