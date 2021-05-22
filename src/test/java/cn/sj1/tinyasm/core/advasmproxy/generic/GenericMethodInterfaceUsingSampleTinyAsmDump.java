package cn.sj1.tinyasm.core.advasmproxy.generic;
import org.objectweb.asm.Label;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import cn.sj1.tinyasm.core.ClassBody;
import cn.sj1.tinyasm.core.ClassBuilder;
import cn.sj1.tinyasm.core.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cn.sj1.tinyasm.core.Annotation;
import cn.sj1.tinyasm.core.Clazz;
import cn.sj1.tinyasm.core.advasmproxy.generic.GenericMethodInterface;
import java.lang.Object;
import cn.sj1.tinyasm.core.advasmproxy.simple.PojoClass;
import java.lang.Integer;
@SuppressWarnings("unused")
public class GenericMethodInterfaceUsingSampleTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new GenericMethodInterfaceUsingSampleTinyAsmDump().build("cn.sj1.tinyasm.core.advasmproxy.generic.GenericMethodInterfaceUsingSample");
	}

	public byte[] build(String className) throws Exception {
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
