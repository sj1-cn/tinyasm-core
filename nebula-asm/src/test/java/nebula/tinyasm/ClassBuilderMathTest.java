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
import org.objectweb.asm.Type;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

public class ClassBuilderMathTest {

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

		ClassBody cw = ClassBuilder.make(visitor, this.getClass().getPackage().getName() + "/ClassBuilderMath").body();
		cw.publicMethod("<init>").code(mc -> {
			mc.line(3).INITObject();
			mc.RETURN();
		});
		Class<?>[] exceptionClasses = {};

		// @formatter:off

		cw.mvMethod(ACC_PUBLIC, Type.INT_TYPE, "add", namesOf(exceptionClasses)).parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(5).LOAD("x");
			mc.LOAD("y");
			mc.ADD();
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses1 = {};
		cw.mvMethod(ACC_PUBLIC, Type.INT_TYPE, "mul", namesOf(exceptionClasses1)).parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(9).LOAD("x");
			mc.LOAD("y");
			mc.MUL();
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses2 = {};
		cw.mvMethod(ACC_PUBLIC, Type.INT_TYPE, "sub", namesOf(exceptionClasses2)).parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(13).LOAD("x");
			mc.LOAD("y");
			mc.SUB();
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses3 = {};
		cw.mvMethod(ACC_PUBLIC, Type.INT_TYPE, "div", namesOf(exceptionClasses3)).parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(17).LOAD("x");
			mc.LOAD("y");
			mc.DIV();
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses4 = {};
		cw.mvMethod(ACC_PUBLIC, Type.INT_TYPE, "rem", namesOf(exceptionClasses4)).parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(21).LOAD("x");
			mc.LOAD("y");
			mc.REM();
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses5 = {};
		


		cw.mvMethod(ACC_PUBLIC, Type.BYTE_TYPE, "add", namesOf(exceptionClasses5)).parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(25).LOAD("x");
			mc.LOAD("y");
			mc.ADD();
			mc.CONVERTTO(Type.BYTE_TYPE);
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses6 = {};
		cw.mvMethod(ACC_PUBLIC, Type.BYTE_TYPE, "mul", namesOf(exceptionClasses6)).parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(29).LOAD("x");
			mc.LOAD("y");
			mc.MUL();
			mc.CONVERTTO(Type.BYTE_TYPE);
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses7 = {};
		cw.mvMethod(ACC_PUBLIC, Type.BYTE_TYPE, "sub", namesOf(exceptionClasses7)).parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(33).LOAD("x");
			mc.LOAD("y");
			mc.SUB();
			mc.CONVERTTO(Type.BYTE_TYPE);
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses8 = {};
		cw.mvMethod(ACC_PUBLIC, Type.BYTE_TYPE, "div", namesOf(exceptionClasses8)).parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(37).LOAD("x");
			mc.LOAD("y");
			mc.DIV();
			mc.CONVERTTO(Type.BYTE_TYPE);
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses9 = {};
		cw.mvMethod(ACC_PUBLIC, Type.BYTE_TYPE, "rem", namesOf(exceptionClasses9)).parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(41).LOAD("x");
			mc.LOAD("y");
			mc.REM();
			mc.CONVERTTO(Type.BYTE_TYPE);
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses10 = {};

		

