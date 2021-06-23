package cn.sj1.tinyasm.core.sample.MethodCode;

import static cn.sj1.tinyasm.tools.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cn.sj1.tinyasm.tools.TinyAsmTestUtils;

public class MethodCodeBasicTinyASMifierTest {

	@Test
	public void testMethodCodeArraySample_dumpTinyAsm() throws Exception {
		Class<?> expectedClazz = MethodCodeArraySample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testMethodCodeControlSample_dumpTinyAsm() throws Exception {
		Class<?> expectedClazz = MethodCodeControlSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMethodCodeFieldSample_dumpTinyAsm() throws Exception {
		Class<?> expectedClazz = MethodCodeFieldSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}
	
	@Test
	public void testMethodCodeMethodCallerSample_dumpTinyAsm() throws Exception {
		Class<?> expectedClazz = MethodCodeMethodCallerSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMethodCodeLogicSample_dumpTinyAsm() throws Exception {
		Class<?> expectedClazz = MethodCodeLogicSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMethodCodeMathSample_dumpTinyAsm() throws Exception {
		Class<?> expectedClazz = MethodCodeMathSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMethodCodeMathStaticSample_dumpTinyAsm() throws Exception {
		Class<?> expectedClazz = MethodCodeMathStaticSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMethodCodeSimpleSample_dumpTinyAsm() throws Exception {
		Class<?> expectedClazz = MethodCodeSimpleSample.class;

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMethodCodeStaticFieldSample_dumpTinyAsm() throws Exception {
		Class<?> expectedClazz = MethodCodeStaticFieldSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}
}
