package cc1sj.tinyasm.util;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.MethodCode;
@SuppressWarnings("unused")
public class MethodASMArraySampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new MethodASMArraySampleTinyAsmDump().dump("cc1sj.tinyasm.util.MethodASMArraySample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.private_().field("ba", Clazz.of(byte[].class));
		classBody.private_().field("ca", Clazz.of(char[].class));
		classBody.private_().field("sa", Clazz.of(short[].class));
		classBody.private_().field("ia", Clazz.of(int[].class));
		classBody.private_().field("la", Clazz.of(long[].class));
		classBody.private_().field("fa", Clazz.of(float[].class));
		classBody.private_().field("da", Clazz.of(double[].class));
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
		code.RETURN();

		code.END();
	}

	protected void _init(ClassBody classBody) {
		MethodCode code = classBody.public_().method("init").begin();

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(byte.class);
		code.PUTFIELD_OF_THIS("ba");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(char.class);
		code.PUTFIELD_OF_THIS("ca");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(short.class);
		code.PUTFIELD_OF_THIS("sa");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(int.class);
		code.PUTFIELD_OF_THIS("ia");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(long.class);
		code.PUTFIELD_OF_THIS("la");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(float.class);
		code.PUTFIELD_OF_THIS("fa");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(double.class);
		code.PUTFIELD_OF_THIS("da");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.NEWARRAY(String.class);
		code.PUTFIELD_OF_THIS("stra");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setArrayValue(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setArrayValue").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("ba");
		code.LOADConst(0);
		code.LOADConst(100);
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("ca");
		code.LOADConst(0);
		code.LOADConst(1000);
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("sa");
		code.LOADConst(0);
		code.LOADConst(10000);
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("ia");
		code.LOADConst(0);
		code.LOADConst(Integer.valueOf(100000));
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("la");
		code.LOADConst(0);
		code.LOADConst(Long.valueOf(1000000L));
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("fa");
		code.LOADConst(0);
		code.LOADConst(Float.valueOf("1.0E7"));
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("da");
		code.LOADConst(0);
		code.LOADConst(Double.valueOf("1.0E8"));
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("stra");
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
		code.GETFIELD_OF_THIS("ba");
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD_OF_THIS("ba");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("ca");
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD_OF_THIS("ca");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("sa");
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD_OF_THIS("sa");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("ia");
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD_OF_THIS("ia");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("la");
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD_OF_THIS("la");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("fa");
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD_OF_THIS("fa");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("da");
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD_OF_THIS("da");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("stra");
		code.LOADConst(1);
		code.LOAD("this");
		code.GETFIELD_OF_THIS("stra");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.ARRAYSTORE();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
