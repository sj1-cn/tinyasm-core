package cn.sj1.tinyasm.core;

import java.util.List;

public interface WithDefineVar {

	default void define(List<Field> defines) {
		for (Field define : defines) {
			define(define.name, define.clazz);
		}
	}

	default int define(String name, String clazz) {
		return define(name, Clazz.of(clazz));
	}

	default int define(String name, Class<?> clazz) {
		return define(name, Clazz.of(clazz));
	}

	default int define(String name, String clazz, boolean isarray) {
		return define(name, Clazz.of(clazz, isarray));
	}

	default int define(String name, Class<?> clazz, boolean isarray) {
		return define(name, Clazz.of(clazz, isarray));
	}

	int define(String name, Clazz clazz);

	int define(Annotation annotation, String name, Clazz clazz);
}