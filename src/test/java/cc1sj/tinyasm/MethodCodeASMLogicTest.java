package cc1sj.tinyasm;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Label;

import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class MethodCodeASMLogicTest  {

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
			mc.LINE(3);
			mc.INIT_OBJECT();
			mc.RETURN();
		});

		// @formatter:off
		cw.method("eq").reTurn(boolean.class).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.LINE();
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPNE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);
			mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("ne").reTurn(boolean.class).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.LINE();
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPEQ(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);
			mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("ge").reTurn(boolean.class).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.LINE(14);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);
			mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("le").reTurn(boolean.class).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.LINE(18);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("gt").reTurn(boolean.class).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.LINE(22);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("lt").reTurn(boolean.class).parameter("x", byte.class).parameter("y", byte.class).code(mc -> {
			mc.LINE(26);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});		

		cw.method("eq").reTurn(boolean.class).parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.LINE(30);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPNE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("ne").reTurn(boolean.class).parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.LINE(34);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPEQ(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("ge").reTurn(boolean.class).parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.LINE(38);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("le").reTurn(boolean.class).parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.LINE(42);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("gt").reTurn(boolean.class).parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.LINE(46);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("lt").reTurn(boolean.class).parameter("x", char.class).parameter("y", char.class).code(mc -> {
			mc.LINE(50);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});	
		

		cw.method("eq").reTurn(boolean.class).parameter("x",short.class).parameter("y",short.class).code(mc -> {
			mc.LINE(54);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPNE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});
		
		cw.method("ne").reTurn(boolean.class).parameter("x",short.class).parameter("y",short.class).code(mc -> {
			mc.LINE(58);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPEQ(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});		

		cw.method("ge").reTurn(boolean.class).parameter("x",short.class).parameter("y",short.class).code(mc -> {
			mc.LINE(62);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("le").reTurn(boolean.class).parameter("x",short.class).parameter("y",short.class).code(mc -> {
			mc.LINE(66);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("gt").reTurn(boolean.class).parameter("x",short.class).parameter("y",short.class).code(mc -> {
			mc.LINE(70);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("lt").reTurn(boolean.class).parameter("x",short.class).parameter("y",short.class).code(mc -> {
			mc.LINE(74);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});
		
		cw.method("eq").reTurn(boolean.class).parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.LINE(78);
			mc.LOAD("x");mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPNE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("ne").reTurn(boolean.class).parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.LINE(82);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPEQ(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});		

		cw.method("ge").reTurn(boolean.class).parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.LINE(86);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("le").reTurn(boolean.class).parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.LINE(90);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("gt").reTurn(boolean.class).parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.LINE(94);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("lt").reTurn(boolean.class).parameter("x", int.class).parameter("y", int.class).code(mc -> {
			mc.LINE(98);
			mc.LOAD("x");
			mc.LOAD("y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});		

		cw.method("eq").reTurn(boolean.class).parameter("x",long.class).parameter("y",long.class).code(mc -> {
			mc.LINE(102);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.LCMP();
			Label ifElse=mc.IFNE();
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("ne").reTurn(boolean.class).parameter("x",long.class).parameter("y",long.class).code(mc -> {
			mc.LINE(106);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.LCMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFEQ(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("ge").reTurn(boolean.class).parameter("x",long.class).parameter("y",long.class).code(mc -> {
			mc.LINE(110);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.LCMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFLT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("le").reTurn(boolean.class).parameter("x",long.class).parameter("y",long.class).code(mc -> {
			mc.LINE(114);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.LCMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFGT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});


		cw.method("gt").reTurn(boolean.class).parameter("x",long.class).parameter("y",long.class).code(mc -> {
			mc.LINE(118);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.LCMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFLE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("lt").reTurn(boolean.class).parameter("x",long.class).parameter("y",long.class).code(mc -> {
			mc.LINE(122);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.LCMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFGE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});				

		cw.method("eq").reTurn(boolean.class).parameter("x", float.class).parameter("y", float.class).code(mc -> {
			mc.LINE(126);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFNE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("ne").reTurn(boolean.class).parameter("x", float.class).parameter("y", float.class).code(mc -> {
			mc.LINE(130);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFEQ(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});
		

		cw.method("ge").reTurn(boolean.class).parameter("x", float.class).parameter("y", float.class).code(mc -> {
			mc.LINE(134);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFLT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("le").reTurn(boolean.class).parameter("x", float.class).parameter("y", float.class).code(mc -> {
			mc.LINE(138);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPG();
			Label ifElse = mc.codeNewLabel();
			mc.IFGT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("gt").reTurn(boolean.class).parameter("x", float.class).parameter("y", float.class).code(mc -> {
			mc.LINE(142);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFLE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});
		
		cw.method("lt").reTurn(boolean.class).parameter("x", float.class).parameter("y", float.class).code(mc -> {
			mc.LINE(146);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPG();
			Label ifElse = mc.codeNewLabel();
			mc.IFGE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});		
		

		cw.method("eq").reTurn(boolean.class).parameter("x", double.class).parameter("y", double.class).code(mc -> {
			mc.LINE(150);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFNE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("ne").reTurn(boolean.class).parameter("x", double.class).parameter("y", double.class).code(mc -> {
			mc.LINE(154);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFEQ(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});
		

		cw.method("ge").reTurn(boolean.class).parameter("x", double.class).parameter("y", double.class).code(mc -> {
			mc.LINE(158);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFLT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("le").reTurn(boolean.class).parameter("x", double.class).parameter("y", double.class).code(mc -> {
			mc.LINE(162);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPG();
			Label ifElse = mc.codeNewLabel();
			mc.IFGT(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});


		cw.method("gt").reTurn(boolean.class).parameter("x", double.class).parameter("y", double.class).code(mc -> {
			mc.LINE(166);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFLE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		cw.method("lt").reTurn(boolean.class).parameter("x", double.class).parameter("y", double.class).code(mc -> {
			mc.LINE(170);
			mc.LOAD("x");
			mc.LOAD("y");
			mc.CMPG();
			Label ifElse = mc.codeNewLabel();
			mc.IFGE(ifElse);
			Label end = mc.codeNewLabel();
			mc.LOADConstByte(1);
			mc.GOTO(end);
			mc.visitLabel(ifElse);
			mc.LOADConstByte(0);
			mc.visitLabel(end);
			mc.RETURNTop();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz,cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

//	@Test
//	public void printClass() throws IOException {
//		System.out.println(toString(ClassBuilderCompare.class.getName()));
//	}
}
