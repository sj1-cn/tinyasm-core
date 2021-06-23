package cn.sj1.tinyasm.core.sample.ClassBody;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE,FIELD,METHOD,PARAMETER,LOCAL_VARIABLE})
public @interface TestAnnotation {
	String value() default "valueDefault";

	String name() default "nameDefault";
	
	String secondName() default "secondNameDefault";
}
