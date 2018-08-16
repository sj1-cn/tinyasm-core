package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.nameOf;

import java.util.function.Consumer;

import nebula.tinyasm.data.WithAnnotation;
import nebula.tinyasm.data.WithDefineParameter;

public interface MethodHeader extends WithDefineParameter<MethodHeader>, WithAnnotation<MethodHeader> {
	MethodCode begin();

	default MethodHeader tHrow(Class<?>... clazz) {
		return tHrow(nameOf(clazz));
	}

	MethodHeader tHrow(String... clazz);

	default MethodHeader reTurn(Class<?> clazz) {
		return reTurn(nameOf(clazz));
	}

	MethodHeader reTurn(String clazz);

	void code(Consumer<MethodCode> invocation);

}