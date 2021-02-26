package cc1sj.tinyasm.hero.helperclass;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.hero.helperclass.PageWithParameters;
import java.lang.Object;
@SuppressWarnings("unused")
public class PageWithParametersSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new PageWithParametersSampleTinyAsmDump().__dump__("cc1sj.tinyasm.hero.helperclass.PageWithParametersSample");
	}

	public byte[] __dump__(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className).access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_test(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method("<init>").begin();

		code.LINE(3);
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _test(ClassBody classBody) {
		MethodCode code = classBody.method("test").begin();

		code.LINE(6);
		code.NEW(PageWithParameters.class);
		code.DUP();
		code.LOADConst(3);
		code.LOADConst(3);
		code.SPECIAL(PageWithParameters.class, "<init>")
				.parameter(int.class)
				.parameter(int.class).INVOKE();
		code.STORE("p1",PageWithParameters.class);

		code.LINE(7);
		code.LOADConst(10);
		code.STORE("i",int.class);

		code.LINE(8);
		code.LOADConst(20);
		code.STORE("j",int.class);

		code.LINE(9);
		code.NEW(PageWithParameters.class);
		code.DUP();
		code.LOAD("i");
		code.LOAD("j");
		code.SPECIAL(PageWithParameters.class, "<init>")
				.parameter(int.class)
				.parameter(int.class).INVOKE();
		code.STORE("p2",PageWithParameters.class);

		code.LINE(11);
		code.RETURN();

		code.END();
	}

}
