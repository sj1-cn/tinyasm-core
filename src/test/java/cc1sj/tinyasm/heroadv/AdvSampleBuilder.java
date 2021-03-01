package cc1sj.tinyasm.heroadv;

import static cc1sj.tinyasm.Adv.*;

import java.io.Serializable;

import cc1sj.tinyasm.AdvClassBody;
import cc1sj.tinyasm.AfterEnterBody;
import junit.framework.TestCase;

public class AdvSampleBuilder extends TestCase implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -120670567726930315L;

	public byte[] dump() {
		String AdvSample = "AdvSample";
		Class<?> TestCase = TestCase.class;
		Class<?> Serializable = Serializable.class;

		AdvClassBody clazz = public_().class_(AdvSample).extends_(TestCase).implements_(Serializable).enterClassBody();
		final String name = clazz.public_().field("name", String.class);

		{
			AfterEnterBody code = clazz.public_().method("sayHello").enterBody();
			{
				final int i = refer_(cst(10));
				final int j = refer_(cst(20));
				set_(j, add(i, j));
				AdvSampleReferObject advSampleReferObject = refer_(ctor(AdvSampleReferObject.class));
				advSampleReferObject.sayHello();
				String helloString = advSampleReferObject.getHelloString();
				advSampleReferObject.setHelloString("sayNothing");
				advSampleReferObject.setHelloString(helloString);
				if_(isTrue(advSampleReferObject.beGood())).then_(c -> {
				}).else_(c -> {
				});
				if_(isTrue(advSampleReferObject.beGood())).then_(c -> {
				}).else_if(isTrue(advSampleReferObject.beGood())).then_(c -> {
				});
				while_(isTrue(advSampleReferObject.beGood())).block(c -> {
				});
				do_(nop()).while_(isTrue(advSampleReferObject.beGood()));
			}
			code.exitBody();
		}

		return null;
	}

}
