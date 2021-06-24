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
import cn.sj1.tinyasm.core.LamdaMethodCaller;
import cn.sj1.tinyasm.core.MethodCode;

import java.io.PrintStream;
import java.util.function.Function;

@SuppressWarnings("unused")
public class MethodCodeMethodCallerLAMBDASampleTinyAsmBuilder {

	public static byte[] dump() throws Exception {
		return new MethodCodeMethodCallerLAMBDASampleTinyAsmBuilder().build("cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeMethodCallerLAMBDASample");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
				.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, "java.lang.invoke.MethodHandles", "Lookup");

		__init_(classBody);
		_exec2(classBody, className);
		_method(classBody);
		_lambda$exec2$0(classBody);

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

	protected void _exec2(ClassBody classBody, String className) {
		MethodCode code = classBody.public_().method("exec2")
				.parameter("profix", String.class).begin();

		code.LINE();
		code.LOAD("profix");
		code.DYNAMIC(className, "lambda$exec2$0").parameter(String.class).parameter(String.class).return_(String.class).LAMBDA(Function.class, "apply").parameter(Object.class).return_(Object.class).INVOKE();
		code.STORE("func", Clazz.of(Function.class, Clazz.of(String.class), Clazz.of(String.class)));

		code.LINE();
		code.LOAD("this");
		code.LOAD("func");
		code.VIRTUAL("method")
				.parameter(Function.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _method(ClassBody classBody) {
		MethodCode code = classBody.public_().method("method")
				.return_(Clazz.of(void.class))
				.parameter("data", Clazz.of(Function.class, Clazz.of(String.class), Clazz.of(String.class))).begin();

		code.LINE();
		code.LOAD("data");
		code.LOADConst("test");
		code.INTERFACE(Function.class, "apply")
				.return_(Object.class)
				.parameter(Object.class).INVOKE();
		code.CHECKCAST(String.class);
		code.STORE("s", String.class);

		code.LINE();
		code.GETSTATIC(System.class, "out", PrintStream.class);
		code.LOAD("s");
		code.VIRTUAL(PrintStream.class, "println")
				.parameter(String.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$exec2$0(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$exec2$0")
				.return_(String.class)
				.parameter(ACC_FINAL | ACC_SYNTHETIC, "profix", String.class)
				.parameter(ACC_SYNTHETIC, "s", String.class).begin();

		code.LINE();
		code.NEW(StringBuilder.class);
		code.DUP();
		code.SPECIAL(StringBuilder.class, "<init>").INVOKE();
		code.LOAD("profix");
		code.VIRTUAL(StringBuilder.class, "append")
				.return_(StringBuilder.class)
				.parameter(String.class).INVOKE();
		code.LOAD("s");
		code.LOADConst(0);
		code.LOADConst(2);
		code.VIRTUAL(String.class, "substring")
				.return_(String.class)
				.parameter(int.class)
				.parameter(int.class).INVOKE();
		code.VIRTUAL(StringBuilder.class, "append")
				.return_(StringBuilder.class)
				.parameter(String.class).INVOKE();
		code.VIRTUAL(StringBuilder.class, "toString")
				.return_(String.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

}
