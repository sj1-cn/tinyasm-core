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
		return new MethodCodeASMSimpleSampleTinyAsmDump().dump("cc1sj.tinyasm.MethodCodeASMSimpleSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

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

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _getField(ClassBody classBody) {
		MethodCode code = classBody.method(int.class, "getField").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i");
		code.ADD();
		code.STORE("x",int.class);

		code.LINE();
		code.LOAD("x");
		code.RETURNTop();

		code.END();
	}

	protected void _getFieldAll(ClassBody classBody) {
		MethodCode code = classBody.method(int.class, "getFieldAll").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.LOAD("this");
		code.GETFIELD_OF_THIS("c");
		code.ADD();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("s");
		code.ADD();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i");
		code.ADD();
		code.CONVERTTO(long.class);
		code.LOAD("this");
		code.GETFIELD_OF_THIS("l");
		code.ADD();
		code.CONVERTTO(float.class);
		code.LOAD("this");
		code.GETFIELD_OF_THIS("f");
		code.ADD();
		code.CONVERTTO(double.class);
		code.LOAD("this");
		code.GETFIELD_OF_THIS("d");
		code.ADD();
		code.CONVERTTO(int.class);
		code.STORE("x",int.class);

		code.LINE();
		code.LOAD("x");
		code.RETURNTop();

		code.END();
	}

	protected void _getFieldConst(ClassBody classBody) {
		MethodCode code = classBody.method(int.class, "getFieldConst").begin();

		code.LINE();
		code.LOAD("this");
		code.LOADConst(100);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1000);
		code.PUTFIELD_OF_THIS("c");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10000);
		code.PUTFIELD_OF_THIS("s");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(new Integer(100000));
		code.PUTFIELD_OF_THIS("i");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(new Long(1000000L));
		code.PUTFIELD_OF_THIS("l");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(new Float("1.0E7"));
		code.PUTFIELD_OF_THIS("f");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(new Double("1.0E8"));
		code.PUTFIELD_OF_THIS("d");

		code.LINE();
		code.LOAD("this");
		code.LOADConst("1000000000s");
		code.PUTFIELD_OF_THIS("str");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.LOAD("this");
		code.GETFIELD_OF_THIS("c");
		code.ADD();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("s");
		code.ADD();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i");
		code.ADD();
		code.CONVERTTO(long.class);
		code.LOAD("this");
		code.GETFIELD_OF_THIS("l");
		code.ADD();
		code.CONVERTTO(float.class);
		code.LOAD("this");
		code.GETFIELD_OF_THIS("f");
		code.ADD();
		code.CONVERTTO(double.class);
		code.LOAD("this");
		code.GETFIELD_OF_THIS("d");
		code.ADD();
		code.CONVERTTO(int.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getFieldIConst(ClassBody classBody) {
		MethodCode code = classBody.method(int.class, "getFieldIConst").begin();

		code.LINE();
		code.LOAD("this");
		code.LOADConst(0);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(1);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(2);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(3);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(4);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(5);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(6);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(7);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(8);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(-4);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(-3);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(-2);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(-1);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.RETURNTop();

		code.END();
	}

	protected void _retByte(ClassBody classBody) {
		MethodCode code = classBody.method(byte.class, "retByte").begin();

		code.LINE();
		code.LOADConst(1);
		code.STORE("x",byte.class);

		code.LINE();
		code.LOAD("x");
		code.LOADConst(1);
		code.ADD();
		code.CONVERTTO(byte.class);
		code.STORE("x");

		code.LINE();
		code.LOAD("this");
		code.LOADConst(10);
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.STORE("x");

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.LOAD("x");
		code.ADD();
		code.CONVERTTO(byte.class);
		code.STORE("y",byte.class);

		code.LINE();
		code.LOAD("y");
		code.RETURNTop();

		code.END();
	}

}
