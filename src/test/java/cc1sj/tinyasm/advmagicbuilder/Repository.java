package cc1sj.tinyasm.advmagicbuilder;

public interface Repository<T,R> {
	R update(T t);
}
