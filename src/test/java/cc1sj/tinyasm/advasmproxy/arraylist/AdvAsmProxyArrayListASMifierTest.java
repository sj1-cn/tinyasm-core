package cc1sj.tinyasm.advasmproxy.arraylist;

import static cc1sj.tinyasm.Adv.of;
import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import cc1sj.tinyasm.AdvAsmProxyClassAdvAsmBuilder;
import cc1sj.tinyasm.advasmproxy.simple.PojoClass;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class AdvAsmProxyArrayListASMifierTest {

	@Test
	public void test_ArraySample_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = ArraySampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_ArraySample_Proxy_Build() throws Exception {
		Class<?> expectedClazz = ArraySampleAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpClass(ArraySample.class, ArraySampleAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_PageList_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = PageListAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_PageList_Proxy_Builder() throws Exception {
		Class<?> expectedClazz = PageListAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpInterface(PageList.class, of(PojoClass.class), PageListAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_Iterator_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = IteratorAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_Iterator_Proxy_Build() throws Exception {
		Class<?> expectedClazz = IteratorAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpInterface(Iterator.class, of(PojoClass.class), IteratorAdvAsmProxy.class.getName()));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_Iterable_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = IterableAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_Iterable_Proxy_Build() throws Exception {
		Class<?> expectedClazz = IterableAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyClassAdvAsmBuilder.dumpInterface(Iterable.class, of(PojoClass.class), IterableAdvAsmProxy.class.getName()));
	
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_Iterable_UsingSample_Dump() throws Exception {
		Class<?> expectedClazz = IterableUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_List_UsingSample_Dump() throws Exception {
		Class<?> expectedClazz = ListUsingSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

}
