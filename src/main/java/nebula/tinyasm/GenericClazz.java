package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.*;
import static nebula.tinyasm.util.TypeUtils.signatureOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;

import org.objectweb.asm.Type;

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
			signature = signatureOf(arrayOf(originclazzName, isarray), typeOf(genericParameterClazz));
		} else if (genericClazz != null) {
			return typeOf(genericClazz).getDescriptor();
		} else {
			signature = typeOf(originclazzName).getDescriptor();
		}
		return signature;
	}

	public String signatureWhenNeed() {
		if (genericParameterClazz != null && genericParameterClazz.length > 0) {
			return signatureOf(arrayOf(originclazzName, isarray), typeOf(genericParameterClazz));
		} else if (genericClazz != null) {
			return typeOf(genericClazz).getDescriptor();
		} else {
			return null;
		}
	}

	public boolean needSignature() {
		return (genericParameterClazz != null && genericParameterClazz.length > 0) || genericClazz != null;
	}

	static public GenericClazz generic(GenericClazz originclazzName) {
		return originclazzName;
	}

	static public GenericClazz generic(Class<?> originclazzName) {
		return new GenericClazz(classnameOf(originclazzName));
	}

	//TODO need fix bug
	static public GenericClazz generic(Type type) {
		return new GenericClazz(type.getInternalName());
	}
	static public GenericClazz generic(String originclazzName) {
		return new GenericClazz(classnameOf(originclazzName));
	}

	static public GenericClazz genericBase(Class<?> originclazzName, Class<?> genericClass) {
		return new GenericClazz(classnameOf(originclazzName), classnameOf(genericClass));
	}

	static public GenericClazz genericBase(Class<?> originclazzName, String genericClass) {
		return new GenericClazz(classnameOf(originclazzName), classnameOf(genericClass));
	}

	static public GenericClazz genericBase(String originclazzName, String genericClass) {
		return new GenericClazz(classnameOf(originclazzName), classnameOf(genericClass));
	}

	static public GenericClazz generic(String originclazzName, String... genericParameterClazz) {
		return new GenericClazz(classnameOf(originclazzName), genericParameterClazz);
	}

	static public GenericClazz generic(Class<?> originclazzName, String... genericParameterClazz) {
		return new GenericClazz(classnameOf(originclazzName), genericParameterClazz);
	}

	static public GenericClazz generic(Class<?> originclazzName, Class<?>... genericParameterClazz) {
		return new GenericClazz(classnameOf(originclazzName), classnamesOf(genericParameterClazz));
	}

	static public GenericClazz generic(Class<?> originclazzName, boolean isarray) {
		return new GenericClazz(classnameOf(originclazzName), isarray, null);
	}

	static public GenericClazz generic(String originclazzName, boolean isarray) {
		return new GenericClazz(classnameOf(originclazzName), isarray, null);
	}

	static public GenericClazz generic(Class<?> originclazzName, boolean isarray, String[] genericParameterClazz) {
		return new GenericClazz(classnameOf(originclazzName), isarray, genericParameterClazz);
	}

	public String getDescriptor() {
		return arrayOf(originclazzName, isarray).getDescriptor();
	}

}