package cn.sj1.tinyasm.core.advasmproxy.subclassmethod;
import org.objectweb.asm.Label;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import cn.sj1.tinyasm.core.ClassBody;
import cn.sj1.tinyasm.core.ClassBuilder;
import cn.sj1.tinyasm.core.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cn.sj1.tinyasm.core.Annotation;
import cn.sj1.tinyasm.core.Clazz;
import java.io.PrintStream;
import cn.sj1.tinyasm.core.advasmproxy.subclassmethod.ClassA;
import java.lang.System;
import java.lang.String;
@SuppressWarnings("unused")
public class ClassBTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new ClassBTinyAsmDump().build("cn.sj1.tinyasm.core.advasmproxy.subclassmethod.ClassB");
	}

	public byte[] build(String className) throws Exception {
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
