package cn.sj1.tinyasm.core.advasmproxy.generic;

import cn.sj1.tinyasm.core.advasmproxy.simple.PojoClass;
import cn.sj1.tinyasm.core.advasmproxy.simple.PojoClassChild;

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
