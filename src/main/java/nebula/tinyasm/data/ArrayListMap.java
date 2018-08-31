package nebula.tinyasm.data;

public class ArrayListMap<V> extends ListMap<String, V> implements Iterable<V> {
	public ArrayListMap(Naming<String, V> namingHandler) {
		super(namingHandler);
	}

}
