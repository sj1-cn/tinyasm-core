package cn.sj1.tinyasm.core.advasmproxy.simple;

import static cn.sj1.tinyasm.core.Adv.__;
import static cn.sj1.tinyasm.core.Adv._do;
import static cn.sj1.tinyasm.core.Adv._for;
import static cn.sj1.tinyasm.core.Adv._if;
import static cn.sj1.tinyasm.core.Adv._inc;
import static cn.sj1.tinyasm.core.Adv._while;
import static cn.sj1.tinyasm.core.Adv.add;
import static cn.sj1.tinyasm.core.Adv.isGreaterThan;
import static cn.sj1.tinyasm.core.Adv.new_;

import cn.sj1.tinyasm.core.AdvClassBuilder;
import cn.sj1.tinyasm.core.AdvMagic;

public class SimplePojoClassUsingSampleMagicBuilder extends SimpleSuperClass implements SimpleSuperInterface {

	String name;// = clazz.public_().field("name", String.class);

	public void _dump_fields(AdvClassBuilder classBody) {
		name = classBody.private_().field("name", String.class);
	}
	
	public void sayHello() { // public void sayHello() {
		int i = __("i", 10); // int i = 10;
		int j = __("j", 20); // int j = 20;
		__(j, add(i, j)); // j = i + j;

		SimplePojoClass referedObject = __("referedObject", new_(SimplePojoClass.class));// ReferedObject referedObject = new
																										// ReferedObject();
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
		}); // } //}

	}

	public static byte[] dump() {

		SimplePojoClassUsingSampleMagicBuilder magicBuilderProxy = AdvMagic.buildMagicProxyInstance(SimplePojoClassUsingSampleMagicBuilder.class);

//		magicBuilderProxy.dumpInit("sayNothing");

		return AdvMagic.dumpTargetFromMagicBuilderInstance(SimplePojoClassUsingSample.class.getName(), magicBuilderProxy);

	}
}
