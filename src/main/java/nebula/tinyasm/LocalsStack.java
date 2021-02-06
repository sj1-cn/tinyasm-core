package nebula.tinyasm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;

public class LocalsStack implements Iterable<LocalsStack.Var> {

	public static class Var extends ClassField {
		public Label startFrom;

		public Object value;

		public Annotation annotation;

		public Var(ClassField field, Label startFrom) {
			super(field.access, field.name, field.clazz, null);
			this.startFrom = startFrom;
		}

		public Var(String name, GenericClazz clazz) {
			super(0, name, clazz, null);
		}

		public Var(int access, String name, GenericClazz clazz) {
			super(access, name, clazz, null);
		}

		public Var(Annotation annotation, String name, GenericClazz clazz) {
			super(0, name, clazz, null);
			this.annotation = annotation;
		}

		public Var(String name, GenericClazz type, Label startFrom) {
			super(0, name, type, null);
			this.startFrom = startFrom;
		}

		public int locals = 0;
	}

	Stack<Var> stack = new Stack<>();
	Map<String, Var> maps = new HashMap<>();

	Stack<Integer> locals = new Stack<>();

	public Var getByLocal(int index) {
		return stack.get(locals.get(index));
	}

	public Var get(String name) {
		return maps.get(name);
	}

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

	public void push(String name, GenericClazz clazz) {
		push(name, new Var(name, clazz));
	}

	public void push(Annotation annotation, String name, GenericClazz clazz) {
		push(name, new Var(annotation, name, clazz));
	}

	private void push(String name, Var value) {
		value.locals = locals.size();
		for (int i = 0; i < value.type.getSize(); i++) {
			locals.push(stack.size());
		}
		stack.push(value);
		maps.put(name, value);
	}

	public void push(String name, GenericClazz clazz, Label label) {
		push(name, new Var(name, clazz, label));
	}
}
