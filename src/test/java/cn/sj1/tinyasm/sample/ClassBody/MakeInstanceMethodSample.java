package cn.sj1.tinyasm.sample.ClassBody;

public class MakeInstanceMethodSample {

	String method() {
		return "here";
	}

	public String publicMethod() {
		return "here";
	}

	@SuppressWarnings("unused")
	private String privateMethod() {
		return "here";
	}

	protected String protectedMethod() {
		return "here";
	}

	void methodVoid() {
		return;
	}

	public void publicMethodVoid() {
		return;
	}

	@SuppressWarnings("unused")
	private void privateMethodVoid() {
		return;
	}

	protected void protectedMethodVoid() {
		return;
	}
}
