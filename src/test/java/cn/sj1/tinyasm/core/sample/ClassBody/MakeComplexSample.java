package cn.sj1.tinyasm.core.sample.ClassBody;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@TestAnnotation
public class MakeComplexSample extends ArrayList<String> implements List<String> {
	private byte b;
	private char c;
	private short s;
	private int i;
	private long l;
	private float f;
	private double d;
	private String str;

	public MakeComplexSample(byte b, char c, short s, int i, long l, float f, double d, String str) {
		super();
		this.b = b;
		this.c = c;
		this.s = s;
		this.i = i;
		this.l = l;
		this.f = f;
		this.d = d;
		this.str = str;
	}

	public void math(byte b, char c, short s, int i, long l, float f, double d) {
		byte bx = 10;
		char cx = 10;
		short sx = 10;
		int ix = 10;
		long lx = 10L;
		float fx = 10.0F;
		double dx = 10.01D;

		b = (byte) (b + bx);
		b = (byte) (b - bx);
		b = (byte) (b * bx);
		b = (byte) (b / bx);
		b = (byte) (b % bx);
		b = (byte) (b & bx);
		b = (byte) (b ^ bx);
		b = (byte) (b << 1);
		b = (byte) (b >> 1);

		c = (char) (c + cx);
		c = (char) (c - cx);
		c = (char) (c * cx);
		c = (char) (c / cx);
		c = (char) (c % cx);
		c = (char) (c & cx);
		c = (char) (c ^ cx);
		c = (char) (c << 1);
		c = (char) (c >> 1);

		s = (short) (s + sx);
		s = (short) (s - sx);
		s = (short) (s * sx);
		s = (short) (s / sx);
		s = (short) (s % sx);
		s = (short) (s & sx);
		s = (short) (s ^ sx);
		s = (short) (s << 1);
		s = (short) (s >> 1);

		i = (i + ix);
		i = (i - ix);
		i = (i * ix);
		i = (i / ix);
		i = (i % ix);
		i = (i & ix);
		i = (i ^ ix);
		i = (i << 1);
		i = (i >> 1);

		l = (l + lx);
		l = (l - lx);
		l = (l * lx);
		l = (l / lx);
		l = (l % lx);
		l = (l & lx);
		l = (l ^ lx);
		l = (l << 1);
		l = (l >> 1);

		f = (f + fx);
		f = (f - fx);
		f = (f * fx);
		f = (f / fx);
		f = (f % fx);

		d = (d + dx);
		d = (d - dx);
		d = (d * dx);
		d = (d / dx);
		d = (d % dx);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + b;
		result = prime * result + c;
		long temp;
		temp = Double.doubleToLongBits(d);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(f);
		result = prime * result + i;
		result = prime * result + (int) (l ^ (l >>> 32));
		result = prime * result + s;
		result = prime * result + ((str == null) ? 0 : str.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		MakeComplexSample other = (MakeComplexSample) obj;
		if (b != other.b) return false;
		if (c != other.c) return false;
		if (Double.doubleToLongBits(d) != Double.doubleToLongBits(other.d)) return false;
		if (Float.floatToIntBits(f) != Float.floatToIntBits(other.f)) return false;
		if (i != other.i) return false;
		if (l != other.l) return false;
		if (s != other.s) return false;
		if (str == null) {
			if (other.str != null) return false;
		} else if (!str.equals(other.str)) return false;
		return true;
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
		return "MakePojo [b=" + b + ", c=" + c + ", s=" + s + ", i=" + i + ", l=" + l + ", f=" + f + ", d=" + d
				+ ", str=" + str + "]";
	}

}
