package cn.sj1.tinyasm.util;

public class SimpleSample {
	@SuppressWarnings("unused")
	private int i = 0;

	public SimpleSample() {

	}

	@SuppressWarnings("unused")
	public void dd() {
		int j = 1;
		int k = 1;
		int k1 = j + 10;
		int j1 = k1 + 10;
	}

	public void methodWith1Param(int i) {
		this.i = i;
	}
}
