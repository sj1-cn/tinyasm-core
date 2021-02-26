package cc1sj.tinyasm.sample.ClassBody;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.lang.Object;
import java.lang.StringBuilder;
import java.lang.String;
@SuppressWarnings("unused")
public class MakeReadOnlyPojoTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new MakeReadOnlyPojoTinyAsmDump().dump("cc1sj.tinyasm.sample.ClassBody.MakeReadOnlyPojo");
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
		_getB(classBody);
		_getC(classBody);
		_getS(classBody);
		_getI(classBody);
		_getL(classBody);
		_getF(classBody);
		_getD(classBody);
		_getStr(classBody);
		_toString(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method("<init>")
			.parameter("b",byte.class)
			.parameter("c",char.class)
			.parameter("s",short.class)
			.parameter("i",int.class)
			.parameter("l",long.class)
			.parameter("f",float.class)
			.parameter("d",double.class)
			.parameter("str",String.class).begin();

		code.LINE(13);
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();

		code.LINE(14);
		code.LOAD("this");
		code.LOAD("b");
		code.PUTFIELD("b", byte.class);

		code.LINE(15);
		code.LOAD("this");
		code.LOAD("c");
		code.PUTFIELD("c", char.class);

		code.LINE(16);
		code.LOAD("this");
		code.LOAD("s");
		code.PUTFIELD("s", short.class);

		code.LINE(17);
		code.LOAD("this");
		code.LOAD("i");
		code.PUTFIELD("i", int.class);

		code.LINE(18);
		code.LOAD("this");
		code.LOAD("l");
		code.PUTFIELD("l", long.class);

		code.LINE(19);
		code.LOAD("this");
		code.LOAD("f");
		code.PUTFIELD("f", float.class);

		code.LINE(20);
		code.LOAD("this");
		code.LOAD("d");
		code.PUTFIELD("d", double.class);

		code.LINE(21);
		code.LOAD("this");
		code.LOAD("str");
		code.PUTFIELD("str", String.class);

		code.LINE(22);
		code.RETURN();

		code.END();
	}

	protected void _getB(ClassBody classBody) {
		MethodCode code = classBody.method(byte.class, "getB").begin();

		code.LINE(25);
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getC(ClassBody classBody) {
		MethodCode code = classBody.method(char.class, "getC").begin();

		code.LINE(29);
		code.LOAD("this");
		code.GETFIELD("c", char.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getS(ClassBody classBody) {
		MethodCode code = classBody.method(short.class, "getS").begin();

		code.LINE(33);
		code.LOAD("this");
		code.GETFIELD("s", short.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getI(ClassBody classBody) {
		MethodCode code = classBody.method(int.class, "getI").begin();

		code.LINE(37);
		code.LOAD("this");
		code.GETFIELD("i", int.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getL(ClassBody classBody) {
		MethodCode code = classBody.method(long.class, "getL").begin();

		code.LINE(41);
		code.LOAD("this");
		code.GETFIELD("l", long.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getF(ClassBody classBody) {
		MethodCode code = classBody.method(float.class, "getF").begin();

		code.LINE(45);
		code.LOAD("this");
		code.GETFIELD("f", float.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getD(ClassBody classBody) {
		MethodCode code = classBody.method(double.class, "getD").begin();

		code.LINE(49);
		code.LOAD("this");
		code.GETFIELD("d", double.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getStr(ClassBody classBody) {
		MethodCode code = classBody.method(String.class, "getStr").begin();

		code.LINE(53);
		code.LOAD("this");
		code.GETFIELD("str", String.class);
		code.RETURNTop();

		code.END();
	}

	protected void _toString(ClassBody classBody) {
		MethodCode code = classBody.method(String.class, "toString").begin();

		code.LINE(58);
		code.NEW(StringBuilder.class);
		code.DUP();
		code.SPECIAL(StringBuilder.class, "<init>").INVOKE();
		code.STORE("builder",StringBuilder.class);

		code.LINE(59);
		code.LOAD("builder");
		code.LOADConst("MakeReadOnlyPojo [b=");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(int.class).INVOKE();
		code.LOADConst(", c=");

		code.LINE(60);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("c", char.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(char.class).INVOKE();
		code.LOADConst(", s=");

		code.LINE(61);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("s", short.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(int.class).INVOKE();
		code.LOADConst(", i=");

		code.LINE(62);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("i", int.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(int.class).INVOKE();
		code.LOADConst(", l=");

		code.LINE(63);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("l", long.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(long.class).INVOKE();
		code.LOADConst(", f=");

		code.LINE(64);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("f", float.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(float.class).INVOKE();
		code.LOADConst(", d=");

		code.LINE(65);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("d", double.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(double.class).INVOKE();
		code.LOADConst(", str=");

		code.LINE(66);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("str", String.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOADConst("]");

		code.LINE(67);
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.POP();

		code.LINE(68);
		code.LOAD("builder");
		code.VIRTUAL(StringBuilder.class, "toString")
			.reTurn(String.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

}
