package nebula.tinyasm;

public interface WithReturn<T> {

	default MethodHeader reTurn(Class<?> clazz) {
		return reTurn(Clazz.of(clazz));
	}

	default MethodHeader reTurn(String clazz) {
		String[] genericParameterClazz = {};
		return reTurn(Clazz.of(clazz, genericParameterClazz));
	}

	default MethodHeader reTurn(Class<?> clazz, boolean isarray) {
		return reTurn(Clazz.of(clazz, isarray));
	}

	default MethodHeader reTurn(String clazz, boolean isarray) {
		return reTurn(Clazz.of(clazz, isarray));
	}

	MethodHeader reTurn(Clazz clazz);

}