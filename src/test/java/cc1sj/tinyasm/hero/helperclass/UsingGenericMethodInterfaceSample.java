package cc1sj.tinyasm.hero.helperclass;

public class UsingGenericMethodInterfaceSample {

	public void say() {
		GenericMethodInterface pp = null;
		Integer[] iarray = new Integer[1];
		Integer[] warray = pp.toArray(iarray);
	}

}
