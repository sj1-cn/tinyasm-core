package cn.sj1.tinyasm.core.sample.MethodCode;

import java.util.function.Function;

public class MethodCodeMethodCallerLAMBDASample {
	static String staticFieldString = "staticFieldString";
	String fieldString = "fieldString";

	public void exec() {
		Function<String, String> func = s -> s.substring(0, 2);
		method(func);
	}

	public void execparamString(String paramString) {
		Function<String, String> func = s -> paramString + s.substring(0, 2);
		method(func);
	}

	public void execfieldString() {
		Function<String, String> func = s -> fieldString + s.substring(0, 2);
		method(func);
	}

	public void execstaticFieldString() {
		Function<String, String> func = s -> staticFieldString + s.substring(0, 2);
		method(func);
	}

	public void method(Function<String, String> data) {
		String s = data.apply("test");
		System.out.println(s);
	}
}
