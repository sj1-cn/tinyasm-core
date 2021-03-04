package cc1sj.tinyasm.hero.helperclass;

public class AdvAsmProxyInvokeNewWithTwoParametersSample {
	public void test() {

		AdvAsmProxyWithTwoParametersSample p1 = new AdvAsmProxyWithTwoParametersSample(3, 3);
		int i = 10;
		int j = 20;
		AdvAsmProxyWithTwoParametersSample p2 = new AdvAsmProxyWithTwoParametersSample(i, j);

	}
}
