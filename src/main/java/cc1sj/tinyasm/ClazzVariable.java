package cc1sj.tinyasm;

import org.objectweb.asm.Type;
import static cc1sj.tinyasm.TypeUtils.arrayOf;

import java.util.List;

public class ClazzVariable implements Clazz {
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
		return this.signatureOf();
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
		throw new UnsupportedOperationException("不能找到对应的FormalTypeParameter");
	}

	@Override
	public String signatureOf() {
		if ("*".equals(name)) {
			return "*";
		} else return isarray ? "[T" + name + ";" : "T" + name + ";";
	}

	@Override
	public String toString() {
		return signatureOf();
	}

}
