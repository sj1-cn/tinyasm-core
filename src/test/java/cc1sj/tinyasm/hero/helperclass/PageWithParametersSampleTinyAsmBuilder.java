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
import static cc1sj.tinyasm.TinyAsmBuilder.*;

@SuppressWarnings("unused")
public class PageWithParametersSampleTinyAsmBuilder {

	public static byte[] dump() throws Exception {

		ClassBody classBody = ClassBuilder.make("cc1sj.tinyasm.hero.helperclass.PageWithParametersSample").access(ACC_PUBLIC | ACC_SUPER)
				.body();

		{
			MethodCode code = classBody.method("<init>").begin();

			code.LINE(3);
			code.LOAD("this");
			code.SPECIAL(Object.class, "<init>").INVOKE();
			code.RETURN();
			code.END();
		}

		{
			MethodCode code = classBody.method("test").begin();

			PageWithParameters p1 = ctor(PageWithParameters.class, 3, 3);
			int i = cst(10);
			int j = cst(20);
			PageWithParameters p2 = ctor(PageWithParameters.class, i, j);

			code.LINE(11);
			code.RETURN();
			code.END();
		}

		return classBody.end().toByteArray();
	}
}
