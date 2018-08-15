package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MethodCodeFriendlyLogicTest extends TestBase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMath() throws Exception {
		String clazz = MethodCodeFriendlyLogicSample.class.getName();
		ClassBody cw = ClassBuilder.make(clazz).body();
		cw.publicMethod("<init>").code(mc -> {
			mc.line(3).INITObject();
			mc.RETURN();
		});

		// @formatter:off

		cw.method(int.class, "and").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.line(5).LOAD("x");
			mc.LOAD("y");
			mc.AND();
			mc.RETURNTop();
		});
		cw.method(int.class, "or").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.line(9).LOAD("x");
			mc.LOAD("y");
			mc.OR();
			mc.RETURNTop();
		});
		cw.method(int.class, "xor").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.line(13).LOAD("x");
			mc.LOAD("y");
			mc.XOR();
			mc.RETURNTop();
		});

		cw.method(byte.class, "and").parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.line(25).LOAD("x");
			mc.LOAD("y");
			mc.AND();
			mc.CONVERTTO(byte.class);
			mc.RETURNTop();
		});
		cw.method(byte.class, "or"/*6)*/).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.line(29).LOAD("x");
			mc.LOAD("y");
			mc.OR();
			mc.CONVERTTO(byte.class);
			mc.RETURNTop();
		});
		cw.method(byte.class, "xor"/*7)*/).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.line(33).LOAD("x");
			mc.LOAD("y");
			mc.XOR();
			mc.CONVERTTO(byte.class);
			mc.RETURNTop();
		});
		

		cw.method(short.class, "and"/*10)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.line(45).LOAD("x");
			mc.LOAD("y");
			mc.AND();
			mc.CONVERTTO(short.class);
			mc.RETURNTop();
		});
		cw.method(short.class, "or"/*11)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.line(49).LOAD("x");
			mc.LOAD("y");
			mc.OR();
			mc.CONVERTTO(short.class);
			mc.RETURNTop();
		});
		cw.method(short.class, "xor"/*12)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.line(53).LOAD("x");
			mc.LOAD("y");
			mc.XOR();
			mc.CONVERTTO(short.class);
			mc.RETURNTop();
		});
		
		

		cw.method(long.class, "and"/*15)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.line(65).LOAD("x");
			mc.LOAD("y");
			mc.AND();
			mc.RETURNTop();
		});
		cw.method(long.class, "or"/*16)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.line(69).LOAD("x");
			mc.LOAD("y");
			mc.OR();
			mc.RETURNTop();
		});
		cw.method(long.class, "xor"/*17)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.line(73).LOAD("x");
			mc.LOAD("y");
			mc.XOR();
			mc.RETURNTop();
		});
		

		cw.method(char.class, "and"/*20)*/).parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.line(85).LOAD("x");
			mc.LOAD("y");
			mc.AND();
			mc.CONVERTTO(char.class);
			mc.RETURNTop();
		});
		cw.method(char.class, "or"/*21)*/).parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.line(89).LOAD("x");
			mc.LOAD("y");
			mc.OR();
			mc.CONVERTTO(char.class);
			mc.RETURNTop();
		});
		cw.method(char.class, "xor").parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.line(93).LOAD("x");
			mc.LOAD("y");
			mc.XOR();
			mc.CONVERTTO(char.class);
			mc.RETURNTop();
		});
		// @formatter:on

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

//	@Test
//	public void printClass() throws IOException {
//		System.out.println(toString(ClassBuilderCompare.class.getName()));
//	}
}
