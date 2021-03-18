package cn.sj1.tinyasm;

import org.objectweb.asm.Type;

public class Field {
	public Field(String name, Clazz clazz) {
		this.name = name;
		this.clazz = clazz;
	}
	public Field(String name, Class<?> clazz) {
		this.name = name;
		this.clazz = Clazz.of(clazz);
	}

	@Override
	public String toString() {
		return "Field [name=" + name + ", type=" + clazz + "]";
	}

	public String name;
	final public Clazz clazz;
	Type type;
	public boolean identifier;
}