package nebula.commons.list;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;

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


	public T get(int index) {
		return stack.get(index);
	}

	public T get(String name) {
		return maps.get(name);
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


	@Override
	public String toString() {
		return stack.toString();
	}

}