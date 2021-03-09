package cc1sj.tinyasm;

import java.util.List;

import org.objectweb.asm.Type;

public class ClazzTypeArgument extends Clazz {
	char wildcard;
	Clazz clazz;

	ClazzTypeArgument(char wildcard) {
		this.wildcard = wildcard;
	}

	ClazzTypeArgument(char name, Clazz clazz) {
		this.wildcard = name;
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
	public String getDescriptor(List<ClazzFormalTypeParameter> formalTypeParameters) {
		return this.getDescriptor();
	}

	@Override
	public String signatureOf() {
		switch (wildcard) {
		case '*':
			return String.valueOf(wildcard);
		case '=':
			return clazz.signatureOf() + "";

		default:
			return wildcard + clazz.signatureOf() + "";
		}
	}

	@Override
	public String toString() {
		return signatureOf();
	}

}
