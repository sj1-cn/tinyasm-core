package cn.sj1.tinyasm.core.util;

public class BoxUnboxSample {
	boolean z = true;
	byte b = 1;
	char c = 1;
	short s = 1;
	int i = 1;
	long l = 1l;
	float f = 1f;
	double d = 1d;

	public void exec() {
		zFunc(this.z);
		bFunc(this.b);
		cFunc(this.c);
		sFunc(this.s);
		iFunc(this.i);
		lFunc(this.l);
		fFunc(this.f);
		dFunc(this.d);
	}

	boolean zFunc(Boolean oz) {
		return oz;
	}//true;

	byte bFunc(Byte ob) {
		return ob;
	}//1;

	char cFunc(Character oc) {
		return oc;
	}//1;

	short sFunc(Short os) {
		return os;
	}//1;

	int iFunc(Integer oi) {
		return oi;
	}//1;

	long lFunc(Long ol) {
		return ol;
	}//1l;

	float fFunc(Float of) {
		return of;
	}//1f;

	double dFunc(Double od) {
		return od;
	}//1d;

}
