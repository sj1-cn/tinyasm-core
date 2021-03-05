package cc1sj.tinyasm;

import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc1sj.tinyasm.AdvAsmProxyForClassAsmBuilder;
import cc1sj.tinyasm.AdvAsmProxyForInterfaceAsmBuilder;
import cc1sj.tinyasm.hero.helperclass.AdvAsmProxyInvokeNewWithTwoParametersSample;
import cc1sj.tinyasm.hero.helperclass.AdvAsmProxyInvokeNewWithTwoParametersSampleAdvAsmBuilder;
import cc1sj.tinyasm.hero.helperclass.AdvAsmProxyPojoClassChildSample;
import cc1sj.tinyasm.hero.helperclass.AdvAsmProxyPojoClassChildSampleAdvAsmProxy;
import cc1sj.tinyasm.hero.helperclass.AdvAsmProxyPojoClassSample;
import cc1sj.tinyasm.hero.helperclass.AdvAsmProxyPojoClassSampleAdvAsmProxy;
import cc1sj.tinyasm.hero.helperclass.AdvAsmProxyPojoInterfaceChildSample;
import cc1sj.tinyasm.hero.helperclass.AdvAsmProxyPojoInterfaceChildSampleAdvAsmProxy;
import cc1sj.tinyasm.hero.helperclass.AdvAsmProxyPojoInterfaceSampleAdvAsmProxy;
import cc1sj.tinyasm.hero.helperclass.AdvAsxProxyPojoInterfaceSample;
import cc1sj.tinyasm.sourceconverter.ReferedObject;
import cc1sj.tinyasm.sourceconverter.AdvJavaSourceCodeConverterSampleReferedObjectObjenesisAdvAsmProxy__;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class AdvAsmProxyASMifierTest {


	@Test
	public void test_PojoClassSampleAdvAsmProxy_dump() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyPojoClassSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));


			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_PojoClassSampleAdvAsmProxy_Builder() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyPojoClassSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyForClassAsmBuilder
					.dump2(AdvAsmProxyPojoClassSample.class, AdvAsmProxyPojoClassSampleAdvAsmProxy.class.getName()));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_PojoInterfaceSampleAdvAsmProxy_Builder() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyPojoInterfaceSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyForInterfaceAsmBuilder
					.dump2(AdvAsxProxyPojoInterfaceSample.class, AdvAsmProxyPojoInterfaceSampleAdvAsmProxy.class.getName()));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_PojoClassChildSampleAdvAsmProxy_Builder() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyPojoClassChildSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyForClassAsmBuilder
					.dump2(AdvAsmProxyPojoClassChildSample.class, AdvAsmProxyPojoClassChildSampleAdvAsmProxy.class.getName()));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_PojoInterfaceChildSample_Dump() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyPojoInterfaceChildSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_PojoInterfaceChildSampleAdvAsmProxy_Dump() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyPojoInterfaceChildSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_InvokeNewWithTwoParametersSample_Dump() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyInvokeNewWithTwoParametersSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_InvokeNewWithTwoParametersSample_Builder() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyInvokeNewWithTwoParametersSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),
					AdvAsmProxyInvokeNewWithTwoParametersSampleAdvAsmBuilder.dump());

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}
//
//	@Test
//	public void test_AdvJavaSourceCodeConverterSampleReferedObject_dump() throws Exception {
//		Class<?> expectedClazz = AdvJavaSourceCodeConverterSampleReferedObjectObjenesisAdvAsmProxy.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		try {
//			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));
//
//			assertEquals("Code", codeExpected, codeActual);
//		} finally {
//
//			System.out.println(codeExpected);
//
//		}
//	}
	
	@Test
	public void test_AdvJavaSourceCodeConverterSampleReferedObject_builder() throws Exception {
		Class<?> expectedClazz = AdvJavaSourceCodeConverterSampleReferedObjectObjenesisAdvAsmProxy__.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),
					AdvAsmProxyForClassAsmBuilder.dump2(ReferedObject.class,
							AdvJavaSourceCodeConverterSampleReferedObjectObjenesisAdvAsmProxy__.class.getName()));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}
	}
}
