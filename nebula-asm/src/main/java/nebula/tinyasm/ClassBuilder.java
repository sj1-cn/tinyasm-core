package nebula.tinyasm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import nebula.tinyasm.data.ClassHeader;

public interface ClassBuilder {
	static public ClassHeader make(ClassVisitor classWriter, String clazz) {
		return new ClassHeaderImpl(classWriter, clazz);
	}

	static public ClassHeader make(ClassVisitor classWriter, String clazz,String superClazz) {
		return new ClassHeaderImpl(classWriter, clazz,superClazz);
	}

	static public ClassHeader make(ClassVisitor classWriter,String clazz, String superClazz, String interfaceType) {
		return new ClassHeaderImpl(classWriter, clazz,superClazz).imPlements(interfaceType);
	}
	
	static public ClassHeader make(String clazz) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz);
	}

	static public ClassHeader make( String clazz,String superClazz) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz,superClazz);
	}

	static public ClassHeader make(String clazz, String superClazz, String interfaceType) {
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		return new ClassHeaderImpl(classWriter, clazz,superClazz).imPlements(interfaceType);
	}

	public byte[] toByteArray();
}
