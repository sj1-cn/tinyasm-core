package cc1sj.tinyasm.util;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
@SuppressWarnings("unused")
public class MethodCodeASMControlSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("cc1sj.tinyasm.util.MethodCodeASMControlSample").access(ACC_PUBLIC | ACC_SUPER).body();

classWriter.field(0, "b", Clazz.of(byte.class));
classWriter.method("<init>").code(code -> {

	code.LINE(3);
	code.LOAD("this");
	code.SPECIAL(java.lang.Object.class, "<init>").INVOKE();

	code.LINE(4);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);
	code.RETURN();
});
classWriter.method(int.class, "addInt")
	.parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(7);
	code.LOAD("x");
	code.LOAD("y");
	code.LCMP();
	Label label1OfIFLE = new Label();
	code.IFLE(label1OfIFLE);

	code.LINE(8);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label1OfIFLE);

	code.LINE(10);
	code.LOAD("x");
	code.LOAD("y");
	code.LCMP();
	Label label3OfIFGE = new Label();
	code.IFGE(label3OfIFGE);

	code.LINE(11);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label3OfIFGE);

	code.LINE(13);
	code.LOAD("x");
	code.LOAD("y");
	code.LCMP();
	Label label5OfIFLT = new Label();
	code.IFLT(label5OfIFLT);

	code.LINE(14);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label5OfIFLT);

	code.LINE(16);
	code.LOAD("x");
	code.LOAD("y");
	code.LCMP();
	Label label7OfIFGT = new Label();
	code.IFGT(label7OfIFGT);

	code.LINE(17);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label7OfIFGT);

	code.LINE(19);
	code.LOAD("x");
	code.LOAD("y");
	code.LCMP();
	Label label9OfIFEQ = new Label();
	code.IFEQ(label9OfIFEQ);

	code.LINE(20);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label9OfIFEQ);

	code.LINE(22);
	code.LOAD("x");
	code.LOAD("y");
	code.LCMP();
	Label label11OfIFNE = new Label();
	code.IFNE(label11OfIFNE);

	code.LINE(23);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label11OfIFNE);

	code.LINE(25);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.RETURNTop();
});
classWriter.method(int.class, "addInt")
	.parameter("x",float.class)
	.parameter("y",float.class).code(code -> {

	code.LINE(29);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label1OfIFLE = new Label();
	code.IFLE(label1OfIFLE);

	code.LINE(30);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label1OfIFLE);

	code.LINE(32);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPG();
	Label label3OfIFGE = new Label();
	code.IFGE(label3OfIFGE);

	code.LINE(33);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label3OfIFGE);

	code.LINE(35);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label5OfIFLT = new Label();
	code.IFLT(label5OfIFLT);

	code.LINE(36);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label5OfIFLT);

	code.LINE(38);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPG();
	Label label7OfIFGT = new Label();
	code.IFGT(label7OfIFGT);

	code.LINE(39);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label7OfIFGT);

	code.LINE(41);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label9OfIFEQ = new Label();
	code.IFEQ(label9OfIFEQ);

	code.LINE(42);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label9OfIFEQ);

	code.LINE(44);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label11OfIFNE = new Label();
	code.IFNE(label11OfIFNE);

	code.LINE(45);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label11OfIFNE);

	code.LINE(47);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.RETURNTop();
});
classWriter.method(int.class, "addInt")
	.parameter("x",double.class)
	.parameter("y",double.class).code(code -> {

	code.LINE(51);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label1OfIFLE = new Label();
	code.IFLE(label1OfIFLE);

	code.LINE(52);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label1OfIFLE);

	code.LINE(54);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPG();
	Label label3OfIFGE = new Label();
	code.IFGE(label3OfIFGE);

	code.LINE(55);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label3OfIFGE);

	code.LINE(57);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label5OfIFLT = new Label();
	code.IFLT(label5OfIFLT);

	code.LINE(58);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label5OfIFLT);

	code.LINE(60);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPG();
	Label label7OfIFGT = new Label();
	code.IFGT(label7OfIFGT);

	code.LINE(61);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label7OfIFGT);

	code.LINE(63);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label9OfIFEQ = new Label();
	code.IFEQ(label9OfIFEQ);

	code.LINE(64);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label9OfIFEQ);

	code.LINE(66);
	code.LOAD("x");
	code.LOAD("y");
	code.CMPL();
	Label label11OfIFNE = new Label();
	code.IFNE(label11OfIFNE);

	code.LINE(67);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label11OfIFNE);

	code.LINE(69);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.RETURNTop();
});
classWriter.method(int.class, "addInt")
	.parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(73);
	code.LOAD("x");
	code.LOAD("y");
	Label label1OfIF_ICMPLE = new Label();
	code.IF_ICMPLE(label1OfIF_ICMPLE);

	code.LINE(74);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label1OfIF_ICMPLE);

	code.LINE(76);
	code.LOAD("x");
	code.LOAD("y");
	Label label3OfIF_ICMPGE = new Label();
	code.IF_ICMPGE(label3OfIF_ICMPGE);

	code.LINE(77);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label3OfIF_ICMPGE);

	code.LINE(79);
	code.LOAD("x");
	code.LOAD("y");
	Label label5OfIF_ICMPLT = new Label();
	code.IF_ICMPLT(label5OfIF_ICMPLT);

	code.LINE(80);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label5OfIF_ICMPLT);

	code.LINE(82);
	code.LOAD("x");
	code.LOAD("y");
	Label label7OfIF_ICMPGT = new Label();
	code.IF_ICMPGT(label7OfIF_ICMPGT);

	code.LINE(83);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label7OfIF_ICMPGT);

	code.LINE(85);
	code.LOAD("x");
	code.LOAD("y");
	Label label9OfIF_ICMPEQ = new Label();
	code.IF_ICMPEQ(label9OfIF_ICMPEQ);

	code.LINE(86);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label9OfIF_ICMPEQ);

	code.LINE(88);
	code.LOAD("x");
	code.LOAD("y");
	Label label11OfIF_ICMPNE = new Label();
	code.IF_ICMPNE(label11OfIF_ICMPNE);

	code.LINE(89);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label11OfIF_ICMPNE);

	code.LINE(91);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.RETURNTop();
});
classWriter.method(int.class, "addInt")
	.parameter("x",int.class).code(code -> {

	code.LINE(95);
	code.LOAD("x");
	Label label1OfIFLE = new Label();
	code.IFLE(label1OfIFLE);

	code.LINE(96);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label1OfIFLE);

	code.LINE(98);
	code.LOAD("x");
	Label label3OfIFGE = new Label();
	code.IFGE(label3OfIFGE);

	code.LINE(99);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label3OfIFGE);

	code.LINE(101);
	code.LOAD("x");
	Label label5OfIFLT = new Label();
	code.IFLT(label5OfIFLT);

	code.LINE(102);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label5OfIFLT);

	code.LINE(104);
	code.LOAD("x");
	Label label7OfIFGT = new Label();
	code.IFGT(label7OfIFGT);

	code.LINE(105);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label7OfIFGT);

	code.LINE(107);
	code.LOAD("x");
	Label label9OfIFEQ = new Label();
	code.IFEQ(label9OfIFEQ);

	code.LINE(108);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label9OfIFEQ);

	code.LINE(110);
	code.LOAD("x");
	Label label11OfIFNE = new Label();
	code.IFNE(label11OfIFNE);

	code.LINE(111);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label11OfIFNE);

	code.LINE(113);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.RETURNTop();
});
classWriter.method(int.class, "addInt")
	.parameter("x",java.lang.String.class)
	.parameter("y",java.lang.String.class).code(code -> {

	code.LINE(117);
	code.LOAD("x");
	code.LOAD("y");
	Label label1OfIF_ACMPEQ = new Label();
	code.IF_ACMPEQ(label1OfIF_ACMPEQ);

	code.LINE(118);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label1OfIF_ACMPEQ);

	code.LINE(120);
	code.LOAD("x");
	code.LOAD("y");
	Label label3OfIF_ACMPNE = new Label();
	code.IF_ACMPNE(label3OfIF_ACMPNE);

	code.LINE(121);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label3OfIF_ACMPNE);

	code.LINE(123);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.RETURNTop();
});
classWriter.method(int.class, "add_instance")
	.parameter("x",java.lang.String.class)
	.parameter("y",java.lang.String.class).code(code -> {

	code.LINE(127);
	code.LOAD("x");
	code.INSTANCEOF(java.lang.String.class);
	Label label1OfIFEQ = new Label();
	code.IFEQ(label1OfIFEQ);

	code.LINE(128);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label1OfIFEQ);

	code.LINE(130);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.RETURNTop();
});
classWriter.method(byte.class, "addByte")
	.parameter("o",java.lang.Object.class).code(code -> {

	code.LINE(134);
	code.LOAD("o");
	Label label1OfIFNONNULL = new Label();
	code.IFNONNULL(label1OfIFNONNULL);

	code.LINE(135);
	code.LOAD("this");
	code.LOADConst(10);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label1OfIFNONNULL);

	code.LINE(137);
	code.LOAD("o");
	Label label3OfIFNULL = new Label();
	code.IFNULL(label3OfIFNULL);

	code.LINE(138);
	code.LOAD("this");
	code.LOADConst(100);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label3OfIFNULL);

	code.LINE(140);
	code.LOADConst(1);
	code.STORE("z",boolean.class);

	code.LINE(141);
	code.LOAD("z");
	Label label6OfIFEQ = new Label();
	code.IFEQ(label6OfIFEQ);

	code.LINE(142);
	code.LOAD("this");
	code.LOADConst(2);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label6OfIFEQ);

	code.LINE(144);
	code.LOAD("z");
	Label label8OfIFNE = new Label();
	code.IFNE(label8OfIFNE);

	code.LINE(145);
	code.LOAD("this");
	code.LOADConst(8);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label8OfIFNE);

	code.LINE(147);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.LOADConst(1);
	code.ADD();
	Label label10OfIF_ICMPGE = new Label();
	code.IF_ICMPGE(label10OfIF_ICMPGE);

	code.LINE(148);
	code.LOAD("this");
	code.LOADConst(10);
	code.PUTFIELD("b", byte.class);

	code.visitLabel(label10OfIF_ICMPGE);

	code.LINE(150);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.RETURNTop();
});
return classWriter.end().toByteArray();
}
}
