package nebula.tinyasm.api;

import static nebula.tinyasm.util.TypeUtils.typeOf;

import java.util.function.Consumer;

import org.objectweb.asm.Type;

public interface MethodHeader<C> extends MethodDefineParameter<MethodHeader<C>> {

	default MethodHeader<C> annotation(Class<?> annotationClass) {
		return annotation(typeOf(annotationClass), null);
	}

	default MethodHeader<C> annotation(Class<?> annotationClass, Object value) {
		return annotation(typeOf(annotationClass), value);
	}

	default MethodHeader<C> annotation(Class<?> annotationClass, String name, Object value) {
		return annotation(typeOf(annotationClass), name, value);
	}

	default MethodHeader<C> annotation(Type type) {
		return annotation(type, null);
	}

	MethodHeader<C> annotation(Type type, Object value);

	MethodHeader<C> annotation(Type type, String name, Object value);

	C codeBegin();

	void code(Consumer<C> invocation);

	default MethodHeader<C> parameterAnnotation(Class<?> annotationClass) {
		return parameterAnnotation(typeOf(annotationClass), null);
	}

	default MethodHeader<C> parameterAnnotation(Type type) {
		return parameterAnnotation(type, null);
	}

	MethodHeader<C> parameterAnnotation(Type type, Object value);
}