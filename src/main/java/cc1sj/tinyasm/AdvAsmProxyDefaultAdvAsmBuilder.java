package cc1sj.tinyasm;

import org.objectweb.asm.ClassVisitor;

public abstract class AdvAsmProxyDefaultAdvAsmBuilder extends ClassVisitor {

	public AdvAsmProxyDefaultAdvAsmBuilder(int api) {
		super(api);
	}

	public AdvAsmProxyDefaultAdvAsmBuilder(int api, ClassVisitor classVisitor) {
		super(api, classVisitor);
	}

}