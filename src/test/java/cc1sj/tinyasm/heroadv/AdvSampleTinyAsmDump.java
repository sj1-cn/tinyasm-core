package cc1sj.tinyasm.heroadv;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.heroadv.AdvSampleReferObject;
import cc1sj.tinyasm.heroadv.AdvSampleImplmentInterface;
import java.lang.String;
import cc1sj.tinyasm.heroadv.AdvSampleExtendsClass;
@SuppressWarnings("unused")
public class AdvSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new AdvSampleTinyAsmDump().dump("cc1sj.tinyasm.heroadv.AdvSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className, AdvSampleExtendsClass.class, AdvSampleImplmentInterface.class)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_sayHello(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(AdvSampleExtendsClass.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _sayHello(ClassBody classBody) {
		MethodCode code = classBody.method("sayHello").begin();

		code.LINE();
		code.LOADConst(10);
		code.STORE("i",int.class);

		code.LINE();
		code.LOADConst(20);
		code.STORE("j",int.class);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");

		code.LINE();
		code.NEW(AdvSampleReferObject.class);
		code.DUP();
		code.SPECIAL(AdvSampleReferObject.class, "<init>").INVOKE();
		code.STORE("advSampleReferObject",AdvSampleReferObject.class);

		code.LINE();
		code.LOAD("advSampleReferObject");
		code.VIRTUAL(AdvSampleReferObject.class, "sayHello").INVOKE();

		code.LINE();
		code.LOAD("advSampleReferObject");
		code.VIRTUAL(AdvSampleReferObject.class, "getHelloString")
			.reTurn(String.class).INVOKE();
		code.STORE("helloString",String.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
