package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClassBuilderFieldTest extends TestBase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMath() throws Exception {
//		ClassVisitor visitor = new TraceClassVisitor(null, new ASMifier(), new PrintWriter(System.out));
//		ClassVisitor visitor = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);

		ClassBody cw = ClassBuilder.make(this.getClass().getPackage().getName() + "/ClassBuilderField").body();

		// @formatter:off
		cw.field("b",  byte.class);
		cw.field("c", char.class);
		cw.field("s",short.class);
		cw.field("i",int.class);
		cw.field("l",long.class);
		cw.field("f",float.class);
		cw.field("d",double.class);
		cw.field("str",String.class);
		
		cw.publicMethod("<init>").code(mc -> {
			mc.line(3).INITObject();
			mc.RETURN();
		});
		
		cw.method(int.class, "getField").code(mc->{
			mc.define("x", int.class);
			mc.line(14).LOAD("this");
			mc.GET_THIS_FIELD("b");
			mc.LOAD("this");
			mc.GET_THIS_FIELD("i");
			mc.ADD();
			mc.STORE("x");
			mc.line(15).LOAD("x");
			mc.RETURNTop();
		});

		cw.method(int.class, "getFieldAll").code(mc->{
			mc.define("x", int.class);
			mc.line(19);
			mc.getThisField("b");
			mc.getThisField("c");
			mc.ADD();
			mc.LOAD("this");
			mc.GET_THIS_FIELD("s");
			mc.ADD();
			mc.LOAD("this");
			mc.GET_THIS_FIELD("i");
			mc.ADD();
			mc.CONVERTTO(long.class);
			mc.LOAD("this");
			mc.GET_THIS_FIELD("l");
			mc.ADD();
			mc.CONVERTTO(float.class);
			mc.LOAD("this");
			mc.GET_THIS_FIELD("f");
			mc.ADD();
			mc.CONVERTTO(double.class);
			mc.LOAD("this");
			mc.GET_THIS_FIELD("d");
			mc.ADD();
			mc.CONVERTTO(int.class);
			mc.STORE("x");
			mc.line(20).LOAD("x");
			mc.RETURNTop();
		});

		cw.publicMethod(int.class,"getFieldConst").code(mc->{
			mc.line(24).LOAD("this");
			mc.LOADConstByte(100);
			mc.PUT_THIS_FIELD("b");
			mc.line(25).LOAD("this");
			mc.LOADConstShort(1000);
			mc.PUT_THIS_FIELD("c");
			mc.line(26).LOAD("this");
			mc.LOADConstShort(10000);
			mc.PUT_THIS_FIELD("s");

			mc.line(27).LOAD("this");
			mc.LOADConst(100000);
			mc.PUT_THIS_FIELD("i");

			mc.line(28).LOAD("this");
			mc.LOADConst(1000000L);
			mc.PUT_THIS_FIELD("l");
			
			mc.line(29).LOAD("this");
			mc.LOADConst(1.0E7F);
			mc.PUT_THIS_FIELD("f");


			mc.line(30).LOAD("this");
			mc.LOADConst(1.0E8D);
			mc.PUT_THIS_FIELD("d");
			
			mc.line(31).LOAD("this");
			mc.LOADConst("1000000000s");
			mc.PUT_THIS_FIELD("str");
			
			mc.line(32).LOAD("this");
			mc.GET_THIS_FIELD("b");
			mc.LOAD("this");
			mc.GET_THIS_FIELD("c");
			mc.ADD();
			mc.LOAD("this");
			mc.GET_THIS_FIELD("s");
			mc.ADD();
			mc.LOAD("this");
			mc.GET_THIS_FIELD("i");
			mc.ADD();
			mc.CONVERTTO(long.class);
			mc.LOAD("this");
			mc.GET_THIS_FIELD("l");
			mc.ADD();
			mc.CONVERTTO(float.class);
			mc.LOAD("this");
			mc.GET_THIS_FIELD("f");
			mc.ADD();
			mc.CONVERTTO(double.class);
			mc.LOAD("this");
			mc.GET_THIS_FIELD("d");
			mc.ADD();

			mc.CONVERTTO(int.class);
			mc.RETURNTop();

		});		
		
		cw.method(int.class, "getFieldIConst").code(mc->{

			int i = 36;
			mc.line(i++).LOAD("this");
			mc.LOADConstByte(0);
			mc.PUT_THIS_FIELD("b");

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(1);
			mc.PUT_THIS_FIELD("b");

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(2);
			mc.PUT_THIS_FIELD("b");

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(3);
			mc.PUT_THIS_FIELD("b");

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(4);
			mc.PUT_THIS_FIELD("b");

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(5);
			mc.PUT_THIS_FIELD("b");

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(6);
			mc.PUT_THIS_FIELD("b");

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(7);
			mc.PUT_THIS_FIELD("b");

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(8);
			mc.PUT_THIS_FIELD("b");
			
			
			mc.line(i++).LOAD("this");
			mc.LOADConstByte(-4);
			mc.PUT_THIS_FIELD("b");

			mc.line(i++).LOAD("this");
			mc.LOADConstByte(-3);
			mc.PUT_THIS_FIELD("b");
			
			mc.line(i++).LOAD("this");
			mc.LOADConstByte(-2);
			mc.PUT_THIS_FIELD("b");


			mc.line(i++).LOAD("this");
			mc.LOADConstByte(-1);
			mc.PUT_THIS_FIELD("b");
			
			mc.line(i++).LOAD("this");
			mc.GET_THIS_FIELD("b");
			mc.RETURNTop();

		});

		cw.method(String.class, "getFieldStr").code(mc->{
			mc.define("xstr", String.class);
			mc.line(53).LOADConst("hello ");
			mc.STORE("xstr");
			mc.line(54).NEW(StringBuilder.class);
			mc.DUP();
			mc.LOAD("xstr");
			mc.INVOKESTATIC(String.class,String.class, "valueOf",Object.class);
			mc.INVOKESPECIAL(StringBuilder.class,"<init>",String.class);
			mc.LOADThis();
			mc.GET_THIS_FIELD("str");
			mc.INVOKEVIRTUAL(StringBuilder.class,StringBuilder.class, "append",String.class);
			mc.LOADConst("!");
			mc.INVOKEVIRTUAL(StringBuilder.class,StringBuilder.class, "append",String.class);
			mc.INVOKEVIRTUAL(StringBuilder.class,String.class, "toString");
			mc.STORE("xstr");
			mc.line(55).RETURN("xstr");	
		});

		cw.method(byte.class, "retByte").code(mc->{
			mc.define("x", byte.class);
			mc.define("y", byte.class);
			mc.line(59).LOADConstByte(1);
			mc.STORE("x");
			mc.line().LOAD("x");
			mc.LOADConstByte(1);
			mc.ADD();
			mc.CONVERTTO(byte.class);
			mc.STORE("x");
			
			mc.line().LOADThis();
			mc.LOADConstByte(10);
			mc.PUT_THIS_FIELD("b");
			mc.line().LOADThis();
			mc.GET_THIS_FIELD("b");
			mc.STORE("x");
			mc.line().LOADThis();
			mc.GET_THIS_FIELD("b");
			mc.LOAD("x");
			mc.ADD();
			mc.CONVERTTO(byte.class);
			mc.STORE("y");
			mc.line().RETURN("y");			
		});
		
		// @formatter:on

		byte[] code = cw.end().toByteArray();

		String strCode = toString(code);
		String strCodeExpected = toString(ClassBuilderField.class.getName());
		assertEquals("Code", strCodeExpected, strCode);
	}

	@Test
	public void printClass() throws IOException {
		System.out.println(toString(ClassBuilderField.class.getName()));
	}
}
