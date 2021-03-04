package cc1sj.tinyasm.heroadv;

import static cc1sj.tinyasm.Adv.*;

import cc1sj.tinyasm.AdvClassBuilder;

public class AdvSampleCodeBuilder {

	public static byte[] dump() {
		//package_("cc1sj.tinyasm.heroadv");
		
		AdvClassBuilder clazz = public_().class_("AdvSample").extends_(AdvSampleExtendsClass.class).implements_(AdvSampleImplmentInterface.class).enterClassBody();
			String name = clazz.private_().field("name",String.class);
		
			clazz.public_().method("sayHello").code(code -> {
				int i =__( 10);
				int j =__( 20);
				__(j, add(i,j));
		
				AdvSampleReferObject advSampleReferObject =__( new AdvSampleReferObject());
				advSampleReferObject.sayHello();
				String helloString =__( advSampleReferObject.getHelloString());
				advSampleReferObject.setHelloString("sayNothing");
				advSampleReferObject.setHelloString(helloString);
		//
				if_(isGreaterThan(j,10)) .then_(c->{
					__(j, add(i,j));
				}).else_(c->{
					__(j, add(i,j));
				});
		//
				__(j, add(i,j));
		
				while_(isGreaterThan(j,10)) .block(c->{
					__(j, add(i,j));
				});
		//
		//		advSampleReferObject.setHelloString(helloString);
		
				do_(c->{
					__(j, add(i,j));
				}).while_(isGreaterThan(j,10));
			});
		return clazz.end().toByteArray();
	}
}
