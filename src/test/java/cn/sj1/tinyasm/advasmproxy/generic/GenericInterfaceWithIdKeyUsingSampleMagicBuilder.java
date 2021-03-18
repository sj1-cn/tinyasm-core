package cn.sj1.tinyasm.advasmproxy.generic;

import static cn.sj1.tinyasm.Adv.__;
import static cn.sj1.tinyasm.Adv.new_;

public class GenericInterfaceWithIdKeyUsingSampleMagicBuilder {

	@SuppressWarnings("unused")
	public void say() {
		GenericInterfaceWithIdKey<PojoClassWithIdKey> pp = __(GenericInterfaceWithIdKey.class, PojoClassWithIdKey.class, "pp", new_(GenericClassWithIdKey.class, PojoClassWithIdKey.class));
		PojoClassWithIdKey pojoClassSample = __("pojoClassSample", new_(PojoClassWithIdKey.class));
		pp.setT(pojoClassSample);
		PojoClassWithIdKey pojoClassSample2 = __("pojoClassSample2", pp.getT());
//		pojoClassSample2.setAgeBoolean(false);
	}

}
