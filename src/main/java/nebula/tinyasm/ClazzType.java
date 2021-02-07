package nebula.tinyasm;

import org.objectweb.asm.Type;

public class ClazzType implements Clazz {
	Type type;

	public ClazzType(Type type) {
		this.type = type;
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

}
