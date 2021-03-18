package cn.sj1.tinyasm.advasmproxy.twoparameters;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import cn.sj1.tinyasm.ClassBody;
import cn.sj1.tinyasm.ClassBuilder;
import cn.sj1.tinyasm.MethodCode;
@SuppressWarnings("unused")
public class ObjectWithTwoParametersUsingSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new ObjectWithTwoParametersUsingSampleTinyAsmDump().dump("cn.sj1.tinyasm.advasmproxy.twoparameters.ObjectWithTwoParametersUsingSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_test(classBody);

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

	protected void _test(ClassBody classBody) {
		MethodCode code = classBody.public_().method("test").begin();

		code.LINE();
		code.NEW(ObjectWithTwoParameters.class);
		code.DUP();
		code.LOADConst(3);
		code.LOADConst(3);
		code.SPECIAL(ObjectWithTwoParameters.class, "<init>")
			.parameter(int.class)
			.parameter(int.class).INVOKE();
		code.STORE("p1",ObjectWithTwoParameters.class);

		code.LINE();
		code.LOADConst(10);
		code.STORE("i",int.class);

		code.LINE();
		code.LOADConst(20);
		code.STORE("j",int.class);

		code.LINE();
		code.NEW(ObjectWithTwoParameters.class);
		code.DUP();
		code.LOAD("i");
		code.LOAD("j");
		code.SPECIAL(ObjectWithTwoParameters.class, "<init>")
			.parameter(int.class)
			.parameter(int.class).INVOKE();
		code.STORE("p2",ObjectWithTwoParameters.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
