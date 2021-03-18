package cn.sj1.tinyasm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

public interface ClassBuilder {
	static public ClassHeader class_(ClassVisitor classWriter, String clazz) {
		return new ClassHeaderImpl(classWriter, clazz);
	}

	static public ClassHeader class_(ClassVisitor classWriter, String clazz, String superClazz) {
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz));
	}

	static public ClassHeader class_(ClassVisitor classWriter, String clazz, Class<?> superClazz) {
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz));
	}

	static public ClassHeader class_(ClassVisitor classWriter, String clazz, String superClazz, String interfaceType) {
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz)).implements_(interfaceType);
	}

	static public ClassHeader class_(ClassVisitor classWriter, String clazz, Class<?> superClazz, Class<?> interfaceType) {
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz)).implements_(interfaceType);
	}

	static public ClassHeader class_(String clazz) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz);
	}

	static public ClassHeader class_(String clazz, String superClazz) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz));
	}

	static public ClassHeader class_(String clazz, Class<?> superClazz) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz));
	}

	static public ClassHeader class_(String clazz, Class<?> superClazz, Class<?>... interfaceTypes) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		ClassHeader ch = new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz));
		for (Class<?> interfaceType : interfaceTypes) {
			ch.implements_(interfaceType);
		}
		return ch;
	}

	static public ClassHeader class_(String clazz, Clazz superClazz, Clazz... interfaceType) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz, superClazz).implements_(interfaceType);
	}

	static public ClassHeader class_(String clazz, Clazz superClazz) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz, superClazz);
	}

	static public ClassHeader class_(String clazz, String superClazz, String interfaceType) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz)).implements_(interfaceType);
	}

	static public ClassHeader class_(String clazz, Class<?> superClazz, String interfaceType) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz)).implements_(interfaceType);
	}

	static public ClassHeader class_(String clazz, Class<?> superClazz, Class<?> interfaceType) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz, Clazz.of(superClazz)).implements_(interfaceType);
	}

	public byte[] toByteArray();
}
