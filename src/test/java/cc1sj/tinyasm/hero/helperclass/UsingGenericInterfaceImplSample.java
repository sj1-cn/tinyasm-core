package cc1sj.tinyasm.hero.helperclass;

public class UsingGenericInterfaceImplSample {

	public void say() {
		GenericInterfaceImplSample pp = new GenericInterfaceImplSample();
		PojoClassSample pojoClassSample = new PojoClassSample();
		pp.setT(pojoClassSample);
		PojoClassSample pojoClassSample2 = pp.getT();
		pojoClassSample2.setAgeBoolean(false);
		PojoClassChildSample pojoClassChildSample = pp.getPojoClassChildSample();
		pp.setPojoClassChildSample(pojoClassChildSample);
		
	}

}
