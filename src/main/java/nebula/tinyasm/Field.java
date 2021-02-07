package nebula.tinyasm;

public class Field {
	public Field(String name, GenericClazz generic) {
		this.name = name;
		this.clazz = generic;
	}
	public Field(String name, Class<?> generic) {
		this.name = name;
		this.clazz = TypeUtils.generic(generic);
	}

	@Override
	public String toString() {
		return "Field [name=" + name + ", type=" + clazz + "]";
	}

	public String name;
	final public GenericClazz clazz;
	public boolean identifier;
}