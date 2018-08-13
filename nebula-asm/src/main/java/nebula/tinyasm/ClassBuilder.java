package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

public interface ClassBuilder {
	static public ClassHeader make(Class<?> objectType) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassBuilderImpl(ACC_PUBLIC + ACC_SUPER, classWriter, typeOf(objectType), typeOf(Object.class));
	}

	static public ClassHeader make(Class<?> objectType, Class<?> superType) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassBuilderImpl(ACC_PUBLIC + ACC_SUPER, classWriter, typeOf(objectType), typeOf(superType));
	}

	static public ClassHeader make(ClassVisitor classWriter, String typename) {
		return new ClassBuilderImpl(ACC_PUBLIC + ACC_SUPER, classWriter, typeOf(typename), typeOf(Object.class));
	}

	static public ClassHeader make(final int access, Class<?> objectType, Class<?> superType) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassBuilderImpl(access, classWriter, typeOf(objectType), typeOf(superType));
	}

	static public ClassHeader make(final int access, Class<?> objectType, Class<?> superType, Class<?> interfaceType,
			Class<?>[] interfaceSignature) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassBuilderImpl(access, classWriter, typeOf(objectType), typeOf(superType), typeOf(interfaceType),
				typeOf(interfaceSignature));
	}

	static public ClassHeader make(final int access, String objectType, String superType, String interfaceType,
			String[] interfaceSignature) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassBuilderImpl(access, classWriter, typeOf(objectType), typeOf(superType), typeOf(interfaceType),
				typeOf(interfaceSignature));
	}

	static public ClassHeader make(final int access, Class<?> objectType, Class<?> superType,
			Class<?>[] superTypeSignature) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassBuilderImpl(access, classWriter, typeOf(objectType), typeOf(superType),
				typeOf(superTypeSignature));
	}

	static public ClassHeader make(final int access, String objectType, String superType, String[] superTypeSignature) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassBuilderImpl(access, classWriter, typeOf(objectType), typeOf(superType),
				typeOf(superTypeSignature));
	}

	static public ClassHeader make(String typename) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassBuilderImpl(ACC_PUBLIC + ACC_SUPER, classWriter, typeOf(typename), typeOf(Object.class));
	}

	public byte[] toByteArray();
}
