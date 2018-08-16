package nebula.tinyasm.data;

import static nebula.tinyasm.util.TypeUtils.*;

public class Annotation {
	final public String clazz;

	final public Object defaultValue;

	final public String[] names;
	final public Object[] values;

	public Annotation(String clazz, Object defaultValue, String[] names, Object[] values) {
		super();
		this.clazz = clazz;
		this.defaultValue = defaultValue;
		this.names = names;
		this.values = values;
	}

	public Annotation(String clazz, Object defaultValue) {
		super();
		this.clazz = clazz;
		this.defaultValue = defaultValue;
		this.names = new String[0];
		this.values = new Object[0];
	}

	static public Annotation annotation(Annotation annotation) {
		return annotation;
	}

	static public Annotation annotation(Class<?> clazz) {
		return annotation(nameOf(clazz), null);
	}

	static public Annotation annotation(String clazz) {
		return annotation(nameOf(clazz), null);
	}

	static public Annotation annotation(Class<?> clazz, Object value) {
		return annotation(nameOf(clazz), value);
	}

	static public Annotation annotation(String clazz, Object value) {
		return new Annotation(clazz, value, null, null);
	}

	static public Annotation annotation(String clazz, Object value, String[] names, Object[] values) {
		return new Annotation(clazz, value, names, values);
	}

	static public Annotation annotation(String clazz, String[] names, Object[] values) {
		return annotation(clazz, null, names, values);
	}

	static public Annotation annotation(Class<?> clazz, String[] names, Object[] values) {
		return annotation(nameOf(clazz), names, values);
	}

	static public Annotation annotation(Class<?> clazz, Object value, String[] names, Object[] values) {
		return annotation(nameOf(clazz), value, names, values);
	}

	public String getDescriptor() {
		return typeOf(clazz).getDescriptor();
	}
}