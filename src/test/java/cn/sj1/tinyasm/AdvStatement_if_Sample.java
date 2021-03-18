package cn.sj1.tinyasm;

public class AdvStatement_if_Sample {

	public void testIfThen() {
		int iGT = 20;
		if (iGT > 10) {
			iGT--;
		}

		int iGE = 20;
		if (iGE >= 10) {
			iGE--;
		}

		int iEQ = 20;
		if (iEQ == 10) {
			iEQ++;
		}
		
		int iNE = 20;
		if (iNE != 10) {
			iNE++;
		}

		int iLE = 20;
		if (iLE <= 10) {
			iLE++;
		}

		int iLT = 20;
		if (iLT < 10) {
			iLT++;
		}
	}

	public void testIfThenElse() {
		int iGT = 20;
		if (iGT > 10) {
			iGT--;
		} else {
			iGT++;
		}

		int iGE = 20;
		if (iGE >= 10) {
			iGE--;
		} else {
			iGE++;
		}

		int iEQ = 20;
		if (iEQ == 10) {
			iEQ++;
		} else {
			iEQ++;
		}

		int iNE = 20;
		if (iNE != 10) {
			iNE++;
		} else {
			iNE--;
		}

		int iLE = 20;
		if (iLE <= 10) {
			iLE++;
		} else {
			iLE++;
		}

		int iLT = 20;
		if (iLT < 10) {
			iLT++;
		} else {
			iLT++;
		}
	}
}
