package cc1sj.tinyasm.hero.advasmproxy;

public class AdvAsmProxyInvokeNewWithTwoParametersSample {
	@SuppressWarnings("unused")
	public void test() {

		AdvAsmProxyWithTwoParametersSample p1 = new AdvAsmProxyWithTwoParametersSample(3, 3);
		int i = 10;
		int j = 20;
		AdvAsmProxyWithTwoParametersSample p2 = new AdvAsmProxyWithTwoParametersSample(i, j);

	}
}
