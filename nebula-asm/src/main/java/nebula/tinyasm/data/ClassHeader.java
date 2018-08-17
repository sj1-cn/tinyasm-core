package nebula.tinyasm.data;

import static nebula.tinyasm.util.TypeUtils.classnameOf;
import static nebula.tinyasm.util.TypeUtils.classnamesOf;

import java.util.function.Consumer;

import nebula.tinyasm.ClassBuilder;

public interface ClassHeader extends WithAnnotation<ClassHeader>, WithAccess<ClassHeader> {

	default ClassHeader eXtend(Class<?> clazz, Class<?>... genericClazz) {
		return eXtend(classnameOf(clazz), classnamesOf(genericClazz));
	}

	default ClassHeader eXtend(Class<?> clazz, String... genericClazz) {
		return eXtend(classnameOf(clazz), classnamesOf(genericClazz));
	}

	default ClassHeader eXtend(String clazz, Class<?>... genericClazz) {
		return eXtend(classnameOf(clazz), classnamesOf(genericClazz));
	}

	default ClassHeader eXtend(Class<?> clazz) {
		return eXtend(classnameOf(clazz));
	}

	ClassHeader eXtend(String clazz);

	ClassHeader eXtend(String clazz, String... genericClazz);

	default ClassHeader imPlements(Class<?> clazz, Class<?>... genericClazz) {
		return imPlements(classnameOf(clazz), classnamesOf(genericClazz));
	}

	default ClassHeader imPlements(Class<?> clazz, String... genericClazz) {
		return imPlements(classnameOf(clazz), classnamesOf(genericClazz));
	}

	default ClassHeader imPlements(String clazz, Class<?>... genericClazz) {
		return imPlements(classnameOf(clazz), classnamesOf(genericClazz));
	}

	default ClassHeader imPlements(Class<?> clazz) {
		return imPlements(classnameOf(clazz));
	}

	ClassHeader imPlements(String clazz);

	ClassHeader imPlements(String clazz, String... genericClazz);

	ClassBody body();

	ClassBuilder body(Consumer<ClassBody> mb);

}
