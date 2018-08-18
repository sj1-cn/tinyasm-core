package nebula.tinyasm.sample.ClassBody;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
	String value() default "valueDefault";

	String name() default "nameDefault";
	
	String secondName() default "secondNameDefault";
}
