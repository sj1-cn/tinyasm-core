package cc1sj.tinyasm.advasmproxy.simple;

public class ReferSimplePojoClassUsingSample extends SimpleSuperClass implements SimpleSuperInterface {

	@SuppressWarnings("unused")
	private String name;

	public void sayHello() {
		int i = 10;
		int j = 20;
		j = i + j;

		ReferSimplePojoClass referedObject = new ReferSimplePojoClass();
		referedObject.sayHello(); // referedObject.sayHello();
		String helloString = referedObject.getHelloString();// String helloString = referedObject.getHelloString();
		referedObject.setHelloString("sayNothing"); // referedObject.setHelloString("sayNothing");
		referedObject.setHelloString(helloString); // referedObject.setHelloString(helloString);
		SimplePojoClass refered2Object = referedObject.getSimplePojoClassSample();
		refered2Object.sayHello();

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
