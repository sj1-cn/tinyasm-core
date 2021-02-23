package cc1sj.tinyasm;

import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

interface WithMakeInstanceMethod {

	default MethodHeader privateMethod(Class<?> returnClass, String name) {
		return method(ACC_PRIVATE, Clazz.of(returnClass), name);
	}

	default MethodHeader privateMethod(String returnClass, String name) {
		return method(ACC_PRIVATE, Clazz.of(returnClass), name);
	}

	default MethodHeader privateMethod(String name) {
		return method(ACC_PRIVATE, name);
	}

	default MethodHeader protectdMethod(Class<?> returnClass, String name) {
		return method(ACC_PROTECTED, Clazz.of(returnClass), name);
	}

	default MethodHeader protectdMethod(String name) {
		return method(ACC_PROTECTED, name);
	}

	default MethodHeader protectdMethod(String returnClass, String name) {
		return method(ACC_PROTECTED, Clazz.of(returnClass), name);
	}

	default MethodHeader publicMethod(Class<?> returnClass, String name) {
		return method(ACC_PUBLIC, Clazz.of(returnClass), name);
	}

	default MethodHeader publicMethod(Clazz returnClass, String name) {
		return method(ACC_PUBLIC, returnClass, name);
	}

	default MethodHeader publicMethod(String name) {
		return method(ACC_PUBLIC, name);
	}

	default MethodHeader publicMethod(String returnClass, String name) {
		return method(ACC_PUBLIC, Clazz.of(returnClass), name);
	}

	default MethodHeader method(Class<?> returnClass, String name) {
		return method(ACC_PUBLIC, Clazz.of(returnClass), name);
	}

	default MethodHeader method(int access, Class<?> returnClass, String name) {
		return method(access, Clazz.of(returnClass), name);
	}

	MethodHeader method(int access, String name);

	MethodHeader method(int access, Clazz returnType, String name);
	
//	MethodHeader method(int access, Clazz returnType, String name,Clazz... params) {
//		MethodHeader mh = method(access, returnType, name);
//		for (int i = 0; i < params.length; i++) {
//			mh.parameter(null)
//			
//		}
//		return method(access, returnType, name).pa
//	}

	default MethodHeader method(String name) {
		return method(ACC_PUBLIC, name);
	}

	default MethodHeader method(String returnType, String name) {
		return method(ACC_PUBLIC, Clazz.of(returnType), name);
	}

}
