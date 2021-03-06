package cc1sj.tinyasm.sourceconverter;

import static cc1sj.tinyasm.Adv.*;

import cc1sj.tinyasm.AdvClassBuilder;

public class SimpleSampleCodeBuilder {

	public static byte[] dump() {
		//package_("cc1sj.tinyasm.sourceconverter");                            //package cc1sj.tinyasm.sourceconverter;
		
		AdvClassBuilder clazz = public_().class_("SimpleSample").extends_(SuperClass.class).implements_(SuperInterface.class).enterClassBody();//public class SimpleSample extends SuperClass implements SuperInterface {
			
			final String name = clazz.private_().field("name",String.class);    //	private String name;
		
			clazz.public_().method("sayHello").code(code -> {                   //	public void sayHello() {
				final int i =__("i", 10);                                       //		int i = 10;
				final int j =__("j", 20);                                       //		int j = 20;
				__(j, add(i,j));                                                //		j = i + j;
		
				final ReferedObject referedObject =__("referedObject", new ReferedObject());//		ReferedObject referedObject = new ReferedObject();
				referedObject.sayHello();                                       //		referedObject.sayHello();
				final String helloString =__("helloString", referedObject.getHelloString());//		String helloString = referedObject.getHelloString();
				referedObject.setHelloString("sayNothing");                     //		referedObject.setHelloString("sayNothing");
				referedObject.setHelloString(helloString);                      //		referedObject.setHelloString(helloString);
		
				_if(isGreaterThan(j,10)) .then(c->{                             //		if (j > 10) {
					__(j, add(i,j));                                            //			j = i + j;
				}).else_(c->{                                                   //		} else {
					__(j, add(i,j));                                            //			j = i + j;
				});                                                             //		}
		
				__(j, add(i,j));                                                //		j = i + j;
		
				_while(isGreaterThan(j,10)) .block(c->{                         //		while (j > 10) {
					__(j, add(i,j));                                            //			j = i + j;
				});                                                             //		}
		
				referedObject.setHelloString(helloString);                      //		referedObject.setHelloString(helloString);
		
				_do(c->{                                                        //		do {
					__(j, add(i,j));                                            //			j = i + j;
				}).while_(isGreaterThan(j,10));                                 //		} while (j > 10);
		
				final int k =__("k", 0);                                        //		int k = 0;
				_for(isGreaterThan(k,10),c-> _inc(k,1)).block(c->{              //		for (; k > 10; k++) {
					__(j, add(i,j));                                            //			j = i + j;
				});                                                             //		}
			});                                                                 //	}
		return clazz.end().toByteArray();                                       //}
	}
}
