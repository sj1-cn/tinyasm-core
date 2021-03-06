package cc1sj.tinyasm.sourceconverter;

public class SimpleSampleRefer2 extends SuperClass implements SuperInterface {
	
	private String name;

	public void sayHello() {
		int i = 10;
		int j = 20;
		j = i + j;

		ReferReferedObject referedObject = new ReferReferedObject();
		referedObject.sayHello(); // referedObject.sayHello();
		String helloString = referedObject.getHelloString();// String helloString = referedObject.getHelloString();
		referedObject.setHelloString("sayNothing"); // referedObject.setHelloString("sayNothing");
		referedObject.setHelloString(helloString); // referedObject.setHelloString(helloString);
		ReferRefered2Object refered2Object = referedObject.getReferRefered2Object();
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
