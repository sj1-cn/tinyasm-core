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

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();

		code.LINE();
		code.LOAD("this");
		code.LOAD("b");
		code.PUTFIELD_OF_THIS("b");

		code.LINE();
		code.LOAD("this");
		code.LOAD("c");
		code.PUTFIELD_OF_THIS("c");

		code.LINE();
		code.LOAD("this");
		code.LOAD("s");
		code.PUTFIELD_OF_THIS("s");

		code.LINE();
		code.LOAD("this");
		code.LOAD("i");
		code.PUTFIELD_OF_THIS("i");

		code.LINE();
		code.LOAD("this");
		code.LOAD("l");
		code.PUTFIELD_OF_THIS("l");

		code.LINE();
		code.LOAD("this");
		code.LOAD("f");
		code.PUTFIELD_OF_THIS("f");

		code.LINE();
		code.LOAD("this");
		code.LOAD("d");
		code.PUTFIELD_OF_THIS("d");

		code.LINE();
		code.LOAD("this");
		code.LOAD("str");
		code.PUTFIELD_OF_THIS("str");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getB(ClassBody classBody) {
		MethodCode code = classBody.method(byte.class, "getB").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.RETURNTop();

		code.END();
	}

	protected void _getC(ClassBody classBody) {
		MethodCode code = classBody.method(char.class, "getC").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("c");
		code.RETURNTop();

		code.END();
	}

	protected void _getS(ClassBody classBody) {
		MethodCode code = classBody.method(short.class, "getS").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("s");
		code.RETURNTop();

		code.END();
	}

	protected void _getI(ClassBody classBody) {
		MethodCode code = classBody.method(int.class, "getI").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i");
		code.RETURNTop();

		code.END();
	}

	protected void _getL(ClassBody classBody) {
		MethodCode code = classBody.method(long.class, "getL").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("l");
		code.RETURNTop();

		code.END();
	}

	protected void _getF(ClassBody classBody) {
		MethodCode code = classBody.method(float.class, "getF").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("f");
		code.RETURNTop();

		code.END();
	}

	protected void _getD(ClassBody classBody) {
		MethodCode code = classBody.method(double.class, "getD").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("d");
		code.RETURNTop();

		code.END();
	}

	protected void _getStr(ClassBody classBody) {
		MethodCode code = classBody.method(String.class, "getStr").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("str");
		code.RETURNTop();

		code.END();
	}

	protected void _toString(ClassBody classBody) {
		MethodCode code = classBody.method(String.class, "toString").begin();

		code.LINE();
		code.NEW(StringBuilder.class);
		code.DUP();
		code.SPECIAL(StringBuilder.class, "<init>").INVOKE();
		code.STORE("builder",StringBuilder.class);

		code.LINE();
		code.LOAD("builder");
		code.LOADConst("MakeReadOnlyPojo [b=");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(int.class).INVOKE();

		code.LINE();
		code.LOADConst(", c=");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("c");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(char.class).INVOKE();

		code.LINE();
		code.LOADConst(", s=");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("s");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(int.class).INVOKE();

		code.LINE();
		code.LOADConst(", i=");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(int.class).INVOKE();

		code.LINE();
		code.LOADConst(", l=");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("l");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(long.class).INVOKE();

		code.LINE();
		code.LOADConst(", f=");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("f");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(float.class).INVOKE();

		code.LINE();
		code.LOADConst(", d=");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("d");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(double.class).INVOKE();

		code.LINE();
		code.LOADConst(", str=");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("str");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();

		code.LINE();
		code.LOADConst("]");
		code.VIRTUAL(StringBuilder.class, "append")
			.reTurn(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.POP();

		code.LINE();
		code.LOAD("builder");
		code.VIRTUAL(StringBuilder.class, "toString")
			.reTurn(String.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

}
