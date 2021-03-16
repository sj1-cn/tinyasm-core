package cc1sj.tinyasm.advasmproxy.simple;

public class ReferSimplePojoClass {
	public void sayHello() {
		System.out.println(getHelloString());
	}

	public String getHelloString() {
		return "sayHello";
	}

	public SimplePojoClass getSimplePojoClassSample() {
		return new SimplePojoClass();
	}

	public void setHelloString(String string) {
		// TODO Auto-generated method stub

	}

	public boolean beGood() {
		return true;
	}
}
