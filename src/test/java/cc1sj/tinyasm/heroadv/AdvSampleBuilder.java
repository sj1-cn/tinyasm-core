package cc1sj.tinyasm.heroadv;

import static cc1sj.tinyasm.Adv.add;
import static cc1sj.tinyasm.Adv.cst;
import static cc1sj.tinyasm.Adv.ctor;
import static cc1sj.tinyasm.Adv.do_;
import static cc1sj.tinyasm.Adv.if_;
import static cc1sj.tinyasm.Adv.isTrue;
import static cc1sj.tinyasm.Adv.nop;
import static cc1sj.tinyasm.Adv.public_;
import static cc1sj.tinyasm.Adv.__;
import static cc1sj.tinyasm.Adv.__;
import static cc1sj.tinyasm.Adv.while_;

import java.io.Serializable;

import cc1sj.tinyasm.AdvClassBody;
import junit.framework.TestCase;

public class AdvSampleBuilder extends TestCase implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -120670567726930315L;

	public static byte[] dump() {
		String AdvSample = "AdvSample";
		Class<?> TestCase = TestCase.class;
		Class<?> Serializable = Serializable.class;

		AdvClassBody clazz = public_().class_(AdvSample).extends_(TestCase).implements_(Serializable).enterClassBody();
		final String name = clazz.public_().field("name", String.class);

		{
			clazz.public_().method("sayHello").code(code -> {
				final int i = __(cst(10));
				final int j = __(cst(20));
				__(j, add(i, j));
//				AdvSampleReferObject advSampleReferObject = refer_(ctor(AdvSampleReferObject.class));
//				advSampleReferObject.sayHello();
//				String helloString = advSampleReferObject.getHelloString();
//				advSampleReferObject.setHelloString("sayNothing");
//				advSampleReferObject.setHelloString(helloString);
//				if_(isTrue(advSampleReferObject.beGood())).then_(c -> {
//				}).else_(c -> {
//				});
//				if_(isTrue(advSampleReferObject.beGood())).then_(c -> {
//				}).else_if(isTrue(advSampleReferObject.beGood())).then_(c -> {
//				});
//				while_(isTrue(advSampleReferObject.beGood())).block(c -> {
//				});
//				do_(nop()).while_(isTrue(advSampleReferObject.beGood()));
			});
		}

		return clazz.end();
	}

}
