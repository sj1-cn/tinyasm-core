package cc1sj.tinyasm;

import org.objectweb.asm.Type;

public class ClazzVariable implements Clazz {
	String name;

	ClazzVariable(String name) {
		this.name = name;
	}

	@Override
	public Type getType() {
		return Type.getType(Object.class);
	}

	@Override
	public String signatureAnyway() {
		return signatureOf();
	}

	@Override
	public String signatureWhenNeed() {
		return signatureOf();
	}

	@Override
	public boolean needSignature() {
		return false;
	}

	@Override
	public String getDescriptor() {
		return null;
	}

	@Override
	public String signatureOf() {
		return "T" + name + ";";
	}

	@Override
	public String toString() {
		return signatureOf();
	}

}
