package cc1sj.tinyasm.advasmproxy;

import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc1sj.tinyasm.util.ClassB;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class AdvAsmProxyASMifierTest {


	@Test
	public void test_UsingObjectWithTwoParametersSample_Dump() throws Exception {
		Class<?> expectedClazz = UsingObjectWithTwoParametersSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_UsingObjectWithTwoParametersSample_Builder() throws Exception {
		Class<?> expectedClazz = UsingObjectWithTwoParametersSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), UsingObjectWithTwoParametersSampleAdvAsmBuilder.dump());

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void ClassB() throws Exception {
		Class<?> expectedClazz = ClassB.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}


}
