package cc1sj.tinyasm;

public interface WithSignature<B> {
	B formalTypeParameter(ClazzFormalTypeParameter clazz);

	default B formalTypeParameter(String name, Clazz clazz) {
		return formalTypeParameter((ClazzFormalTypeParameter) Clazz.formalTypeParameterOf(name, clazz));
	}

	default B formalTypeParameter(String name, Class<?> clazz) {
		return formalTypeParameter((ClazzFormalTypeParameter) Clazz.formalTypeParameterOf(name, Clazz.of(clazz)));
	}
}