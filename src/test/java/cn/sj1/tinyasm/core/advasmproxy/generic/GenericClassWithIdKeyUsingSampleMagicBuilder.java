package cn.sj1.tinyasm.core.advasmproxy.generic;

import static cn.sj1.tinyasm.core.Adv.__;
import static cn.sj1.tinyasm.core.Adv.new_;

public class GenericClassWithIdKeyUsingSampleMagicBuilder {

	@SuppressWarnings("unused")
	public void say() {
		GenericClassWithIdKey<PojoClassWithIdKey> pp = __(GenericClassWithIdKey.class, PojoClassWithIdKey.class, "pp", new_(GenericClassWithIdKey.class, PojoClassWithIdKey.class));
		PojoClassWithIdKey pojoClassSample = __("pojoClassSample", new_(PojoClassWithIdKey.class));
		pp.setT(pojoClassSample);
		PojoClassWithIdKey pojoClassSample2 = __("pojoClassSample2", pp.getT());
//		pojoClassSample2.setAgeBoolean(false);
	}

}
