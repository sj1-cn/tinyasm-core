package cc1sj.tinyasm;

import org.objectweb.asm.Type;

public class ClazzFormalTypeParameter extends Clazz {
	String name;
	Clazz clazz;
	Clazz actualClazz;

	ClazzFormalTypeParameter(String name, Clazz clazz) {
		this.name = name;
		this.clazz = clazz;
	}

	public Clazz getActualClazz() {
		return actualClazz;
	}

	public void setActualTypeArgument(Clazz actualClazz) {
		this.actualClazz = actualClazz;
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
