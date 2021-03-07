package cc1sj.tinyasm;

import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc1sj.tinyasm.hero.advasmproxy.UsingObjectWithTwoParametersSample;
import cc1sj.tinyasm.hero.advasmproxy.UsingObjectWithTwoParametersSampleAdvAsmBuilder;
import cc1sj.tinyasm.hero.advasmproxy.PojoClassChildSampleAdvAsmProxy;
import cc1sj.tinyasm.hero.advasmproxy.PojoClassSampleAdvAsmProxy;
import cc1sj.tinyasm.hero.advasmproxy.PojoInterfaceChildSampleAdvAsmProxy;
import cc1sj.tinyasm.hero.advasmproxy.PojoInterfaceSampleAdvAsmProxy;
import cc1sj.tinyasm.hero.advasmproxy.ReferSimplePojoClassOnlySampleAdvAsmProxy;
import cc1sj.tinyasm.hero.helperclass.PojoInterfaceChildSample;
import cc1sj.tinyasm.hero.helperclass.PojoInterfaceSample;
import cc1sj.tinyasm.hero.helperclass.ReferSimplePojoClassOnlySample;
import cc1sj.tinyasm.hero.helperclass.ReferSimplePojoClassSample;
import cc1sj.tinyasm.hero.helperclass.SimplePojoClassSample;
import cc1sj.tinyasm.hero.helperclass.PojoClassChildSample;
import cc1sj.tinyasm.hero.helperclass.PojoClassSample;
import cc1sj.tinyasm.sourceconverter.SimplePojoClassSampleObjenesisAdvAsmProxy__;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class AdvAsmProxyASMifierTest {

	@Test
	public void test_PojoClassSampleAdvAsmProxy_dump() throws Exception {
		Class<?> expectedClazz = PojoClassSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_PojoClassSampleAdvAsmProxy_Builder() throws Exception {
		Class<?> expectedClazz = PojoClassSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),
				AdvProxyClassAdvAsmBuilder.dump2(PojoClassSample.class, PojoClassSampleAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_PojoInterfaceSampleAdvAsmProxy_Builder() throws Exception {
		Class<?> expectedClazz = PojoInterfaceSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAdvAsmBuilder
				.dump2(PojoInterfaceSample.class, PojoInterfaceSampleAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_PojoClassChildSampleAdvAsmProxy_Builder() throws Exception {
		Class<?> expectedClazz = PojoClassChildSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),
				AdvProxyClassAdvAsmBuilder.dump2(PojoClassChildSample.class, PojoClassChildSampleAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_PojoInterfaceChildSample_Dump() throws Exception {
		Class<?> expectedClazz = PojoInterfaceChildSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_PojoInterfaceChildSampleAdvAsmProxy_Dump() throws Exception {
		Class<?> expectedClazz = PojoInterfaceChildSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

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
//
//	@Test
//	public void test_AdvJavaSourceCodeConverterSampleReferedObject_dump() throws Exception {
//		Class<?> expectedClazz = AdvJavaSourceCodeConverterSampleReferedObjectObjenesisAdvAsmProxy.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		
//			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));
//
//			assertEquals("Code", codeExpected, codeActual);
//		
//
//			
//
//		}
//	}

	@Test
	public void test_AdvJavaSourceCodeConverterSampleReferedObject_builder() throws Exception {
		Class<?> expectedClazz = SimplePojoClassSampleObjenesisAdvAsmProxy__.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvProxyClassAdvAsmBuilder
				.dump2(SimplePojoClassSample.class, SimplePojoClassSampleObjenesisAdvAsmProxy__.class.getName()));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_ReferSimplePojoClassSampleAdvAsmProxy_dump() throws Exception {
		Class<?> expectedClazz = ReferSimplePojoClassOnlySampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_ReferSimplePojoClassSampleAdvAsmProxy_Builder() throws Exception {
		Class<?> expectedClazz = ReferSimplePojoClassOnlySampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvProxyClassAdvAsmBuilder
				.dump2(ReferSimplePojoClassOnlySample.class, ReferSimplePojoClassOnlySampleAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

}
