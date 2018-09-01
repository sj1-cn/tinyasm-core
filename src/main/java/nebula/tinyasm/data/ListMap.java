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

public class ListMap<K, T> implements Iterable<T> {

	Stack<T> stack = new Stack<>();
	Map<K, T> maps = new HashMap<>();
	protected Naming<K, T> namingHandler;

	public ListMap(Naming<K, T> namingHandler) {
		this.namingHandler = namingHandler;
	}

	public void push(T value) {
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

	public T get(int index) {
		return stack.get(index);
	}

	public T get(String name) {
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

	public Iterator<T> iterator() {
		return stack.iterator();
	}

	public List<T> list() {
		return stack;
	}

	public ListMap<K, T> filter(Predicate<? super T> predicate) {
		ListMap<K, T> newlist = new ListMap<>(namingHandler);
		for (T v : this.stack) {
			if (predicate.test(v)) {
				newlist.push(v);
			}
		}
		return newlist;
	}

	public boolean allMatch(Predicate<? super T> predicate) {
		return this.list().stream().allMatch(predicate);
	}

	public boolean anyMatch(Predicate<? super T> predicate) {
		return this.list().stream().anyMatch(predicate);
	}

	public <R> List<R> map(Function<? super T, ? extends R> mapper) {
		return this.list().stream().map(mapper).collect(Collectors.toList());
	}

	public void foreach(Consumer<? super T> action) {
		this.list().stream().forEach(action);
	}

	@Override
	public String toString() {
		return stack.toString();
	}

}