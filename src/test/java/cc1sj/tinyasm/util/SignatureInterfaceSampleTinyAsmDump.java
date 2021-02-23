package cc1sj.tinyasm.util;
import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_INTERFACE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.Clazz;
@SuppressWarnings("unused")
public class SignatureInterfaceSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("cc1sj.tinyasm.util.SignatureInterfaceSample", Clazz.of(java.lang.Object.class),Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String[].class))),Clazz.of(java.io.Serializable.class)).access(ACC_PUBLIC | ACC_ABSTRACT | ACC_INTERFACE).body();

classWriter.method(ACC_PUBLIC | ACC_ABSTRACT, Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String.class)), "mapStrngString")
	.parameter("var1",Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String.class)))
	.parameter("var2",Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String.class))).code(code -> {
});
return classWriter.end().toByteArray();
}
}
