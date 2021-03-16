package cc1sj.tinyasm.advasmproxy.twoparameters;

import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class AdvAsmProxyASMifierTest {

	@Test
	public void test_ObjectWithTwoParametersUsingSample_Dump() throws Exception {
		Class<?> expectedClazz = ObjectWithTwoParametersUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_ObjectWithTwoParametersUsingSample_Build() throws Exception {
		Class<?> expectedClazz = ObjectWithTwoParametersUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), ObjectWithTwoParametersUsingSampleAdvAsmBuilder.dump());

		assertEquals("Code", codeExpected, codeActual);

	}

}
