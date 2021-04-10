package cn.sj1.tinyasm.core;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class MixinClassVisitor extends ClassVisitor {
	String newClassName;
	ClassWriter classWriter;

	public MixinClassVisitor(int api, ClassWriter classWriter, String newClassName) {
		super(api);
		this.newClassName = newClassName;
		this.classWriter = classWriter;
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
		return super.visitMethod(access, name, descriptor, signature, exceptions);
	}

}
