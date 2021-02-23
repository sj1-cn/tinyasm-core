package cc1sj.tinyasm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

public interface ClassBuilder {
	static public ClassHeader make(ClassVisitor classWriter, String clazz) {
		return new ClassHeaderImpl(classWriter, clazz);
	}

	static public ClassHeader make(ClassVisitor classWriter, String clazz, String superClazz) {
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz));
	}

	static public ClassHeader make(ClassVisitor classWriter, String clazz, Class<?> superClazz) {
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz));
	}

	static public ClassHeader make(ClassVisitor classWriter, String clazz, String superClazz, String interfaceType) {
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz)).implement(interfaceType);
	}

	static public ClassHeader make(ClassVisitor classWriter, String clazz, Class<?> superClazz,
			Class<?> interfaceType) {
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz)).implement(interfaceType);
	}

	static public ClassHeader make(String clazz) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz);
	}

	static public ClassHeader make(String clazz, String superClazz) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz));
	}

	static public ClassHeader make(String clazz, Class<?> superClazz) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz));
	}

	static public ClassHeader make(String clazz, Clazz superClazz, Clazz... interfaceType) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz, superClazz).implement(interfaceType);
	}
	static public ClassHeader make(String clazz, Clazz superClazz) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz, superClazz);
	}
	
	static public ClassHeader make(String clazz, String superClazz, String interfaceType) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz)).implement(interfaceType);
	}

	static public ClassHeader make(String clazz, Class<?> superClazz, String interfaceType) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz)).implement(interfaceType);
	}

	static public ClassHeader make(String clazz, Class<?> superClazz, Class<?> interfaceType) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz)).implement(interfaceType);
	}

	public byte[] toByteArray();
}
