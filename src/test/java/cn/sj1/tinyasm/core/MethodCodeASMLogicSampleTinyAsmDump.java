package cn.sj1.tinyasm.core;
import org.objectweb.asm.Label;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import cn.sj1.tinyasm.core.ClassBody;
import cn.sj1.tinyasm.core.ClassBuilder;
import cn.sj1.tinyasm.core.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cn.sj1.tinyasm.core.Annotation;
import cn.sj1.tinyasm.core.Clazz;
import java.lang.Object;
@SuppressWarnings("unused")
public class MethodCodeASMLogicSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new MethodCodeASMLogicSampleTinyAsmDump().dump("cn.sj1.tinyasm.core.MethodCodeASMLogicSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_eq(classBody);
		_ne(classBody);
		_ge(classBody);
		_le(classBody);
		_gt(classBody);
		_lt(classBody);
		_eq_char_char_boolean(classBody);
		_ne_char_char_boolean(classBody);
		_ge_char_char_boolean(classBody);
		_le_char_char_boolean(classBody);
		_gt_char_char_boolean(classBody);
		_lt_char_char_boolean(classBody);
		_eq_short_short_boolean(classBody);
		_ne_short_short_boolean(classBody);
		_ge_short_short_boolean(classBody);
		_le_short_short_boolean(classBody);
		_gt_short_short_boolean(classBody);
		_lt_short_short_boolean(classBody);
		_eq_int_int_boolean(classBody);
		_ne_int_int_boolean(classBody);
		_ge_int_int_boolean(classBody);
		_le_int_int_boolean(classBody);
		_gt_int_int_boolean(classBody);
		_lt_int_int_boolean(classBody);
		_eq_long_long_boolean(classBody);
		_ne_long_long_boolean(classBody);
		_ge_long_long_boolean(classBody);
		_le_long_long_boolean(classBody);
		_gt_long_long_boolean(classBody);
		_lt_long_long_boolean(classBody);
		_eq_float_float_boolean(classBody);
		_ne_float_float_boolean(classBody);
		_ge_float_float_boolean(classBody);
		_le_float_float_boolean(classBody);
		_gt_float_float_boolean(classBody);
		_lt_float_float_boolean(classBody);
		_eq_double_double_boolean(classBody);
		_ne_double_double_boolean(classBody);
		_ge_double_double_boolean(classBody);
		_le_double_double_boolean(classBody);
		_gt_double_double_boolean(classBody);
		_lt_double_double_boolean(classBody);

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

	protected void _eq(ClassBody classBody) {
		MethodCode code = classBody.public_().method("eq")
			.return_(boolean.class )
			.parameter("x",byte.class)
			.parameter("y",byte.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPNE = new Label();
		code.IF_ICMPNE(label1OfIF_ICMPNE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPNE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _ne(ClassBody classBody) {
		MethodCode code = classBody.public_().method("ne")
			.return_(boolean.class )
			.parameter("x",byte.class)
			.parameter("y",byte.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPEQ = new Label();
		code.IF_ICMPEQ(label1OfIF_ICMPEQ);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPEQ);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _ge(ClassBody classBody) {
		MethodCode code = classBody.public_().method("ge")
			.return_(boolean.class )
			.parameter("x",byte.class)
			.parameter("y",byte.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPLT = new Label();
		code.IF_ICMPLT(label1OfIF_ICMPLT);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPLT);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _le(ClassBody classBody) {
		MethodCode code = classBody.public_().method("le")
			.return_(boolean.class )
			.parameter("x",byte.class)
			.parameter("y",byte.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPGT = new Label();
		code.IF_ICMPGT(label1OfIF_ICMPGT);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPGT);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _gt(ClassBody classBody) {
		MethodCode code = classBody.public_().method("gt")
			.return_(boolean.class )
			.parameter("x",byte.class)
			.parameter("y",byte.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPLE = new Label();
		code.IF_ICMPLE(label1OfIF_ICMPLE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPLE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _lt(ClassBody classBody) {
		MethodCode code = classBody.public_().method("lt")
			.return_(boolean.class )
			.parameter("x",byte.class)
			.parameter("y",byte.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPGE = new Label();
		code.IF_ICMPGE(label1OfIF_ICMPGE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPGE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _eq_char_char_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("eq")
			.return_(boolean.class )
			.parameter("x",char.class)
			.parameter("y",char.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPNE = new Label();
		code.IF_ICMPNE(label1OfIF_ICMPNE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPNE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _ne_char_char_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("ne")
			.return_(boolean.class )
			.parameter("x",char.class)
			.parameter("y",char.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPEQ = new Label();
		code.IF_ICMPEQ(label1OfIF_ICMPEQ);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPEQ);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _ge_char_char_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("ge")
			.return_(boolean.class )
			.parameter("x",char.class)
			.parameter("y",char.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPLT = new Label();
		code.IF_ICMPLT(label1OfIF_ICMPLT);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPLT);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _le_char_char_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("le")
			.return_(boolean.class )
			.parameter("x",char.class)
			.parameter("y",char.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPGT = new Label();
		code.IF_ICMPGT(label1OfIF_ICMPGT);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPGT);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _gt_char_char_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("gt")
			.return_(boolean.class )
			.parameter("x",char.class)
			.parameter("y",char.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPLE = new Label();
		code.IF_ICMPLE(label1OfIF_ICMPLE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPLE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _lt_char_char_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("lt")
			.return_(boolean.class )
			.parameter("x",char.class)
			.parameter("y",char.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPGE = new Label();
		code.IF_ICMPGE(label1OfIF_ICMPGE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPGE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _eq_short_short_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("eq")
			.return_(boolean.class )
			.parameter("x",short.class)
			.parameter("y",short.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPNE = new Label();
		code.IF_ICMPNE(label1OfIF_ICMPNE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPNE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _ne_short_short_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("ne")
			.return_(boolean.class )
			.parameter("x",short.class)
			.parameter("y",short.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPEQ = new Label();
		code.IF_ICMPEQ(label1OfIF_ICMPEQ);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPEQ);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _ge_short_short_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("ge")
			.return_(boolean.class )
			.parameter("x",short.class)
			.parameter("y",short.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPLT = new Label();
		code.IF_ICMPLT(label1OfIF_ICMPLT);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPLT);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _le_short_short_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("le")
			.return_(boolean.class )
			.parameter("x",short.class)
			.parameter("y",short.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPGT = new Label();
		code.IF_ICMPGT(label1OfIF_ICMPGT);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPGT);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _gt_short_short_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("gt")
			.return_(boolean.class )
			.parameter("x",short.class)
			.parameter("y",short.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPLE = new Label();
		code.IF_ICMPLE(label1OfIF_ICMPLE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPLE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _lt_short_short_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("lt")
			.return_(boolean.class )
			.parameter("x",short.class)
			.parameter("y",short.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPGE = new Label();
		code.IF_ICMPGE(label1OfIF_ICMPGE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPGE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _eq_int_int_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("eq")
			.return_(boolean.class )
			.parameter("x",int.class)
			.parameter("y",int.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPNE = new Label();
		code.IF_ICMPNE(label1OfIF_ICMPNE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPNE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _ne_int_int_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("ne")
			.return_(boolean.class )
			.parameter("x",int.class)
			.parameter("y",int.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPEQ = new Label();
		code.IF_ICMPEQ(label1OfIF_ICMPEQ);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPEQ);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _ge_int_int_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("ge")
			.return_(boolean.class )
			.parameter("x",int.class)
			.parameter("y",int.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPLT = new Label();
		code.IF_ICMPLT(label1OfIF_ICMPLT);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPLT);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _le_int_int_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("le")
			.return_(boolean.class )
			.parameter("x",int.class)
			.parameter("y",int.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPGT = new Label();
		code.IF_ICMPGT(label1OfIF_ICMPGT);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPGT);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _gt_int_int_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("gt")
			.return_(boolean.class )
			.parameter("x",int.class)
			.parameter("y",int.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPLE = new Label();
		code.IF_ICMPLE(label1OfIF_ICMPLE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPLE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _lt_int_int_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("lt")
			.return_(boolean.class )
			.parameter("x",int.class)
			.parameter("y",int.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		Label label1OfIF_ICMPGE = new Label();
		code.IF_ICMPGE(label1OfIF_ICMPGE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIF_ICMPGE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _eq_long_long_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("eq")
			.return_(boolean.class )
			.parameter("x",long.class)
			.parameter("y",long.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.LCMP();
		Label label1OfIFNE = new Label();
		code.IFNE(label1OfIFNE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFNE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _ne_long_long_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("ne")
			.return_(boolean.class )
			.parameter("x",long.class)
			.parameter("y",long.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.LCMP();
		Label label1OfIFEQ = new Label();
		code.IFEQ(label1OfIFEQ);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFEQ);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _ge_long_long_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("ge")
			.return_(boolean.class )
			.parameter("x",long.class)
			.parameter("y",long.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.LCMP();
		Label label1OfIFLT = new Label();
		code.IFLT(label1OfIFLT);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFLT);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _le_long_long_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("le")
			.return_(boolean.class )
			.parameter("x",long.class)
			.parameter("y",long.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.LCMP();
		Label label1OfIFGT = new Label();
		code.IFGT(label1OfIFGT);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFGT);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _gt_long_long_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("gt")
			.return_(boolean.class )
			.parameter("x",long.class)
			.parameter("y",long.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.LCMP();
		Label label1OfIFLE = new Label();
		code.IFLE(label1OfIFLE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFLE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _lt_long_long_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("lt")
			.return_(boolean.class )
			.parameter("x",long.class)
			.parameter("y",long.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.LCMP();
		Label label1OfIFGE = new Label();
		code.IFGE(label1OfIFGE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFGE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _eq_float_float_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("eq")
			.return_(boolean.class )
			.parameter("x",float.class)
			.parameter("y",float.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label1OfIFNE = new Label();
		code.IFNE(label1OfIFNE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFNE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _ne_float_float_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("ne")
			.return_(boolean.class )
			.parameter("x",float.class)
			.parameter("y",float.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label1OfIFEQ = new Label();
		code.IFEQ(label1OfIFEQ);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFEQ);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _ge_float_float_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("ge")
			.return_(boolean.class )
			.parameter("x",float.class)
			.parameter("y",float.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label1OfIFLT = new Label();
		code.IFLT(label1OfIFLT);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFLT);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _le_float_float_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("le")
			.return_(boolean.class )
			.parameter("x",float.class)
			.parameter("y",float.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPG();
		Label label1OfIFGT = new Label();
		code.IFGT(label1OfIFGT);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFGT);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _gt_float_float_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("gt")
			.return_(boolean.class )
			.parameter("x",float.class)
			.parameter("y",float.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label1OfIFLE = new Label();
		code.IFLE(label1OfIFLE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFLE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _lt_float_float_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("lt")
			.return_(boolean.class )
			.parameter("x",float.class)
			.parameter("y",float.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPG();
		Label label1OfIFGE = new Label();
		code.IFGE(label1OfIFGE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFGE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _eq_double_double_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("eq")
			.return_(boolean.class )
			.parameter("x",double.class)
			.parameter("y",double.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label1OfIFNE = new Label();
		code.IFNE(label1OfIFNE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFNE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _ne_double_double_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("ne")
			.return_(boolean.class )
			.parameter("x",double.class)
			.parameter("y",double.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label1OfIFEQ = new Label();
		code.IFEQ(label1OfIFEQ);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFEQ);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _ge_double_double_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("ge")
			.return_(boolean.class )
			.parameter("x",double.class)
			.parameter("y",double.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label1OfIFLT = new Label();
		code.IFLT(label1OfIFLT);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFLT);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _le_double_double_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("le")
			.return_(boolean.class )
			.parameter("x",double.class)
			.parameter("y",double.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPG();
		Label label1OfIFGT = new Label();
		code.IFGT(label1OfIFGT);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFGT);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _gt_double_double_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("gt")
			.return_(boolean.class )
			.parameter("x",double.class)
			.parameter("y",double.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPL();
		Label label1OfIFLE = new Label();
		code.IFLE(label1OfIFLE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFLE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

	protected void _lt_double_double_boolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("lt")
			.return_(boolean.class )
			.parameter("x",double.class)
			.parameter("y",double.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.CMPG();
		Label label1OfIFGE = new Label();
		code.IFGE(label1OfIFGE);
		code.LOADConst(1);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);

		code.visitLabel(label1OfIFGE);
		code.LOADConst(0);

		code.visitLabel(label2OfGOTO);
		code.RETURNTop();

		code.END();
	}

}
