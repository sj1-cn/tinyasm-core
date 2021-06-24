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

import java.io.PrintStream;
import java.util.function.Function;

@SuppressWarnings("unused")
public class MethodCodeMethodCallerLAMBDASampleTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new MethodCodeMethodCallerLAMBDASampleTinyAsmDump().build("cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeMethodCallerLAMBDASample");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
				.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, "java.lang.invoke.MethodHandles", "Lookup");

		classBody.staticField(ACC_STATIC, "staticFieldString", Clazz.of(String.class));
		classBody.field("fieldString", Clazz.of(String.class));
		classBody.staticField(ACC_STATIC, "staticFieldStringArray", Clazz.of(String[].class));
		classBody.field("fieldStringArray", Clazz.of(String[].class));
		__init_(classBody);
		_exec(classBody);
		_execparamString(classBody);
		_execfieldString(classBody);
		_execstaticFieldString(classBody);
		_execfieldStringArray(classBody);
		_execstaticFieldStringArray(classBody);
		_method(classBody);
		_lambda$execstaticFieldStringArray$5(classBody);
		_lambda$execfieldStringArray$4(classBody);
		_lambda$execstaticFieldString$3(classBody);
		_lambda$execfieldString$2(classBody);
		_lambda$execparamString$1(classBody);
		_lambda$exec$0(classBody);
		__clinit_(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();

		code.LINE();
		code.LOAD("this");
		code.LOADConst("fieldString");
		code.PUTFIELD("fieldString", String.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(String.class);
		code.PUTFIELD("fieldStringArray", String[].class);
		code.RETURN();

		code.END();
	}

	protected void _exec(ClassBody classBody) {
		MethodCode code = classBody.public_().method("exec").begin();

		code.LINE();
		code.DYNAMIC("lambda$exec$0").parameter(String.class).return_(String.class)
				.LAMBDA(Function.class, "apply").parameter(Object.class).return_(Object.class)
				.INVOKE();
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

	protected void _execparamString(ClassBody classBody) {
		MethodCode code = classBody.public_().method("execparamString")
				.parameter("paramString", String.class).begin();

		code.LINE();
		code.LOAD("paramString");
		code.DYNAMIC("lambda$execparamString$1").parameter(String.class).parameter(String.class).return_(String.class)
				.LAMBDA(Function.class, "apply").parameter(Object.class).return_(Object.class)
				.INVOKE();
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

	protected void _execfieldString(ClassBody classBody) {
		MethodCode code = classBody.public_().method("execfieldString")
				.parameter("paramString", String.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("paramString");
		code.DYNAMIC("lambda$execfieldString$2").withThis()
				.parameter(String.class).parameter(String.class).return_(String.class)
				.LAMBDA(Function.class, "apply").parameter(Object.class).return_(Object.class)
				.INVOKE();
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

	protected void _execstaticFieldString(ClassBody classBody) {
		MethodCode code = classBody.public_().method("execstaticFieldString")
				.parameter("paramString", String.class).begin();

		code.LINE();
		code.LOAD("paramString");
		code.DYNAMIC("lambda$execstaticFieldString$3").parameter(String.class).parameter(String.class).return_(String.class)
				.LAMBDA(Function.class, "apply").parameter(Object.class).return_(Object.class)
				.INVOKE();
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

	protected void _execfieldStringArray(ClassBody classBody) {
		MethodCode code = classBody.public_().method("execfieldStringArray")
				.parameter("paramString", String.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("paramString");
		code.DYNAMIC("lambda$execfieldStringArray$4").withThis()
				.parameter(String.class).parameter(String.class).return_(String.class)
				.LAMBDA(Function.class, "apply").parameter(Object.class).return_(Object.class)
				.INVOKE();
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

	protected void _execstaticFieldStringArray(ClassBody classBody) {
		MethodCode code = classBody.public_().method("execstaticFieldStringArray")
				.parameter("paramString", String.class).begin();

		code.LINE();
		code.LOAD("paramString");
		code.DYNAMIC("lambda$execstaticFieldStringArray$5").parameter(String.class).parameter(String.class).return_(String.class)
				.LAMBDA(Function.class, "apply").parameter(Object.class).return_(Object.class)
				.INVOKE();
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

	protected void _lambda$execstaticFieldStringArray$5(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$execstaticFieldStringArray$5")
				.return_(String.class)
				.parameter(ACC_FINAL | ACC_SYNTHETIC, "paramString", String.class)
				.parameter(ACC_SYNTHETIC, "s", String.class).begin();

		code.LINE();
		code.NEW(StringBuilder.class);
		code.DUP();
		code.SPECIAL(StringBuilder.class, "<init>").INVOKE();
		code.LOAD("paramString");
		code.VIRTUAL(StringBuilder.class, "append")
				.return_(StringBuilder.class)
				.parameter(String.class).INVOKE();
		code.GETSTATIC("staticFieldStringArray", String[].class);
		code.VIRTUAL(StringBuilder.class, "append")
				.return_(StringBuilder.class)
				.parameter(Object.class).INVOKE();
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

	protected void _lambda$execfieldStringArray$4(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PRIVATE | ACC_SYNTHETIC, "lambda$execfieldStringArray$4")
				.return_(String.class)
				.parameter(ACC_FINAL | ACC_SYNTHETIC, "paramString", String.class)
				.parameter(ACC_SYNTHETIC, "s", String.class).begin();

		code.LINE();
		code.NEW(StringBuilder.class);
		code.DUP();
		code.SPECIAL(StringBuilder.class, "<init>").INVOKE();
		code.LOAD("paramString");
		code.VIRTUAL(StringBuilder.class, "append")
				.return_(StringBuilder.class)
				.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("fieldStringArray", String[].class);
		code.VIRTUAL(StringBuilder.class, "append")
				.return_(StringBuilder.class)
				.parameter(Object.class).INVOKE();
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

	protected void _lambda$execstaticFieldString$3(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$execstaticFieldString$3")
				.return_(String.class)
				.parameter(ACC_FINAL | ACC_SYNTHETIC, "paramString", String.class)
				.parameter(ACC_SYNTHETIC, "s", String.class).begin();

		code.LINE();
		code.NEW(StringBuilder.class);
		code.DUP();
		code.SPECIAL(StringBuilder.class, "<init>").INVOKE();
		code.LOAD("paramString");
		code.VIRTUAL(StringBuilder.class, "append")
				.return_(StringBuilder.class)
				.parameter(String.class).INVOKE();
		code.GETSTATIC("staticFieldString", String.class);
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

	protected void _lambda$execfieldString$2(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PRIVATE | ACC_SYNTHETIC, "lambda$execfieldString$2")
				.return_(String.class)
				.parameter(ACC_FINAL | ACC_SYNTHETIC, "paramString", String.class)
				.parameter(ACC_SYNTHETIC, "s", String.class).begin();

		code.LINE();
		code.NEW(StringBuilder.class);
		code.DUP();
		code.SPECIAL(StringBuilder.class, "<init>").INVOKE();
		code.LOAD("paramString");
		code.VIRTUAL(StringBuilder.class, "append")
				.return_(StringBuilder.class)
				.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("fieldString", String.class);
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

	protected void _lambda$execparamString$1(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$execparamString$1")
				.return_(String.class)
				.parameter(ACC_FINAL | ACC_SYNTHETIC, "paramString", String.class)
				.parameter(ACC_SYNTHETIC, "s", String.class).begin();

		code.LINE();
		code.NEW(StringBuilder.class);
		code.DUP();
		code.SPECIAL(StringBuilder.class, "<init>").INVOKE();
		code.LOAD("paramString");
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

	protected void _lambda$exec$0(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$exec$0")
				.return_(String.class)
				.parameter(ACC_SYNTHETIC, "s", String.class).begin();

		code.LINE();
		code.LOAD("s");
		code.LOADConst(0);
		code.LOADConst(2);
		code.VIRTUAL(String.class, "substring")
				.return_(String.class)
				.parameter(int.class)
				.parameter(int.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void __clinit_(ClassBody classBody) {
		MethodCode code = classBody.staticMethod("<clinit>").begin();

		code.LINE();
		code.LOADConst("staticFieldString");
		code.PUTSTATIC("staticFieldString", String.class);

		code.LINE();
		code.LOADConst(10);
		code.NEWARRAY(String.class);
		code.PUTSTATIC("staticFieldStringArray", String[].class);
		code.RETURN();

		code.END();
	}

}
