package cn.sj1.tinyasm.advasmproxy.generic;

import cn.sj1.tinyasm.advasmproxy.simple.PojoClass;

public class GenericMethodInterfaceUsingSample {

	@SuppressWarnings("unused")
	public void say(GenericMethodInterface<PojoClass> pp) {
		Integer[] iarray = new Integer[1];
		Integer[] warray = pp.arrayToArray(iarray);
	}

}
