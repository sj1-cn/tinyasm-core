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
import static cn.sj1.tinyasm.Adv.private_;

import cn.sj1.tinyasm.AdvClassBuilder;
import cn.sj1.tinyasm.AdvMagic;

public class ReferSimplePojoClassUsingSampleMagicBuilder extends SimpleSuperClass implements SimpleSuperInterface {

	@SuppressWarnings("unused")
	private String _name;

	String saying;

	public void dumpInit(String word) {
		this.saying = word;
	}

	public void _dump_fields(AdvClassBuilder classBody) {
		_name = private_().field("name", String.class);
	}

	public void sayHello() { // public void sayHello() {
		final int _i = __("i", 10); // int i = 10;
		final int _j = __("j", 20); // int j = 20;
		__(_j, add(_i, _j)); // j = i + j;

		final ReferSimplePojoClass referedObject = __("referedObject", new_(ReferSimplePojoClass.class));// ReferedObject
																														// referedObject =
																														// new
		// ReferedObject();
		referedObject.sayHello(); // referedObject.sayHello();
		final String helloString = __("helloString", referedObject.getHelloString());// String helloString = referedObject.getHelloString();
		referedObject.setHelloString(saying); // referedObject.setHelloString("sayNothing");
		referedObject.setHelloString(helloString); // referedObject.setHelloString(helloString);
		final SimplePojoClass refered2Object = __("refered2Object", referedObject.getSimplePojoClassSample());
		refered2Object.sayHello();

		_if(isGreaterThan(_j, 10)).then(c -> { // if (j > 10) {
			__(_j, add(_i, _j)); // j = i + j;
		}).else_(c -> { // } else {
			__(_j, add(_i, _j)); // j = i + j;
		}); // }

		__(_j, add(_i, _j)); // j = i + j;

		_while(isGreaterThan(_j, 10)).block(c -> { // while (j > 10) {
			__(_j, add(_i, _j)); // j = i + j;
		}); // }

		referedObject.setHelloString(helloString); // referedObject.setHelloString(helloString);

		_do(c -> { // do {
			__(_j, add(_i, _j)); // j = i + j;
		}).while_(isGreaterThan(_j, 10)); // } while (j > 10);

		int k = __("k", 0); // int k = 0;
		_for(isGreaterThan(k, 10), c -> _inc(k, 1)).block(c -> { // for (; k > 10; k++) {
			__(_j, add(_i, _j)); // j = i + j;
		}); // } //}

	}

	public static byte[] dump() {

		ReferSimplePojoClassUsingSampleMagicBuilder magicBuilderProxy = AdvMagic.buildMagicProxyInstance(ReferSimplePojoClassUsingSampleMagicBuilder.class);

		magicBuilderProxy.dumpInit("sayNothing");

		return AdvMagic.dumpTargetFromMagicBuilderInstance(ReferSimplePojoClassUsingSample.class.getName(), magicBuilderProxy);

	}
}
