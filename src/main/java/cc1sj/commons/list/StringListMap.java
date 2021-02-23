package cc1sj.commons.list;


import java.util.function.Function;

public class StringListMap<V> extends ListMap<String, V> implements Iterable<V> {
	public StringListMap(Function<V, String> keyFunction) {
		super(keyFunction);
	}
}
