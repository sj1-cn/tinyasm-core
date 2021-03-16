package cc1sj.tinyasm.advasmproxy.generic;

import cc1sj.tinyasm.advasmproxy.simple.PojoClassChild;
import cc1sj.tinyasm.advasmproxy.simple.PojoClass;

public class GenericInterfaceImplUsingSample {

	@SuppressWarnings("unused")
	public void say() {
		GenericInterfaceImpl pp = new GenericInterfaceImpl();
		PojoClass pojoClassSample = new PojoClass();
		pp.setT(pojoClassSample);
		PojoClass pojoClassSample2 = pp.getT();
//		pojoClassSample2.setAgeBoolean(false);
		PojoClassChild pojoClassChildSample = pp.getPojoClassChildSample();
		pp.setPojoClassChildSample(pojoClassChildSample);
		
	}

}
