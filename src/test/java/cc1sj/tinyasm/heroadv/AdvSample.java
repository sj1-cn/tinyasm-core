package cc1sj.tinyasm.heroadv;

import static cc1sj.tinyasm.Adv.do_;
import static cc1sj.tinyasm.Adv.if_;
import static cc1sj.tinyasm.Adv.isTrue;
import static cc1sj.tinyasm.Adv.nop;
import static cc1sj.tinyasm.Adv.while_;

public class AdvSample extends AdvSampleExtendsClass implements AdvSampleImplmentInterface {
	private String name;
	public void sayHello() {
		int i = 10;
		int j = 20;
		j = i + j;

		AdvSampleReferObject advSampleReferObject = new AdvSampleReferObject();
//		advSampleReferObject.sayHello();
//		String helloString = advSampleReferObject.getHelloString();
//		advSampleReferObject.setHelloString("sayNothing");
//		advSampleReferObject.setHelloString(helloString);

//		if ((advSampleReferObject.beGood())) {
//			i += j;
//		} else {
//			i += j;
//		}
//
//		if ((advSampleReferObject.beGood())) {
//			i += j;
//		} else if ((advSampleReferObject.beGood())) {
//			i += j;
//		}

//		while ((advSampleReferObject.beGood())) {
//			i += j;
//		}

//		advSampleReferObject.setHelloString(helloString);
		do {
			i += j;
		} while ((advSampleReferObject.beGood()));
	}
}
