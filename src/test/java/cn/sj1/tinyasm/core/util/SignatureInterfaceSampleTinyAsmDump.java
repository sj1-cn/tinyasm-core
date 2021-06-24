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
import java.util.Map;

@SuppressWarnings("unused")
public class SignatureInterfaceSampleTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new SignatureInterfaceSampleTinyAsmDump().build("cn.sj1.tinyasm.core.util.SignatureInterfaceSample");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className, Clazz.of(Object.class),Clazz.of(Map.class, Clazz.of(String.class), Clazz.of(Map.class, Clazz.of(String.class), Clazz.of(String[].class))),Clazz.of(Serializable.class))
				.access(ACC_PUBLIC | ACC_ABSTRACT | ACC_INTERFACE).body();

		_mapStrngString(classBody);

		return classBody.end().toByteArray();
	}

	protected void _mapStrngString(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC | ACC_ABSTRACT, "mapStrngString")
				.return_(Clazz.of(Map.class, Clazz.of(String.class), Clazz.of(String.class)))
				.parameter("mapStrngString", Clazz.of(Map.class, Clazz.of(String.class), Clazz.of(String.class)))
				.parameter("mapStrngString2", Clazz.of(Map.class, Clazz.of(String.class), Clazz.of(String.class))).begin();

		code.END();
	}

}
