package cc1sj.tinyasm;

public interface WithReturn<T> {

	default MethodHeader reTurn(Class<?> clazz) {
		return reTurn(Clazz.of(clazz));
	}

	default MethodHeader reTurn(String clazz) {
		String[] genericParameterClazz = {};
		return reTurn(Clazz.of(clazz, genericParameterClazz));
	}

	default MethodHeader reTurn(Class<?> class1, String clazzTarget){
		return reTurn(Clazz.of(class1,clazzTarget));
	}
	default MethodHeader reTurn(Class<?> class1, Class<?> clazzTarget){
		return reTurn(Clazz.of(class1,clazzTarget));
	}
	default MethodHeader reTurn(Class<?> clazz, boolean isarray) {
		return reTurn(Clazz.of(clazz, isarray));
	}

	default MethodHeader reTurn(String clazz, boolean isarray) {
		return reTurn(Clazz.of(clazz, isarray));
	}

	MethodHeader reTurn(Clazz clazz);

}