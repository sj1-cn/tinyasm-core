package nebula.tinyasm.sample.ClassBody;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE,FIELD,METHOD,PARAMETER,LOCAL_VARIABLE})
public @interface TestAnnotation {
	String value() default "valueDefault";

	String name() default "nameDefault";
	
	String secondName() default "secondNameDefault";
}
