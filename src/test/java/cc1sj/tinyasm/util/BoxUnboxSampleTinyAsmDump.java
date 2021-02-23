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
public class BoxUnboxSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("cc1sj.tinyasm.util.BoxUnboxSample").access(ACC_PUBLIC | ACC_SUPER).body();

classWriter.method("<init>").code(code -> {

	code.LINE(3);
	code.LOAD("this");
	code.SPECIAL(java.lang.Object.class, "<init>").INVOKE();
	code.RETURN();
});
classWriter.method("funcLong")
	.parameter("l",java.lang.Long.class).code(code -> {

	code.LINE(5);
	code.LOAD("l");
	code.STORE("ll",java.lang.Long.class);

	code.LINE(6);
	code.LOAD("ll");
	code.VIRTUAL(java.lang.Long.class, "longValue")
		.reTurn(long.class).INVOKE();
	code.LOADConst(1L);
	code.ADD();
	code.STATIC(java.lang.Long.class, "valueOf")
		.reTurn(java.lang.Long.class)
		.parameter(long.class).INVOKE();
	code.STORE("l");

	code.LINE(7);
	code.RETURN();
});
classWriter.method("funclong")
	.parameter("l",long.class).code(code -> {

	code.LINE(10);
	code.LOAD("l");
	code.STATIC(java.lang.Long.class, "valueOf")
		.reTurn(java.lang.Long.class)
		.parameter(long.class).INVOKE();
	code.STORE("ll",java.lang.Long.class);

	code.LINE(11);
	code.LOAD("ll");
	code.VIRTUAL(java.lang.Long.class, "longValue")
		.reTurn(long.class).INVOKE();
	code.LOADConst(1L);
	code.ADD();
	code.STORE("l");

	code.LINE(12);
	code.RETURN();
});
classWriter.method("init").code(code -> {

	code.LINE(15);
	code.LOADConst(Long.valueOf(10L));
	code.STORE("l",long.class);

	code.LINE(16);
	code.LOADConst(Long.valueOf(100L));
	code.STATIC(java.lang.Long.class, "valueOf")
		.reTurn(java.lang.Long.class)
		.parameter(long.class).INVOKE();
	code.STORE("ll",java.lang.Long.class);

	code.LINE(17);
	code.LOAD("this");
	code.LOAD("l");
	code.VIRTUAL(cc1sj.tinyasm.util.BoxUnboxSample.class, "funclong")
		.parameter(long.class).INVOKE();

	code.LINE(18);
	code.LOAD("this");
	code.LOAD("ll");
	code.VIRTUAL(cc1sj.tinyasm.util.BoxUnboxSample.class, "funcLong")
		.parameter(java.lang.Long.class).INVOKE();

	code.LINE(19);
	code.LOAD("this");
	code.LOADConst(1L);
	code.VIRTUAL(cc1sj.tinyasm.util.BoxUnboxSample.class, "funclong")
		.parameter(long.class).INVOKE();

	code.LINE(20);
	code.LOAD("this");
	code.LOADConst(Long.valueOf(2L));
	code.STATIC(java.lang.Long.class, "valueOf")
		.reTurn(java.lang.Long.class)
		.parameter(long.class).INVOKE();
	code.VIRTUAL(cc1sj.tinyasm.util.BoxUnboxSample.class, "funcLong")
		.parameter(java.lang.Long.class).INVOKE();

	code.LINE(21);
	code.RETURN();
});
return classWriter.end().toByteArray();
}
}
