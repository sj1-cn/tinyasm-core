package cc1sj.tinyasm;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.lang.Object;
@SuppressWarnings("unused")
public class TinyAsmBuilder_whileTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new TinyAsmBuilder_whileTinyAsmDump().dump("cc1sj.tinyasm.TinyAsmBuilder_while");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_test(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method("<init>").begin();

		code.LINE(3);
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _test(ClassBody classBody) {
		MethodCode code = classBody.method("test").begin();

		code.LINE(5);
		code.LOADConst(20);
		code.STORE("iGT",int.class);
		Label label4OfGOTO = new Label();

		code.visitLabel(label4OfGOTO);

		code.LINE(6);
		code.LOAD("iGT");
		code.LOADConst(10);
		Label label2OfIF_ICMPLE = new Label();
		code.IF_ICMPLE(label2OfIF_ICMPLE);

		code.LINE(7);
		code.IINC("iGT", -1);
		code.GOTO(label4OfGOTO);

		code.visitLabel(label2OfIF_ICMPLE);

		code.LINE(10);
		code.LOADConst(20);
		code.STORE("iGE",int.class);
		Label label7OfGOTO = new Label();

		code.visitLabel(label7OfGOTO);

		code.LINE(11);
		code.LOAD("iGE");
		code.LOADConst(10);
		Label label5OfIF_ICMPLT = new Label();
		code.IF_ICMPLT(label5OfIF_ICMPLT);

		code.LINE(12);
		code.IINC("iGE", -1);
		code.GOTO(label7OfGOTO);

		code.visitLabel(label5OfIF_ICMPLT);

		code.LINE(15);
		code.LOADConst(10);
		code.STORE("iEQ",int.class);
		Label label10OfGOTO = new Label();

		code.visitLabel(label10OfGOTO);

		code.LINE(16);
		code.LOAD("iEQ");
		code.LOADConst(10);
		Label label8OfIF_ICMPNE = new Label();
		code.IF_ICMPNE(label8OfIF_ICMPNE);

		code.LINE(17);
		code.IINC("iEQ", 1);
		code.GOTO(label10OfGOTO);

		code.visitLabel(label8OfIF_ICMPNE);

		code.LINE(20);
		code.LOADConst(0);
		code.STORE("iLE",int.class);
		Label label13OfGOTO = new Label();

		code.visitLabel(label13OfGOTO);

		code.LINE(21);
		code.LOAD("iLE");
		code.LOADConst(10);
		Label label11OfIF_ICMPGT = new Label();
		code.IF_ICMPGT(label11OfIF_ICMPGT);

		code.LINE(22);
		code.IINC("iLE", 1);
		code.GOTO(label13OfGOTO);

		code.visitLabel(label11OfIF_ICMPGT);

		code.LINE(25);
		code.LOADConst(0);
		code.STORE("iLT",int.class);
		Label label16OfGOTO = new Label();

		code.visitLabel(label16OfGOTO);

		code.LINE(26);
		code.LOAD("iLT");
		code.LOADConst(10);
		Label label14OfIF_ICMPGE = new Label();
		code.IF_ICMPGE(label14OfIF_ICMPGE);

		code.LINE(27);
		code.IINC("iLT", 1);
		code.GOTO(label16OfGOTO);

		code.visitLabel(label14OfIF_ICMPGE);

		code.LINE(29);
		code.RETURN();

		code.END();
	}

}
