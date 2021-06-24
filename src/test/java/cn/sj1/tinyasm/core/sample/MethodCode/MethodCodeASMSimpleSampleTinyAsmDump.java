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
public class MethodCodeASMSimpleSampleTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new MethodCodeASMSimpleSampleTinyAsmDump().build("cn.sj1.tinyasm.core.MethodCodeASMSimpleSample");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
				.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.private_().field("b", Clazz.of(byte.class));
		classBody.private_().field("c", Clazz.of(char.class));
		classBody.private_().field("s", Clazz.of(short.class));
		classBody.private_().field("i", Clazz.of(int.class));
		classBody.private_().field("l", Clazz.of(long.class));
		classBody.private_().field("f", Clazz.of(float.class));
		classBody.private_().field("d", Clazz.of(double.class));
		classBody.private_().field("str", Clazz.of(String.class));
		__init_(classBody);
		_getField(classBody);
		_getFieldAll(classBody);
		_getFieldConst(classBody);
		_getFieldIConst(classBody);
		_retByte(classBody);

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

	protected void _getField(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getField")
				.return_(int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.LOAD("this");
		code.GETFIELD("i", int.class);
		code.ADD();
		code.STORE("x", int.class);

		code.LINE();
		code.LOAD("x");
		code.RETURNTop();

		code.END();
	}

	protected void _getFieldAll(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getFieldAll")
				.return_(int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.LOAD("this");
		code.GETFIELD("c", char.class);
		code.ADD();
		code.LOAD("this");
		code.GETFIELD("s", short.class);
		code.ADD();
		code.LOAD("this");
		code.GETFIELD("i", int.class);
		code.ADD();
		code.CONVERTTO(long.class);
		code.LOAD("this");
		code.GETFIELD("l", long.class);
		code.ADD();
		code.CONVERTTO(float.class);
		code.LOAD("this");
		code.GETFIELD("f", float.class);
		code.ADD();
		code.CONVERTTO(double.class);
		code.LOAD("this");
		code.GETFIELD("d", double.class);
		code.ADD();
		code.CONVERTTO(int.class);
		code.STORE("x", int.class);

		code.LINE();
		code.LOAD("x");
		code.RETURNTop();

		code.END();
	}

	protected void _getFieldConst(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getFieldConst")
				.return_(int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOADConst(100);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1000);
		code.PUTFIELD("c", char.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10000);
		code.PUTFIELD("s", short.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(Integer.valueOf(100000));
		code.PUTFIELD("i", int.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(Long.valueOf(1000000L));
		code.PUTFIELD("l", long.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(Float.valueOf("1.0E7"));
		code.PUTFIELD("f", float.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(Double.valueOf("1.0E8"));
		code.PUTFIELD("d", double.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst("1000000000s");
		code.PUTFIELD("str", String.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.LOAD("this");
		code.GETFIELD("c", char.class);
		code.ADD();
		code.LOAD("this");
		code.GETFIELD("s", short.class);
		code.ADD();
		code.LOAD("this");
		code.GETFIELD("i", int.class);
		code.ADD();
		code.CONVERTTO(long.class);
		code.LOAD("this");
		code.GETFIELD("l", long.class);
		code.ADD();
		code.CONVERTTO(float.class);
		code.LOAD("this");
		code.GETFIELD("f", float.class);
		code.ADD();
		code.CONVERTTO(double.class);
		code.LOAD("this");
		code.GETFIELD("d", double.class);
		code.ADD();
		code.CONVERTTO(int.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getFieldIConst(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getFieldIConst")
				.return_(int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOADConst(0);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(2);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(3);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(4);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(5);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(6);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(7);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(8);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(-4);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(-3);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(-2);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOADConst(-1);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.RETURNTop();

		code.END();
	}

	protected void _retByte(ClassBody classBody) {
		MethodCode code = classBody.public_().method("retByte")
				.return_(byte.class).begin();

		code.LINE();
		code.LOADConst(1);
		code.STORE("x", byte.class);

		code.LINE();
		code.LOAD("x");
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(byte.class);
		code.STORE("x");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.STORE("x");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.LOAD("x");
		code.ADD();
		code.CONVERTTO(byte.class);
		code.STORE("y", byte.class);

		code.LINE();
		code.LOAD("y");
		code.RETURNTop();

		code.END();
	}

}
