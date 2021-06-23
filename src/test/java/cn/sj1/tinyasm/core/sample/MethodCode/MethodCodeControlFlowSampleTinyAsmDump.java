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
public class MethodCodeControlFlowSampleTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new MethodCodeControlFlowSampleTinyAsmDump().build("cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeControlFlowSample");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.field("b", Clazz.of(byte.class));
		__init_(classBody);
		_addInt(classBody);
		_addInt_float_float_int(classBody);
		_addInt_double_double_int(classBody);
		_addInt_int_int_int(classBody);
		_addInt_int_int(classBody);
		_addInt_String_String_int(classBody);
		_add_instance(classBody);
		_addByte(classBody);

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
		code.PUTFIELD("b", byte.class);
		code.RETURN();

		code.END();
	}

	protected void _addInt(ClassBody classBody) {
		MethodCode code = classBody.public_().method("addInt")
			.return_(int.class )
			.parameter("x",long.class)
			.parameter("y",long.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.LCMP();
		Label label1OfIFLE = new Label();
		code.IFLE(label1OfIFLE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label1OfIFLE);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.LCMP();
		Label label3OfIFGE = new Label();
		code.IFGE(label3OfIFGE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label3OfIFGE);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.LCMP();
		Label label5OfIFLT = new Label();
		code.IFLT(label5OfIFLT);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label5OfIFLT);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.LCMP();
		Label label7OfIFGT = new Label();
		code.IFGT(label7OfIFGT);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label7OfIFGT);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.LCMP();
		Label label9OfIFEQ = new Label();
		code.IFEQ(label9OfIFEQ);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label9OfIFEQ);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.LCMP();
		Label label11OfIFNE = new Label();
		code.IFNE(label11OfIFNE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label11OfIFNE);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.RETURNTop();

		code.END();
	}

	protected void _addInt_float_float_int(ClassBody classBody) {
		MethodCode code = classBody.public_().method("addInt")
			.return_(int.class )
			.parameter("x",float.class)
			.parameter("y",float.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label1OfIFLE = new Label();
		code.IFLE(label1OfIFLE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label1OfIFLE);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPG();
		Label label3OfIFGE = new Label();
		code.IFGE(label3OfIFGE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label3OfIFGE);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label5OfIFLT = new Label();
		code.IFLT(label5OfIFLT);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label5OfIFLT);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPG();
		Label label7OfIFGT = new Label();
		code.IFGT(label7OfIFGT);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label7OfIFGT);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label9OfIFEQ = new Label();
		code.IFEQ(label9OfIFEQ);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label9OfIFEQ);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label11OfIFNE = new Label();
		code.IFNE(label11OfIFNE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label11OfIFNE);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.RETURNTop();

		code.END();
	}

	protected void _addInt_double_double_int(ClassBody classBody) {
		MethodCode code = classBody.public_().method("addInt")
			.return_(int.class )
			.parameter("x",double.class)
			.parameter("y",double.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label1OfIFLE = new Label();
		code.IFLE(label1OfIFLE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label1OfIFLE);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPG();
		Label label3OfIFGE = new Label();
		code.IFGE(label3OfIFGE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label3OfIFGE);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label5OfIFLT = new Label();
		code.IFLT(label5OfIFLT);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label5OfIFLT);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPG();
		Label label7OfIFGT = new Label();
		code.IFGT(label7OfIFGT);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label7OfIFGT);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label9OfIFEQ = new Label();
		code.IFEQ(label9OfIFEQ);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label9OfIFEQ);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label11OfIFNE = new Label();
		code.IFNE(label11OfIFNE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label11OfIFNE);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.RETURNTop();

		code.END();
	}

	protected void _addInt_int_int_int(ClassBody classBody) {
		MethodCode code = classBody.public_().method("addInt")
			.return_(int.class )
			.parameter("x",int.class)
			.parameter("y",int.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPLE = new Label();
		code.IF_ICMPLE(label1OfIF_ICMPLE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label1OfIF_ICMPLE);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label3OfIF_ICMPGE = new Label();
		code.IF_ICMPGE(label3OfIF_ICMPGE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label3OfIF_ICMPGE);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label5OfIF_ICMPLT = new Label();
		code.IF_ICMPLT(label5OfIF_ICMPLT);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label5OfIF_ICMPLT);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label7OfIF_ICMPGT = new Label();
		code.IF_ICMPGT(label7OfIF_ICMPGT);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label7OfIF_ICMPGT);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label9OfIF_ICMPEQ = new Label();
		code.IF_ICMPEQ(label9OfIF_ICMPEQ);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label9OfIF_ICMPEQ);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label11OfIF_ICMPNE = new Label();
		code.IF_ICMPNE(label11OfIF_ICMPNE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label11OfIF_ICMPNE);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.RETURNTop();

		code.END();
	}

	protected void _addInt_int_int(ClassBody classBody) {
		MethodCode code = classBody.public_().method("addInt")
			.return_(int.class )
			.parameter("x",int.class).begin();

		code.LINE();
		code.LOAD("x");
		Label label1OfIFLE = new Label();
		code.IFLE(label1OfIFLE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label1OfIFLE);

		code.LINE();
		code.LOAD("x");
		Label label3OfIFGE = new Label();
		code.IFGE(label3OfIFGE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label3OfIFGE);

		code.LINE();
		code.LOAD("x");
		Label label5OfIFLT = new Label();
		code.IFLT(label5OfIFLT);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label5OfIFLT);

		code.LINE();
		code.LOAD("x");
		Label label7OfIFGT = new Label();
		code.IFGT(label7OfIFGT);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label7OfIFGT);

		code.LINE();
		code.LOAD("x");
		Label label9OfIFEQ = new Label();
		code.IFEQ(label9OfIFEQ);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label9OfIFEQ);

		code.LINE();
		code.LOAD("x");
		Label label11OfIFNE = new Label();
		code.IFNE(label11OfIFNE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label11OfIFNE);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.RETURNTop();

		code.END();
	}

	protected void _addInt_String_String_int(ClassBody classBody) {
		MethodCode code = classBody.public_().method("addInt")
			.return_(int.class )
			.parameter("x",String.class)
			.parameter("y",String.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ACMPEQ = new Label();
		code.IF_ACMPEQ(label1OfIF_ACMPEQ);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label1OfIF_ACMPEQ);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label3OfIF_ACMPNE = new Label();
		code.IF_ACMPNE(label3OfIF_ACMPNE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label3OfIF_ACMPNE);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.RETURNTop();

		code.END();
	}

	protected void _add_instance(ClassBody classBody) {
		MethodCode code = classBody.public_().method("add_instance")
			.return_(int.class )
			.parameter("x",String.class)
			.parameter("y",String.class).begin();

		code.LINE();
		code.LOAD("x");
		code.INSTANCEOF(String.class);
		Label label1OfIFEQ = new Label();
		code.IFEQ(label1OfIFEQ);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label1OfIFEQ);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.RETURNTop();

		code.END();
	}

	protected void _addByte(ClassBody classBody) {
		MethodCode code = classBody.public_().method("addByte")
			.return_(byte.class )
			.parameter("o",Object.class).begin();

		code.LINE();
		code.LOAD("o");
		Label label1OfIFNONNULL = new Label();
		code.IFNONNULL(label1OfIFNONNULL);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label1OfIFNONNULL);

		code.LINE();
		code.LOAD("o");
		Label label3OfIFNULL = new Label();
		code.IFNULL(label3OfIFNULL);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(100);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label3OfIFNULL);

		code.LINE();
		code.LOADConst(1);
		code.STORE("z",boolean.class);

		code.LINE();
		code.LOAD("z");
		Label label6OfIFEQ = new Label();
		code.IFEQ(label6OfIFEQ);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(2);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label6OfIFEQ);

		code.LINE();
		code.LOAD("z");
		Label label8OfIFNE = new Label();
		code.IFNE(label8OfIFNE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(8);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label8OfIFNE);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.LOADConst(1);
		code.ADD();
		Label label10OfIF_ICMPGE = new Label();
		code.IF_ICMPGE(label10OfIF_ICMPGE);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.PUTFIELD("b", byte.class);

		code.visitLabel(label10OfIF_ICMPGE);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.RETURNTop();

		code.END();
	}

}
