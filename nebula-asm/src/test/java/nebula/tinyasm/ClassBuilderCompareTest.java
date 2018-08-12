package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

import nebula.tinyasm.api.ClassBody;

public class ClassBuilderCompareTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMath() throws Exception {
//		ClassVisitor visitor = new TraceClassVisitor(null, new ASMifier(), new PrintWriter(System.out));
		ClassVisitor visitor = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);

		ClassBody cw = ClassBuilder.make(visitor, this.getClass().getPackage().getName() + "/ClassBuilderCompare");
		cw.publicMethod("<init>").code(mc -> {
			mc.line(3).INITObject();
			mc.RETURN();
		});

		// @formatter:off
		cw.publicMethod(Type.BOOLEAN_TYPE, "eq").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(6);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPNE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "ne").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(10);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPEQ(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});
		

		cw.publicMethod(Type.BOOLEAN_TYPE, "ge").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(14);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPLT(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "le").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(18);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPGT(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});


		cw.publicMethod(Type.BOOLEAN_TYPE, "gt").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(22);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPLE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "lt").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(26);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPGE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});
		
		

		cw.publicMethod(Type.BOOLEAN_TYPE, "eq").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(30);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPNE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "ne").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(34);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPEQ(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});
		

		cw.publicMethod(Type.BOOLEAN_TYPE, "ge").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(38);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPLT(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "le").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(42);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPGT(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});


		cw.publicMethod(Type.BOOLEAN_TYPE, "gt").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(46);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPLE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "lt").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(50);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPGE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});
		


		
		

		cw.publicMethod(Type.BOOLEAN_TYPE, "eq").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(54);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPNE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "ne").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(58);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPEQ(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});
		

		cw.publicMethod(Type.BOOLEAN_TYPE, "ge").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(62);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPLT(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "le").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(66);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPGT(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});


		cw.publicMethod(Type.BOOLEAN_TYPE, "gt").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(70);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPLE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "lt").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(74);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPGE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});
		
		cw.publicMethod(Type.BOOLEAN_TYPE, "eq").parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(78);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPNE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "ne").parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(82);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPEQ(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});
		

		cw.publicMethod(Type.BOOLEAN_TYPE, "ge").parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(86);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPLT(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "le").parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(90);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPGT(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});


		cw.publicMethod(Type.BOOLEAN_TYPE, "gt").parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(94);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPLE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "lt").parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(98);
			mc.LOAD("x","y");
			Label ifElse = mc.newLabel();
			mc.IF_ICMPGE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});
		
				
		

		cw.publicMethod(Type.BOOLEAN_TYPE, "eq").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(102);
			mc.LOAD("x","y");
			mc.CMP();
			Label ifElse = mc.newLabel();
			mc.IFNE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "ne").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(106);
			mc.LOAD("x","y");
			mc.CMP();
			Label ifElse = mc.newLabel();
			mc.IFEQ(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});
		

		cw.publicMethod(Type.BOOLEAN_TYPE, "ge").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(110);
			mc.LOAD("x","y");
			mc.CMP();
			Label ifElse = mc.newLabel();
			mc.IFLT(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "le").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(114);
			mc.LOAD("x","y");
			mc.CMP();
			Label ifElse = mc.newLabel();
			mc.IFGT(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});


		cw.publicMethod(Type.BOOLEAN_TYPE, "gt").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(118);
			mc.LOAD("x","y");
			mc.CMP();
			Label ifElse = mc.newLabel();
			mc.IFLE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "lt").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(122);
			mc.LOAD("x","y");
			mc.CMP();
			Label ifElse = mc.newLabel();
			mc.IFGE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});
		
		
		
		

		cw.publicMethod(Type.BOOLEAN_TYPE, "eq").parameter("x", Type.FLOAT_TYPE).parameter("y", Type.FLOAT_TYPE).code(mc -> {
			mc.line(126);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.newLabel();
			mc.IFNE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "ne").parameter("x", Type.FLOAT_TYPE).parameter("y", Type.FLOAT_TYPE).code(mc -> {
			mc.line(130);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.newLabel();
			mc.IFEQ(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});
		

		cw.publicMethod(Type.BOOLEAN_TYPE, "ge").parameter("x", Type.FLOAT_TYPE).parameter("y", Type.FLOAT_TYPE).code(mc -> {
			mc.line(134);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.newLabel();
			mc.IFLT(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "le").parameter("x", Type.FLOAT_TYPE).parameter("y", Type.FLOAT_TYPE).code(mc -> {
			mc.line(138);
			mc.LOAD("x","y");
			mc.CMPG();
			Label ifElse = mc.newLabel();
			mc.IFGT(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});


		cw.publicMethod(Type.BOOLEAN_TYPE, "gt").parameter("x", Type.FLOAT_TYPE).parameter("y", Type.FLOAT_TYPE).code(mc -> {
			mc.line(142);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.newLabel();
			mc.IFLE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "lt").parameter("x", Type.FLOAT_TYPE).parameter("y", Type.FLOAT_TYPE).code(mc -> {
			mc.line(146);
			mc.LOAD("x","y");
			mc.CMPG();
			Label ifElse = mc.newLabel();
			mc.IFGE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});
		
		
		

		cw.publicMethod(Type.BOOLEAN_TYPE, "eq").parameter("x", Type.DOUBLE_TYPE).parameter("y", Type.DOUBLE_TYPE).code(mc -> {
			mc.line(150);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.newLabel();
			mc.IFNE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "ne").parameter("x", Type.DOUBLE_TYPE).parameter("y", Type.DOUBLE_TYPE).code(mc -> {
			mc.line(154);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.newLabel();
			mc.IFEQ(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});
		

		cw.publicMethod(Type.BOOLEAN_TYPE, "ge").parameter("x", Type.DOUBLE_TYPE).parameter("y", Type.DOUBLE_TYPE).code(mc -> {
			mc.line(158);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.newLabel();
			mc.IFLT(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "le").parameter("x", Type.DOUBLE_TYPE).parameter("y", Type.DOUBLE_TYPE).code(mc -> {
			mc.line(162);
			mc.LOAD("x","y");
			mc.CMPG();
			Label ifElse = mc.newLabel();
			mc.IFGT(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});


		cw.publicMethod(Type.BOOLEAN_TYPE, "gt").parameter("x", Type.DOUBLE_TYPE).parameter("y", Type.DOUBLE_TYPE).code(mc -> {
			mc.line(166);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.newLabel();
			mc.IFLE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});

		cw.publicMethod(Type.BOOLEAN_TYPE, "lt").parameter("x", Type.DOUBLE_TYPE).parameter("y", Type.DOUBLE_TYPE).code(mc -> {
			mc.line(170);
			mc.LOAD("x","y");
			mc.CMPG();
			Label ifElse = mc.newLabel();
			mc.IFGE(ifElse);
			mc.RETURN(1);
			mc.accessLabel(ifElse);
			mc.RETURN(0);
		});
		
		
//		mv.visitFrame(Opcodes.F_NEW, 3, new Object[] {"nebula/tinyasm/ClassBuilderCompare", Opcodes.INTEGER, Opcodes.INTEGER}, 0, new Object[] {});

//		Label l2 = new Label();
//		mv.visitLabel(l2);
//		mv.visitLocalVariable("this", "Lnebula/tinyasm/ClassBuilderCompare;", null, l0, l2, 0);
//		mv.visitLocalVariable("x", "B", null, l0, l2, 1);
//		mv.visitLocalVariable("y", "B", null, l0, l2, 2);
//		mv.visitMaxs(2, 3);
//		mv.visitEnd();
		
//
//{
//mv = cw.visitMethod(ACC_PUBLIC, "eq", "(BB)Z", null, null);
//mv.visitCode();
//Label l0 = new Label();
//mv.visitLabel(l0);
//mv.visitLineNumber(6, l0);
//mv.visitVarInsn(ILOAD, 1);
//mv.visitVarInsn(ILOAD, 2);
//Label l1 = new Label();
//mv.visitJumpInsn(IF_ICMPNE, l1);
//mv.visitInsn(ICONST_1);
//Label l2 = new Label();
//mv.visitJumpInsn(GOTO, l2);
//mv.visitLabel(l1);
//mv.visitFrame(Opcodes.F_NEW, 3, new Object[] {"nebula/tinyasm/ClassBuilderCompare", Opcodes.INTEGER, Opcodes.INTEGER}, 0, new Object[] {});
//mv.visitInsn(ICONST_0);
//mv.visitLabel(l2);
//mv.visitFrame(Opcodes.F_NEW, 3, new Object[] {"nebula/tinyasm/ClassBuilderCompare", Opcodes.INTEGER, Opcodes.INTEGER}, 1, new Object[] {Opcodes.INTEGER});
//mv.visitVarInsn(ISTORE, 3);
//Label l3 = new Label();
//mv.visitLabel(l3);
//mv.visitLineNumber(7, l3);
//mv.visitVarInsn(ILOAD, 3);
//mv.visitInsn(IRETURN);
//Label l4 = new Label();
//mv.visitLabel(l4);
//mv.visitLocalVariable("this", "Lnebula/tinyasm/ClassBuilderCompare;", null, l0, l4, 0);
//mv.visitLocalVariable("x", "B", null, l0, l4, 1);
//mv.visitLocalVariable("y", "B", null, l0, l4, 2);
//mv.visitLocalVariable("z", "Z", null, l3, l4, 3);
//mv.visitMaxs(2, 4);
//mv.visitEnd();
//}
//}

//		cw.publicMethod(Type.INT_TYPE, "mul").parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
//			mc.line(9).LOAD("x");
//			mc.LOAD("y");
//			mc.MUL();
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.INT_TYPE, "sub").parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
//			mc.line(13).LOAD("x");
//			mc.LOAD("y");
//			mc.SUB();
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.INT_TYPE, "div").parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
//			mc.line(17).LOAD("x");
//			mc.LOAD("y");
//			mc.DIV();
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.INT_TYPE, "rem").parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
//			mc.line(21).LOAD("x");
//			mc.LOAD("y");
//			mc.REM();
//			mc.RETURNTop();
//		});
//		
//
//
//		cw.publicMethod(Type.BYTE_TYPE, "add").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
//			mc.line(25).LOAD("x");
//			mc.LOAD("y");
//			mc.ADD();
//			mc.CONVERTTO(Type.BYTE_TYPE);
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.BYTE_TYPE, "mul").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
//			mc.line(29).LOAD("x");
//			mc.LOAD("y");
//			mc.MUL();
//			mc.CONVERTTO(Type.BYTE_TYPE);
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.BYTE_TYPE, "sub").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
//			mc.line(33).LOAD("x");
//			mc.LOAD("y");
//			mc.SUB();
//			mc.CONVERTTO(Type.BYTE_TYPE);
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.BYTE_TYPE, "div").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
//			mc.line(37).LOAD("x");
//			mc.LOAD("y");
//			mc.DIV();
//			mc.CONVERTTO(Type.BYTE_TYPE);
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.BYTE_TYPE, "rem").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
//			mc.line(41).LOAD("x");
//			mc.LOAD("y");
//			mc.REM();
//			mc.CONVERTTO(Type.BYTE_TYPE);
//			mc.RETURNTop();
//		});
//
//		
//
//		cw.publicMethod(Type.SHORT_TYPE, "add").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
//			mc.line(45).LOAD("x");
//			mc.LOAD("y");
//			mc.ADD();
//			mc.CONVERTTO(Type.SHORT_TYPE);
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.SHORT_TYPE, "mul").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
//			mc.line(49).LOAD("x");
//			mc.LOAD("y");
//			mc.MUL();
//			mc.CONVERTTO(Type.SHORT_TYPE);
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.SHORT_TYPE, "sub").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
//			mc.line(53).LOAD("x");
//			mc.LOAD("y");
//			mc.SUB();
//			mc.CONVERTTO(Type.SHORT_TYPE);
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.SHORT_TYPE, "div").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
//			mc.line(57).LOAD("x");
//			mc.LOAD("y");
//			mc.DIV();
//			mc.CONVERTTO(Type.SHORT_TYPE);
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.SHORT_TYPE, "rem").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
//			mc.line(61).LOAD("x");
//			mc.LOAD("y");
//			mc.REM();
//			mc.CONVERTTO(Type.SHORT_TYPE);
//			mc.RETURNTop();
//		});
//		
//		
//		
//
//		cw.publicMethod(Type.LONG_TYPE, "add").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
//			mc.line(65).LOAD("x");
//			mc.LOAD("y");
//			mc.ADD();
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.LONG_TYPE, "mul").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
//			mc.line(69).LOAD("x");
//			mc.LOAD("y");
//			mc.MUL();
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.LONG_TYPE, "sub").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
//			mc.line(73).LOAD("x");
//			mc.LOAD("y");
//			mc.SUB();
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.LONG_TYPE, "div").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
//			mc.line(77).LOAD("x");
//			mc.LOAD("y");
//			mc.DIV();
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.LONG_TYPE, "rem").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
//			mc.line(81).LOAD("x");
//			mc.LOAD("y");
//			mc.REM();
//			mc.RETURNTop();
//		});
//		
//
//		cw.publicMethod(Type.CHAR_TYPE, "add").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
//			mc.line(85).LOAD("x");
//			mc.LOAD("y");
//			mc.ADD();
//			mc.CONVERTTO(Type.CHAR_TYPE);
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.CHAR_TYPE, "mul").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
//			mc.line(89).LOAD("x");
//			mc.LOAD("y");
//			mc.MUL();
//			mc.CONVERTTO(Type.CHAR_TYPE);
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.CHAR_TYPE, "sub").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
//			mc.line(93).LOAD("x");
//			mc.LOAD("y");
//			mc.SUB();
//			mc.CONVERTTO(Type.CHAR_TYPE);
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.CHAR_TYPE, "div").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
//			mc.line(97).LOAD("x");
//			mc.LOAD("y");
//			mc.DIV();
//			mc.CONVERTTO(Type.CHAR_TYPE);
//			mc.RETURNTop();
//		});
//		cw.publicMethod(Type.CHAR_TYPE, "rem").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
//			mc.line(101).LOAD("x");
//			mc.LOAD("y");
//			mc.REM();
//			mc.CONVERTTO(Type.CHAR_TYPE);
//			mc.RETURNTop();
//		});
		// @formatter:on

		byte[] code = cw.end().toByteArray();

		String strCode = toString(code);
		String strCodeExpected = toString(ClassBuilderCompare.class.getName());

		assertEquals("Code", strCodeExpected, strCode);
	}

	public static String toString(byte[] code) throws IOException {
		ClassReader cr = new ClassReader(code);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ClassVisitor visitor = new TraceClassVisitor(null, new ASMifier(), pw);
		cr.accept(visitor, ClassReader.EXPAND_FRAMES);
		return sw.toString();
	}

	@Test
	public void printClass() throws IOException {
		System.out.println(toString(ClassBuilderCompare.class.getName()));
	}

	public static String toString(String className) throws IOException {
		ClassReader cr = new ClassReader(className);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ClassVisitor visitor = new TraceClassVisitor(null, new ASMifier(), pw);
		cr.accept(visitor, ClassReader.EXPAND_FRAMES);
		return sw.toString();
	}
}
