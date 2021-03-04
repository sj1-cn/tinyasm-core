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
public class AdvStatement_while_SampleAdvAsmBuilder {

	public static byte[] dump() throws Exception {
		return new AdvStatement_while_SampleAdvAsmBuilder().dump(AdvStatement_while_Sample.class.getName());
	}

	public byte[] dump(String className) throws Exception {
		AdvClassBuilder classBody = public_().class_(className).enterClassBody();

		__init_(classBody);
		_test(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(AdvClassBuilder classBody) {
		classBody.public_().method("<init>").code(code -> {

			code.LINE();
			code.LOAD("this");
			code.SPECIAL(Object.class, "<init>").INVOKE();

		});
	}

	protected void _test(AdvClassBuilder classBody) {
		classBody.public_().method("test").code(code -> {

			int iGT = __(cst(20));
			_while(isGreaterThan(iGT, 10))._block(c -> {
				_inc(iGT, -1);
			});

			int iGE = __(cst(20));
			_while(isGreaterEqual(iGE, 10))._block(c -> {
				_inc(iGE, -1);
			});

			int iEQ = __(cst(20));
			_while(isEqual(iEQ, 10))._block(c -> {
				_inc(iEQ, 1);
			});

			int iNE = __(cst(20));
			_while(isNotEqual(iNE, 10))._block(c -> {
				_inc(iNE, 1);
			});

			int iLE = __(cst(20));
			_while(isLessEqual(iLE, 10))._block(c -> {
				_inc(iLE, 1);
			});

			int iLT = __(cst(20));
			_while(isLessThan(iLT, 10))._block(c -> {
				_inc(iLT, 1);
			});
		});
	}
}
