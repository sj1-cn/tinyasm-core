package cc1sj.tinyasm;

public class AdvAsmBuilder_if {

	public void testIfThen() {
		int iGT = 20;
		if (iGT > 10) {
			iGT--;
		}

		int iGE = 20;
		if (iGE >= 10) {
			iGE--;
		}

		int iEQ = 10;
		if (iEQ == 10) {
			iEQ++;
		}
		
		int iNE = 10;
		if (iNE != 10) {
			iNE++;
		}

		int iLE = 0;
		if (iLE <= 10) {
			iLE++;
		}

		int iLT = 0;
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

		int iEQ = 10;
		if (iEQ == 10) {
			iEQ++;
		} else {
			iEQ++;
		}

		int iNE = 10;
		if (iNE != 10) {
			iNE++;
		} else {
			iNE--;
		}

		int iLE = 0;
		if (iLE <= 10) {
			iLE++;
		} else {
			iLE++;
		}

		int iLT = 0;
		if (iLT < 10) {
			iLT++;
		} else {
			iLT++;
		}
	}
}
