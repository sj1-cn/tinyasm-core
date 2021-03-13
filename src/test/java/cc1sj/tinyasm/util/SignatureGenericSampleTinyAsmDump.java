package cc1sj.tinyasm.util;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.MethodCode;
@SuppressWarnings("unused")
public class SignatureGenericSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new SignatureGenericSampleTinyAsmDump().dump("cc1sj.tinyasm.util.SignatureGenericSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className, Clazz.of(HashMap.class,Clazz.typeArgument(Clazz.typeVariableOf("S")),Clazz.typeArgument(Clazz.typeVariableOf("D"))),Clazz.of(Serializable.class)).formalTypeParameter("S",Clazz.of(Object.class)).formalTypeParameter("D",Clazz.of(Object.class))
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.field("mapStrngStringArray",Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String[].class)));
		classBody.field("mapStrngString",Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String.class)));
		classBody.field("hashMapStringMapStringStringArray",Clazz.of(HashMap.class,Clazz.of(String.class),Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String[].class))));
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
			.return_(Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String.class)) )
			.parameter("mapStrngString",Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String.class)))
			.parameter("mapStrngString2",Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String.class))).begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

}
