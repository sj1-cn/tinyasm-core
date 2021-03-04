package cc1sj.tinyasm.util;
import org.objectweb.asm.Label;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.lang.Object;
@SuppressWarnings("unused")
public class MethodCodeASMMathStaticSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new MethodCodeASMMathStaticSampleTinyAsmDump().dump("cc1sj.tinyasm.util.MethodCodeASMMathStaticSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className)
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
		__init_(classBody);
		_addInt(classBody);
		_addByte(classBody);
		_addShort(classBody);
		_addLong(classBody);
		_mathChar(classBody);
		_mathFloat(classBody);
		_mathDouble(classBody);
		__clinit_(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, "<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _addInt(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PUBLIC | ACC_STATIC, int.class, "addInt")
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
		code.GET_THIS_STATIC("b");
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("c");
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("s");
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("i");
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("f");
		code.CONVERTTO(int.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("d");
		code.CONVERTTO(int.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("b");
		code.NEG();
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("c");
		code.NEG();
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("s");
		code.NEG();
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("i");
		code.NEG();
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("f");
		code.NEG();
		code.CONVERTTO(int.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("d");
		code.NEG();
		code.CONVERTTO(int.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _addByte(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PUBLIC | ACC_STATIC, byte.class, "addByte")
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
		code.GET_THIS_STATIC("b");
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("c");
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("s");
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("i");
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("f");
		code.CONVERTTO(int.class);
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("d");
		code.CONVERTTO(int.class);
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _addShort(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PUBLIC | ACC_STATIC, short.class, "addShort")
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
		code.GET_THIS_STATIC("b");
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("c");
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("s");
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("i");
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("f");
		code.CONVERTTO(int.class);
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("d");
		code.CONVERTTO(int.class);
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _addLong(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PUBLIC | ACC_STATIC, long.class, "addLong")
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
		code.GET_THIS_STATIC("b");
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("c");
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("s");
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("i");
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("f");
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("d");
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _mathChar(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PUBLIC | ACC_STATIC, char.class, "mathChar")
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
		code.GET_THIS_STATIC("b");
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("c");
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("s");
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("i");
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("f");
		code.CONVERTTO(int.class);
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("d");
		code.CONVERTTO(int.class);
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _mathFloat(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PUBLIC | ACC_STATIC, float.class, "mathFloat")
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
		code.GET_THIS_STATIC("b");
		code.CONVERTTO(float.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("c");
		code.CONVERTTO(float.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("s");
		code.CONVERTTO(float.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("i");
		code.CONVERTTO(float.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("f");
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("d");
		code.CONVERTTO(float.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _mathDouble(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PUBLIC | ACC_STATIC, double.class, "mathDouble")
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
		code.GET_THIS_STATIC("b");
		code.CONVERTTO(double.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("c");
		code.CONVERTTO(double.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("s");
		code.CONVERTTO(double.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("i");
		code.CONVERTTO(double.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("f");
		code.CONVERTTO(double.class);
		code.STORE("z");

		code.LINE();
		code.GET_THIS_STATIC("d");
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void __clinit_(ClassBody classBody) {
		MethodCode code = classBody.staticMethod("<clinit>").begin();

		code.LINE();
		code.LOADConst(1);
		code.PUT_THIS_STATIC("b");

		code.LINE();
		code.LOADConst(1);
		code.PUT_THIS_STATIC("c");

		code.LINE();
		code.LOADConst(1);
		code.PUT_THIS_STATIC("s");

		code.LINE();
		code.LOADConst(1);
		code.PUT_THIS_STATIC("i");

		code.LINE();
		code.LOADConst(1L);
		code.PUT_THIS_STATIC("l");

		code.LINE();
		code.LOADConst(1F);
		code.PUT_THIS_STATIC("f");

		code.LINE();
		code.LOADConst(1D);
		code.PUT_THIS_STATIC("d");

		code.LINE();
		code.LOADConst(3);
		code.PUT_THIS_STATIC("b3");

		code.LINE();
		code.LOADConst(3);
		code.PUT_THIS_STATIC("c3");

		code.LINE();
		code.LOADConst(3);
		code.PUT_THIS_STATIC("s3");

		code.LINE();
		code.LOADConst(3);
		code.PUT_THIS_STATIC("i3");

		code.LINE();
		code.LOADConst(new Long(3L));
		code.PUT_THIS_STATIC("l3");

		code.LINE();
		code.LOADConst(new Float("3.0"));
		code.PUT_THIS_STATIC("f3");

		code.LINE();
		code.LOADConst(new Double("3.0"));
		code.PUT_THIS_STATIC("d3");

		code.LINE();
		code.LOADConst(new Float("3.1"));
		code.PUT_THIS_STATIC("f31");

		code.LINE();
		code.LOADConst(new Double("3.1"));
		code.PUT_THIS_STATIC("d31");

		code.LINE();
		code.LOADConst(0);
		code.PUT_THIS_STATIC("b0");

		code.LINE();
		code.LOADConst(0);
		code.PUT_THIS_STATIC("c0");

		code.LINE();
		code.LOADConst(0);
		code.PUT_THIS_STATIC("s0");

		code.LINE();
		code.LOADConst(0);
		code.PUT_THIS_STATIC("i0");

		code.LINE();
		code.LOADConst(0L);
		code.PUT_THIS_STATIC("l1");

		code.LINE();
		code.LOADConst(0F);
		code.PUT_THIS_STATIC("f1");

		code.LINE();
		code.LOADConst(0D);
		code.PUT_THIS_STATIC("d1");

		code.LINE();
		code.LOADConst(-1);
		code.PUT_THIS_STATIC("bn1");

		code.LINE();
		code.LOADConst(-1);
		code.PUT_THIS_STATIC("sn1");

		code.LINE();
		code.LOADConst(-1);
		code.PUT_THIS_STATIC("in1");

		code.LINE();
		code.LOADConst(new Long(-1L));
		code.PUT_THIS_STATIC("ln1");

		code.LINE();
		code.LOADConst(new Float("-1.0"));
		code.PUT_THIS_STATIC("fn1");

		code.LINE();
		code.LOADConst(new Double("-1.0"));
		code.PUT_THIS_STATIC("dn1");
		code.RETURN();

		code.END();
	}

}
