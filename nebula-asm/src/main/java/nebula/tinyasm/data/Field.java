package nebula.tinyasm.data;

import nebula.tinyasm.GenericClazz;

public class Field {
	public Field(String name, GenericClazz generic) {
		this.name = name;
		this.clazz = generic;
	}

	@Override
	public String toString() {
		return "Field [name=" + name + ", type=" + clazz + "]";
	}

	public String name;
	final public GenericClazz clazz;
	public boolean identifier;
}