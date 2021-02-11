package nebula.tinyasm.util;

public class SimpleSample {
	private int i = 0;

	public SimpleSample() {

	}

	public void dd() {
		int j = 1;
		i = 1;
		i = j + 10;
		j = i + 10;
	}

	public void methodWith1Param(int i) {
		this.i = i;
	}
}
