package cn.sj1.tinyasm.core.sample.MethodCode;

import java.util.function.Function;

public class MethodCodeMethodCallerLAMBDASample {

	public void exec() {
		Function<String, String> func = s -> s.substring(0, 2);
		method(func);
	}

	public void method(Function<String, String> data) {
		String s = data.apply("test");
		System.out.println(s);
	}
}
