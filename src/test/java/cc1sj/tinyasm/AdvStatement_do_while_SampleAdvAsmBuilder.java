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
public class AdvStatement_do_while_SampleAdvAsmBuilder {

	public static byte[] dump() throws Exception {
		return new AdvStatement_do_while_SampleAdvAsmBuilder().dump(AdvStatement_do_while_Sample.class.getName());
	}

	public byte[] dump(String className) throws Exception {
		AdvClassBuilder classBody = publicClass_(className).enterClassBody();

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

			int iGT = __("iGT",cst(20));
			_do(c -> {
				_inc(iGT, -1);
			}).while_(isGreaterThan(iGT, 10));

			int iGE = __("iGE",cst(20));
			_do(c -> {
				_inc(iGE, -1);
			}).while_(isGreaterEqual(iGE, 10));

			int iEQ = __("iEQ",cst(20));
			_do(c -> {
				_inc(iEQ, 1);
			}).while_(isEqual(iEQ, 10));

			int iNE = __("iNE",cst(20));
			_do(c -> {
				_inc(iNE, 1);
			}).while_(isNotEqual(iNE, 10));

			int iLE = __("iLE",cst(20));
			_do(c -> {
				_inc(iLE, 1);
			}).while_(isLessEqual(iLE, 10));

			int iLT = __("iLT",cst(20));
			_do(c -> {
				_inc(iLT, 1);
			}).while_(isLessThan(iLT, 10));
		});
	}
}
