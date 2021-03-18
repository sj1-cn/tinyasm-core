package cn.sj1.tinyasm.util;

public class BoxUnboxSample {
	public void funcLong(Long l) {
		Long ll = l;
		l = ll + 1;
	}

	public void funclong(long l) {
		Long ll = l;
		l = ll + 1;
	}

	public void init() {
		long l=10;
		Long ll = 100L;
		funclong(l);
		funcLong(ll);
		funclong(1);
		funcLong(2L);
	}
}
