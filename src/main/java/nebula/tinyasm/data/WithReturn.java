package nebula.tinyasm.data;

public interface WithReturn<T> {

	default MethodHeader reTurn(Class<?> clazz) {
		return reTurn(GenericClazz.generic(clazz));
	}

	MethodHeader reTurn(GenericClazz clazz);

	default MethodHeader reTurn(String clazz) {
		return reTurn(GenericClazz.generic(clazz));
	}

	default MethodHeader reTurn(Class<?> clazz, boolean isarray) {
		return reTurn(GenericClazz.generic(clazz, isarray));
	}

	default MethodHeader reTurn(String clazz, boolean isarray) {
		return reTurn(GenericClazz.generic(clazz, isarray));
	}
}