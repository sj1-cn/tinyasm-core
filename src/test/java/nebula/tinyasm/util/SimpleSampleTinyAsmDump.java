package nebula.tinyasm.util;
import org.objectweb.asm.Label;
import nebula.tinyasm.ClassBody;
import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.MethodCode;
import static org.objectweb.asm.Opcodes.*;
public class SimpleSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("nebula.tinyasm.util.SimpleSample").body();

classWriter.field(0, "i", int.class);
classWriter.method("<init>").code(code -> {

	code.LINE(6);
	code.LOAD("this");
	code.SPECIAL(java.lang.Object.class, "<init>").INVOKE();

	code.LINE(4);
	code.LOAD("this");
	code.LOADConst(0);
	code.PUTFIELD("i", int.class);

	code.LINE(8);
	code.RETURN();
});
classWriter.method("dd").code(code -> {

	code.LINE(11);
	code.LOADConst(1);
	code.STORE("j",int.class);

	code.LINE(12);
	code.LOAD("this");
	code.LOADConst(1);
	code.PUTFIELD("i", int.class);

	code.LINE(13);
	code.RETURN();
});
classWriter.method("methodWith1Param").parameter("i",int.class).code(code -> {

	code.LINE(16);
	code.LOAD("this");
	code.LOAD("i");
	code.PUTFIELD("i", int.class);

	code.LINE(17);
	code.RETURN();
});
return classWriter.end().toByteArray();
}
}
