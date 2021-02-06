package nebula.tinyasm.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nebula.tinyasm.TestBase;
import nebula.tinyasm.sample.ClassBody.MakeComplexSample;

public class RefineCodeTest extends TestBase {
	String clazz = MakeComplexSample.class.getName();

	@Test
	public void test() {

//		String source = toString(clazz);

//		assertEquals(source, RefineCode.refine(source));
	}
//
//	@Test
//	public void matchTypeDescriptionTest() {
//		String source = toString(clazz);
//		source = RefineCode.matchTypeDescription(source);
//		System.out.println(source.toString());
//	}

////
//	add(,
//			"ClassBody cw = ClassBuilder.make($2,$3).eXtend($5).body();");

//	@Test
//	public void getClasNameTest() {
//		String source = toString(clazz);
//		String name = RefineCode.getClasName(source);
//		assertEquals(clazz, name);
//	}

	@Test
	public void testMaddt() {
		assertEquals("methodVisitor.LOAD(8);\n", RefineCode.replaceAll("methodVisitor.visitVarInsn(DLOAD, 8);\n"));
	}

//	@Test
//	public void printClass() {
//		System.out.println(toString(clazz));
////		System.out.println(RefineCode.refineCode(toString(clazz)));
//	}

}
