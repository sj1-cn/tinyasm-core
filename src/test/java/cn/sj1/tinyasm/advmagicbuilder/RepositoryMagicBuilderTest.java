package cn.sj1.tinyasm.advmagicbuilder;

import static cn.sj1.tinyasm.Adv.of;
import static cn.sj1.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.sj1.tinyasm.AdvAsmProxyMagicClassAdvAsmBuilder;
import cn.sj1.tinyasm.AdvMagic;
import cn.sj1.tinyasm.util.TinyAsmTestUtils;

public class RepositoryMagicBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_RepositoryMagicBuilderAdvAsmProxy_dump() throws Exception {
		Class<?> expectedClazz = UserRepositoryMagicBuilderAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_RepositoryMagicBuilderAdvAsmProxy_build() throws Exception {
		Class<?> expectedClazz = UserRepositoryMagicBuilderAdvAsmProxy.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvAsmProxyMagicClassAdvAsmBuilder.dumpMagic(RepositoryMagicBuilder.class, of(User.class, String.class), expectedClazz.getName()));

		assertEquals("Code", codeExpected, codeActual);
	}

	
	@Test
	public void test_UserRepository_build() throws Exception {
		Class<?> expectedClazz = UserRepository.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		byte[] result = AdvMagic.dump(expectedClazz.getName(), RepositoryMagicBuilder.class, of(User.class, String.class));

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),result);

		assertEquals("Code", codeExpected, codeActual);
	}

}
