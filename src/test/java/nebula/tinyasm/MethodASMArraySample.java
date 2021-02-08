package nebula.tinyasm;

public class MethodASMArraySample {
	private byte[] ba;
	private char[] ca;
	private short[] sa;
	private int[] ia;
	private long[] la;
	private float[] fa;
	private double[] da;
	private String[] stra;

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