		cw.mvMethod(ACC_PUBLIC, Type.SHORT_TYPE, "add", namesOf(exceptionClasses10)).parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(45).LOAD("x");
			mc.LOAD("y");
			mc.ADD();
			mc.CONVERTTO(Type.SHORT_TYPE);
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses11 = {};
		cw.mvMethod(ACC_PUBLIC, Type.SHORT_TYPE, "mul", namesOf(exceptionClasses11)).parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(49).LOAD("x");
			mc.LOAD("y");
			mc.MUL();
			mc.CONVERTTO(Type.SHORT_TYPE);
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses12 = {};
		cw.mvMethod(ACC_PUBLIC, Type.SHORT_TYPE, "sub", namesOf(exceptionClasses12)).parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(53).LOAD("x");
			mc.LOAD("y");
			mc.SUB();
			mc.CONVERTTO(Type.SHORT_TYPE);
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses13 = {};
		cw.mvMethod(ACC_PUBLIC, Type.SHORT_TYPE, "div", namesOf(exceptionClasses13)).parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(57).LOAD("x");
			mc.LOAD("y");
			mc.DIV();
			mc.CONVERTTO(Type.SHORT_TYPE);
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses14 = {};
		cw.mvMethod(ACC_PUBLIC, Type.SHORT_TYPE, "rem", namesOf(exceptionClasses14)).parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(61).LOAD("x");
			mc.LOAD("y");
			mc.REM();
			mc.CONVERTTO(Type.SHORT_TYPE);
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses15 = {};
		
		
		

		cw.mvMethod(ACC_PUBLIC, Type.LONG_TYPE, "add", namesOf(exceptionClasses15)).parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(65).LOAD("x");
			mc.LOAD("y");
			mc.ADD();
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses16 = {};
		cw.mvMethod(ACC_PUBLIC, Type.LONG_TYPE, "mul", namesOf(exceptionClasses16)).parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(69).LOAD("x");
			mc.LOAD("y");
			mc.MUL();
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses17 = {};
		cw.mvMethod(ACC_PUBLIC, Type.LONG_TYPE, "sub", namesOf(exceptionClasses17)).parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(73).LOAD("x");
			mc.LOAD("y");
			mc.SUB();
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses18 = {};
		cw.mvMethod(ACC_PUBLIC, Type.LONG_TYPE, "div", namesOf(exceptionClasses18)).parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(77).LOAD("x");
			mc.LOAD("y");
			mc.DIV();
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses19 = {};
		cw.mvMethod(ACC_PUBLIC, Type.LONG_TYPE, "rem", namesOf(exceptionClasses19)).parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(81).LOAD("x");
			mc.LOAD("y");
			mc.REM();
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses20 = {};
		

		cw.mvMethod(ACC_PUBLIC, Type.CHAR_TYPE, "add", namesOf(exceptionClasses20)).parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(85).LOAD("x");
			mc.LOAD("y");
			mc.ADD();
			mc.CONVERTTO(Type.CHAR_TYPE);
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses21 = {};
		cw.mvMethod(ACC_PUBLIC, Type.CHAR_TYPE, "mul", namesOf(exceptionClasses21)).parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(89).LOAD("x");
			mc.LOAD("y");
			mc.MUL();
			mc.CONVERTTO(Type.CHAR_TYPE);
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses22 = {};
		cw.mvMethod(ACC_PUBLIC, Type.CHAR_TYPE, "sub", namesOf(exceptionClasses22)).parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(93).LOAD("x");
			mc.LOAD("y");
			mc.SUB();
			mc.CONVERTTO(Type.CHAR_TYPE);
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses23 = {};
		cw.mvMethod(ACC_PUBLIC, Type.CHAR_TYPE, "div", namesOf(exceptionClasses23)).parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(97).LOAD("x");
			mc.LOAD("y");
			mc.DIV();
			mc.CONVERTTO(Type.CHAR_TYPE);
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses24 = {};
		cw.mvMethod(ACC_PUBLIC, Type.CHAR_TYPE, "rem", namesOf(exceptionClasses24)).parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(101).LOAD("x");
			mc.LOAD("y");
			mc.REM();
			mc.CONVERTTO(Type.CHAR_TYPE);
			mc.RETURNTop();
		});
		// @formatter:on

		byte[] code = cw.end().toByteArray();

		String strCode = toString(code);
		String strCodeExpected = toString(ClassBuilderMath.class.getName());
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
		System.out.println(toString(ClassBuilderMath.class.getName()));
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
