package cn.sj1.tinyasm;

import java.util.List;

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
		if (actualClazz == null) {
			return clazz.getType();
		} else {
			return actualClazz.getType();
		}
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
		return true;
	}

	@Override
	public String getDescriptor() {
		return this.getType().getDescriptor();
	}

	@Override
	public String signatureOf(List<ClazzFormalTypeParameter> formalTypeParameters) {
		return "T" + name + ";";
	}

	@Override
	public String signatureOf() {
		if (clazz.getType().getClassName().equals(Object.class.getName())) {
			return name + ":" + clazz.signatureOf() + "";
		} else {
			return name + "::" + clazz.signatureOf() + "";
		}
	}

	@Override
	public String toString() {
		return signatureOf();
	}

}
