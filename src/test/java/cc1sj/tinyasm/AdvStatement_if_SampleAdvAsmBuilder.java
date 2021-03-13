package cc1sj.tinyasm;

import static cc1sj.tinyasm.Adv.__;
import static cc1sj.tinyasm.Adv._if;
import static cc1sj.tinyasm.Adv._inc;
import static cc1sj.tinyasm.Adv.cst;
import static cc1sj.tinyasm.Adv.isEqual;
import static cc1sj.tinyasm.Adv.isGreaterEqual;
import static cc1sj.tinyasm.Adv.isGreaterThan;
import static cc1sj.tinyasm.Adv.isLessEqual;
import static cc1sj.tinyasm.Adv.isLessThan;
import static cc1sj.tinyasm.Adv.isNotEqual;
import static cc1sj.tinyasm.Adv.public_class_;

@SuppressWarnings("unused")
public class AdvStatement_if_SampleAdvAsmBuilder {

	public static byte[] dump() throws Exception {
		return new AdvStatement_if_SampleAdvAsmBuilder().dump(AdvStatement_if_Sample.class.getName());
	}

	public byte[] dump(String className) throws Exception {
		AdvClassBuilder classBody = public_class_(className).enterClassBody();

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

			int iGT = __("iGT", cst(20));
			_if(isGreaterThan(iGT, 10)).then(c -> {
				_inc(iGT, -1);
			});

			int iGE = __("iGE", cst(20));
			_if(isGreaterEqual(iGE, 10)).then(c -> {
				_inc(iGE, -1);
			});

			int iEQ = __("iEQ", cst(20));
			_if(isEqual(iEQ, 10)).then(c -> {
				_inc(iEQ, 1);
			});

			int iNE = __("iNE", cst(20));
			_if(isNotEqual(iNE, 10)).then(c -> {
				_inc(iNE, 1);
			});

			int iLE = __("iLE", cst(20));
			_if(isLessEqual(iLE, 10)).then(c -> {
				_inc(iLE, 1);
			});

			int iLT = __("iLT", cst(20));
			_if(isLessThan(iLT, 10)).then(c -> {
				_inc(iLT, 1);
			});

		});

	}

	protected void _testIfThenElse(AdvClassBuilder classBody) {
		classBody.method("testIfThenElse").code(code -> {

			int iGT = __("iGT", cst(20));
			_if(isGreaterThan(iGT, 10)).then(c -> {
				_inc(iGT, -1);
			}).else_(c -> {
				_inc(iGT, 1);
			});

			int iGE = __("iGE", cst(20));
			_if(isGreaterEqual(iGE, 10)).then(c -> {
				_inc(iGE, -1);
			}).else_(c -> {
				_inc(iGE, 1);
			});

			int iEQ = __("iEQ", cst(20));
			_if(isEqual(iEQ, 10)).then(c -> {
				_inc(iEQ, 1);
			}).else_(c -> {
				_inc(iEQ, 1);
			});

			int iNE = __("iNE", cst(20));
			_if(isNotEqual(iNE, 10)).then(c -> {
				_inc(iNE, 1);
			}).else_(c -> {
				_inc(iNE, -1);
			});

			int iLE = __("iLE", cst(20));
			_if(isLessEqual(iLE, 10)).then(c -> {
				_inc(iLE, 1);
			}).else_(c -> {
				_inc(iLE, 1);
			});

			int iLT = __("iLT", cst(20));
			_if(isLessThan(iLT, 10)).then(c -> {
				_inc(iLT, 1);
			}).else_(c -> {
				_inc(iLT, 1);
			});
		});
	}

}
