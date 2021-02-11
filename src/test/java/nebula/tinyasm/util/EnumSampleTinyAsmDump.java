package nebula.tinyasm.util;
import org.objectweb.asm.Label;
import nebula.tinyasm.ClassBody;
import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import nebula.tinyasm.Clazz;
@SuppressWarnings("unused")
public class EnumSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("nebula.tinyasm.util.EnumSample").body();

classWriter.staticField(ACC_PUBLIC | ACC_FINAL | ACC_STATIC | ACC_ENUM, "FIRST", Clazz.of(nebula.tinyasm.util.EnumSample.class));
classWriter.staticField(ACC_PUBLIC | ACC_FINAL | ACC_STATIC | ACC_ENUM, "SECOND", Clazz.of(nebula.tinyasm.util.EnumSample.class));
classWriter.staticField(ACC_PUBLIC | ACC_FINAL | ACC_STATIC | ACC_ENUM, "THIRD", Clazz.of(nebula.tinyasm.util.EnumSample.class));
classWriter.staticField("ENUM$VALUES", nebula.tinyasm.util.EnumSample[].class);
classWriter.staticMethod(ACC_STATIC, "<clinit>").code(code -> {

	code.LINE(4);
	code.NEW(nebula.tinyasm.util.EnumSample.class);
	code.DUP();
	code.LOADConst("FIRST");
	code.LOADConst(0);
	code.SPECIAL(nebula.tinyasm.util.EnumSample.class, "<init>")
		.parameter(java.lang.String.class)
		.parameter(int.class).INVOKE();
	code.PUTSTATIC(nebula.tinyasm.util.EnumSample.class, "FIRST", nebula.tinyasm.util.EnumSample.class);

	code.LINE(5);
	code.NEW(nebula.tinyasm.util.EnumSample.class);
	code.DUP();
	code.LOADConst("SECOND");
	code.LOADConst(1);
	code.SPECIAL(nebula.tinyasm.util.EnumSample.class, "<init>")
		.parameter(java.lang.String.class)
		.parameter(int.class).INVOKE();
	code.PUTSTATIC(nebula.tinyasm.util.EnumSample.class, "SECOND", nebula.tinyasm.util.EnumSample.class);

	code.LINE(6);
	code.NEW(nebula.tinyasm.util.EnumSample.class);
	code.DUP();
	code.LOADConst("THIRD");
	code.LOADConst(2);
	code.SPECIAL(nebula.tinyasm.util.EnumSample.class, "<init>")
		.parameter(java.lang.String.class)
		.parameter(int.class).INVOKE();
	code.PUTSTATIC(nebula.tinyasm.util.EnumSample.class, "THIRD", nebula.tinyasm.util.EnumSample.class);

	code.LINE(3);
	code.LOADConst(3);
	code.NEWARRAY(nebula.tinyasm.util.EnumSample.class);
	code.DUP();
	code.LOADConst(0);
	code.GETSTATIC(nebula.tinyasm.util.EnumSample.class, "FIRST", nebula.tinyasm.util.EnumSample.class);
	code.ARRAYSTORE();
	code.DUP();
	code.LOADConst(1);
	code.GETSTATIC(nebula.tinyasm.util.EnumSample.class, "SECOND", nebula.tinyasm.util.EnumSample.class);
	code.ARRAYSTORE();
	code.DUP();
	code.LOADConst(2);
	code.GETSTATIC(nebula.tinyasm.util.EnumSample.class, "THIRD", nebula.tinyasm.util.EnumSample.class);
	code.ARRAYSTORE();
	code.PUTSTATIC(nebula.tinyasm.util.EnumSample.class, "ENUM$VALUES", nebula.tinyasm.util.EnumSample[].class);
	code.RETURN();
});
classWriter.method(ACC_PRIVATE, "<init>").parameter("",java.lang.String.class)
	.parameter("",int.class).code(code -> {

	code.LINE(3);
	code.LOAD("this");
	code.LOAD("");
	code.LOAD("");
	code.SPECIAL(java.lang.Enum.class, "<init>")
		.parameter(java.lang.String.class)
		.parameter(int.class).INVOKE();
	code.RETURN();
});
classWriter.staticMethod(ACC_PUBLIC | ACC_STATIC, nebula.tinyasm.util.EnumSample[].class, "values").code(code -> {

	code.LINE(1);
	code.GETSTATIC(nebula.tinyasm.util.EnumSample.class, "ENUM$VALUES", nebula.tinyasm.util.EnumSample[].class);
	code.DUP();
	code.STORE("var0");
	code.LOADConst(0);
	code.LOAD("var0");
	code.ARRAYLENGTH();
	code.DUP();
	code.STORE("var1");
	code.NEWARRAY(nebula.tinyasm.util.EnumSample.class);
	code.DUP();
	code.STORE("var2");
	code.LOADConst(0);
	code.LOAD("var1");
	code.STATIC(java.lang.System.class, "arraycopy")
		.parameter(java.lang.Object.class)
		.parameter(int.class)
		.parameter(java.lang.Object.class)
		.parameter(int.class)
		.parameter(int.class).INVOKE();
	code.LOAD("var2");
	code.RETURNTop();
});
classWriter.staticMethod(ACC_PUBLIC | ACC_STATIC, nebula.tinyasm.util.EnumSample.class, "valueOf").parameter("",java.lang.String.class).code(code -> {

	code.LINE(1);
	code.LOADConst(Type.getType("Lnebula/tinyasm/util/EnumSample;"));
	code.LOAD("");
	code.STATIC(java.lang.Enum.class, "valueOf")
		.reTurn(java.lang.Enum.class)
		.parameter(java.lang.Class.class)
		.parameter(java.lang.String.class).INVOKE();
	code.CHECKCAST(nebula.tinyasm.util.EnumSample.class);
	code.RETURNTop();
});
return classWriter.end().toByteArray();
}
}
