package cc1sj.tinyasm.util;
import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_INTERFACE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

import java.io.Serializable;
import java.util.Map;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.MethodCode;
@SuppressWarnings("unused")
public class SignatureInterfaceSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new SignatureInterfaceSampleTinyAsmDump().dump("cc1sj.tinyasm.util.SignatureInterfaceSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className, Clazz.of(Object.class),Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String[].class))),Clazz.of(Serializable.class))
			.access(ACC_PUBLIC | ACC_ABSTRACT | ACC_INTERFACE).body();

		_mapStrngString(classBody);

		return classBody.end().toByteArray();
	}

	protected void _mapStrngString(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC | ACC_ABSTRACT, "mapStrngString")
			.return_(Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String.class)) )
			.parameter("var1",Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String.class)))
			.parameter("var2",Clazz.of(Map.class,Clazz.of(String.class),Clazz.of(String.class))).begin();

		code.END();
	}

}
