package cc1sj.tinyasm.hero.advasmproxy;

import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.hero.advasmproxy.AdvAsmProxyWithTwoParametersSample;

import org.objectweb.asm.Type;

import static cc1sj.tinyasm.Adv.*;
import static org.objectweb.asm.Opcodes.*;

import cc1sj.tinyasm.AdvClassBuilder;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;

import java.lang.Object;

@SuppressWarnings("unused")
public class AdvAsmProxyInvokeNewWithTwoParametersSampleAdvAsmBuilder {

	public static byte[] dump() throws Exception {

		AdvClassBuilder classBody = publicClass_("cc1sj.tinyasm.hero.helperclass.AdvAsmProxyInvokeNewWithTwoParametersSample").enterClassBody();

		classBody.public_().method("<init>").code(code -> {
			code.LINE();
			code.LOAD("this");
			code.SPECIAL(Object.class, "<init>").INVOKE();
		});

		classBody.public_().method("test").code(code -> {
			AdvAsmProxyWithTwoParametersSample p1 = __("p1",new_(AdvAsmProxyWithTwoParametersSample.class, 3, 3));
			int i = __("i",cst(10));
			int j = __("j",cst(20));
			AdvAsmProxyWithTwoParametersSample p2 = __("p2",new_(AdvAsmProxyWithTwoParametersSample.class, i, j));
		});

		return classBody.end().toByteArray();
	}
}
