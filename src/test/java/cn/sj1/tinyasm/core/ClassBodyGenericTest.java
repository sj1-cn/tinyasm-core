package cn.sj1.tinyasm.core;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.sj1.tinyasm.core.sample.ClassBody.ParameterGenericSample;
import cn.sj1.tinyasm.core.sample.ClassBody.TestAnnotation;
import cn.sj1.tinyasm.core.sample.ClassBody.TestInerface;
import cn.sj1.tinyasm.tools.TinyAsmTestUtils;

public class ClassBodyGenericTest {

	String clazz = ParameterGenericSample.class.getName();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMathClass() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).extends_(Clazz.of(ArrayList.class, Annotation.class)).implements_(TestInerface.class.getName())
				.implements_(Clazz.of(List.class, Annotation.class)).body();
		String[] genericParameterClazz = { String.class.getName() };

//		cw.field(ACC_PRIVATE + ACC_FINAL + ACC_STATIC,"serialVersionUID",long.class.getName());
		cw.private_().field("annotation", Clazz.of(List.class.getName(), genericParameterClazz));

		cw.public_().method("<init>").code(mv -> {
			mv.LINE();
			mv.LOAD(0);
			mv.SPECIAL(ArrayList.class.getName(), "<init>").INVOKE();
			mv.RETURN();
		});
		String[] genericParameterClazz1 = { String.class.getName() };

		cw.private_().method("annotationMethod").return_(Clazz.of(List.class.getName(), genericParameterClazz1)).code(mv -> {
			mv.LINE();
			mv.LOADConstNULL();
			mv.RETURNTop();
		});
		String[] genericParameterClazz2 = { String.class.getName() };

		cw.method("method").parameter("annotation", Clazz.of(List.class.getName(), genericParameterClazz2))

				.code(mv -> {
					mv.LINE();
					mv.LOAD(0);
					mv.LOAD(1);
					mv.PUTFIELD_OF_THIS("annotation");
					mv.LINE();
					mv.RETURN();
				});
		String[] genericParameterClazz3 = { String.class.getName() };

		cw.method("methodGenericVar").parameter("annotation", Clazz.of(List.class.getName(), genericParameterClazz3)).code(mv -> {
			String[] genericParameterClazz4 = { String.class.getName() };
			mv.define(Annotation.of(TestAnnotation.class), "thisannotation", Clazz.of(List.class.getName(), genericParameterClazz4));
			mv.LINE();
			mv.LOAD(1);
			mv.STORE("thisannotation");
			mv.LINE();
			mv.LOAD(0);
			mv.LOAD(1);
			mv.PUTFIELD_OF_THIS("annotation");
			mv.LINE();
			mv.RETURN();
		});

		String codeActual = TinyAsmTestUtils.toString(clazz,cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathString() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).extends_(Clazz.of(ArrayList.class, Annotation.class)).implements_(Clazz.of(TestInerface.class))
				.implements_(Clazz.of(List.class, Annotation.class)).body();
		String[] genericParameterClazz = { String.class.getName() };

//		cw.field(ACC_PRIVATE + ACC_FINAL + ACC_STATIC,"serialVersionUID",long.class.getName());
		cw.private_().field("annotation", Clazz.of(List.class.getName(), genericParameterClazz));

		cw.public_().method("<init>").code(mv -> {
			mv.LINE();
			mv.LOAD(0);
			mv.SPECIAL(ArrayList.class.getName(), "<init>").INVOKE();
			mv.RETURN();
		});
		String[] genericParameterClazz1 = { String.class.getName() };

		cw.private_().method("annotationMethod").return_(Clazz.of(List.class.getName(), genericParameterClazz1)).code(mv -> {
			mv.LINE();
			mv.LOADConstNULL();
			mv.RETURNTop();
		});
		String[] genericParameterClazz2 = { String.class.getName() };

		cw.method("method").parameter("annotation", Clazz.of(List.class.getName(), genericParameterClazz2))

				.code(mv -> {
					mv.LINE();
					mv.LOAD(0);
					mv.LOAD(1);
					mv.PUTFIELD_OF_THIS("annotation");
					mv.LINE();
					mv.RETURN();
				});
		String[] genericParameterClazz3 = { String.class.getName() };

		cw.method("methodGenericVar").parameter("annotation", Clazz.of(List.class.getName(), genericParameterClazz3)).code(mv -> {
			String[] genericParameterClazz4 = { String.class.getName() };
			mv.define(Annotation.of(TestAnnotation.class), "thisannotation", Clazz.of(List.class.getName(), genericParameterClazz4));
			mv.LINE();
			mv.LOAD(1);
			mv.STORE("thisannotation");
			mv.LINE();
			mv.LOAD(0);
			mv.LOAD(1);
			mv.PUTFIELD_OF_THIS("annotation");
			mv.LINE();
			mv.RETURN();
		});

		String codeActual = TinyAsmTestUtils.toString(clazz,cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

}
