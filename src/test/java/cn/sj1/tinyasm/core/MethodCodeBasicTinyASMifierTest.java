package cn.sj1.tinyasm.core;

import static cn.sj1.tinyasm.tools.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeArraySample;
import cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeFieldSample;
import cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeStaticFieldSample;
import cn.sj1.tinyasm.tools.TinyAsmTestUtils;

public class MethodCodeBasicTinyASMifierTest {

	@Test
	public void test_MethodCodeArraySample_dumpTinyAsm() throws Exception {
		Class<?> expectedClazz = MethodCodeArraySample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void MethodCodeFieldSample() throws Exception {
		Class<?> expectedClazz = MethodCodeFieldSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void MethodCodeStaticFieldSample() throws Exception {
		Class<?> expectedClazz = MethodCodeStaticFieldSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}
}
