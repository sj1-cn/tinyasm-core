package cc1sj.tinyasm.heroadv;

import static cc1sj.tinyasm.Adv.add;
import static cc1sj.tinyasm.Adv.cst;
import static cc1sj.tinyasm.Adv.ctor;
import static cc1sj.tinyasm.Adv.do_;
import static cc1sj.tinyasm.Adv.if_;
import static cc1sj.tinyasm.Adv.isGreaterThan;
import static cc1sj.tinyasm.Adv.isTrue;
import static cc1sj.tinyasm.Adv.nop;
import static cc1sj.tinyasm.Adv.public_;
import static cc1sj.tinyasm.Adv.__;
import static cc1sj.tinyasm.Adv.__;
import static cc1sj.tinyasm.Adv.while_;

import java.io.Serializable;

import cc1sj.tinyasm.AdvClassBody;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.MethodCode;
import junit.framework.TestCase;

public class AdvSampleBuilder extends TestCase implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -120670567726930315L;

	public static byte[] dump() {
		String AdvSample = "cc1sj.tinyasm.heroadv.AdvSample";

		AdvClassBody clazz = public_().class_(AdvSample).extends_(AdvSampleExtendsClass.class).implements_(AdvSampleImplmentInterface.class)
				.enterClassBody();
		final String name = clazz.public_().field("name", String.class);

		clazz.public_().method("<init>").code(code -> {
			code.LINE();
			code.LOAD("this");
			code.SPECIAL(AdvSampleExtendsClass.class, "<init>").INVOKE();
		});

		clazz.public_().method("sayHello").code(code -> {
			final int i = __(cst(10));//int i = 10;
			final int j = __(cst(20));//int j = 20;
			__(j, add(i, j));//j = i + j;
			AdvSampleReferObject advSampleReferObject = __(ctor(AdvSampleReferObject.class));
			advSampleReferObject.sayHello();
			String helloString = __(advSampleReferObject.getHelloString());
			advSampleReferObject.setHelloString("sayNothing");
			advSampleReferObject.setHelloString(helloString);
//			
			if_(isGreaterThan(j, 10)).then_(c -> {/*if (j > 10) {*/
				__(j, add(i, j));/*j = i + j;*/
			}).else_(c -> {
				__(j, add(i, j));/*j = i + j;*/
			});
//
			__(j, add(i, j));/*j = i + j;*/


			while_(isGreaterThan(j, 10)).block(c -> {/*while (j > 10) {*/
				__(j, add(i, j));/*j = i + j;*/
			});
//
//			advSampleReferObject.setHelloString(helloString);
////				
			do_(c -> {
				__(j, add(i, j));/*j = i + j;*/
			}).while_(isGreaterThan(j, 10));//} while (j > 10);
		});

		return clazz.end();
	}

}
