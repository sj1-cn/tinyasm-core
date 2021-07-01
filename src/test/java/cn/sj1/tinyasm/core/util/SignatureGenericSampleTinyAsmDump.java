package cn.sj1.tinyasm.core.util;

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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class SignatureGenericSampleTinyAsmDump {

	public static byte[] dump() {
		return new SignatureGenericSampleTinyAsmDump().build("cn.sj1.tinyasm.core.util.SignatureGenericSample");
	}

	public byte[] build(String className)  {
		ClassBody classBody = ClassBuilder.class_(className, Clazz.of(HashMap.class, Clazz.typeArgument(Clazz.typeVariableOf("S")), Clazz.typeArgument(Clazz.typeVariableOf("D"))),Clazz.of(Serializable.class)).formalTypeParameter("S", Clazz.of(Object.class)).formalTypeParameter("D", Clazz.of(Object.class)).body();

		classBody.field("mapStrngStringArray", Clazz.of(Map.class, Clazz.of(String.class), Clazz.of(String[].class)));
		classBody.field("mapStrngString", Clazz.of(Map.class, Clazz.of(String.class), Clazz.of(String.class)));
		classBody.field("hashMapStringMapStringStringArray", Clazz.of(HashMap.class, Clazz.of(String.class), Clazz.of(Map.class, Clazz.of(String.class), Clazz.of(String[].class))));
		__init_(classBody);
		_mapStrngString(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HashMap.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _mapStrngString(ClassBody classBody) {
		MethodCode code = classBody.method("mapStrngString")
				.return_(Clazz.of(Map.class, Clazz.of(String.class), Clazz.of(String.class)))
				.parameter("mapStrngString", Clazz.of(Map.class, Clazz.of(String.class), Clazz.of(String.class)))
				.parameter("mapStrngString2", Clazz.of(Map.class, Clazz.of(String.class), Clazz.of(String.class))).begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

}
