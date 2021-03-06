package cc1sj.tinyasm.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TinyHeroTinyAsmProxyASMifierTest {

	@Test
	public void testSimpleSample() throws Exception {
		Class<?> expectedClazz = SimpleSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

//			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), SimpleSampleTinyAsmProxyBuilder.dump());
//
//			assertEquals("Code", codeExpected, codeActual);

	}
}
