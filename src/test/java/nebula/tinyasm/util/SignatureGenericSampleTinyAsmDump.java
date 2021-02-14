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

ClassBody classWriter = ClassBuilder.make("nebula.tinyasm.util.SignatureGenericSample", Clazz.of(java.util.HashMap.class,Clazz.typeVariableOf("S"),Clazz.typeVariableOf("D")),Clazz.of(java.io.Serializable.class)).formalTypeParameter("S",Clazz.of(java.lang.Object.class)).formalTypeParameter("D",Clazz.of(java.lang.Object.class)).access(ACC_PUBLIC | ACC_SUPER).body();

classWriter.method(ACC_PUBLIC, "<init>").code(code -> {

	code.LINE(8);
	code.LOAD("this");
	code.SPECIAL(java.util.HashMap.class, "<init>").INVOKE();
	code.RETURN();
});
return classWriter.end().toByteArray();
}
}
