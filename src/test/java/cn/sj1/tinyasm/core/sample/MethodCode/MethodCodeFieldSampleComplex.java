package cn.sj1.tinyasm.core.sample.MethodCode;

public class MethodCodeFieldSampleComplex {

	MethodCodeFieldSample methodCodeFieldSample = new MethodCodeFieldSample();

	public void getAll() {
		boolean z = methodCodeFieldSample.z;
		byte b = methodCodeFieldSample.b;
		char c = methodCodeFieldSample.c;
		short s = methodCodeFieldSample.s;
		int i = methodCodeFieldSample.i;
		long l = methodCodeFieldSample.l;
		float f = methodCodeFieldSample.f;
		double d = methodCodeFieldSample.d;
		String str = methodCodeFieldSample.str;

		methodCodeFieldSample.z = z;
		methodCodeFieldSample.b = b;
		methodCodeFieldSample.c = c;
		methodCodeFieldSample.s = s;
		methodCodeFieldSample.i = i;
		methodCodeFieldSample.l = l;
		methodCodeFieldSample.f = f;
		methodCodeFieldSample.d = d;
		methodCodeFieldSample.str = str;

		methodCodeFieldSample.z = !z;
		methodCodeFieldSample.b = (byte) (b + 1);
		methodCodeFieldSample.c = (char) (c + 1);
		methodCodeFieldSample.s = (short) (s + 1);
		methodCodeFieldSample.i = i + 1;
		methodCodeFieldSample.l = l + 1;
		methodCodeFieldSample.f = f + 1;
		methodCodeFieldSample.d = d + 1;
		methodCodeFieldSample.str = str + 1;

		boolean[] za = methodCodeFieldSample.za;
		byte[] ba = methodCodeFieldSample.ba;
		char[] ca = methodCodeFieldSample.ca;
		short[] sa = methodCodeFieldSample.sa;
		int[] ia = methodCodeFieldSample.ia;
		long[] la = methodCodeFieldSample.la;
		float[] fa = methodCodeFieldSample.fa;
		double[] da = methodCodeFieldSample.da;
		String[] stra = methodCodeFieldSample.stra;

		methodCodeFieldSample.za = za;
		methodCodeFieldSample.ba = ba;
		methodCodeFieldSample.ca = ca;
		methodCodeFieldSample.sa = sa;
		methodCodeFieldSample.ia = ia;
		methodCodeFieldSample.la = la;
		methodCodeFieldSample.fa = fa;
		methodCodeFieldSample.da = da;
		methodCodeFieldSample.stra = stra;

		methodCodeFieldSample.za[0] = !za[0];
		methodCodeFieldSample.ba[0] = (byte) (ba[0] + 1);
		methodCodeFieldSample.ca[0] = (char) (ca[0] + 1);
		methodCodeFieldSample.sa[0] = (short) (sa[0] + 1);
		methodCodeFieldSample.ia[0] = ia[0] + 1;
		methodCodeFieldSample.la[0] = la[0] + 1;
		methodCodeFieldSample.fa[0] = fa[0] + 1;
		methodCodeFieldSample.da[0] = da[0] + 1;
		methodCodeFieldSample.stra[0] = stra[0] + 1;
	}
}
