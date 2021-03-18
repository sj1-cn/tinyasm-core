package cn.sj1.tinyasm.advasmproxy.generic;

import cn.sj1.tinyasm.advasmproxy.simple.PojoClassChild;
import cn.sj1.tinyasm.advmagicbuilder.WithIdKey;

public interface GenericInterfaceWithIdKey<T extends WithIdKey> extends GenericInterface<T> {
	public T getT();

	PojoClassChild getPojoClassChildSample();

	public void setT(T t);

	void setPojoClassChildSample(PojoClassChild classSample);
}
