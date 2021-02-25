package cc1sj.tinyasm.util;

import org.objectweb.asm.Label;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;

import static cc1sj.tinyasm.TinyAsmBuilder.*;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;

@SuppressWarnings("unused")
public class SimpleSampleTinyAsmProxyBuilder {

	public static byte[] dump() throws Exception {

		ClassBody classWriter = ClassBuilder.make("cc1sj.tinyasm.util.SimpleSample").access(ACC_PUBLIC | ACC_SUPER).body();

		classWriter.field("i", Clazz.of(int.class));
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

			int j = cst(1);
			int k = cst(1);
			int k1 = add(j, 10);
			int j1 = add(k1, 10);

			code.LINE(15);
			code.RETURN();
		});
		classWriter.method("methodWith1Param").parameter("i", int.class).code(code -> {

			code.LINE(18);
			code.LOAD("this");
			code.LOAD("i");
			code.PUTFIELD("i", int.class);

			code.LINE(19);
			code.RETURN();
		});
		return classWriter.end().toByteArray();
	}
}
