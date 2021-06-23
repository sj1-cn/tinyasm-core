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
public class MethodCodeArraySampleTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new MethodCodeArraySampleTinyAsmDump().build("cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeArraySample");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.field("za", Clazz.of(boolean[].class));
		classBody.field("ba", Clazz.of(byte[].class));
		classBody.field("ca", Clazz.of(char[].class));
		classBody.field("sa", Clazz.of(short[].class));
		classBody.field("ia", Clazz.of(int[].class));
		classBody.field("la", Clazz.of(long[].class));
		classBody.field("fa", Clazz.of(float[].class));
		classBody.field("da", Clazz.of(double[].class));
		classBody.private_().field("stra", Clazz.of(String[].class));
		__init_(classBody);
		_init(classBody);
		_setArrayValue(classBody);
		_getArrayValue(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();

		code.LINE();
		code.LOAD("this");
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
		code.RETURN();

		code.END();
	}

	protected void _init(ClassBody classBody) {
		MethodCode code = classBody.public_().method("init").begin();

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(byte.class);
		code.PUTFIELD("ba", byte[].class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(char.class);
		code.PUTFIELD("ca", char[].class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(short.class);
		code.PUTFIELD("sa", short[].class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(int.class);
		code.PUTFIELD("ia", int[].class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(long.class);
		code.PUTFIELD("la", long[].class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(float.class);
		code.PUTFIELD("fa", float[].class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(double.class);
		code.PUTFIELD("da", double[].class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(String.class);
		code.PUTFIELD("stra", String[].class);

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setArrayValue(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setArrayValue").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("ba", byte[].class);
		code.LOADConst(0);
		code.LOADConst(100);
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("ca", char[].class);
		code.LOADConst(0);
		code.LOADConst(1000);
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("sa", short[].class);
		code.LOADConst(0);
		code.LOADConst(10000);
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("ia", int[].class);
		code.LOADConst(0);
		code.LOADConst(Integer.valueOf(100000));
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("la", long[].class);
		code.LOADConst(0);
		code.LOADConst(Long.valueOf(1000000L));
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("fa", float[].class);
		code.LOADConst(0);
		code.LOADConst(Float.valueOf("1.0E7"));
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("da", double[].class);
		code.LOADConst(0);
		code.LOADConst(Double.valueOf("1.0E8"));
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("stra", String[].class);
		code.LOADConst(0);
		code.LOADConst("1000000000s");
		code.ARRAYSTORE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getArrayValue(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getArrayValue").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("ba", byte[].class);
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD("ba", byte[].class);
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("ca", char[].class);
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD("ca", char[].class);
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("sa", short[].class);
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD("sa", short[].class);
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("ia", int[].class);
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD("ia", int[].class);
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("la", long[].class);
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD("la", long[].class);
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("fa", float[].class);
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD("fa", float[].class);
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("da", double[].class);
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD("da", double[].class);
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("stra", String[].class);
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD("stra", String[].class);
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
