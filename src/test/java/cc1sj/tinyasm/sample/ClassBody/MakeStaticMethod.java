package cc1sj.tinyasm.sample.ClassBody;

public class MakeStaticMethod {

	public static String staticMethod() {
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

	public static void staticMethodVoid() {
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
