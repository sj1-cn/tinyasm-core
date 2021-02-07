package nebula.tinyasm;

public interface WithReturn<T> {

	default MethodHeader reTurn(Class<?> clazz) {
		return reTurn(TypeUtils.generic(clazz));
	}

	MethodHeader reTurn(GenericClazz clazz);

	default MethodHeader reTurn(String clazz) {
		return reTurn(TypeUtils.generic(clazz));
	}

	default MethodHeader reTurn(Class<?> clazz, String generic) {
		return reTurn(TypeUtils.generic(clazz, generic));
	}

	default MethodHeader reTurn(Class<?> clazz, Class<?> generic) {
		return reTurn(TypeUtils.generic(clazz, generic));
	}

	default MethodHeader reTurn(String clazz, String generic) {
		return reTurn(TypeUtils.generic(clazz, generic));
	}

	default MethodHeader reTurn(Class<?> clazz, boolean isarray) {
		return reTurn(TypeUtils.generic(clazz, isarray));
	}

	default MethodHeader reTurn(String clazz, boolean isarray) {
		return reTurn(TypeUtils.generic(clazz, isarray));
	}
}