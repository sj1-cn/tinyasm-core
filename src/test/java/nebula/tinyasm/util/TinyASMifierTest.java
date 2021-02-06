package nebula.tinyasm.util;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

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
	
	@Test
	public void testDDDD() throws Exception {
		SimpleSampleTinyAsmDump.dump();
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
		String codeExpected = toString(expectedClazz);

		try {
			String codeActual = toString(makeAndDump(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {
			
			System.out.println(codeExpected);
			
		}
	}
//	@Test
//	public void testMethodCodeASMSimpleSample() throws Exception {
//		Class<?> expectedClazz = MethodCodeASMSimpleSample.class;
//
//		String codeActual = toString(makeAndDump(expectedClazz));
//		String codeExpected = toString(expectedClazz);
//
//		assertEquals("Code", codeExpected, codeActual);
//	}
	
}
