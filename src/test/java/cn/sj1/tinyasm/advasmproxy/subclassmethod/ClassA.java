package cn.sj1.tinyasm.advasmproxy.subclassmethod;

public class ClassA {
	public void say1() {
		System.out.println("say in classA1");
		say2();
	}
	public void say2() {
		System.out.println("say in classA2");
	}
}
