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

		code.LINE(6);
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);
		Label label4OfIF_ICMPGT = new Label();

		code.visitLabel(label4OfIF_ICMPGT);

		code.LINE(7);
		code.IINC("iGT", -1);

		code.visitLabel(label2OfGOTO);

		code.LINE(6);
		code.LOAD("iGT");
		code.LOADConst(10);
		code.IF_ICMPGT(label4OfIF_ICMPGT);

		code.LINE(10);
		code.LOADConst(20);
		code.STORE("iGE",int.class);

		code.LINE(11);
		Label label6OfGOTO = new Label();
		code.GOTO(label6OfGOTO);
		Label label8OfIF_ICMPGE = new Label();

		code.visitLabel(label8OfIF_ICMPGE);

		code.LINE(12);
		code.IINC("iGE", -1);

		code.visitLabel(label6OfGOTO);

		code.LINE(11);
		code.LOAD("iGE");
		code.LOADConst(10);
		code.IF_ICMPGE(label8OfIF_ICMPGE);

		code.LINE(15);
		code.LOADConst(10);
		code.STORE("iEQ",int.class);

		code.LINE(16);
		Label label10OfGOTO = new Label();
		code.GOTO(label10OfGOTO);
		Label label12OfIF_ICMPEQ = new Label();

		code.visitLabel(label12OfIF_ICMPEQ);

		code.LINE(17);
		code.IINC("iEQ", 1);

		code.visitLabel(label10OfGOTO);

		code.LINE(16);
		code.LOAD("iEQ");
		code.LOADConst(10);
		code.IF_ICMPEQ(label12OfIF_ICMPEQ);

		code.LINE(20);
		code.LOADConst(0);
		code.STORE("iLE",int.class);

		code.LINE(21);
		Label label14OfGOTO = new Label();
		code.GOTO(label14OfGOTO);
		Label label16OfIF_ICMPLE = new Label();

		code.visitLabel(label16OfIF_ICMPLE);

		code.LINE(22);
		code.IINC("iLE", 1);

		code.visitLabel(label14OfGOTO);

		code.LINE(21);
		code.LOAD("iLE");
		code.LOADConst(10);
		code.IF_ICMPLE(label16OfIF_ICMPLE);

		code.LINE(25);
		code.LOADConst(0);
		code.STORE("iLT",int.class);

		code.LINE(26);
		Label label18OfGOTO = new Label();
		code.GOTO(label18OfGOTO);
		Label label20OfIF_ICMPLT = new Label();

		code.visitLabel(label20OfIF_ICMPLT);

		code.LINE(27);
		code.IINC("iLT", 1);

		code.visitLabel(label18OfGOTO);

		code.LINE(26);
		code.LOAD("iLT");
		code.LOADConst(10);
		code.IF_ICMPLT(label20OfIF_ICMPLT);

		code.LINE(29);
		code.RETURN();

		code.END();
	}

}
