package cn.sj1.tinyasm.core;

import java.util.List;

import org.objectweb.asm.Type;

public class ClazzTypeArgument extends Clazz {
	char wildcard;
	Clazz clazz;

	public char getWildcard() {
		return wildcard;
	}

	public Clazz getClazz() {
		return clazz;
	}

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
		return clazz.getDescriptor();
	}

	@Override
	public String getDescriptor(List<ClazzFormalTypeParameter> formalTypeParameters) {
		return clazz.getDescriptor(formalTypeParameters);
	}

	@Override
	public String signatureOf(List<ClazzFormalTypeParameter> formalTypeParameters) {
		switch (wildcard) {
		case '*':
			return String.valueOf(wildcard);
		case '=':
			return clazz.signatureOf(formalTypeParameters) + "";

		default:
			return wildcard + clazz.signatureOf(formalTypeParameters) + "";
		}
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
