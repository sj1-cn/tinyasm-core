package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.typeOf;

import java.util.Iterator;
import java.util.Stack;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;

public class LocalsStack implements Iterable<LocalsStack.Var> {

	public static class Var {
		int access;
		String name;
		Label startFrom;
		Annotation annotation;
		final Type type;
		final GenericClazz clazz;
		int locals = 0;

		//TODO fix bug
		Var(GenericClazz clazz) {
			this.clazz = clazz;
			this.type = typeOf(clazz.originclazzName);
		}

		Var(Type type) {
			this.clazz = GenericClazz.generic(type);
			this.type = type;
		}

		Var(GenericClazz clazz, Type type) {
			this.clazz = clazz;
			this.type = type;
		}
	}

	Stack<Var> stack = new Stack<>();

	Stack<Integer> locals = new Stack<>();

	public Var getByLocal(int index) {
		return stack.get(locals.get(index));
	}

	public Var get(String name) {
		for (Var var : stack) {
			if (name.equals(var.name)) return var;
		}
		return null;
	}

	public int size() {
		return locals.size();
	}

	public Iterator<Var> iterator() {
		return stack.iterator();
	}

	int top = 0;

	public Type accessLoadType(int index, Label label) {
		Var var = getByLocal(index);
		if (var.startFrom == null) var.startFrom = label;
		return var.type;
	}

	// 存储变量不算访问？？？？
	public Type accessStoreType(int index, Type type, Label label) {
		if (index >= locals.size()) {
			Var var1 = new Var(type);
			var1.locals = index;
			for (int i = 0; i < type.getSize(); i++) {
				locals.push(stack.size());
			}
			stack.push(var1);
		}
		Var var = getByLocal(index);
//		if (var.startFrom == null) var.startFrom = label;
		return var.type;
	}

	// Method Parameter
	public void pushParameter(String name, Type type, Label label) {
		Var var = new Var(type);
		var.name = name;
		var.startFrom = label;

		var.locals = locals.size();
		for (int i = 0; i < var.type.getSize(); i++) {
			locals.push(stack.size());
		}
		stack.push(var);
	}
	
	// Method Parameter
	public void pushParameter(String name, GenericClazz clazz, Label label) {
		Var var = new Var(clazz);
		var.name = name;
		var.startFrom = label;

		var.locals = locals.size();
		for (int i = 0; i < var.type.getSize(); i++) {
			locals.push(stack.size());
		}
		stack.push(var);
	}

	// 定义局部变量
	public void define(String name, GenericClazz clazz) {
		define(null, name, clazz);
	}

	// 定义局部变量
	public void define(Annotation annotation, String name, GenericClazz clazz) {
		Var var = new Var(clazz);
		var.annotation = annotation;
		var.name = name;

		var.locals = locals.size();
		for (int i = 0; i < var.type.getSize(); i++) {
			locals.push(stack.size());
		}
		stack.push(var);
	}

}
