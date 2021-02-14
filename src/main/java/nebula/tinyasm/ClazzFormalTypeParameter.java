package nebula.tinyasm;

import org.objectweb.asm.Type;

public class ClazzFormalTypeParameter implements Clazz {
	String name;
	Clazz clazz;

	ClazzFormalTypeParameter(String name,Clazz clazz) {
		this.name = name;
		this.clazz = clazz;
	}

	@Override
	public Type getType() {
		return null;
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
		return name + ":" + clazz.signatureOf() + "";
	}

	@Override
	public String toString() {
		return signatureOf();
	}

}
