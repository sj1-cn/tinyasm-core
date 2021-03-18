package cn.sj1.tinyasm.core.util;

public class MethodCodeASMMathStaticSample {
	static byte b = 1;
	static char c = 1;
	static short s = 1;
	static int i = 1;
	static long l = 1l;
	static float f = 1f;
	static double d = 1d;

	static byte b3 = 3;
	static char c3 = 3;
	static short s3 = 3;
	static int i3 = 3;
	static long l3 = 3l;
	static float f3 = 3f;
	static double d3 = 3d;

	static float f31 = 3.1f;
	static double d31 = 3.1d;

	static byte b0 = 0;
	static char c0 = 0;
	static short s0 = 0;
	static int i0 = 0;
	static long l1 = 0l;
	static float f1 = 0f;
	static double d1 = 0d;

	static byte bn1 = -1;
//static char cn1 = -1;
	static short sn1 = -1;
	static int in1 = -1;
	static long ln1 = -1l;
	static float fn1 = -1f;
	static double dn1 = -1d;

	static public int addInt(int x, int y) {
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

	static public byte addByte(byte x, byte y) {
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

	static public short addShort(short x, short y) {
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

	static public long addLong(long x, long y) {
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

	static public char mathChar(char x, char y) {
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

	static public float mathFloat(float x, float y) {
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

	static public double mathDouble(double x, double y) {
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
