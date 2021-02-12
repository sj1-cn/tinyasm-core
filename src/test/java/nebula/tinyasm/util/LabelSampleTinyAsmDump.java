package nebula.tinyasm.util;
import org.objectweb.asm.Label;
import nebula.tinyasm.ClassBody;
import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import nebula.tinyasm.Clazz;
@SuppressWarnings("unused")
public class LabelSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("nebula.tinyasm.util.LabelSample").access(ACC_PUBLIC | ACC_SUPER).body();

classWriter.method(ACC_PUBLIC, "<init>").code(code -> {

	code.LINE(3);
	code.LOAD("this");
	code.SPECIAL(java.lang.Object.class, "<init>").INVOKE();
	code.RETURN();
});
classWriter.method(ACC_PUBLIC, "t").code(code -> {

	code.LINE(5);
	code.LOADConst(10);
	code.STORE("i",int.class);

	code.LINE(6);
	code.LOAD("i");
	code.LOADConst(1);
	Label label0OfIF_ICMPNE = new Label();
	code.IF_ICMPNE(label0OfIF_ICMPNE);

	code.LINE(7);
	code.IINC("i", 1);

	code.visitLabel(label0OfIF_ICMPNE);

	code.LINE(9);
	code.GETSTATIC(java.lang.System.class, "out", java.io.PrintStream.class);
	code.LOADConst("ddd");
	code.VIRTUAL(java.io.PrintStream.class, "println")
		.parameter(java.lang.String.class).INVOKE();

	code.LINE(10);
	code.RETURN();
});
return classWriter.end().toByteArray();
}
}
