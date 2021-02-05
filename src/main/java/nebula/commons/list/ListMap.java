package nebula.commons.list;


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
	protected Function<T,K> keyFunction;

	public ListMap(Function<T,K> keyFunction) {
		this.keyFunction = keyFunction;
	}

	public void push(T value) {
		K key = keyFunction.apply(value);
		if (maps.containsKey(key)) {
			for (int i = 0; i < stack.size(); i++) {
				if (key.equals(keyFunction.apply(stack.get(i)))) {
					stack.set(i, value);
					break;
				}
			}
		} else {
			stack.push(value);
		}
		maps.put(keyFunction.apply(value), value);
	}

	public void push(List<T> values) {
		for (T t : values) {
			push(t);
		}
	}

	public T get(int index) {
		return stack.get(index);
	}

	public T get(String name) {
		return maps.get(name);
	}

	public void remove(String name) {
		for (int i = 0; i < stack.size(); i++) {
			if (name.equals(keyFunction.apply(stack.get(i)))) {
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
		ListMap<K, T> newlist = new ListMap<>(keyFunction);
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