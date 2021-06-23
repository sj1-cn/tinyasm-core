package cn.sj1.tinyasm.core.util;

import static cn.sj1.tinyasm.tools.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cn.sj1.tinyasm.core.sample.ClassBody.MakeReadOnlyPojo;
import cn.sj1.tinyasm.tools.TinyAsmTestUtils;

public class TinyASMifierTest {

	@Test
	public void testSignatureSample() throws Exception {
		Class<?> expectedClazz = SignatureSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testSignatureInterfaceSample() throws Exception {
		Class<?> expectedClazz = SignatureInterfaceSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testSignatureGenericSample() throws Exception {
		Class<?> expectedClazz = SignatureGenericSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	//	
	//	@Test
	//	public void testDDDD() throws Exception {
	//		SimpleSampleTinyAsmDump.dump();
	//	}

	@Test
	public void test_MakeReadOnlyPojo() throws Exception {
		Class<?> expectedClazz = MakeReadOnlyPojo.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_LabelSample() throws Exception {
		Class<?> expectedClazz = LabelSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_Pojo() throws Exception {
		Class<?> expectedClazz = PojoSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_BoxUnboxSample() throws Exception {
		Class<?> expectedClazz = BoxUnboxSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_BoxUnboxSample_builder() throws Exception {
		Class<?> expectedClazz = BoxUnboxSample.class;

		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), BoxUnboxSampleTinyAsmBuilder.dump());

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testSimpleSample_dumpTinyAsm() throws Exception {
		Class<?> expectedClazz = SimpleSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

}
