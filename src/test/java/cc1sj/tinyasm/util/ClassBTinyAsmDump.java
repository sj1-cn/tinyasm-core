package cc1sj.tinyasm.util;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import java.io.PrintStream;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
@SuppressWarnings("unused")
public class ClassBTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new ClassBTinyAsmDump().dump("cc1sj.tinyasm.util.ClassB");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className, ClassA.class)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_say1(classBody);
		_say2(classBody);
		_say1InB(classBody);
		_say2InB(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(ClassA.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _say1(ClassBody classBody) {
		MethodCode code = classBody.public_().method("say1").begin();

		code.LINE();
		code.GETSTATIC(System.class, "out", PrintStream.class);
		code.LOADConst("say in classB1");
		code.VIRTUAL(PrintStream.class, "println")
			.parameter(String.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _say2(ClassBody classBody) {
		MethodCode code = classBody.public_().method("say2").begin();

		code.LINE();
		code.GETSTATIC(System.class, "out", PrintStream.class);
		code.LOADConst("say in classB2");
		code.VIRTUAL(PrintStream.class, "println")
			.parameter(String.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _say1InB(ClassBody classBody) {
		MethodCode code = classBody.public_().method("say1InB").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(ClassA.class, "say1").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _say2InB(ClassBody classBody) {
		MethodCode code = classBody.public_().method("say2InB").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(ClassA.class, "say2").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
