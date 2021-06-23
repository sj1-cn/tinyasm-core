package cn.sj1.tinyasm.core.sample.MethodCode;

public class MethodCodeArraySample {
	boolean[] za = new boolean[] { true, false, true, false };
	byte[] ba = new byte[] { 1, 2, 3, 4, 5 };
	char[] ca = new char[] { 1, 2, 3, 4, 5 };
	short[] sa = new short[] { 1, 2, 3, 4, 5 };
	int[] ia = new int[] { 1, 2, 3, 4, 5 };
	long[] la = new long[] { 1, 2, 3, 4, 5 };
	float[] fa = new float[] { 1.1F, 2.1F, 3.1F, 4.1F, 5.1F };
	double[] da = new double[] { 1.1D, 2.1D, 3.1D, 4.1D, 5.1D };
	private String[] stra = new String[] { "str1", "str2", "str3", "str4", "str5" };

	public void init() {
		ba = new byte[10];
		ca = new char[10];
		sa = new short[10];
		ia = new int[10];
		la = new long[10];
		fa = new float[10];
		da = new double[10];
		stra = new String[10];
	}

	public void setArrayValue() {
		ba[0] = 100;
		ca[0] = 1000;
		sa[0] = 10000;
		ia[0] = 100000;
		la[0] = 1000000l;
		fa[0] = 10000000f;
		da[0] = 100000000d;
		stra[0] = "1000000000s";
	}

	public void getArrayValue() {
		ba[1] = ba[0];
		ca[1] = ca[0];
		sa[1] = sa[0];
		ia[1] = ia[0];
		la[1] = la[0];
		fa[1] = fa[0];
		da[1] = da[0];
		stra[1] = stra[0];
	}
}
