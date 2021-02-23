package cc1sj.tinyasm;

import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_ANNOTATION;
import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
import static org.objectweb.asm.Opcodes.ACC_ENUM;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_INTERFACE;
import static org.objectweb.asm.Opcodes.ACC_MANDATED;
import static org.objectweb.asm.Opcodes.ACC_NATIVE;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_STRICT;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ACC_SYNCHRONIZED;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;
import static org.objectweb.asm.Opcodes.ACC_TRANSIENT;
import static org.objectweb.asm.Opcodes.ACC_VARARGS;
import static org.objectweb.asm.Opcodes.ACC_VOLATILE;

public interface WithAccess<T> {

	T access(int access);

	default T ACC_PUBLIC() {
		return access(ACC_PUBLIC);
	}

	default T ACC_PRIVATE() {
		return access(ACC_PRIVATE);

	}

	default T ACC_PROTECTED() {
		return access(ACC_PROTECTED);

	}

	default T ACC_STATIC() {
		return access(ACC_STATIC);

	}

	default T ACC_FINAL() {
		return access(ACC_FINAL);

	}

	default T ACC_SUPER() {
		return access(ACC_SUPER);

	}

	default T ACC_SYNCHRONIZED() {
		return access(ACC_SYNCHRONIZED);

	}

	default T ACC_VOLATILE() {
		return access(ACC_VOLATILE);

	}
	default T bridge() {
		access(ACC_PUBLIC);
		access(ACC_SYNTHETIC);
		return access(ACC_BRIDGE);
	}
	default T ACC_BRIDGE() {
		return access(ACC_BRIDGE);
	}

	default T ACC_VARARGS() {
		return access(ACC_VARARGS);

	}

	default T ACC_TRANSIENT() {
		return access(ACC_TRANSIENT);

	}

	default T ACC_NATIVE() {
		return access(ACC_NATIVE);

	}

	default T ACC_INTERFACE() {
		return access(ACC_INTERFACE);

	}

	default T ACC_ABSTRACT() {
		return access(ACC_ABSTRACT);

	}

	default T ACC_STRICT() {
		return access(ACC_STRICT);

	}

	default T ACC_SYNTHETIC() {
		return access(ACC_SYNTHETIC);

	}

	default T ACC_ANNOTATION() {
		return access(ACC_ANNOTATION);

	}

	default T ACC_ENUM() {
		return access(ACC_ENUM);

	}

	default T ACC_MANDATED() {
		return access(ACC_MANDATED);

	}

}
