package cc1sj.tinyasm.util;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
@SuppressWarnings("unused")
public class SignatureGenericSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("cc1sj.tinyasm.util.SignatureGenericSample", Clazz.of(java.util.HashMap.class,Clazz.typeVariableOf("S"),Clazz.typeVariableOf("D")),Clazz.of(java.io.Serializable.class)).formalTypeParameter("S",Clazz.of(java.lang.Object.class)).formalTypeParameter("D",Clazz.of(java.lang.Object.class)).access(ACC_PUBLIC | ACC_SUPER).body();

classWriter.field(0, "mapStrngStringArray",Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String[].class)));
classWriter.field(0, "mapStrngString",Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String.class)));
classWriter.field(0, "hashMapStringMapStringStringArray",Clazz.of(java.util.HashMap.class,Clazz.of(java.lang.String.class),Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String[].class))));
classWriter.method("<init>").code(code -> {

	code.LINE(7);
	code.LOAD("this");
	code.SPECIAL(java.util.HashMap.class, "<init>").INVOKE();
	code.RETURN();
});
classWriter.method(0, Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String.class)), "mapStrngString")
	.parameter("mapStrngString",Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String.class)))
	.parameter("mapStrngString2",Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String.class))).code(code -> {

	code.LINE(22);
	code.LOADConstNULL();
	code.RETURNTop();
});
return classWriter.end().toByteArray();
}
}
