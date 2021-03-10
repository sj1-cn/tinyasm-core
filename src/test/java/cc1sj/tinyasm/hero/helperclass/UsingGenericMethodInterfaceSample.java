package cc1sj.tinyasm.hero.helperclass;

public class UsingGenericMethodInterfaceSample {

	@SuppressWarnings("unused")
	public void say(GenericMethodInterface<PojoClassSample> pp) {
		Integer[] iarray = new Integer[1];
		Integer[] warray = pp.toArray(iarray);
	}

}
