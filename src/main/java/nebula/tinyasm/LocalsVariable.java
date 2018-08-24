package nebula.tinyasm;

import org.objectweb.asm.Label;

import nebula.tinyasm.data.Annotation;
import nebula.tinyasm.data.GenericClazz;

class LocalsVariable extends ClassField {
	public Label startFrom;

	public Object value;

	public Annotation annotation;

	public LocalsVariable(ClassField field, Label startFrom) {
		super(field.access, field.name, field.clazz, null);
		this.startFrom = startFrom;
	}

	public LocalsVariable(String name, GenericClazz clazz) {
		super(0, name, clazz, null);
	}

	public LocalsVariable(int access, String name, GenericClazz clazz) {
		super(access, name, clazz, null);
	}

	public LocalsVariable(Annotation annotation, String name, GenericClazz clazz) {
		super(0, name, clazz, null);
		this.annotation = annotation;
	}

	public LocalsVariable(String name, GenericClazz type, Label startFrom) {
		super(0, name, type, null);
		this.startFrom = startFrom;
	}

	public int locals = 0;
}