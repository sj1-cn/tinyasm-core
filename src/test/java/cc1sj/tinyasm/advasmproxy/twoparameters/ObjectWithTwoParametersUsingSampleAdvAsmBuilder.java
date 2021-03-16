package cc1sj.tinyasm.advasmproxy.twoparameters;

import static cc1sj.tinyasm.Adv.__;
import static cc1sj.tinyasm.Adv.cst;
import static cc1sj.tinyasm.Adv.new_;
import static cc1sj.tinyasm.Adv.params;
import static cc1sj.tinyasm.Adv.public_class_;

import cc1sj.tinyasm.AdvClassBuilder;

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
