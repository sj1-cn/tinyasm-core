package nebula.tinyasm.util;
import org.objectweb.asm.Label;
import nebula.tinyasm.ClassBody;
import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import nebula.tinyasm.Clazz;
@SuppressWarnings("unused")
public class SignatureGenericSampleTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("nebula.tinyasm.util.SignatureGenericSample", Clazz.of(java.lang.Object.class)Clazz.of(java.util.ArrayList.class,)).access(ACC_PUBLIC | ACC_SUPER).body();

classWriter.method(ACC_PUBLIC, "<init>").code(code -> {

	code.LINE(7);
	code.LOAD("this");
	code.SPECIAL(java.util.ArrayList.class, "<init>").INVOKE();
	code.RETURN();
});
return classWriter.end().toByteArray();
}
}
