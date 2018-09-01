package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nebula.tinyasm.data.ClassBody;
import nebula.tinyasm.data.GenericClazz;
import nebula.tinyasm.sample.ClassBody.MethodCodeMethodCallerSample;

public class MethodCodeMethodCallerSimpleTest extends TestBase {

	String clazz = MethodCodeMethodCallerSample.class.getName();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMath() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz).body();

		cw.field("i", int.class);

		cw.method("<init>").code(mv -> {
			mv.line().initThis();
			mv.line().set("i", m -> m.LOADConstByte(10));
			mv.line().set("i", m -> m.LOADConstByte(100));
			mv.line().returnVoid();

		});

		cw.method("method").ACC_PUBLIC().ACC_STATIC().parameter("data", String.class).code(mv -> {
			mv.define("i", int.class);
			mv.define("l", Long.class);
			mv.define("s", String.class);
			mv.define("ls", GenericClazz.generic(List.class, String.class));

			mv.line().set("i", m -> m.LOADConstByte(10));

			mv.line()
				.clazz(Long.class)
				.call("valueOf")
				.parameter(long.class)
				.returnObject(Long.class)
				.invoke(m -> m.LOADConst(new Long(10L)))
				.set("l");

			mv.line()
				.clazz(String.class)
				.call("valueOf")
				.parameter(int.class)
				.returnObject(String.class)
				.invoke(m -> m.LOAD(1))
				.set("s");

			// @formatter:off
			mv.line().init(StringBuilder.class)
				.virtual("append").parameter(String.class).returnObject(StringBuilder.class).invoke("s")
				.virtual("append").returnObject(StringBuilder.class).invoke("i")
				.virtual("append").parameter(Object.class).returnObject(StringBuilder.class).invoke("l")
				.virtual("toString").returnObject(String.class).invoke()
				.set("s");
			// @formatter:on

			mv.line().init(ArrayList.class).set("ls");

			mv.line()
				.load("ls")
				.inter("add")
				.parameter(Object.class)
				.returnObject(boolean.class)
				.invoke(m -> m.LOADConst("first"));
			mv.POP();

			mv.line()
				.load("ls")
				.inter("add")
				.parameter(Object.class)
				.returnObject(boolean.class)
				.invoke(m -> m.LOADConst("second"));
			mv.POP();

			mv.line().returnVoid();
		});

		// @formatter:on

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

//	@Test
//	public void printClass() {
//		System.out.println(RefineCode.refineCode(toString(clazz)));
//	}

}
