package nebula.tinyasm;

import java.util.List;


class ASMUtils {

	static public boolean is(int access, int modified) {
		return (access & modified) > 0;
	}
	public static int[] computerLocalsVariable(List<LocalsVariable> fields) {
		int max = 0;
		for (int i = 0; i < fields.size(); i++) {
			max += fields.get(i).type.getSize();
		}

		int[] localsVar = new int[max];
		int cntLocal = 0;
		for (int i = 0; i < fields.size(); i++) {
			localsVar[cntLocal] = i;
			cntLocal += fields.get(i).type.getSize();
		}
		return localsVar;
	}


}

