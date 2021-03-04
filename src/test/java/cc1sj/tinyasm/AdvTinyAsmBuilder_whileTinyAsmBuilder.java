package cc1sj.tinyasm;

import org.objectweb.asm.Label;
import cc1sj.tinyasm.AdvClassBuilder;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;

import static cc1sj.tinyasm.Adv.*;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.lang.Object;

@SuppressWarnings("unused")
public class AdvTinyAsmBuilder_whileTinyAsmBuilder {

	public static byte[] dump() throws Exception {
		return new AdvTinyAsmBuilder_whileTinyAsmBuilder().dump("cc1sj.tinyasm.TinyAsmBuilder_while");
	}

	public byte[] dump(String className) throws Exception {
		AdvClassBuilder classBody = public_().class_(className).enterClassBody();

		__init_(classBody);
		_test(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(AdvClassBuilder classBody) {
		classBody.method("<init>").code(code -> {

//			initThis();
		});
	}

	protected void _test(AdvClassBuilder classBody) {
		classBody.method("test").code(code -> {

			int iGT = cst(20);
			while_(isGreaterThan(iGT, 10)).block(c -> {
				inc(iGT, -1);
			});

			int iGE = cst(20);
			while_(isGreaterEqual(iGE, 10)).block(c -> {
				inc(iGE, -1);
			});

			int iEQ = cst(10);
			while_(isEqual(iEQ, 10)).block(c -> {
				inc(iEQ, 1);
			});

			int iNE = cst(10);
			while_(isNotEqual(iNE, 10)).block(c -> {
				inc(iNE, 1);
			});

			int iLE = cst(0);
			while_(isLessEqual(iLE, 10)).block(c -> {
				inc(iLE, 1);
			});

			int iLT = cst(0);
			while_(isLessThan(iLT, 10)).block(c -> {
				inc(iLT, 1);
			});
		});
	}
}
