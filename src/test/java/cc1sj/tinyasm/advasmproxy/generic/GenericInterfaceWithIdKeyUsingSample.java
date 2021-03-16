package cc1sj.tinyasm.advasmproxy.generic;

public class GenericInterfaceWithIdKeyUsingSample {

	@SuppressWarnings("unused")
	public void say() {
		GenericInterfaceWithIdKey<PojoClassWithIdKey> pp = new GenericClassWithIdKey<>();
		PojoClassWithIdKey pojoClassSample = new PojoClassWithIdKey();
		pp.setT(pojoClassSample);
		PojoClassWithIdKey pojoClassSample2 = pp.getT();
//		pojoClassSample2.setAgeBoolean(false);
	}

}
