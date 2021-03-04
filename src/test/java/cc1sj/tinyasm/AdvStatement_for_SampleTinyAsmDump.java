package cc1sj.tinyasm;
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
import java.lang.Object;
@SuppressWarnings("unused")
public class AdvStatement_for_SampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new AdvStatement_for_SampleTinyAsmDump().dump("cc1sj.tinyasm.AdvStatement_for_Sample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_test(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, "<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _test(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, "test").begin();

		code.LINE();
		code.LOADConst(20);
		code.STORE("iGT",int.class);

		code.LINE();
		code.LOADConst(0);
		code.STORE("i",int.class);
		Label label6OfGOTO = new Label();

		code.visitLabel(label6OfGOTO);

		code.LINE();
		code.LOAD("i");
		code.LOADConst(10);
		Label label3OfIF_ICMPGE = new Label();
		code.IF_ICMPGE(label3OfIF_ICMPGE);

		code.LINE();
		code.IINC("iGT", 1);

		code.LINE();
		code.IINC("i", 1);
		code.GOTO(label6OfGOTO);

		code.visitLabel(label3OfIF_ICMPGE);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
