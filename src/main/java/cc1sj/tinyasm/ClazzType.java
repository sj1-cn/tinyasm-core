package cc1sj.tinyasm;

import org.objectweb.asm.Type;

public class ClazzType implements Clazz {
	Type type;

	ClazzType(Type type) {
		this.type = type;
	}

	public ClazzType(Class<?> type) {
		this.type = Type.getType(type);
	}

	public ClazzType(String name) {
		if (name == null) type = Type.VOID_TYPE;
		if (TypeUtils.primaryTypeMaps.containsKey(name)) type = TypeUtils.primaryTypeMaps.get(name);
		type = Type.getObjectType(name.replace('.', '/'));
	}

	@Override
	public Type getType() {
		return this.type;
	}

	@Override
	public String signatureAnyway() {
		return this.type.getDescriptor();
	}

	@Override
	public String signatureWhenNeed() {
		return null;
	}

	@Override
	public boolean needSignature() {
		return false;
	}

	@Override
	public String getDescriptor() {
		return this.type.getDescriptor();
	}

	@Override
	public String signatureOf() {
//		StringBuilder sb = new StringBuilder();
//
//		if (this.type.getSort() == Type.ARRAY) sb.append("[" + type.getInternalName());
//		else sb.append(type.getInternalName());
//		return sb.toString();
		return type.getDescriptor();
	}

	@Override
	public String toString() {
		return type.getDescriptor();
	}

}
