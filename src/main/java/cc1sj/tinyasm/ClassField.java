package cc1sj.tinyasm;

public class ClassField extends Field {
	public ClassField(int access, String name, Clazz clazz, Object defaultValue) {
		super(name, clazz);
		this.access = access;
		this.defaultValue = defaultValue;
	}

	final public int access;
	public boolean identifier;
	Object defaultValue;
}