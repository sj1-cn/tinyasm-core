package cc1sj.tinyasm.advasmproxy.simple;

import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc1sj.tinyasm.AdvAsmProxyClassAdvAsmBuilder;
import cc1sj.tinyasm.AdvAsmProxyMagicClassAdvAsmBuilder;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class AdvAsmProxySimpleASMifierTest {

	@Test
	public void testReferSimplePojoClassOnly_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = ReferSimplePojoClassOnlySampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testReferSimplePojoClassOnlySample_Proxy_Build() throws Exception {
		Class<?> expectedClazz = ReferSimplePojoClassOnlySampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpClass(ReferSimplePojoClassOnlySample.class, ReferSimplePojoClassOnlySampleAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testPojoClassSample_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = PojoClassAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testPojoClassSample_Proxy_Build() throws Exception {
		Class<?> expectedClazz = PojoClassAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpClass(PojoClass.class, PojoClassAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testPojoInterfaceSample_Proxy_Build() throws Exception {
		Class<?> expectedClazz = PojoInterfaceSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpInterface(PojoInterfaceSample.class, PojoInterfaceSampleAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testPojoClassChildSample_Proxy_Build() throws Exception {
		Class<?> expectedClazz = PojoClassChildAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpClass(PojoClassChild.class, PojoClassChildAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testPojoInterfaceChildSample_Dump() throws Exception {
		Class<?> expectedClazz = PojoInterfaceChildSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testPojoInterfaceChildSample_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = PojoInterfaceChildSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testSimplePojoClassSampleUsingMagicBuilderAdvAsmProxy_Dump() throws Exception {
		Class<?> expectedClazz = SimplePojoClassSampleUsingSampleMagicBuilderAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testSimplePojoClassUsingSample_MagicBuild() throws Exception {
		Class<?> expectedClazz = SimplePojoClassSampleUsingSampleMagicBuilderAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyMagicClassAdvAsmBuilder.dumpMagic(SimplePojoClassUsingSampleMagicBuilder.class, expectedClazz.getName()));

		assertEquals("Code", codeExpected, codeActual);
	}
}
