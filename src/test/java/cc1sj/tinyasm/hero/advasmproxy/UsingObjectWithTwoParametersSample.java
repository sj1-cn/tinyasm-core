package cc1sj.tinyasm.hero.advasmproxy;

import cc1sj.tinyasm.hero.helperclass.ObjectWithTwoParametersSample;

public class UsingObjectWithTwoParametersSample {
	@SuppressWarnings("unused")
	public void test() {

		ObjectWithTwoParametersSample p1 = new ObjectWithTwoParametersSample(3, 3);
		int i = 10;
		int j = 20;
		ObjectWithTwoParametersSample p2 = new ObjectWithTwoParametersSample(i, j);

	}
}
