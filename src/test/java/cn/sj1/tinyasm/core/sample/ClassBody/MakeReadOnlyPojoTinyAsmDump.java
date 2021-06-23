package cn.sj1.tinyasm.core.sample.ClassBody;
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
public class MakeReadOnlyPojoTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new MakeReadOnlyPojoTinyAsmDump().build("cn.sj1.tinyasm.core.sample.ClassBody.MakeReadOnlyPojo");
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
		code.PUTFIELD("b", byte.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("c");
		code.PUTFIELD("c", char.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("s");
		code.PUTFIELD("s", short.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("i");
		code.PUTFIELD("i", int.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("l");
		code.PUTFIELD("l", long.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("f");
		code.PUTFIELD("f", float.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("d");
		code.PUTFIELD("d", double.class);

		code.LINE();
		code.LOAD("this");
		code.LOAD("str");
		code.PUTFIELD("str", String.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getB(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getB")
			.return_(byte.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("b", byte.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getC(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getC")
			.return_(char.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("c", char.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getS(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getS")
			.return_(short.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("s", short.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getI(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getI")
			.return_(int.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("i", int.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getL(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getL")
			.return_(long.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("l", long.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getF(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getF")
			.return_(float.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("f", float.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getD(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getD")
			.return_(double.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("d", double.class);
		code.RETURNTop();

		code.END();
	}

	protected void _getStr(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getStr")
			.return_(String.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD("str", String.class);
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
		code.GETFIELD("b", byte.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(int.class).INVOKE();

		code.LINE();
		code.LOADConst(", c=");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("c", char.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(char.class).INVOKE();

		code.LINE();
		code.LOADConst(", s=");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("s", short.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(int.class).INVOKE();

		code.LINE();
		code.LOADConst(", i=");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("i", int.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(int.class).INVOKE();

		code.LINE();
		code.LOADConst(", l=");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("l", long.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(long.class).INVOKE();

		code.LINE();
		code.LOADConst(", f=");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("f", float.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(float.class).INVOKE();

		code.LINE();
		code.LOADConst(", d=");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("d", double.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(double.class).INVOKE();

		code.LINE();
		code.LOADConst(", str=");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD("str", String.class);
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();

		code.LINE();
		code.LOADConst("]");
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
