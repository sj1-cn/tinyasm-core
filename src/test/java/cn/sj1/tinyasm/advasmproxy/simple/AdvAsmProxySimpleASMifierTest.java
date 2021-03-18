package cn.sj1.tinyasm.advasmproxy.simple;

import static cn.sj1.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cn.sj1.tinyasm.AdvAsmProxyClassAdvAsmBuilder;
import cn.sj1.tinyasm.AdvAsmProxyMagicClassAdvAsmBuilder;
import cn.sj1.tinyasm.util.TinyAsmTestUtils;

public class AdvAsmProxySimpleASMifierTest {

	@Test
	public void test_ReferSimplePojoClassOnly_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = ReferSimplePojoClassOnlySampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_ReferSimplePojoClassOnlySample_Proxy_Build() throws Exception {
		Class<?> expectedClazz = ReferSimplePojoClassOnlySampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpClass(ReferSimplePojoClassOnlySample.class, ReferSimplePojoClassOnlySampleAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_PojoClassSample_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = PojoClassAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_PojoClassSample_Proxy_Build() throws Exception {
		Class<?> expectedClazz = PojoClassAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpClass(PojoClass.class, PojoClassAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_PojoInterfaceSample_Proxy_Build() throws Exception {
		Class<?> expectedClazz = PojoInterfaceSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpInterface(PojoInterfaceSample.class, PojoInterfaceSampleAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_PojoClassChildSample_Proxy_Build() throws Exception {
		Class<?> expectedClazz = PojoClassChildAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpClass(PojoClassChild.class, PojoClassChildAdvAsmProxy.class.getName()));

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
	public void test_PojoInterfaceChildSample_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = PojoInterfaceChildSampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_SimplePojoClassSampleUsingMagicBuilderAdvAsmProxy_Dump() throws Exception {
		Class<?> expectedClazz = SimplePojoClassSampleUsingSampleMagicBuilderAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_SimplePojoClassUsingSample_MagicBuild() throws Exception {
		Class<?> expectedClazz = SimplePojoClassSampleUsingSampleMagicBuilderAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyMagicClassAdvAsmBuilder.dumpMagic(SimplePojoClassUsingSampleMagicBuilder.class, expectedClazz.getName()));

		assertEquals("Code", codeExpected, codeActual);
	}
	

	@Test
	public void test_SimplePojoClassUsingSample_Dump() throws Exception {
		Class<?> expectedClazz = SimplePojoClassUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_SimplePojoClassUsingSample_Build() throws Exception {
		Class<?> expectedClazz = SimplePojoClassUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), SimplePojoClassUsingSampleBuilder.dump());

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_SimplePojoClassUsingSampleMagicBuilder_Build() throws Exception {
		Class<?> expectedClazz = SimplePojoClassUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), SimplePojoClassUsingSampleMagicBuilder.dump());

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_ReferSimplePojoClassUsingSampleMagicBuilder_Build() throws Exception {
		Class<?> expectedClazz = ReferSimplePojoClassUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), ReferSimplePojoClassUsingSampleMagicBuilder.dump());

		assertEquals("Code", codeExpected, codeActual);

	}
}
