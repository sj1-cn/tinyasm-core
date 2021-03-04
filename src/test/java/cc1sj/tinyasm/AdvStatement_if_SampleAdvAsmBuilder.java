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
public class AdvAsmBuilder_ifAdvAsmBuilder {

	public static byte[] dump() throws Exception {
		return new AdvAsmBuilder_ifAdvAsmBuilder().dump("cc1sj.tinyasm.AdvAsmBuilder_if");
	}

	public byte[] dump(String className) throws Exception {
		AdvClassBuilder classBody = public_().class_(className).enterClassBody();

		__init_(classBody);
		_testIfThen(classBody);
		_testIfThenElse(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(AdvClassBuilder classBody) {
		classBody.public_().method("<init>").code(code -> {

			code.LINE();
			code.LOAD("this");
			code.SPECIAL(Object.class, "<init>").INVOKE();

		});
	}

	protected void _testIfThen(AdvClassBuilder classBody) {
		classBody.public_().method("testIfThen").code(code -> {

			int iGT = __(cst(20));
			__if(isGreaterThan(iGT, 10)).then_(c -> {
				_inc(iGT, -1);
			});

			int iGE = __(cst(20));
			__if(isGreaterEqual(iGE, 10)).then_(c -> {
				_inc(iGE, -1);
			});

			int iEQ = __(cst(20));
			__if(isEqual(iEQ, 10)).then_(c -> {
				_inc(iEQ, 1);
			});

			int iNE = __(cst(20));
			;
			__if(isNotEqual(iNE, 10)).then_(c -> {
				_inc(iNE, 1);
			});

			int iLE = __(cst(20));
			__if(isLessEqual(iLE, 10)).then_(c -> {
				_inc(iLE, 1);
			});

			int iLT = __(cst(20));
			__if(isLessThan(iLT, 10)).then_(c -> {
				_inc(iLT, 1);
			});

		});

	}

	protected void _testIfThenElse(AdvClassBuilder classBody) {
		classBody.method("testIfThenElse").code(code -> {

			int iGT = __(cst(20));
			__if(isGreaterThan(iGT, 10)).then_(c -> {
				_inc(iGT, -1);
			}).else_(c -> {
				_inc(iGT, 1);
			});

			int iGE = __(cst(20));
			__if(isGreaterEqual(iGE, 10)).then_(c -> {
				_inc(iGE, -1);
			}).else_(c -> {
				_inc(iGE, 1);
			});

			int iEQ = __(cst(20));
			__if(isEqual(iEQ, 10)).then_(c -> {
				_inc(iEQ, 1);
			}).else_(c -> {
				_inc(iEQ, 1);
			});

			int iNE = __(cst(20));
			__if(isNotEqual(iNE, 10)).then_(c -> {
				_inc(iNE, 1);
			}).else_(c -> {
				_inc(iNE, -1);
			});

			int iLE = __(cst(20));
			__if(isLessEqual(iLE, 10)).then_(c -> {
				_inc(iLE, 1);
			}).else_(c -> {
				_inc(iLE, 1);
			});

			int iLT = __(cst(20));
			__if(isLessThan(iLT, 10)).then_(c -> {
				_inc(iLT, 1);
			}).else_(c -> {
				_inc(iLT, 1);
			});
		});
	}

}
