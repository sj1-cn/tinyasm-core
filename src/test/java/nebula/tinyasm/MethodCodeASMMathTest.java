package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
			mc.LINE(3);
			mc.INIT_OBJECT();
			mc.RETURN();
		});

		// @formatter:off

		cw.method(int.class, "add").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.LINE(5);mc.LOAD("x");
			mc.LOAD("y");
			mc.ADD();
			mc.RETURNTop();
		});
		cw.method(int.class, "mul").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.LINE(9);mc.LOAD("x");
			mc.LOAD("y");
			mc.MUL();
			mc.RETURNTop();
		});
		cw.method(int.class, "sub").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.LINE(13);mc.LOAD("x");
			mc.LOAD("y");
			mc.SUB();
			mc.RETURNTop();
		});
		cw.method(int.class, "div").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.LINE(17);mc.LOAD("x");
			mc.LOAD("y");
			mc.DIV();
			mc.RETURNTop();
		});
		cw.method(int.class, "rem").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.LINE(21);mc.LOAD("x");
			mc.LOAD("y");
			mc.REM();
			mc.RETURNTop();
		});		
		cw.method(int.class, "and").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.LINE(5);mc.LOAD("x");
			mc.LOAD("y");
			mc.AND();
			mc.RETURNTop();
		});
		cw.method(int.class, "or").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.LINE(9);mc.LOAD("x");
			mc.LOAD("y");
			mc.OR();
			mc.RETURNTop();
		});
		cw.method(int.class, "xor").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.LINE(13);mc.LOAD("x");
			mc.LOAD("y");
			mc.XOR();
			mc.RETURNTop();
		});

		cw.method(byte.class, "add").parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.LINE(25);mc.LOAD("x");
			mc.LOAD("y");
			mc.ADD();
			mc.CONVERTTO(byte.class);
			mc.RETURNTop();
		});
		cw.method(byte.class, "mul"/*6)*/).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.LINE(29);mc.LOAD("x");
			mc.LOAD("y");
			mc.MUL();
			mc.CONVERTTO(byte.class);
			mc.RETURNTop();
		});
		cw.method(byte.class, "sub"/*7)*/).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.LINE(33);mc.LOAD("x");
			mc.LOAD("y");
			mc.SUB();
			mc.CONVERTTO(byte.class);
			mc.RETURNTop();
		});
		cw.method(byte.class, "div"/*8)*/).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.LINE(37);mc.LOAD("x");
			mc.LOAD("y");
			mc.DIV();
			mc.CONVERTTO(byte.class);
			mc.RETURNTop();
		});
		cw.method(byte.class, "rem"/*9)*/).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.LINE(41);mc.LOAD("x");
			mc.LOAD("y");
			mc.REM();
			mc.CONVERTTO(byte.class);
			mc.RETURNTop();
		});
		cw.method(byte.class, "and").parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.LINE(25);mc.LOAD("x");
			mc.LOAD("y");
			mc.AND();
			mc.CONVERTTO(byte.class);
			mc.RETURNTop();
		});
		cw.method(byte.class, "or"/*6)*/).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.LINE(29);mc.LOAD("x");
			mc.LOAD("y");
			mc.OR();
			mc.CONVERTTO(byte.class);
			mc.RETURNTop();
		});
		cw.method(byte.class, "xor"/*7)*/).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.LINE(33);mc.LOAD("x");
			mc.LOAD("y");
			mc.XOR();
			mc.CONVERTTO(byte.class);
			mc.RETURNTop();
		});

		

		cw.method(short.class, "add"/*10)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.LINE(45);mc.LOAD("x");
			mc.LOAD("y");
			mc.ADD();
			mc.CONVERTTO(short.class);
			mc.RETURNTop();
		});
		cw.method(short.class, "mul"/*11)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.LINE(49);mc.LOAD("x");
			mc.LOAD("y");
			mc.MUL();
			mc.CONVERTTO(short.class);
			mc.RETURNTop();
		});
		cw.method(short.class, "sub"/*12)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.LINE(53);mc.LOAD("x");
			mc.LOAD("y");
			mc.SUB();
			mc.CONVERTTO(short.class);
			mc.RETURNTop();
		});
		cw.method(short.class, "div"/*13)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.LINE(57);mc.LOAD("x");
			mc.LOAD("y");
			mc.DIV();
			mc.CONVERTTO(short.class);
			mc.RETURNTop();
		});
		cw.method(short.class, "rem"/*14)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.LINE(61);mc.LOAD("x");
			mc.LOAD("y");
			mc.REM();
			mc.CONVERTTO(short.class);
			mc.RETURNTop();
		});
		cw.method(short.class, "and"/*10)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.LINE(45);mc.LOAD("x");
			mc.LOAD("y");
			mc.AND();
			mc.CONVERTTO(short.class);
			mc.RETURNTop();
		});
		cw.method(short.class, "or"/*11)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.LINE(49);mc.LOAD("x");
			mc.LOAD("y");
			mc.OR();
			mc.CONVERTTO(short.class);
			mc.RETURNTop();
		});
		cw.method(short.class, "xor"/*12)*/).parameter("x", short.class).parameter("y", short.class).code(mc -> {
			mc.LINE(53);mc.LOAD("x");
			mc.LOAD("y");
			mc.XOR();
			mc.CONVERTTO(short.class);
			mc.RETURNTop();
		});
		
		
		

		cw.method(long.class, "add"/*15)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.LINE(65);mc.LOAD("x");
			mc.LOAD("y");
			mc.ADD();
			mc.RETURNTop();
		});
		cw.method(long.class, "mul"/*16)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.LINE(69);mc.LOAD("x");
			mc.LOAD("y");
			mc.MUL();
			mc.RETURNTop();
		});
		cw.method(long.class, "sub"/*17)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.LINE(73);mc.LOAD("x");
			mc.LOAD("y");
			mc.SUB();
			mc.RETURNTop();
		});
		cw.method(long.class, "div"/*18)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.LINE(77);mc.LOAD("x");
			mc.LOAD("y");
			mc.DIV();
			mc.RETURNTop();
		});
		cw.method(long.class, "rem"/*19)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.LINE(81);mc.LOAD("x");
			mc.LOAD("y");
			mc.REM();
			mc.RETURNTop();
		});
		cw.method(long.class, "and"/*15)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.LINE(65);mc.LOAD("x");
			mc.LOAD("y");
			mc.AND();
			mc.RETURNTop();
		});
		cw.method(long.class, "or"/*16)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.LINE(69);mc.LOAD("x");
			mc.LOAD("y");
			mc.OR();
			mc.RETURNTop();
		});
		cw.method(long.class, "xor"/*17)*/).parameter("x", long.class).parameter("y", long.class).code(mc -> {
			mc.LINE(73);mc.LOAD("x");
			mc.LOAD("y");
			mc.XOR();
			mc.RETURNTop();
		});
		

		cw.method(char.class, "add"/*20)*/).parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.LINE(85);mc.LOAD("x");
			mc.LOAD("y");
			mc.ADD();
			mc.CONVERTTO(char.class);
			mc.RETURNTop();
		});
		cw.method(char.class, "mul"/*21)*/).parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.LINE(89);mc.LOAD("x");
			mc.LOAD("y");
			mc.MUL();
			mc.CONVERTTO(char.class);
			mc.RETURNTop();
		});
		cw.method(char.class, "sub").parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.LINE(93);mc.LOAD("x");
			mc.LOAD("y");
			mc.SUB();
			mc.CONVERTTO(char.class);
			mc.RETURNTop();
		});
		cw.method(char.class, "div").parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.LINE(97);mc.LOAD("x");
			mc.LOAD("y");
			mc.DIV();
			mc.CONVERTTO(char.class);
			mc.RETURNTop();
		});
		cw.method(char.class, "rem").parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.LINE(101);mc.LOAD("x");
			mc.LOAD("y");
			mc.REM();
			mc.CONVERTTO(char.class);
			mc.RETURNTop();
		});		
		cw.method(char.class, "and"/*20)*/).parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.LINE(85);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.AND();
			mc.CONVERTTO(char.class);
			mc.RETURNTop();
		});
		cw.method(char.class, "or"/*21)*/).parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.LINE(89);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.OR();
			mc.CONVERTTO(char.class);
			mc.RETURNTop();
		});
		cw.method(char.class, "xor").parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.LINE(93);
			mc.LOAD("x");
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
