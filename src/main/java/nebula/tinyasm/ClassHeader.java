package nebula.tinyasm;

import static nebula.tinyasm.TypeUtils.classnamesOf;

import java.util.function.Consumer;


public interface ClassHeader extends WithAnnotation<ClassHeader>, WithAccess<ClassHeader> {

	default ClassHeader eXtend(Class<?> clazz, Class<?>... genericClazz) {
		return eXtend(clazz.getName(), classnamesOf(genericClazz));
	}

	default ClassHeader eXtend(Class<?> clazz, String... genericClazz) {
		return eXtend(clazz.getName(), genericClazz);
	}

	default ClassHeader eXtend(String clazz, Class<?>... genericClazz) {
		return eXtend(clazz, classnamesOf(genericClazz));
	}

	default ClassHeader eXtend(Class<?> clazz) {
		return subclass(clazz.getName());
	}

	ClassHeader subclass(String clazz);
	
	ClassHeader eXtend(String clazz, String... genericClazz);

	default ClassHeader implement(Class<?> clazz, Class<?>... genericClazz) {
		return implement(clazz.getName(), classnamesOf(genericClazz));
	}

	default ClassHeader implement(Class<?> clazz, String... genericClazz) {
		return implement(clazz.getName(), genericClazz);
	}

	default ClassHeader implement(String clazz, Class<?>... genericClazz) {
		return implement(clazz, classnamesOf(genericClazz));
	}

	default ClassHeader implement(Class<?> clazz) {
		return implement(clazz.getName());
	}

	ClassHeader implement(String clazz);

	ClassHeader implement(String clazz, String... genericClazz);

	ClassBody body();

	ClassBuilder body(Consumer<ClassBody> mb);

}
