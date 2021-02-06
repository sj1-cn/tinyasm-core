package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Opcodes;

import nebula.tinyasm.sample.ClassBody.MakeStaticMethod;

public class MakeStaticMethodTest extends TestBase {

	String clazz = MakeStaticMethod.class.getName();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMath() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz).body();

		cw.constructerEmpty();

		cw.staticMethod(String.class, "staticMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.publicStaticMethod(String.class, "publicStaticMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.privateStaticMethod(String.class, "privateStaticMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protectdStaticMethod(String.class, "protectedStaticMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod("staticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.publicStaticMethod("publicStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.privateStaticMethod("privateStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.protectdStaticMethod("protectedStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathdd() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz).body();

		cw.constructerEmpty();

		cw.staticMethod(String.class.getName(), "staticMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});
		cw.publicStaticMethod(String.class.getName(), "publicStaticMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.privateStaticMethod(String.class.getName(), "privateStaticMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protectdStaticMethod(String.class.getName(), "protectedStaticMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod("staticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});
		cw.publicStaticMethod("publicStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.privateStaticMethod("privateStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.protectdStaticMethod("protectedStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathsssdd() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz).body();

		cw.constructerEmpty();

		cw.staticMethod("staticMethod").reTurn(String.class).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.publicStaticMethod("publicStaticMethod").reTurn(String.class).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.privateStaticMethod("privateStaticMethod").reTurn(String.class).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protectdStaticMethod("protectedStaticMethod").reTurn(String.class).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod("staticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});
		cw.publicStaticMethod("publicStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.privateStaticMethod("privateStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.protectdStaticMethod("protectedStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathsssssdd() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz).body();

		cw.constructerEmpty();

		cw.staticMethod("staticMethod").reTurn(String.class.getName()).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.publicStaticMethod("publicStaticMethod").reTurn(String.class.getName()).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.privateStaticMethod("privateStaticMethod").reTurn(String.class.getName()).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protectdStaticMethod("protectedStaticMethod").reTurn(String.class.getName()).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod("staticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.publicStaticMethod("publicStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.privateStaticMethod("privateStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.protectdStaticMethod("protectedStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathssssssssdd() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz).body();

		cw.constructerEmpty();

		cw.staticMethod(Opcodes.ACC_STATIC, "staticMethod").reTurn(String.class.getName()).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC, "publicStaticMethod")
			.reTurn(String.class.getName())
			.code(mv -> {
				mv.line();
				mv.LOADConst("here");
				mv.RETURNTop();
			});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PRIVATE, "privateStaticMethod")
			.reTurn(String.class.getName())
			.code(mv -> {
				mv.line();
				mv.LOADConst("here");
				mv.RETURNTop();
			});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PROTECTED, "protectedStaticMethod")
			.reTurn(String.class.getName())
			.code(mv -> {
				mv.line();
				mv.LOADConst("here");
				mv.RETURNTop();
			});

		cw.staticMethod(Opcodes.ACC_STATIC, "staticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC, "publicStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PRIVATE, "privateStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PROTECTED, "protectedStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathssssssdfsdfsdfssdd() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz).body();

		cw.constructerEmpty();

		cw.staticMethod(Opcodes.ACC_STATIC, String.class, "staticMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC, String.class, "publicStaticMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PRIVATE, String.class, "privateStaticMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PROTECTED, String.class, "protectedStaticMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod(Opcodes.ACC_STATIC, "staticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC, "publicStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PRIVATE, "privateStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PROTECTED, "protectedStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathssssssdfsdfsdfsdfsdfsdsdd() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz).body();

		cw.constructerEmpty();

		cw.staticMethod(Opcodes.ACC_STATIC, String.class.getName(), "staticMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC, String.class.getName(), "publicStaticMethod")
			.code(mv -> {
				mv.line();
				mv.LOADConst("here");
				mv.RETURNTop();
			});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PRIVATE, String.class.getName(), "privateStaticMethod")
			.code(mv -> {
				mv.line();
				mv.LOADConst("here");
				mv.RETURNTop();
			});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PROTECTED, String.class.getName(), "protectedStaticMethod")
			.code(mv -> {
				mv.line();
				mv.LOADConst("here");
				mv.RETURNTop();
			});

		cw.staticMethod(Opcodes.ACC_STATIC, "staticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PUBLIC, "publicStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PRIVATE, "privateStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.staticMethod(Opcodes.ACC_STATIC + Opcodes.ACC_PROTECTED, "protectedStaticMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}
//	@Test
//	public void printClass() throws IOException {
//		System.out.println(RefineCode.refineCode(toString(clazz)));
//	}

}
