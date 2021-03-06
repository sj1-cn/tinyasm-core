package cc1sj.tinyasm.sourceconverter;

public class ReferReferedObject {
	public void sayHello() {
		System.out.println(getHelloString());
	}

	public String getHelloString() {
		return "sayHello";
	}
	public ReferRefered2Object getReferRefered2Object() {
		return new ReferRefered2Object();
	}

	public void setHelloString(String string) {
		// TODO Auto-generated method stub

	}

	public boolean beGood() {
		return true;
	}
}
