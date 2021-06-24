package cn.sj1.tinyasm.core.util;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;

import cn.sj1.tinyasm.core.Annotation;
import cn.sj1.tinyasm.core.ClassBody;
import cn.sj1.tinyasm.core.ClassBuilder;
import cn.sj1.tinyasm.core.Clazz;
import cn.sj1.tinyasm.core.MethodCode;

@SuppressWarnings("unused")
public class SimpleSampleTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new SimpleSampleTinyAsmDump().build("cn.sj1.tinyasm.core.util.SimpleSample");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
				.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.field("i", Clazz.of(int.class));
		__init_(classBody);
		_dd(classBody);
		_methodWith1Param(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();

		code.LINE();
		code.LOAD("this");
		code.LOADConst(0);
		code.PUTFIELD("i", int.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _dd(ClassBody classBody) {
		MethodCode code = classBody.public_().method("dd").begin();

		code.LINE();
		code.LOADConst(1);
		code.STORE("j", int.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("j");
		code.LOADConst(1);
		code.ADD();
		code.PUTFIELD("i", int.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _methodWith1Param(ClassBody classBody) {
		MethodCode code = classBody.public_().method("methodWith1Param")
				.parameter("i", int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("i");
		code.PUTFIELD("i", int.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
