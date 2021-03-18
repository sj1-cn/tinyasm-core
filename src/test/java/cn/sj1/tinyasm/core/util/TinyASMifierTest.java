package cn.sj1.tinyasm.core.util;

import static cn.sj1.tinyasm.tools.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cn.sj1.tinyasm.core.MethodCodeASMLogicSample;
import cn.sj1.tinyasm.core.MethodCodeASMSimpleSample;
import cn.sj1.tinyasm.core.sample.ClassBody.MakeReadOnlyPojo;
import cn.sj1.tinyasm.tools.TinyAsmTestUtils;

public class TinyASMifierTest  {

	@Test
	public void testSimpleSample() throws Exception {
		Class<?> expectedClazz = SimpleSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testSignatureSample() throws Exception {
		Class<?> expectedClazz = SignatureSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);

	}
	

	@Test
	public void testSignatureInterfaceSample() throws Exception {
		Class<?> expectedClazz = SignatureInterfaceSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);

	}
	

	@Test
	public void testSignatureGenericSample() throws Exception {
		Class<?> expectedClazz = SignatureGenericSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);

	}
	
//	
//	@Test
//	public void testDDDD() throws Exception {
//		SimpleSampleTinyAsmDump.dump();
//	}

	@Test
	public void testMethodCodeASMLogicSample() throws Exception {
		Class<?> expectedClazz = MethodCodeASMLogicSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMethodCodeASMMathSample() throws Exception {
		Class<?> expectedClazz = MethodCodeASMMathSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMethodCodeASMSimpleSample() throws Exception {
		Class<?> expectedClazz = MethodCodeASMSimpleSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMethodASMArraySample() throws Exception {
		Class<?> expectedClazz = MethodASMArraySample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_MakeReadOnlyPojo() throws Exception {
		Class<?> expectedClazz = MakeReadOnlyPojo.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_LabelSample() throws Exception {
		Class<?> expectedClazz = LabelSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_Pojo() throws Exception {
		Class<?> expectedClazz = PojoSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_BoxUnboxSample() throws Exception {
		Class<?> expectedClazz = BoxUnboxSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_MethodCodeASMMathSample() throws Exception {
		Class<?> expectedClazz = MethodCodeASMMathSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_MethodCodeASMMathStaticSample() throws Exception {
		Class<?> expectedClazz = MethodCodeASMMathStaticSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}
	
	@Test
	public void test_MethodCodeASMControlSample() throws Exception {
		Class<?> expectedClazz = MethodCodeASMControlSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

}
