package cc1sj.tinyasm;

import java.util.List;

import org.objectweb.asm.Type;

public class ClazzComplex extends Clazz {
	private Clazz baseClazz;
	private Clazz[] genericParameterClazz;

	public Type getType() {
		return baseClazz.getType();
	}

	ClazzComplex(Clazz originclazzName, Clazz... genericClazz) {
		super();
		this.baseClazz = originclazzName;
		this.genericParameterClazz = genericClazz;
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
		return baseClazz.needSignature() || (genericParameterClazz != null && genericParameterClazz.length > 0);
	}

	@Override
	public String getDescriptor() {
		return baseClazz.getDescriptor();
	}

	@Override
	public String getDescriptor(List<ClazzFormalTypeParameter> formalTypeParameters) {
		return this.getDescriptor();
	}

	@Override
	public String signatureOf() {
		String signature = null;
		if (this.genericParameterClazz != null && genericParameterClazz.length > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("L");

			if (baseClazz.getType().getSort() == Type.ARRAY) sb.append("[");

			sb.append(baseClazz.getType().getInternalName());

			sb.append("<");
			for (Clazz signatureType : genericParameterClazz) {
				sb.append(signatureType.signatureOf());
			}
			sb.append(">;");
			signature = sb.toString();
		}
		return signature;
	}

	@Override
	public String toString() {
		return this.signatureOf();
	};

}
