package cc1sj.tinyasm;

import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.lang.Object;
import static cc1sj.tinyasm.TinyAsmBuilder.*;

@SuppressWarnings("unused")
public class TinyAsmBuilder_ifTinyAsmBuilder {

	public static byte[] dump() throws Exception {
		return new TinyAsmBuilder_ifTinyAsmBuilder().dump("cc1sj.tinyasm.TinyAsmBuilder_if");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className).access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_testIfThen(classBody);
		_testIfThenElse(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method("<init>").begin();

		initThis();

		code.END();
	}

	protected void _testIfThen(ClassBody classBody) {
		MethodCode code = classBody.method("testIfThen").begin();

		int iGT = cst(20);
		ifEval(cmpGt(iGT, 10), c -> {
			inc(iGT, -1);
		});

		int iGE = cst(20);
		ifEval(cmpGe(iGE, 10), c -> {
			inc(iGE, -1);
		});

		int iEQ = cst(10);
		ifEval(cmpEq(iEQ, 10), c -> {
			inc(iEQ, 1);
		});

		int iNE = cst(10);
		ifEval(cmpNe(iNE, 10), c -> {
			inc(iNE, 1);
		});

		int iLE = cst(0);
		ifEval(cmpLe(iLE, 10), c -> {
			inc(iLE, 1);
		});

		int iLT = cst(0);
		ifEval(cmpLt(iLT, 10), c -> {
			inc(iLT, 1);
		});

		code.END();
	}

	protected void _testIfThenElse(ClassBody classBody) {
		MethodCode code = classBody.method("testIfThenElse").begin();

		int iGT = cst(20);
		ifEval(cmpGt(iGT, 10), c -> {
			inc(iGT, -1);
		}, c -> {
			inc(iGT, 1);
		});

		int iGE = cst(20);
		ifEval(cmpGe(iGE, 10), c -> {
			inc(iGE, -1);
		}, c -> {
			inc(iGE, 1);
		});

		int iEQ = cst(10);
		ifEval(cmpEq(iEQ, 10), c -> {
			inc(iEQ, 1);
		}, c -> {
			inc(iEQ, 1);
		});

		int iNE = cst(10);
		ifEval(cmpNe(iNE, 10), c -> {
			inc(iNE, 1);
		}, c -> {
			inc(iNE, -1);
		});

		int iLE = cst(0);
		ifEval(cmpLe(iLE, 10), c -> {
			inc(iLE, 1);
		}, c -> {
			inc(iLE, 1);
		});

		int iLT = cst(0);
		ifEval(cmpLt(iLT, 10), c -> {
			inc(iLT, 1);
		}, c -> {
			inc(iLT, 1);
		});
//		code.LINE(38);
//		code.LOADConst(20);
//		code.STORE("iGT",int.class);
//
//		code.LINE(39);
//		code.LOAD("iGT");
//		code.LOADConst(10);
//		Label label2OfIF_ICMPLE = new Label();
//		code.IF_ICMPLE(label2OfIF_ICMPLE);
//
//		code.LINE(40);
//		code.IINC("iGT", -1);
//
//		code.LINE(41);
//		Label label5OfGOTO = new Label();
//		code.GOTO(label5OfGOTO);
//
//		code.visitLabel(label2OfIF_ICMPLE);
//
//		code.LINE(42);
//		code.IINC("iGT", 1);
//
//		code.visitLabel(label5OfGOTO);
//
//		code.LINE(45);
//		code.LOADConst(20);
//		code.STORE("iGE",int.class);
//
//		code.LINE(46);
//		code.LOAD("iGE");
//		code.LOADConst(10);
//		Label label7OfIF_ICMPLT = new Label();
//		code.IF_ICMPLT(label7OfIF_ICMPLT);
//
//		code.LINE(47);
//		code.IINC("iGE", -1);
//
//		code.LINE(48);
//		Label label10OfGOTO = new Label();
//		code.GOTO(label10OfGOTO);
//
//		code.visitLabel(label7OfIF_ICMPLT);
//
//		code.LINE(49);
//		code.IINC("iGE", 1);
//
//		code.visitLabel(label10OfGOTO);
//
//		code.LINE(52);
//		code.LOADConst(10);
//		code.STORE("iEQ",int.class);
//
//		code.LINE(53);
//		code.LOAD("iEQ");
//		code.LOADConst(10);
//		Label label12OfIF_ICMPNE = new Label();
//		code.IF_ICMPNE(label12OfIF_ICMPNE);
//
//		code.LINE(54);
//		code.IINC("iEQ", 1);
//
//		code.LINE(55);
//		Label label15OfGOTO = new Label();
//		code.GOTO(label15OfGOTO);
//
//		code.visitLabel(label12OfIF_ICMPNE);
//
//		code.LINE(56);
//		code.IINC("iEQ", 1);
//
//		code.visitLabel(label15OfGOTO);
//
//		code.LINE(59);
//		code.LOADConst(10);
//		code.STORE("iNE",int.class);
//
//		code.LINE(60);
//		code.LOAD("iNE");
//		code.LOADConst(10);
//		Label label17OfIF_ICMPNE = new Label();
//		code.IF_ICMPNE(label17OfIF_ICMPNE);
//
//		code.LINE(61);
//		code.IINC("iNE", 1);
//
//		code.LINE(62);
//		Label label20OfGOTO = new Label();
//		code.GOTO(label20OfGOTO);
//
//		code.visitLabel(label17OfIF_ICMPNE);
//
//		code.LINE(63);
//		code.IINC("iNE", -1);
//
//		code.visitLabel(label20OfGOTO);
//
//		code.LINE(66);
//		code.LOADConst(0);
//		code.STORE("iLE",int.class);
//
//		code.LINE(67);
//		code.LOAD("iLE");
//		code.LOADConst(10);
//		Label label22OfIF_ICMPGT = new Label();
//		code.IF_ICMPGT(label22OfIF_ICMPGT);
//
//		code.LINE(68);
//		code.IINC("iLE", 1);
//
//		code.LINE(69);
//		Label label25OfGOTO = new Label();
//		code.GOTO(label25OfGOTO);
//
//		code.visitLabel(label22OfIF_ICMPGT);
//
//		code.LINE(70);
//		code.IINC("iLE", 1);
//
//		code.visitLabel(label25OfGOTO);
//
//		code.LINE(73);
//		code.LOADConst(0);
//		code.STORE("iLT",int.class);
//
//		code.LINE(74);
//		code.LOAD("iLT");
//		code.LOADConst(10);
//		Label label27OfIF_ICMPGE = new Label();
//		code.IF_ICMPGE(label27OfIF_ICMPGE);
//
//		code.LINE(75);
//		code.IINC("iLT", 1);
//
//		code.LINE(76);
//		Label label30OfGOTO = new Label();
//		code.GOTO(label30OfGOTO);
//
//		code.visitLabel(label27OfIF_ICMPGE);
//
//		code.LINE(77);
//		code.IINC("iLT", 1);
//
//		code.visitLabel(label30OfGOTO);
//
//		code.LINE(79);
//		code.RETURN();

		code.END();
	}

}
