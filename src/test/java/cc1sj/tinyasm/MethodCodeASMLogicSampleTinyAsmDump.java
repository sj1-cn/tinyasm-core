package cc1sj.tinyasm;
import org.objectweb.asm.Label;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.lang.Object;
@SuppressWarnings("unused")
public class MethodCodeASMLogicSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new MethodCodeASMLogicSampleTinyAsmDump().dump("cc1sj.tinyasm.MethodCodeASMLogicSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_eq(classBody);
		_ne(classBody);
		_ge(classBody);
		_le(classBody);
		_gt(classBody);
		_lt(classBody);
		_eq_char_char(classBody);
		_ne_char_char(classBody);
		_ge_char_char(classBody);
		_le_char_char(classBody);
		_gt_char_char(classBody);
		_lt_char_char(classBody);
		_eq_short_short(classBody);
		_ne_short_short(classBody);
		_ge_short_short(classBody);
		_le_short_short(classBody);
		_gt_short_short(classBody);
		_lt_short_short(classBody);
		_eq_int_int(classBody);
		_ne_int_int(classBody);
		_ge_int_int(classBody);
		_le_int_int(classBody);
		_gt_int_int(classBody);
		_lt_int_int(classBody);
		_eq_long_long(classBody);
		_ne_long_long(classBody);
		_ge_long_long(classBody);
		_le_long_long(classBody);
		_gt_long_long(classBody);
		_lt_long_long(classBody);
		_eq_float_float(classBody);
		_ne_float_float(classBody);
		_ge_float_float(classBody);
		_le_float_float(classBody);
		_gt_float_float(classBody);
		_lt_float_float(classBody);
		_eq_double_double(classBody);
		_ne_double_double(classBody);
		_ge_double_double(classBody);
		_le_double_double(classBody);
		_gt_double_double(classBody);
		_lt_double_double(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _eq(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "eq")
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
		MethodCode code = classBody.publicMethod(boolean.class, "ne")
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
		MethodCode code = classBody.publicMethod(boolean.class, "ge")
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
		MethodCode code = classBody.publicMethod(boolean.class, "le")
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
		MethodCode code = classBody.publicMethod(boolean.class, "gt")
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
		MethodCode code = classBody.publicMethod(boolean.class, "lt")
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

	protected void _eq_char_char(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "eq")
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

	protected void _ne_char_char(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "ne")
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

	protected void _ge_char_char(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "ge")
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

	protected void _le_char_char(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "le")
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

	protected void _gt_char_char(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "gt")
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

	protected void _lt_char_char(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "lt")
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

	protected void _eq_short_short(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "eq")
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

	protected void _ne_short_short(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "ne")
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

	protected void _ge_short_short(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "ge")
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

	protected void _le_short_short(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "le")
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

	protected void _gt_short_short(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "gt")
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

	protected void _lt_short_short(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "lt")
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

	protected void _eq_int_int(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "eq")
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

	protected void _ne_int_int(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "ne")
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

	protected void _ge_int_int(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "ge")
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

	protected void _le_int_int(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "le")
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

	protected void _gt_int_int(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "gt")
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

	protected void _lt_int_int(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "lt")
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

	protected void _eq_long_long(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "eq")
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

	protected void _ne_long_long(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "ne")
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

	protected void _ge_long_long(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "ge")
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

	protected void _le_long_long(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "le")
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

	protected void _gt_long_long(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "gt")
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

	protected void _lt_long_long(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "lt")
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

	protected void _eq_float_float(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "eq")
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

	protected void _ne_float_float(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "ne")
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

	protected void _ge_float_float(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "ge")
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

	protected void _le_float_float(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "le")
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

	protected void _gt_float_float(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "gt")
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

	protected void _lt_float_float(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "lt")
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

	protected void _eq_double_double(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "eq")
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

	protected void _ne_double_double(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "ne")
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

	protected void _ge_double_double(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "ge")
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

	protected void _le_double_double(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "le")
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

	protected void _gt_double_double(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "gt")
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

	protected void _lt_double_double(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(boolean.class, "lt")
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
