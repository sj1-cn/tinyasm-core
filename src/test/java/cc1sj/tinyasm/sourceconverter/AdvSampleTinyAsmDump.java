package cc1sj.tinyasm.sourceconverter;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.sourceconverter.SuperClass;
import cc1sj.tinyasm.sourceconverter.SuperInterface;
import cc1sj.tinyasm.sourceconverter.ReferedObject;

import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;

import java.lang.String;
@SuppressWarnings("unused")
public class AdvSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new AdvSampleTinyAsmDump().dump("cc1sj.tinyasm.heroadv.AdvSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className, SuperClass.class, SuperInterface.class)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.field("name", Clazz.of(String.class));
		__init_(classBody);
		_sayHello(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(SuperClass.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _sayHello(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("sayHello").begin();

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
		code.NEW(ReferedObject.class);
		code.DUP();
		code.SPECIAL(ReferedObject.class, "<init>").INVOKE();
		code.STORE("advSampleReferObject",ReferedObject.class);

		code.LINE();
		code.LOAD("advSampleReferObject");
		code.VIRTUAL(ReferedObject.class, "sayHello").INVOKE();

		code.LINE();
		code.LOAD("advSampleReferObject");
		code.VIRTUAL(ReferedObject.class, "getHelloString")
			.reTurn(String.class).INVOKE();
		code.STORE("helloString",String.class);

		code.LINE();
		code.LOAD("advSampleReferObject");
		code.LOADConst("sayNothing");
		code.VIRTUAL(ReferedObject.class, "setHelloString")
			.parameter(String.class).INVOKE();

		code.LINE();
		code.LOAD("advSampleReferObject");
		code.LOAD("helloString");
		code.VIRTUAL(ReferedObject.class, "setHelloString")
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

		code.LINE();
		Label label12OfGOTO = new Label();
		code.GOTO(label12OfGOTO);

		code.visitLabel(label9OfIF_ICMPLE);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");

		code.visitLabel(label12OfGOTO);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");

		code.LINE();
		Label label14OfGOTO = new Label();
		code.GOTO(label14OfGOTO);
		Label label16OfIF_ICMPGT = new Label();

		code.visitLabel(label16OfIF_ICMPGT);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");

		code.visitLabel(label14OfGOTO);

		code.LINE();
		code.LOAD("j");
		code.LOADConst(10);
		code.IF_ICMPGT(label16OfIF_ICMPGT);
		Label label19OfIF_ICMPGT = new Label();

		code.visitLabel(label19OfIF_ICMPGT);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");

		code.LINE();
		code.LOAD("j");
		code.LOADConst(10);

		code.LINE();
		code.IF_ICMPGT(label19OfIF_ICMPGT);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
