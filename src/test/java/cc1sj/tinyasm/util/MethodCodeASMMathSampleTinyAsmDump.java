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
public class MethodCodeASMMathSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new MethodCodeASMMathSampleTinyAsmDump().dump("cc1sj.tinyasm.util.MethodCodeASMMathSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.field(0, "b", Clazz.of(byte.class));
		classBody.field(0, "c", Clazz.of(char.class));
		classBody.field(0, "s", Clazz.of(short.class));
		classBody.field(0, "i", Clazz.of(int.class));
		classBody.field(0, "l", Clazz.of(long.class));
		classBody.field(0, "f", Clazz.of(float.class));
		classBody.field(0, "d", Clazz.of(double.class));
		classBody.field(0, "b3", Clazz.of(byte.class));
		classBody.field(0, "c3", Clazz.of(char.class));
		classBody.field(0, "s3", Clazz.of(short.class));
		classBody.field(0, "i3", Clazz.of(int.class));
		classBody.field(0, "l3", Clazz.of(long.class));
		classBody.field(0, "f3", Clazz.of(float.class));
		classBody.field(0, "d3", Clazz.of(double.class));
		classBody.field(0, "f31", Clazz.of(float.class));
		classBody.field(0, "d31", Clazz.of(double.class));
		classBody.field(0, "b0", Clazz.of(byte.class));
		classBody.field(0, "c0", Clazz.of(char.class));
		classBody.field(0, "s0", Clazz.of(short.class));
		classBody.field(0, "i0", Clazz.of(int.class));
		classBody.field(0, "l1", Clazz.of(long.class));
		classBody.field(0, "f1", Clazz.of(float.class));
		classBody.field(0, "d1", Clazz.of(double.class));
		classBody.field(0, "bn1", Clazz.of(byte.class));
		classBody.field(0, "sn1", Clazz.of(short.class));
		classBody.field(0, "in1", Clazz.of(int.class));
		classBody.field(0, "ln1", Clazz.of(long.class));
		classBody.field(0, "fn1", Clazz.of(float.class));
		classBody.field(0, "dn1", Clazz.of(double.class));
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

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, "<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD_OF_THIS("c");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD_OF_THIS("s");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD_OF_THIS("i");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1L);
		code.PUTFIELD_OF_THIS("l");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1F);
		code.PUTFIELD_OF_THIS("f");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1D);
		code.PUTFIELD_OF_THIS("d");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(3);
		code.PUTFIELD_OF_THIS("b3");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(3);
		code.PUTFIELD_OF_THIS("c3");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(3);
		code.PUTFIELD_OF_THIS("s3");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(3);
		code.PUTFIELD_OF_THIS("i3");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(new Long(3L));
		code.PUTFIELD_OF_THIS("l3");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(new Float("3.0"));
		code.PUTFIELD_OF_THIS("f3");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(new Double("3.0"));
		code.PUTFIELD_OF_THIS("d3");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(new Float("3.1"));
		code.PUTFIELD_OF_THIS("f31");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(new Double("3.1"));
		code.PUTFIELD_OF_THIS("d31");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(0);
		code.PUTFIELD_OF_THIS("b0");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(0);
		code.PUTFIELD_OF_THIS("c0");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(0);
		code.PUTFIELD_OF_THIS("s0");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(0);
		code.PUTFIELD_OF_THIS("i0");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(0L);
		code.PUTFIELD_OF_THIS("l1");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(0F);
		code.PUTFIELD_OF_THIS("f1");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(0D);
		code.PUTFIELD_OF_THIS("d1");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(-1);
		code.PUTFIELD_OF_THIS("bn1");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(-1);
		code.PUTFIELD_OF_THIS("sn1");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(-1);
		code.PUTFIELD_OF_THIS("in1");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(new Long(-1L));
		code.PUTFIELD_OF_THIS("ln1");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(new Float("-1.0"));
		code.PUTFIELD_OF_THIS("fn1");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(new Double("-1.0"));
		code.PUTFIELD_OF_THIS("dn1");
		code.RETURN();

		code.END();
	}

	protected void _addInt(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, int.class, "addInt")
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
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("c");
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("s");
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i");
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("f");
		code.CONVERTTO(int.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("d");
		code.CONVERTTO(int.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.NEG();
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("c");
		code.NEG();
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("s");
		code.NEG();
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i");
		code.NEG();
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("f");
		code.NEG();
		code.CONVERTTO(int.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("d");
		code.NEG();
		code.CONVERTTO(int.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _addByte(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, byte.class, "addByte")
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
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("c");
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("s");
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i");
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("f");
		code.CONVERTTO(int.class);
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("d");
		code.CONVERTTO(int.class);
		code.CONVERTTO(byte.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _addShort(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, short.class, "addShort")
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
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("c");
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("s");
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i");
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("f");
		code.CONVERTTO(int.class);
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("d");
		code.CONVERTTO(int.class);
		code.CONVERTTO(short.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _addLong(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, long.class, "addLong")
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
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("c");
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("s");
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i");
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("f");
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("d");
		code.CONVERTTO(long.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _mathChar(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, char.class, "mathChar")
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
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("c");
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("s");
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i");
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("f");
		code.CONVERTTO(int.class);
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("d");
		code.CONVERTTO(int.class);
		code.CONVERTTO(char.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _mathFloat(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, float.class, "mathFloat")
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
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.CONVERTTO(float.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("c");
		code.CONVERTTO(float.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("s");
		code.CONVERTTO(float.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i");
		code.CONVERTTO(float.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("f");
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("d");
		code.CONVERTTO(float.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

	protected void _mathDouble(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, double.class, "mathDouble")
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
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.CONVERTTO(double.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("c");
		code.CONVERTTO(double.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("s");
		code.CONVERTTO(double.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i");
		code.CONVERTTO(double.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("f");
		code.CONVERTTO(double.class);
		code.STORE("z");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("d");
		code.STORE("z");

		code.LINE();
		code.LOAD("z");
		code.RETURNTop();

		code.END();
	}

}
