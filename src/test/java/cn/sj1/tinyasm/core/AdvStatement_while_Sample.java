package cn.sj1.tinyasm.core;

public class AdvStatement_while_Sample {
	public void test() {
		int iGT = 20;
		while (iGT > 10) {
			iGT--;
		}

		int iGE = 20;
		while (iGE >= 10) {
			iGE--;
		}

		int iEQ = 20;
		while (iEQ == 10) {
			iEQ++;
		}
		int iNE = 20;
		while (iNE != 10) {
			iNE++;
		}

		int iLE = 20;
		while (iLE <= 10) {
			iLE++;
		}

		int iLT = 20;
		while (iLT < 10) {
			iLT++;
		}
	}
}
