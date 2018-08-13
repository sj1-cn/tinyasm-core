package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.typeOf;

import java.util.function.Consumer;

import org.objectweb.asm.Type;

public interface ClassHeader {

	default ClassHeader annotation(Class<?> annotationClass) {
		return vmAnnotation(typeOf(annotationClass), null);
	}

	default ClassHeader annotation(String annotationClass) {
		return vmAnnotation(typeOf(annotationClass), null);
	}

	default ClassHeader annotation(Class<?> annotationClass, Object value) {
		return vmAnnotation(typeOf(annotationClass), value);
	}

	ClassHeader vmAnnotation(Type annotationType, Object value);

	ClassBody body();

	ClassBuilder body(Consumer<ClassBody> mb);

}
