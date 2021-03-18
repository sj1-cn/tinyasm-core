package cn.sj1.tinyasm.advasmproxy.generic;

import static cn.sj1.tinyasm.Adv.__;
import static cn.sj1.tinyasm.Adv.new_;

import cn.sj1.tinyasm.advasmproxy.simple.PojoClass;

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
