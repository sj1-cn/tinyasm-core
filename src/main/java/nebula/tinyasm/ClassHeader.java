package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.classnameOf;
import static nebula.tinyasm.util.TypeUtils.classnamesOf;

import java.util.function.Consumer;

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
		return subclass(classnameOf(clazz));
	}

	ClassHeader subclass(String clazz);

	ClassHeader eXtend(String clazz, String... genericClazz);

	default ClassHeader implement(Class<?> clazz, Class<?>... genericClazz) {
		return implement(classnameOf(clazz), classnamesOf(genericClazz));
	}

	default ClassHeader implement(Class<?> clazz, String... genericClazz) {
		return implement(classnameOf(clazz), classnamesOf(genericClazz));
	}

	default ClassHeader implement(String clazz, Class<?>... genericClazz) {
		return implement(classnameOf(clazz), classnamesOf(genericClazz));
	}

	default ClassHeader implement(Class<?> clazz) {
		return implement(classnameOf(clazz));
	}

	ClassHeader implement(String clazz);

	ClassHeader implement(String clazz, String... genericClazz);

	ClassBody body();

	ClassBuilder body(Consumer<ClassBody> mb);

}
