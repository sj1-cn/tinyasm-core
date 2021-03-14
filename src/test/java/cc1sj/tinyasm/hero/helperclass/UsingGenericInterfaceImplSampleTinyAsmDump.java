package cc1sj.tinyasm.hero.helperclass;
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
import cc1sj.tinyasm.hero.helperclass.PojoClassChildSample;
import cc1sj.tinyasm.hero.helperclass.GenericInterfaceImplSample;
import java.lang.Object;
import cc1sj.tinyasm.hero.helperclass.PojoClassSample;
@SuppressWarnings("unused")
public class UsingGenericInterfaceImplSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new UsingGenericInterfaceImplSampleTinyAsmDump().dump("cc1sj.tinyasm.hero.helperclass.UsingGenericInterfaceImplSample");
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
		code.NEW(GenericInterfaceImplSample.class);
		code.DUP();
		code.SPECIAL(GenericInterfaceImplSample.class, "<init>").INVOKE();
		code.STORE("pp",GenericInterfaceImplSample.class);

		code.LINE();
		code.NEW(PojoClassSample.class);
		code.DUP();
		code.SPECIAL(PojoClassSample.class, "<init>").INVOKE();
		code.STORE("pojoClassSample",PojoClassSample.class);

		code.LINE();
		code.LOAD("pp");
		code.LOAD("pojoClassSample");
		code.VIRTUAL(GenericInterfaceImplSample.class, "setT")
			.parameter(PojoClassSample.class).INVOKE();

		code.LINE();
		code.LOAD("pp");
		code.VIRTUAL(GenericInterfaceImplSample.class, "getT")
			.return_(PojoClassSample.class).INVOKE();
		code.STORE("pojoClassSample2",PojoClassSample.class);

		code.LINE();
		code.LOAD("pojoClassSample2");
		code.LOADConst(0);
		code.VIRTUAL(PojoClassSample.class, "setAgeBoolean")
			.parameter(boolean.class).INVOKE();

		code.LINE();
		code.LOAD("pp");
		code.VIRTUAL(GenericInterfaceImplSample.class, "getPojoClassChildSample")
			.return_(PojoClassChildSample.class).INVOKE();
		code.STORE("pojoClassChildSample",PojoClassChildSample.class);

		code.LINE();
		code.LOAD("pp");
		code.LOAD("pojoClassChildSample");
		code.VIRTUAL(GenericInterfaceImplSample.class, "setPojoClassChildSample")
			.parameter(PojoClassChildSample.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
