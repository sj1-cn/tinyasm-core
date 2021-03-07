package cc1sj.tinyasm;

import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc1sj.tinyasm.hero.advasmproxy.AdvAsmProxyInvokeNewWithTwoParametersSample;
import cc1sj.tinyasm.hero.advasmproxy.AdvAsmProxyInvokeNewWithTwoParametersSampleAdvAsmBuilder;
import cc1sj.tinyasm.hero.advasmproxy.AdvAsmProxyPojoClassChildSample;
import cc1sj.tinyasm.hero.advasmproxy.AdvAsmProxyPojoClassChildSampleAdvAsmProxy;
import cc1sj.tinyasm.hero.advasmproxy.AdvAsmProxyPojoClassSampleAdvAsmProxy;
import cc1sj.tinyasm.hero.advasmproxy.AdvAsmProxyPojoInterfaceChildSample;
import cc1sj.tinyasm.hero.advasmproxy.AdvAsmProxyPojoInterfaceChildSampleAdvAsmProxy;
import cc1sj.tinyasm.hero.advasmproxy.AdvAsmProxyPojoInterfaceSampleAdvAsmProxy;
import cc1sj.tinyasm.hero.advasmproxy.AdvAsmProxyWithReferReferAdvAsmProxy;
import cc1sj.tinyasm.hero.advasmproxy.AdvAsmProxyWithReferRefferSample;
import cc1sj.tinyasm.hero.advasmproxy.AdvAsxProxyPojoInterfaceSample;
import cc1sj.tinyasm.hero.advasmproxy.PojoSample;
import cc1sj.tinyasm.sourceconverter.AdvJavaSourceCodeConverterSampleReferedObjectObjenesisAdvAsmProxy__;
import cc1sj.tinyasm.sourceconverter.ReferedObject;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class AdvAsmProxyASMifierTest {

	@Test
	public void test_PojoClassSampleAdvAsmProxy_dump() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyPojoClassSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_PojoClassSampleAdvAsmProxy_Builder() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyPojoClassSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyForClassAsmBuilder
				.dump2(PojoSample.class, AdvAsmProxyPojoClassSampleAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_PojoInterfaceSampleAdvAsmProxy_Builder() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyPojoInterfaceSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyForInterfaceAsmBuilder
				.dump2(AdvAsxProxyPojoInterfaceSample.class, AdvAsmProxyPojoInterfaceSampleAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_PojoClassChildSampleAdvAsmProxy_Builder() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyPojoClassChildSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyForClassAsmBuilder
				.dump2(AdvAsmProxyPojoClassChildSample.class, AdvAsmProxyPojoClassChildSampleAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_PojoInterfaceChildSample_Dump() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyPojoInterfaceChildSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_PojoInterfaceChildSampleAdvAsmProxy_Dump() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyPojoInterfaceChildSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_InvokeNewWithTwoParametersSample_Dump() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyInvokeNewWithTwoParametersSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_InvokeNewWithTwoParametersSample_Builder() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyInvokeNewWithTwoParametersSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),
				AdvAsmProxyInvokeNewWithTwoParametersSampleAdvAsmBuilder.dump());

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
		Class<?> expectedClazz = AdvJavaSourceCodeConverterSampleReferedObjectObjenesisAdvAsmProxy__.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyForClassAsmBuilder.dump2(ReferedObject.class,
				AdvJavaSourceCodeConverterSampleReferedObjectObjenesisAdvAsmProxy__.class.getName()));

		assertEquals("Code", codeExpected, codeActual);
	}
	

	@Test
	public void test_AdvAsmProxyWithReferReferAdvAsmProxy_dump() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyWithReferReferAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_AdvAsmProxyWithReferReferAdvAsmProxy_Builder() throws Exception {
		Class<?> expectedClazz = AdvAsmProxyWithReferReferAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyForClassAsmBuilder
				.dump2(AdvAsmProxyWithReferRefferSample.class, AdvAsmProxyWithReferReferAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

}
