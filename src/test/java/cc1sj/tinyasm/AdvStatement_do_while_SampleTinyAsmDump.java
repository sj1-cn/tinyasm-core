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
public class AdvStatement_do_while_SampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new AdvStatement_do_while_SampleTinyAsmDump().dump("cc1sj.tinyasm.AdvStatement_do_while_Sample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_test(classBody);

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

	protected void _test(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("test").begin();

		code.LINE();
		code.LOADConst(20);
		code.STORE("iGT",int.class);
		Label label3OfIF_ICMPGT = new Label();

		code.visitLabel(label3OfIF_ICMPGT);

		code.LINE();
		code.IINC("iGT", -1);

		code.LINE();
		code.LOAD("iGT");
		code.LOADConst(10);
		code.IF_ICMPGT(label3OfIF_ICMPGT);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iGE",int.class);
		Label label6OfIF_ICMPGE = new Label();

		code.visitLabel(label6OfIF_ICMPGE);

		code.LINE();
		code.IINC("iGE", -1);

		code.LINE();
		code.LOAD("iGE");
		code.LOADConst(10);
		code.IF_ICMPGE(label6OfIF_ICMPGE);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iEQ",int.class);
		Label label9OfIF_ICMPEQ = new Label();

		code.visitLabel(label9OfIF_ICMPEQ);

		code.LINE();
		code.IINC("iEQ", 1);

		code.LINE();
		code.LOAD("iEQ");
		code.LOADConst(10);
		code.IF_ICMPEQ(label9OfIF_ICMPEQ);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iNE",int.class);
		Label label12OfIF_ICMPNE = new Label();

		code.visitLabel(label12OfIF_ICMPNE);

		code.LINE();
		code.IINC("iNE", 1);

		code.LINE();
		code.LOAD("iNE");
		code.LOADConst(10);
		code.IF_ICMPNE(label12OfIF_ICMPNE);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iLE",int.class);
		Label label15OfIF_ICMPLE = new Label();

		code.visitLabel(label15OfIF_ICMPLE);

		code.LINE();
		code.IINC("iLE", 1);

		code.LINE();
		code.LOAD("iLE");
		code.LOADConst(10);
		code.IF_ICMPLE(label15OfIF_ICMPLE);

		code.LINE();
		code.LOADConst(20);
		code.STORE("iLT",int.class);
		Label label18OfIF_ICMPLT = new Label();

		code.visitLabel(label18OfIF_ICMPLT);

		code.LINE();
		code.IINC("iLT", 1);

		code.LINE();
		code.LOAD("iLT");
		code.LOADConst(10);
		code.IF_ICMPLT(label18OfIF_ICMPLT);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
