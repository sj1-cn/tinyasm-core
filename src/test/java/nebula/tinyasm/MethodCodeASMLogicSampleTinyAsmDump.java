package nebula.tinyasm;
import org.objectweb.asm.Label;
import nebula.tinyasm.ClassBody;
import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import nebula.tinyasm.Annotation;
import nebula.tinyasm.Clazz;
@SuppressWarnings("unused")
public class MethodCodeASMLogicSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("nebula.tinyasm.MethodCodeASMLogicSample").access(ACC_PUBLIC | ACC_SUPER).body();

classWriter.method(ACC_PUBLIC, "<init>").code(code -> {

	code.LINE(3);
	code.LOAD("this");
	code.SPECIAL(java.lang.Object.class, "<init>").INVOKE();
	code.RETURN();
});
classWriter.method(ACC_PUBLIC, boolean.class, "eq")
	.parameter("x",byte.class)
	.parameter("y",byte.class).code(code -> {

	code.LINE(6);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPNE = new Label();
	code.IF_ICMPNE(label0OfIF_ICMPNE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPNE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "ne")
	.parameter("x",byte.class)
	.parameter("y",byte.class).code(code -> {

	code.LINE(10);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPEQ = new Label();
	code.IF_ICMPEQ(label0OfIF_ICMPEQ);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPEQ);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "ge")
	.parameter("x",byte.class)
	.parameter("y",byte.class).code(code -> {

	code.LINE(14);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPLT = new Label();
	code.IF_ICMPLT(label0OfIF_ICMPLT);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPLT);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "le")
	.parameter("x",byte.class)
	.parameter("y",byte.class).code(code -> {

	code.LINE(18);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPGT = new Label();
	code.IF_ICMPGT(label0OfIF_ICMPGT);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPGT);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "gt")
	.parameter("x",byte.class)
	.parameter("y",byte.class).code(code -> {

	code.LINE(22);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPLE = new Label();
	code.IF_ICMPLE(label0OfIF_ICMPLE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPLE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "lt")
	.parameter("x",byte.class)
	.parameter("y",byte.class).code(code -> {

	code.LINE(26);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPGE = new Label();
	code.IF_ICMPGE(label0OfIF_ICMPGE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPGE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "eq")
	.parameter("x",char.class)
	.parameter("y",char.class).code(code -> {

	code.LINE(30);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPNE = new Label();
	code.IF_ICMPNE(label0OfIF_ICMPNE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPNE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "ne")
	.parameter("x",char.class)
	.parameter("y",char.class).code(code -> {

	code.LINE(34);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPEQ = new Label();
	code.IF_ICMPEQ(label0OfIF_ICMPEQ);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPEQ);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "ge")
	.parameter("x",char.class)
	.parameter("y",char.class).code(code -> {

	code.LINE(38);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPLT = new Label();
	code.IF_ICMPLT(label0OfIF_ICMPLT);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPLT);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "le")
	.parameter("x",char.class)
	.parameter("y",char.class).code(code -> {

	code.LINE(42);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPGT = new Label();
	code.IF_ICMPGT(label0OfIF_ICMPGT);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPGT);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "gt")
	.parameter("x",char.class)
	.parameter("y",char.class).code(code -> {

	code.LINE(46);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPLE = new Label();
	code.IF_ICMPLE(label0OfIF_ICMPLE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPLE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "lt")
	.parameter("x",char.class)
	.parameter("y",char.class).code(code -> {

	code.LINE(50);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPGE = new Label();
	code.IF_ICMPGE(label0OfIF_ICMPGE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPGE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "eq")
	.parameter("x",short.class)
	.parameter("y",short.class).code(code -> {

	code.LINE(54);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPNE = new Label();
	code.IF_ICMPNE(label0OfIF_ICMPNE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPNE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "ne")
	.parameter("x",short.class)
	.parameter("y",short.class).code(code -> {

	code.LINE(58);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPEQ = new Label();
	code.IF_ICMPEQ(label0OfIF_ICMPEQ);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPEQ);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "ge")
	.parameter("x",short.class)
	.parameter("y",short.class).code(code -> {

	code.LINE(62);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPLT = new Label();
	code.IF_ICMPLT(label0OfIF_ICMPLT);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPLT);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "le")
	.parameter("x",short.class)
	.parameter("y",short.class).code(code -> {

	code.LINE(66);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPGT = new Label();
	code.IF_ICMPGT(label0OfIF_ICMPGT);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPGT);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "gt")
	.parameter("x",short.class)
	.parameter("y",short.class).code(code -> {

	code.LINE(70);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPLE = new Label();
	code.IF_ICMPLE(label0OfIF_ICMPLE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPLE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "lt")
	.parameter("x",short.class)
	.parameter("y",short.class).code(code -> {

	code.LINE(74);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPGE = new Label();
	code.IF_ICMPGE(label0OfIF_ICMPGE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPGE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "eq")
	.parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(78);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPNE = new Label();
	code.IF_ICMPNE(label0OfIF_ICMPNE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPNE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "ne")
	.parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(82);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPEQ = new Label();
	code.IF_ICMPEQ(label0OfIF_ICMPEQ);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPEQ);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "ge")
	.parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(86);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPLT = new Label();
	code.IF_ICMPLT(label0OfIF_ICMPLT);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPLT);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "le")
	.parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(90);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPGT = new Label();
	code.IF_ICMPGT(label0OfIF_ICMPGT);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPGT);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "gt")
	.parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(94);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPLE = new Label();
	code.IF_ICMPLE(label0OfIF_ICMPLE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPLE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "lt")
	.parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(98);
	code.LOAD("x");
	code.LOAD("y");
	Label label0OfIF_ICMPGE = new Label();
	code.IF_ICMPGE(label0OfIF_ICMPGE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIF_ICMPGE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "eq")
	.parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(102);
	code.LOAD("x");
	code.LOAD("y");
	code.LCMP();
	Label label0OfIFNE = new Label();
	code.IFNE(label0OfIFNE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFNE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "ne")
	.parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(106);
	code.LOAD("x");
	code.LOAD("y");
	code.LCMP();
	Label label0OfIFEQ = new Label();
	code.IFEQ(label0OfIFEQ);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFEQ);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "ge")
	.parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(110);
	code.LOAD("x");
	code.LOAD("y");
	code.LCMP();
	Label label0OfIFLT = new Label();
	code.IFLT(label0OfIFLT);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFLT);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "le")
	.parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(114);
	code.LOAD("x");
	code.LOAD("y");
	code.LCMP();
	Label label0OfIFGT = new Label();
	code.IFGT(label0OfIFGT);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFGT);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "gt")
	.parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(118);
	code.LOAD("x");
	code.LOAD("y");
	code.LCMP();
	Label label0OfIFLE = new Label();
	code.IFLE(label0OfIFLE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFLE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "lt")
	.parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(122);
	code.LOAD("x");
	code.LOAD("y");
	code.LCMP();
	Label label0OfIFGE = new Label();
	code.IFGE(label0OfIFGE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFGE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "eq")
	.parameter("x",float.class)
	.parameter("y",float.class).code(code -> {

	code.LINE(126);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label0OfIFNE = new Label();
	code.IFNE(label0OfIFNE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFNE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "ne")
	.parameter("x",float.class)
	.parameter("y",float.class).code(code -> {

	code.LINE(130);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label0OfIFEQ = new Label();
	code.IFEQ(label0OfIFEQ);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFEQ);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "ge")
	.parameter("x",float.class)
	.parameter("y",float.class).code(code -> {

	code.LINE(134);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label0OfIFLT = new Label();
	code.IFLT(label0OfIFLT);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFLT);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "le")
	.parameter("x",float.class)
	.parameter("y",float.class).code(code -> {

	code.LINE(138);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPG();
	Label label0OfIFGT = new Label();
	code.IFGT(label0OfIFGT);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFGT);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "gt")
	.parameter("x",float.class)
	.parameter("y",float.class).code(code -> {

	code.LINE(142);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label0OfIFLE = new Label();
	code.IFLE(label0OfIFLE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFLE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "lt")
	.parameter("x",float.class)
	.parameter("y",float.class).code(code -> {

	code.LINE(146);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPG();
	Label label0OfIFGE = new Label();
	code.IFGE(label0OfIFGE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFGE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "eq")
	.parameter("x",double.class)
	.parameter("y",double.class).code(code -> {

	code.LINE(150);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label0OfIFNE = new Label();
	code.IFNE(label0OfIFNE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFNE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "ne")
	.parameter("x",double.class)
	.parameter("y",double.class).code(code -> {

	code.LINE(154);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label0OfIFEQ = new Label();
	code.IFEQ(label0OfIFEQ);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFEQ);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "ge")
	.parameter("x",double.class)
	.parameter("y",double.class).code(code -> {

	code.LINE(158);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label0OfIFLT = new Label();
	code.IFLT(label0OfIFLT);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFLT);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "le")
	.parameter("x",double.class)
	.parameter("y",double.class).code(code -> {

	code.LINE(162);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPG();
	Label label0OfIFGT = new Label();
	code.IFGT(label0OfIFGT);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFGT);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "gt")
	.parameter("x",double.class)
	.parameter("y",double.class).code(code -> {

	code.LINE(166);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label0OfIFLE = new Label();
	code.IFLE(label0OfIFLE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFLE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, boolean.class, "lt")
	.parameter("x",double.class)
	.parameter("y",double.class).code(code -> {

	code.LINE(170);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPG();
	Label label0OfIFGE = new Label();
	code.IFGE(label0OfIFGE);
	code.LOADConst(1);
	Label label1OfGOTO = new Label();
	code.GOTO(label1OfGOTO);

	code.visitLabel(label0OfIFGE);
	code.LOADConst(0);

	code.visitLabel(label1OfGOTO);
	code.RETURNTop();
});
return classWriter.end().toByteArray();
}
}
