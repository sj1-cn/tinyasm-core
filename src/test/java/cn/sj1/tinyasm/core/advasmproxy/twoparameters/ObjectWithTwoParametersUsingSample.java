package cn.sj1.tinyasm.core.advasmproxy.twoparameters;

public class ObjectWithTwoParametersUsingSample {
	@SuppressWarnings("unused")
	public void test() {

		ObjectWithTwoParameters p1 = new ObjectWithTwoParameters(3, 3);
		int i = 10;
		int j = 20;
		ObjectWithTwoParameters p2 = new ObjectWithTwoParameters(i, j);

	}
}
