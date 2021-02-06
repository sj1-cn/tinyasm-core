package nebula.tinyasm.util;

import nebula.tinyasm.ClassBody;
import nebula.tinyasm.ClassBuilder;
import static nebula.tinyasm.util.TypeUtils.*;

public class SimpleSampleDump {

	public static byte[] dump() throws Exception {
		String clazz = "nebula.tinyasm.util.SimpleSample";
		ClassBody classWriter = ClassBuilder.make(clazz).body();
		classWriter.field("i", int.class);
		classWriter.method("<init>").code(code -> {
			code.codeNewLabel();
			code.line();
			code.LOAD("this");
			code.SPECIAL(java.lang.Object.class, "<init>").INVOKE();
			code.LOAD("this");
			code.LOAD("this");
			code.GETFIELD("i", int.class);
			code.LOAD("this");
			code.ADD();
			code.LOAD("this");
			code.GETFIELD("i", int.class);
			code.DIV();
			code.ADD();
			code.LOADConst(10);
			code.ADD();
			code.PUTFIELD("i", int.class);
			
			
			code.RETURN();
		});

		return classWriter.end().toByteArray();
	}
}
