package cc1sj.tinyasm.sourceconverter;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import org.objectweb.asm.Label;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.hero.helperclass.SimplePojoClassSample;
@SuppressWarnings("unused")
public class UsingSimplePojoClassSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new UsingSimplePojoClassSampleTinyAsmDump().dump("cc1sj.tinyasm.sourceconverter.UsingSimplePojoClassSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className, SimpleSuperClass.class, SimpleSuperInterface.class)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.private_().field("name", Clazz.of(String.class));
		__init_(classBody);
		_sayHello(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(SimpleSuperClass.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _sayHello(ClassBody classBody) {
		MethodCode code = classBody.public_().method("sayHello").begin();

		code.LINE();
		code.LOADConst(10);
		code.STORE("i",int.class);

		code.LINE();
		code.LOADConst(20);
		code.STORE("j",int.class);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");

		code.LINE();
		code.NEW(SimplePojoClassSample.class);
		code.DUP();
		code.SPECIAL(SimplePojoClassSample.class, "<init>").INVOKE();
		code.STORE("referedObject",SimplePojoClassSample.class);

		code.LINE();
		code.LOAD("referedObject");
		code.VIRTUAL(SimplePojoClassSample.class, "sayHello").INVOKE();

		code.LINE();
		code.LOAD("referedObject");
		code.VIRTUAL(SimplePojoClassSample.class, "getHelloString")
			.return_(String.class).INVOKE();
		code.STORE("helloString",String.class);

		code.LINE();
		code.LOAD("referedObject");
		code.LOADConst("sayNothing");
		code.VIRTUAL(SimplePojoClassSample.class, "setHelloString")
			.parameter(String.class).INVOKE();

		code.LINE();
		code.LOAD("referedObject");
		code.LOAD("helloString");
		code.VIRTUAL(SimplePojoClassSample.class, "setHelloString")
			.parameter(String.class).INVOKE();

		code.LINE();
		code.LOAD("j");
		code.LOADConst(10);
		Label label9OfIF_ICMPLE = new Label();
		code.IF_ICMPLE(label9OfIF_ICMPLE);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");
		Label label11OfGOTO = new Label();
		code.GOTO(label11OfGOTO);

		code.visitLabel(label9OfIF_ICMPLE);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");

		code.visitLabel(label11OfGOTO);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");
		Label label15OfGOTO = new Label();

		code.visitLabel(label15OfGOTO);

		code.LINE();
		code.LOAD("j");
		code.LOADConst(10);
		Label label13OfIF_ICMPLE = new Label();
		code.IF_ICMPLE(label13OfIF_ICMPLE);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");
		code.GOTO(label15OfGOTO);

		code.visitLabel(label13OfIF_ICMPLE);

		code.LINE();
		code.LOAD("referedObject");
		code.LOAD("helloString");
		code.VIRTUAL(SimplePojoClassSample.class, "setHelloString")
			.parameter(String.class).INVOKE();
		Label label17OfIF_ICMPGT = new Label();

		code.visitLabel(label17OfIF_ICMPGT);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");

		code.LINE();
		code.LOAD("j");
		code.LOADConst(10);
		code.IF_ICMPGT(label17OfIF_ICMPGT);

		code.LINE();
		code.LOADConst(0);
		code.STORE("k",int.class);
		Label label22OfGOTO = new Label();

		code.visitLabel(label22OfGOTO);

		code.LINE();
		code.LOAD("k");
		code.LOADConst(10);
		Label label19OfIF_ICMPLE = new Label();
		code.IF_ICMPLE(label19OfIF_ICMPLE);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");

		code.LINE();
		code.IINC("k", 1);
		code.GOTO(label22OfGOTO);

		code.visitLabel(label19OfIF_ICMPLE);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
