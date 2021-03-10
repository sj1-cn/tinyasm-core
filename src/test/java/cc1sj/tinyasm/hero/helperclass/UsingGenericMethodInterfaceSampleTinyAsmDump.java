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
import cc1sj.tinyasm.hero.helperclass.GenericMethodInterface;
import java.lang.Object;
import cc1sj.tinyasm.hero.helperclass.PojoClassSample;
import java.lang.Integer;
@SuppressWarnings("unused")
public class UsingGenericMethodInterfaceSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new UsingGenericMethodInterfaceSampleTinyAsmDump().dump("cc1sj.tinyasm.hero.helperclass.UsingGenericMethodInterfaceSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className)
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
		MethodCode code = classBody.publicMethod("say")
			.reTurn(Clazz.of(void.class) )
			.parameter("pp",Clazz.of(GenericMethodInterface.class,Clazz.of(PojoClassSample.class))).begin();

		code.LINE();
		code.LOADConst(1);
		code.NEWARRAY(Integer.class);
		code.STORE("iarray",Integer[].class);

		code.LINE();
		code.LOAD("pp");
		code.LOAD("iarray");
		code.INTERFACE(GenericMethodInterface.class, "arrayToArray")
			.reTurn(Object[].class)
			.parameter(Object[].class).INVOKE();
		code.CHECKCAST(Integer[].class);
		code.STORE("warray",Integer[].class);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
