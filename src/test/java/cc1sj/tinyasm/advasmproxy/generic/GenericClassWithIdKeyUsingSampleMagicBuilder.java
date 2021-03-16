package cc1sj.tinyasm.advasmproxy.generic;

import static cc1sj.tinyasm.Adv.__;
import static cc1sj.tinyasm.Adv.new_;

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
