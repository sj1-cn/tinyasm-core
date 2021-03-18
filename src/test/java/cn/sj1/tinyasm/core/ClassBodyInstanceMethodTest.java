package cn.sj1.tinyasm.core;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Opcodes;

import cn.sj1.tinyasm.core.sample.ClassBody.MakeInstanceMethodSample;
import cn.sj1.tinyasm.tools.TinyAsmTestUtils;

public class ClassBodyInstanceMethodTest {

	String clazz = MakeInstanceMethodSample.class.getName();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMath() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		cw.method(0, "method").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.public_().method("publicMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.private_().method("privateMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protected_().method("protectedMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(0, "methodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.public_().method("publicMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.private_().method("privateMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.protected_().method("protectedMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathdd() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		cw.method("method").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});
		cw.public_().method("publicMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.private_().method("privateMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protected_().method("protectedMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(0, "methodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});
		cw.public_().method("publicMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.private_().method("privateMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.protected_().method("protectedMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathsssdd() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		cw.method(0, "method").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.public_().method("publicMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.private_().method("privateMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protected_().method("protectedMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(0, "methodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});
		cw.public_().method("publicMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.private_().method("privateMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.protected_().method("protectedMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathsssssdd() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		cw.method(0, "method").return_(String.class.getName()).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.public_().method("publicMethod").return_(String.class.getName()).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.private_().method("privateMethod").return_(String.class.getName()).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protected_().method("protectedMethod").return_(String.class.getName()).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(0, "methodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.public_().method("publicMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.private_().method("privateMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.protected_().method("protectedMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathssssssssdd() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		cw.method(0, "method").return_(String.class.getName()).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.public_().method("publicMethod").return_(String.class.getName()).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(Opcodes.ACC_PRIVATE, "privateMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(Opcodes.ACC_PROTECTED, "protectedMethod").return_(String.class.getName()).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(0, "methodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.public_().method("publicMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.method(Opcodes.ACC_PRIVATE, "privateMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.method(Opcodes.ACC_PROTECTED, "protectedMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathssssssdfsdfsdfssdd() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		cw.method("method").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.public_().method("publicMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.private_().method("privateMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protected_().method("protectedMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(0, "methodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.public_().method("publicMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.method(Opcodes.ACC_PRIVATE, "privateMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.method(Opcodes.ACC_PROTECTED, "protectedMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathssssssdfsdfsdfsdfsdfsdsdd() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		cw.method("method").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.public_().method("publicMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.private_().method("privateMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protected_().method("protectedMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method("methodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.public_().method("publicMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.private_().method("privateMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.protected_().method("protectedMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

}
