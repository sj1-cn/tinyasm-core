package cc1sj.tinyasm;

import static org.junit.Assert.assertEquals;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Label;

import cc1sj.tinyasm.sample.ClassBody.ParameterAnnotationSample;
import cc1sj.tinyasm.sample.ClassBody.TestAnnotation;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class ClassBodyAnnotationTest {

	String clazz = ParameterAnnotationSample.class.getName();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMath() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz)
				.annotation(TestAnnotation.class, new String[] { "name", "secondName" }, new Object[] { "name", "secondName" }).body();

		cw.field(ACC_PRIVATE, Annotation.of(TestAnnotation.class), "annotation", Clazz.of(String.class));
		cw.field(ACC_PRIVATE, Annotation.of(TestAnnotation.class, "value"), "annotationWithDefaultValue", Clazz.of(String.class));
		cw.field(ACC_PRIVATE, Annotation.of(TestAnnotation.class, new String[] { "value", "name" }, new Object[] { "value", "name" }),
				"annotationWithDefaultValueAndNamedValue", Clazz.of(String.class));
		cw.field(ACC_PRIVATE,
				Annotation.of(TestAnnotation.class, new String[] { "name", "secondName" }, new Object[] { "name", "secondName" }),
				"annotationWithDefaultValueAndNamedValue2", Clazz.of(String.class));

		cw.constructerEmpty();

//		Opcodes.NULL
		cw.private_().method("annotationMethod").return_(String.class).annotation(TestAnnotation.class).code(mv -> {
			mv.LINE();

			mv.LOADConstNULL();
			mv.RETURNTop();
			Label l1 = mv.codeNewLabel();
			mv.visitLabel(l1);
		});

		cw.private_().method("annotationWithDefaultValue").return_(String.class).annotation(TestAnnotation.class, "value").code(mv -> {
			mv.LINE();

			mv.LOADConstNULL();
			mv.RETURNTop();
			Label l1 = mv.codeNewLabel();
			mv.visitLabel(l1);
		});

		cw.private_().method("annotationWithDefaultValueAndNamedValue").return_(String.class)
				.annotation(TestAnnotation.class, new String[] { "value", "name" }, new Object[] { "value", "name" }).code(mv -> {
					mv.LINE();

					mv.LOADConstNULL();
					mv.RETURNTop();
					Label l1 = mv.codeNewLabel();
					mv.visitLabel(l1);
				});

		cw.private_().method("annotationWithDefaultValueAndNamedValue2").return_(String.class)
				.annotation(TestAnnotation.class, new String[] { "name", "secondName" }, new Object[] { "name", "secondName" }).code(mv -> {
					mv.LINE();

					mv.LOADConstNULL();
					mv.RETURNTop();
					Label l1 = mv.codeNewLabel();
					mv.visitLabel(l1);
				});

		cw.public_().method("publicMethod").parameter(Annotation.of(TestAnnotation.class), "annotation", Clazz.of(String.class))
				.parameter(Annotation.of(TestAnnotation.class, "value"), "annotationWithDefaultValue", Clazz.of(String.class))
				.parameter(Annotation.of(TestAnnotation.class, new String[] { "value", "name" }, new Object[] { "value", "name" }),
						"annotationWithDefaultValueAndNamedValue", Clazz.of(String.class))
				.parameter(
						Annotation.of(TestAnnotation.class, new String[] { "name", "secondName" }, new Object[] { "name", "secondName" }),
						"annotationWithDefaultValueAndNamedValue2", Clazz.of(String.class))
				.code(mv -> {
					mv.LINE();

					mv.LOADConst("annotation");
					mv.STORE("annotation");
					mv.LINE();
					mv.LOADConst("annotationWithDefaultValue");
					mv.STORE("annotationWithDefaultValue");
					mv.LINE();
					mv.LOADConst("annotationWithDefaultValueAndNamedValue");
					mv.STORE("annotationWithDefaultValueAndNamedValue");
					mv.LINE();
					mv.LOADConst("annotationWithDefaultValueAndNamedValue2");
					mv.STORE("annotationWithDefaultValueAndNamedValue2");
					mv.LINE();
					mv.RETURN();
				});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

}
