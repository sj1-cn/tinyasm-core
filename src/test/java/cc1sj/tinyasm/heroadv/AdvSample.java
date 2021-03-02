package cc1sj.tinyasm.heroadv;

public class AdvSample extends AdvSampleExtendsClass implements AdvSampleImplmentInterface {
	public void sayHello() {
		int i = 10;
		int j = 20;
		j = i +j;
		
		AdvSampleReferObject advSampleReferObject = new AdvSampleReferObject();
		advSampleReferObject.sayHello();
		String helloString = advSampleReferObject.getHelloString();
		advSampleReferObject.setHelloString("sayNothing");
		advSampleReferObject.setHelloString(helloString);
	}
}
