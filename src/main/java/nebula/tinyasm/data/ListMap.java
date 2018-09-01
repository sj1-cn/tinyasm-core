package nebula.tinyasm.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListMap<K, V> implements Iterable<V> {

	Stack<V> stack = new Stack<>();
	Map<K, V> maps = new HashMap<>();
	protected Naming<K, V> namingHandler;

	public ListMap(Naming<K, V> namingHandler) {
		this.namingHandler = namingHandler;
	}

	public void push(V value) {
		if (maps.containsKey(namingHandler.nameOf(value))) {
			K name = namingHandler.nameOf(value);
			for (int i = 0; i < stack.size(); i++) {
				if (name.equals(namingHandler.nameOf(stack.get(i)))) {
					stack.set(i, value);
					break;
				}
			}
		} else {
			stack.push(value);
		}
		maps.put(namingHandler.nameOf(value), value);
	}

	public V get(int index) {
		return stack.get(index);
	}

	public V get(String name) {
		return maps.get(name);
	}

	public void remove(String name) {
		for (int i = 0; i < stack.size(); i++) {
			if (name.equals(namingHandler.nameOf(stack.get(i)))) {
				stack.remove(i);
				break;
			}
		}
		maps.remove(name);
	}

	public boolean containsKey(String name) {
		return maps.containsKey(name);
	}

	public int size() {
		return stack.size();
	}

	public Iterator<V> iterator() {
		return stack.iterator();
	}

	public List<V> list() {
		return stack;
	}

	public ListMap<K, V> filter(Predicate<? super V> predicate) {
		ListMap<K, V> newlist = new ListMap<>(namingHandler);
		for (V v : this.stack) {
			if (predicate.test(v)) {
				newlist.push(v);
			}
		}
		return newlist;
	}

	public <R> List<R> map(Function<? super V, ? extends R> mapper) {
		return this.list().stream().map(mapper).collect(Collectors.toList());
	}

	public void foreach(Consumer<? super V> action) {
		this.list().stream().forEach(action);
	}

	@Override
	public String toString() {
		return stack.toString();
	}

}