package nebula.tinyasm.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;

import nebula.tinyasm.Annotation;

public class TinyLocalsStack implements Iterable<TinyLocalsStack.Var> {

	public static class Var {
		int access;
		public Label startFrom;

		public Object value;

		public Annotation annotation;
		Type type;
		String name;

		public Var(String name, Type type) {
			this(0, name, type);
		}

		public Var(int access, String name, Type type) {
			this.access = access;
			this.name = name;
			this.type = type;
		}

		public Var(Annotation annotation, String name, Type clazz) {
			this(0, name, clazz);
			this.annotation = annotation;
		}

		public Var(String name, Type type, Label startFrom) {
			this(0, name, type);
			this.startFrom = startFrom;
		}

		public int locals = 0;

		@Override
		public String toString() {
			return this.name;
		}
	}

	Stack<Var> stack = new Stack<>();
//	Map<String, Var> maps = new HashMap<>();

	Stack<Integer> locals = new Stack<>();

	public Var getByLocal(int index) {
		return stack.get(locals.get(index));
	}

//	public Var get(String name) {
//		return maps.get(name);
//	}

//	public boolean containsKey(String name) {
//		return maps.containsKey(name);
//	}

//	public int size() {
//		return stack.size();
//	}

	public Iterator<Var> iterator() {
		return stack.iterator();
	}

	int top = 0;

//	public Var accessLoad(int index, Label label) {
//		Var var = getByLocal(index);
//		if (var.startFrom == null) var.startFrom = label;
//		return var;
//	}

	public Type accessLoadType(int index, Label label) {
		Var var = getByLocal(index);
		if (var.startFrom == null) var.startFrom = label;
		return var.type;
	}

//	public Var accessStore(int index, Label label) {
//		Var var = getByLocal(index);
////		if (var.startFrom == null) var.startFrom = label;
//		return var;
//	}

	public Type accessStoreType(int index, Label label) {
		Var var = getByLocal(index);
//		if (var.startFrom == null) var.startFrom = label;
		return var.type;
	}

	public Var push(String name, Type clazz) {
		return push(name, new Var(name, clazz));
	}

	public Var push(String name) {
		return push(name, new Var(name, null));
	}

	public Var push(Annotation annotation, String name, Type clazz) {
		return push(name, new Var(annotation, name, clazz));
	}

	private Var push(String name, Var value) {
		value.locals = locals.size();
		for (int i = 0; i < value.type.getSize(); i++) {
			locals.push(stack.size());
		}
		stack.push(value);
		return value;
	}

	public Var push(String name, Type clazz, Label label) {
		return push(name, new Var(name, clazz, label));
	}
}
