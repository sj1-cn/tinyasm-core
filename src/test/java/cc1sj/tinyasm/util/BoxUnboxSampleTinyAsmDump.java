package cc1sj.tinyasm.util;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
@SuppressWarnings("unused")
public class BoxUnboxSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new BoxUnboxSampleTinyAsmDump().dump("cc1sj.tinyasm.util.BoxUnboxSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_funcLong(classBody);
		_funclong(classBody);
		_init(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _funcLong(ClassBody classBody) {
		MethodCode code = classBody.public_().method("funcLong")
			.parameter("l",Long.class).begin();

		code.LINE();
		code.LOAD("l");
		code.STORE("ll",Long.class);

		code.LINE();
		code.LOAD("ll");
		code.VIRTUAL(Long.class, "longValue")
			.return_(long.class).INVOKE();
		code.LOADConst(1L);
		code.ADD();
		code.STATIC(Long.class, "valueOf")
			.return_(Long.class)
			.parameter(long.class).INVOKE();
		code.STORE("l");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _funclong(ClassBody classBody) {
		MethodCode code = classBody.public_().method("funclong")
			.parameter("l",long.class).begin();

		code.LINE();
		code.LOAD("l");
		code.STATIC(Long.class, "valueOf")
			.return_(Long.class)
			.parameter(long.class).INVOKE();
		code.STORE("ll",Long.class);

		code.LINE();
		code.LOAD("ll");
		code.VIRTUAL(Long.class, "longValue")
			.return_(long.class).INVOKE();
		code.LOADConst(1L);
		code.ADD();
		code.STORE("l");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _init(ClassBody classBody) {
		MethodCode code = classBody.public_().method("init").begin();

		code.LINE();
		code.LOADConst(Long.valueOf(10L));
		code.STORE("l",long.class);

		code.LINE();
		code.LOADConst(Long.valueOf(100L));
		code.STATIC(Long.class, "valueOf")
			.return_(Long.class)
			.parameter(long.class).INVOKE();
		code.STORE("ll",Long.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("l");
		code.VIRTUAL("funclong")
			.parameter(long.class).INVOKE();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ll");
		code.VIRTUAL("funcLong")
			.parameter(Long.class).INVOKE();

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1L);
		code.VIRTUAL("funclong")
			.parameter(long.class).INVOKE();

		code.LINE();
		code.LOAD("this");
		code.LOADConst(Long.valueOf(2L));
		code.STATIC(Long.class, "valueOf")
			.return_(Long.class)
			.parameter(long.class).INVOKE();
		code.VIRTUAL("funcLong")
			.parameter(Long.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
