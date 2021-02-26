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
public class SignatureInterfaceSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new SignatureInterfaceSampleTinyAsmDump().__dump__("cc1sj.tinyasm.util.SignatureInterfaceSample");
	}

	public byte[] __dump__(String className) throws Exception {
ClassBody classBody = ClassBuilder.make("cc1sj.tinyasm.util.SignatureInterfaceSample", Clazz.of(java.lang.Object.class),Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String[].class))),Clazz.of(java.io.Serializable.class)).access(ACC_PUBLIC | ACC_ABSTRACT | ACC_INTERFACE).body();

		_mapStrngString(classBody);

		return classBody.end().toByteArray();
	}

	protected void _mapStrngString(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC | ACC_ABSTRACT, Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String.class)), "mapStrngString")
		.parameter("var1",Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String.class)))
		.parameter("var2",Clazz.of(java.util.Map.class,Clazz.of(java.lang.String.class),Clazz.of(java.lang.String.class))).begin();

		code.END();
	}

}
