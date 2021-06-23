package cn.sj1.tinyasm.core.sample.MethodCode;

import java.util.ArrayList;
import java.util.List;

public class MethodCodeMethodCallerSample {

	@SuppressWarnings("unused")
	private int i = 10;

	public MethodCodeMethodCallerSample() {
		i = 100;
	}

	public static void method(String data) {
		int i = 10;
		Long l = 10L;// Long.valueOf(i); // Static;

		String s = String.valueOf(i);

		s = new StringBuilder().append(s).append(i).append(l).toString();

		List<String> ls = new ArrayList<>();
		ls.add("first");
		ls.add("second");

	}
}
