package nebula.tinyasm.sample.ClassBody;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
	String value() default "value";

	String name() default "name";
}
