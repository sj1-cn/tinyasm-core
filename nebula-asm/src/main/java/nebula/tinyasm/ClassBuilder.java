package nebula.tinyasm;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;

import nebula.tinyasm.api.ClassHeader;

public interface ClassBuilder {
	static public ClassHeader make() {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassBuilderImpl(classWriter);
	}

	static public ClassHeader make(ClassVisitor cv, Type objectType) {
		return make(ACC_PUBLIC + ACC_SUPER, cv, objectType, Type.getType(Object.class));
	}

	static public Type fromName(String typename) {
		final String internalName = typename.replace('.', '/');
		Type type = Type.getObjectType(internalName);
		return type;
	}

	static public ClassHeader make(String typename) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return make(ACC_PUBLIC + ACC_SUPER, classWriter, fromName(typename), Type.getType(Object.class));
	}

	static public ClassHeader make(ClassVisitor classWriter, String typename) {
		return make(ACC_PUBLIC + ACC_SUPER, classWriter, fromName(typename), Type.getType(Object.class));
	}

	static public ClassHeader make(ClassVisitor cv, Type objectType, Type superType) {
		return new ClassBuilderImpl(ACC_PUBLIC + ACC_SUPER, cv, objectType, superType);
	}

	static public ClassHeader make(ClassVisitor cv, Type objectType, Type superType, Class<?> interfaceClass,
			Type[] interfaceSignature) {
		return make(cv, objectType, superType, Type.getType(interfaceClass), interfaceSignature);
	}

	static public ClassHeader make(ClassVisitor cv, Type objectType, Type superType, Type interfaceType,
			Type[] interfaceSignature) {
		return new ClassBuilderImpl(ACC_PUBLIC + ACC_SUPER, cv, objectType, superType, interfaceType,
				interfaceSignature);
	}

	static public ClassHeader make(ClassVisitor cv, Type objectType, Type superType, Type[] superTypeSignature) {
		return new ClassBuilderImpl(ACC_PUBLIC + ACC_SUPER, cv, objectType, superType, superTypeSignature);
	}

	static public ClassHeader make(final int access, ClassVisitor cv, Type objectType) {
		return make(access, cv, objectType, Type.getType(Object.class));
	}

	static public ClassHeader make(final int access, ClassVisitor cv, Type objectType, Type superType) {
		return new ClassBuilderImpl(access, cv, objectType, superType);
	}

	static public ClassHeader make(final int access, ClassVisitor cv, Type objectType, Type superType, Type interfaceType,
			Type[] interfaceSignature) {
		return new ClassBuilderImpl(access, cv, objectType, superType, interfaceType, interfaceSignature);
	}

	static public ClassHeader make(final int access, Type objectType) {
		return make(access, objectType, Type.getType(Object.class));
	}

	static public ClassHeader make(final int access, Type objectType, Class<?> superClass, Class<?> interfaceClass,
			Type[] interfaceSignature) {
		return make(access, objectType, Type.getType(superClass), Type.getType(interfaceClass), interfaceSignature);
	}

	static public ClassHeader make(final int access, Type objectType, Class<?> superClass, Type interfaceType,
			Type[] interfaceSignature) {
		return make(access, objectType, Type.getType(superClass), interfaceType, interfaceSignature);
	}

	static public ClassHeader make(final int access, Type objectType, Type superType) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassBuilderImpl(access, classWriter, objectType, superType);
	}

	static public ClassHeader make(final int access, Type objectType, Type superType, Type interfaceType,
			Type[] interfaceSignature) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassBuilderImpl(access, classWriter, objectType, superType, interfaceType, interfaceSignature);
	}

	static public ClassHeader make(final int access, Type objectType, Type superType, Type[] superTypeSignature) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassBuilderImpl(access, classWriter, objectType, superType, superTypeSignature);
	}

	static public ClassHeader make(Type objectType) {
		return make(ACC_PUBLIC + ACC_SUPER, objectType, Type.getType(Object.class));
	}

	static public ClassHeader make(Type objectType, Type superType) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassBuilderImpl(ACC_PUBLIC + ACC_SUPER, classWriter, objectType, superType);
	}

	public byte[] toByteArray();
}
