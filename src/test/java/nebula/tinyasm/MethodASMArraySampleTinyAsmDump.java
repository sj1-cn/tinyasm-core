package nebula.tinyasm;
import org.objectweb.asm.Label;
import nebula.tinyasm.ClassBody;
import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.MethodCode;
import static org.objectweb.asm.Opcodes.*;
public class MethodASMArraySampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("nebula.tinyasm.MethodASMArraySample").body();

classWriter.field("la", long[].class);
classWriter.method("<init>").code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(3);
	code.LOAD("this");
	code.SPECIAL(java.lang.Object.class, "<init>").INVOKE();
	code.RETURN();
Label label1 = new Label();
	code.visitLabel(label1);
});
classWriter.method("init").code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(6);
	code.LOAD("this");
	code.LOADConst(10);
	code.NEWARRAY(long.class);
	code.PUTFIELD("la", long[].class);
Label label1 = new Label();
	code.visitLabel(label1);
	code.line(7);
	code.RETURN();
Label label2 = new Label();
	code.visitLabel(label2);
});
return classWriter.end().toByteArray();
}
}
