package cn.sj1.tinyasm.core.advasmproxy.generic;

import cn.sj1.tinyasm.core.advasmproxy.simple.PojoClass;

public class GenericInterfaceUsingSample {

	@SuppressWarnings("unused")
	public void say() {
		GenericInterface<PojoClass> pp = new GenericClass<>();
		PojoClass pojoClassSample = new PojoClass();
		pp.setT(pojoClassSample);
		PojoClass pojoClassSample2 = pp.getT();
//		pojoClassSample2.setAgeBoolean(false);
	}

}