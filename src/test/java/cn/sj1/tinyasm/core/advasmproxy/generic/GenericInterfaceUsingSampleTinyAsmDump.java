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
import cn.sj1.tinyasm.core.advasmproxy.generic.GenericInterface;
import java.lang.Object;
import cn.sj1.tinyasm.core.advasmproxy.generic.GenericClass;
import cn.sj1.tinyasm.core.advasmproxy.simple.PojoClass;
@SuppressWarnings("unused")
public class GenericInterfaceUsingSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new GenericInterfaceUsingSampleTinyAsmDump().dump("cn.sj1.tinyasm.core.advasmproxy.generic.GenericInterfaceUsingSample");
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
		MethodCode code = classBody.public_().method("say").begin();

		code.LINE();
		code.NEW(GenericClass.class);
		code.DUP();
		code.SPECIAL(GenericClass.class, "<init>").INVOKE();
		code.STORE("pp",Clazz.of(GenericInterface.class,Clazz.of(PojoClass.class)));

		code.LINE();
		code.NEW(PojoClass.class);
		code.DUP();
		code.SPECIAL(PojoClass.class, "<init>").INVOKE();
		code.STORE("pojoClassSample",PojoClass.class);

		code.LINE();
		code.LOAD("pp");
		code.LOAD("pojoClassSample");
		code.INTERFACE(GenericInterface.class, "setT")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("pp");
		code.INTERFACE(GenericInterface.class, "getT")
			.return_(Object.class).INVOKE();
		code.CHECKCAST(PojoClass.class);
		code.STORE("pojoClassSample2",PojoClass.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
