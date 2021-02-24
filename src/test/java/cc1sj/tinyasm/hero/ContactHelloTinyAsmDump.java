package cc1sj.tinyasm.hero;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.hero.Hello;
import java.lang.Short;
import java.lang.Object;
import java.lang.String;
@SuppressWarnings("unused")
public class ContactHelloTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classWriter = ClassBuilder.make("cc1sj.tinyasm.hero.ContactHello").access(ACC_PUBLIC | ACC_SUPER).body();

classWriter.method("<init>").code(code -> {

	code.LINE(3);
	code.LOAD("this");
	code.SPECIAL(Object.class, "<init>").INVOKE();
	code.RETURN();
});
classWriter.method(0, "say").code(code -> {

	code.LINE(5);
	code.NEW(Hello.class);
	code.DUP();
	code.SPECIAL(Hello.class, "<init>").INVOKE();
	code.STORE("hello",Hello.class);

	code.LINE(7);
	code.LOAD("hello");
	code.LOADConst("wangshilian");
	code.VIRTUAL(Hello.class, "setName")
		.parameter(String.class).INVOKE();

	code.LINE(8);
	code.LOAD("hello");
	code.VIRTUAL(Hello.class, "getName")
		.reTurn(String.class).INVOKE();
	code.STORE("name",String.class);

	code.LINE(9);
	code.LOAD("hello");
	code.LOAD("name");
	code.VIRTUAL(Hello.class, "setName")
		.parameter(String.class).INVOKE();

	code.LINE(10);
	code.LOAD("hello");
	code.LOADConst(10);
	code.VIRTUAL(Hello.class, "setAgeShort")
		.parameter(short.class).INVOKE();

	code.LINE(11);
	code.LOAD("hello");
	code.VIRTUAL(Hello.class, "getAgeShort")
		.reTurn(short.class).INVOKE();
	code.STORE("age",short.class);

	code.LINE(12);
	code.LOAD("hello");
	code.LOAD("age");
	code.VIRTUAL(Hello.class, "setAgeShort")
		.parameter(short.class).INVOKE();

	code.LINE(13);
	code.LOAD("age");
	code.LOADConst(10);
	code.ADD();
	code.CONVERTTO(short.class);
	code.STORE("age2",short.class);

	code.LINE(14);
	code.LOAD("hello");
	code.LOAD("age2");
	code.VIRTUAL(Hello.class, "setAgeShort")
		.parameter(short.class).INVOKE();

	code.LINE(16);
	code.LOAD("hello");
	code.LOADConst(10);
	code.STATIC(Short.class, "valueOf")
		.reTurn(Short.class)
		.parameter(short.class).INVOKE();
	code.VIRTUAL(Hello.class, "setAgeShort2")
		.parameter(Short.class).INVOKE();

	code.LINE(17);
	code.LOAD("hello");
	code.VIRTUAL(Hello.class, "getAgeShort2")
		.reTurn(Short.class).INVOKE();
	code.STORE("ageShort2",Short.class);

	code.LINE(18);
	code.LOAD("hello");
	code.LOAD("ageShort2");
	code.VIRTUAL(Hello.class, "setAgeShort2")
		.parameter(Short.class).INVOKE();

	code.LINE(19);
	code.RETURN();
});
return classWriter.end().toByteArray();
}
}
