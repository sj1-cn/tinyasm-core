package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Label;

public class MethodCodeASMLogicTest extends TestBase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMath() throws Exception {
		String clazz = MethodCodeASMLogicSample.class.getName();
		ClassBody cw = ClassBuilder.make(clazz).body();
		cw.publicMethod("<init>").code(mc -> {
			mc.line(3).INITObject();
			mc.RETURN();
		});

		// @formatter:off
		cw.method(boolean.class, "eq").parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.line();
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPNE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);
			mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "ne").parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.line();
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPEQ(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);
			mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "ge").parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.line(14);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);
			mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "le").parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.line(18);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "gt").parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.line(22);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "lt").parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.line(26);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});		

		cw.method(boolean.class, "eq").parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.line(30);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPNE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "ne").parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.line(34);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPEQ(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "ge").parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.line(38);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "le").parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.line(42);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "gt").parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.line(46);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "lt").parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.line(50);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});	
		

		cw.method(boolean.class, "eq").parameter("x",short.class).parameter("y",short.class).code(mc -> {
			mc.line(54);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPNE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});
		
		cw.method(boolean.class, "ne").parameter("x",short.class).parameter("y",short.class).code(mc -> {
			mc.line(58);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPEQ(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});		

		cw.method(boolean.class, "ge").parameter("x",short.class).parameter("y",short.class).code(mc -> {
			mc.line(62);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "le").parameter("x",short.class).parameter("y",short.class).code(mc -> {
			mc.line(66);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "gt").parameter("x",short.class).parameter("y",short.class).code(mc -> {
			mc.line(70);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "lt").parameter("x",short.class).parameter("y",short.class).code(mc -> {
			mc.line(74);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});
		
		cw.method(boolean.class, "eq").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.line(78);
			mc.LOAD("x");mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPNE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "ne").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.line(82);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPEQ(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});		

		cw.method(boolean.class, "ge").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.line(86);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "le").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.line(90);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "gt").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.line(94);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "lt").parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.line(98);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});		

		cw.method(boolean.class, "eq").parameter("x",long.class).parameter("y",long.class).code(mc -> {
			mc.line(102);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.LCMP();
			Label ifElse=mc.IFNE();
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "ne").parameter("x",long.class).parameter("y",long.class).code(mc -> {
			mc.line(106);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.LCMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFEQ(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "ge").parameter("x",long.class).parameter("y",long.class).code(mc -> {
			mc.line(110);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.LCMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFLT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "le").parameter("x",long.class).parameter("y",long.class).code(mc -> {
			mc.line(114);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.LCMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFGT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});


		cw.method(boolean.class, "gt").parameter("x",long.class).parameter("y",long.class).code(mc -> {
			mc.line(118);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.LCMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFLE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "lt").parameter("x",long.class).parameter("y",long.class).code(mc -> {
			mc.line(122);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.LCMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFGE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});				

		cw.method(boolean.class, "eq").parameter("x", float.class).parameter("y", float.class).code(mc -> {
			mc.line(126);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFNE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "ne").parameter("x", float.class).parameter("y", float.class).code(mc -> {
			mc.line(130);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFEQ(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});
		

		cw.method(boolean.class, "ge").parameter("x", float.class).parameter("y", float.class).code(mc -> {
			mc.line(134);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFLT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "le").parameter("x", float.class).parameter("y", float.class).code(mc -> {
			mc.line(138);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPG();
			Label ifElse = mc.codeNewLabel();
			mc.IFGT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "gt").parameter("x", float.class).parameter("y", float.class).code(mc -> {
			mc.line(142);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFLE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});
		
		cw.method(boolean.class, "lt").parameter("x", float.class).parameter("y", float.class).code(mc -> {
			mc.line(146);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPG();
			Label ifElse = mc.codeNewLabel();
			mc.IFGE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});		
		

		cw.method(boolean.class, "eq").parameter("x", double.class).parameter("y", double.class).code(mc -> {
			mc.line(150);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFNE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "ne").parameter("x", double.class).parameter("y", double.class).code(mc -> {
			mc.line(154);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFEQ(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});
		

		cw.method(boolean.class, "ge").parameter("x", double.class).parameter("y", double.class).code(mc -> {
			mc.line(158);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFLT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "le").parameter("x", double.class).parameter("y", double.class).code(mc -> {
			mc.line(162);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPG();
			Label ifElse = mc.codeNewLabel();
			mc.IFGT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});


		cw.method(boolean.class, "gt").parameter("x", double.class).parameter("y", double.class).code(mc -> {
			mc.line(166);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFLE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
			mc.RETURNTop();
		});

		cw.method(boolean.class, "lt").parameter("x", double.class).parameter("y", double.class).code(mc -> {
			mc.line(170);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPG();
			Label ifElse = mc.codeNewLabel();
			mc.IFGE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);
			mc.GOTO(end);
			mc.labelHere(ifElse);
			mc.LOADConstByte(0);
			mc.labelHere(end);
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
