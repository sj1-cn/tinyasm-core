package cn.sj1.tinyasm;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import org.objectweb.asm.Label;
@SuppressWarnings("unused")
public class AdvStatement_if_SampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new AdvStatement_if_SampleTinyAsmDump().dump("cn.sj1.tinyasm.AdvStatement_if_Sample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_testIfThen(classBody);
		_testIfThenElse(classBody);

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

	protected void _testIfThen(ClassBody classBody) {
		MethodCode code = classBody.public_().method("testIfThen").begin();

		code.LINE();
		code.LOADConst(20);
		code.STORE("iGT",int.class);

		code.LINE();
		code.LOAD("iGT");
		code.LOADConst(10);
		Label label2OfIF_ICMPLE = new Label();
		code.IF_ICMPLE(label2OfIF_ICMPLE);

		code.LINE();
		code.IINC("iGT", -1);

		code.visitLabel(label2OfIF_ICMPLE);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iGE",int.class);

		code.LINE();
		code.LOAD("iGE");
		code.LOADConst(10);
		Label label5OfIF_ICMPLT = new Label();
		code.IF_ICMPLT(label5OfIF_ICMPLT);

		code.LINE();
		code.IINC("iGE", -1);

		code.visitLabel(label5OfIF_ICMPLT);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iEQ",int.class);

		code.LINE();
		code.LOAD("iEQ");
		code.LOADConst(10);
		Label label8OfIF_ICMPNE = new Label();
		code.IF_ICMPNE(label8OfIF_ICMPNE);

		code.LINE();
		code.IINC("iEQ", 1);

		code.visitLabel(label8OfIF_ICMPNE);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iNE",int.class);

		code.LINE();
		code.LOAD("iNE");
		code.LOADConst(10);
		Label label11OfIF_ICMPEQ = new Label();
		code.IF_ICMPEQ(label11OfIF_ICMPEQ);

		code.LINE();
		code.IINC("iNE", 1);

		code.visitLabel(label11OfIF_ICMPEQ);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iLE",int.class);

		code.LINE();
		code.LOAD("iLE");
		code.LOADConst(10);
		Label label14OfIF_ICMPGT = new Label();
		code.IF_ICMPGT(label14OfIF_ICMPGT);

		code.LINE();
		code.IINC("iLE", 1);

		code.visitLabel(label14OfIF_ICMPGT);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iLT",int.class);

		code.LINE();
		code.LOAD("iLT");
		code.LOADConst(10);
		Label label17OfIF_ICMPGE = new Label();
		code.IF_ICMPGE(label17OfIF_ICMPGE);

		code.LINE();
		code.IINC("iLT", 1);

		code.visitLabel(label17OfIF_ICMPGE);

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _testIfThenElse(ClassBody classBody) {
		MethodCode code = classBody.public_().method("testIfThenElse").begin();

		code.LINE();
		code.LOADConst(20);
		code.STORE("iGT",int.class);

		code.LINE();
		code.LOAD("iGT");
		code.LOADConst(10);
		Label label2OfIF_ICMPLE = new Label();
		code.IF_ICMPLE(label2OfIF_ICMPLE);

		code.LINE();
		code.IINC("iGT", -1);
		Label label4OfGOTO = new Label();
		code.GOTO(label4OfGOTO);

		code.visitLabel(label2OfIF_ICMPLE);

		code.LINE();
		code.IINC("iGT", 1);

		code.visitLabel(label4OfGOTO);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iGE",int.class);

		code.LINE();
		code.LOAD("iGE");
		code.LOADConst(10);
		Label label6OfIF_ICMPLT = new Label();
		code.IF_ICMPLT(label6OfIF_ICMPLT);

		code.LINE();
		code.IINC("iGE", -1);
		Label label8OfGOTO = new Label();
		code.GOTO(label8OfGOTO);

		code.visitLabel(label6OfIF_ICMPLT);

		code.LINE();
		code.IINC("iGE", 1);

		code.visitLabel(label8OfGOTO);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iEQ",int.class);

		code.LINE();
		code.LOAD("iEQ");
		code.LOADConst(10);
		Label label10OfIF_ICMPNE = new Label();
		code.IF_ICMPNE(label10OfIF_ICMPNE);

		code.LINE();
		code.IINC("iEQ", 1);
		Label label12OfGOTO = new Label();
		code.GOTO(label12OfGOTO);

		code.visitLabel(label10OfIF_ICMPNE);

		code.LINE();
		code.IINC("iEQ", 1);

		code.visitLabel(label12OfGOTO);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iNE",int.class);

		code.LINE();
		code.LOAD("iNE");
		code.LOADConst(10);
		Label label14OfIF_ICMPEQ = new Label();
		code.IF_ICMPEQ(label14OfIF_ICMPEQ);

		code.LINE();
		code.IINC("iNE", 1);
		Label label16OfGOTO = new Label();
		code.GOTO(label16OfGOTO);

		code.visitLabel(label14OfIF_ICMPEQ);

		code.LINE();
		code.IINC("iNE", -1);

		code.visitLabel(label16OfGOTO);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iLE",int.class);

		code.LINE();
		code.LOAD("iLE");
		code.LOADConst(10);
		Label label18OfIF_ICMPGT = new Label();
		code.IF_ICMPGT(label18OfIF_ICMPGT);

		code.LINE();
		code.IINC("iLE", 1);
		Label label20OfGOTO = new Label();
		code.GOTO(label20OfGOTO);

		code.visitLabel(label18OfIF_ICMPGT);

		code.LINE();
		code.IINC("iLE", 1);

		code.visitLabel(label20OfGOTO);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iLT",int.class);

		code.LINE();
		code.LOAD("iLT");
		code.LOADConst(10);
		Label label22OfIF_ICMPGE = new Label();
		code.IF_ICMPGE(label22OfIF_ICMPGE);

		code.LINE();
		code.IINC("iLT", 1);
		Label label24OfGOTO = new Label();
		code.GOTO(label24OfGOTO);

		code.visitLabel(label22OfIF_ICMPGE);

		code.LINE();
		code.IINC("iLT", 1);

		code.visitLabel(label24OfGOTO);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
