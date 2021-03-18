package cn.sj1.tinyasm;

import static cn.sj1.tinyasm.Adv.__;
import static cn.sj1.tinyasm.Adv._inc;
import static cn.sj1.tinyasm.Adv._while;
import static cn.sj1.tinyasm.Adv.cst;
import static cn.sj1.tinyasm.Adv.isEqual;
import static cn.sj1.tinyasm.Adv.isGreaterEqual;
import static cn.sj1.tinyasm.Adv.isGreaterThan;
import static cn.sj1.tinyasm.Adv.isLessEqual;
import static cn.sj1.tinyasm.Adv.isLessThan;
import static cn.sj1.tinyasm.Adv.isNotEqual;
import static cn.sj1.tinyasm.Adv.public_class_;

@SuppressWarnings("unused")
public class AdvStatement_while_SampleAdvAsmBuilder {

	public static byte[] dump() throws Exception {
		return new AdvStatement_while_SampleAdvAsmBuilder().dump(AdvStatement_while_Sample.class.getName());
	}

	public byte[] dump(String className) throws Exception {
		AdvClassBuilder classBody = public_class_(className).enterClassBody();

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
			_while(isGreaterThan(iGT, 10)).block(c -> {
				_inc(iGT, -1);
			});

			int iGE = __("iGE",cst(20));
			_while(isGreaterEqual(iGE, 10)).block(c -> {
				_inc(iGE, -1);
			});

			int iEQ = __("iEQ",cst(20));
			_while(isEqual(iEQ, 10)).block(c -> {
				_inc(iEQ, 1);
			});

			int iNE = __("iNE",cst(20));
			_while(isNotEqual(iNE, 10)).block(c -> {
				_inc(iNE, 1);
			});

			int iLE = __("iLE",cst(20));
			_while(isLessEqual(iLE, 10)).block(c -> {
				_inc(iLE, 1);
			});

			int iLT = __("iLT",cst(20));
			_while(isLessThan(iLT, 10)).block(c -> {
				_inc(iLT, 1);
			});
		});
	}
}