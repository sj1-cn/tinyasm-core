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
import cc1sj.tinyasm.hero.helperclass.GenericInterface;
import cc1sj.tinyasm.hero.helperclass.GenericClass;
import java.lang.Object;
import cc1sj.tinyasm.hero.helperclass.PojoClassSample;
@SuppressWarnings("unused")
public class UsingGenericClassTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new UsingGenericClassTinyAsmDump().dump("cc1sj.tinyasm.hero.helperclass.UsingGenericClass");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_say(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _say(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("say").begin();

		code.LINE();
		code.NEW(GenericClass.class);
		code.DUP();
		code.SPECIAL(GenericClass.class, "<init>").INVOKE();
		code.STORE("pp",Clazz.of(GenericInterface.class,Clazz.of(PojoClassSample.class)));

		code.LINE();
		code.NEW(PojoClassSample.class);
		code.DUP();
		code.SPECIAL(PojoClassSample.class, "<init>").INVOKE();
		code.STORE("pojoClassSample",PojoClassSample.class);

		code.LINE();
		code.LOAD("pp");
		code.LOAD("pojoClassSample");
		code.INTERFACE(GenericInterface.class, "setT")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("pp");
		code.INTERFACE(GenericInterface.class, "getT")
			.reTurn(Object.class).INVOKE();
		code.CHECKCAST(PojoClassSample.class);
		code.STORE("pojoClassSample2",PojoClassSample.class);

		code.LINE();
		code.LOAD("pojoClassSample2");
		code.LOADConst(0);
		code.VIRTUAL(PojoClassSample.class, "setAgeBoolean")
			.parameter(boolean.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
