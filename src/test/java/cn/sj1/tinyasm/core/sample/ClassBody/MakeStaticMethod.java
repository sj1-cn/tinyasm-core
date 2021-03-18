package cn.sj1.tinyasm.core.sample.ClassBody;

public class MakeStaticMethod {

	static String staticMethod() {
		return "here";
	}

	public static String publicStaticMethod() {
		return "here";
	}

	@SuppressWarnings("unused")
	private static String privateStaticMethod() {
		return "here";
	}

	protected static String protectedStaticMethod() {
		return "here";
	}

	static void staticMethodVoid() {
		return;
	}

	public static void publicStaticMethodVoid() {
		return;
	}

	@SuppressWarnings("unused")
	private static void privateStaticMethodVoid() {
		return;
	}

	protected static void protectedStaticMethodVoid() {
		return;
	}
}
