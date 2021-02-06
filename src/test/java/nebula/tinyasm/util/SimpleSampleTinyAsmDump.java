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
	code.line(7);
	code.LOAD("this");
	code.DUP();
	code.GETFIELD("i", int.class);
	code.LOADConst(1);
	code.ADD();
	code.PUTFIELD("i", int.class);
Label label3 = new Label();
	code.visitLabel(label3);
	code.line(8);
	code.LOAD("this");
	code.DUP();
	code.GETFIELD("i", int.class);
	code.LOADConst(1);
	code.SUB();
	code.PUTFIELD("i", int.class);
Label label4 = new Label();
	code.visitLabel(label4);
	code.line(9);
	code.LOAD("this");
	code.DUP();
	code.GETFIELD("i", int.class);
	code.LOADConst(1);
	code.MUL();
	code.PUTFIELD("i", int.class);
Label label5 = new Label();
	code.visitLabel(label5);
	code.line(10);
	code.LOAD("this");
	code.DUP();
	code.GETFIELD("i", int.class);
	code.LOADConst(1);
	code.DIV();
	code.PUTFIELD("i", int.class);
Label label6 = new Label();
	code.visitLabel(label6);
	code.line(12);
	code.RETURN();
Label label7 = new Label();
	code.visitLabel(label7);
});
return classWriter.end().toByteArray();
}
}
