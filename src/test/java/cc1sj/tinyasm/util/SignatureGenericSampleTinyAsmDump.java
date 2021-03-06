package cc1sj.tinyasm.util;
import org.objectweb.asm.Label;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.util.SignatureGenericSample;
import java.util.Map;
import java.lang.Object;
import java.util.HashMap;
import java.lang.String;
import java.io.Serializable;
@SuppressWarnings("unused")
public class SignatureGenericSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new SignatureGenericSampleTinyAsmDump().dump("cc1sj.tinyasm.util.SignatureGenericSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className, Clazz.of(HashMap.class,Clazz.typeVariableOf("S"),Clazz.typeVariableOf("D")),Clazz.of(Serializable.class)).formalTypeParameter("S",Clazz.of(Object.class)).formalTypeParameter("D",Clazz.of(Object.class))
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.field(0, "mapStrngStringArray",Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String[].class)));
		classBody.field(0, "mapStrngString",Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String.class)));
		classBody.field(0, "hashMapStringMapStringStringArray",Clazz.of(HashMap.class,Clazz.of(String.class),Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String[].class))));
		__init_(classBody);
		_mapStrngString(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HashMap.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _mapStrngString(ClassBody classBody) {
		MethodCode code = classBody.method(Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String.class)), "mapStrngString")
			.parameter("mapStrngString",Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String.class)))
			.parameter("mapStrngString2",Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String.class))).begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

}
