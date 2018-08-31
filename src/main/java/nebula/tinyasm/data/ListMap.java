package nebula.tinyasm.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ListMap<K, V> {

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

	@Override
	public String toString() {
		return stack.toString();
	}

}