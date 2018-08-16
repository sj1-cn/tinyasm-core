package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Opcodes;

import nebula.tinyasm.data.ClassBody;
import nebula.tinyasm.sample.ClassBody.MakeInstanceMethodSample;
import nebula.tinyasm.util.RefineCode;

public class MakeInstanceMethodTest extends TestBase {

	String clazz = MakeInstanceMethodSample.class.getName();

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

		cw.method(0, String.class, "method").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.publicMethod(String.class, "publicMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.privateMethod(String.class, "privateMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protectdMethod(String.class, "protectedMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(0, "methodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.publicMethod("publicMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.privateMethod("privateMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.protectdMethod("protectedMethodVoid").code(mv -> {
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

		cw.method(0, String.class.getName(), "method").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});
		cw.publicMethod(String.class.getName(), "publicMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.privateMethod(String.class.getName(), "privateMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protectdMethod(String.class.getName(), "protectedMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(0, "methodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});
		cw.publicMethod("publicMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.privateMethod("privateMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.protectdMethod("protectedMethodVoid").code(mv -> {
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

		cw.method(0, "method").reTurn(String.class).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.publicMethod("publicMethod").reTurn(String.class).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.privateMethod("privateMethod").reTurn(String.class).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protectdMethod("protectedMethod").reTurn(String.class).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(0, "methodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});
		cw.publicMethod("publicMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.privateMethod("privateMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.protectdMethod("protectedMethodVoid").code(mv -> {
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

		cw.method(0, "method").reTurn(String.class.getName()).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.publicMethod("publicMethod").reTurn(String.class.getName()).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.privateMethod("privateMethod").reTurn(String.class.getName()).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.protectdMethod("protectedMethod").reTurn(String.class.getName()).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(0, "methodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.publicMethod("publicMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.privateMethod("privateMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.protectdMethod("protectedMethodVoid").code(mv -> {
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

		cw.method(0, "method").reTurn(String.class.getName()).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method("publicMethod").reTurn(String.class.getName()).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(Opcodes.ACC_PRIVATE, "privateMethod").reTurn(String.class.getName()).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(Opcodes.ACC_PROTECTED, "protectedMethod").reTurn(String.class.getName()).code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(0, "methodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.method("publicMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.method(Opcodes.ACC_PRIVATE, "privateMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.method(Opcodes.ACC_PROTECTED, "protectedMethodVoid").code(mv -> {
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

		cw.method(0, String.class, "method").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(String.class, "publicMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(Opcodes.ACC_PRIVATE, String.class, "privateMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(Opcodes.ACC_PROTECTED, String.class, "protectedMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(0, "methodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.method("publicMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.method(Opcodes.ACC_PRIVATE, "privateMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.method(Opcodes.ACC_PROTECTED, "protectedMethodVoid").code(mv -> {
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

		cw.method(0, String.class.getName(), "method").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(String.class.getName(), "publicMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(Opcodes.ACC_PRIVATE, String.class.getName(), "privateMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(Opcodes.ACC_PROTECTED, String.class.getName(), "protectedMethod").code(mv -> {
			mv.line();
			mv.LOADConst("here");
			mv.RETURNTop();
		});

		cw.method(0, "methodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.method("publicMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.method(Opcodes.ACC_PRIVATE, "privateMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		cw.method(Opcodes.ACC_PROTECTED, "protectedMethodVoid").code(mv -> {
			mv.line();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void printClass() throws IOException {
		System.out.println(RefineCode.refineCode(toString(clazz)));
	}

}
