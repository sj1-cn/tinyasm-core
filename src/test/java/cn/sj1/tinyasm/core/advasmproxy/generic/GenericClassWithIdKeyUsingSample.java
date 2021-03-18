package cn.sj1.tinyasm.core.advasmproxy.generic;

public class GenericClassWithIdKeyUsingSample {

	@SuppressWarnings("unused")
	public void say() {
		GenericClassWithIdKey<PojoClassWithIdKey> pp = new GenericClassWithIdKey<>();
		PojoClassWithIdKey pojoClassSample = new PojoClassWithIdKey();
		pp.setT(pojoClassSample);
		PojoClassWithIdKey pojoClassSample2 = pp.getT();
//		pojoClassSample2.setAgeBoolean(false);
	}

}
