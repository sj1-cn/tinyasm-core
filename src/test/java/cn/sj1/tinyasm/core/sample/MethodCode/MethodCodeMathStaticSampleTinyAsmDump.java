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
public class MethodCodeMathStaticSampleTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new MethodCodeMathStaticSampleTinyAsmDump().build("cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeMathStaticSample");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.staticField(ACC_STATIC, "b", Clazz.of(byte.class));
		classBody.staticField(ACC_STATIC, "c", Clazz.of(char.class));
		classBody.staticField(ACC_STATIC, "s", Clazz.of(short.class));
		classBody.staticField(ACC_STATIC, "i", Clazz.of(int.class));
		classBody.staticField(ACC_STATIC, "l", Clazz.of(long.class));
		classBody.staticField(ACC_STATIC, "f", Clazz.of(float.class));
		classBody.staticField(ACC_STATIC, "d", Clazz.of(double.class));
		classBody.staticField(ACC_STATIC, "b3", Clazz.of(byte.class));
		classBody.staticField(ACC_STATIC, "c3", Clazz.of(char.class));
		classBody.staticField(ACC_STATIC, "s3", Clazz.of(short.class));
		classBody.staticField(ACC_STATIC, "i3", Clazz.of(int.class));
		classBody.staticField(ACC_STATIC, "l3", Clazz.of(long.class));
		classBody.staticField(ACC_STATIC, "f3", Clazz.of(float.class));
		classBody.staticField(ACC_STATIC, "d3", Clazz.of(double.class));
		classBody.staticField(ACC_STATIC, "f31", Clazz.of(float.class));
		classBody.staticField(ACC_STATIC, "d31", Clazz.of(double.class));
		classBody.staticField(ACC_STATIC, "b0", Clazz.of(byte.class));
		classBody.staticField(ACC_STATIC, "c0", Clazz.of(char.class));
		classBody.staticField(ACC_STATIC, "s0", Clazz.of(short.class));
		classBody.staticField(ACC_STATIC, "i0", Clazz.of(int.class));
		classBody.staticField(ACC_STATIC, "l1", Clazz.of(long.class));
		classBody.staticField(ACC_STATIC, "f1", Clazz.of(float.class));
		classBody.staticField(ACC_STATIC, "d1", Clazz.of(double.class));
		classBody.staticField(ACC_STATIC, "bn1", Clazz.of(byte.class));
		classBody.staticField(ACC_STATIC, "sn1", Clazz.of(short.class));
		classBody.staticField(ACC_STATIC, "in1", Clazz.of(int.class));
		classBody.staticField(ACC_STATIC, "ln1", Clazz.of(long.class));
		classBody.staticField(ACC_STATIC, "fn1", Clazz.of(float.class));
		classBody.staticField(ACC_STATIC, "dn1", Clazz.of(double.class));
		__clinit_(classBody);
		__init_(classBody);
		_addInt(classBody);
		_addByte(classBody);
		_addShort(classBody);
		_addLong(classBody);
		_mathChar(classBody);
		_mathFloat(classBody);
		_mathDouble(classBody);

		return classBody.end().toByteArray();
	}

	protected void __clinit_(ClassBody classBody) {
		MethodCode code = classBody.staticMethod("<clinit>").begin();

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
		code.LOADConst(3);
		code.PUTSTATIC("b3", byte.class);

		code.LINE();
		code.LOADConst(3);
		code.PUTSTATIC("c3", char.class);

		code.LINE();
		code.LOADConst(3);
		code.PUTSTATIC("s3", short.class);

		code.LINE();
		code.LOADConst(3);
		code.PUTSTATIC("i3", int.class);

		code.LINE();
		code.LOADConst(Long.valueOf(3L));
		code.PUTSTATIC("l3", long.class);

		code.LINE();
		code.LOADConst(Float.valueOf("3.0"));
		code.PUTSTATIC("f3", float.class);

		code.LINE();
		code.LOADConst(Double.valueOf("3.0"));
		code.PUTSTATIC("d3", double.class);

		code.LINE();
		code.LOADConst(Float.valueOf("3.1"));
		code.PUTSTATIC("f31", float.class);

		code.LINE();
		code.LOADConst(Double.valueOf("3.1"));
		code.PUTSTATIC("d31", double.class);

		code.LINE();
		code.LOADConst(0);
		code.PUTSTATIC("b0", byte.class);

		code.LINE();
		code.LOADConst(0);
		code.PUTSTATIC("c0", char.class);

		code.LINE();
		code.LOADConst(0);
		code.PUTSTATIC("s0", short.class);

		code.LINE();
		code.LOADConst(0);
		code.PUTSTATIC("i0", int.class);

		code.LINE();
		code.LOADConst(0L);
		code.PUTSTATIC("l1", long.class);

		code.LINE();
		code.LOADConst(0F);
		code.PUTSTATIC("f1", float.class);

		code.LINE();
		code.LOADConst(0D);
		code.PUTSTATIC("d1", double.class);

		code.LINE();
		code.LOADConst(-1);
		code.PUTSTATIC("bn1", byte.class);

		code.LINE();
		code.LOADConst(-1);
		code.PUTSTATIC("sn1", short.class);

		code.LINE();
		code.LOADConst(-1);
		code.PUTSTATIC("in1", int.class);

		code.LINE();
		code.LOADConst(Long.valueOf(-1L));
		code.PUTSTATIC("ln1", long.class);

		code.LINE();
		code.LOADConst(Float.valueOf("-1.0"));
		code.PUTSTATIC("fn1", float.class);

		code.LINE();
		code.LOADConst(Double.valueOf("-1.0"));
		code.PUTSTATIC("dn1", double.class);
		code.RETURN();

		code.END();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _addInt(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PUBLIC | ACC_STATIC, "addInt")
			.return_(int.class )
			.parameter("x",int.class)
			.parameter("y",int.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.ADD();
		code.STORE("z",int.class);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.MUL();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.SUB();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.DIV();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.REM();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.AND();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.OR();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.XOR();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.SHL();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.SHR();
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("b", byte.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("c", char.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("s", short.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("i", int.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("f", float.class);
		code.CONVERTTO(int.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("d", double.class);
		code.CONVERTTO(int.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("b", byte.class);
		code.NEG();
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("c", char.class);
		code.NEG();
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("s", short.class);
		code.NEG();
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("i", int.class);
		code.NEG();
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("f", float.class);
		code.NEG();
		code.CONVERTTO(int.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("d", double.class);
		code.NEG();
		code.CONVERTTO(int.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _addByte(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PUBLIC | ACC_STATIC, "addByte")
			.return_(byte.class )
			.parameter("x",byte.class)
			.parameter("y",byte.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.ADD();
		code.CONVERTTO(byte.class);
		code.STORE("z",byte.class);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.MUL();
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.SUB();
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.DIV();
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.REM();
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.AND();
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.OR();
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.XOR();
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("b", byte.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("c", char.class);
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("s", short.class);
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("i", int.class);
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("f", float.class);
		code.CONVERTTO(int.class);
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("d", double.class);
		code.CONVERTTO(int.class);
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _addShort(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PUBLIC | ACC_STATIC, "addShort")
			.return_(short.class )
			.parameter("x",short.class)
			.parameter("y",short.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.ADD();
		code.CONVERTTO(short.class);
		code.STORE("z",short.class);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.MUL();
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.SUB();
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.DIV();
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.REM();
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.AND();
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.OR();
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.XOR();
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("b", byte.class);
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("c", char.class);
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("s", short.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("i", int.class);
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("f", float.class);
		code.CONVERTTO(int.class);
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("d", double.class);
		code.CONVERTTO(int.class);
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _addLong(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PUBLIC | ACC_STATIC, "addLong")
			.return_(long.class )
			.parameter("x",long.class)
			.parameter("y",long.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.ADD();
		code.STORE("z",long.class);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.MUL();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.SUB();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.DIV();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.REM();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.AND();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.OR();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.XOR();
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("b", byte.class);
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("c", char.class);
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("s", short.class);
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("i", int.class);
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("f", float.class);
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("d", double.class);
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _mathChar(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PUBLIC | ACC_STATIC, "mathChar")
			.return_(char.class )
			.parameter("x",char.class)
			.parameter("y",char.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.ADD();
		code.CONVERTTO(char.class);
		code.STORE("z",char.class);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.MUL();
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.SUB();
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.DIV();
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.REM();
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.AND();
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.OR();
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.XOR();
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("b", byte.class);
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("c", char.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("s", short.class);
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("i", int.class);
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("f", float.class);
		code.CONVERTTO(int.class);
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("d", double.class);
		code.CONVERTTO(int.class);
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _mathFloat(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PUBLIC | ACC_STATIC, "mathFloat")
			.return_(float.class )
			.parameter("x",float.class)
			.parameter("y",float.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.ADD();
		code.STORE("z",float.class);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.MUL();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.SUB();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.DIV();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.REM();
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("b", byte.class);
		code.CONVERTTO(float.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("c", char.class);
		code.CONVERTTO(float.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("s", short.class);
		code.CONVERTTO(float.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("i", int.class);
		code.CONVERTTO(float.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("f", float.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("d", double.class);
		code.CONVERTTO(float.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _mathDouble(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PUBLIC | ACC_STATIC, "mathDouble")
			.return_(double.class )
			.parameter("x",double.class)
			.parameter("y",double.class).begin();

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.ADD();
		code.STORE("z",double.class);

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.MUL();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.SUB();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.DIV();
		code.STORE("z");

		code.LINE();
		code.LOAD("x");
		code.LOAD("y");
		code.REM();
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("b", byte.class);
		code.CONVERTTO(double.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("c", char.class);
		code.CONVERTTO(double.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("s", short.class);
		code.CONVERTTO(double.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("i", int.class);
		code.CONVERTTO(double.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("f", float.class);
		code.CONVERTTO(double.class);
		code.STORE("z");

		code.LINE();
		code.GETSTATIC("d", double.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

}
