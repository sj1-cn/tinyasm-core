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
public class MethodCodeFieldSampleTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new MethodCodeFieldSampleTinyAsmDump().build("cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeFieldSample");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.private_().field("z", Clazz.of(boolean.class));
		__init_(classBody);
		_getAll(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("z", boolean.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getAll(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAll").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("z", boolean.class);
		Label label1OfIFEQ = new Label();
		code.IFEQ(label1OfIFEQ);
		code.LOADConst(0);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFEQ);
		code.LOADConst(1);

		code.visitLabel(label2OfGOTO);
		code.STORE("z",boolean.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("z");
		Label label4OfIFEQ = new Label();
		code.IFEQ(label4OfIFEQ);
		code.LOADConst(0);
		Label label5OfGOTO = new Label();
		code.GOTO(label5OfGOTO);

		code.visitLabel(label4OfIFEQ);
		code.LOADConst(1);

		code.visitLabel(label5OfGOTO);
		code.PUTFIELD("z", boolean.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
