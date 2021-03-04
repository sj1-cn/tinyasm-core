package cc1sj.tinyasm;

import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class AdvTinyAsmBuilderASMifierTest {

	@Test
	public void test_TinyAsmBuilder_while_Dump() throws Exception {
		Class<?> expectedClazz = AdvTinyAsmBuilder_while.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {
			System.out.println(codeExpected);
		}
	}

	@Test
	public void test_TinyAsmBuilder_while_Builder() throws Exception {
		Class<?> expectedClazz = AdvTinyAsmBuilder_while.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvTinyAsmBuilder_whileTinyAsmBuilder.dump());

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_TinyAsmBuilder_if_Dump() throws Exception {
		Class<?> expectedClazz = AdvAsmBuilder_if.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {
			System.out.println(codeExpected);
		}
	}

	@Test
	public void test_TinyAsmBuilder_if_Builder() throws Exception {
		Class<?> expectedClazz = AdvAsmBuilder_if.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvTinyAsmBuilder_ifTinyAsmBuilder.dump());

			assertEquals("Code", codeExpected, codeActual);
		} finally {
			System.out.println(codeExpected);
		}
	}
}