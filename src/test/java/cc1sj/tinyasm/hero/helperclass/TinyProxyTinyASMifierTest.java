package cc1sj.tinyasm.hero.helperclass;

import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc1sj.tinyasm.hero.TinyAsmProxyClassBuilder;
import cc1sj.tinyasm.hero.TinyAsmProxyFactoryAsmBuilder;
import cc1sj.tinyasm.hero.TinyAsmProxyInterfaceAsmBuilder;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class TinyProxyTinyASMifierTest {

	@Test
	public void testContactHello() throws Exception {
		Class<?> expectedClazz = ContactHello.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void testContactHelloHeroTinyAsm() throws Exception {
		Class<?> expectedClazz = ContactHello.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(ContactHelloHeroTinyAsm.dump());

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void testHelloInner() throws Exception {
		Class<?> expectedClazz = HelloClassTinyAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_HelloInnerTinyAsmBuilder() throws Exception {
		Class<?> expectedClazz = HelloClassTinyAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(TinyAsmProxyClassBuilder.dump(HelloClass.class, "TinyAsmProxy"));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_HelloInnerTinyAsmBuilderdump2() throws Exception {
		Class<?> expectedClazz = HelloClassTinyAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(TinyAsmProxyClassBuilder.dump2(HelloClass.class,"TinyAsmProxy"));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_HelloInterfaceInner_TinyAsmBuilder() throws Exception {
		Class<?> expectedClazz = HelloInterfaceTinyAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(TinyAsmProxyInterfaceAsmBuilder.dump2(HelloInterface.class,"TinyAsmProxy"));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void testHelloTinyAsmBuilderProxyFactory() throws Exception {
		Class<?> expectedClazz = HelloClassTinyAsmProxyFactory.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void testTinyAsmBuilderProxyFactoryTinyAsmBuilder() throws Exception {
		Class<?> expectedClazz = HelloClassTinyAsmProxyFactory.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(TinyAsmProxyFactoryAsmBuilder.dump(HelloClassTinyAsmProxy.class.getName(), "Factory"));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

}
