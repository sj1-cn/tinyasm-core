package cc1sj.tinyasm.hero.advasmproxy;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.hero.helperclass.ObjectWithTwoParametersSample;
@SuppressWarnings("unused")
public class UsingObjectWithTwoParametersSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new UsingObjectWithTwoParametersSampleTinyAsmDump().dump("cc1sj.tinyasm.hero.advasmproxy.UsingObjectWithTwoParametersSample");
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
		code.NEW(ObjectWithTwoParametersSample.class);
		code.DUP();
		code.LOADConst(3);
		code.LOADConst(3);
		code.SPECIAL(ObjectWithTwoParametersSample.class, "<init>")
			.parameter(int.class)
			.parameter(int.class).INVOKE();
		code.STORE("p1",ObjectWithTwoParametersSample.class);

		code.LINE();
		code.LOADConst(10);
		code.STORE("i",int.class);

		code.LINE();
		code.LOADConst(20);
		code.STORE("j",int.class);

		code.LINE();
		code.NEW(ObjectWithTwoParametersSample.class);
		code.DUP();
		code.LOAD("i");
		code.LOAD("j");
		code.SPECIAL(ObjectWithTwoParametersSample.class, "<init>")
			.parameter(int.class)
			.parameter(int.class).INVOKE();
		code.STORE("p2",ObjectWithTwoParametersSample.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
