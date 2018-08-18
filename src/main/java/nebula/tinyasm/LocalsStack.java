package nebula.tinyasm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import org.objectweb.asm.Label;

import nebula.tinyasm.data.GenericClazz;

class LocalsStack implements Iterable<LocalsVariable> {
	Stack<LocalsVariable> stack = new Stack<>();
	Map<String, LocalsVariable> maps = new HashMap<>();

	Stack<Integer> locals = new Stack<>();

	public LocalsVariable getByLocal(int index) {
		return stack.get(locals.get(index));
	}

	public LocalsVariable get(String name) {
		return maps.get(name);
	}

//	public boolean containsKey(String name) {
//		return maps.containsKey(name);
//	}

//	public int size() {
//		return stack.size();
//	}

	public Iterator<LocalsVariable> iterator() {
		return stack.iterator();
	}

	int top = 0;


	public LocalsVariable accessLoad(int index, Label label) {
		LocalsVariable var = getByLocal(index);
		if (var.startFrom == null) var.startFrom = label;
		return var;
	}

	public LocalsVariable accessStore(int index, Label label) {
		LocalsVariable var = getByLocal(index);
//		if (var.startFrom == null) var.startFrom = label;
		return var;
	}

	public void push(String name, LocalsVariable value) {
		value.locals = locals.size();
		for (int i = 0; i < value.type.getSize(); i++) {
			locals.push(stack.size());
		}
		stack.push(value);
		maps.put(name, value);
	}

	public void push(String name, GenericClazz clazz, Label label) {
		push(name, new LocalsVariable(name, clazz, label));
	}
}
