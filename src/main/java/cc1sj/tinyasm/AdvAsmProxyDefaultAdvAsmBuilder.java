package cc1sj.tinyasm;

import org.objectweb.asm.ClassVisitor;

public abstract class AdvAsmProxyDefaultAdvAsmBuilder extends ClassVisitor {

	public AdvAsmProxyDefaultAdvAsmBuilder(int api) {
		super(api);
	}

	public AdvAsmProxyDefaultAdvAsmBuilder(int api, ClassVisitor classVisitor) {
		super(api, classVisitor);
	}

	protected void _set__Context(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("set__Context")
				.parameter("_contextThreadLocal", Clazz.of(ThreadLocal.class, Clazz.of(AdvContext.class)))
				.parameter("_magicNumber", byte.class).begin();
	
		code.LINE();
		code.LOAD("this");
		code.LOAD("_contextThreadLocal");
		code.PUTFIELD_OF_THIS("_contextThreadLocal");
	
		code.LINE();
		code.LOAD("this");
		code.LOAD("_magicNumber");
		code.PUTFIELD_OF_THIS("_magicNumber");
	
		code.LINE();
		code.RETURN();
	
		code.END();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("<init>").begin();
	
		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Clazz.of(Object.class), "<init>").INVOKE();
		code.RETURN();
	
		code.END();
	}

	protected void _get__MagicNumber(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(byte.class, "get__MagicNumber").begin();
	
		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_magicNumber");
		code.RETURNTop();
	
		code.END();
	}

	protected void _set__MagicNumber(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("set__MagicNumber").parameter("_magicNumber", byte.class).begin();
	
		code.LINE();
		code.LOAD("this");
		code.LOAD("_magicNumber");
		code.PUTFIELD_OF_THIS("_magicNumber");
	
		code.LINE();
		code.RETURN();
	
		code.END();
	}

}