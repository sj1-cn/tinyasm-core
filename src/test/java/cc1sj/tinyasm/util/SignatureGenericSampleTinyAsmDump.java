package cc1sj.tinyasm.util;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.util.HashMap;
@SuppressWarnings("unused")
public class SignatureGenericSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new SignatureGenericSampleTinyAsmDump().__dump__("cc1sj.tinyasm.util.SignatureGenericSample");
	}

	public byte[] __dump__(String className) throws Exception {
ClassBody classBody = ClassBuilder.make("cc1sj.tinyasm.util.SignatureGenericSample", Clazz.of(java.util.HashMap.class,Clazz.typeVariableOf("S"),Clazz.typeVariableOf("D")),Clazz.of(java.io.Serializable.class)).formalTypeParameter("S",Clazz.of(java.lang.Object.class)).formalTypeParameter("D",Clazz.of(java.lang.Object.class)).access(ACC_PUBLIC | ACC_SUPER).body();

classBody.field(0, "mapStrngStringArray",Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String[].class)));
classBody.field(0, "mapStrngString",Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String.class)));
classBody.field(0, "hashMapStringMapStringStringArray",Clazz.of(java.util.HashMap.class,Clazz.of(java.lang.String.class),Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String[].class))));
		__init_(classBody);
		_mapStrngString(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method("<init>").begin();

		code.LINE(7);
		code.LOAD("this");
		code.SPECIAL(HashMap.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _mapStrngString(ClassBody classBody) {
		MethodCode code = classBody.method(0, Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String.class)), "mapStrngString")
		.parameter("mapStrngString",Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String.class)))
		.parameter("mapStrngString2",Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String.class))).begin();

		code.LINE(22);
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

}
