package nebula.tinyasm.util;
import org.objectweb.asm.Label;
import nebula.tinyasm.ClassBody;
import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.MethodCode;
public class SimpleSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("nebula.tinyasm.util.SimpleSample").body();

classWriter.field(0, "i", int.class);
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
	code.line(8);
	code.RETURN();
Label label3 = new Label();
	code.visitLabel(label3);
});
classWriter.method("dd").code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(11);
	code.LOADConst(1);
	code.STORE("j");
Label label1 = new Label();
	code.visitLabel(label1);
	code.line(12);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("i", int.class);
Label label2 = new Label();
	code.visitLabel(label2);
	code.line(13);
	code.RETURN();
Label label3 = new Label();
	code.visitLabel(label3);
});
classWriter.method("methodWith1Param").parameter("i",int.class).code(code -> {
Label label0 = new Label();
	code.visitLabel(label0);
	code.line(16);
	code.LOAD("this");
	code.LOAD("i");
	code.PUTFIELD("i", int.class);
Label label1 = new Label();
	code.visitLabel(label1);
	code.line(17);
	code.RETURN();
Label label2 = new Label();
	code.visitLabel(label2);
});
return classWriter.end().toByteArray();
}
}
