package cc1sj.tinyasm.heroadv;

public class AdvSample extends AdvSampleExtendsClass {
	private String name;

	public void sayHello() {
		int i = 10;
		int j = 20;
		j = i + j;

		AdvSampleReferObject advSampleReferObject = new AdvSampleReferObject();
		advSampleReferObject.sayHello();
		String helloString = advSampleReferObject.getHelloString();
		advSampleReferObject.setHelloString("sayNothing");
		advSampleReferObject.setHelloString(helloString);
//
		if (j > 10) {
			j = i + j;
		} else {
			j = i + j;
		}
//
		j = i + j;

		while (j > 10) {
			j = i + j;
		}
//
//		advSampleReferObject.setHelloString(helloString);

		do {
			j = i + j;
		} while (j > 10);
	}
}
