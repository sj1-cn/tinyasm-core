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
import java.util.Map;
import java.lang.Object;
import java.lang.String;
import java.io.Serializable;
@SuppressWarnings("unused")
public class SignatureInterfaceSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new SignatureInterfaceSampleTinyAsmDump().dump("cc1sj.tinyasm.util.SignatureInterfaceSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className, Clazz.of(Object.class),Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String[].class))),Clazz.of(Serializable.class))
			.access(ACC_PUBLIC | ACC_ABSTRACT | ACC_INTERFACE).body();

		_mapStrngString(classBody);

		return classBody.end().toByteArray();
	}

	protected void _mapStrngString(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC | ACC_ABSTRACT, Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String.class)), "mapStrngString")
			.parameter("var1",Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String.class)))
			.parameter("var2",Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String.class))).begin();

		code.END();
	}

}
