package cn.sj1.tinyasm;

public interface UsingSignature<B> {
	B formalTypeParameter(ClazzFormalTypeParameter clazz);

	default B formalTypeParameter(String name, Clazz clazz) {
		return formalTypeParameter(Clazz.formalTypeParameterOf(name, clazz));
	}

	default B formalTypeParameter(String name, Class<?> clazz) {
		return formalTypeParameter(Clazz.formalTypeParameterOf(name, Clazz.of(clazz)));
	}
}