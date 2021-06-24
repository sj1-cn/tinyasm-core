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

import cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeStaticFieldSample;

@SuppressWarnings("unused")
public class MethodCodeStaticFieldSampleComplexTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new MethodCodeStaticFieldSampleComplexTinyAsmDump().build("cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeStaticFieldSampleComplex");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
				.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_getAll(classBody);

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

	protected void _getAll(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAll").begin();

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "z", boolean.class);
		code.STORE("z", boolean.class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "b", byte.class);
		code.STORE("b", byte.class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "c", char.class);
		code.STORE("c", char.class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "s", short.class);
		code.STORE("s", short.class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "i", int.class);
		code.STORE("i", int.class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "l", long.class);
		code.STORE("l", long.class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "f", float.class);
		code.STORE("f", float.class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "d", double.class);
		code.STORE("d", double.class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "str", String.class);
		code.STORE("str", String.class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "za", boolean[].class);
		code.STORE("za", boolean[].class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "ba", byte[].class);
		code.STORE("ba", byte[].class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "ca", char[].class);
		code.STORE("ca", char[].class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "sa", short[].class);
		code.STORE("sa", short[].class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "ia", int[].class);
		code.STORE("ia", int[].class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "la", long[].class);
		code.STORE("la", long[].class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "fa", float[].class);
		code.STORE("fa", float[].class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "da", double[].class);
		code.STORE("da", double[].class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "stra", String[].class);
		code.STORE("stra", String[].class);

		code.LINE();
		code.LOAD("z");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "z", boolean.class);

		code.LINE();
		code.LOAD("b");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "b", byte.class);

		code.LINE();
		code.LOAD("c");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "c", char.class);

		code.LINE();
		code.LOAD("s");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "s", short.class);

		code.LINE();
		code.LOAD("i");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "i", int.class);

		code.LINE();
		code.LOAD("l");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "l", long.class);

		code.LINE();
		code.LOAD("f");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "f", float.class);

		code.LINE();
		code.LOAD("d");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "d", double.class);

		code.LINE();
		code.LOAD("str");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "str", String.class);

		code.LINE();
		code.LOAD("za");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "za", boolean[].class);

		code.LINE();
		code.LOAD("ba");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "ba", byte[].class);

		code.LINE();
		code.LOAD("ca");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "ca", char[].class);

		code.LINE();
		code.LOAD("sa");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "sa", short[].class);

		code.LINE();
		code.LOAD("ia");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "ia", int[].class);

		code.LINE();
		code.LOAD("la");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "la", long[].class);

		code.LINE();
		code.LOAD("fa");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "fa", float[].class);

		code.LINE();
		code.LOAD("da");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "da", double[].class);

		code.LINE();
		code.LOAD("stra");
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "stra", String[].class);

		code.LINE();
		code.LOAD("z");
		Label label37OfIFNE = new Label();
		code.IFNE(label37OfIFNE);
		code.LOADConst(1);
		Label label38OfGOTO = new Label();
		code.GOTO(label38OfGOTO);

		code.visitLabel(label37OfIFNE);
		code.LOADConst(0);

		code.visitLabel(label38OfGOTO);
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "z", boolean.class);

		code.LINE();
		code.LOAD("b");
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(byte.class);
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "b", byte.class);

		code.LINE();
		code.LOAD("c");
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(char.class);
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "c", char.class);

		code.LINE();
		code.LOAD("s");
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(short.class);
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "s", short.class);

		code.LINE();
		code.LOAD("i");
		code.LOADConst(1);
		code.ADD();
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "i", int.class);

		code.LINE();
		code.LOAD("l");
		code.LOADConst(1L);
		code.ADD();
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "l", long.class);

		code.LINE();
		code.LOAD("f");
		code.LOADConst(1F);
		code.ADD();
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "f", float.class);

		code.LINE();
		code.LOAD("d");
		code.LOADConst(1D);
		code.ADD();
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "d", double.class);

		code.LINE();
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
		code.PUTSTATIC(MethodCodeStaticFieldSample.class, "str", String.class);

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "za", boolean[].class);
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
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "ba", byte[].class);
		code.LOADConst(0);
		code.LOAD("ba");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(byte.class);
		code.ARRAYSTORE();

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "ca", char[].class);
		code.LOADConst(0);
		code.LOAD("ca");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(char.class);
		code.ARRAYSTORE();

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "sa", short[].class);
		code.LOADConst(0);
		code.LOAD("sa");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(short.class);
		code.ARRAYSTORE();

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "ia", int[].class);
		code.LOADConst(0);
		code.LOAD("ia");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "la", long[].class);
		code.LOADConst(0);
		code.LOAD("la");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1L);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "fa", float[].class);
		code.LOADConst(0);
		code.LOAD("fa");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1F);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "da", double[].class);
		code.LOADConst(0);
		code.LOAD("da");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1D);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.GETSTATIC(MethodCodeStaticFieldSample.class, "stra", String[].class);
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

}
