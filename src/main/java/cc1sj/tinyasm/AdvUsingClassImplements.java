package cc1sj.tinyasm;

public interface AdvUsingClassImplements {

	AdvAfterClassImplements implements_(Clazz... interfaceClass);
	AdvAfterClassImplements implements_(Class<?> interfaceClass);
	AdvAfterClassImplements implements_(Class<?> interfaceClass,Class<?> genericClass);

}