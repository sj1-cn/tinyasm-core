package cc1sj.tinyasm.hero.helperclass;

public class GenericClass<T> implements GenericInterface<T> {
	T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	@Override
	public PojoClassChildSample getPojoClassChildSample() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPojoClassChildSample(PojoClassChildSample classSample) {
		// TODO Auto-generated method stub
		
	}

}
