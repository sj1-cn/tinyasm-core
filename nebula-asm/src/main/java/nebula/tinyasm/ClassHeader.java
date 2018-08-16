package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.nameOf;

import java.util.function.Consumer;

import nebula.tinyasm.data.WithAccess;
import nebula.tinyasm.data.WithAnnotation;

public interface ClassHeader extends WithAnnotation<ClassHeader>, WithAccess<ClassHeader> {

	default ClassHeader eXtend(Class<?> clazz, Class<?>... genericClazz) {
		return eXtend(nameOf(clazz), nameOf(genericClazz));
	}

	default ClassHeader eXtend(Class<?> clazz, String... genericClazz) {
		return eXtend(nameOf(clazz), nameOf(genericClazz));
	}

	default ClassHeader eXtend(String clazz, Class<?>... genericClazz) {
		return eXtend(nameOf(clazz), nameOf(genericClazz));
	}

	default ClassHeader eXtend(Class<?> clazz) {
		return eXtend(nameOf(clazz));
	}

	ClassHeader eXtend(String clazz);

	ClassHeader eXtend(String clazz, String... genericClazz);

	default ClassHeader imPlements(Class<?> clazz, Class<?>... genericClazz) {
		return imPlements(nameOf(clazz), nameOf(genericClazz));
	}

	default ClassHeader imPlements(Class<?> clazz, String... genericClazz) {
		return imPlements(nameOf(clazz), nameOf(genericClazz));
	}

	default ClassHeader imPlements(String clazz, Class<?>... genericClazz) {
		return imPlements(nameOf(clazz), nameOf(genericClazz));
	}

	ClassHeader imPlements(String clazz);

	ClassHeader imPlements(String clazz, String... genericClazz);

	ClassBody body();

	ClassBuilder body(Consumer<ClassBody> mb);

}
