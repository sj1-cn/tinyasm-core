package nebula.tinyasm.sample.MethodCode;

public class InvokeSample {
	private int i = 0;
	private int j = 0;
	@SuppressWarnings("unused")
	private long l = 0l;
	@SuppressWarnings("unused")
	private Long L;

	public void run() {
		long kl = 0L;
		Long kL = 0L;
		L = kl;
		l = kL;

		invokeVoid();
		invokeVoid(i);
		invokeVoid(j, i);
		invokeVoid(i);
		invokeVoid(j, i);
		invokeVoid(i);
		invokeVoid(j, i);
		invokeVoid(i);
		invokeVoid(j, i);
	}

	public void boxUnbox() {
		boolean z = false;
		byte b = 0;
		char c = 'a';
		short s = (short) 1;
		int i = 1;
		long l = 1L;
		float f = 0.1f;
		double d = 0.1d;
		String str = "str";
		Boolean Z = z;
		Byte B = b;
		Character C = c;
		Short S = s;
		Integer I = i;
		Long L = l;
		Float F = f;
		Double D = d;
		String STR = str;

		z = Z;
		b = B;
		c = C;
		s = S;
		i = I;
		l = L;
		f = F;
		d = D;
		str = STR;
	}

	public void invokeVoid() {
		int k = 10;
		i = k + i;
	}

	public void invokeVoid(int p1) {
		i = p1 + i;
	}

	public void invokeVoid(int p1, int p2) {
		i = p1 + i + p2;
	}
}
