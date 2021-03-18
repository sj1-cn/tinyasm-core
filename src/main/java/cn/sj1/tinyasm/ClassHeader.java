package cn.sj1.tinyasm;

import java.util.function.Consumer;

public interface ClassHeader extends UsingAnnotation<ClassHeader>, UsingAccess<ClassHeader>, UsingImplements, UsingExtends {

	ClassHeader formalTypeParameter(String name, Clazz clazz);

	ClassBody body();

	ClassBuilder body(Consumer<ClassBody> mb);

}
