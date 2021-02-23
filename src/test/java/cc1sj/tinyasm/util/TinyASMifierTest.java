package cc1sj.tinyasm.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc1sj.tinyasm.MethodCodeASMLogicSample;
import cc1sj.tinyasm.MethodCodeASMSimpleSample;
import cc1sj.tinyasm.sample.ClassBody.MakeReadOnlyPojo;

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
	public void testSignatureSample() throws Exception {
		Class<?> expectedClazz = SignatureSample.class;
		String codeExpected = toString(expectedClazz);

		try {
			String codeActual = toString(makeAndDump(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}
	

	@Test
	public void testSignatureInterfaceSample() throws Exception {
		Class<?> expectedClazz = SignatureInterfaceSample.class;
		String codeExpected = toString(expectedClazz);

		try {
			String codeActual = toString(makeAndDump(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}
	

	@Test
	public void testSignatureGenericSample() throws Exception {
		Class<?> expectedClazz = SignatureGenericSample.class;
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

	@Test
	public void test_MakeReadOnlyPojo() throws Exception {
		Class<?> expectedClazz = MakeReadOnlyPojo.class;

		String codeActual = toString(makeAndDump(expectedClazz));
		String codeExpected = toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_LabelSample() throws Exception {
		Class<?> expectedClazz = LabelSample.class;

		String codeActual = toString(makeAndDump(expectedClazz));
		String codeExpected = toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_Pojo() throws Exception {
		Class<?> expectedClazz = PojoSample.class;

		String codeActual = toString(makeAndDump(expectedClazz));
		String codeExpected = toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_BoxUnboxSample() throws Exception {
		Class<?> expectedClazz = BoxUnboxSample.class;

		String codeActual = toString(makeAndDump(expectedClazz));
		String codeExpected = toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_MethodCodeASMMathSample() throws Exception {
		Class<?> expectedClazz = MethodCodeASMMathSample.class;

		String codeActual = toString(makeAndDump(expectedClazz));
		String codeExpected = toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_MethodCodeASMMathStaticSample() throws Exception {
		Class<?> expectedClazz = MethodCodeASMMathStaticSample.class;

		String codeActual = toString(makeAndDump(expectedClazz));
		String codeExpected = toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}
	
	@Test
	public void test_MethodCodeASMControlSample() throws Exception {
		Class<?> expectedClazz = MethodCodeASMControlSample.class;

		String codeActual = toString(makeAndDump(expectedClazz));
		String codeExpected = toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

}
