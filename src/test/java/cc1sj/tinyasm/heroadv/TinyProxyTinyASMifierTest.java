package cc1sj.tinyasm.heroadv;

import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc1sj.tinyasm.hero.helperclass.HelloClass;
import cc1sj.tinyasm.hero.helperclass.HelloClassChild;
import cc1sj.tinyasm.hero.helperclass.HelloInterface;
import cc1sj.tinyasm.hero.helperclass.HelloInterfaceClassChild;
import cc1sj.tinyasm.hero.helperclass.HelloInterfaceClassChildProxy;
import cc1sj.tinyasm.hero.helperclass.PageWithParametersSample;
import cc1sj.tinyasm.hero.helperclass.PageWithParametersSampleTinyAsmBuilder;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class TinyProxyTinyASMifierTest {

//	@Test
//	public void test_ContactHello_Dump() throws Exception {
//		Class<?> expectedClazz = ContactHello.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		try {
//			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));
//
//			assertEquals("Code", codeExpected, codeActual);
//		} finally {
//			System.out.println(codeExpected);
//		}
//	}

	@Test
	public void test_HelloClassTinyAsmProxy_dump() throws Exception {
		Class<?> expectedClazz = HelloClassAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_HelloClassTinyAsmProxy_Dump1() throws Exception {
		Class<?> expectedClazz = HelloClassAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), HelloClassAdvAsmProxyTinyAsmBuilder.dump());

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_HelloClassTinyAsmProxy_Builder() throws Exception {
		Class<?> expectedClazz = HelloClassAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),
					AdvAsmProxyForClassAsmBuilder.dump2(HelloClass.class, HelloClassAdvAsmProxy.class.getName()));

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
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),
					AdvAsmProxyForInterfaceAsmBuilder.dump2(HelloInterface.class, HelloInterfaceTinyAsmProxy.class.getName()));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_HelloClassChildTinyAsmProxy_Builder() throws Exception {
		Class<?> expectedClazz = HelloClassChildTinyAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),
					AdvAsmProxyForClassAsmBuilder.dump2(HelloClassChild.class, HelloClassChildTinyAsmProxy.class.getName()));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_HelloInterfaceClassChild_Dump() throws Exception {
		Class<?> expectedClazz = HelloInterfaceClassChild.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_HelloInterfaceClassChildProxy_Dump() throws Exception {
		Class<?> expectedClazz = HelloInterfaceClassChildProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

//
	@Test
	public void test_PageWithParametersSample_Dump() throws Exception {
		Class<?> expectedClazz = PageWithParametersSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_PageWithParametersSample_Builder() throws Exception {
		Class<?> expectedClazz = PageWithParametersSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), PageWithParametersSampleTinyAsmBuilder.dump());

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

}
