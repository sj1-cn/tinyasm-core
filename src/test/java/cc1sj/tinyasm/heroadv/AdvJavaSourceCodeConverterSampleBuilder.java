package cc1sj.tinyasm.heroadv;

import static cc1sj.tinyasm.Adv.*;

import cc1sj.tinyasm.AdvClassBuilder;

public class AdvJavaSourceCodeConverterSampleBuilder {

	public static byte[] dump() {
		AdvClassBuilder clazz = public_().class_("cc1sj.tinyasm.heroadv.AdvJavaSourceCodeConverterSample").extends_(AdvJavaSourceCodeConverterSampleExtendedClass.class)
				.implements_(AdvJavaSourceCodeConverterSampleImplmentedInterface.class).enterClassBody();
		final String name = clazz.public_().field("name", String.class);

		clazz.public_().method("<init>").code(code -> {
			code.LINE();
			code.LOAD("this");
			code.SPECIAL(AdvJavaSourceCodeConverterSampleExtendedClass.class, "<init>").INVOKE();
		});

		clazz.public_().method("sayHello").code(code -> {
			final int i = __("i",cst(10));// int i = 10;
			final int j = __("j",cst(20));// int j = 20;
			__(j, add(i, j));// j = i + j;
			AdvJavaSourceCodeConverterSampleReferedObject advSampleReferObject = __("advSampleReferObject",new_(AdvJavaSourceCodeConverterSampleReferedObject.class));
			advSampleReferObject.sayHello();
			String helloString = __("helloString",advSampleReferObject.getHelloString());
			advSampleReferObject.setHelloString("sayNothing");
			advSampleReferObject.setHelloString(helloString);
//			
			_if(isGreaterThan(j, 10)).then(c -> {/* if (j > 10) { */
				__(j, add(i, j));/* j = i + j; */
			}).else_(c -> {
				__(j, add(i, j));/* j = i + j; */
			});
//
			__(j, add(i, j));/* j = i + j; */

			_while(isGreaterThan(j, 10)).block(c -> {/* while (j > 10) { */
				__(j, add(i, j));/* j = i + j; */
			});
//
			advSampleReferObject.setHelloString(helloString);
////				
			_do(c -> {
				__(j, add(i, j));/* j = i + j; */
			}).while_(isGreaterThan(j, 10));// } while (j > 10);
		});

		return clazz.end().toByteArray();
	}

}
