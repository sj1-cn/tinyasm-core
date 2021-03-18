package cn.sj1.tinyasm.advmagicbuilder;

public interface Repository<T extends WithIdKey,R> {
	R update(T t);
}
