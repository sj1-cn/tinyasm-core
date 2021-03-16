package cc1sj.tinyasm.advasmproxy.generic;

import cc1sj.tinyasm.advasmproxy.simple.PojoClassChild;

public interface GenericInterface<T> {
	public T getT();

	PojoClassChild getPojoClassChildSample();

	public void setT(T t);
	
	void setPojoClassChildSample(PojoClassChild classSample);
}
