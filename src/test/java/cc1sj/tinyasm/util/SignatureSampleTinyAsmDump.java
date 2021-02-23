package cc1sj.tinyasm.util;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.Clazz;
@SuppressWarnings("unused")
public class SignatureSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("cc1sj.tinyasm.util.SignatureSample", Clazz.of(java.util.HashMap.class,Clazz.of(java.lang.String.class),Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String[].class))),Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String[].class))),Clazz.of(java.io.Serializable.class)).access(ACC_PUBLIC | ACC_SUPER).body();

classWriter.field(0, "mapStrngStringArray",Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String[].class)));
classWriter.field(0, "mapStrngString",Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String.class)));
classWriter.field(0, "hashMapStringMapStringStringArray",Clazz.of(java.util.HashMap.class,Clazz.of(java.lang.String.class),Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String[].class))));
classWriter.method(ACC_PUBLIC, "<init>").code(code -> {

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
