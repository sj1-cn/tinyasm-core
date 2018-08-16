package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nebula.tinyasm.data.ClassBody;

public class MethodCodeASMMathTest extends TestBase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMath() throws Exception {
		String clazz = MethodCodeASMMathSample.class.getName();
		ClassBody cw = ClassBuilder.make(clazz).body();
		cw.publicMethod("<init>").code(mc -> {
			mc.line(3).INITObject();
			mc.RETURN();
		});

		// @formatter:off

		cw.method(int.class, "add").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.line(5).LOAD("x");
			mc.LOAD("y");
			mc.ADD();
			mc.RETURNTop();
		});
		cw.method(int.class, "mul").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.line(9).LOAD("x");
			mc.LOAD("y");
			mc.MUL();
			mc.RETURNTop();
		});
		cw.method(int.class, "sub").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.line(13).LOAD("x");
			mc.LOAD("y");
			mc.SUB();
			mc.RETURNTop();
		});
		cw.method(int.class, "div").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.line(17).LOAD("x");
			mc.LOAD("y");
			mc.DIV();
			mc.RETURNTop();
		});
		cw.method(int.class, "rem").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.line(21).LOAD("x");
			mc.LOAD("y");
			mc.REM();
			mc.RETURNTop();
		});		
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

		cw.method(byte.class, "add").parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.line(25).LOAD("x");
			mc.LOAD("y");
			mc.ADD();
			mc.CONVERTTO(byte.class);
			mc.RETURNTop();
		});
		cw.method(byte.class, "mul"/*6)*/).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.line(29).LOAD("x");
			mc.LOAD("y");
			mc.MUL();
			mc.CONVERTTO(byte.class);
			mc.RETURNTop();
		});
		cw.method(byte.class, "sub"/*7)*/).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.line(33).LOAD("x");
			mc.LOAD("y");
			mc.SUB();
			mc.CONVERTTO(byte.class);
			mc.RETURNTop();
		});
		cw.method(byte.class, "div"/*8)*/).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.line(37).LOAD("x");
			mc.LOAD("y");
			mc.DIV();
			mc.CONVERTTO(byte.class);
			mc.RETURNTop();
		});
		cw.method(byte.class, "rem"/*9)*/).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.line(41).LOAD("x");
			mc.LOAD("y");
			mc.REM();
			mc.CONVERTTO(byte.class);
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

		

		cw.method(short.class, "add"/*10)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.line(45).LOAD("x");
			mc.LOAD("y");
			mc.ADD();
			mc.CONVERTTO(short.class);
			mc.RETURNTop();
		});
		cw.method(short.class, "mul"/*11)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.line(49).LOAD("x");
			mc.LOAD("y");
			mc.MUL();
			mc.CONVERTTO(short.class);
			mc.RETURNTop();
		});
		cw.method(short.class, "sub"/*12)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.line(53).LOAD("x");
			mc.LOAD("y");
			mc.SUB();
			mc.CONVERTTO(short.class);
			mc.RETURNTop();
		});
		cw.method(short.class, "div"/*13)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.line(57).LOAD("x");
			mc.LOAD("y");
			mc.DIV();
			mc.CONVERTTO(short.class);
			mc.RETURNTop();
		});
		cw.method(short.class, "rem"/*14)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.line(61).LOAD("x");
			mc.LOAD("y");
			mc.REM();
			mc.CONVERTTO(short.class);
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
		
		
		

		cw.method(long.class, "add"/*15)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.line(65).LOAD("x");
			mc.LOAD("y");
			mc.ADD();
			mc.RETURNTop();
		});
		cw.method(long.class, "mul"/*16)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.line(69).LOAD("x");
			mc.LOAD("y");
			mc.MUL();
			mc.RETURNTop();
		});
		cw.method(long.class, "sub"/*17)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.line(73).LOAD("x");
			mc.LOAD("y");
			mc.SUB();
			mc.RETURNTop();
		});
		cw.method(long.class, "div"/*18)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.line(77).LOAD("x");
			mc.LOAD("y");
			mc.DIV();
			mc.RETURNTop();
		});
		cw.method(long.class, "rem"/*19)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.line(81).LOAD("x");
			mc.LOAD("y");
			mc.REM();
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
		

		cw.method(char.class, "add"/*20)*/).parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.line(85).LOAD("x");
			mc.LOAD("y");
			mc.ADD();
			mc.CONVERTTO(char.class);
			mc.RETURNTop();
		});
		cw.method(char.class, "mul"/*21)*/).parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.line(89).LOAD("x");
			mc.LOAD("y");
			mc.MUL();
			mc.CONVERTTO(char.class);
			mc.RETURNTop();
		});
		cw.method(char.class, "sub").parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.line(93).LOAD("x");
			mc.LOAD("y");
			mc.SUB();
			mc.CONVERTTO(char.class);
			mc.RETURNTop();
		});
		cw.method(char.class, "div").parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.line(97).LOAD("x");
			mc.LOAD("y");
			mc.DIV();
			mc.CONVERTTO(char.class);
			mc.RETURNTop();
		});
		cw.method(char.class, "rem").parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.line(101).LOAD("x");
			mc.LOAD("y");
			mc.REM();
			mc.CONVERTTO(char.class);
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
//
//	@Test
//	public void printClass() throws IOException {
//		System.out.println(toString(ClassBuilderMath.class.getName()));
//	}

}
