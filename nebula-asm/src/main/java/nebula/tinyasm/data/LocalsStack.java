package nebula.tinyasm.data;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;

import nebula.tinyasm.util.ArrayListMap;

public class LocalsStack extends ArrayListMap<LocalsVariable> {

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

	public void push(String name, Type type, Label label) {
		push(new LocalsVariable(name, type, null, label));
	}
}
