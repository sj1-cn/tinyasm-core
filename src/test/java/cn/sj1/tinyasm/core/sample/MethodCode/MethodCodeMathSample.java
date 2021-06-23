package cn.sj1.tinyasm.core.sample.MethodCode;

public class MethodCodeMathSample {
	byte b = 1;
	char c = 1;
	short s = 1;
	int i = 1;
	long l = 1l;
	float f = 1f;
	double d = 1d;
	
	byte b3 = 3;
	char c3 = 3;
	short s3 = 3;
	int i3 = 3;
	long l3 = 3l;
	float f3 = 3f;
	double d3 = 3d;
	
	float f31 = 3.1f;
	double d31 = 3.1d;
	
	byte b0 = 0;
	char c0 = 0;
	short s0 = 0;
	int i0 = 0;
	long l1 = 0l;
	float f1 = 0f;
	double d1 = 0d;
	
	byte bn1 = -1;
//	char cn1 = -1;
	short sn1 = -1;
	int in1 = -1;
	long ln1 = -1l;
	float fn1 = -1f;
	double dn1 = -1d;

	public int addInt(int x, int y) {
		int z;
		z = x + y;
		z = x * y;
		z = x - y;
		z = x / y;
		z = x % y;
		z = x & y;
		z = x | y;
		z = x ^ y;
		z = x << y;
		z = x >> y;

		z = (int) b;
		z = (int) c;
		z = (int) s;
		z = (int) i;
		z = (int) f;
		z = (int) d;
		
		z = (int) -b;
		z = (int) -c;
		z = (int) -s;
		z = (int) -i;
		z = (int) -f;
		z = (int) -d;
		return z;
	}

	public byte addByte(byte x, byte y) {
		byte z;
		z = (byte) (x + y);
		z = (byte) (x * y);
		z = (byte) (x - y);
		z = (byte) ((byte) x / y);
		z = (byte) (x % y);
		z = (byte) (x & y);
		z = (byte) (x | y);
		z = (byte) (x ^ y);

		z = (byte) b;
		z = (byte) c;
		z = (byte) s;
		z = (byte) i;
		z = (byte) f;
		z = (byte) d;
		
		return z;
	}

	public short addShort(short x, short y) {
		short z;
		z = (short) (x + y);
		z = (short) (x * y);
		z = (short) (x - y);
		z = (short) ((short) x / y);
		z = (short) (x % y);
		z = (short) (x & y);
		z = (short) (x | y);
		z = (short) (x ^ y);

		z = (short) b;
		z = (short) c;
		z = (short) s;
		z = (short) i;
		z = (short) f;
		z = (short) d;
		return z;
	}

	public long addLong(long x, long y) {
		long z;
		z = (long) (x + y);
		z = (long) (x * y);
		z = (long) (x - y);
		z = (long) ((long) x / y);
		z = (long) ((long) x % y);
		z = (long) (x & y);
		z = (long) (x | y);
		z = (long) (x ^ y);

		z = (long) b;
		z = (long) c;
		z = (long) s;
		z = (long) i;
		z = (long) f;
		z = (long) d;
		return z;
	}

	public char mathChar(char x, char y) {
		char z;
		z = (char) (x + y);
		z = (char) (x * y);
		z = (char) (x - y);
		z = (char) ((char) x / y);
		z = (char) ((char) x % y);
		z = (char) (x & y);
		z = (char) (x | y);
		z = (char) (x ^ y);

		z = (char) b;
		z = (char) c;
		z = (char) s;
		z = (char) i;
		z = (char) f;
		z = (char) d;
		return z;
	}
	
	public float mathFloat(float x, float y) {
		float z;
		z = (float) (x + y);
		z = (float) (x * y);
		z = (float) (x - y);
		z = (float) ((float) x / y);
		z = (float) ((float) x % y);
//		z = (float) (x & i);
//		z = (float) (x | i);
//		z = (float) (x ^ i);

		z = (float) b;
		z = (float) c;
		z = (float) s;
		z = (float) i;
		z = (float) f;
		z = (float) d;
		return z;
	}

	public double mathDouble(double x, double y) {
		double z;
		z = (double) (x + y);
		z = (double) (x * y);
		z = (double) (x - y);
		z = (double) ((double) x / y);
		z = (double) ((double) x % y);
//		z = (double) (x & i);
//		z = (double) (x | i);
//		z = (double) (x ^ i);

		z = (double) b;
		z = (double) c;
		z = (double) s;
		z = (double) i;
		z = (double) f;
		z = (double) d;
		return z;
	}
}
