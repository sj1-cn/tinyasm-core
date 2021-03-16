package cc1sj.tinyasm.advasmproxy.simple;

public class SimplePojoClass {
	public void sayHello() {
		System.out.println(getHelloString());
	}

	public String getHelloString() {
		return "sayHello";
	}

	public void setHelloString(String string) {
		// TODO Auto-generated method stub

	}

	public boolean beGood() {
		return true;
	}
}
