package cc1sj.tinyasm.sourceconverter;

import static cc1sj.tinyasm.Adv.*;

import cc1sj.tinyasm.Adv;
import cc1sj.tinyasm.AdvClassBuilder;
import cc1sj.tinyasm.hero.helperclass.ReferSimplePojoClassSample;
import cc1sj.tinyasm.hero.helperclass.SimplePojoClassSample;

public class UsingReferSimplePojoClassSampleMagicBuilder {

//	final private String _name = private_().field("name", String.class);

	String saying;

	public void dumpInit(String word) {
		this.saying = word;
	}

	public void _dump_fields(AdvClassBuilder classBody) {
		classBody.private_().field("name", String.class);
	}

	public void _dump_init(AdvClassBuilder classBody) {
		classBody.public_().method("<init>").code(code -> {
			code.LINE();
			code.LOAD("this");
			code.SPECIAL(classBody.getSuperClazz(), "<init>").INVOKE();
		});
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

		AdvClassBuilder classBuilder = public_class_("cc1sj.tinyasm.sourceconverter.UsingReferSimplePojoClassSample")
				.extends_(SimpleSuperClass.class).implements_(SimpleSuperInterface.class).enterClassBody();

		UsingReferSimplePojoClassSampleMagicBuilder magicBuilderProxy = Adv
				.buildMagicBuilderProxyClass(UsingReferSimplePojoClassSampleMagicBuilder.class);

		magicBuilderProxy.dumpInit("sayNothing");

		return execMagic(classBuilder, magicBuilderProxy);

	}
}
