package cn.sj1.tinyasm.core.advasmproxy.generic;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import cn.sj1.tinyasm.core.ClassBody;
import cn.sj1.tinyasm.core.ClassBuilder;
import cn.sj1.tinyasm.core.Clazz;
import cn.sj1.tinyasm.core.MethodCode;
import cn.sj1.tinyasm.core.advasmproxy.simple.PojoClass;
@SuppressWarnings("unused")
public class GenericMethodInterfaceSample_UsingTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new GenericMethodInterfaceSample_UsingTinyAsmDump().dump("cc1sj.tinyasm.advasmproxy.generic.GenericMethodInterfaceSample_Using");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_say(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _say(ClassBody classBody) {
		MethodCode code = classBody.public_().method("say")
			.return_(Clazz.of(void.class) )
			.parameter("pp",Clazz.of(GenericMethodInterface.class,Clazz.of(PojoClass.class))).begin();

		code.LINE();
		code.LOADConst(1);
		code.NEWARRAY(Integer.class);
		code.STORE("iarray",Integer[].class);

		code.LINE();
		code.LOAD("pp");
		code.LOAD("iarray");
		code.INTERFACE(GenericMethodInterface.class, "arrayToArray")
			.return_(Object[].class)
			.parameter(Object[].class).INVOKE();
		code.CHECKCAST(Integer[].class);
		code.STORE("warray",Integer[].class);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
