package cc1sj.tinyasm;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cc1sj.tinyasm.sample.ClassBody.ParameterGenericSample;
import cc1sj.tinyasm.sample.ClassBody.TestAnnotation;
import cc1sj.tinyasm.sample.ClassBody.TestInerface;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

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
		ClassBody cw = ClassBuilder.make(clazz).eXtend(Clazz.of(ArrayList.class, Annotation.class)).implement(TestInerface.class.getName())
				.implement(Clazz.of(List.class, Annotation.class)).body();
		String[] genericParameterClazz = { String.class.getName() };

//		cw.field(ACC_PRIVATE + ACC_FINAL + ACC_STATIC,"serialVersionUID",long.class.getName());
		cw.field("annotation", Clazz.of(List.class.getName(), genericParameterClazz));

		cw.publicMethod("<init>").code(mv -> {
			mv.LINE();
			mv.LOAD(0);
			mv.SPECIAL(ArrayList.class.getName(), "<init>").INVOKE();
			mv.RETURN();
		});
		String[] genericParameterClazz1 = { String.class.getName() };

		cw.privateMethod("annotationMethod").reTurn(Clazz.of(List.class.getName(), genericParameterClazz1)).code(mv -> {
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
		ClassBody cw = ClassBuilder.make(clazz).eXtend(Clazz.of(ArrayList.class, Annotation.class)).implement(Clazz.of(TestInerface.class))
				.implement(Clazz.of(List.class, Annotation.class)).body();
		String[] genericParameterClazz = { String.class.getName() };

//		cw.field(ACC_PRIVATE + ACC_FINAL + ACC_STATIC,"serialVersionUID",long.class.getName());
		cw.field("annotation", Clazz.of(List.class.getName(), genericParameterClazz));

		cw.publicMethod("<init>").code(mv -> {
			mv.LINE();
			mv.LOAD(0);
			mv.SPECIAL(ArrayList.class.getName(), "<init>").INVOKE();
			mv.RETURN();
		});
		String[] genericParameterClazz1 = { String.class.getName() };

		cw.privateMethod("annotationMethod").reTurn(Clazz.of(List.class.getName(), genericParameterClazz1)).code(mv -> {
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
