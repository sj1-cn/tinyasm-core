package nebula.tinyasm.util;
import org.objectweb.asm.Label;
import nebula.tinyasm.ClassBody;
import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.MethodCode;
import static org.objectweb.asm.Opcodes.*;
public class MathSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("nebula.tinyasm.util.MathSample").body();

classWriter.method("<init>").code(code -> {

	code.LINE(3);
	code.LOAD("this");
	code.SPECIAL(java.lang.Object.class, "<init>").INVOKE();
	code.RETURN();
});
classWriter.method("math").code(code -> {

	code.LINE(5);
	code.LOADConst(10);
	code.STORE("i",int.class);

	code.LINE(6);
	code.LOADConst(2);
	code.STORE("j",int.class);

	code.LINE(7);
	code.LOAD("i");
	code.LOAD("j");
	code.ADD();
	code.STORE("i");

	code.LINE(8);
	code.LOAD("i");
	code.LOAD("j");
	code.SUB();
	code.STORE("i");

	code.LINE(9);
	code.LOAD("i");
	code.LOAD("j");
	code.MUL();
	code.STORE("i");

	code.LINE(10);
	code.LOAD("i");
	code.LOAD("j");
	code.DIV();
	code.STORE("i");

	code.LINE(11);
	code.LOAD("i");
	code.LOADConst(2);
	code.REM();
	code.STORE("i");

	code.LINE(12);
	code.LOAD("j");
	code.LOADConst(2);
	code.SHL();
	code.STORE("i");

	code.LINE(13);
	code.LOAD("j");
	code.LOADConst(2);
	code.SHR();
	code.STORE("i");

	code.LINE(14);
	code.RETURN();
});
return classWriter.end().toByteArray();
}
}
