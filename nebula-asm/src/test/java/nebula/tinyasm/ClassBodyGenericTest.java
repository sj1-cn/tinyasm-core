package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Label;

import nebula.tinyasm.data.Annotation;
import nebula.tinyasm.data.ClassBody;
import nebula.tinyasm.data.GenericClazz;
import nebula.tinyasm.sample.ClassBody.ParameterGenericSample;
import nebula.tinyasm.sample.ClassBody.TestAnnotation;
import nebula.tinyasm.util.RefineCode;

public class ClassBodyGenericTest extends TestBase {

	String clazz = ParameterGenericSample.class.getName();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMath() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz)
			.eXtend(ArrayList.class, Annotation.class)
			.imPlements(List.class, Annotation.class)
			.body();

//		cw.field(ACC_PRIVATE + ACC_FINAL + ACC_STATIC,"serialVersionUID",long.class);
		cw.field("annotation", GenericClazz.clazz(List.class, String.class));

		cw.method("<init>").code(mv -> {
			mv.line();
			mv.LOAD(0);
			mv.INVOKESPECIAL(ArrayList.class, "<init>");
			mv.RETURN();
		});

		cw.privateMethod("annotationMethod").reTurn(GenericClazz.clazz(List.class, String.class)).code(mv -> {
			mv.line();
			mv.LOADConstNULL();
			mv.RETURNTop();
		});

		cw.method("method")
			.parameter("annotation", GenericClazz.clazz(List.class, String.class))

			.code(mv -> {
				mv.line();
				mv.LOAD(0);
				mv.LOAD(1);
				mv.PUTFIELD_OF_THIS("annotation");
				mv.line();
				mv.RETURN();
			});

		cw.method("methodGenericVar").parameter("annotation", GenericClazz.clazz(List.class, String.class)).code(mv -> {
			mv.define(TestAnnotation.class, "thisannotation", GenericClazz.clazz(List.class, String.class));
			mv.line();
			mv.LOAD(1);
			mv.STORE("thisannotation");
			mv.line();
			mv.LOAD(0);
			mv.LOAD(1);
			mv.PUTFIELD_OF_THIS("annotation");
			mv.line();
			mv.RETURN();
		});

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void printClass() throws IOException {
		System.out.println(RefineCode.refineCode(toString(clazz)));
	}

}
