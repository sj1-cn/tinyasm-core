package cc1sj.tinyasm.hero;

import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc1sj.tinyasm.hero.helperclass.ContactHello;
import cc1sj.tinyasm.hero.helperclass.ContactHelloWithTinyAsmProxy;
import cc1sj.tinyasm.hero.helperclass.HelloClass;
import cc1sj.tinyasm.hero.helperclass.HelloClassTinyAsmProxy;
import cc1sj.tinyasm.hero.helperclass.HelloClassTinyAsmProxyFactory;
import cc1sj.tinyasm.hero.helperclass.HelloInterface;
import cc1sj.tinyasm.hero.helperclass.HelloInterfaceTinyAsmProxy;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class TinyProxyTinyASMifierTest {

	@Test
	public void test_ContactHello_Dump() throws Exception {
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
	public void test_ContactHello_AsmProxy() throws Exception {
		Class<?> expectedClazz = ContactHello.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(ContactHelloWithTinyAsmProxy.dump());

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_HelloClassTinyAsmProxy_dump() throws Exception {
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
	public void test_HelloClassTinyAsmProxy_Dump1() throws Exception {
		Class<?> expectedClazz = HelloClassTinyAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(TinyAsmProxyForClassAsmBuilder.dump(HelloClass.class, "TinyAsmProxy"));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_HelloClassTinyAsmProxy_Builder() throws Exception {
		Class<?> expectedClazz = HelloClassTinyAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(TinyAsmProxyForClassAsmBuilder.dump2(HelloClass.class, "TinyAsmProxy"));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_HelloInterfaceTinyAsmProxy_Builder() throws Exception {
		Class<?> expectedClazz = HelloInterfaceTinyAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(TinyAsmProxyForInterfaceAsmBuilder.dump2(HelloInterface.class, "TinyAsmProxy"));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

//	@Test
//	public void test_HelloClassTinyAsmProxyFactory_dump() throws Exception {
//		Class<?> expectedClazz = HelloClassTinyAsmProxyFactory.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		try {
//			String codeActual = TinyAsmTestUtils.toString(dumpTinyAsm(expectedClazz));
//
//			assertEquals("Code", codeExpected, codeActual);
//		} finally {
//
//			System.out.println(codeExpected);
//
//		}
//
//	}

//	@Test
//	public void test_HelloClassTinyAsmProxyFactory_Builder() throws Exception {
//		Class<?> expectedClazz = HelloClassTinyAsmProxyFactory.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		try {
//			String codeActual = TinyAsmTestUtils
//					.toString(TinyAsmProxyFactoryAsmBuilder.dump(HelloClassTinyAsmProxy.class.getName(), "Factory"));
//
//			assertEquals("Code", codeExpected, codeActual);
//		} finally {
//
//			System.out.println(codeExpected);
//
//		}
//
//	}

}
