package cn.sj1.tinyasm.core.advmagicbuilder;

public interface Repository<T extends WithIdKey,R> {
	R update(T t);
}
