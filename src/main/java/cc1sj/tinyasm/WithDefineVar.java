package cc1sj.tinyasm;

import java.util.List;

public interface WithDefineVar {

	default void define(List<Field> defines) {
		for (Field define : defines) {
			define(define.name, define.clazz);
		}
	}

	default void define(String name, String clazz) {
		 define(name, Clazz.of(clazz));
	}

	default void define(String name, Class<?> clazz) {
		 define(name, Clazz.of(clazz));
	}

	default void define(String name, String clazz, boolean isarray) {
		 define(name, Clazz.of(clazz, isarray));
	}

	default void define(String name, Class<?> clazz, boolean isarray) {
		 define(name, Clazz.of(clazz, isarray));
	}

	void define( String name, Clazz clazz);


	void define(Annotation annotation, String name, Clazz clazz);
}