package cn.sj1.tinyasm.core;

import static cn.sj1.tinyasm.core.Adv.__;
import static cn.sj1.tinyasm.core.Adv._for;
import static cn.sj1.tinyasm.core.Adv._inc;
import static cn.sj1.tinyasm.core.Adv.cst;
import static cn.sj1.tinyasm.core.Adv.isLessThan;
import static cn.sj1.tinyasm.core.Adv.public_class_;

@SuppressWarnings("unused")
public class AdvStatement_for_SampleAdvAsmBuilder {

	public static byte[] dump() throws Exception {
		return new AdvStatement_for_SampleAdvAsmBuilder().dump(AdvStatement_for_Sample.class.getName());
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
			int i = __("i",cst(0));

			_for(isLessThan(i, 10), c -> _inc(i, 1)).block(c -> {
				_inc(iGT, 1);
			});
			
		});
	}
}
