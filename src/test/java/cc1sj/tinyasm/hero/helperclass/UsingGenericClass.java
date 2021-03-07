package cc1sj.tinyasm.hero.helperclass;

public class UsingGenericClass {

	public void say() {
		GenericInterface<PojoClassSample> pp = new GenericClass<>();
		PojoClassSample pojoClassSample = new PojoClassSample();
		pp.setT(pojoClassSample);
		PojoClassSample pojoClassSample2 = pp.getT();
		pojoClassSample2.setAgeBoolean(false);
	}

}
