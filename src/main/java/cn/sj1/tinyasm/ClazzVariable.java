package cn.sj1.tinyasm;

import static cn.sj1.tinyasm.TypeUtils.arrayOf;

import java.util.List;

import org.objectweb.asm.Type;

public class ClazzVariable extends Clazz {
	final String name;
	final boolean isarray;

	ClazzVariable(String name) {
		this.name = name;
		this.isarray = false;
	}

	public ClazzVariable(String name, boolean isarray) {
		this.name = name;
		this.isarray = isarray;
	}

	@Override
	public Type getType() {
		return arrayOf(Type.getType(Object.class), isarray);
	}

	@Override
	public String signatureAnyway() {
		return signatureOf();
	}

	@Override
	public String signatureWhenNeed() {
		return needSignature() ? signatureOf() : null;
	}

	@Override
	public boolean needSignature() {
		return true;
	}

	@Override
	public String getDescriptor() {
		if (isarray) {
			return "[" + Type.getType(Object.class).getDescriptor();
		} else {
			return Type.getType(Object.class).getDescriptor();
		}
	}

	@Override
	public String signatureOf(List<ClazzFormalTypeParameter> formalTypeParameters) {
		for (int i = 0; i < formalTypeParameters.size(); i++) {
			if (this.name.equals(formalTypeParameters.get(i).name)) {
				Clazz actualClazz = formalTypeParameters.get(i).getActualClazz();
				if (actualClazz == null) {
					actualClazz = formalTypeParameters.get(i).clazz;
				}

				if (isarray) {
					return "[" + actualClazz.getDescriptor();
				} else {
					return actualClazz.getDescriptor();
				}
			}
		}
		return signatureOf();
	}

	@Override
	public String getDescriptor(List<ClazzFormalTypeParameter> formalTypeParameters) {
		for (int i = 0; i < formalTypeParameters.size(); i++) {
			if (this.name == formalTypeParameters.get(i).name) {
				if (isarray) {
					return "[" + formalTypeParameters.get(i).clazz.getDescriptor();
				} else {
					return formalTypeParameters.get(i).clazz.getDescriptor();
				}
			}
		}
		return getDescriptor();
	}

	@Override
	public String signatureOf() {
		return isarray ? "[T" + name + ";" : "T" + name + ";";
	}

	@Override
	public String toString() {
		return signatureOf();
	}

}
