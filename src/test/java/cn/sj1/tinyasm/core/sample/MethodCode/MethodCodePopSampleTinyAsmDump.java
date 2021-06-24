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
public class MethodCodePopSampleTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new MethodCodePopSampleTinyAsmDump().build("cn.sj1.tinyasm.core.sample.MethodCode.MethodCodePopSample");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
				.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_getAll(classBody);
		_returnBoolean(classBody);
		_returnByte(classBody);
		_returnChar(classBody);
		_returnShort(classBody);
		_returnInt(classBody);
		_returnLong(classBody);
		_returnFloat(classBody);
		_returnDouble(classBody);
		_returnString(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _getAll(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAll").begin();

		code.LINE();
		code.LOAD("this");
		code.VIRTUAL("returnBoolean")
				.return_(boolean.class).INVOKE();
		code.POP();

		code.LINE();
		code.LOAD("this");
		code.VIRTUAL("returnByte")
				.return_(byte.class).INVOKE();
		code.POP();

		code.LINE();
		code.LOAD("this");
		code.VIRTUAL("returnChar")
				.return_(char.class).INVOKE();
		code.POP();

		code.LINE();
		code.LOAD("this");
		code.VIRTUAL("returnShort")
				.return_(short.class).INVOKE();
		code.POP();

		code.LINE();
		code.LOAD("this");
		code.VIRTUAL("returnInt")
				.return_(int.class).INVOKE();
		code.POP();

		code.LINE();
		code.LOAD("this");
		code.VIRTUAL("returnLong")
				.return_(long.class).INVOKE();
		code.POP();

		code.LINE();
		code.LOAD("this");
		code.VIRTUAL("returnFloat")
				.return_(float.class).INVOKE();
		code.POP();

		code.LINE();
		code.LOAD("this");
		code.VIRTUAL("returnDouble")
				.return_(double.class).INVOKE();
		code.POP();

		code.LINE();
		code.LOAD("this");
		code.VIRTUAL("returnString")
				.return_(String.class).INVOKE();
		code.POP();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _returnBoolean(ClassBody classBody) {
		MethodCode code = classBody.method("returnBoolean")
				.return_(boolean.class).begin();

		code.LINE();
		code.LOADConst(1);
		code.RETURNTop();

		code.END();
	}

	protected void _returnByte(ClassBody classBody) {
		MethodCode code = classBody.method("returnByte")
				.return_(byte.class).begin();

		code.LINE();
		code.LOADConst(10);
		code.RETURNTop();

		code.END();
	}

	protected void _returnChar(ClassBody classBody) {
		MethodCode code = classBody.method("returnChar")
				.return_(char.class).begin();

		code.LINE();
		code.LOADConst(10);
		code.RETURNTop();

		code.END();
	}

	protected void _returnShort(ClassBody classBody) {
		MethodCode code = classBody.method("returnShort")
				.return_(short.class).begin();

		code.LINE();
		code.LOADConst(10);
		code.RETURNTop();

		code.END();
	}

	protected void _returnInt(ClassBody classBody) {
		MethodCode code = classBody.method("returnInt")
				.return_(int.class).begin();

		code.LINE();
		code.LOADConst(10);
		code.RETURNTop();

		code.END();
	}

	protected void _returnLong(ClassBody classBody) {
		MethodCode code = classBody.method("returnLong")
				.return_(long.class).begin();

		code.LINE();
		code.LOADConst(Long.valueOf(10L));
		code.RETURNTop();

		code.END();
	}

	protected void _returnFloat(ClassBody classBody) {
		MethodCode code = classBody.method("returnFloat")
				.return_(float.class).begin();

		code.LINE();
		code.LOADConst(Float.valueOf("10.0"));
		code.RETURNTop();

		code.END();
	}

	protected void _returnDouble(ClassBody classBody) {
		MethodCode code = classBody.method("returnDouble")
				.return_(double.class).begin();

		code.LINE();
		code.LOADConst(Double.valueOf("10.0"));
		code.RETURNTop();

		code.END();
	}

	protected void _returnString(ClassBody classBody) {
		MethodCode code = classBody.method("returnString")
				.return_(String.class).begin();

		code.LINE();
		code.LOADConst("10");
		code.RETURNTop();

		code.END();
	}

}
