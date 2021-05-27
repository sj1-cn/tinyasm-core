package cn.sj1.tinyasm.core.advasmproxy.simple;
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

import cn.sj1.tinyasm.core.advasmproxy.simple.SimplePojoClass;
import cn.sj1.tinyasm.core.advasmproxy.simple.SimpleSuperClass;
import cn.sj1.tinyasm.core.advasmproxy.simple.SimpleSuperInterface;

@SuppressWarnings("unused")
public class SimplePojoClassUsingSampleTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new SimplePojoClassUsingSampleTinyAsmDump().build("cn.sj1.tinyasm.core.advasmproxy.simple.SimplePojoClassUsingSample");
	}

	public byte[] build(String className) throws Exception {
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
		code.NEW(SimplePojoClass.class);
		code.DUP();
		code.SPECIAL(SimplePojoClass.class, "<init>").INVOKE();
		code.STORE("referedObject",SimplePojoClass.class);

		code.LINE();
		code.LOAD("referedObject");
		code.VIRTUAL(SimplePojoClass.class, "sayHello").INVOKE();

		code.LINE();
		code.LOAD("referedObject");
		code.VIRTUAL(SimplePojoClass.class, "getHelloString")
			.return_(String.class).INVOKE();
		code.STORE("helloString",String.class);

		code.LINE();
		code.LOAD("referedObject");
		code.LOADConst("sayNothing");
		code.VIRTUAL(SimplePojoClass.class, "setHelloString")
			.parameter(String.class).INVOKE();

		code.LINE();
		code.LOAD("referedObject");
		code.LOAD("helloString");
		code.VIRTUAL(SimplePojoClass.class, "setHelloString")
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
		code.VIRTUAL(SimplePojoClass.class, "setHelloString")
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
