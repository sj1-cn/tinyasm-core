package cc1sj.tinyasm.advmagicbuilder;

public interface Repository<T extends WithIdKey,R> {
	R update(T t);
}
