package nebula.tinyasm;
import org.objectweb.asm.Label;
import nebula.tinyasm.ClassBody;
import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.MethodCode;
import static org.objectweb.asm.Opcodes.*;
public class MethodCodeASMMathSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("nebula.tinyasm.MethodCodeASMMathSample").body();

classWriter.method("<init>").code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(3);
	code.LOAD("this");
	code.SPECIAL(java.lang.Object.class, "<init>").INVOKE();
	code.RETURN();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(int.class, "add").parameter("x",int.class).parameter("y",int.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(5);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(int.class, "mul").parameter("x",int.class).parameter("y",int.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(9);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(int.class, "sub").parameter("x",int.class).parameter("y",int.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(13);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(int.class, "div").parameter("x",int.class).parameter("y",int.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(17);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(int.class, "rem").parameter("x",int.class).parameter("y",int.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(21);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(int.class, "and").parameter("x",int.class).parameter("y",int.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(25);
	code.LOAD("x");
	code.LOAD("y");
	code.AND();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(int.class, "or").parameter("x",int.class).parameter("y",int.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(29);
	code.LOAD("x");
	code.LOAD("y");
	code.OR();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(int.class, "xor").parameter("x",int.class).parameter("y",int.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(33);
	code.LOAD("x");
	code.LOAD("y");
	code.XOR();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(byte.class, "add").parameter("x",byte.class).parameter("y",byte.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(37);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(byte.class, "mul").parameter("x",byte.class).parameter("y",byte.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(41);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(byte.class, "sub").parameter("x",byte.class).parameter("y",byte.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(45);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(byte.class, "div").parameter("x",byte.class).parameter("y",byte.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(49);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(byte.class, "rem").parameter("x",byte.class).parameter("y",byte.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(53);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(byte.class, "and").parameter("x",byte.class).parameter("y",byte.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(57);
	code.LOAD("x");
	code.LOAD("y");
	code.AND();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(byte.class, "or").parameter("x",byte.class).parameter("y",byte.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(61);
	code.LOAD("x");
	code.LOAD("y");
	code.OR();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(byte.class, "xor").parameter("x",byte.class).parameter("y",byte.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(65);
	code.LOAD("x");
	code.LOAD("y");
	code.XOR();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(short.class, "add").parameter("x",short.class).parameter("y",short.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(69);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.CONVERTTO(short.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(short.class, "mul").parameter("x",short.class).parameter("y",short.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(73);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.CONVERTTO(short.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(short.class, "sub").parameter("x",short.class).parameter("y",short.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(77);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.CONVERTTO(short.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(short.class, "div").parameter("x",short.class).parameter("y",short.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(81);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.CONVERTTO(short.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(short.class, "rem").parameter("x",short.class).parameter("y",short.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(85);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.CONVERTTO(short.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(short.class, "and").parameter("x",short.class).parameter("y",short.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(89);
	code.LOAD("x");
	code.LOAD("y");
	code.AND();
	code.CONVERTTO(short.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(short.class, "or").parameter("x",short.class).parameter("y",short.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(93);
	code.LOAD("x");
	code.LOAD("y");
	code.OR();
	code.CONVERTTO(short.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(short.class, "xor").parameter("x",short.class).parameter("y",short.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(97);
	code.LOAD("x");
	code.LOAD("y");
	code.XOR();
	code.CONVERTTO(short.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(long.class, "add").parameter("x",long.class).parameter("y",long.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(101);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(long.class, "mul").parameter("x",long.class).parameter("y",long.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(105);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(long.class, "sub").parameter("x",long.class).parameter("y",long.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(109);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(long.class, "div").parameter("x",long.class).parameter("y",long.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(113);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(long.class, "rem").parameter("x",long.class).parameter("y",long.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(117);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(long.class, "and").parameter("x",long.class).parameter("y",long.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(121);
	code.LOAD("x");
	code.LOAD("y");
	code.AND();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(long.class, "or").parameter("x",long.class).parameter("y",long.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(125);
	code.LOAD("x");
	code.LOAD("y");
	code.OR();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(long.class, "xor").parameter("x",long.class).parameter("y",long.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(129);
	code.LOAD("x");
	code.LOAD("y");
	code.XOR();
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(char.class, "add").parameter("x",char.class).parameter("y",char.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(133);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.CONVERTTO(char.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(char.class, "mul").parameter("x",char.class).parameter("y",char.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(137);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.CONVERTTO(char.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(char.class, "sub").parameter("x",char.class).parameter("y",char.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(141);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.CONVERTTO(char.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(char.class, "div").parameter("x",char.class).parameter("y",char.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(145);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.CONVERTTO(char.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(char.class, "rem").parameter("x",char.class).parameter("y",char.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(149);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.CONVERTTO(char.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(char.class, "and").parameter("x",char.class).parameter("y",char.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(153);
	code.LOAD("x");
	code.LOAD("y");
	code.AND();
	code.CONVERTTO(char.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(char.class, "or").parameter("x",char.class).parameter("y",char.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(157);
	code.LOAD("x");
	code.LOAD("y");
	code.OR();
	code.CONVERTTO(char.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method(char.class, "xor").parameter("x",char.class).parameter("y",char.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(161);
	code.LOAD("x");
	code.LOAD("y");
	code.XOR();
	code.CONVERTTO(char.class);
	code.RETURNTop();
Label label1 = new Label();
	code.visitLabel(label1);
});
return classWriter.end().toByteArray();
}
}
