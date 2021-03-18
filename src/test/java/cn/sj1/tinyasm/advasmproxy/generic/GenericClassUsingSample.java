package cn.sj1.tinyasm.advasmproxy.generic;

import cn.sj1.tinyasm.advasmproxy.simple.PojoClass;

public class GenericClassUsingSample {

	@SuppressWarnings("unused")
	public void say() {
		GenericClass<PojoClass> pp = new GenericClass<>();
		PojoClass pojoClassSample = new PojoClass();
		pp.setT(pojoClassSample);
		PojoClass pojoClassSample2 = pp.getT();
//		pojoClassSample2.setAgeBoolean(false);
	}

}
