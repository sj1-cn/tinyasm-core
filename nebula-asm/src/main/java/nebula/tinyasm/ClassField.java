package nebula.tinyasm;

import java.util.List;

import org.objectweb.asm.Type;

import nebula.tinyasm.api.Field;

public class ClassField extends Field {
	public ClassField(int access, String name, Type type, String signature, Object defaultValue) {
		super(name, type);
		this.signature = signature;
		this.access = access;
		this.defaultValue = defaultValue;
	}

	@Override
	public String toString() {
		return "Field [name=" + name + ", type=" + type + "]";
	}

	public int access;
	public String signature;
	public boolean identifier;
	Object defaultValue;

	static public Type[] typesOf(List<ClassField> fields) {
		Type[] types = new Type[fields.size()];
		for (int i = 0; i < fields.size(); i++) {
			types[i] = fields.get(i).type;
		}
		return types;
	}
}