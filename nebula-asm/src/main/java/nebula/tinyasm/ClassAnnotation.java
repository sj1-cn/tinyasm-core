package nebula.tinyasm;

import org.objectweb.asm.Type;

class ClassAnnotation {
	int parameter;

	final public Type type;

	final public String name;

	final public Object value;

	public ClassAnnotation(Type type, String name, Object value) {
		super();
		this.value = value;
		this.type = type;
		this.name = name;
	}

	public ClassAnnotation(Type type, String name, Object value, int parameter) {
		this(type, name, value);
		this.parameter = parameter;
	}
}