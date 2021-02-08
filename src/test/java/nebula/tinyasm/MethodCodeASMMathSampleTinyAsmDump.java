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

	code.LINE(3);
	code.LOAD("this");
	code.SPECIAL(java.lang.Object.class, "<init>").INVOKE();
	code.RETURN();
});
classWriter.method(int.class, "add").parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(5);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.RETURNTop();
});
classWriter.method(int.class, "mul").parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(9);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.RETURNTop();
});
classWriter.method(int.class, "sub").parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(13);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.RETURNTop();
});
classWriter.method(int.class, "div").parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(17);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.RETURNTop();
});
classWriter.method(int.class, "rem").parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(21);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.RETURNTop();
});
classWriter.method(int.class, "and").parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(25);
	code.LOAD("x");
	code.LOAD("y");
	code.AND();
	code.RETURNTop();
});
classWriter.method(int.class, "or").parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(29);
	code.LOAD("x");
	code.LOAD("y");
	code.OR();
	code.RETURNTop();
});
classWriter.method(int.class, "xor").parameter("x",int.class)
	.parameter("y",int.class).code(code -> {

	code.LINE(33);
	code.LOAD("x");
	code.LOAD("y");
	code.XOR();
	code.RETURNTop();
});
classWriter.method(byte.class, "add").parameter("x",byte.class)
	.parameter("y",byte.class).code(code -> {

	code.LINE(37);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
});
classWriter.method(byte.class, "mul").parameter("x",byte.class)
	.parameter("y",byte.class).code(code -> {

	code.LINE(41);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
});
classWriter.method(byte.class, "sub").parameter("x",byte.class)
	.parameter("y",byte.class).code(code -> {

	code.LINE(45);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
});
classWriter.method(byte.class, "div").parameter("x",byte.class)
	.parameter("y",byte.class).code(code -> {

	code.LINE(49);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
});
classWriter.method(byte.class, "rem").parameter("x",byte.class)
	.parameter("y",byte.class).code(code -> {

	code.LINE(53);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
});
classWriter.method(byte.class, "and").parameter("x",byte.class)
	.parameter("y",byte.class).code(code -> {

	code.LINE(57);
	code.LOAD("x");
	code.LOAD("y");
	code.AND();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
});
classWriter.method(byte.class, "or").parameter("x",byte.class)
	.parameter("y",byte.class).code(code -> {

	code.LINE(61);
	code.LOAD("x");
	code.LOAD("y");
	code.OR();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
});
classWriter.method(byte.class, "xor").parameter("x",byte.class)
	.parameter("y",byte.class).code(code -> {

	code.LINE(65);
	code.LOAD("x");
	code.LOAD("y");
	code.XOR();
	code.CONVERTTO(byte.class);
	code.RETURNTop();
});
classWriter.method(short.class, "add").parameter("x",short.class)
	.parameter("y",short.class).code(code -> {

	code.LINE(69);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.CONVERTTO(short.class);
	code.RETURNTop();
});
classWriter.method(short.class, "mul").parameter("x",short.class)
	.parameter("y",short.class).code(code -> {

	code.LINE(73);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.CONVERTTO(short.class);
	code.RETURNTop();
});
classWriter.method(short.class, "sub").parameter("x",short.class)
	.parameter("y",short.class).code(code -> {

	code.LINE(77);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.CONVERTTO(short.class);
	code.RETURNTop();
});
classWriter.method(short.class, "div").parameter("x",short.class)
	.parameter("y",short.class).code(code -> {

	code.LINE(81);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.CONVERTTO(short.class);
	code.RETURNTop();
});
classWriter.method(short.class, "rem").parameter("x",short.class)
	.parameter("y",short.class).code(code -> {

	code.LINE(85);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.CONVERTTO(short.class);
	code.RETURNTop();
});
classWriter.method(short.class, "and").parameter("x",short.class)
	.parameter("y",short.class).code(code -> {

	code.LINE(89);
	code.LOAD("x");
	code.LOAD("y");
	code.AND();
	code.CONVERTTO(short.class);
	code.RETURNTop();
});
classWriter.method(short.class, "or").parameter("x",short.class)
	.parameter("y",short.class).code(code -> {

	code.LINE(93);
	code.LOAD("x");
	code.LOAD("y");
	code.OR();
	code.CONVERTTO(short.class);
	code.RETURNTop();
});
classWriter.method(short.class, "xor").parameter("x",short.class)
	.parameter("y",short.class).code(code -> {

	code.LINE(97);
	code.LOAD("x");
	code.LOAD("y");
	code.XOR();
	code.CONVERTTO(short.class);
	code.RETURNTop();
});
classWriter.method(long.class, "add").parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(101);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.RETURNTop();
});
classWriter.method(long.class, "mul").parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(105);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.RETURNTop();
});
classWriter.method(long.class, "sub").parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(109);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.RETURNTop();
});
classWriter.method(long.class, "div").parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(113);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.RETURNTop();
});
classWriter.method(long.class, "rem").parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(117);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.RETURNTop();
});
classWriter.method(long.class, "and").parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(121);
	code.LOAD("x");
	code.LOAD("y");
	code.AND();
	code.RETURNTop();
});
classWriter.method(long.class, "or").parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(125);
	code.LOAD("x");
	code.LOAD("y");
	code.OR();
	code.RETURNTop();
});
classWriter.method(long.class, "xor").parameter("x",long.class)
	.parameter("y",long.class).code(code -> {

	code.LINE(129);
	code.LOAD("x");
	code.LOAD("y");
	code.XOR();
	code.RETURNTop();
});
classWriter.method(char.class, "add").parameter("x",char.class)
	.parameter("y",char.class).code(code -> {

	code.LINE(133);
	code.LOAD("x");
	code.LOAD("y");
	code.ADD();
	code.CONVERTTO(char.class);
	code.RETURNTop();
});
classWriter.method(char.class, "mul").parameter("x",char.class)
	.parameter("y",char.class).code(code -> {

	code.LINE(137);
	code.LOAD("x");
	code.LOAD("y");
	code.MUL();
	code.CONVERTTO(char.class);
	code.RETURNTop();
});
classWriter.method(char.class, "sub").parameter("x",char.class)
	.parameter("y",char.class).code(code -> {

	code.LINE(141);
	code.LOAD("x");
	code.LOAD("y");
	code.SUB();
	code.CONVERTTO(char.class);
	code.RETURNTop();
});
classWriter.method(char.class, "div").parameter("x",char.class)
	.parameter("y",char.class).code(code -> {

	code.LINE(145);
	code.LOAD("x");
	code.LOAD("y");
	code.DIV();
	code.CONVERTTO(char.class);
	code.RETURNTop();
});
classWriter.method(char.class, "rem").parameter("x",char.class)
	.parameter("y",char.class).code(code -> {

	code.LINE(149);
	code.LOAD("x");
	code.LOAD("y");
	code.REM();
	code.CONVERTTO(char.class);
	code.RETURNTop();
});
classWriter.method(char.class, "and").parameter("x",char.class)
	.parameter("y",char.class).code(code -> {

	code.LINE(153);
	code.LOAD("x");
	code.LOAD("y");
	code.AND();
	code.CONVERTTO(char.class);
	code.RETURNTop();
});
classWriter.method(char.class, "or").parameter("x",char.class)
	.parameter("y",char.class).code(code -> {

	code.LINE(157);
	code.LOAD("x");
	code.LOAD("y");
	code.OR();
	code.CONVERTTO(char.class);
	code.RETURNTop();
});
classWriter.method(char.class, "xor").parameter("x",char.class)
	.parameter("y",char.class).code(code -> {

	code.LINE(161);
	code.LOAD("x");
	code.LOAD("y");
	code.XOR();
	code.CONVERTTO(char.class);
	code.RETURNTop();
});
return classWriter.end().toByteArray();
}
}
