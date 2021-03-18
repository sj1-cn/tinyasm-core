package cn.sj1.tinyasm.advasmproxy.simple;

import static cn.sj1.tinyasm.Adv.__;
import static cn.sj1.tinyasm.Adv._do;
import static cn.sj1.tinyasm.Adv._for;
import static cn.sj1.tinyasm.Adv._if;
import static cn.sj1.tinyasm.Adv._inc;
import static cn.sj1.tinyasm.Adv._while;
import static cn.sj1.tinyasm.Adv.add;
import static cn.sj1.tinyasm.Adv.isGreaterThan;
import static cn.sj1.tinyasm.Adv.new_;
import static cn.sj1.tinyasm.Adv.public_class_;

import cn.sj1.tinyasm.AdvClassBuilder;

public class SimplePojoClassUsingSampleBuilder {

	@SuppressWarnings("unused")
	public static byte[] dump() {
		AdvClassBuilder clazz = public_class_(SimplePojoClassUsingSample.class.getName()).extends_(SimpleSuperClass.class).implements_(SimpleSuperInterface.class).enterClassBody();
		final String name = clazz.public_().field("name", String.class);

		clazz.public_().method("<init>").code(code -> {
			code.LINE();
			code.LOAD("this");
			code.SPECIAL(SimpleSuperClass.class, "<init>").INVOKE();
		});

		clazz.public_().method("sayHello").code(code -> { // public void sayHello() {
			int i = __("i", 10); // int i = 10;
			int j = __("j", 20); // int j = 20;
			__(j, add(i, j)); // j = i + j;

			SimplePojoClass referedObject = __("referedObject", new_(SimplePojoClass.class));// ReferedObject referedObject = new ReferedObject();
			referedObject.sayHello(); // referedObject.sayHello();
			String helloString = __("helloString", referedObject.getHelloString());// String helloString = referedObject.getHelloString();
			referedObject.setHelloString("sayNothing"); // referedObject.setHelloString("sayNothing");
			referedObject.setHelloString(helloString); // referedObject.setHelloString(helloString);

			_if(isGreaterThan(j, 10)).then(c -> { // if (j > 10) {
				__(j, add(i, j)); // j = i + j;
			}).else_(c -> { // } else {
				__(j, add(i, j)); // j = i + j;
			}); // }

			__(j, add(i, j)); // j = i + j;

			_while(isGreaterThan(j, 10)).block(c -> { // while (j > 10) {
				__(j, add(i, j)); // j = i + j;
			}); // }

			referedObject.setHelloString(helloString); // referedObject.setHelloString(helloString);

			_do(c -> { // do {
				__(j, add(i, j)); // j = i + j;
			}).while_(isGreaterThan(j, 10)); // } while (j > 10);

			int k = __("k", 0); // int k = 0;
			_for(isGreaterThan(k, 10), c -> _inc(k, 1)).block(c -> { // for (; k > 10; k++) {
				__(j, add(i, j)); // j = i + j;
			}); // }
		}); // }
		return clazz.end().toByteArray(); // }

	}
}
