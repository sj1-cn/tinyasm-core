package nebula.tinyasm.util;
import org.objectweb.asm.Label;
import nebula.tinyasm.ClassBody;
import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.MethodCode;
public class SimpleSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("nebula.tinyasm.util.SimpleSample").body();

classWriter.field("i", "int.class");
classWriter.method("<init>").code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(6);
	code.LOAD("this");
	code.SPECIAL(java.lang.Object.class, "<init>").INVOKE();
Label label1 = new Label();
	code.visitLabel(label1);
	code.line(4);
	code.LOAD("this");
	code.LOADConst(0);
	code.PUTFIELD("i", int.class);
Label label2 = new Label();
	code.visitLabel(label2);
	code.line(7);
	code.RETURN();
Label label3 = new Label();
	code.visitLabel(label3);
});
return classWriter.end().toByteArray();
}
}
