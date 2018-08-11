package nebula.tinyasm;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;

public class LocalsStack extends ArrayListMap<LocalsVariable> {

	int top = 0;

	public LocalsVariable access(String name, Label label) {
		LocalsVariable var = get(name);
		if (var.startFrom == null) var.startFrom = label;
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

	public int size() {
		return stack.size();
	}

	public int[] computerVariableLocals() {
		int[] locals = new int[stack.size()];
		for (int i = 0; i < stack.size(); i++) {
			locals[i] = stack.get(i).locals;
		}
		return locals;
	}
}
