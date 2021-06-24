package cn.sj1.tinyasm.core.sample.MethodCode;

import java.util.function.Function;

public class MethodCodeMethodCallerLAMBDASample {
	static String staticFieldString = "staticFieldString";
	String fieldString = "fieldString";

	static String[] staticFieldStringArray = new String[10];
	String[] fieldStringArray= new String[10];
	public void exec() {
		Function<String, String> func = s -> s.substring(0, 2);
		method(func);
	}

	public void execparamString(String paramString) {
		Function<String, String> func = s -> paramString + s.substring(0, 2);
		method(func);
	}

	public void execfieldString(String paramString) {
		Function<String, String> func = s -> paramString + fieldString + s.substring(0, 2);
		method(func);
	}

	public void execstaticFieldString(String paramString) {
		Function<String, String> func = s -> paramString + staticFieldString + s.substring(0, 2);
		method(func);
	}

	public void execfieldStringArray(String paramString) {
		Function<String, String> func = s -> paramString + fieldStringArray + s.substring(0, 2);
		method(func);
	}

	public void execstaticFieldStringArray(String paramString) {
		Function<String, String> func = s -> paramString + staticFieldStringArray + s.substring(0, 2);
		method(func);
	}

	public void method(Function<String, String> data) {
		String s = data.apply("test");
		System.out.println(s);
	}
}
