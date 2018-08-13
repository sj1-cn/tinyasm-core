package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.namesOf;
import static org.junit.Assert.assertEquals;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

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

		ClassBody cw = ClassBuilder.make(visitor, this.getClass().getPackage().getName() + "/ClassBuilderCompare")
			.body();
		cw.publicMethod("<init>").code(mc -> {
			mc.line(3).INITObject();
			mc.RETURN();
		});
		Class<?>[] exceptionClasses = {};

		// @formatter:off
		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "eq", namesOf(exceptionClasses)).parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(6);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPNE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses1 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "ne", namesOf(exceptionClasses1)).parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(10);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPEQ(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses2 = {};
		

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "ge", namesOf(exceptionClasses2)).parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(14);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLT(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses3 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "le", namesOf(exceptionClasses3)).parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(18);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGT(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses4 = {};


		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "gt", namesOf(exceptionClasses4)).parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(22);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses5 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "lt", namesOf(exceptionClasses5)).parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(26);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses6 = {};
		
		

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "eq", namesOf(exceptionClasses6)).parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(30);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPNE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses7 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "ne", namesOf(exceptionClasses7)).parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(34);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPEQ(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses8 = {};
		

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "ge", namesOf(exceptionClasses8)).parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(38);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLT(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses9 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "le", namesOf(exceptionClasses9)).parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(42);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGT(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses10 = {};


		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "gt", namesOf(exceptionClasses10)).parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(46);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses11 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "lt", namesOf(exceptionClasses11)).parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(50);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses12 = {};
		


		
		

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "eq", namesOf(exceptionClasses12)).parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(54);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPNE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses13 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "ne", namesOf(exceptionClasses13)).parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(58);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPEQ(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses14 = {};
		

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "ge", namesOf(exceptionClasses14)).parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(62);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLT(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses15 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "le", namesOf(exceptionClasses15)).parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(66);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGT(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses16 = {};


		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "gt", namesOf(exceptionClasses16)).parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(70);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses17 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "lt", namesOf(exceptionClasses17)).parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(74);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses18 = {};
		
		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "eq", namesOf(exceptionClasses18)).parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(78);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPNE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses19 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "ne", namesOf(exceptionClasses19)).parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(82);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPEQ(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses20 = {};
		

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "ge", namesOf(exceptionClasses20)).parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(86);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLT(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses21 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "le", namesOf(exceptionClasses21)).parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(90);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGT(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses22 = {};


		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "gt", namesOf(exceptionClasses22)).parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(94);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPLE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses23 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "lt", namesOf(exceptionClasses23)).parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(98);
			mc.LOAD("x","y");
			Label ifElse = mc.codeNewLabel();
			mc.IF_ICMPGE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses24 = {};
		
				
		

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "eq", namesOf(exceptionClasses24)).parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(102);
			mc.LOAD("x","y");
			mc.CMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFNE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses25 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "ne", namesOf(exceptionClasses25)).parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(106);
			mc.LOAD("x","y");
			mc.CMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFEQ(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses26 = {};
		

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "ge", namesOf(exceptionClasses26)).parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(110);
			mc.LOAD("x","y");
			mc.CMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFLT(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses27 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "le", namesOf(exceptionClasses27)).parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(114);
			mc.LOAD("x","y");
			mc.CMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFGT(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses28 = {};


		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "gt", namesOf(exceptionClasses28)).parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(118);
			mc.LOAD("x","y");
			mc.CMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFLE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses29 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "lt", namesOf(exceptionClasses29)).parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(122);
			mc.LOAD("x","y");
			mc.CMP();
			Label ifElse = mc.codeNewLabel();
			mc.IFGE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses30 = {};
		
		
		
		

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "eq", namesOf(exceptionClasses30)).parameter("x", Type.FLOAT_TYPE).parameter("y", Type.FLOAT_TYPE).code(mc -> {
			mc.line(126);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFNE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses31 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "ne", namesOf(exceptionClasses31)).parameter("x", Type.FLOAT_TYPE).parameter("y", Type.FLOAT_TYPE).code(mc -> {
			mc.line(130);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFEQ(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses32 = {};
		

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "ge", namesOf(exceptionClasses32)).parameter("x", Type.FLOAT_TYPE).parameter("y", Type.FLOAT_TYPE).code(mc -> {
			mc.line(134);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFLT(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses33 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "le", namesOf(exceptionClasses33)).parameter("x", Type.FLOAT_TYPE).parameter("y", Type.FLOAT_TYPE).code(mc -> {
			mc.line(138);
			mc.LOAD("x","y");
			mc.CMPG();
			Label ifElse = mc.codeNewLabel();
			mc.IFGT(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses34 = {};


		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "gt", namesOf(exceptionClasses34)).parameter("x", Type.FLOAT_TYPE).parameter("y", Type.FLOAT_TYPE).code(mc -> {
			mc.line(142);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFLE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses35 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "lt", namesOf(exceptionClasses35)).parameter("x", Type.FLOAT_TYPE).parameter("y", Type.FLOAT_TYPE).code(mc -> {
			mc.line(146);
			mc.LOAD("x","y");
			mc.CMPG();
			Label ifElse = mc.codeNewLabel();
			mc.IFGE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses36 = {};
		
		
		

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "eq", namesOf(exceptionClasses36)).parameter("x", Type.DOUBLE_TYPE).parameter("y", Type.DOUBLE_TYPE).code(mc -> {
			mc.line(150);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFNE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses37 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "ne", namesOf(exceptionClasses37)).parameter("x", Type.DOUBLE_TYPE).parameter("y", Type.DOUBLE_TYPE).code(mc -> {
			mc.line(154);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFEQ(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses38 = {};
		

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "ge", namesOf(exceptionClasses38)).parameter("x", Type.DOUBLE_TYPE).parameter("y", Type.DOUBLE_TYPE).code(mc -> {
			mc.line(158);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFLT(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses39 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "le", namesOf(exceptionClasses39)).parameter("x", Type.DOUBLE_TYPE).parameter("y", Type.DOUBLE_TYPE).code(mc -> {
			mc.line(162);
			mc.LOAD("x","y");
			mc.CMPG();
			Label ifElse = mc.codeNewLabel();
			mc.IFGT(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses40 = {};


		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "gt", namesOf(exceptionClasses40)).parameter("x", Type.DOUBLE_TYPE).parameter("y", Type.DOUBLE_TYPE).code(mc -> {
			mc.line(166);
			mc.LOAD("x","y");
			mc.CMPL();
			Label ifElse = mc.codeNewLabel();
			mc.IFLE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});
		Class<?>[] exceptionClasses41 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BOOLEAN_TYPE, "lt", namesOf(exceptionClasses41)).parameter("x", Type.DOUBLE_TYPE).parameter("y", Type.DOUBLE_TYPE).code(mc -> {
			mc.line(170);
			mc.LOAD("x","y");
			mc.CMPG();
			Label ifElse = mc.codeNewLabel();
			mc.IFGE(ifElse);
			mc.RETURN(1);
			mc.codeAccessLabel(ifElse);
			mc.RETURN(0);
		});

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
