package nebula.tinyasm;

import static nebula.tinyasm.TypeUtils.arrayOf;
import static nebula.tinyasm.TypeUtils.signatureOf;
import static nebula.tinyasm.TypeUtils.typeOf;

import org.objectweb.asm.Type;

public class ClazzComplex implements Clazz {
	private Class<?> originclazz;
	private String originclazzName;
	private String[] genericParameterClazz;
	private String genericClazz;
	private boolean isarray;

	public Type getType() {
		return typeOf(originclazz);
	}

	ClazzComplex(String originclazzName, boolean isarray, String[] genericClazz) {
		super();
		this.originclazzName = originclazzName;
		this.genericParameterClazz = genericClazz;
		this.isarray = isarray;
	}

	ClazzComplex(String originclazzName, String[] genericClazz) {
		super();
		this.originclazzName = originclazzName;
		this.genericParameterClazz = genericClazz;
	}

	ClazzComplex(String originclazzName, String genericBase) {
		super();
		this.originclazzName = originclazzName;
		this.genericClazz = genericBase;
	}

	ClazzComplex(String originclazzName) {
		super();
		this.originclazzName = originclazzName;
	}

	ClazzComplex(Class<?> originclazz) {
		super();
		this.originclazz = originclazz;
	}

	@Override
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

	@Override
	public String signatureWhenNeed() {
		if (genericParameterClazz != null && genericParameterClazz.length > 0) {
			return signatureOf(arrayOf(typeOf(originclazzName), isarray), typeOf(genericParameterClazz));
		} else if (genericClazz != null) {
			return typeOf(genericClazz).getDescriptor();
		} else {
			return null;
		}
	}

	@Override
	public boolean needSignature() {
		return (genericParameterClazz != null && genericParameterClazz.length > 0) || genericClazz != null;
	}

	@Override
	public String getDescriptor() {
		return arrayOf(typeOf(originclazzName), isarray).getDescriptor();
	}
}
