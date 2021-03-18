package cn.sj1.tinyasm.advasmproxy.generic;

import cn.sj1.tinyasm.advasmproxy.simple.PojoClassChild;

public class GenericClass<T> implements GenericInterface<T> {
	T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	@Override
	public PojoClassChild getPojoClassChildSample() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPojoClassChildSample(PojoClassChild classSample) {
		// TODO Auto-generated method stub
		
	}

}
