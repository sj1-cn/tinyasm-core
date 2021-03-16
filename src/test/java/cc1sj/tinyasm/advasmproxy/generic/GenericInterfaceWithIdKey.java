package cc1sj.tinyasm.advasmproxy.generic;

import cc1sj.tinyasm.advasmproxy.simple.PojoClassChild;
import cc1sj.tinyasm.advmagicbuilder.WithIdKey;

public interface GenericInterfaceWithIdKey<T extends WithIdKey> {
	public T getT();

	PojoClassChild getPojoClassChildSample();

	public void setT(T t);

	void setPojoClassChildSample(PojoClassChild classSample);
}
