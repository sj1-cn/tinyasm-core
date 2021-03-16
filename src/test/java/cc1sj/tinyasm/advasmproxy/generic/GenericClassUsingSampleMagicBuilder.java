package cc1sj.tinyasm.advasmproxy.generic;

import static cc1sj.tinyasm.Adv.*;

import cc1sj.tinyasm.advasmproxy.simple.PojoClass;

public class GenericClassUsingSampleMagicBuilder {

	@SuppressWarnings("unused")
	public void say() {
		GenericClass<PojoClass> pp = __(GenericClass.class, PojoClass.class, "pp", new_(GenericClass.class, PojoClass.class));
		PojoClass pojoClassSample = __("pojoClassSample", new_(PojoClass.class));
		pp.setT(pojoClassSample);
		PojoClass pojoClassSample2 = __("pojoClassSample2", pp.getT());
//		pojoClassSample2.setAgeBoolean(false);
	}

}
