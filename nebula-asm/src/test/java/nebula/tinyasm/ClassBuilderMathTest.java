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
import org.objectweb.asm.Type;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

import nebula.tinyasm.api.ClassBody;

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

		ClassBody cw = ClassBuilder.make(visitor, this.getClass().getPackage().getName() + "/ClassBuilderMath");
		cw.publicMethod("<init>").code(mc -> {
			mc.line(3).init();
			mc.returnvoid();
		});

		// @formatter:off

		cw.publicMethod(Type.INT_TYPE, "add").parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(5).load("x");
			mc.load("y");
			mc.add_op();
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.INT_TYPE, "mul").parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(9).load("x");
			mc.load("y");
			mc.mul_op();
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.INT_TYPE, "sub").parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(13).load("x");
			mc.load("y");
			mc.sub_op();
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.INT_TYPE, "div").parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(17).load("x");
			mc.load("y");
			mc.div_op();
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.INT_TYPE, "rem").parameter("x", Type.INT_TYPE).parameter("y", Type.INT_TYPE).code(mc -> {
			mc.line(21).load("x");
			mc.load("y");
			mc.rem_op();
			mc.returnTopValue_op();
		});
		


		cw.publicMethod(Type.BYTE_TYPE, "add").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(25).load("x");
			mc.load("y");
			mc.add_op();
			mc.convert_op(Type.BYTE_TYPE);
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.BYTE_TYPE, "mul").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(29).load("x");
			mc.load("y");
			mc.mul_op();
			mc.convert_op(Type.BYTE_TYPE);
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.BYTE_TYPE, "sub").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(33).load("x");
			mc.load("y");
			mc.sub_op();
			mc.convert_op(Type.BYTE_TYPE);
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.BYTE_TYPE, "div").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(37).load("x");
			mc.load("y");
			mc.div_op();
			mc.convert_op(Type.BYTE_TYPE);
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.BYTE_TYPE, "rem").parameter("x", Type.BYTE_TYPE).parameter("y", Type.BYTE_TYPE).code(mc -> {
			mc.line(41).load("x");
			mc.load("y");
			mc.rem_op();
			mc.convert_op(Type.BYTE_TYPE);
			mc.returnTopValue_op();
		});

		

		cw.publicMethod(Type.SHORT_TYPE, "add").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(45).load("x");
			mc.load("y");
			mc.add_op();
			mc.convert_op(Type.SHORT_TYPE);
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.SHORT_TYPE, "mul").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(49).load("x");
			mc.load("y");
			mc.mul_op();
			mc.convert_op(Type.SHORT_TYPE);
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.SHORT_TYPE, "sub").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(53).load("x");
			mc.load("y");
			mc.sub_op();
			mc.convert_op(Type.SHORT_TYPE);
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.SHORT_TYPE, "div").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(57).load("x");
			mc.load("y");
			mc.div_op();
			mc.convert_op(Type.SHORT_TYPE);
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.SHORT_TYPE, "rem").parameter("x", Type.SHORT_TYPE).parameter("y", Type.SHORT_TYPE).code(mc -> {
			mc.line(61).load("x");
			mc.load("y");
			mc.rem_op();
			mc.convert_op(Type.SHORT_TYPE);
			mc.returnTopValue_op();
		});
		
		
		

		cw.publicMethod(Type.LONG_TYPE, "add").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(65).load("x");
			mc.load("y");
			mc.add_op();
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.LONG_TYPE, "mul").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(69).load("x");
			mc.load("y");
			mc.mul_op();
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.LONG_TYPE, "sub").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(73).load("x");
			mc.load("y");
			mc.sub_op();
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.LONG_TYPE, "div").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(77).load("x");
			mc.load("y");
			mc.div_op();
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.LONG_TYPE, "rem").parameter("x", Type.LONG_TYPE).parameter("y", Type.LONG_TYPE).code(mc -> {
			mc.line(81).load("x");
			mc.load("y");
			mc.rem_op();
			mc.returnTopValue_op();
		});
		

		cw.publicMethod(Type.CHAR_TYPE, "add").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(85).load("x");
			mc.load("y");
			mc.add_op();
			mc.convert_op(Type.CHAR_TYPE);
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.CHAR_TYPE, "mul").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(89).load("x");
			mc.load("y");
			mc.mul_op();
			mc.convert_op(Type.CHAR_TYPE);
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.CHAR_TYPE, "sub").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(93).load("x");
			mc.load("y");
			mc.sub_op();
			mc.convert_op(Type.CHAR_TYPE);
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.CHAR_TYPE, "div").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(97).load("x");
			mc.load("y");
			mc.div_op();
			mc.convert_op(Type.CHAR_TYPE);
			mc.returnTopValue_op();
		});
		cw.publicMethod(Type.CHAR_TYPE, "rem").parameter("x", Type.CHAR_TYPE).parameter("y", Type.CHAR_TYPE).code(mc -> {
			mc.line(101).load("x");
			mc.load("y");
			mc.rem_op();
			mc.convert_op(Type.CHAR_TYPE);
			mc.returnTopValue_op();
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
