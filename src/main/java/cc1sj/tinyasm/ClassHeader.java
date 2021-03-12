package cc1sj.tinyasm;

import java.util.function.Consumer;

public interface ClassHeader extends UsingAnnotation<ClassHeader>, UsingAccess<ClassHeader>, UsingImplements, UsingExtends {

	ClassHeader formalTypeParameter(String name, Clazz clazz);

	ClassBody body();

	ClassBuilder body(Consumer<ClassBody> mb);

}
