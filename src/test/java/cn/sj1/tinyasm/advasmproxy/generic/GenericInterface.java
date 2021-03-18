package cn.sj1.tinyasm.advasmproxy.generic;

import cn.sj1.tinyasm.advasmproxy.simple.PojoClassChild;

public interface GenericInterface<T> {
	public T getT();

	PojoClassChild getPojoClassChildSample();

	public void setT(T t);
	
	void setPojoClassChildSample(PojoClassChild classSample);
}
