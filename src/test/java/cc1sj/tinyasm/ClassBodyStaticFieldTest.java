package cc1sj.tinyasm;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

import cc1sj.tinyasm.sample.ClassBody.ParameterStaticSample;
import cc1sj.tinyasm.sample.ClassBody.TestAnnotation;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class ClassBodyStaticFieldTest {

	String clazz = ParameterStaticSample.class.getName();

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

		cw.staticField(Opcodes.ACC_PRIVATE, Annotation.of(TestAnnotation.class), "annotation", Clazz.of(String.class));
		cw.staticField(Opcodes.ACC_PROTECTED, Annotation.of(TestAnnotation.class, "value"), "annotationWithDefaultValue",
				Clazz.of(String.class));
		cw.staticField(Opcodes.ACC_PUBLIC,
				Annotation.of(TestAnnotation.class, new String[] { "value", "name" }, new Object[] { "value", "name" }),
				"annotationWithDefaultValueAndNamedValue", Clazz.of(String.class));
		cw.staticField(Opcodes.ACC_STATIC,
				Annotation.of(TestAnnotation.class, new String[] { "name", "secondName" }, new Object[] { "name", "secondName" }),
				"annotationWithDefaultValueAndNamedValue2", Clazz.of(String.class));
		Class<?>[] genericParameterClazz = { String.class };

		cw.staticField(Opcodes.ACC_PRIVATE, Annotation.of(TestAnnotation.class), "genericWithAnnotation",
				Clazz.of(List.class, genericParameterClazz));
		Class<?>[] genericParameterClazz1 = { String.class };
		cw.staticField(Opcodes.ACC_PRIVATE, "genericWithoutAnnotation", Clazz.of(List.class, genericParameterClazz1));

		cw.constructerEmpty();

//		Opcodes.NULL
		cw.privateStaticMethod(String.class, "annotationMethod").static_().annotation(TestAnnotation.class).code(mv -> {
			mv.LINE();

			mv.LOADConstNULL();
			mv.RETURNTop();
			Label l1 = mv.codeNewLabel();
			mv.visitLabel(l1);
		});

		cw.privateStaticMethod(String.class, "annotationWithDefaultValue").annotation(TestAnnotation.class, "value").code(mv -> {
			mv.LINE();

			mv.LOADConstNULL();
			mv.RETURNTop();
			Label l1 = mv.codeNewLabel();
			mv.visitLabel(l1);
		});

		cw.privateStaticMethod(String.class, "annotationWithDefaultValueAndNamedValue")
				.annotation(TestAnnotation.class, new String[] { "value", "name" }, new Object[] { "value", "name" }).code(mv -> {
					mv.LINE();

					mv.LOADConstNULL();
					mv.RETURNTop();
					Label l1 = mv.codeNewLabel();
					mv.visitLabel(l1);
				});

		cw.privateStaticMethod(String.class, "annotationWithDefaultValueAndNamedValue2")
				.annotation(TestAnnotation.class, new String[] { "name", "secondName" }, new Object[] { "name", "secondName" }).code(mv -> {
					mv.LINE();

					mv.LOADConstNULL();
					mv.RETURNTop();
					Label l1 = mv.codeNewLabel();
					mv.visitLabel(l1);
				});

		cw.publicMethod("method").static_().parameter(Annotation.of(TestAnnotation.class), "annotation", Clazz.of(String.class))
				.parameter(Annotation.of(TestAnnotation.class, "value"), "annotationWithDefaultValue", Clazz.of(String.class))
				.parameter(Annotation.of(TestAnnotation.class, new String[] { "value", "name" }, new Object[] { "value", "name" }),
						"annotationWithDefaultValueAndNamedValue", Clazz.of(String.class))
				.parameter(
						Annotation.of(TestAnnotation.class, new String[] { "name", "secondName" }, new Object[] { "name", "secondName" }),
						"annotationWithDefaultValueAndNamedValue2", Clazz.of(String.class))
				.code(mv -> {
					mv.LINE();
					mv.LOADConst("annotation");
					mv.PUT_THIS_STATIC("annotation");
					mv.LINE();
					mv.LOADConst("annotationWithDefaultValue");
					mv.PUT_THIS_STATIC("annotationWithDefaultValue");
					mv.LINE();
					mv.LOADConst("annotationWithDefaultValueAndNamedValue");
					mv.PUT_THIS_STATIC("annotationWithDefaultValueAndNamedValue");
					mv.LINE();
					mv.LOADConst("annotationWithDefaultValueAndNamedValue2");
					mv.PUT_THIS_STATIC("annotationWithDefaultValueAndNamedValue2");
					mv.LINE();
					mv.RETURN();
				});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}


}
