package nebula.tinyasm;

import static nebula.tinyasm.TypeUtils.*;

public class GenericClazz {
	public Class<?> originclazz;
	public String originclazzName;
	public String[] genericParameterClazz;
	public String genericClazz;
	public boolean isarray;

	public GenericClazz(String originclazzName, boolean isarray, String[] genericClazz) {
		super();
		this.originclazzName = originclazzName;
		this.genericParameterClazz = genericClazz;
		this.isarray = isarray;
	}

	public GenericClazz(String originclazzName, String[] genericClazz) {
		super();
		this.originclazzName = originclazzName;
		this.genericParameterClazz = genericClazz;
	}

	public GenericClazz(String originclazzName, String genericBase) {
		super();
		this.originclazzName = originclazzName;
		this.genericClazz = genericBase;
	}

	public GenericClazz(String originclazzName) {
		super();
		this.originclazzName = originclazzName;
	}
	public GenericClazz(Class<?> originclazz) {
		super();
		this.originclazz = originclazz;
	}

	public String signatureAnyway() {
		String signature;
		if (genericParameterClazz != null && genericParameterClazz.length > 0) {
			signature = signatureOf(arrayOf(typeOf(originclazzName), isarray), typeOf(genericParameterClazz));
		} else if (genericClazz != null) {
			return typeOf(genericClazz).getDescriptor();
		} else {
			signature = typeOf(originclazzName).getDescriptor();
		}
		return signature;
	}

	public String signatureWhenNeed() {
		if (genericParameterClazz != null && genericParameterClazz.length > 0) {
			return signatureOf(arrayOf(typeOf(originclazzName), isarray), typeOf(genericParameterClazz));
		} else if (genericClazz != null) {
			return typeOf(genericClazz).getDescriptor();
		} else {
			return null;
		}
	}

	public boolean needSignature() {
		return (genericParameterClazz != null && genericParameterClazz.length > 0) || genericClazz != null;
	}

	public String getDescriptor() {
		return arrayOf(typeOf(originclazzName), isarray).getDescriptor();
	}

}