package cn.sj1.tinyasm.core.sample.MethodCode;

public class MethodCodeFieldSample {
	 boolean z = true;
	 byte b = 1;
	 char c = 1;
	 short s = 1;
	 int i = 1;
	 long l = 1l;
	 float f = 1f;
	 double d = 1d;
	 String str = "str";

	 boolean[] za = new boolean[] { true, false, true, false };
	 byte[] ba = new byte[] { 1, 2, 3, 4, 5 };
	 char[] ca = new char[] { 1, 2, 3, 4, 5 };
	 short[] sa = new short[] { 1, 2, 3, 4, 5 };
	 int[] ia = new int[] { 1, 2, 3, 4, 5 };
	 long[] la = new long[] { 1, 2, 3, 4, 5 };
	 float[] fa = new float[] { 1.1F, 2.1F, 3.1F, 4.1F, 5.1F };
	 double[] da = new double[] { 1.1D, 2.1D, 3.1D, 4.1D, 5.1D };
	 String[] stra = new String[] { "str1", "str2", "str3", "str4", "str5" };

	public void getAll() {
		boolean z = this.z;
		byte b = this.b;
		char c = this.c;
		short s = this.s;
		int i = this.i;
		long l = this.l;
		float f = this.f;
		double d = this.d;
		String str = this.str;

		this.z = z;
		this.b = b;
		this.c = c;
		this.s = s;
		this.i = i;
		this.l = l;
		this.f = f;
		this.d = d;
		this.str = str;

		this.z = !z;
		this.b = (byte) (b + 1);
		this.c = (char) (c + 1);
		this.s = (short) (s + 1);
		this.i = i + 1;
		this.l = l + 1;
		this.f = f + 1;
		this.d = d + 1;
		this.str = str + 1;

		boolean[] za = this.za;
		byte[] ba = this.ba;
		char[] ca = this.ca;
		short[] sa = this.sa;
		int[] ia = this.ia;
		long[] la = this.la;
		float[] fa = this.fa;
		double[] da = this.da;
		String[] stra = this.stra;
		
		this.za = za;
		this.ba = ba;
		this.ca = ca;
		this.sa = sa;
		this.ia = ia;
		this.la = la;
		this.fa = fa;
		this.da = da;
		this.stra = stra;

		this.za[0] = !za[0];
		this.ba[0] = (byte) (ba[0] + 1);
		this.ca[0] = (char) (ca[0] + 1);
		this.sa[0] = (short) (sa[0] + 1);
		this.ia[0] = ia[0] + 1;
		this.la[0] = la[0] + 1;
		this.fa[0] = fa[0] + 1;
		this.da[0] = da[0] + 1;
		this.stra[0] = stra[0] + 1;
	}
}