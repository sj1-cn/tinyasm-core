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
public class AdvStatement_while_SampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new AdvStatement_while_SampleTinyAsmDump().dump("cc1sj.tinyasm.AdvStatement_while_Sample");
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

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _test(ClassBody classBody) {
		MethodCode code = classBody.method("test").begin();

		code.LINE();
		code.LOADConst(20);
		code.STORE("iGT",int.class);

		code.LINE();
		Label label2OfGOTO = new Label();
		code.GOTO(label2OfGOTO);
		Label label4OfIF_ICMPGT = new Label();

		code.visitLabel(label4OfIF_ICMPGT);

		code.LINE();
		code.IINC("iGT", -1);

		code.visitLabel(label2OfGOTO);

		code.LINE();
		code.LOAD("iGT");
		code.LOADConst(10);
		code.IF_ICMPGT(label4OfIF_ICMPGT);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iGE",int.class);

		code.LINE();
		Label label6OfGOTO = new Label();
		code.GOTO(label6OfGOTO);
		Label label8OfIF_ICMPGE = new Label();

		code.visitLabel(label8OfIF_ICMPGE);

		code.LINE();
		code.IINC("iGE", -1);

		code.visitLabel(label6OfGOTO);

		code.LINE();
		code.LOAD("iGE");
		code.LOADConst(10);
		code.IF_ICMPGE(label8OfIF_ICMPGE);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iEQ",int.class);

		code.LINE();
		Label label10OfGOTO = new Label();
		code.GOTO(label10OfGOTO);
		Label label12OfIF_ICMPEQ = new Label();

		code.visitLabel(label12OfIF_ICMPEQ);

		code.LINE();
		code.IINC("iEQ", 1);

		code.visitLabel(label10OfGOTO);

		code.LINE();
		code.LOAD("iEQ");
		code.LOADConst(10);
		code.IF_ICMPEQ(label12OfIF_ICMPEQ);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iNE",int.class);

		code.LINE();
		Label label14OfGOTO = new Label();
		code.GOTO(label14OfGOTO);
		Label label16OfIF_ICMPNE = new Label();

		code.visitLabel(label16OfIF_ICMPNE);

		code.LINE();
		code.IINC("iNE", 1);

		code.visitLabel(label14OfGOTO);

		code.LINE();
		code.LOAD("iNE");
		code.LOADConst(10);
		code.IF_ICMPNE(label16OfIF_ICMPNE);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iLE",int.class);

		code.LINE();
		Label label18OfGOTO = new Label();
		code.GOTO(label18OfGOTO);
		Label label20OfIF_ICMPLE = new Label();

		code.visitLabel(label20OfIF_ICMPLE);

		code.LINE();
		code.IINC("iLE", 1);

		code.visitLabel(label18OfGOTO);

		code.LINE();
		code.LOAD("iLE");
		code.LOADConst(10);
		code.IF_ICMPLE(label20OfIF_ICMPLE);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iLT",int.class);

		code.LINE();
		Label label22OfGOTO = new Label();
		code.GOTO(label22OfGOTO);
		Label label24OfIF_ICMPLT = new Label();

		code.visitLabel(label24OfIF_ICMPLT);

		code.LINE();
		code.IINC("iLT", 1);

		code.visitLabel(label22OfGOTO);

		code.LINE();
		code.LOAD("iLT");
		code.LOADConst(10);
		code.IF_ICMPLT(label24OfIF_ICMPLT);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
