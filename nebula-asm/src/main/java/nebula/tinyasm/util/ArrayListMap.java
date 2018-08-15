package nebula.tinyasm.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ArrayListMap<V> implements Iterable<V> {
	Stack<V> stack = new Stack<>();
	Map<String, V> maps = new HashMap<>();

	public void push(String name, V value) {
		stack.push(value);
		maps.put(name, value);
	}

	public V get(int index) {
		return stack.get(index);
	}

	public V get(String name) {
		return maps.get(name);
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
}
