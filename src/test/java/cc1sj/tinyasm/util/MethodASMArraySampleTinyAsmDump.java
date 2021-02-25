package cc1sj.tinyasm.util;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.lang.Object;
import java.lang.String;
@SuppressWarnings("unused")
public class MethodASMArraySampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classBody = ClassBuilder.make("cc1sj.tinyasm.util.MethodASMArraySample").access(ACC_PUBLIC | ACC_SUPER).body();

classBody.field("ba", Clazz.of(byte[].class));
classBody.field("ca", Clazz.of(char[].class));
classBody.field("sa", Clazz.of(short[].class));
classBody.field("ia", Clazz.of(int[].class));
classBody.field("la", Clazz.of(long[].class));
classBody.field("fa", Clazz.of(float[].class));
classBody.field("da", Clazz.of(double[].class));
classBody.field("stra", Clazz.of(String[].class));
{
	MethodCode code = classBody.method("<init>").begin();

	code.LINE(3);
	code.LOAD("this");
	code.SPECIAL(Object.class, "<init>").INVOKE();
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("init").begin();

	code.LINE(14);
	code.LOAD("this");
	code.LOADConst(10);
	code.NEWARRAY(byte.class);
	code.PUTFIELD("ba", byte[].class);

	code.LINE(15);
	code.LOAD("this");
	code.LOADConst(10);
	code.NEWARRAY(char.class);
	code.PUTFIELD("ca", char[].class);

	code.LINE(16);
	code.LOAD("this");
	code.LOADConst(10);
	code.NEWARRAY(short.class);
	code.PUTFIELD("sa", short[].class);

	code.LINE(17);
	code.LOAD("this");
	code.LOADConst(10);
	code.NEWARRAY(int.class);
	code.PUTFIELD("ia", int[].class);

	code.LINE(18);
	code.LOAD("this");
	code.LOADConst(10);
	code.NEWARRAY(long.class);
	code.PUTFIELD("la", long[].class);

	code.LINE(19);
	code.LOAD("this");
	code.LOADConst(10);
	code.NEWARRAY(float.class);
	code.PUTFIELD("fa", float[].class);

	code.LINE(20);
	code.LOAD("this");
	code.LOADConst(10);
	code.NEWARRAY(double.class);
	code.PUTFIELD("da", double[].class);

	code.LINE(21);
	code.LOAD("this");
	code.LOADConst(10);
	code.NEWARRAY(String.class);
	code.PUTFIELD("stra", String[].class);

	code.LINE(22);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setArrayValue").begin();

	code.LINE(25);
	code.LOAD("this");
	code.GETFIELD("ba", byte[].class);
	code.LOADConst(0);
	code.LOADConst(100);
	code.ARRAYSTORE();

	code.LINE(26);
	code.LOAD("this");
	code.GETFIELD("ca", char[].class);
	code.LOADConst(0);
	code.LOADConst(1000);
	code.ARRAYSTORE();

	code.LINE(27);
	code.LOAD("this");
	code.GETFIELD("sa", short[].class);
	code.LOADConst(0);
	code.LOADConst(10000);
	code.ARRAYSTORE();

	code.LINE(28);
	code.LOAD("this");
	code.GETFIELD("ia", int[].class);
	code.LOADConst(0);
	code.LOADConst(Integer.valueOf(100000));
	code.ARRAYSTORE();

	code.LINE(29);
	code.LOAD("this");
	code.GETFIELD("la", long[].class);
	code.LOADConst(0);
	code.LOADConst(Long.valueOf(1000000L));
	code.ARRAYSTORE();

	code.LINE(30);
	code.LOAD("this");
	code.GETFIELD("fa", float[].class);
	code.LOADConst(0);
	code.LOADConst(Float.valueOf("1.0E7"));
	code.ARRAYSTORE();

	code.LINE(31);
	code.LOAD("this");
	code.GETFIELD("da", double[].class);
	code.LOADConst(0);
	code.LOADConst(Double.valueOf("1.0E8"));
	code.ARRAYSTORE();

	code.LINE(32);
	code.LOAD("this");
	code.GETFIELD("stra", String[].class);
	code.LOADConst(0);
	code.LOADConst("1000000000s");
	code.ARRAYSTORE();

	code.LINE(33);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("getArrayValue").begin();

	code.LINE(36);
	code.LOAD("this");
	code.GETFIELD("ba", byte[].class);
	code.LOADConst(1);
	code.LOAD("this");
	code.GETFIELD("ba", byte[].class);
	code.LOADConst(0);
	code.ARRAYLOAD();
	code.ARRAYSTORE();

	code.LINE(37);
	code.LOAD("this");
	code.GETFIELD("ca", char[].class);
	code.LOADConst(1);
	code.LOAD("this");
	code.GETFIELD("ca", char[].class);
	code.LOADConst(0);
	code.ARRAYLOAD();
	code.ARRAYSTORE();

	code.LINE(38);
	code.LOAD("this");
	code.GETFIELD("sa", short[].class);
	code.LOADConst(1);
	code.LOAD("this");
	code.GETFIELD("sa", short[].class);
	code.LOADConst(0);
	code.ARRAYLOAD();
	code.ARRAYSTORE();

	code.LINE(39);
	code.LOAD("this");
	code.GETFIELD("ia", int[].class);
	code.LOADConst(1);
	code.LOAD("this");
	code.GETFIELD("ia", int[].class);
	code.LOADConst(0);
	code.ARRAYLOAD();
	code.ARRAYSTORE();

	code.LINE(40);
	code.LOAD("this");
	code.GETFIELD("la", long[].class);
	code.LOADConst(1);
	code.LOAD("this");
	code.GETFIELD("la", long[].class);
	code.LOADConst(0);
	code.ARRAYLOAD();
	code.ARRAYSTORE();

	code.LINE(41);
	code.LOAD("this");
	code.GETFIELD("fa", float[].class);
	code.LOADConst(1);
	code.LOAD("this");
	code.GETFIELD("fa", float[].class);
	code.LOADConst(0);
	code.ARRAYLOAD();
	code.ARRAYSTORE();

	code.LINE(42);
	code.LOAD("this");
	code.GETFIELD("da", double[].class);
	code.LOADConst(1);
	code.LOAD("this");
	code.GETFIELD("da", double[].class);
	code.LOADConst(0);
	code.ARRAYLOAD();
	code.ARRAYSTORE();

	code.LINE(43);
	code.LOAD("this");
	code.GETFIELD("stra", String[].class);
	code.LOADConst(1);
	code.LOAD("this");
	code.GETFIELD("stra", String[].class);
	code.LOADConst(0);
	code.ARRAYLOAD();
	code.ARRAYSTORE();

	code.LINE(44);
	code.RETURN();
	code.END();
}

return classBody.end().toByteArray();
}
}
