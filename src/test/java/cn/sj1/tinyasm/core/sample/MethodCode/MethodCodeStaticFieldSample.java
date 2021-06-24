package cn.sj1.tinyasm.core.sample.MethodCode;

public class MethodCodeStaticFieldSample {
	public static boolean z = true;
	public static byte b = 1;
	public static char c = 1;
	public static short s = 1;
	public static int i = 1;
	public static long l = 1l;
	public static float f = 1f;
	public static double d = 1d;
	public static String str = "str";

	static boolean[] za = new boolean[] { true, false, true, false };
	static byte[] ba = new byte[] { 1, 2, 3, 4, 5 };
	static char[] ca = new char[] { 1, 2, 3, 4, 5 };
	static short[] sa = new short[] { 1, 2, 3, 4, 5 };
	static int[] ia = new int[] { 1, 2, 3, 4, 5 };
	static long[] la = new long[] { 1, 2, 3, 4, 5 };
	static float[] fa = new float[] { 1.1F, 2.1F, 3.1F, 4.1F, 5.1F };
	static double[] da = new double[] { 1.1D, 2.1D, 3.1D, 4.1D, 5.1D };
	static String[] stra = new String[] { "str1", "str2", "str3", "str4", "str5" };

	public void getAll() {
		boolean z = MethodCodeStaticFieldSample.z;
		byte b = MethodCodeStaticFieldSample.b;
		char c = MethodCodeStaticFieldSample.c;
		short s = MethodCodeStaticFieldSample.s;
		int i = MethodCodeStaticFieldSample.i;
		long l = MethodCodeStaticFieldSample.l;
		float f = MethodCodeStaticFieldSample.f;
		double d = MethodCodeStaticFieldSample.d;
		String str = MethodCodeStaticFieldSample.str;

		boolean[] za = MethodCodeStaticFieldSample.za;
		byte[] ba = MethodCodeStaticFieldSample.ba;
		char[] ca = MethodCodeStaticFieldSample.ca;
		short[] sa = MethodCodeStaticFieldSample.sa;
		int[] ia = MethodCodeStaticFieldSample.ia;
		long[] la = MethodCodeStaticFieldSample.la;
		float[] fa = MethodCodeStaticFieldSample.fa;
		double[] da = MethodCodeStaticFieldSample.da;
		String[] stra = MethodCodeStaticFieldSample.stra;

		MethodCodeStaticFieldSample.z = z;
		MethodCodeStaticFieldSample.b = b;
		MethodCodeStaticFieldSample.c = c;
		MethodCodeStaticFieldSample.s = s;
		MethodCodeStaticFieldSample.i = i;
		MethodCodeStaticFieldSample.l = l;
		MethodCodeStaticFieldSample.f = f;
		MethodCodeStaticFieldSample.d = d;
		MethodCodeStaticFieldSample.str = str;
		MethodCodeStaticFieldSample.za = za;
		MethodCodeStaticFieldSample.ba = ba;
		MethodCodeStaticFieldSample.ca = ca;
		MethodCodeStaticFieldSample.sa = sa;
		MethodCodeStaticFieldSample.ia = ia;
		MethodCodeStaticFieldSample.la = la;
		MethodCodeStaticFieldSample.fa = fa;
		MethodCodeStaticFieldSample.da = da;
		MethodCodeStaticFieldSample.stra = stra;

		MethodCodeStaticFieldSample.z = !z;
		MethodCodeStaticFieldSample.b = (byte) (b + 1);
		MethodCodeStaticFieldSample.c = (char) (c + 1);
		MethodCodeStaticFieldSample.s = (short) (s + 1);
		MethodCodeStaticFieldSample.i = i + 1;
		MethodCodeStaticFieldSample.l = l + 1;
		MethodCodeStaticFieldSample.f = f + 1;
		MethodCodeStaticFieldSample.d = d + 1;
		MethodCodeStaticFieldSample.str = str + 1;
		MethodCodeStaticFieldSample.za[0] = !za[0];
		MethodCodeStaticFieldSample.ba[0] = (byte) (ba[0] + 1);
		MethodCodeStaticFieldSample.ca[0] = (char) (ca[0] + 1);
		MethodCodeStaticFieldSample.sa[0] = (short) (sa[0] + 1);
		MethodCodeStaticFieldSample.ia[0] = ia[0] + 1;
		MethodCodeStaticFieldSample.la[0] = la[0] + 1;
		MethodCodeStaticFieldSample.fa[0] = fa[0] + 1;
		MethodCodeStaticFieldSample.da[0] = da[0] + 1;
		MethodCodeStaticFieldSample.stra[0] = stra[0] + 1;
	}
}
