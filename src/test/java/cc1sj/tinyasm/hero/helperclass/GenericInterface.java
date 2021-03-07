package cc1sj.tinyasm.hero.helperclass;

public interface GenericInterface<T> {
	public T getT();

	PojoClassChildSample getPojoClassChildSample();

	public void setT(T t);
	
	void setPojoClassChildSample(PojoClassChildSample classSample);
}
