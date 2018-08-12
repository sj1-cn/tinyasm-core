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
			mc.GETFIELD("b", Type.BYTE_TYPE);
			mc.load("this");
			mc.GETFIELD("i", Type.INT_TYPE);
			mc.ADD();
			mc.store("x");
			mc.line(15).load("x");
			mc.returnTopValue();
		});

		cw.publicMethod(Type.INT_TYPE,"getFieldAll").code(mc->{
			mc.def("x", int.class);
			mc.line(19).load("this");
			mc.GETFIELD("b", Type.BYTE_TYPE);
			mc.load("this");
			mc.GETFIELD("c", Type.CHAR_TYPE);
			mc.ADD();
			mc.load("this");
			mc.GETFIELD("s", Type.SHORT_TYPE);
			mc.ADD();
			mc.load("this");
			mc.GETFIELD("i", Type.INT_TYPE);
			mc.ADD();
			mc.CONVERTTO(Type.LONG_TYPE);
			mc.load("this");
			mc.GETFIELD("l", Type.LONG_TYPE);
			mc.ADD();
			mc.CONVERTTO(Type.FLOAT_TYPE);
			mc.load("this");
			mc.GETFIELD("f", Type.FLOAT_TYPE);
			mc.ADD();
			mc.CONVERTTO(Type.DOUBLE_TYPE);
			mc.load("this");
			mc.GETFIELD("d", Type.DOUBLE_TYPE);
			mc.ADD();
			mc.CONVERTTO(Type.INT_TYPE);
			mc.store("x");
			mc.line(20).load("x");
			mc.returnTopValue();
		});

		cw.publicMethod(int.class,"getFieldConst").code(mc->{
			mc.line(24).load("this");
			mc.loadConstByte(100);
			mc.PUTFIELD("b", Type.BYTE_TYPE);
			mc.line(25).load("this");
			mc.ldcShort(1000);
			mc.PUTFIELD("c", Type.CHAR_TYPE);
			mc.line(26).load("this");
			mc.ldcShort(10000);
			mc.PUTFIELD("s", Type.SHORT_TYPE);

			mc.line(27).load("this");
			mc.loadConst(100000);
			mc.PUTFIELD("i", Type.INT_TYPE);

			mc.line(28).load("this");
			mc.loadConst(1000000L);
			mc.PUTFIELD("l", Type.LONG_TYPE);
			
			mc.line(29).load("this");
			mc.loadConst(1.0E7F);
			mc.PUTFIELD("f", Type.FLOAT_TYPE);


			mc.line(30).load("this");
			mc.loadConst(1.0E8D);
			mc.PUTFIELD("d", Type.DOUBLE_TYPE);
			
			mc.line(31).load("this");
			mc.loadConst("1000000000s");
			mc.PUTFIELD("str", Type.getType(String.class));
			
			mc.line(32).load("this");
			mc.GETFIELD("b", Type.BYTE_TYPE);
			mc.load("this");
			mc.GETFIELD("c", Type.CHAR_TYPE);
			mc.ADD();
			mc.load("this");
			mc.GETFIELD("s", Type.SHORT_TYPE);
			mc.ADD();
			mc.load("this");
			mc.GETFIELD("i", Type.INT_TYPE);
			mc.ADD();
			mc.CONVERTTO(Type.LONG_TYPE);
			mc.load("this");
			mc.GETFIELD("l", Type.LONG_TYPE);
			mc.ADD();
			mc.CONVERTTO(Type.FLOAT_TYPE);
			mc.load("this");
			mc.GETFIELD("f", Type.FLOAT_TYPE);
			mc.ADD();
			mc.CONVERTTO(Type.DOUBLE_TYPE);
			mc.load("this");
			mc.GETFIELD("d", Type.DOUBLE_TYPE);
			mc.ADD();

			mc.CONVERTTO(Type.INT_TYPE);
			mc.returnTopValue();

		});
		
		cw.publicMethod(Type.INT_TYPE,"getFieldIConst").code(mc->{

			int i = 36;
			mc.line(i++).load("this");
			mc.loadConstByte(0);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).load("this");
			mc.loadConstByte(1);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).load("this");
			mc.loadConstByte(2);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).load("this");
			mc.loadConstByte(3);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).load("this");
			mc.loadConstByte(4);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).load("this");
			mc.loadConstByte(5);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).load("this");
			mc.loadConstByte(6);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).load("this");
			mc.loadConstByte(7);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).load("this");
			mc.loadConstByte(8);
			mc.PUTFIELD("b", Type.BYTE_TYPE);
			
			
			mc.line(i++).load("this");
			mc.loadConstByte(-4);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).load("this");
			mc.loadConstByte(-3);
			mc.PUTFIELD("b", Type.BYTE_TYPE);
			
			mc.line(i++).load("this");
			mc.loadConstByte(-2);
			mc.PUTFIELD("b", Type.BYTE_TYPE);


			mc.line(i++).load("this");
			mc.loadConstByte(-1);
			mc.PUTFIELD("b", Type.BYTE_TYPE);
			
			mc.line(i++).load("this");
			mc.GETFIELD("b", Type.BYTE_TYPE);
			mc.returnTopValue();

		});

		cw.publicMethod(Type.getType(String.class),"getFieldStr").code(mc->{
			mc.def("xstr", Type.getType(String.class), false);
			mc.line(53).loadConst("hello ");
			mc.store("xstr");
			mc.line(54).NEW(Type.getType(StringBuilder.class));
			mc.DUP();
			mc.load("xstr");
			mc.INVOKESTATIC(Type.getType(String.class),Type.getType(String.class), "valueOf",Type.getType(Object.class));
			mc.INVOKESPECIAL(Type.getType(StringBuilder.class),Type.VOID_TYPE, "<init>",Type.getType(String.class));
			mc.loadThis();
			mc.GETFIELD("str", Type.getType(String.class));
			mc.invokeVirtual_op(Type.getType(StringBuilder.class),Type.getType(StringBuilder.class), "append",Type.getType(String.class));
			mc.loadConst("!");
			mc.invokeVirtual_op(Type.getType(StringBuilder.class),Type.getType(StringBuilder.class), "append",Type.getType(String.class));
			mc.invokeVirtual_op(Type.getType(StringBuilder.class),Type.getType(String.class), "toString");
			mc.STORE("xstr");
			mc.line(55).ret("xstr");	
		});

		cw.publicMethod(Type.BYTE_TYPE,"retByte").code(mc->{
			mc.def("x",Type.BYTE_TYPE, false);
			mc.def("y",Type.BYTE_TYPE, false);
			mc.line(59).loadConstByte(1);
			mc.store("x");
			mc.line().load("x");
			mc.loadConstByte(1);
			mc.ADD();
			mc.CONVERTTO(Type.BYTE_TYPE);
			mc.store("x");
			
			mc.line().loadThis();
			mc.loadConstByte(10);
			mc.PUTFIELD("b", Type.BYTE_TYPE);
			mc.line().loadThis();
			mc.GETFIELD("b", Type.BYTE_TYPE);
			mc.store("x");
			mc.line().loadThis();
			mc.GETFIELD("b", Type.BYTE_TYPE);
			mc.load("x");
			mc.ADD();
			mc.CONVERTTO(Type.BYTE_TYPE);
			mc.store("y");
			mc.line().ret("y");			
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
