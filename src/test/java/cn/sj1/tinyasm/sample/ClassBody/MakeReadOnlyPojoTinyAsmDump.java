package cn.sj1.tinyasm.sample.ClassBody;
import org.objectweb.asm.Label;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import cn.sj1.tinyasm.ClassBody;
import cn.sj1.tinyasm.ClassBuilder;
import cn.sj1.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cn.sj1.tinyasm.Annotation;
import cn.sj1.tinyasm.Clazz;
import java.lang.Object;
import java.lang.StringBuilder;
import java.lang.String;
@SuppressWarnings("unused")
public class MakeReadOnlyPojoTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new MakeReadOnlyPojoTinyAsmDump().dump("cn.sj1.tinyasm.sample.ClassBody.MakeReadOnlyPojo");
	}

	public byte[] dump(String className) throws Exception {
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
		MethodCode code = classBody.public_().method("<init>")
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
		MethodCode code = classBody.public_().method("getB")
			.return_(byte.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.RETURNTop();

		code.END();
	}

	protected void _getC(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getC")
			.return_(char.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("c");
		code.RETURNTop();

		code.END();
	}

	protected void _getS(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getS")
			.return_(short.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("s");
		code.RETURNTop();

		code.END();
	}

	protected void _getI(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getI")
			.return_(int.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i");
		code.RETURNTop();

		code.END();
	}

	protected void _getL(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getL")
			.return_(long.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("l");
		code.RETURNTop();

		code.END();
	}

	protected void _getF(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getF")
			.return_(float.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("f");
		code.RETURNTop();

		code.END();
	}

	protected void _getD(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getD")
			.return_(double.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("d");
		code.RETURNTop();

		code.END();
	}

	protected void _getStr(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getStr")
			.return_(String.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("str");
		code.RETURNTop();

		code.END();
	}

	protected void _toString(ClassBody classBody) {
		MethodCode code = classBody.public_().method("toString")
			.return_(String.class ).begin();

		code.LINE();
		code.NEW(StringBuilder.class);
		code.DUP();
		code.SPECIAL(StringBuilder.class, "<init>").INVOKE();
		code.STORE("builder",StringBuilder.class);

		code.LINE();
		code.LOAD("builder");
		code.LOADConst("MakeReadOnlyPojo [b=");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("b");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(int.class).INVOKE();
		code.LOADConst(", c=");

		code.LINE();
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("c");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(char.class).INVOKE();
		code.LOADConst(", s=");

		code.LINE();
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("s");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(int.class).INVOKE();
		code.LOADConst(", i=");

		code.LINE();
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(int.class).INVOKE();
		code.LOADConst(", l=");

		code.LINE();
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("l");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(long.class).INVOKE();
		code.LOADConst(", f=");

		code.LINE();
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("f");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(float.class).INVOKE();
		code.LOADConst(", d=");

		code.LINE();
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("d");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(double.class).INVOKE();
		code.LOADConst(", str=");

		code.LINE();
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("str");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOADConst("]");

		code.LINE();
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.POP();

		code.LINE();
		code.LOAD("builder");
		code.VIRTUAL(StringBuilder.class, "toString")
			.return_(String.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

}
