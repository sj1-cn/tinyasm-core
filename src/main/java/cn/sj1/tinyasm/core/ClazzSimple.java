package cn.sj1.tinyasm.core;

import org.objectweb.asm.Type;

public class ClazzSimple extends Clazz {
	Type type;

	ClazzSimple(Type type) {
		this.type = type;
	}

	public ClazzSimple(Class<?> type) {
		this.type = Type.getType(type);
	}

	public ClazzSimple(String name) {
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
		return type.getDescriptor();
	}

	@Override
	public String toString() {
		return type.getDescriptor();
	}

}
