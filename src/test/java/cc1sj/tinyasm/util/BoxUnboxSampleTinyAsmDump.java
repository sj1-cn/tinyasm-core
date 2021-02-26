package cc1sj.tinyasm.util;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.lang.Long;
import java.lang.Object;
@SuppressWarnings("unused")
public class BoxUnboxSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new BoxUnboxSampleTinyAsmDump().__dump__("cc1sj.tinyasm.util.BoxUnboxSample");
	}

	public byte[] __dump__(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className).access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_funcLong(classBody);
		_funclong(classBody);
		_init(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method("<init>").begin();

		code.LINE(3);
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _funcLong(ClassBody classBody) {
		MethodCode code = classBody.method("funcLong")
		.parameter("l",Long.class).begin();

		code.LINE(5);
		code.LOAD("l");
		code.STORE("ll",Long.class);

		code.LINE(6);
		code.LOAD("ll");
		code.VIRTUAL(Long.class, "longValue")
				.reTurn(long.class).INVOKE();
		code.LOADConst(1L);
		code.ADD();
		code.STATIC(Long.class, "valueOf")
				.reTurn(Long.class)
				.parameter(long.class).INVOKE();
		code.STORE("l");

		code.LINE(7);
		code.RETURN();

		code.END();
	}

	protected void _funclong(ClassBody classBody) {
		MethodCode code = classBody.method("funclong")
		.parameter("l",long.class).begin();

		code.LINE(10);
		code.LOAD("l");
		code.STATIC(Long.class, "valueOf")
				.reTurn(Long.class)
				.parameter(long.class).INVOKE();
		code.STORE("ll",Long.class);

		code.LINE(11);
		code.LOAD("ll");
		code.VIRTUAL(Long.class, "longValue")
				.reTurn(long.class).INVOKE();
		code.LOADConst(1L);
		code.ADD();
		code.STORE("l");

		code.LINE(12);
		code.RETURN();

		code.END();
	}

	protected void _init(ClassBody classBody) {
		MethodCode code = classBody.method("init").begin();

		code.LINE(15);
		code.LOADConst(Long.valueOf(10L));
		code.STORE("l",long.class);

		code.LINE(16);
		code.LOADConst(Long.valueOf(100L));
		code.STATIC(Long.class, "valueOf")
				.reTurn(Long.class)
				.parameter(long.class).INVOKE();
		code.STORE("ll",Long.class);

		code.LINE(17);
		code.LOAD("this");
		code.LOAD("l");
		code.VIRTUAL("funclong")
				.parameter(long.class).INVOKE();

		code.LINE(18);
		code.LOAD("this");
		code.LOAD("ll");
		code.VIRTUAL("funcLong")
				.parameter(Long.class).INVOKE();

		code.LINE(19);
		code.LOAD("this");
		code.LOADConst(1L);
		code.VIRTUAL("funclong")
				.parameter(long.class).INVOKE();

		code.LINE(20);
		code.LOAD("this");
		code.LOADConst(Long.valueOf(2L));
		code.STATIC(Long.class, "valueOf")
				.reTurn(Long.class)
				.parameter(long.class).INVOKE();
		code.VIRTUAL("funcLong")
				.parameter(Long.class).INVOKE();

		code.LINE(21);
		code.RETURN();

		code.END();
	}

}
