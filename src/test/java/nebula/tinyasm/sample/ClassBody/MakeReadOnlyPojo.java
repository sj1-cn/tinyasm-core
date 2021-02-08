package nebula.tinyasm.sample.ClassBody;

public class MakeReadOnlyPojo {
	private byte b;
	private char c;
	private short s;
	private int i;
	private long l;
	private float f;
	private double d;
	private String str;

	public MakeReadOnlyPojo(byte b, char c, short s, int i, long l, float f, double d, String str) {
		this.b = b;
		this.c = c;
		this.s = s;
		this.i = i;
		this.l = l;
		this.f = f;
		this.d = d;
		this.str = str;
	}

	public byte getB() {
		return b;
	}

	public char getC() {
		return c;
	}

	public short getS() {
		return s;
	}

	public int getI() {
		return i;
	}

	public long getL() {
		return l;
	}

	public float getF() {
		return f;
	}

	public double getD() {
		return d;
	}

	public String getStr() {
		return str;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MakeReadOnlyPojo [b=").append(b)
				.append(", c=").append(c)
				.append(", s=").append(s)
				.append(", i=").append(i)
				.append(", l=").append(l)
				.append(", f=").append(f)
				.append(", d=").append(d)
				.append(", str=").append(str)
				.append("]");
		return builder.toString();
	}

}
