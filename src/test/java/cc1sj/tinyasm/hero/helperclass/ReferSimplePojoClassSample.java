package cc1sj.tinyasm.hero.helperclass;

public class ReferSimplePojoClassSample {
	public void sayHello() {
		System.out.println(getHelloString());
	}

	public String getHelloString() {
		return "sayHello";
	}

	public SimplePojoClassSample getSimplePojoClassSample() {
		return new SimplePojoClassSample();
	}

	public void setHelloString(String string) {
		// TODO Auto-generated method stub

	}

	public boolean beGood() {
		return true;
	}
}
