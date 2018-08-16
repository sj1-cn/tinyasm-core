package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.arrayOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;

import java.util.List;

import org.objectweb.asm.Type;

import nebula.tinyasm.data.Field;
import nebula.tinyasm.data.GenericClazz;

public class ClassField extends Field {
	public ClassField(int access, String name, GenericClazz clazz, Object defaultValue) {
		super(name, clazz);
		this.access = access;
		this.defaultValue = defaultValue;
		this.type = arrayOf(clazz.clazz, clazz.isarray);
	}

	@Override
	public String toString() {
		return "Field [name=" + name + ", type=" + clazz + "]";
	}

	final public int access;

	static public <T extends ClassField> Type[] typesOf(List<T> fields) {
		Type[] types = new Type[fields.size()];
		for (int i = 0; i < fields.size(); i++) {
			types[i] = typeOf(fields.get(i).clazz.clazz);
		}
		return types;
	}

	final public Type type;
	public boolean identifier;
	Object defaultValue;
}