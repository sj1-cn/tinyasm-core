package nebula.tinyasm.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nebula.tinyasm.MethodCodeASMLogicSample;
import nebula.tinyasm.MethodCodeASMMathSample;

public class TinyASMifierTest extends TinyASMifierTestBase {

	@Test
	public void testSimpleSample() throws Exception {
		Class<?> expectedClazz = SimpleSample.class;

		String codeActual = toString(makeAndDump(expectedClazz));
		String codeExpected = toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);

	}

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

		String codeActual = toString(makeAndDump(expectedClazz));
		String codeExpected = toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

}
