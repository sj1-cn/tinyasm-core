package cc1sj.tinyasm.advmagicbuilder;

public class RepositoryMagicBuilder<T extends WithIdKey> implements Repository<T> {

	@Override
	public T update(T t) {
		return t;
	}

}
