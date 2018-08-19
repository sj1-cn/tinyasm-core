package nebula.tinyasm.data;

import static nebula.tinyasm.util.TypeUtils.*;
import static nebula.tinyasm.util.TypeUtils.signatureOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;

public class GenericClazz {
	public String originclazz;
	public String[] genericParameterClazz;
	public String genericClazz;
	public boolean isarray;

	public GenericClazz(String originclazz, boolean isarray, String[] genericClazz) {
		super();
		this.originclazz = originclazz;
		this.genericParameterClazz = genericClazz;
		this.isarray = isarray;
	}

	public GenericClazz(String originclazz, String[] genericClazz) {
		super();
		this.originclazz = originclazz;
		this.genericParameterClazz = genericClazz;
	}

	public GenericClazz(String originclazz, String genericBase) {
		super();
		this.originclazz = originclazz;
		this.genericClazz = genericBase;
	}

	public GenericClazz(String originclazz) {
		super();
		this.originclazz = originclazz;
	}

	public String signatureAnyway() {
		String signature;
		if (genericParameterClazz != null && genericParameterClazz.length > 0) {
			signature = signatureOf(arrayOf(originclazz, isarray), typeOf(genericParameterClazz));
		} else if (genericClazz != null) {
			return typeOf(genericClazz).getDescriptor();
		} else {
			signature = typeOf(originclazz).getDescriptor();
		}
		return signature;
	}

	public String signatureWhenNeed() {
		if (genericParameterClazz != null && genericParameterClazz.length > 0) {
			return signatureOf(arrayOf(originclazz, isarray), typeOf(genericParameterClazz));
		} else if (genericClazz != null) {
			return typeOf(genericClazz).getDescriptor();
		} else {
			return null;
		}
	}

	public boolean needSignature() {
		return (genericParameterClazz != null && genericParameterClazz.length > 0) || genericClazz != null;
	}

	static public GenericClazz generic(GenericClazz originclazz) {
		return originclazz;
	}

	static public GenericClazz generic(Class<?> originclazz) {
		return new GenericClazz(classnameOf(originclazz));
	}

	static public GenericClazz generic(String originclazz) {
		return new GenericClazz(classnameOf(originclazz));
	}

	static public GenericClazz genericBase(Class<?> originclazz, Class<?> genericClass) {
		return new GenericClazz(classnameOf(originclazz), classnameOf(genericClass));
	}

	static public GenericClazz genericBase(Class<?> originclazz, String genericClass) {
		return new GenericClazz(classnameOf(originclazz), classnameOf(genericClass));
	}

	static public GenericClazz genericBase(String originclazz, String genericClass) {
		return new GenericClazz(classnameOf(originclazz), classnameOf(genericClass));
	}

	static public GenericClazz generic(String originclazz, String... genericParameterClazz) {
		return new GenericClazz(classnameOf(originclazz), genericParameterClazz);
	}

	static public GenericClazz generic(Class<?> originclazz, String... genericParameterClazz) {
		return new GenericClazz(classnameOf(originclazz), genericParameterClazz);
	}

	static public GenericClazz generic(Class<?> originclazz, Class<?>... genericParameterClazz) {
		return new GenericClazz(classnameOf(originclazz), classnamesOf(genericParameterClazz));
	}

	static public GenericClazz generic(Class<?> originclazz, boolean isarray) {
		return new GenericClazz(classnameOf(originclazz), isarray, null);
	}

	static public GenericClazz generic(String originclazz, boolean isarray) {
		return new GenericClazz(classnameOf(originclazz), isarray, null);
	}

	static public GenericClazz generic(Class<?> originclazz, boolean isarray, String[] genericParameterClazz) {
		return new GenericClazz(classnameOf(originclazz), isarray, genericParameterClazz);
	}

	public String getDescriptor() {
		return arrayOf(originclazz, isarray).getDescriptor();
	}

}