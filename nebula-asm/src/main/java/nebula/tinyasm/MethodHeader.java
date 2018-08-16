package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.nameOf;

import java.util.function.Consumer;

public interface MethodHeader<MC> extends WithDefineParameter<MethodHeader<MC>>, WithAnnotation<MethodHeader<MC>> {
	MC begin();

	default MethodHeader<MC> tHrow(Class<?>... clazz) {
		return tHrow(nameOf(clazz));
	}

	MethodHeader<MC> tHrow(String... clazz);

	default MethodHeader<MC> reTurn(Class<?> clazz) {
		return reTurn(nameOf(clazz));
	}

	MethodHeader<MC> reTurn(String clazz);

	void code(Consumer<MC> invocation);

}