package cc1sj.tinyasm;

public interface UsingImplements {

	default ClassHeader implements_(Class<?> clazz) {
		return implements_(Clazz.of(clazz));
	}

	default ClassHeader implements_(String clazz) {
		return implements_(Clazz.of(clazz));
	}

	default ClassHeader implements_(Clazz... clazz) {
		ClassHeader ch = null;
		for (Clazz clazz2 : clazz) {
			ch = implements_(clazz2);
		}
		return ch;
	}

	default ClassHeader implements_(Class<?> clazz, Class<?>... genericClazz) {
		return implements_(Clazz.of(clazz, genericClazz));
	}

	default ClassHeader implements_(Class<?> clazz, String... genericClazz) {
		return implements_(Clazz.of(clazz, genericClazz));
	}

	ClassHeader implements_(Clazz clazz);
}
