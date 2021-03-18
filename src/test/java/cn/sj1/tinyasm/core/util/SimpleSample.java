package cn.sj1.tinyasm.core.util;

public class SimpleSample {
	int i = 0;

	public SimpleSample() {

	}

	public void dd() {
		int j = 1;
		i = j + 1;
	}

	public void methodWith1Param(int i) {
		this.i = i;
	}
}
