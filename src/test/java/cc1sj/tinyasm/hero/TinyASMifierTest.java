package cc1sj.tinyasm.hero;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.objectweb.asm.Type;

import cc1sj.tinyasm.MethodCodeASMLogicSample;
import cc1sj.tinyasm.MethodCodeASMSimpleSample;
import cc1sj.tinyasm.sample.ClassBody.MakeReadOnlyPojo;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

import static cc1sj.tinyasm.util.TinyAsmTestUtils.*;

public class TinyASMifierTest  {

	@Test
	public void testContactHello() throws Exception {
		Class<?> expectedClazz = ContactHello.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}
	@Test
	public void testContactHelloHeroTinyAsm() throws Exception {
		Class<?> expectedClazz = ContactHello.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
		
		try {
			String codeActual = TinyAsmTestUtils.toString(ContactHelloHeroTinyAsm.dump());

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}
	@Test
	public void testHelloInner() throws Exception {
		Class<?> expectedClazz = HelloInner.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
		
		try {
			String codeActual = TinyAsmTestUtils.toString(dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}	@Test
	public void testHelloInnerTinyAsmDump() throws Exception {
		Class<?> expectedClazz = HelloInner.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
		
		try {
			String codeActual = TinyAsmTestUtils.toString(HelloInnerTinyAsmDump.dump(Type.getType(Hello.class)));

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}
	
}
