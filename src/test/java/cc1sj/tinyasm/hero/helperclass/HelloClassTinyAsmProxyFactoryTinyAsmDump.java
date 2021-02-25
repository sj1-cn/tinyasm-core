package cc1sj.tinyasm.hero.helperclass;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.hero.helperclass.HelloClassTinyAsmProxy;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.hero.TinyAsmProxyFactory;
import java.lang.Object;
import java.lang.String;
@SuppressWarnings("unused")
public class HelloClassTinyAsmProxyFactoryTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classBody = ClassBuilder.make("cc1sj.tinyasm.hero.helperclass.HelloClassTinyAsmProxyFactory", null, TinyAsmProxyFactory.class).access(ACC_PUBLIC | ACC_SUPER).body();

{
	MethodCode code = classBody.method("<init>").begin();

	code.LINE(6);
	code.LOAD("this");
	code.SPECIAL(Object.class, "<init>").INVOKE();
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method(Object.class, "build")
	.parameter("code",MethodCode.class)
	.parameter("__referName",String.class).begin();

	code.LINE(9);
	code.NEW(HelloClassTinyAsmProxy.class);
	code.DUP();
	code.LOAD("code");
	code.LOAD("__referName");
	code.SPECIAL(HelloClassTinyAsmProxy.class, "<init>")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();
	code.RETURNTop();
	code.END();
}

return classBody.end().toByteArray();
}
}
