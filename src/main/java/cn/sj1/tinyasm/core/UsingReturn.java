package cn.sj1.tinyasm.core;

public interface UsingReturn<T> {

	default MethodHeader return_(Class<?> clazz) {
		return return_(Clazz.of(clazz));
	}

	default MethodHeader return_(String clazz) {
		String[] genericParameterClazz = {};
		return return_(Clazz.of(clazz, genericParameterClazz));
	}

	default MethodHeader return_(Class<?> class1, String clazzTarget) {
		return return_(Clazz.of(class1, clazzTarget));
	}

	default MethodHeader return_(Class<?> class1, Class<?> clazzTarget) {
		return return_(Clazz.of(class1, clazzTarget));
	}

	default MethodHeader return_(Class<?> clazz, boolean isarray) {
		return return_(Clazz.of(clazz, isarray));
	}

	default MethodHeader return_(String clazz, boolean isarray) {
		return return_(Clazz.of(clazz, isarray));
	}

	MethodHeader return_(Clazz clazz);

}