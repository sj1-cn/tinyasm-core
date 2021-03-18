package cn.sj1.tinyasm.util;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import cn.sj1.tinyasm.ClassBody;
import cn.sj1.tinyasm.ClassBuilder;
import cn.sj1.tinyasm.Clazz;
import cn.sj1.tinyasm.MethodCode;
@SuppressWarnings("unused")
public class SimpleSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new SimpleSampleTinyAsmDump().dump("cn.sj1.tinyasm.util.SimpleSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.private_().field("i", Clazz.of(int.class));
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
		code.PUTFIELD_OF_THIS("i");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _dd(ClassBody classBody) {
		MethodCode code = classBody.public_().method("dd").begin();

		code.LINE();
		code.LOADConst(1);
		code.STORE("j",int.class);

		code.LINE();
		code.LOADConst(1);
		code.STORE("k",int.class);

		code.LINE();
		code.LOAD("j");
		code.LOADConst(10);
		code.ADD();
		code.STORE("k1",int.class);

		code.LINE();
		code.LOAD("k1");
		code.LOADConst(10);
		code.ADD();
		code.STORE("j1",int.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _methodWith1Param(ClassBody classBody) {
		MethodCode code = classBody.public_().method("methodWith1Param")
			.parameter("i",int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("i");
		code.PUTFIELD_OF_THIS("i");

		code.LINE();
		code.RETURN();

		code.END();
	}

}
