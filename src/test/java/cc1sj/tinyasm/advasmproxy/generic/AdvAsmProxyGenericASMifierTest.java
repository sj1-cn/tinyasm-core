package cc1sj.tinyasm.advasmproxy.generic;

import static cc1sj.tinyasm.Adv.of;
import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc1sj.tinyasm.AdvAsmProxyClassAdvAsmBuilder;
import cc1sj.tinyasm.AdvMagic;
import cc1sj.tinyasm.advasmproxy.simple.PojoClass;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class AdvAsmProxyGenericASMifierTest {

	@Test
	public void test_GenericClass_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = GenericClassAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericClass_Proxy_Build() throws Exception {
		Class<?> expectedClazz = GenericClassAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpClass(GenericClass.class, of(PojoClass.class), expectedClazz.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_GenericClass_UsingSample_Dump() throws Exception {
		Class<?> expectedClazz = GenericClassUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericClass_UsingSample_MagicBuild() throws Exception {
		Class<?> expectedClazz = GenericClassUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvMagic.dump(expectedClazz.getName(), AdvMagic.build(GenericClassUsingSampleMagicBuilder.class)));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericInterface_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = GenericInterfaceAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericInterface_Proxy_Build() throws Exception {
		Class<?> expectedClazz = GenericInterfaceAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpInterface(GenericInterface.class, of(PojoClass.class), GenericInterfaceAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_GenericInterface_UsingSample_Dump() throws Exception {
		Class<?> expectedClazz = GenericInterfaceUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericInterface_UsingSample_MagicBuild() throws Exception {
		Class<?> expectedClazz = GenericInterfaceUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvMagic.dump(expectedClazz.getName(), AdvMagic.build(GenericInterfaceUsingSampleMagicBuilder.class)));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericClassWithIdKey_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = GenericClassWithIdKeyAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericClassWithIdKey_Proxy_Build() throws Exception {
		Class<?> expectedClazz = GenericClassWithIdKeyAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpClass(GenericClassWithIdKey.class, of(PojoClassWithIdKey.class), expectedClazz.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_GenericClassWithIdKey_UsingSample_Dump() throws Exception {
		Class<?> expectedClazz = GenericClassWithIdKeyUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericClassWithIdKey_UsingSample_MagicBuild() throws Exception {
		Class<?> expectedClazz = GenericClassWithIdKeyUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvMagic.dump(expectedClazz.getName(), AdvMagic.build(GenericClassWithIdKeyUsingSampleMagicBuilder.class)));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericInterfaceWithIdKey_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = GenericInterfaceWithIdKeyAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericInterfaceWithIdKey_Proxy_Build() throws Exception {
		Class<?> expectedClazz = GenericInterfaceWithIdKeyAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpClass(GenericInterfaceWithIdKey.class, of(PojoClassWithIdKey.class), expectedClazz.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_GenericInterfaceWithIdKey_UsingSample_Dump() throws Exception {
		Class<?> expectedClazz = GenericInterfaceWithIdKeyUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericInterfaceWithIdKey_UsingSample_MagicBuild() throws Exception {
		Class<?> expectedClazz = GenericInterfaceWithIdKeyUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvMagic.dump(expectedClazz.getName(), AdvMagic.build(GenericInterfaceWithIdKeyUsingSampleMagicBuilder.class)));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericInterfaceImpl_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = GenericInterfaceImplAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	// TODO
	@Test
	public void test_GenericInterfaceImpl_Proxy_Build() throws Exception {
		Class<?> expectedClazz = GenericInterfaceImplAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpClass(GenericInterfaceImpl.class, GenericInterfaceImplAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_GenericInterfaceImpl_UsingSample_Dump() throws Exception {
		Class<?> expectedClazz = GenericInterfaceImplUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericInterfaceImpl_UsingSample_MagicBuild() throws Exception {
		Class<?> expectedClazz = GenericInterfaceImplUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvMagic.dump(expectedClazz.getName(), AdvMagic.build(GenericInterfaceImplUsingSampleMagicBuilder.class)));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericMethodInterface_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = GenericMethodInterfaceAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericMethodInterface_Proxy_Build() throws Exception {
		Class<?> expectedClazz = GenericMethodInterfaceAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpInterface(GenericMethodInterface.class, of(PojoClass.class), expectedClazz.getName()));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_GenericMethodInterface_UsingSample_Dump() throws Exception {
		Class<?> expectedClazz = GenericMethodInterfaceUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}
}
