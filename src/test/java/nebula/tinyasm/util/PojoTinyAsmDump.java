package nebula.tinyasm.util;
import org.objectweb.asm.Label;
import nebula.tinyasm.ClassBody;
import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.MethodCode;
import static org.objectweb.asm.Opcodes.*;
import nebula.tinyasm.Clazz;
@SuppressWarnings("unused")
public class PojoTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("nebula.tinyasm.util.Pojo").body();

classWriter.field("i1", int.class);
classWriter.field("i2", int.class);
classWriter.field("i3", int.class);
classWriter.field("i4", int.class);
classWriter.field("str", java.lang.String.class);
classWriter.method("<init>").parameter("i1",int.class)
	.parameter("i2",int.class)
	.parameter("i3",int.class)
	.parameter("i4",int.class)
	.parameter("str",java.lang.String.class).code(code -> {

	code.LINE(10);
	code.LOAD("this");
	code.SPECIAL(java.lang.Object.class, "<init>").INVOKE();

	code.LINE(11);
	code.LOAD("this");
	code.LOAD("i1");
	code.PUTFIELD("i1", int.class);

	code.LINE(12);
	code.LOAD("this");
	code.LOAD("i2");
	code.PUTFIELD("i2", int.class);

	code.LINE(13);
	code.LOAD("this");
	code.LOAD("i3");
	code.PUTFIELD("i3", int.class);

	code.LINE(14);
	code.LOAD("this");
	code.LOAD("i4");
	code.PUTFIELD("i4", int.class);

	code.LINE(15);
	code.LOAD("this");
	code.LOAD("str");
	code.PUTFIELD("str", java.lang.String.class);

	code.LINE(16);
	code.RETURN();
});
classWriter.method(int.class, "getI1").code(code -> {

	code.LINE(18);
	code.LOAD("this");
	code.GETFIELD("i1", int.class);
	code.RETURNTop();
});
classWriter.method("setI1").parameter("i1",int.class).code(code -> {

	code.LINE(21);
	code.LOAD("this");
	code.LOAD("i1");
	code.PUTFIELD("i1", int.class);

	code.LINE(22);
	code.RETURN();
});
classWriter.method(int.class, "getI2").code(code -> {

	code.LINE(24);
	code.LOAD("this");
	code.GETFIELD("i2", int.class);
	code.RETURNTop();
});
classWriter.method("setI2").parameter("i2",int.class).code(code -> {

	code.LINE(27);
	code.LOAD("this");
	code.LOAD("i2");
	code.PUTFIELD("i2", int.class);

	code.LINE(28);
	code.RETURN();
});
classWriter.method(int.class, "getI3").code(code -> {

	code.LINE(30);
	code.LOAD("this");
	code.GETFIELD("i3", int.class);
	code.RETURNTop();
});
classWriter.method("setI3").parameter("i3",int.class).code(code -> {

	code.LINE(33);
	code.LOAD("this");
	code.LOAD("i3");
	code.PUTFIELD("i3", int.class);

	code.LINE(34);
	code.RETURN();
});
classWriter.method(int.class, "getI4").code(code -> {

	code.LINE(36);
	code.LOAD("this");
	code.GETFIELD("i4", int.class);
	code.RETURNTop();
});
classWriter.method("setI4").parameter("i4",int.class).code(code -> {

	code.LINE(39);
	code.LOAD("this");
	code.LOAD("i4");
	code.PUTFIELD("i4", int.class);

	code.LINE(40);
	code.RETURN();
});
classWriter.method(java.lang.String.class, "getStr").code(code -> {

	code.LINE(42);
	code.LOAD("this");
	code.GETFIELD("str", java.lang.String.class);
	code.RETURNTop();
});
classWriter.method("setStr").parameter("str",java.lang.String.class).code(code -> {

	code.LINE(45);
	code.LOAD("this");
	code.LOAD("str");
	code.PUTFIELD("str", java.lang.String.class);

	code.LINE(46);
	code.RETURN();
});
classWriter.method(java.lang.String.class, "toString").code(code -> {

	code.LINE(49);
	code.NEW(java.lang.StringBuilder.class);
	code.DUP();
	code.SPECIAL(java.lang.StringBuilder.class, "<init>").INVOKE();
	code.STORE("builder",java.lang.StringBuilder.class);

	code.LINE(50);
	code.LOAD("builder");
	code.LOADConst("Pojo [i1=");
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.LOAD("this");
	code.GETFIELD("i1", int.class);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(int.class).INVOKE();
	code.LOADConst(", i2=");

	code.LINE(51);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.LOAD("this");
	code.GETFIELD("i2", int.class);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(int.class).INVOKE();
	code.LOADConst(", i3=");

	code.LINE(52);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.LOAD("this");
	code.GETFIELD("i3", int.class);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(int.class).INVOKE();
	code.LOADConst(", i4=");

	code.LINE(53);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.LOAD("this");
	code.GETFIELD("i4", int.class);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(int.class).INVOKE();
	code.LOADConst(", str=");

	code.LINE(54);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.LOAD("this");
	code.GETFIELD("str", java.lang.String.class);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.LOADConst("]");

	code.LINE(55);
	code.VIRTUAL(java.lang.StringBuilder.class, "append")
		.reTurn(java.lang.StringBuilder.class)
		.parameter(java.lang.String.class).INVOKE();
	code.POP();

	code.LINE(56);
	code.LOAD("builder");
	code.VIRTUAL(java.lang.StringBuilder.class, "toString")
		.reTurn(java.lang.String.class).INVOKE();
	code.RETURNTop();
});
return classWriter.end().toByteArray();
}
}
