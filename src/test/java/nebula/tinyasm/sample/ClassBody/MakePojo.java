package nebula.tinyasm.sample.ClassBody;

@TestAnnotation
public class MakePojo {
	private byte b;
	private char c;
	private short s;
	private int i;
	private long l;
	private float f;
	private double d;
	private String str;

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

	public void setB(byte b) {
		this.b = b;
	}

	public void setC(char c) {
		this.c = c;
	}

	public void setS(short s) {
		this.s = s;
	}

	public void setI(int i) {
		this.i = i;
	}

	public void setL(long l) {
		this.l = l;
	}

	public void setF(float f) {
		this.f = f;
	}

	public void setD(double d) {
		this.d = d;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MakePojo [b=").append(b)
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
