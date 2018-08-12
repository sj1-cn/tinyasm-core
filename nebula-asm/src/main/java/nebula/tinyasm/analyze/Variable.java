package nebula.tinyasm.analyze;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;

//TODO Delete
class Variable extends ClassField {
	Label startFrom;

	public Variable(ClassField field, Label startFrom) {
		super(field.access, field.name, field.type, field.signature, null);
		this.startFrom = startFrom;
	}

	public Variable(String name, Type type) {
		this(name, type, null);
	}

	public Variable(String name, Type type, String signature) {
		super(0, name, type, signature, null);
	}

	public Variable(String name, Type type, String signature, Label startFrom) {
		super(0, name, type, signature, null);
		this.startFrom = startFrom;
	}

	public Object value;
}