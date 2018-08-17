package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

import nebula.tinyasm.data.Annotation;
import nebula.tinyasm.data.ClassBody;
import nebula.tinyasm.data.ClassHeader;
import nebula.tinyasm.data.GenericClazz;
import nebula.tinyasm.sample.ClassBody.TestAnnotation;
import nebula.tinyasm.sample.ClassBody.TestInerface;
import nebula.tinyasm.sample.ClassHeader.MakeClassSuperInterfaceSample;
import nebula.tinyasm.sample.ClassHeader.MakeClassSuperSample;
import nebula.tinyasm.sample.ClassHeader.TestSuperClass;

public class ClassHeaderTest extends TestBase {

	String clazz = MakeClassSuperInterfaceSample.class.getName();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMath() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz, TestSuperClass.class, TestInerface.class).body();

		cw.constructerEmpty();
		// @formatter:on

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathGEtname() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz, TestSuperClass.class.getName(), TestInerface.class.getName()).body();

		cw.constructerEmpty();
		// @formatter:on

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathGEtnamedd() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz, TestSuperClass.class, TestInerface.class.getName()).body();

		cw.constructerEmpty();
		// @formatter:on

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathGEtnsssamedd() throws Exception {
		String clazz = MakeClassSuperSample.class.getName();
		ClassBody cw = ClassBuilder.make(clazz, TestSuperClass.class).body();

		cw.constructerEmpty();
		// @formatter:on

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathGEtnsssameddfsdd() throws Exception {
		String clazz = MakeClassSuperSample.class.getName();
		ClassBuilder cb = ClassBuilder.make(clazz, TestSuperClass.class.getName()).body(cw -> {
			cw.constructerEmpty();
		});

		// @formatter:on

		String codeActual = toString(cb.toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

//	@Test
//	public void printClass() throws IOException {
//		System.out.println(RefineCode.refineCode(toString(clazz)));
//	}

}
