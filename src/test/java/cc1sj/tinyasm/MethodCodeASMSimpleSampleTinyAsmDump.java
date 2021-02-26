package cc1sj.tinyasm;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.lang.Object;
import java.lang.String;
@SuppressWarnings("unused")
public class MethodCodeASMSimpleSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new MethodCodeASMSimpleSampleTinyAsmDump().__dump__("cc1sj.tinyasm.MethodCodeASMSimpleSample");
	}

	public byte[] __dump__(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className).access(ACC_PUBLIC | ACC_SUPER).body();

classBody.field("b", Clazz.of(byte.class));
classBody.field("c", Clazz.of(char.class));
classBody.field("s", Clazz.of(short.class));
classBody.field("i", Clazz.of(int.class));
classBody.field("l", Clazz.of(long.class));
classBody.field("f", Clazz.of(float.class));
classBody.field("d", Clazz.of(double.class));
classBody.field("str", Clazz.of(String.class));
		__init_(classBody);
		_getField(classBody);
		_getFieldAll(classBody);
		_getFieldConst(classBody);
		_getFieldIConst(classBody);
		_retByte(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method("<init>").begin();

		code.LINE(3);
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _getField(ClassBody classBody) {
		MethodCode code = classBody.method(int.class, "getField").begin();

		code.LINE(15);
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.LOAD("this");
		code.GETFIELD("i", int.class);
		code.ADD();
		code.STORE("x",int.class);

		code.LINE(16);
		code.LOAD("x");
		code.RETURNTop();

		code.END();
	}

	protected void _getFieldAll(ClassBody classBody) {
		MethodCode code = classBody.method(int.class, "getFieldAll").begin();

		code.LINE(20);
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
		code.STORE("x",int.class);

		code.LINE(21);
		code.LOAD("x");
		code.RETURNTop();

		code.END();
	}

	protected void _getFieldConst(ClassBody classBody) {
		MethodCode code = classBody.method(int.class, "getFieldConst").begin();

		code.LINE(25);
		code.LOAD("this");
		code.LOADConst(100);
		code.PUTFIELD("b", byte.class);

		code.LINE(26);
		code.LOAD("this");
		code.LOADConst(1000);
		code.PUTFIELD("c", char.class);

		code.LINE(27);
		code.LOAD("this");
		code.LOADConst(10000);
		code.PUTFIELD("s", short.class);

		code.LINE(28);
		code.LOAD("this");
		code.LOADConst(Integer.valueOf(100000));
		code.PUTFIELD("i", int.class);

		code.LINE(29);
		code.LOAD("this");
		code.LOADConst(Long.valueOf(1000000L));
		code.PUTFIELD("l", long.class);

		code.LINE(30);
		code.LOAD("this");
		code.LOADConst(Float.valueOf("1.0E7"));
		code.PUTFIELD("f", float.class);

		code.LINE(31);
		code.LOAD("this");
		code.LOADConst(Double.valueOf("1.0E8"));
		code.PUTFIELD("d", double.class);

		code.LINE(32);
		code.LOAD("this");
		code.LOADConst("1000000000s");
		code.PUTFIELD("str", String.class);

		code.LINE(33);
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
		MethodCode code = classBody.method(int.class, "getFieldIConst").begin();

		code.LINE(37);
		code.LOAD("this");
		code.LOADConst(0);
		code.PUTFIELD("b", byte.class);

		code.LINE(38);
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD("b", byte.class);

		code.LINE(39);
		code.LOAD("this");
		code.LOADConst(2);
		code.PUTFIELD("b", byte.class);

		code.LINE(40);
		code.LOAD("this");
		code.LOADConst(3);
		code.PUTFIELD("b", byte.class);

		code.LINE(41);
		code.LOAD("this");
		code.LOADConst(4);
		code.PUTFIELD("b", byte.class);

		code.LINE(42);
		code.LOAD("this");
		code.LOADConst(5);
		code.PUTFIELD("b", byte.class);

		code.LINE(43);
		code.LOAD("this");
		code.LOADConst(6);
		code.PUTFIELD("b", byte.class);

		code.LINE(44);
		code.LOAD("this");
		code.LOADConst(7);
		code.PUTFIELD("b", byte.class);

		code.LINE(45);
		code.LOAD("this");
		code.LOADConst(8);
		code.PUTFIELD("b", byte.class);

		code.LINE(46);
		code.LOAD("this");
		code.LOADConst(-4);
		code.PUTFIELD("b", byte.class);

		code.LINE(47);
		code.LOAD("this");
		code.LOADConst(-3);
		code.PUTFIELD("b", byte.class);

		code.LINE(48);
		code.LOAD("this");
		code.LOADConst(-2);
		code.PUTFIELD("b", byte.class);

		code.LINE(49);
		code.LOAD("this");
		code.LOADConst(-1);
		code.PUTFIELD("b", byte.class);

		code.LINE(50);
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.RETURNTop();

		code.END();
	}

	protected void _retByte(ClassBody classBody) {
		MethodCode code = classBody.method(byte.class, "retByte").begin();

		code.LINE(54);
		code.LOADConst(1);
		code.STORE("x",byte.class);

		code.LINE(55);
		code.LOAD("x");
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(byte.class);
		code.STORE("x");

		code.LINE(56);
		code.LOAD("this");
		code.LOADConst(10);
		code.PUTFIELD("b", byte.class);

		code.LINE(57);
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.STORE("x");

		code.LINE(58);
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.LOAD("x");
		code.ADD();
		code.CONVERTTO(byte.class);
		code.STORE("y",byte.class);

		code.LINE(59);
		code.LOAD("y");
		code.RETURNTop();

		code.END();
	}

}
