package nebula.tinyasm.util;

import java.util.Iterator;
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

		int count = 0;

		@Override
		public String toString() {
			return this.name != null ? this.name : "var" + locals;
		}
	}

	Stack<Var> stack = new Stack<>();

	Stack<Integer> locals = new Stack<>();

	public Var getByLocal(int index) {
		return stack.get(locals.get(index));
	}

	public Iterator<Var> iterator() {
		return stack.iterator();
	}

	public Var accessLoad(int index, int size) {
		Var var;
		if (locals.size() <= index) {
			var = new Var(null, null);
			var.locals = index;
			for (int i = 0; i < size; i++) {
				locals.push(stack.size());
			}
			stack.push(var);
		} else {
			var = getByLocal(index);
		}
		var.count++;
		return var;
	}


	public Var accessStore(int index, int size) {
		Var var;
		if (locals.size() <= index) {
			var = new Var(null, null);
			var.locals = index;
			for (int i = 0; i < size; i++) {
				locals.push(stack.size());
			}
			stack.push(var);
		} else {
			var = getByLocal(index);
		}
		var.count++;
		return var;
	}

	public Var push(String name, Type clazz) {
		return push(name, new Var(name, clazz));
	}

	public Var push(String name) {
		return push(name, new Var(name, null));
	}

	public Var push(Annotation annotation, String name, Type clazz) {
		Var var = new Var(annotation, name, clazz);
		return push(name, var);
	}

	private Var push(String name, Var var) {
		var.count++;
		var.locals = locals.size();
		for (int i = 0; i < var.type.getSize(); i++) {
			locals.push(stack.size());
		}
		stack.push(var);
		return var;
	}

	public Var push(String name, Type clazz, Label label) {
		Var var = new Var(name, clazz, label);
		return push(name, var);
	}

	public int size() {
		return locals.size();
	}
}
