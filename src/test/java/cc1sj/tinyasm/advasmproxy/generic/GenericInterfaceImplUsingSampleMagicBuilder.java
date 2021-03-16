package cc1sj.tinyasm.advasmproxy.generic;

import cc1sj.tinyasm.advasmproxy.simple.PojoClassChild;
import cc1sj.tinyasm.advasmproxy.simple.PojoClass;
import static cc1sj.tinyasm.Adv.*;

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
