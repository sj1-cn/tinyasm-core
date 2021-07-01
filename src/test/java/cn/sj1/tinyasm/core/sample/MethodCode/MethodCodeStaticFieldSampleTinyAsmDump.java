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

@SuppressWarnings("unused")
public class MethodCodeStaticFieldSampleTinyAsmDump {

	public static byte[] dump() {
		return new MethodCodeStaticFieldSampleTinyAsmDump().build("cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeStaticFieldSample");
	}

	public byte[] build(String className)  {
		ClassBody classBody = ClassBuilder.class_(className)
				.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.staticField("z", Clazz.of(boolean.class));
		classBody.staticField("b", Clazz.of(byte.class));
		classBody.staticField("c", Clazz.of(char.class));
		classBody.staticField("s", Clazz.of(short.class));
		classBody.staticField("i", Clazz.of(int.class));
		classBody.staticField("l", Clazz.of(long.class));
		classBody.staticField("f", Clazz.of(float.class));
		classBody.staticField("d", Clazz.of(double.class));
		classBody.staticField("str", Clazz.of(String.class));
		classBody.staticField(ACC_STATIC, "za", Clazz.of(boolean[].class));
		classBody.staticField(ACC_STATIC, "ba", Clazz.of(byte[].class));
		classBody.staticField(ACC_STATIC, "ca", Clazz.of(char[].class));
		classBody.staticField(ACC_STATIC, "sa", Clazz.of(short[].class));
		classBody.staticField(ACC_STATIC, "ia", Clazz.of(int[].class));
		classBody.staticField(ACC_STATIC, "la", Clazz.of(long[].class));
		classBody.staticField(ACC_STATIC, "fa", Clazz.of(float[].class));
		classBody.staticField(ACC_STATIC, "da", Clazz.of(double[].class));
		classBody.staticField(ACC_STATIC, "stra", Clazz.of(String[].class));
		__init_(classBody);
		_getAll(classBody);
		__clinit_(classBody);

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
		code.GETSTATIC("z", boolean.class);
		code.STORE("z", boolean.class);

		code.LINE();
		code.GETSTATIC("b", byte.class);
		code.STORE("b", byte.class);

		code.LINE();
		code.GETSTATIC("c", char.class);
		code.STORE("c", char.class);

		code.LINE();
		code.GETSTATIC("s", short.class);
		code.STORE("s", short.class);

		code.LINE();
		code.GETSTATIC("i", int.class);
		code.STORE("i", int.class);

		code.LINE();
		code.GETSTATIC("l", long.class);
		code.STORE("l", long.class);

		code.LINE();
		code.GETSTATIC("f", float.class);
		code.STORE("f", float.class);

		code.LINE();
		code.GETSTATIC("d", double.class);
		code.STORE("d", double.class);

		code.LINE();
		code.GETSTATIC("str", String.class);
		code.STORE("str", String.class);

		code.LINE();
		code.GETSTATIC("za", boolean[].class);
		code.STORE("za", boolean[].class);

		code.LINE();
		code.GETSTATIC("ba", byte[].class);
		code.STORE("ba", byte[].class);

		code.LINE();
		code.GETSTATIC("ca", char[].class);
		code.STORE("ca", char[].class);

		code.LINE();
		code.GETSTATIC("sa", short[].class);
		code.STORE("sa", short[].class);

		code.LINE();
		code.GETSTATIC("ia", int[].class);
		code.STORE("ia", int[].class);

		code.LINE();
		code.GETSTATIC("la", long[].class);
		code.STORE("la", long[].class);

		code.LINE();
		code.GETSTATIC("fa", float[].class);
		code.STORE("fa", float[].class);

		code.LINE();
		code.GETSTATIC("da", double[].class);
		code.STORE("da", double[].class);

		code.LINE();
		code.GETSTATIC("stra", String[].class);
		code.STORE("stra", String[].class);

		code.LINE();
		code.LOAD("z");
		code.PUTSTATIC("z", boolean.class);

		code.LINE();
		code.LOAD("b");
		code.PUTSTATIC("b", byte.class);

		code.LINE();
		code.LOAD("c");
		code.PUTSTATIC("c", char.class);

		code.LINE();
		code.LOAD("s");
		code.PUTSTATIC("s", short.class);

		code.LINE();
		code.LOAD("i");
		code.PUTSTATIC("i", int.class);

		code.LINE();
		code.LOAD("l");
		code.PUTSTATIC("l", long.class);

		code.LINE();
		code.LOAD("f");
		code.PUTSTATIC("f", float.class);

		code.LINE();
		code.LOAD("d");
		code.PUTSTATIC("d", double.class);

		code.LINE();
		code.LOAD("str");
		code.PUTSTATIC("str", String.class);

		code.LINE();
		code.LOAD("za");
		code.PUTSTATIC("za", boolean[].class);

		code.LINE();
		code.LOAD("ba");
		code.PUTSTATIC("ba", byte[].class);

		code.LINE();
		code.LOAD("ca");
		code.PUTSTATIC("ca", char[].class);

		code.LINE();
		code.LOAD("sa");
		code.PUTSTATIC("sa", short[].class);

		code.LINE();
		code.LOAD("ia");
		code.PUTSTATIC("ia", int[].class);

		code.LINE();
		code.LOAD("la");
		code.PUTSTATIC("la", long[].class);

		code.LINE();
		code.LOAD("fa");
		code.PUTSTATIC("fa", float[].class);

		code.LINE();
		code.LOAD("da");
		code.PUTSTATIC("da", double[].class);

		code.LINE();
		code.LOAD("stra");
		code.PUTSTATIC("stra", String[].class);

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
		code.PUTSTATIC("z", boolean.class);

		code.LINE();
		code.LOAD("b");
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(byte.class);
		code.PUTSTATIC("b", byte.class);

		code.LINE();
		code.LOAD("c");
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(char.class);
		code.PUTSTATIC("c", char.class);

		code.LINE();
		code.LOAD("s");
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(short.class);
		code.PUTSTATIC("s", short.class);

		code.LINE();
		code.LOAD("i");
		code.LOADConst(1);
		code.ADD();
		code.PUTSTATIC("i", int.class);

		code.LINE();
		code.LOAD("l");
		code.LOADConst(1L);
		code.ADD();
		code.PUTSTATIC("l", long.class);

		code.LINE();
		code.LOAD("f");
		code.LOADConst(1F);
		code.ADD();
		code.PUTSTATIC("f", float.class);

		code.LINE();
		code.LOAD("d");
		code.LOADConst(1D);
		code.ADD();
		code.PUTSTATIC("d", double.class);

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
		code.PUTSTATIC("str", String.class);

		code.LINE();
		code.GETSTATIC("za", boolean[].class);
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
		code.GETSTATIC("ba", byte[].class);
		code.LOADConst(0);
		code.LOAD("ba");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(byte.class);
		code.ARRAYSTORE();

		code.LINE();
		code.GETSTATIC("ca", char[].class);
		code.LOADConst(0);
		code.LOAD("ca");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(char.class);
		code.ARRAYSTORE();

		code.LINE();
		code.GETSTATIC("sa", short[].class);
		code.LOADConst(0);
		code.LOAD("sa");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(short.class);
		code.ARRAYSTORE();

		code.LINE();
		code.GETSTATIC("ia", int[].class);
		code.LOADConst(0);
		code.LOAD("ia");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.GETSTATIC("la", long[].class);
		code.LOADConst(0);
		code.LOAD("la");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1L);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.GETSTATIC("fa", float[].class);
		code.LOADConst(0);
		code.LOAD("fa");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1F);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.GETSTATIC("da", double[].class);
		code.LOADConst(0);
		code.LOAD("da");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1D);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.GETSTATIC("stra", String[].class);
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

	protected void __clinit_(ClassBody classBody) {
		MethodCode code = classBody.staticMethod("<clinit>").begin();

		code.LINE();
		code.LOADConst(1);
		code.PUTSTATIC("z", boolean.class);

		code.LINE();
		code.LOADConst(1);
		code.PUTSTATIC("b", byte.class);

		code.LINE();
		code.LOADConst(1);
		code.PUTSTATIC("c", char.class);

		code.LINE();
		code.LOADConst(1);
		code.PUTSTATIC("s", short.class);

		code.LINE();
		code.LOADConst(1);
		code.PUTSTATIC("i", int.class);

		code.LINE();
		code.LOADConst(1L);
		code.PUTSTATIC("l", long.class);

		code.LINE();
		code.LOADConst(1F);
		code.PUTSTATIC("f", float.class);

		code.LINE();
		code.LOADConst(1D);
		code.PUTSTATIC("d", double.class);

		code.LINE();
		code.LOADConst("str");
		code.PUTSTATIC("str", String.class);

		code.LINE();
		code.LOADConst(4);
		code.NEWARRAY(boolean.class);
		code.DUP();
		code.LOADConst(0);
		code.LOADConst(1);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(1);
		code.LOADConst(0);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(2);
		code.LOADConst(1);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(3);
		code.LOADConst(0);
		code.ARRAYSTORE();
		code.PUTSTATIC("za", boolean[].class);

		code.LINE();
		code.LOADConst(5);
		code.NEWARRAY(byte.class);
		code.DUP();
		code.LOADConst(0);
		code.LOADConst(1);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(1);
		code.LOADConst(2);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(2);
		code.LOADConst(3);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(3);
		code.LOADConst(4);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(4);
		code.LOADConst(5);
		code.ARRAYSTORE();
		code.PUTSTATIC("ba", byte[].class);

		code.LINE();
		code.LOADConst(5);
		code.NEWARRAY(char.class);
		code.DUP();
		code.LOADConst(0);
		code.LOADConst(1);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(1);
		code.LOADConst(2);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(2);
		code.LOADConst(3);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(3);
		code.LOADConst(4);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(4);
		code.LOADConst(5);
		code.ARRAYSTORE();
		code.PUTSTATIC("ca", char[].class);

		code.LINE();
		code.LOADConst(5);
		code.NEWARRAY(short.class);
		code.DUP();
		code.LOADConst(0);
		code.LOADConst(1);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(1);
		code.LOADConst(2);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(2);
		code.LOADConst(3);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(3);
		code.LOADConst(4);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(4);
		code.LOADConst(5);
		code.ARRAYSTORE();
		code.PUTSTATIC("sa", short[].class);

		code.LINE();
		code.LOADConst(5);
		code.NEWARRAY(int.class);
		code.DUP();
		code.LOADConst(0);
		code.LOADConst(1);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(1);
		code.LOADConst(2);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(2);
		code.LOADConst(3);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(3);
		code.LOADConst(4);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(4);
		code.LOADConst(5);
		code.ARRAYSTORE();
		code.PUTSTATIC("ia", int[].class);

		code.LINE();
		code.LOADConst(5);
		code.NEWARRAY(long.class);
		code.DUP();
		code.LOADConst(0);
		code.LOADConst(1L);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(1);
		code.LOADConst(Long.valueOf(2L));
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(2);
		code.LOADConst(Long.valueOf(3L));
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(3);
		code.LOADConst(Long.valueOf(4L));
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(4);
		code.LOADConst(Long.valueOf(5L));
		code.ARRAYSTORE();
		code.PUTSTATIC("la", long[].class);

		code.LINE();
		code.LOADConst(5);
		code.NEWARRAY(float.class);
		code.DUP();
		code.LOADConst(0);
		code.LOADConst(Float.valueOf("1.1"));
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(1);
		code.LOADConst(Float.valueOf("2.1"));
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(2);
		code.LOADConst(Float.valueOf("3.1"));
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(3);
		code.LOADConst(Float.valueOf("4.1"));
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(4);
		code.LOADConst(Float.valueOf("5.1"));
		code.ARRAYSTORE();
		code.PUTSTATIC("fa", float[].class);

		code.LINE();
		code.LOADConst(5);
		code.NEWARRAY(double.class);
		code.DUP();
		code.LOADConst(0);
		code.LOADConst(Double.valueOf("1.1"));
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(1);
		code.LOADConst(Double.valueOf("2.1"));
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(2);
		code.LOADConst(Double.valueOf("3.1"));
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(3);
		code.LOADConst(Double.valueOf("4.1"));
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(4);
		code.LOADConst(Double.valueOf("5.1"));
		code.ARRAYSTORE();
		code.PUTSTATIC("da", double[].class);

		code.LINE();
		code.LOADConst(5);
		code.NEWARRAY(String.class);
		code.DUP();
		code.LOADConst(0);
		code.LOADConst("str1");
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(1);
		code.LOADConst("str2");
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(2);
		code.LOADConst("str3");
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(3);
		code.LOADConst("str4");
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(4);
		code.LOADConst("str5");
		code.ARRAYSTORE();
		code.PUTSTATIC("stra", String[].class);
		code.RETURN();

		code.END();
	}

}
