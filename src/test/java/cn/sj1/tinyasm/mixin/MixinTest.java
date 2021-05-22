package cn.sj1.tinyasm.mixin;

import static cn.sj1.tinyasm.tools.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objenesis.instantiator.ObjectInstantiator;

import cn.sj1.tinyasm.core.Mixin;
import cn.sj1.tinyasm.core.MixinLambdaAdvAsmBuilder;
import cn.sj1.tinyasm.tools.TinyAsmTestUtils;

public class MixinTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_PojoClassSample_Proxy_Dump() throws Exception {
		Class<?> expectedClazz = SimpleClassMixin.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}

//	@Test
//	public void test_PojoClassSample_Proxy_Build() throws Exception {
//		Class<?> expectedClazz = SimpleClassMixin.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), MixinAdvAsmBuilder.dumpMagic(SimpleClass.class, SimpleClassMixin.class.getName()));
//
//		assertEquals("Code", codeExpected, codeActual);
//
//	}

	@Test
	public void test_SimpleClassLambda_build() throws Exception {
		Class<?> expectedClazz = SimpleClassLambda.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		MixinLambdaAdvAsmBuilder mixinLambdaAdvAsmBuilder = MixinLambdaAdvAsmBuilder.dumpMagic(SimpleClass.class, SimpleClassLambda.class.getName());
		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), mixinLambdaAdvAsmBuilder.toByteArray());

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testBuild() {
		ObjectInstantiator<SimpleClass> objectInstantiator = Mixin.build(SimpleClass.class);
		SimpleClass s = objectInstantiator.newInstance();
		assertEquals("wangshilian++", s.getName("wangshilian"));

	}

	@Test
	public void testBuildWithParams() {
		ObjectInstantiator<SimpleClassWithParams> objectInstantiator = Mixin.build(SimpleClassWithParams.class, new Object[] { "--" });
		SimpleClassWithParams s = objectInstantiator.newInstance();
		assertEquals("wangshilian--", s.getName("wangshilian"));
	}

//	@Test
//	public void testBuild2() {
//		ObjectInstantiator<SimpleGenericClass<String>> objectInstantiator = Mixin.build(SimpleGenericClass.class, String.class, new Object[] { "--" });
//		SimpleGenericClass<String> s = objectInstantiator.newInstance();
//		assertEquals("wangshiliangenericclass", s.getName("wangshiliangenericclass"));
//	}
//
//	@Test
//	public void test_SimpleGenericClass_Build() throws Exception {
//		Class<?> expectedClazz = SimpleClassMixin.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), MixinAdvAsmBuilder.dumpMagic(SimpleGenericClass.class, SimpleClassMixin.class.getName(), new Class[] { String.class }, new Object[] { "--" }));
//
//		assertEquals("Code", codeExpected, codeActual);
//
//	}
}
