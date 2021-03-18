package cn.sj1.tinyasm.advasmproxy.twoparameters;

import static cn.sj1.tinyasm.Adv.__;
import static cn.sj1.tinyasm.Adv.cst;
import static cn.sj1.tinyasm.Adv.new_;
import static cn.sj1.tinyasm.Adv.params;
import static cn.sj1.tinyasm.Adv.public_class_;

import cn.sj1.tinyasm.AdvClassBuilder;

@SuppressWarnings("unused")
public class ObjectWithTwoParametersUsingSampleAdvAsmBuilder {

	public static byte[] dump() throws Exception {

		AdvClassBuilder classBody = public_class_(ObjectWithTwoParametersUsingSample.class.getName()).enterClassBody();

		classBody.public_().method("<init>").code(code -> {
			code.LINE();
			code.LOAD("this");
			code.SPECIAL(Object.class, "<init>").INVOKE();
		});

		classBody.public_().method("test").code(code -> {
			ObjectWithTwoParameters p1 = __("p1", new_(ObjectWithTwoParameters.class, params(3, 3)));
			int i = __("i", cst(10));
			int j = __("j", cst(20));
			ObjectWithTwoParameters p2 = __("p2", new_(ObjectWithTwoParameters.class, params(i, j)));
		});

		return classBody.end().toByteArray();
	}
}
