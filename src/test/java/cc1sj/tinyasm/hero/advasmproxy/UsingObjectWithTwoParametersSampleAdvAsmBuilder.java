package cc1sj.tinyasm.hero.advasmproxy;

import static cc1sj.tinyasm.Adv.__;
import static cc1sj.tinyasm.Adv.cst;
import static cc1sj.tinyasm.Adv.new_;
import static cc1sj.tinyasm.Adv.params;
import static cc1sj.tinyasm.Adv.public_class_;

import cc1sj.tinyasm.AdvClassBuilder;
import cc1sj.tinyasm.hero.helperclass.ObjectWithTwoParametersSample;

@SuppressWarnings("unused")
public class UsingObjectWithTwoParametersSampleAdvAsmBuilder {

	public static byte[] dump() throws Exception {

		AdvClassBuilder classBody = public_class_("cc1sj.tinyasm.hero.advasmproxy.UsingObjectWithTwoParametersSample").enterClassBody();

		classBody.public_().method("<init>").code(code -> {
			code.LINE();
			code.LOAD("this");
			code.SPECIAL(Object.class, "<init>").INVOKE();
		});

		classBody.public_().method("test").code(code -> {
			ObjectWithTwoParametersSample p1 = __("p1", new_(ObjectWithTwoParametersSample.class, params(3, 3)));
			int i = __("i", cst(10));
			int j = __("j", cst(20));
			ObjectWithTwoParametersSample p2 = __("p2", new_(ObjectWithTwoParametersSample.class, params(i, j)));
		});

		return classBody.end().toByteArray();
	}
}
