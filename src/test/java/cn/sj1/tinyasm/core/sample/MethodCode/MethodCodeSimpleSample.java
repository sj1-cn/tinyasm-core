package cn.sj1.tinyasm.core.sample.MethodCode;

public class MethodCodeSimpleSample {
	private byte b;
	private char c;
	private short s;
	private int i;
	private long l;
	private float f;
	private double d;
	@SuppressWarnings("unused")
	private String str;

	public int getField() {
		int x = this.b + this.i;
		return x;
	}

	public int getFieldAll() {
		int x = (int) (this.b + this.c + this.s + this.i + this.l + this.f + this.d);
		return x;
	}

	public int getFieldConst() {
		b = 100;
		c = 1000;
		s = 10000;
		i = 100000;
		l = 1000000l;
		f = 10000000f;
		d = 100000000d;
		str = "1000000000s";
		return (int) (b + c + s + i + l + f + d);
	}

	public int getFieldIConst() {
		b = 0;
		b = 1;
		b = 2;
		b = 3;
		b = 4;
		b = 5;
		b = 6;
		b = 7;
		b = 8;
		b = -4;
		b = -3;
		b = -2;
		b = -1;
		return b;
	}

	public byte retByte() {
		byte x = 1;
		x = (byte) (x + 1);
		b = 10;
		x = b;
		byte y = (byte) (b + x);
		return y;
	}
}
