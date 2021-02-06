package nebula.tinyasm.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nebula.tinyasm.MethodASMArraySample;
import nebula.tinyasm.MethodCodeASMLogicSample;
import nebula.tinyasm.MethodCodeASMMathSample;
import nebula.tinyasm.MethodCodeASMSimpleSample;

public class TinyASMifierTest extends TinyASMifierTestBase {

	@Test
	public void testSimpleSample() throws Exception {
		Class<?> expectedClazz = SimpleSample.class;
		String codeExpected = toString(expectedClazz);

		try {
			String codeActual = toString(makeAndDump(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {
			
			System.out.println(codeExpected);
			
		}

	}
//	
//	@Test
//	public void testDDDD() throws Exception {
//		SimpleSampleTinyAsmDump.dump();
//	}

	@Test
	public void testMethodCodeASMLogicSample() throws Exception {
		Class<?> expectedClazz = MethodCodeASMLogicSample.class;

		String codeActual = toString(makeAndDump(expectedClazz));
		String codeExpected = toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMethodCodeASMMathSample() throws Exception {
		Class<?> expectedClazz = MethodCodeASMMathSample.class;
		String codeExpected = toString(expectedClazz);

		try {
			String codeActual = toString(makeAndDump(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {
			
			System.out.println(codeExpected);
			
		}
	}
	@Test
	public void testMethodCodeASMSimpleSample() throws Exception {
		Class<?> expectedClazz = MethodCodeASMSimpleSample.class;

		String codeActual = toString(makeAndDump(expectedClazz));
		String codeExpected = toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}
	@Test
	public void testMethodASMArraySample() throws Exception {
		Class<?> expectedClazz = MethodASMArraySample.class;

		String codeActual = toString(makeAndDump(expectedClazz));
		String codeExpected = toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}
	
}
