package nebula.tinyasm;

import org.objectweb.asm.Label;

import nebula.tinyasm.data.ArrayListMap;
import nebula.tinyasm.data.GenericClazz;

class LocalsStack extends ArrayListMap<LocalsVariable> {

	int top = 0;

	public LocalsVariable accessLoad(String name, Label label) {
		LocalsVariable var = get(name);
		if (var.startFrom == null) var.startFrom = label;
		return var;
	}

	public LocalsVariable accessStore(String name, Label label) {
		LocalsVariable var = get(name);
//		if (var.startFrom == null) var.startFrom = label;
		return var;
	}

	public LocalsVariable accessLoad(int index, Label label) {
		LocalsVariable var = get(index);
		if (var.startFrom == null) var.startFrom = label;
		return var;
	}

	public LocalsVariable accessStore(int index, Label label) {
		LocalsVariable var = get(index);
//		if (var.startFrom == null) var.startFrom = label;
		return var;
	}

	@Override
	public void push(String name, LocalsVariable value) {
		value.locals = top;
		super.push(name, value);
		top += value.type.getSize();
	}

	public void push(LocalsVariable value) {
		value.locals = top;
		super.push(value.name, value);
		top += value.type.getSize();
	}

	public void push(String name, GenericClazz clazz, Label label) {
		push(new LocalsVariable(name, clazz, label));
	}
}
