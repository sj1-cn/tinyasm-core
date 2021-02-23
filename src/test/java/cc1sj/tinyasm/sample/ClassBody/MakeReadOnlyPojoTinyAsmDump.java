package cc1sj.tinyasm.sample.ClassBody;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
@SuppressWarnings("unused")
public class MakeReadOnlyPojoTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("cc1sj.tinyasm.sample.ClassBody.MakeReadOnlyPojo").access(ACC_PUBLIC | ACC_SUPER).body();

classWriter.field(ACC_PRIVATE, "b", Clazz.of(byte.class));
classWriter.field(ACC_PRIVATE, "c", Clazz.of(char.class));
classWriter.field(ACC_PRIVATE, "s", Clazz.of(short.class));
classWriter.field(ACC_PRIVATE, "i", Clazz.of(int.class));
classWriter.field(ACC_PRIVATE, "l", Clazz.of(long.class));
classWriter.field(ACC_PRIVATE, "f", Clazz.of(float.class));
classWriter.field(ACC_PRIVATE, "d", Clazz.of(double.class));
classWriter.field(ACC_PRIVATE, "str", Clazz.of(java.lang.String.class));
classWriter.method(ACC_PUBLIC, "<init>")
	.parameter("b",byte.class)
	.parameter("c",char.class)
	.parameter("s",short.class)
	.parameter("i",int.class)
	.parameter("l",long.class)
	.parameter("f",float.class)
	.parameter("d",double.class)
	.parameter("str",java.lang.String.class).code(code -> {

	code.LINE(13);
	code.LOAD("this");
	code.SPECIAL(java.lang.Object.class, "<init>").INVOKE();

	code.LINE(14);
	code.LOAD("this");
	code.LOAD("b");
	code.PUTFIELD("b", byte.class);

	code.LINE(15);
	code.LOAD("this");
	code.LOAD("c");
	code.PUTFIELD("c", char.class);

	code.LINE(16);
	code.LOAD("this");
	code.LOAD("s");
	code.PUTFIELD("s", short.class);

	code.LINE(17);
	code.LOAD("this");
	code.LOAD("i");
	code.PUTFIELD("i", int.class);

	code.LINE(18);
	code.LOAD("this");
	code.LOAD("l");
	code.PUTFIELD("l", long.class);

	code.LINE(19);
	code.LOAD("this");
	code.LOAD("f");
	code.PUTFIELD("f", float.class);

	code.LINE(20);
	code.LOAD("this");
	code.LOAD("d");
	code.PUTFIELD("d", double.class);

	code.LINE(21);
	code.LOAD("this");
	code.LOAD("str");
	code.PUTFIELD("str", java.lang.String.class);

	code.LINE(22);
	code.RETURN();
});
classWriter.method(ACC_PUBLIC, byte.class, "getB").code(code -> {

	code.LINE(25);
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, char.class, "getC").code(code -> {

	code.LINE(29);
	code.LOAD("this");
	code.GETFIELD("c", char.class);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, short.class, "getS").code(code -> {

	code.LINE(33);
	code.LOAD("this");
	code.GETFIELD("s", short.class);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, int.class, "getI").code(code -> {

	code.LINE(37);
	code.LOAD("this");
	code.GETFIELD("i", int.class);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, long.class, "getL").code(code -> {

	code.LINE(41);
	code.LOAD("this");
	code.GETFIELD("l", long.class);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, float.class, "getF").code(code -> {

	code.LINE(45);
	code.LOAD("this");
	code.GETFIELD("f", float.class);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, double.class, "getD").code(code -> {

	code.LINE(49);
	code.LOAD("this");
	code.GETFIELD("d", double.class);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, java.lang.String.class, "getStr").code(code -> {

	code.LINE(53);
	code.LOAD("this");
	code.GETFIELD("str", java.lang.String.class);
	code.RETURNTop();
});
classWriter.method(ACC_PUBLIC, java.lang.String.class, "toString").code(code -> {

	code.LINE(58);
	code.NEW(java.lang.StringBuilder.class);
	code.DUP();
	code.SPECIAL(java.lang.StringBuilder.class, "<init>").INVOKE();
	code.STORE("builder",java.lang.StringBuilder.class);

	code.LINE(59);
	code.LOAD("builder");
	code.LOADConst("MakeReadOnlyPojo [b=");
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.LOAD("this");
	code.GETFIELD("b", byte.class);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(int.class).INVOKE();
	code.LOADConst(", c=");

	code.LINE(60);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.LOAD("this");
	code.GETFIELD("c", char.class);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(char.class).INVOKE();
	code.LOADConst(", s=");

	code.LINE(61);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.LOAD("this");
	code.GETFIELD("s", short.class);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(int.class).INVOKE();
	code.LOADConst(", i=");

	code.LINE(62);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.LOAD("this");
	code.GETFIELD("i", int.class);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(int.class).INVOKE();
	code.LOADConst(", l=");

	code.LINE(63);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.LOAD("this");
	code.GETFIELD("l", long.class);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(long.class).INVOKE();
	code.LOADConst(", f=");

	code.LINE(64);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.LOAD("this");
	code.GETFIELD("f", float.class);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(float.class).INVOKE();
	code.LOADConst(", d=");

	code.LINE(65);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.LOAD("this");
	code.GETFIELD("d", double.class);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(double.class).INVOKE();
	code.LOADConst(", str=");

	code.LINE(66);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.LOAD("this");
	code.GETFIELD("str", java.lang.String.class);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.LOADConst("]");

	code.LINE(67);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.POP();

	code.LINE(68);
	code.LOAD("builder");
	code.VIRTUAL(java.lang.StringBuilder.class, "toString")
		.reTurn(java.lang.String.class).INVOKE();
	code.RETURNTop();
});
return classWriter.end().toByteArray();
}
}
