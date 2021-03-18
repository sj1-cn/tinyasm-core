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
import cn.sj1.tinyasm.core.advasmproxy.generic.GenericClassWithIdKey;
import cn.sj1.tinyasm.core.advmagicbuilder.WithIdKey;
import cn.sj1.tinyasm.core.advasmproxy.generic.PojoClassWithIdKey;
import java.lang.Object;
@SuppressWarnings("unused")
public class GenericClassWithIdKeyUsingSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new GenericClassWithIdKeyUsingSampleTinyAsmDump().dump("cn.sj1.tinyasm.core.advasmproxy.generic.GenericClassWithIdKeyUsingSample");
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
		code.STORE("pp",Clazz.of(GenericClassWithIdKey.class,Clazz.of(PojoClassWithIdKey.class)));

		code.LINE();
		code.NEW(PojoClassWithIdKey.class);
		code.DUP();
		code.SPECIAL(PojoClassWithIdKey.class, "<init>").INVOKE();
		code.STORE("pojoClassSample",PojoClassWithIdKey.class);

		code.LINE();
		code.LOAD("pp");
		code.LOAD("pojoClassSample");
		code.VIRTUAL(GenericClassWithIdKey.class, "setT")
			.parameter(WithIdKey.class).INVOKE();

		code.LINE();
		code.LOAD("pp");
		code.VIRTUAL(GenericClassWithIdKey.class, "getT")
			.return_(WithIdKey.class).INVOKE();
		code.CHECKCAST(PojoClassWithIdKey.class);
		code.STORE("pojoClassSample2",PojoClassWithIdKey.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
