package cc1sj.tinyasm;

import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;

public interface UsingAccess<T> {

	T access(int access);

	default T public_() {
		return access(ACC_PUBLIC);
	}

	default T private_() {
		return access(ACC_PRIVATE);

	}

	default T protected_() {
		return access(ACC_PROTECTED);
	}

	default T static_() {
		return access(ACC_STATIC);
	}

	default T bridge() {
		access(ACC_PUBLIC);
		access(ACC_SYNTHETIC);
		return access(ACC_BRIDGE);
	}

}
