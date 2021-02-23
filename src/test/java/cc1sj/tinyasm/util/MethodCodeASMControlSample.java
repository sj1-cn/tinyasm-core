package cc1sj.tinyasm.util;

public class MethodCodeASMControlSample {
	byte b = 1;

	public int addInt(long x, long y) {
		if (x > y) {
			b = 1;
		}
		if (x < y) {
			b = 1;
		}
		if (x >= y) {
			b = 1;
		}
		if (x <= y) {
			b = 1;
		}
		if (x != y) {
			b = 1;
		}
		if (x == y) {
			b = 1;
		}
		return b;
	}

	public int addInt(float x, float y) {
		if (x > y) {
			b = 1;
		}
		if (x < y) {
			b = 1;
		}
		if (x >= y) {
			b = 1;
		}
		if (x <= y) {
			b = 1;
		}
		if (x != y) {
			b = 1;
		}
		if (x == y) {
			b = 1;
		}
		return b;
	}

	public int addInt(double x, double y) {
		if (x > y) {
			b = 1;
		}
		if (x < y) {
			b = 1;
		}
		if (x >= y) {
			b = 1;
		}
		if (x <= y) {
			b = 1;
		}
		if (x != y) {
			b = 1;
		}
		if (x == y) {
			b = 1;
		}
		return b;
	}

	public int addInt(int x, int y) {
		if (x > y) {
			b = 1;
		}
		if (x < y) {
			b = 1;
		}
		if (x >= y) {
			b = 1;
		}
		if (x <= y) {
			b = 1;
		}
		if (x != y) {
			b = 1;
		}
		if (x == y) {
			b = 1;
		}
		return b;
	}

	public int addInt(int x) {
		if (x > 0) {
			b = 1;
		}
		if (x < 0) {
			b = 1;
		}
		if (x >= 0) {
			b = 1;
		}
		if (x <= 0) {
			b = 1;
		}
		if (x != 0) {
			b = 1;
		}
		if (x == 0) {
			b = 1;
		}
		return b;
	}

	public int addInt(String x, String y) {
		if (x != y) {
			b = 1;
		}
		if (x == y) {
			b = 1;
		}
		return b;
	}

	public int add_instance(String x, String y) {
		if (x instanceof String) {
			b = 1;
		}
		return b;
	}
	
	public byte addByte(Object o) {
		if (o == null) {
			b = 10;
		}
		if (o != null) {
			b = 100;
		}
		boolean z = true;
		if (z) {
			b = 2;
		}
		if (!z) {
			b = 8;
		}
		if (!(b >= b + 1)) {
			b = 10;
		}
		return b;
	}

}
