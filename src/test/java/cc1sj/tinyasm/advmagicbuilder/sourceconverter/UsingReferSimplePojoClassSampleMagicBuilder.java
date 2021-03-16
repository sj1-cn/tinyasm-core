package cc1sj.tinyasm.advmagicbuilder.sourceconverter;

import static cc1sj.tinyasm.Adv.__;
import static cc1sj.tinyasm.Adv._do;
import static cc1sj.tinyasm.Adv._for;
import static cc1sj.tinyasm.Adv._if;
import static cc1sj.tinyasm.Adv._inc;
import static cc1sj.tinyasm.Adv._while;
import static cc1sj.tinyasm.Adv.add;
import static cc1sj.tinyasm.Adv.isGreaterThan;
import static cc1sj.tinyasm.Adv.new_;
import static cc1sj.tinyasm.Adv.private_;

import cc1sj.tinyasm.AdvClassBuilder;
import cc1sj.tinyasm.AdvMagic;
import cc1sj.tinyasm.hero.helperclass.ReferSimplePojoClassSample;
import cc1sj.tinyasm.hero.helperclass.SimplePojoClassSample;

public class UsingReferSimplePojoClassSampleMagicBuilder extends SimpleSuperClass implements SimpleSuperInterface {

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

		final ReferSimplePojoClassSample referedObject = __("referedObject", new_(ReferSimplePojoClassSample.class));// ReferedObject
																														// referedObject =
																														// new
		// ReferedObject();
		referedObject.sayHello(); // referedObject.sayHello();
		final String helloString = __("helloString", referedObject.getHelloString());// String helloString = referedObject.getHelloString();
		referedObject.setHelloString(saying); // referedObject.setHelloString("sayNothing");
		referedObject.setHelloString(helloString); // referedObject.setHelloString(helloString);
		final SimplePojoClassSample refered2Object = __("refered2Object", referedObject.getSimplePojoClassSample());
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

		UsingReferSimplePojoClassSampleMagicBuilder magicBuilderProxy = AdvMagic.build(UsingReferSimplePojoClassSampleMagicBuilder.class);

		magicBuilderProxy.dumpInit("sayNothing");

		return AdvMagic.dump(UsingReferSimplePojoClassSample.class.getName(), magicBuilderProxy);

	}
}
