package nebula.tinyasm;

import java.util.function.Consumer;

public interface ClassHeader extends WithAnnotation<ClassHeader>, WithAccess<ClassHeader> {

//	ClassHeader subclass(String clazz);

//	ClassHeader eXtend(String clazz, String... genericClazz);

	default ClassHeader eXtend(Class<?> clazz) {
		return eXtend(Clazz.of(clazz));
	}

	default ClassHeader eXtend(String clazz) {
		return eXtend(Clazz.of(clazz));
	}

	ClassHeader eXtend(Clazz clazz);

	default ClassHeader implement(Class<?> clazz) {
		return implement(Clazz.of(clazz));
	}

	default ClassHeader implement(String clazz) {
		return implement(Clazz.of(clazz));
	}

	default ClassHeader implement(Clazz... clazz) {
		ClassHeader ch =null;
		for (Clazz clazz2 : clazz) {
			ch = implement(clazz2);
		}
		return ch;
	}
	ClassHeader implement(Clazz clazz);

	ClassBody body();

	ClassBuilder body(Consumer<ClassBody> mb);

	default ClassHeader implement(Class<?> clazz, Class<?>... genericClazz) {
		return implement(Clazz.of(clazz, genericClazz));
	}

	default ClassHeader implement(Class<?> clazz, String... genericClazz) {
		return implement(Clazz.of(clazz, genericClazz));
	}

}
