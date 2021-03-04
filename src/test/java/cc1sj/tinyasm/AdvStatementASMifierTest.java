package cc1sj.tinyasm;

import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class AdvStatementASMifierTest {

	@Test
	public void test_AdvStatement_while_Dump() throws Exception {
		Class<?> expectedClazz = AdvStatement_while_Sample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {
			System.out.println(codeExpected);
		}
	}

	@Test
	public void test_AdvStatement_while_Builder() throws Exception {
		Class<?> expectedClazz = AdvStatement_while_Sample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvStatement_while_SampleAdvAsmBuilder.dump());

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_AdvStatement_if_Dump() throws Exception {
		Class<?> expectedClazz = AdvStatement_if_Sample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {
			System.out.println(codeExpected);
		}
	}

	@Test
	public void test_AdvStatement_if_Builder() throws Exception {
		Class<?> expectedClazz = AdvStatement_if_Sample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvStatement_if_SampleAdvAsmBuilder.dump());

			assertEquals("Code", codeExpected, codeActual);
		} finally {
			System.out.println(codeExpected);
		}
	}

	@Test
	public void test_AdvStatement_do_while_Sample_Dump() throws Exception {
		Class<?> expectedClazz = AdvStatement_do_while_Sample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {
			System.out.println(codeExpected);
		}
	}

	@Test
	public void test_AdvStatement_do_while_Sample_Builder() throws Exception {
		Class<?> expectedClazz = AdvStatement_do_while_Sample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvStatement_do_while_SampleAdvAsmBuilder.dump());

			assertEquals("Code", codeExpected, codeActual);
		} finally {
			System.out.println(codeExpected);
		}
	}

	@Test
	public void test_AdvStatement_for_Sample_Dump() throws Exception {
		Class<?> expectedClazz = AdvStatement_for_Sample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {
			System.out.println(codeExpected);
		}
	}

	@Test
	public void test_AdvStatement_for_Sample_build() throws Exception {
		Class<?> expectedClazz = AdvStatement_for_Sample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvStatement_for_SampleAdvAsmBuilder.dump());

			assertEquals("Code", codeExpected, codeActual);
		} finally {
			System.out.println(codeExpected);
		}
	}
}