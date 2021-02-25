package cc1sj.tinyasm.util;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.io.PrintStream;
import java.lang.System;
import java.lang.Object;
import java.lang.String;
@SuppressWarnings("unused")
public class LabelSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classBody = ClassBuilder.make("cc1sj.tinyasm.util.LabelSample").access(ACC_PUBLIC | ACC_SUPER).body();

{
	MethodCode code = classBody.method("<init>").begin();

	code.LINE(3);
	code.LOAD("this");
	code.SPECIAL(Object.class, "<init>").INVOKE();
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("t").begin();

	code.LINE(5);
	code.LOADConst(10);
	code.STORE("i",int.class);

	code.LINE(6);
	code.LOAD("i");
	code.LOADConst(1);
	Label label2OfIF_ICMPNE = new Label();
	code.IF_ICMPNE(label2OfIF_ICMPNE);

	code.LINE(7);
	code.IINC("i", 1);

	code.visitLabel(label2OfIF_ICMPNE);

	code.LINE(9);
	code.GETSTATIC(System.class, "out", PrintStream.class);
	code.LOADConst("ddd");
	code.VIRTUAL(PrintStream.class, "println")
		.parameter(String.class).INVOKE();

	code.LINE(10);
	code.RETURN();
	code.END();
}

return classBody.end().toByteArray();
}
}
