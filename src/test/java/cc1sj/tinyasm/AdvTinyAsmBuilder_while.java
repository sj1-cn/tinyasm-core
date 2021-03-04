package cc1sj.tinyasm;

public class TinyAsmBuilder_while {
	public void test() {
		int iGT = 20;
		while (iGT > 10) {
			iGT--;
		}

		int iGE = 20;
		while (iGE >= 10) {
			iGE--;
		}

		int iEQ = 10;
		while (iEQ == 10) {
			iEQ++;
		}

		int iLE = 0;
		while (iLE <= 10) {
			iLE++;
		}

		int iLT = 0;
		while (iLT < 10) {
			iLT++;
		}
	}
}
