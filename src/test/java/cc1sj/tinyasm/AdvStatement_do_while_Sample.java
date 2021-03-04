package cc1sj.tinyasm;

public class AdvStatement_do_while_Sample {
	public void test() {
		int iGT = 20;
		do {
			iGT--;
		} while (iGT > 10);

		int iGE = 20;
		do {
			iGE--;
		} while (iGE >= 10);

		int iEQ = 20;
		do {
			iEQ++;
		} while (iEQ == 10);
		int iNE = 20;
		do {
			iNE++;
		} while (iNE != 10);

		int iLE = 20;
		do {
			iLE++;
		} while (iLE <= 10);

		int iLT = 20;
		do {
			iLT++;
		} while (iLT < 10);
	}
}
