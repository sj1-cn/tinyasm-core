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

public class ClassBuilderFieldTest {

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

		ClassBody cw = ClassBuilder.make(visitor, this.getClass().getPackage().getName() + "/ClassBuilderField");

		// @formatter:off
		cw.field("b", Type.BYTE_TYPE);
		cw.field("c", Type.CHAR_TYPE);
		cw.field("s", Type.SHORT_TYPE);
		cw.field("i", Type.INT_TYPE);
		cw.field("l", Type.LONG_TYPE);
		cw.field("f", Type.FLOAT_TYPE);
		cw.field("d", Type.DOUBLE_TYPE);
		cw.field("str", Type.getType(String.class));
		
		cw.publicMethod("<init>").code(mc -> {
			mc.line(3).init();
			mc.returnvoid();
		});
		
		cw.publicMethod(Type.INT_TYPE,"getField").code(mc->{
			mc.def("x", int.class);
			mc.line(14).load("this");
			mc.getfield_op("b", Type.BYTE_TYPE);
			mc.load("this");
			mc.getfield_op("i", Type.INT_TYPE);
			mc.add_op();
			mc.storeTo("x");
			mc.line(15).load("x");
			mc.returnTopValue();
		});
		
		// @formatter:on

		byte[] code = cw.end().toByteArray();

		String strCode = toString(code);
		String strCodeExpected = toString(ClassBuilderField.class.getName());
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
		System.out.println(toString(ClassBuilderField.class.getName()));
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
