package cn.sj1.tinyasm.advasmproxy.generic;

import static cn.sj1.tinyasm.Adv.__;
import static cn.sj1.tinyasm.Adv.new_;

import cn.sj1.tinyasm.advasmproxy.simple.PojoClass;
import cn.sj1.tinyasm.advasmproxy.simple.PojoClassChild;

public class GenericInterfaceImplUsingSampleMagicBuilder {

	@SuppressWarnings("unused")
	public void say() {
		GenericInterfaceImpl pp = __("pp", new_(GenericInterfaceImpl.class));
		PojoClass pojoClassSample = __("pojoClassSample", new_(PojoClass.class));
		pp.setT(pojoClassSample);
		PojoClass pojoClassSample2 = __("pojoClassSample2", pp.getT());
//		pojoClassSample2.setAgeBoolean(false);
		PojoClassChild pojoClassChildSample = __("pojoClassChildSample", pp.getPojoClassChildSample());
		pp.setPojoClassChildSample(pojoClassChildSample);

	}

}
