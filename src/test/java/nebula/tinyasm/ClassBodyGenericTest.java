package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nebula.tinyasm.sample.ClassBody.ParameterGenericSample;
import nebula.tinyasm.sample.ClassBody.TestAnnotation;
import nebula.tinyasm.sample.ClassBody.TestInerface;

public class ClassBodyGenericTest extends TestBase {

	String clazz = ParameterGenericSample.class.getName();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMathClass() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz)
			.eXtend(ArrayList.class.getName(), Annotation.class.getName())
			.implement(TestInerface.class.getName())
			.implement(List.class.getName(), Annotation.class.getName())
			.body();

//		cw.field(ACC_PRIVATE + ACC_FINAL + ACC_STATIC,"serialVersionUID",long.class.getName());
		cw.field("annotation", TypeUtils.generic(List.class.getName(), String.class.getName()));

		cw.method("<init>").code(mv -> {
			mv.LINE();
			mv.LOAD(0);
			mv.SPECIAL(ArrayList.class.getName(), "<init>").INVOKE();
			mv.RETURN();
		});

		cw.privateMethod("annotationMethod")
			.reTurn(TypeUtils.generic(List.class.getName(), String.class.getName()))
			.code(mv -> {
				mv.LINE();
				mv.LOADConstNULL();
				mv.RETURNTop();
			});

		cw.method("method")
			.parameter("annotation", TypeUtils.generic(List.class.getName(), String.class.getName()))

			.code(mv -> {
				mv.LINE();
				mv.LOAD(0);
				mv.LOAD(1);
				mv.PUTFIELD_OF_THIS("annotation");
				mv.LINE();
				mv.RETURN();
			});

		cw.method("methodGenericVar")
			.parameter("annotation", TypeUtils.generic(List.class.getName(), String.class.getName()))
			.code(mv -> {
				mv.define(TestAnnotation.class, "thisannotation",
						TypeUtils.generic(List.class.getName(), String.class.getName()));
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

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathString() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz)
			.eXtend(ArrayList.class.getName(), Annotation.class.getName())
			.implement(TestInerface.class.getName())
			.implement(List.class.getName(), Annotation.class.getName())
			.body();

//		cw.field(ACC_PRIVATE + ACC_FINAL + ACC_STATIC,"serialVersionUID",long.class.getName());
		cw.field("annotation", TypeUtils.generic(List.class.getName(), String.class.getName()));

		cw.method("<init>").code(mv -> {
			mv.LINE();
			mv.LOAD(0);
			mv.SPECIAL(ArrayList.class.getName(), "<init>").INVOKE();
			mv.RETURN();
		});

		cw.privateMethod("annotationMethod")
			.reTurn(TypeUtils.generic(List.class.getName(), String.class.getName()))
			.code(mv -> {
				mv.LINE();
				mv.LOADConstNULL();
				mv.RETURNTop();
			});

		cw.method("method")
			.parameter("annotation", TypeUtils.generic(List.class.getName(), String.class.getName()))

			.code(mv -> {
				mv.LINE();
				mv.LOAD(0);
				mv.LOAD(1);
				mv.PUTFIELD_OF_THIS("annotation");
				mv.LINE();
				mv.RETURN();
			});

		cw.method("methodGenericVar")
			.parameter("annotation", TypeUtils.generic(List.class.getName(), String.class.getName()))
			.code(mv -> {
				mv.define(TestAnnotation.class, "thisannotation",
						TypeUtils.generic(List.class.getName(), String.class.getName()));
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

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

//	@Test
//	public void printClass() throws IOException {
//		System.out.println(RefineCode.refineCode(toString(clazz)));
//	}

}
