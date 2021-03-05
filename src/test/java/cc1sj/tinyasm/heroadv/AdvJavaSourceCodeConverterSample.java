package cc1sj.tinyasm.heroadv;

public class AdvJavaSourceCodeConverterSample extends AdvJavaSourceCodeConverterSampleExtendedClass implements AdvJavaSourceCodeConverterSampleImplmentedInterface {
	private String name;

	public void sayHello() {
		int i = 10;
		int j = 20;
		j = i + j;

		AdvJavaSourceCodeConverterSampleReferedObject advSampleReferObject = new AdvJavaSourceCodeConverterSampleReferedObject();
		advSampleReferObject.sayHello();
		String helloString = advSampleReferObject.getHelloString();
		advSampleReferObject.setHelloString("sayNothing");
		advSampleReferObject.setHelloString(helloString);

		if (j > 10) {
			j = i + j;
		} else {
			j = i + j;
		}

		j = i + j;

		while (j > 10) {
			j = i + j;
		}

		advSampleReferObject.setHelloString(helloString);

		do {
			j = i + j;
		} while (j > 10);

		int k = 0;
		for (; k > 10; k++) {
			j = i + j;
		}
	}
}
