package cc1sj.tinyasm.heroadv;

import static cc1sj.tinyasm.Adv.*;

import cc1sj.tinyasm.AdvClassBuilder;

public class AdvJavaSourceCodeConverterSampleCodeBuilder {

	public static byte[] dump() {
		//package_("cc1sj.tinyasm.heroadv");                                    //package cc1sj.tinyasm.heroadv;
		
		AdvClassBuilder clazz = public_().class_("AdvJavaSourceCodeConverterSample").extends_(AdvJavaSourceCodeConverterSampleExtendedClass.class).implements_(AdvJavaSourceCodeConverterSampleImplmentedInterface.class).enterClassBody();//public class AdvJavaSourceCodeConverterSample extends AdvJavaSourceCodeConverterSampleExtendedClass implements AdvJavaSourceCodeConverterSampleImplmentedInterface {
			String name = clazz.private_().field("name",String.class);          //	private String name;
		
			clazz.public_().method("sayHello").code(code -> {                   //	public void sayHello() {
				int i =__("i", 10);                                             //		int i = 10;
				int j =__("j", 20);                                             //		int j = 20;
				__(j, add(i,j));                                                //		j = i + j;
		
				AdvJavaSourceCodeConverterSampleReferedObject advSampleReferObject =__("advSampleReferObject", new AdvJavaSourceCodeConverterSampleReferedObject());//		AdvJavaSourceCodeConverterSampleReferedObject advSampleReferObject = new AdvJavaSourceCodeConverterSampleReferedObject();
				advSampleReferObject.sayHello();                                //		advSampleReferObject.sayHello();
				String helloString =__("helloString", advSampleReferObject.getHelloString());//		String helloString = advSampleReferObject.getHelloString();
				advSampleReferObject.setHelloString("sayNothing");              //		advSampleReferObject.setHelloString("sayNothing");
				advSampleReferObject.setHelloString(helloString);               //		advSampleReferObject.setHelloString(helloString);
		
				_if(isGreaterThan(j,10)) .then(c->{                             //		if (j > 10) {
					__(j, add(i,j));                                            //			j = i + j;
				}).else_(c->{                                                   //		} else {
					__(j, add(i,j));                                            //			j = i + j;
				});                                                             //		}
		
				__(j, add(i,j));                                                //		j = i + j;
		
				_while(isGreaterThan(j,10)) .block(c->{                         //		while (j > 10) {
					__(j, add(i,j));                                            //			j = i + j;
				});                                                             //		}
		
				advSampleReferObject.setHelloString(helloString);               //		advSampleReferObject.setHelloString(helloString);
		
				_do(c->{                                                        //		do {
					__(j, add(i,j));                                            //			j = i + j;
				}).while_(isGreaterThan(j,10));                                 //		} while (j > 10);
		
				int k =__("k", 0);                                              //		int k = 0;
				_for(isGreaterThan(k,10),c-> _inc(k,1)).block(c->{              //		for (; k > 10; k++) {
					__(j, add(i,j));                                            //			j = i + j;
				});                                                             //		}
			});                                                                 //	}
		return clazz.end().toByteArray();                                       //}
	}
}
