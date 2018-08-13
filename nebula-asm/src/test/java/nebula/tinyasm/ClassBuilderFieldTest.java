package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.namesOf;
import static org.junit.Assert.assertEquals;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
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

		ClassBody cw = ClassBuilder.make(visitor, this.getClass().getPackage().getName() + "/ClassBuilderField").body();

		// @formatter:off
		cw.field(ACC_PRIVATE, "b",  byte.class);
		cw.field(ACC_PRIVATE, "c", char.class);
		cw.field(ACC_PRIVATE, "s",short.class);
		cw.field(ACC_PRIVATE, "i",int.class);
		cw.field(ACC_PRIVATE, "l",long.class);
		cw.field(ACC_PRIVATE, "f",float.class);
		cw.field(ACC_PRIVATE, "d",double.class);
		cw.field(ACC_PRIVATE, "str",String.class);
		
		cw.publicMethod("<init>").code(mc -> {
			mc.line(3).INITObject();
			mc.RETURN();
		});
		Class<?>[] exceptionClasses = {};
		
		cw.mvMethod(ACC_PUBLIC, Type.INT_TYPE, "getField", namesOf(exceptionClasses)).code(mc->{
			mc.def("x", int.class);
			mc.line(14).LOAD("this");
			mc.GETFIELD("b", Type.BYTE_TYPE);
			mc.LOAD("this");
			mc.GETFIELD("i", Type.INT_TYPE);
			mc.ADD();
			mc.STORE("x");
			mc.line(15).LOAD("x");
			mc.RETURNTop();
		});
		Class<?>[] exceptionClasses1 = {};

		cw.mvMethod(ACC_PUBLIC, Type.INT_TYPE, "getFieldAll", namesOf(exceptionClasses1)).code(mc->{
			mc.def("x", int.class);
			mc.line(19).LOAD("this");
			mc.GETFIELD("b", Type.BYTE_TYPE);
			mc.LOAD("this");
			mc.GETFIELD("c", Type.CHAR_TYPE);
			mc.ADD();
			mc.LOAD("this");
			mc.GETFIELD("s", Type.SHORT_TYPE);
			mc.ADD();
			mc.LOAD("this");
			mc.GETFIELD("i", Type.INT_TYPE);
			mc.ADD();
			mc.CONVERTTO(Type.LONG_TYPE);
			mc.LOAD("this");
			mc.GETFIELD("l", Type.LONG_TYPE);
			mc.ADD();
			mc.CONVERTTO(Type.FLOAT_TYPE);
			mc.LOAD("this");
			mc.GETFIELD("f", Type.FLOAT_TYPE);
			mc.ADD();
			mc.CONVERTTO(Type.DOUBLE_TYPE);
			mc.LOAD("this");
			mc.GETFIELD("d", Type.DOUBLE_TYPE);
			mc.ADD();
			mc.CONVERTTO(Type.INT_TYPE);
			mc.STORE("x");
			mc.line(20).LOAD("x");
			mc.RETURNTop();
		});

		cw.publicMethod(int.class,"getFieldConst").code(mc->{
			mc.line(24).LOAD("this");
			mc.LOADConstByte(100);
			mc.PUTFIELD("b", Type.BYTE_TYPE);
			mc.line(25).LOAD("this");
			mc.LOADConstShort(1000);
			mc.PUTFIELD("c", Type.CHAR_TYPE);
			mc.line(26).LOAD("this");
			mc.LOADConstShort(10000);
			mc.PUTFIELD("s", Type.SHORT_TYPE);

			mc.line(27).LOAD("this");
			mc.LOADConst(100000);
			mc.PUTFIELD("i", Type.INT_TYPE);

			mc.line(28).LOAD("this");
			mc.LOADConst(1000000L);
			mc.PUTFIELD("l", Type.LONG_TYPE);
			
			mc.line(29).LOAD("this");
			mc.LOADConst(1.0E7F);
			mc.PUTFIELD("f", Type.FLOAT_TYPE);


			mc.line(30).LOAD("this");
			mc.LOADConst(1.0E8D);
			mc.PUTFIELD("d", Type.DOUBLE_TYPE);
			
			mc.line(31).LOAD("this");
			mc.LOADConst("1000000000s");
			mc.PUTFIELD("str", Type.getType(String.class));
			
			mc.line(32).LOAD("this");
			mc.GETFIELD("b", Type.BYTE_TYPE);
			mc.LOAD("this");
			mc.GETFIELD("c", Type.CHAR_TYPE);
			mc.ADD();
			mc.LOAD("this");
			mc.GETFIELD("s", Type.SHORT_TYPE);
			mc.ADD();
			mc.LOAD("this");
			mc.GETFIELD("i", Type.INT_TYPE);
			mc.ADD();
			mc.CONVERTTO(Type.LONG_TYPE);
			mc.LOAD("this");
			mc.GETFIELD("l", Type.LONG_TYPE);
			mc.ADD();
			mc.CONVERTTO(Type.FLOAT_TYPE);
			mc.LOAD("this");
			mc.GETFIELD("f", Type.FLOAT_TYPE);
			mc.ADD();
			mc.CONVERTTO(Type.DOUBLE_TYPE);
			mc.LOAD("this");
			mc.GETFIELD("d", Type.DOUBLE_TYPE);
			mc.ADD();

			mc.CONVERTTO(Type.INT_TYPE);
			mc.RETURNTop();

		});
		Class<?>[] exceptionClasses2 = {};
		
		cw.mvMethod(ACC_PUBLIC, Type.INT_TYPE, "getFieldIConst", namesOf(exceptionClasses2)).code(mc->{

			int i = 36;
			mc.line(i++).LOAD("this");
			mc.LOADConstByte(0);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(1);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(2);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(3);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(4);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(5);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(6);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(7);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(8);
			mc.PUTFIELD("b", Type.BYTE_TYPE);
			
			
			mc.line(i++).LOAD("this");
			mc.LOADConstByte(-4);
			mc.PUTFIELD("b", Type.BYTE_TYPE);

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(-3);
			mc.PUTFIELD("b", Type.BYTE_TYPE);
			
			mc.line(i++).LOAD("this");
			mc.LOADConstByte(-2);
			mc.PUTFIELD("b", Type.BYTE_TYPE);


			mc.line(i++).LOAD("this");
			mc.LOADConstByte(-1);
			mc.PUTFIELD("b", Type.BYTE_TYPE);
			
			mc.line(i++).LOAD("this");
			mc.GETFIELD("b", Type.BYTE_TYPE);
			mc.RETURNTop();

		});
		Class<?>[] exceptionClasses3 = {};

		cw.mvMethod(ACC_PUBLIC, Type.getType(String.class), "getFieldStr", namesOf(exceptionClasses3)).code(mc->{
			mc.def("xstr", Type.getType(String.class));
			mc.line(53).LOADConst("hello ");
			mc.STORE("xstr");
			mc.line(54).NEW(Type.getType(StringBuilder.class));
			mc.DUP();
			mc.LOAD("xstr");
			mc.INVOKESTATIC(Type.getType(String.class),Type.getType(String.class), "valueOf",Type.getType(Object.class));
			mc.INVOKESPECIAL(Type.getType(StringBuilder.class),Type.VOID_TYPE, "<init>",Type.getType(String.class));
			mc.LOADThis();
			mc.GETFIELD("str", Type.getType(String.class));
			mc.INVOKEVIRTUAL(Type.getType(StringBuilder.class),Type.getType(StringBuilder.class), "append",Type.getType(String.class));
			mc.LOADConst("!");
			mc.INVOKEVIRTUAL(Type.getType(StringBuilder.class),Type.getType(StringBuilder.class), "append",Type.getType(String.class));
			mc.INVOKEVIRTUAL(Type.getType(StringBuilder.class),Type.getType(String.class), "toString");
			mc.STORE("xstr");
			mc.line(55).RETURN("xstr");	
		});
		Class<?>[] exceptionClasses4 = {};

		cw.mvMethod(ACC_PUBLIC, Type.BYTE_TYPE, "retByte", namesOf(exceptionClasses4)).code(mc->{
			mc.def("x",Type.BYTE_TYPE);
			mc.def("y",Type.BYTE_TYPE);
			mc.line(59).LOADConstByte(1);
			mc.STORE("x");
			mc.line().LOAD("x");
			mc.LOADConstByte(1);
			mc.ADD();
			mc.CONVERTTO(Type.BYTE_TYPE);
			mc.STORE("x");
			
			mc.line().LOADThis();
			mc.LOADConstByte(10);
			mc.PUTFIELD("b", Type.BYTE_TYPE);
			mc.line().LOADThis();
			mc.GETFIELD("b", Type.BYTE_TYPE);
			mc.STORE("x");
			mc.line().LOADThis();
			mc.GETFIELD("b", Type.BYTE_TYPE);
			mc.LOAD("x");
			mc.ADD();
			mc.CONVERTTO(Type.BYTE_TYPE);
			mc.STORE("y");
			mc.line().RETURN("y");			
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
