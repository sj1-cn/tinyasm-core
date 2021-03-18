package cn.sj1.tinyasm.advasmproxy.subclassmethod;

public class ClassB  extends ClassA{

	@Override
	public void say1() {
		System.out.println("say in classB1");
	}

	@Override
	public void say2() {
		System.out.println("say in classB2");
	}

	public void say1InB() {
		super.say1();
	}


	public void say2InB() {
		super.say2();
	}

}
