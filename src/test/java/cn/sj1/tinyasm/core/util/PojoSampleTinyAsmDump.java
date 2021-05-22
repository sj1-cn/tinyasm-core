package cn.sj1.tinyasm.core.util;
import org.objectweb.asm.Label;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import cn.sj1.tinyasm.core.ClassBody;
import cn.sj1.tinyasm.core.ClassBuilder;
import cn.sj1.tinyasm.core.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cn.sj1.tinyasm.core.Annotation;
import cn.sj1.tinyasm.core.Clazz;
import java.lang.Object;
import java.lang.StringBuilder;
import java.lang.String;
@SuppressWarnings("unused")
public class PojoSampleTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new PojoSampleTinyAsmDump().build("cn.sj1.tinyasm.core.util.PojoSample");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.private_().field("i1", Clazz.of(int.class));
		classBody.private_().field("i2", Clazz.of(int.class));
		classBody.private_().field("i3", Clazz.of(int.class));
		classBody.private_().field("i4", Clazz.of(int.class));
		classBody.private_().field("str", Clazz.of(String.class));
		__init_(classBody);
		_getI1(classBody);
		_setI1(classBody);
		_getI2(classBody);
		_setI2(classBody);
		_getI3(classBody);
		_setI3(classBody);
		_getI4(classBody);
		_setI4(classBody);
		_getStr(classBody);
		_setStr(classBody);
		_toString(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>")
			.parameter("i1",int.class)
			.parameter("i2",int.class)
			.parameter("i3",int.class)
			.parameter("i4",int.class)
			.parameter("str",String.class).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();

		code.LINE();
		code.LOAD("this");
		code.LOAD("i1");
		code.PUTFIELD_OF_THIS("i1");

		code.LINE();
		code.LOAD("this");
		code.LOAD("i2");
		code.PUTFIELD_OF_THIS("i2");

		code.LINE();
		code.LOAD("this");
		code.LOAD("i3");
		code.PUTFIELD_OF_THIS("i3");

		code.LINE();
		code.LOAD("this");
		code.LOAD("i4");
		code.PUTFIELD_OF_THIS("i4");

		code.LINE();
		code.LOAD("this");
		code.LOAD("str");
		code.PUTFIELD_OF_THIS("str");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getI1(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getI1")
			.return_(int.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i1");
		code.RETURNTop();

		code.END();
	}

	protected void _setI1(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setI1")
			.parameter("i1",int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("i1");
		code.PUTFIELD_OF_THIS("i1");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getI2(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getI2")
			.return_(int.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i2");
		code.RETURNTop();

		code.END();
	}

	protected void _setI2(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setI2")
			.parameter("i2",int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("i2");
		code.PUTFIELD_OF_THIS("i2");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getI3(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getI3")
			.return_(int.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i3");
		code.RETURNTop();

		code.END();
	}

	protected void _setI3(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setI3")
			.parameter("i3",int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("i3");
		code.PUTFIELD_OF_THIS("i3");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getI4(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getI4")
			.return_(int.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i4");
		code.RETURNTop();

		code.END();
	}

	protected void _setI4(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setI4")
			.parameter("i4",int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("i4");
		code.PUTFIELD_OF_THIS("i4");

		code.LINE();
		code.RETURN();

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

	protected void _setStr(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setStr")
			.parameter("str",String.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("str");
		code.PUTFIELD_OF_THIS("str");

		code.LINE();
		code.RETURN();

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
		code.LOADConst("Pojo [i1=");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i1");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(int.class).INVOKE();
		code.LOADConst(", i2=");

		code.LINE();
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i2");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(int.class).INVOKE();
		code.LOADConst(", i3=");

		code.LINE();
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i3");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(int.class).INVOKE();
		code.LOADConst(", i4=");

		code.LINE();
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("i4");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(int.class).INVOKE();
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
