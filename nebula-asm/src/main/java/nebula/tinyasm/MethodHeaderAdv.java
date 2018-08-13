package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.typeOf;

import java.util.function.Consumer;

import org.objectweb.asm.Type;

public interface MethodHeaderAdv<MC> extends MethodDefineParameter<MC> {

	default MethodHeaderAdv<MC> annotation(Class<?> annotationClass) {
		return annotation(typeOf(annotationClass), null);
	}

	default MethodHeaderAdv<MC> annotation(Class<?> annotationClass, Object value) {
		return annotation(typeOf(annotationClass), value);
	}

	default MethodHeaderAdv<MC> annotation(Class<?> annotationClass, String name, Object value) {
		return annotation(typeOf(annotationClass), name, value);
	}

	default MethodHeaderAdv<MC> annotation(Type type) {
		return annotation(type, null);
	}

	MethodHeaderAdv<MC> annotation(Type type, Object value);

	MethodHeaderAdv<MC> annotation(Type type, String name, Object value);

	MC codeBegin();

	void code(Consumer<MC> invocation);

	default MethodHeaderAdv<MC> parameterAnnotation(Class<?> annotationClass) {
		return parameterAnnotation(typeOf(annotationClass), null);
	}

	default MethodHeaderAdv<MC> parameterAnnotation(Type type) {
		return parameterAnnotation(type, null);
	}

	MethodHeaderAdv<MC> parameterAnnotation(Type type, Object value);
}