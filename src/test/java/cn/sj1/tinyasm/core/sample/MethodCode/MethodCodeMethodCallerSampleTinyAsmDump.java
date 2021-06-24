package cn.sj1.tinyasm.core.sample.MethodCode;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;

import cn.sj1.tinyasm.core.Annotation;
import cn.sj1.tinyasm.core.ClassBody;
import cn.sj1.tinyasm.core.ClassBuilder;
import cn.sj1.tinyasm.core.Clazz;
import cn.sj1.tinyasm.core.MethodCode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class MethodCodeMethodCallerSampleTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new MethodCodeMethodCallerSampleTinyAsmDump().build("cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeMethodCallerSample");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
				.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.private_().field("i", Clazz.of(int.class));
		__init_(classBody);
		_method(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.PUTFIELD("i", int.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(100);
		code.PUTFIELD("i", int.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _method(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PUBLIC | ACC_STATIC, "method")
				.parameter("data", String.class).begin();

		code.LINE();
		code.LOADConst(10);
		code.STORE("i", int.class);

		code.LINE();
		code.LOADConst(Long.valueOf(10L));
		code.STATIC(Long.class, "valueOf")
				.return_(Long.class)
				.parameter(long.class).INVOKE();
		code.STORE("l", Long.class);

		code.LINE();
		code.LOAD("i");
		code.STATIC(String.class, "valueOf")
				.return_(String.class)
				.parameter(int.class).INVOKE();
		code.STORE("s", String.class);

		code.LINE();
		code.NEW(StringBuilder.class);
		code.DUP();
		code.SPECIAL(StringBuilder.class, "<init>").INVOKE();
		code.LOAD("s");
		code.VIRTUAL(StringBuilder.class, "append")
				.return_(StringBuilder.class)
				.parameter(String.class).INVOKE();
		code.LOAD("i");
		code.VIRTUAL(StringBuilder.class, "append")
				.return_(StringBuilder.class)
				.parameter(int.class).INVOKE();
		code.LOAD("l");
		code.VIRTUAL(StringBuilder.class, "append")
				.return_(StringBuilder.class)
				.parameter(Object.class).INVOKE();
		code.VIRTUAL(StringBuilder.class, "toString")
				.return_(String.class).INVOKE();
		code.STORE("s");

		code.LINE();
		code.NEW(ArrayList.class);
		code.DUP();
		code.SPECIAL(ArrayList.class, "<init>").INVOKE();
		code.STORE("ls", Clazz.of(List.class, Clazz.of(String.class)));

		code.LINE();
		code.LOAD("ls");
		code.LOADConst("first");
		code.INTERFACE(List.class, "add")
				.return_(boolean.class)
				.parameter(Object.class).INVOKE();
		code.POP();

		code.LINE();
		code.LOAD("ls");
		code.LOADConst("second");
		code.INTERFACE(List.class, "add")
				.return_(boolean.class)
				.parameter(Object.class).INVOKE();
		code.POP();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
