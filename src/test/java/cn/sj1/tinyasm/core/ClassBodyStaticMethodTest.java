package cn.sj1.tinyasm.core;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Opcodes;

import cn.sj1.tinyasm.core.sample.ClassBody.MakeStaticMethod;
import cn.sj1.tinyasm.tools.TinyAsmTestUtils;

public class ClassBodyStaticMethodTest  {

	String clazz = MakeStaticMethod.class.getName();

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

		cw.staticMethod(String.class, "staticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.publicStaticMethod(String.class, "publicStaticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.privateStaticMethod(String.class, "privateStaticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protectdStaticMethod(String.class, "protectedStaticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod("staticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.publicStaticMethod("publicStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.privateStaticMethod("privateStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.protectdStaticMethod("protectedStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz,cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathdd() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		cw.staticMethod(String.class.getName(), "staticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});
		cw.publicStaticMethod(String.class.getName(), "publicStaticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.privateStaticMethod(String.class.getName(), "privateStaticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protectdStaticMethod(String.class.getName(), "protectedStaticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod("staticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});
		cw.publicStaticMethod("publicStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.privateStaticMethod("privateStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.protectdStaticMethod("protectedStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz,cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathsssdd() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		cw.staticMethod("staticMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.publicStaticMethod("publicStaticMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.privateStaticMethod("privateStaticMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protectdStaticMethod("protectedStaticMethod").return_(String.class).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod("staticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});
		cw.publicStaticMethod("publicStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.privateStaticMethod("privateStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.protectdStaticMethod("protectedStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz,cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathsssssdd() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		cw.staticMethod("staticMethod").return_(String.class.getName()).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.publicStaticMethod("publicStaticMethod").return_(String.class.getName()).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.privateStaticMethod("privateStaticMethod").return_(String.class.getName()).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protectdStaticMethod("protectedStaticMethod").return_(String.class.getName()).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod("staticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.publicStaticMethod("publicStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.privateStaticMethod("privateStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.protectdStaticMethod("protectedStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz,cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathssssssssdd() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		cw.staticMethod("staticMethod").return_(String.class.getName()).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC, "publicStaticMethod").return_(String.class.getName()).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PRIVATE, "privateStaticMethod").return_(String.class.getName()).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PROTECTED, "protectedStaticMethod").return_(String.class.getName()).code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod("staticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC, "publicStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PRIVATE, "privateStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PROTECTED, "protectedStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz,cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathssssssdfsdfsdfssdd() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		cw.staticMethod(String.class, "staticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC, String.class, "publicStaticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PRIVATE, String.class, "privateStaticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PROTECTED, String.class, "protectedStaticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod("staticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC, "publicStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PRIVATE, "privateStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PROTECTED, "protectedStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz,cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathssssssdfsdfsdfsdfsdfsdsdd() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		cw.staticMethod(String.class, "staticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC, String.class, "publicStaticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PRIVATE, String.class, "privateStaticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PROTECTED, String.class, "protectedStaticMethod").code(mv -> {
			mv.LINE();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod("staticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC, "publicStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PRIVATE, "privateStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PROTECTED, "protectedStaticMethodVoid").code(mv -> {
			mv.LINE();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz,cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

}
