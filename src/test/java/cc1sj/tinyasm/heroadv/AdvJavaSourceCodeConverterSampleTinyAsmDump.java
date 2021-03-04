package cc1sj.tinyasm.heroadv;
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
import cc1sj.tinyasm.heroadv.AdvJavaSourceCodeConverterSampleReferedObject;
import java.lang.String;
import cc1sj.tinyasm.heroadv.AdvJavaSourceCodeConverterSampleImplmentedInterface;
import cc1sj.tinyasm.heroadv.AdvJavaSourceCodeConverterSampleExtendedClass;
@SuppressWarnings("unused")
public class AdvJavaSourceCodeConverterSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new AdvJavaSourceCodeConverterSampleTinyAsmDump().dump("cc1sj.tinyasm.heroadv.AdvJavaSourceCodeConverterSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className, AdvJavaSourceCodeConverterSampleExtendedClass.class, AdvJavaSourceCodeConverterSampleImplmentedInterface.class)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.field("name", Clazz.of(String.class));
		__init_(classBody);
		_sayHello(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, "<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(AdvJavaSourceCodeConverterSampleExtendedClass.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _sayHello(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, "sayHello").begin();

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
		code.NEW(AdvJavaSourceCodeConverterSampleReferedObject.class);
		code.DUP();
		code.SPECIAL(AdvJavaSourceCodeConverterSampleReferedObject.class, "<init>").INVOKE();
		code.STORE("advSampleReferObject",AdvJavaSourceCodeConverterSampleReferedObject.class);

		code.LINE();
		code.LOAD("j");
		code.LOADConst(10);
		Label label5OfIF_ICMPLE = new Label();
		code.IF_ICMPLE(label5OfIF_ICMPLE);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");
		Label label7OfGOTO = new Label();
		code.GOTO(label7OfGOTO);

		code.visitLabel(label5OfIF_ICMPLE);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");

		code.visitLabel(label7OfGOTO);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");
		Label label11OfGOTO = new Label();

		code.visitLabel(label11OfGOTO);

		code.LINE();
		code.LOAD("j");
		code.LOADConst(10);
		Label label9OfIF_ICMPLE = new Label();
		code.IF_ICMPLE(label9OfIF_ICMPLE);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");
		code.GOTO(label11OfGOTO);

		code.visitLabel(label9OfIF_ICMPLE);

		code.LINE();
		code.LOAD("i");
		code.LOAD("j");
		code.ADD();
		code.STORE("j");

		code.LINE();
		code.LOAD("j");
		code.LOADConst(10);
		code.IF_ICMPGT(label9OfIF_ICMPLE);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
