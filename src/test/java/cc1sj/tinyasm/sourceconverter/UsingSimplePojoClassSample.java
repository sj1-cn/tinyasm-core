package cc1sj.tinyasm.sourceconverter;

import cc1sj.tinyasm.hero.helperclass.SimplePojoClassSample;

public class UsingSimplePojoClassSample extends SimpleSuperClass implements SimpleSuperInterface {
	
	@SuppressWarnings("unused")
	private String name;

	public void sayHello() {
		int i = 10;
		int j = 20;
		j = i + j;

		SimplePojoClassSample referedObject = new SimplePojoClassSample();
		referedObject.sayHello();
		String helloString = referedObject.getHelloString();
		referedObject.setHelloString("sayNothing");
		referedObject.setHelloString(helloString);

		if (j > 10) {
			j = i + j;
		} else {
			j = i + j;
		}

		j = i + j;

		while (j > 10) {
			j = i + j;
		}

		referedObject.setHelloString(helloString);

		do {
			j = i + j;
		} while (j > 10);

		int k = 0;
		for (; k > 10; k++) {
			j = i + j;
		}
	}
}
