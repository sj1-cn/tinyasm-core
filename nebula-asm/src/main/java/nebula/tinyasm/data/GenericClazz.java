package nebula.tinyasm.data;

import static nebula.tinyasm.util.TypeUtils.*;
import static nebula.tinyasm.util.TypeUtils.signatureOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;

public class GenericClazz {
	public String clazz;
	public String[] genericClazz;
	public boolean isarray;

	public GenericClazz(String clazz, boolean isarray, String[] genericClazz) {
		super();
		this.clazz = clazz;
		this.genericClazz = genericClazz;
		this.isarray = isarray;
	}

	public GenericClazz(String clazz, String[] genericClazz) {
		super();
		this.clazz = clazz;
		this.genericClazz = genericClazz;
	}

	public String signatureAnyway() {
		String signature;
		if (genericClazz != null && genericClazz.length > 0) {
			signature = signatureOf(arrayOf(clazz, isarray), typeOf(genericClazz));
		} else {
			signature = typeOf(clazz).getDescriptor();
		}
		return signature;
	}

	public String signatureWhenNeed() {
		if (genericClazz != null && genericClazz.length > 0) {
			return signatureOf(arrayOf(clazz, isarray), typeOf(genericClazz));
		} else {
			return null;
		}
	}

	public boolean needSignature() {
		return genericClazz != null && genericClazz.length > 0;
	}

	static public GenericClazz clazz(GenericClazz clazz) {
		return clazz;
	}

	static public GenericClazz clazz(Class<?> clazz) {
		return new GenericClazz(classnameOf(clazz), null);
	}

	static public GenericClazz generic(String clazz) {
		return new GenericClazz(classnameOf(clazz), null);
	}

	static public GenericClazz clazz(String clazz, String... genericClazz) {
		return new GenericClazz(classnameOf(clazz), genericClazz);
	}
	
	static public GenericClazz clazz(Class<?> clazz, String... genericClazz) {
		return new GenericClazz(classnameOf(clazz), genericClazz);
	}

	static public GenericClazz clazz(Class<?> clazz, Class<?>... genericClazz) {
		return new GenericClazz(classnameOf(clazz), classnamesOf(genericClazz));
	}

	static public GenericClazz clazz(Class<?> clazz, boolean isarray) {
		return new GenericClazz(classnameOf(clazz), isarray, null);
	}

	static public GenericClazz clazz(String clazz, boolean isarray) {
		return new GenericClazz(classnameOf(clazz), isarray, null);
	}

	static public GenericClazz clazz(Class<?> clazz, boolean isarray, String[] genericClazz) {
		return new GenericClazz(classnameOf(clazz), isarray, genericClazz);
	}

	public String getDescriptor() {
		return arrayOf(clazz, isarray).getDescriptor();
	}

}