package nebula.tinyasm;

import org.objectweb.asm.Label;

public class LocalsVariable extends ClassField {
	public Label startFrom;

	public Object value;

	public Annotation annotation;

	public LocalsVariable(ClassField field, Label startFrom) {
		super(field.access, field.name, field.clazz, null);
		this.startFrom = startFrom;
	}

	public LocalsVariable(String name, Clazz clazz) {
		super(0, name, clazz, null);
	}

	public LocalsVariable(int access, String name, Clazz clazz) {
		super(access, name, clazz, null);
	}

	public LocalsVariable(Annotation annotation, String name, Clazz clazz) {
		super(0, name, clazz, null);
		this.annotation = annotation;
	}

	public LocalsVariable(String name, Clazz type, Label startFrom) {
		super(0, name, type, null);
		this.startFrom = startFrom;
	}

	public int locals = 0;
}