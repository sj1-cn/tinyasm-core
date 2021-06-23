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
		__init_(classBody);

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
		code.RETURN();

		code.END();
	}

}
