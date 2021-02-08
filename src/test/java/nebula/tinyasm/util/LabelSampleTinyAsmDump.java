package nebula.tinyasm.util;
import org.objectweb.asm.Label;
import nebula.tinyasm.ClassBody;
import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.MethodCode;
import static org.objectweb.asm.Opcodes.*;
public class LabelSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("nebula.tinyasm.util.LabelSample").body();

classWriter.method("<init>").code(code -> {

	code.LINE(3);
	code.LOAD("this");
	code.SPECIAL(java.lang.Object.class, "<init>").INVOKE();
	code.RETURN();
});
classWriter.method("t").code(code -> {

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
	code.RETURN();
});
return classWriter.end().toByteArray();
}
}
