package cc1sj.tinyasm.heroadv;

import static cc1sj.tinyasm.Adv.*;

import cc1sj.tinyasm.AdvClassBuilder;

public class AdvJavaSourceCodeConverterSampleCodeBuilder {

	public static byte[] dump() {
		//package_("cc1sj.tinyasm.heroadv");
		
		AdvClassBuilder clazz = public_().class_("AdvJavaSourceCodeConverterSample").extends_(AdvJavaSourceCodeConverterSampleExtendedClass.class).implements_(AdvJavaSourceCodeConverterSampleImplmentedInterface.class).enterClassBody();
			String name = clazz.private_().field("name",String.class);
		
			clazz.public_().method("sayHello").code(code -> {
				int i =__("i", 10);
				int j =__("j", 20);
				__(j, add(i,j));
		
				AdvJavaSourceCodeConverterSampleReferedObject advSampleReferObject =__("advSampleReferObject", new AdvJavaSourceCodeConverterSampleReferedObject());
		//		advSampleReferObject.sayHello();
		//		String helloString = advSampleReferObject.getHelloString();
		//		advSampleReferObject.setHelloString("sayNothing");
		//		advSampleReferObject.setHelloString(helloString);
		//
				_if(isGreaterThan(j,10)) .then(c->{
					__(j, add(i,j));
				}).else_(c->{
					__(j, add(i,j));
				});
		//
				__(j, add(i,j));
		
				_while(isGreaterThan(j,10)) .block(c->{
					__(j, add(i,j));
				});
		//
		//		advSampleReferObject.setHelloString(helloString);
		
				_do(c->{
					__(j, add(i,j));
				}).while_(isGreaterThan(j,10));
			});
		return clazz.end().toByteArray();
	}
}
