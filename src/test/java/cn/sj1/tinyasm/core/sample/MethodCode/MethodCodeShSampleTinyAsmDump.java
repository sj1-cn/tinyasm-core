package cn.sj1.tinyasm.core.sample.MethodCode;

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
public class MethodCodeShSampleTinyAsmDump {

	public static byte[] dump() {
		return new MethodCodeShSampleTinyAsmDump().build("cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeShSample");
	}

	public byte[] build(String className)  {
		ClassBody classBody = ClassBuilder.class_(className)
				.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_getAll(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _getAll(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAll").begin();

		code.LINE();
		code.LOADConst(1);
		code.STORE("i", int.class);

		code.LINE();
		code.LOADConst(1L);
		code.STORE("l", long.class);

		code.LINE();
		code.LOAD("i");
		code.LOADConst(10);
		code.SHR();
		code.STORE("i");

		code.LINE();
		code.LOAD("l");
		code.LOADConst(10);
		code.SHR();
		code.STORE("l");

		code.LINE();
		code.LOAD("i");
		code.LOADConst(4);
		code.SHL();
		code.STORE("i");

		code.LINE();
		code.LOAD("l");
		code.LOADConst(4);
		code.SHL();
		code.STORE("l");

		code.LINE();
		code.LOAD("i");
		code.LOADConst(10);
		code.OR();
		code.STORE("i");

		code.LINE();
		code.LOAD("i");
		code.LOADConst(10);
		code.AND();
		code.STORE("i");

		code.LINE();
		code.LOAD("l");
		code.LOADConst(Long.valueOf(10L));
		code.OR();
		code.STORE("l");

		code.LINE();
		code.LOAD("l");
		code.LOADConst(Long.valueOf(10L));
		code.AND();
		code.STORE("l");

		code.LINE();
		code.RETURN();

		code.END();
	}

}
