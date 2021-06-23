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

import cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeFieldSample;

@SuppressWarnings("unused")
public class MethodCodeFieldSampleComplexTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new MethodCodeFieldSampleComplexTinyAsmDump().build("cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeFieldSampleComplex");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.field("methodCodeFieldSample", Clazz.of(MethodCodeFieldSample.class));
		classBody.staticField(ACC_STATIC, "methodCodeFieldSampleStatic", Clazz.of(className));
		__init_(classBody);
		_getAll(classBody);
		__clinit_(classBody,className);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();

		code.LINE();
		code.LOAD("this");
		code.NEW(MethodCodeFieldSample.class);
		code.DUP();
		code.SPECIAL(MethodCodeFieldSample.class, "<init>").INVOKE();
		code.PUTFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.RETURN();

		code.END();
	}

	protected void _getAll(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAll").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "z", boolean.class);
		code.STORE("z",boolean.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "b", byte.class);
		code.STORE("b",byte.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "c", char.class);
		code.STORE("c",char.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "s", short.class);
		code.STORE("s",short.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "i", int.class);
		code.STORE("i",int.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "l", long.class);
		code.STORE("l",long.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "f", float.class);
		code.STORE("f",float.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "d", double.class);
		code.STORE("d",double.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "str", String.class);
		code.STORE("str",String.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("z");
		code.PUTFIELD(MethodCodeFieldSample.class, "z", boolean.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("b");
		code.PUTFIELD(MethodCodeFieldSample.class, "b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("c");
		code.PUTFIELD(MethodCodeFieldSample.class, "c", char.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("s");
		code.PUTFIELD(MethodCodeFieldSample.class, "s", short.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("i");
		code.PUTFIELD(MethodCodeFieldSample.class, "i", int.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("l");
		code.PUTFIELD(MethodCodeFieldSample.class, "l", long.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("f");
		code.PUTFIELD(MethodCodeFieldSample.class, "f", float.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("d");
		code.PUTFIELD(MethodCodeFieldSample.class, "d", double.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("str");
		code.PUTFIELD(MethodCodeFieldSample.class, "str", String.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("z");
		Label label19OfIFNE = new Label();
		code.IFNE(label19OfIFNE);
		code.LOADConst(1);
		Label label20OfGOTO = new Label();
		code.GOTO(label20OfGOTO);

		code.visitLabel(label19OfIFNE);
		code.LOADConst(0);

		code.visitLabel(label20OfGOTO);
		code.PUTFIELD(MethodCodeFieldSample.class, "z", boolean.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("b");
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(byte.class);
		code.PUTFIELD(MethodCodeFieldSample.class, "b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("c");
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(char.class);
		code.PUTFIELD(MethodCodeFieldSample.class, "c", char.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("s");
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(short.class);
		code.PUTFIELD(MethodCodeFieldSample.class, "s", short.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("i");
		code.LOADConst(1);
		code.ADD();
		code.PUTFIELD(MethodCodeFieldSample.class, "i", int.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("l");
		code.LOADConst(1L);
		code.ADD();
		code.PUTFIELD(MethodCodeFieldSample.class, "l", long.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("f");
		code.LOADConst(1F);
		code.ADD();
		code.PUTFIELD(MethodCodeFieldSample.class, "f", float.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("d");
		code.LOADConst(1D);
		code.ADD();
		code.PUTFIELD(MethodCodeFieldSample.class, "d", double.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.NEW(StringBuilder.class);
		code.DUP();
		code.SPECIAL(StringBuilder.class, "<init>").INVOKE();
		code.LOAD("str");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(1);
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(int.class).INVOKE();
		code.VIRTUAL(StringBuilder.class, "toString")
			.return_(String.class).INVOKE();
		code.PUTFIELD(MethodCodeFieldSample.class, "str", String.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "za", boolean[].class);
		code.STORE("za",boolean[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "ba", byte[].class);
		code.STORE("ba",byte[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "ca", char[].class);
		code.STORE("ca",char[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "sa", short[].class);
		code.STORE("sa",short[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "ia", int[].class);
		code.STORE("ia",int[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "la", long[].class);
		code.STORE("la",long[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "fa", float[].class);
		code.STORE("fa",float[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "da", double[].class);
		code.STORE("da",double[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "stra", String[].class);
		code.STORE("stra",String[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("za");
		code.PUTFIELD(MethodCodeFieldSample.class, "za", boolean[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("ba");
		code.PUTFIELD(MethodCodeFieldSample.class, "ba", byte[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("ca");
		code.PUTFIELD(MethodCodeFieldSample.class, "ca", char[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("sa");
		code.PUTFIELD(MethodCodeFieldSample.class, "sa", short[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("ia");
		code.PUTFIELD(MethodCodeFieldSample.class, "ia", int[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("la");
		code.PUTFIELD(MethodCodeFieldSample.class, "la", long[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("fa");
		code.PUTFIELD(MethodCodeFieldSample.class, "fa", float[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("da");
		code.PUTFIELD(MethodCodeFieldSample.class, "da", double[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.LOAD("stra");
		code.PUTFIELD(MethodCodeFieldSample.class, "stra", String[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "za", boolean[].class);
		code.LOADConst(0);
		code.LOAD("za");
		code.LOADConst(0);
		code.ARRAYLOAD();
		Label label48OfIFNE = new Label();
		code.IFNE(label48OfIFNE);
		code.LOADConst(1);
		Label label49OfGOTO = new Label();
		code.GOTO(label49OfGOTO);

		code.visitLabel(label48OfIFNE);
		code.LOADConst(0);

		code.visitLabel(label49OfGOTO);
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "ba", byte[].class);
		code.LOADConst(0);
		code.LOAD("ba");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(byte.class);
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "ca", char[].class);
		code.LOADConst(0);
		code.LOAD("ca");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(char.class);
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "sa", short[].class);
		code.LOADConst(0);
		code.LOAD("sa");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(short.class);
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "ia", int[].class);
		code.LOADConst(0);
		code.LOAD("ia");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "la", long[].class);
		code.LOADConst(0);
		code.LOAD("la");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1L);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "fa", float[].class);
		code.LOADConst(0);
		code.LOAD("fa");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1F);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "da", double[].class);
		code.LOADConst(0);
		code.LOAD("da");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1D);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("methodCodeFieldSample", MethodCodeFieldSample.class);
		code.GETFIELD(MethodCodeFieldSample.class, "stra", String[].class);
		code.LOADConst(0);
		code.NEW(StringBuilder.class);
		code.DUP();
		code.SPECIAL(StringBuilder.class, "<init>").INVOKE();
		code.LOAD("stra");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(1);
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(int.class).INVOKE();
		code.VIRTUAL(StringBuilder.class, "toString")
			.return_(String.class).INVOKE();
		code.ARRAYSTORE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void __clinit_(ClassBody classBody, String  className) {
		MethodCode code = classBody.staticMethod("<clinit>").begin();

		code.LINE();
		code.NEW(className);
		code.DUP();
		code.SPECIAL("<init>").INVOKE();
		code.PUTSTATIC("methodCodeFieldSampleStatic", className);
		code.RETURN();

		code.END();
	}

}
