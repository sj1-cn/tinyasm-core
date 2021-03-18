package cn.sj1.tinyasm;

import java.util.List;

import org.objectweb.asm.Type;

public class ClazzWithTypeArguments extends Clazz {
	private Clazz baseClazz;
	private ClazzTypeArgument[] typeArguments;

	public Type getType() {
		return baseClazz.getType();
	}

	public Clazz getBaseClazz() {
		return baseClazz;
	}

	public ClazzTypeArgument[] getTypeArguments() {
		return typeArguments;
	}

	ClazzWithTypeArguments(Clazz baseClazz, ClazzTypeArgument... genericClazz) {
		super();
		this.baseClazz = baseClazz;
		this.typeArguments = genericClazz;
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
		return baseClazz.needSignature() || (typeArguments != null && typeArguments.length > 0);
	}

	@Override
	public String getDescriptor() {
		return baseClazz.getDescriptor();
	}

	@Override
	public String getDescriptor(List<ClazzFormalTypeParameter> formalTypeParameters) {
		return baseClazz.getDescriptor(formalTypeParameters);
//		String signature = null;
//		if (this.genericParameterClazz != null && genericParameterClazz.length > 0) {
//			StringBuilder sb = new StringBuilder();
//			sb.append("L");
//
//			if (baseClazz.getType().getSort() == Type.ARRAY) sb.append("[");
//
//			sb.append(baseClazz.getDescriptor(formalTypeParameters));
//
//			sb.append("<");
//			for (Clazz signatureType : genericParameterClazz) {
//				sb.append(signatureType.getDescriptor(formalTypeParameters));
//			}
//			sb.append(">;");
//			signature = sb.toString();
//		}
//		return signature;
	}

	@Override
	public String signatureOf(List<ClazzFormalTypeParameter> formalTypeParameters) {
		String signature = null;
		if (this.typeArguments != null && typeArguments.length > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("L");

			if (baseClazz.getType().getSort() == Type.ARRAY) sb.append("[");

			sb.append(baseClazz.getType().getInternalName());

			sb.append("<");
			for (Clazz signatureType : typeArguments) {
				sb.append(signatureType.signatureOf(formalTypeParameters));
			}
			sb.append(">;");
			signature = sb.toString();
		}
		return signature;
	}

	@Override
	public String signatureOf() {
		String signature = null;
		if (this.typeArguments != null && typeArguments.length > 0) {
			StringBuilder sb = new StringBuilder();

			if (baseClazz.getType().getSort() == Type.ARRAY) {
				sb.append("[");
				sb.append("L");
				sb.append(baseClazz.getType().getElementType().getInternalName());
			}else {
				sb.append("L");
				sb.append(baseClazz.getType().getInternalName());
			}


			sb.append("<");
			for (Clazz signatureType : typeArguments) {
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
