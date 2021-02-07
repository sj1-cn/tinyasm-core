package nebula.tinyasm;

import static nebula.tinyasm.TypeUtils.arrayOf;
import static nebula.tinyasm.TypeUtils.signatureOf;
import static nebula.tinyasm.TypeUtils.typeOf;

import org.objectweb.asm.Type;

public class ClazzComplex implements Clazz {
	private String originclazzName;
	private String[] genericParameterClazz;
	private String genericClazz;
	private boolean isarray;

	public Type getType() {
		String name = this.originclazzName;
		if (this.isarray) {
			return Type.getType("[" + Type.getObjectType(name.replace('.', '/')).getDescriptor());
		} else if (TypeUtils.primaryTypeMaps.containsKey(name)) return TypeUtils.primaryTypeMaps.get(name);
		return Type.getObjectType(name.replace('.', '/'));
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
