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
public class MethodCodeFieldSampleTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new MethodCodeFieldSampleTinyAsmDump().build("cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeFieldSample");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.private_().field("z", Clazz.of(boolean.class));
		classBody.private_().field("b", Clazz.of(byte.class));
		classBody.private_().field("c", Clazz.of(char.class));
		classBody.private_().field("s", Clazz.of(short.class));
		classBody.private_().field("i", Clazz.of(int.class));
		classBody.private_().field("l", Clazz.of(long.class));
		classBody.private_().field("f", Clazz.of(float.class));
		classBody.private_().field("d", Clazz.of(double.class));
		classBody.private_().field("str", Clazz.of(String.class));
		classBody.private_().field("za", Clazz.of(boolean[].class));
		classBody.private_().field("ba", Clazz.of(byte[].class));
		classBody.private_().field("ca", Clazz.of(char[].class));
		classBody.private_().field("sa", Clazz.of(short[].class));
		classBody.private_().field("ia", Clazz.of(int[].class));
		classBody.private_().field("la", Clazz.of(long[].class));
		classBody.private_().field("fa", Clazz.of(float[].class));
		classBody.private_().field("da", Clazz.of(double[].class));
		classBody.private_().field("stra", Clazz.of(String[].class));
		__init_(classBody);
		_getAll(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("z", boolean.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("c", char.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("s", short.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("i", int.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1L);
		code.PUTFIELD("l", long.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1F);
		code.PUTFIELD("f", float.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1D);
		code.PUTFIELD("d", double.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst("str");
		code.PUTFIELD("str", String.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(4);
		code.NEWARRAY(boolean.class);
		code.DUP();
		code.LOADConst(0);
		code.LOADConst(1);
		code.ARRAYSTORE();
		code.DUP();
		code.LOADConst(2);
		code.LOADConst(1);
		code.ARRAYSTORE();
		code.PUTFIELD("za", boolean[].class);

		code.LINE();
		code.LOAD("this");
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
		code.PUTFIELD("ba", byte[].class);

		code.LINE();
		code.LOAD("this");
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
		code.PUTFIELD("ca", char[].class);

		code.LINE();
		code.LOAD("this");
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
		code.PUTFIELD("sa", short[].class);

		code.LINE();
		code.LOAD("this");
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
		code.PUTFIELD("ia", int[].class);

		code.LINE();
		code.LOAD("this");
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
		code.PUTFIELD("la", long[].class);

		code.LINE();
		code.LOAD("this");
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
		code.PUTFIELD("fa", float[].class);

		code.LINE();
		code.LOAD("this");
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
		code.PUTFIELD("da", double[].class);

		code.LINE();
		code.LOAD("this");
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
		code.PUTFIELD("stra", String[].class);

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getAll(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAll").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("z", boolean.class);
		code.STORE("z",boolean.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.STORE("b",byte.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("c", char.class);
		code.STORE("c",char.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("s", short.class);
		code.STORE("s",short.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("i", int.class);
		code.STORE("i",int.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("l", long.class);
		code.STORE("l",long.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("f", float.class);
		code.STORE("f",float.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("d", double.class);
		code.STORE("d",double.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("str", String.class);
		code.STORE("str",String.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("z");
		code.PUTFIELD("z", boolean.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("b");
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("c");
		code.PUTFIELD("c", char.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("s");
		code.PUTFIELD("s", short.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("i");
		code.PUTFIELD("i", int.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("l");
		code.PUTFIELD("l", long.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("f");
		code.PUTFIELD("f", float.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("d");
		code.PUTFIELD("d", double.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("str");
		code.PUTFIELD("str", String.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("z");
		Label label19OfIFEQ = new Label();
		code.IFEQ(label19OfIFEQ);
		code.LOADConst(0);
		Label label20OfGOTO = new Label();
		code.GOTO(label20OfGOTO);

		code.visitLabel(label19OfIFEQ);
		code.LOADConst(1);

		code.visitLabel(label20OfGOTO);
		code.PUTFIELD("z", boolean.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("b");
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(byte.class);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("c");
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(char.class);
		code.PUTFIELD("c", char.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("s");
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(short.class);
		code.PUTFIELD("s", short.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("i");
		code.LOADConst(1);
		code.ADD();
		code.PUTFIELD("i", int.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("l");
		code.LOADConst(1L);
		code.ADD();
		code.PUTFIELD("l", long.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("f");
		code.LOADConst(1F);
		code.ADD();
		code.PUTFIELD("f", float.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("d");
		code.LOADConst(1D);
		code.ADD();
		code.PUTFIELD("d", double.class);

		code.LINE();
		code.LOAD("this");
		code.NEW(StringBuilder.class);
		code.DUP();
		code.LOAD("str");
		code.STATIC(String.class, "valueOf")
			.return_(String.class)
			.parameter(Object.class).INVOKE();
		code.SPECIAL(StringBuilder.class, "<init>")
			.parameter(String.class).INVOKE();
		code.LOADConst(1);
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(int.class).INVOKE();
		code.VIRTUAL(StringBuilder.class, "toString")
			.return_(String.class).INVOKE();
		code.PUTFIELD("str", String.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("za", boolean[].class);
		code.STORE("za",boolean[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("ba", byte[].class);
		code.STORE("ba",byte[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("ca", char[].class);
		code.STORE("ca",char[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("sa", short[].class);
		code.STORE("sa",short[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("ia", int[].class);
		code.STORE("ia",int[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("la", long[].class);
		code.STORE("la",long[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("fa", float[].class);
		code.STORE("fa",float[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("da", double[].class);
		code.STORE("da",double[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("stra", String[].class);
		code.STORE("stra",String[].class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("za");
		code.PUTFIELD("za", boolean[].class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("ba");
		code.PUTFIELD("ba", byte[].class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("ca");
		code.PUTFIELD("ca", char[].class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("sa");
		code.PUTFIELD("sa", short[].class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("ia");
		code.PUTFIELD("ia", int[].class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("la");
		code.PUTFIELD("la", long[].class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("fa");
		code.PUTFIELD("fa", float[].class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("da");
		code.PUTFIELD("da", double[].class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("stra");
		code.PUTFIELD("stra", String[].class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("za", boolean[].class);
		code.LOADConst(0);
		code.LOAD("za");
		code.LOADConst(0);
		code.ARRAYLOAD();
		Label label48OfIFEQ = new Label();
		code.IFEQ(label48OfIFEQ);
		code.LOADConst(0);
		Label label49OfGOTO = new Label();
		code.GOTO(label49OfGOTO);

		code.visitLabel(label48OfIFEQ);
		code.LOADConst(1);

		code.visitLabel(label49OfGOTO);
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("ba", byte[].class);
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
		code.GETFIELD("ca", char[].class);
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
		code.GETFIELD("sa", short[].class);
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
		code.GETFIELD("ia", int[].class);
		code.LOADConst(0);
		code.LOAD("ia");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("la", long[].class);
		code.LOADConst(0);
		code.LOAD("la");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1L);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("fa", float[].class);
		code.LOADConst(0);
		code.LOAD("fa");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1F);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("da", double[].class);
		code.LOADConst(0);
		code.LOAD("da");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.LOADConst(1D);
		code.ADD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("stra", String[].class);
		code.LOADConst(0);
		code.NEW(StringBuilder.class);
		code.DUP();
		code.LOAD("stra");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.STATIC(String.class, "valueOf")
			.return_(String.class)
			.parameter(Object.class).INVOKE();
		code.SPECIAL(StringBuilder.class, "<init>")
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
