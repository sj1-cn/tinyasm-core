package nebula.tinyasm;

public class Field {
	public Field(String name, Clazz generic) {
		this.name = name;
		this.clazz = generic;
	}
	public Field(String name, Class<?> generic) {
		this.name = name;
		this.clazz = Clazz.of(generic);
	}

	@Override
	public String toString() {
		return "Field [name=" + name + ", type=" + clazz + "]";
	}

	public String name;
	final public Clazz clazz;
	public boolean identifier;
}