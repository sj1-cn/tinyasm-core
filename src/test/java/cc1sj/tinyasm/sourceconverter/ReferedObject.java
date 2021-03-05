package cc1sj.tinyasm.sourceconverter;

public class ReferedObject {
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
