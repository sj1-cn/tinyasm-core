package nebula.tinyasm.util;
import org.objectweb.asm.Label;
import nebula.tinyasm.ClassBody;
import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import nebula.tinyasm.Clazz;
@SuppressWarnings("unused")
public class MethodCodeASMMathSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("nebula.tinyasm.util.MethodCodeASMMathSample").access(ACC_PUBLIC | ACC_SUPER).body();

classWriter.field(0, "b", Clazz.of(byte.class));
classWriter.field(0, "c", Clazz.of(char.class));
classWriter.field(0, "s", Clazz.of(short.class));
classWriter.field(0, "i", Clazz.of(int.class));
classWriter.field(0, "l", Clazz.of(long.class));
classWriter.field(0, "f", Clazz.of(float.class));
classWriter.field(0, "d", Clazz.of(double.class));
classWriter.field(0, "b3", Clazz.of(byte.class));
classWriter.field(0, "c3", Clazz.of(char.class));
classWriter.field(0, "s3", Clazz.of(short.class));
classWriter.field(0, "i3", Clazz.of(int.class));
classWriter.field(0, "l3", Clazz.of(long.class));
classWriter.field(0, "f3", Clazz.of(float.class));
classWriter.field(0, "d3", Clazz.of(double.class));
classWriter.field(0, "f31", Clazz.of(float.class));
classWriter.field(0, "d31", Clazz.of(double.class));
classWriter.field(0, "b0", Clazz.of(byte.class));
classWriter.field(0, "c0", Clazz.of(char.class));
classWriter.field(0, "s0", Clazz.of(short.class));
classWriter.field(0, "i0", Clazz.of(int.class));
classWriter.field(0, "l1", Clazz.of(long.class));
classWriter.field(0, "f1", Clazz.of(float.class));
classWriter.field(0, "d1", Clazz.of(double.class));
classWriter.field(0, "bn1", Clazz.of(byte.class));
classWriter.field(0, "sn1", Clazz.of(short.class));
classWriter.field(0, "in1", Clazz.of(int.class));
classWriter.field(0, "ln1", Clazz.of(long.class));
classWriter.field(0, "fn1", Clazz.of(float.class));
classWriter.field(0, "dn1", Clazz.of(double.class));
classWriter.method(ACC_PUBLIC, "<init>").code(code -> {

	code.LINE(3);
	code.LOAD("this");
	code.SPECIAL(java.lang.Object.class, "<init>").INVOKE();

	code.LINE(4);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("b", byte.class);

	code.LINE(5);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("c", char.class);

	code.LINE(6);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("s", short.class);

	code.LINE(7);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("i", int.class);

	code.LINE(8);
	code.LOAD("this");
	code.LOADConst(1L);
	code.PUTFIELD("l", long.class);

	code.LINE(9);
	code.LOAD("this");
	code.LOADConst(1F);
	code.PUTFIELD("f", float.class);

	code.LINE(10);
	code.LOAD("this");
	code.LOADConst(1D);
	code.PUTFIELD("d", double.class);

	code.LINE(12);
	code.LOAD("this");
	code.LOADConst(3);
	code.PUTFIELD("b3", byte.class);

	code.LINE(13);
	code.LOAD("this");
	code.LOADConst(3);
	code.PUTFIELD("c3", char.class);

	code.LINE(14);
	code.LOAD("this");
	code.LOADConst(3);
	code.PUTFIELD("s3", short.class);

	code.LINE(15);
	code.LOAD("this");
	code.LOADConst(3);
	code.PUTFIELD("i3", int.class);

	code.LINE(16);
	code.LOAD("this");
	code.LOADConst(Long.valueOf(3L));
	code.PUTFIELD("l3", long.class);

	code.LINE(17);
	code.LOAD("this");
	code.LOADConst(Float.valueOf("3.0"));
	code.PUTFIELD("f3", float.class);

	code.LINE(18);
	code.LOAD("this");
	code.LOADConst(Double.valueOf("3.0"));
	code.PUTFIELD("d3", double.class);

	code.LINE(20);
	code.LOAD("this");
	code.LOADConst(Float.valueOf("3.1"));
	code.PUTFIELD("f31", float.class);

	code.LINE(21);
	code.LOAD("this");
	code.LOADConst(Double.valueOf("3.1"));
	code.PUTFIELD("d31", double.class);

	code.LINE(23);
	code.LOAD("this");
	code.LOADConst(0);
	code.PUTFIELD("b0", byte.class);

	code.LINE(24);
	code.LOAD("this");
	code.LOADConst(0);
	code.PUTFIELD("c0", char.class);

	code.LINE(25);
	code.LOAD("this");
	code.LOADConst(0);
	code.PUTFIELD("s0", short.class);

	code.LINE(26);
	code.LOAD("this");
	code.LOADConst(0);
	code.PUTFIELD("i0", int.class);

	code.LINE(27);
	code.LOAD("this");
	code.LOADConst(0L);
	code.PUTFIELD("l1", long.class);

	code.LINE(28);
	code.LOAD("this");
	code.LOADConst(0F);
	code.PUTFIELD("f1", float.class);

	code.LINE(29);
	code.LOAD("this");
	code.LOADConst(0D);
	code.PUTFIELD("d1", double.class);

	code.LINE(31);
	code.LOAD("this");
	code.LOADConst(-1);
	code.PUTFIELD("bn1", byte.class);

	code.LINE(33);
	code.LOAD("this");
	code.LOADConst(-1);
	code.PUTFIELD("sn1", short.class);

	code.LINE(34);
	code.LOAD("this");
	code.LOADConst(-1);
	code.PUTFIELD("in1", int.class);

	code.LINE(35);
	code.LOAD("this");
	code.LOADConst(Long.valueOf(-1L));
	code.PUTFIELD("ln1", long.class);

	code.LINE(36);
	code.LOAD("this");
	code.LOADConst(Float.valueOf("-1.0"));
	code.PUTFIELD("fn1", float.class);

	code.LINE(37);
	code.LOAD("this");
	code.LOADConst(Double.valueOf("-1.0"));
	code.PUTFIELD("dn1", double.class);
	code.RETURN();
});
classWriter.method(ACC_PUBLIC, int.class, "addInt")
	.parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(41);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.STORE("z",int.class);

	code.LINE(42);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.STORE("z");

	code.LINE(43);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.STORE("z");

	code.LINE(44);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.STORE("z");

	code.LINE(45);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.STORE("z");

	code.LINE(46);
	code.LOAD("x");
	code.LOAD("y");
	code.AND();
	code.STORE("z");

	code.LINE(47);
	code.LOAD("x");
	code.LOAD("y");
	code.OR();
	code.STORE("z");

	code.LINE(48);
	code.LOAD("x");
	code.LOAD("y");
	code.XOR();
	code.STORE("z");

	code.LINE(49);
	code.LOAD("x");
	code.LOAD("y");
	code.SHL();
	code.STORE("z");

	code.LINE(50);
	code.LOAD("x");
	code.LOAD("y");
	code.SHR();
	code.STORE("z");

	code.LINE(52);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.STORE("z");

	code.LINE(53);
	code.LOAD("this");
	code.GETFIELD("c", char.class);
	code.STORE("z");

	code.LINE(54);
	code.LOAD("this");
	code.GETFIELD("s", short.class);
	code.STORE("z");

	code.LINE(55);
	code.LOAD("this");
	code.GETFIELD("i", int.class);
	code.STORE("z");

	code.LINE(56);
	code.LOAD("this");
	code.GETFIELD("f", float.class);
	code.CONVERTTO(int.class);
	code.STORE("z");

	code.LINE(57);
	code.LOAD("this");
	code.GETFIELD("d", double.class);
	code.CONVERTTO(int.class);
	code.STORE("z");

	code.LINE(59);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.NEG();
	code.STORE("z");

	code.LINE(60);
	code.LOAD("this");
	code.GETFIELD("c", char.class);
	code.NEG();
	code.STORE("z");

	code.LINE(61);
	code.LOAD("this");
	code.GETFIELD("s", short.class);
	code.NEG();
	code.STORE("z");

	code.LINE(62);
	code.LOAD("this");
	code.GETFIELD("i", int.class);
	code.NEG();
	code.STORE("z");

	code.LINE(63);
	code.LOAD("this");
	code.GETFIELD("f", float.class);
	code.NEG();
	code.CONVERTTO(int.class);
	code.STORE("z");

	code.LINE(64);
	code.LOAD("this");
	code.GETFIELD("d", double.class);
	code.NEG();
	code.CONVERTTO(int.class);
	code.STORE("z");

	code.LINE(65);
	code.LOAD("z");
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, byte.class, "addByte")
	.parameter("x",byte.class)
	.parameter("y",byte.class).code(code -> {

	code.LINE(70);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.CONVERTTO(byte.class);
	code.STORE("z",byte.class);

	code.LINE(71);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.CONVERTTO(byte.class);
	code.STORE("z");

	code.LINE(72);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.CONVERTTO(byte.class);
	code.STORE("z");

	code.LINE(73);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.CONVERTTO(byte.class);
	code.STORE("z");

	code.LINE(74);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.CONVERTTO(byte.class);
	code.STORE("z");

	code.LINE(75);
	code.LOAD("x");
	code.LOAD("y");
	code.AND();
	code.CONVERTTO(byte.class);
	code.STORE("z");

	code.LINE(76);
	code.LOAD("x");
	code.LOAD("y");
	code.OR();
	code.CONVERTTO(byte.class);
	code.STORE("z");

	code.LINE(77);
	code.LOAD("x");
	code.LOAD("y");
	code.XOR();
	code.CONVERTTO(byte.class);
	code.STORE("z");

	code.LINE(79);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.STORE("z");

	code.LINE(80);
	code.LOAD("this");
	code.GETFIELD("c", char.class);
	code.CONVERTTO(byte.class);
	code.STORE("z");

	code.LINE(81);
	code.LOAD("this");
	code.GETFIELD("s", short.class);
	code.CONVERTTO(byte.class);
	code.STORE("z");

	code.LINE(82);
	code.LOAD("this");
	code.GETFIELD("i", int.class);
	code.CONVERTTO(byte.class);
	code.STORE("z");

	code.LINE(83);
	code.LOAD("this");
	code.GETFIELD("f", float.class);
	code.CONVERTTO(int.class);
	code.CONVERTTO(byte.class);
	code.STORE("z");

	code.LINE(84);
	code.LOAD("this");
	code.GETFIELD("d", double.class);
	code.CONVERTTO(int.class);
	code.CONVERTTO(byte.class);
	code.STORE("z");

	code.LINE(86);
	code.LOAD("z");
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, short.class, "addShort")
	.parameter("x",short.class)
	.parameter("y",short.class).code(code -> {

	code.LINE(91);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.CONVERTTO(short.class);
	code.STORE("z",short.class);

	code.LINE(92);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.CONVERTTO(short.class);
	code.STORE("z");

	code.LINE(93);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.CONVERTTO(short.class);
	code.STORE("z");

	code.LINE(94);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.CONVERTTO(short.class);
	code.STORE("z");

	code.LINE(95);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.CONVERTTO(short.class);
	code.STORE("z");

	code.LINE(96);
	code.LOAD("x");
	code.LOAD("y");
	code.AND();
	code.CONVERTTO(short.class);
	code.STORE("z");

	code.LINE(97);
	code.LOAD("x");
	code.LOAD("y");
	code.OR();
	code.CONVERTTO(short.class);
	code.STORE("z");

	code.LINE(98);
	code.LOAD("x");
	code.LOAD("y");
	code.XOR();
	code.CONVERTTO(short.class);
	code.STORE("z");

	code.LINE(100);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.CONVERTTO(short.class);
	code.STORE("z");

	code.LINE(101);
	code.LOAD("this");
	code.GETFIELD("c", char.class);
	code.CONVERTTO(short.class);
	code.STORE("z");

	code.LINE(102);
	code.LOAD("this");
	code.GETFIELD("s", short.class);
	code.STORE("z");

	code.LINE(103);
	code.LOAD("this");
	code.GETFIELD("i", int.class);
	code.CONVERTTO(short.class);
	code.STORE("z");

	code.LINE(104);
	code.LOAD("this");
	code.GETFIELD("f", float.class);
	code.CONVERTTO(int.class);
	code.CONVERTTO(short.class);
	code.STORE("z");

	code.LINE(105);
	code.LOAD("this");
	code.GETFIELD("d", double.class);
	code.CONVERTTO(int.class);
	code.CONVERTTO(short.class);
	code.STORE("z");

	code.LINE(106);
	code.LOAD("z");
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, long.class, "addLong")
	.parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(111);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.STORE("z",long.class);

	code.LINE(112);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.STORE("z");

	code.LINE(113);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.STORE("z");

	code.LINE(114);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.STORE("z");

	code.LINE(115);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.STORE("z");

	code.LINE(116);
	code.LOAD("x");
	code.LOAD("y");
	code.AND();
	code.STORE("z");

	code.LINE(117);
	code.LOAD("x");
	code.LOAD("y");
	code.OR();
	code.STORE("z");

	code.LINE(118);
	code.LOAD("x");
	code.LOAD("y");
	code.XOR();
	code.STORE("z");

	code.LINE(120);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.CONVERTTO(long.class);
	code.STORE("z");

	code.LINE(121);
	code.LOAD("this");
	code.GETFIELD("c", char.class);
	code.CONVERTTO(long.class);
	code.STORE("z");

	code.LINE(122);
	code.LOAD("this");
	code.GETFIELD("s", short.class);
	code.CONVERTTO(long.class);
	code.STORE("z");

	code.LINE(123);
	code.LOAD("this");
	code.GETFIELD("i", int.class);
	code.CONVERTTO(long.class);
	code.STORE("z");

	code.LINE(124);
	code.LOAD("this");
	code.GETFIELD("f", float.class);
	code.CONVERTTO(long.class);
	code.STORE("z");

	code.LINE(125);
	code.LOAD("this");
	code.GETFIELD("d", double.class);
	code.CONVERTTO(long.class);
	code.STORE("z");

	code.LINE(126);
	code.LOAD("z");
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, char.class, "mathChar")
	.parameter("x",char.class)
	.parameter("y",char.class).code(code -> {

	code.LINE(131);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.CONVERTTO(char.class);
	code.STORE("z",char.class);

	code.LINE(132);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.CONVERTTO(char.class);
	code.STORE("z");

	code.LINE(133);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.CONVERTTO(char.class);
	code.STORE("z");

	code.LINE(134);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.CONVERTTO(char.class);
	code.STORE("z");

	code.LINE(135);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.CONVERTTO(char.class);
	code.STORE("z");

	code.LINE(136);
	code.LOAD("x");
	code.LOAD("y");
	code.AND();
	code.CONVERTTO(char.class);
	code.STORE("z");

	code.LINE(137);
	code.LOAD("x");
	code.LOAD("y");
	code.OR();
	code.CONVERTTO(char.class);
	code.STORE("z");

	code.LINE(138);
	code.LOAD("x");
	code.LOAD("y");
	code.XOR();
	code.CONVERTTO(char.class);
	code.STORE("z");

	code.LINE(140);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.CONVERTTO(char.class);
	code.STORE("z");

	code.LINE(141);
	code.LOAD("this");
	code.GETFIELD("c", char.class);
	code.STORE("z");

	code.LINE(142);
	code.LOAD("this");
	code.GETFIELD("s", short.class);
	code.CONVERTTO(char.class);
	code.STORE("z");

	code.LINE(143);
	code.LOAD("this");
	code.GETFIELD("i", int.class);
	code.CONVERTTO(char.class);
	code.STORE("z");

	code.LINE(144);
	code.LOAD("this");
	code.GETFIELD("f", float.class);
	code.CONVERTTO(int.class);
	code.CONVERTTO(char.class);
	code.STORE("z");

	code.LINE(145);
	code.LOAD("this");
	code.GETFIELD("d", double.class);
	code.CONVERTTO(int.class);
	code.CONVERTTO(char.class);
	code.STORE("z");

	code.LINE(146);
	code.LOAD("z");
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, float.class, "mathFloat")
	.parameter("x",float.class)
	.parameter("y",float.class).code(code -> {

	code.LINE(151);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.STORE("z",float.class);

	code.LINE(152);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.STORE("z");

	code.LINE(153);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.STORE("z");

	code.LINE(154);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.STORE("z");

	code.LINE(155);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.STORE("z");

	code.LINE(160);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.CONVERTTO(float.class);
	code.STORE("z");

	code.LINE(161);
	code.LOAD("this");
	code.GETFIELD("c", char.class);
	code.CONVERTTO(float.class);
	code.STORE("z");

	code.LINE(162);
	code.LOAD("this");
	code.GETFIELD("s", short.class);
	code.CONVERTTO(float.class);
	code.STORE("z");

	code.LINE(163);
	code.LOAD("this");
	code.GETFIELD("i", int.class);
	code.CONVERTTO(float.class);
	code.STORE("z");

	code.LINE(164);
	code.LOAD("this");
	code.GETFIELD("f", float.class);
	code.STORE("z");

	code.LINE(165);
	code.LOAD("this");
	code.GETFIELD("d", double.class);
	code.CONVERTTO(float.class);
	code.STORE("z");

	code.LINE(166);
	code.LOAD("z");
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, double.class, "mathDouble")
	.parameter("x",double.class)
	.parameter("y",double.class).code(code -> {

	code.LINE(171);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.STORE("z",double.class);

	code.LINE(172);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.STORE("z");

	code.LINE(173);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.STORE("z");

	code.LINE(174);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.STORE("z");

	code.LINE(175);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.STORE("z");

	code.LINE(180);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.CONVERTTO(double.class);
	code.STORE("z");

	code.LINE(181);
	code.LOAD("this");
	code.GETFIELD("c", char.class);
	code.CONVERTTO(double.class);
	code.STORE("z");

	code.LINE(182);
	code.LOAD("this");
	code.GETFIELD("s", short.class);
	code.CONVERTTO(double.class);
	code.STORE("z");

	code.LINE(183);
	code.LOAD("this");
	code.GETFIELD("i", int.class);
	code.CONVERTTO(double.class);
	code.STORE("z");

	code.LINE(184);
	code.LOAD("this");
	code.GETFIELD("f", float.class);
	code.CONVERTTO(double.class);
	code.STORE("z");

	code.LINE(185);
	code.LOAD("this");
	code.GETFIELD("d", double.class);
	code.STORE("z");

	code.LINE(186);
	code.LOAD("z");
	code.RETURNTop();
});
return classWriter.end().toByteArray();
}
}
