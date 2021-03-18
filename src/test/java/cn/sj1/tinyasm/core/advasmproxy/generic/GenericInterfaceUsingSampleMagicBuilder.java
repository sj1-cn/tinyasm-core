package cn.sj1.tinyasm.core.advasmproxy.generic;

import static cn.sj1.tinyasm.core.Adv.__;
import static cn.sj1.tinyasm.core.Adv.new_;

import cn.sj1.tinyasm.core.advasmproxy.simple.PojoClass;

public class GenericInterfaceUsingSampleMagicBuilder {

	@SuppressWarnings("unused")
	public void say() {
		GenericInterface<PojoClass> pp = __(GenericInterface.class, PojoClass.class, "pp", new_(GenericClass.class, PojoClass.class));
		PojoClass pojoClassSample = __("pojoClassSample", new_(PojoClass.class));
		pp.setT(pojoClassSample);
		PojoClass pojoClassSample2 = __("pojoClassSample2", pp.getT());
//		pojoClassSample2.setAgeBoolean(false);
	}

}
