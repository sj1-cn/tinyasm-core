package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

import nebula.tinyasm.sample.ClassBody.ParameterStaticSample;
import nebula.tinyasm.sample.ClassBody.TestAnnotation;

public class ClassBodyStaticFieldTest extends TestBase {

	String clazz = ParameterStaticSample.class.getName();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMath() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz)
			.annotation(TestAnnotation.class, new String[] { "name", "secondName" },
					new Object[] { "name", "secondName" })
			.body();

		cw.staticField(Opcodes.ACC_PRIVATE, TestAnnotation.class, "annotation", String.class);
		cw.staticField(Opcodes.ACC_PROTECTED, Annotation.annotation(TestAnnotation.class, "value"),
				"annotationWithDefaultValue", String.class);
		cw.staticField(Opcodes.ACC_PUBLIC, Annotation.annotation(TestAnnotation.class, new String[] { "value", "name" },
				new Object[] { "value", "name" }), "annotationWithDefaultValueAndNamedValue", String.class);
		cw.staticField(Opcodes.ACC_STATIC,
				Annotation.annotation(TestAnnotation.class, new String[] { "name", "secondName" },
						new Object[] { "name", "secondName" }),
				"annotationWithDefaultValueAndNamedValue2", String.class);

		cw.staticField(Opcodes.ACC_PRIVATE, TestAnnotation.class, "genericWithAnnotation",
				TypeUtils.generic(List.class, String.class));
		cw.staticField(Opcodes.ACC_PRIVATE, "genericWithoutAnnotation", TypeUtils.generic(List.class, String.class));

		cw.constructerEmpty();

//		Opcodes.NULL
		cw.privateStaticMethod(String.class, "annotationMethod")
			.ACC_STATIC()
			.annotation(TestAnnotation.class)
			.code(mv -> {
				mv.LINE();

				mv.LOADConstNULL();
				mv.RETURNTop();
				Label l1 = mv.codeNewLabel();
				mv.visitLabel(l1);
			});

		cw.privateStaticMethod(String.class, "annotationWithDefaultValue")
			.annotation(TestAnnotation.class, "value")
			.code(mv -> {
				mv.LINE();

				mv.LOADConstNULL();
				mv.RETURNTop();
				Label l1 = mv.codeNewLabel();
				mv.visitLabel(l1);
			});

		cw.privateStaticMethod(String.class, "annotationWithDefaultValueAndNamedValue")
			.annotation(TestAnnotation.class, new String[] { "value", "name" }, new Object[] { "value", "name" })
			.code(mv -> {
				mv.LINE();

				mv.LOADConstNULL();
				mv.RETURNTop();
				Label l1 = mv.codeNewLabel();
				mv.visitLabel(l1);
			});

		cw.privateStaticMethod(String.class, "annotationWithDefaultValueAndNamedValue2")
			.annotation(TestAnnotation.class, new String[] { "name", "secondName" },
					new Object[] { "name", "secondName" })
			.code(mv -> {
				mv.LINE();

				mv.LOADConstNULL();
				mv.RETURNTop();
				Label l1 = mv.codeNewLabel();
				mv.visitLabel(l1);
			});

		cw.method("method")
			.ACC_STATIC()
			.parameter(TestAnnotation.class, "annotation", String.class)
			.parameter(Annotation.annotation(TestAnnotation.class, "value"), "annotationWithDefaultValue", String.class)
			.parameter(Annotation.annotation(TestAnnotation.class, new String[] { "value", "name" },
					new Object[] { "value", "name" }), "annotationWithDefaultValueAndNamedValue", String.class)
			.parameter(
					Annotation.annotation(TestAnnotation.class, new String[] { "name", "secondName" },
							new Object[] { "name", "secondName" }),
					"annotationWithDefaultValueAndNamedValue2", String.class)
			.code(mv -> {
				mv.LINE();
				mv.LOADConst("annotation");
				mv.PUT_THIS_STATIC(clazz, "annotation");
				mv.LINE();
				mv.LOADConst("annotationWithDefaultValue");
				mv.PUT_THIS_STATIC(clazz, "annotationWithDefaultValue");
				mv.LINE();
				mv.LOADConst("annotationWithDefaultValueAndNamedValue");
				mv.PUT_THIS_STATIC(clazz, "annotationWithDefaultValueAndNamedValue");
				mv.LINE();
				mv.LOADConst("annotationWithDefaultValueAndNamedValue2");
				mv.PUT_THIS_STATIC(clazz, "annotationWithDefaultValueAndNamedValue2");
				mv.LINE();
				mv.RETURN();
			});

		// @formatter:on

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

//	@Test
//	public void printClass() throws IOException {
//		System.out.println(RefineCode.refineCode(toString(clazz)));
//	}

}
