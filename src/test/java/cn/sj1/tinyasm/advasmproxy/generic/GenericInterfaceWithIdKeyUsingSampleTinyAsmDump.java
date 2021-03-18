package cn.sj1.tinyasm.advasmproxy.generic;
import org.objectweb.asm.Label;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import cn.sj1.tinyasm.ClassBody;
import cn.sj1.tinyasm.ClassBuilder;
import cn.sj1.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cn.sj1.tinyasm.Annotation;
import cn.sj1.tinyasm.Clazz;
import cn.sj1.tinyasm.advasmproxy.generic.PojoClassWithIdKey;
import cn.sj1.tinyasm.advasmproxy.generic.GenericClassWithIdKey;
import cn.sj1.tinyasm.advmagicbuilder.WithIdKey;
import cn.sj1.tinyasm.advasmproxy.generic.GenericInterfaceWithIdKey;
import java.lang.Object;
@SuppressWarnings("unused")
public class GenericInterfaceWithIdKeyUsingSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new GenericInterfaceWithIdKeyUsingSampleTinyAsmDump().dump("cn.sj1.tinyasm.advasmproxy.generic.GenericInterfaceWithIdKeyUsingSample");
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
		code.NEW(GenericClassWithIdKey.class);
		code.DUP();
		code.SPECIAL(GenericClassWithIdKey.class, "<init>").INVOKE();
		code.STORE("pp",Clazz.of(GenericInterfaceWithIdKey.class,Clazz.of(PojoClassWithIdKey.class)));

		code.LINE();
		code.NEW(PojoClassWithIdKey.class);
		code.DUP();
		code.SPECIAL(PojoClassWithIdKey.class, "<init>").INVOKE();
		code.STORE("pojoClassSample",PojoClassWithIdKey.class);

		code.LINE();
		code.LOAD("pp");
		code.LOAD("pojoClassSample");
		code.INTERFACE(GenericInterfaceWithIdKey.class, "setT")
			.parameter(WithIdKey.class).INVOKE();

		code.LINE();
		code.LOAD("pp");
		code.INTERFACE(GenericInterfaceWithIdKey.class, "getT")
			.return_(WithIdKey.class).INVOKE();
		code.CHECKCAST(PojoClassWithIdKey.class);
		code.STORE("pojoClassSample2",PojoClassWithIdKey.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
