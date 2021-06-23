package cn.sj1.tinyasm.core.sample.MethodCode;

public class MethodCodeShSample {

	public void getAll() {

		int i = 1;
		long l = 1l;

		i = i >> 10;
		l = l >> 10;

		i = i << 4;
		l = l << 4;

		i = i | 10;
		i = i & 10;
		l = l | 10;
		l = l & 10;

	}
}
