package cn.sj1.tinyasm.core;

public interface AdvUsingClassImplements {

	AdvAfterClassImplements implements_(Clazz... interfaceClass);
	AdvAfterClassImplements implements_(Class<?> interfaceClass);
	AdvAfterClassImplements implements_(Class<?> interfaceClass,Class<?> genericClass);

}