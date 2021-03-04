package cc1sj.tinyasm;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cc1sj.tinyasm.sample.ClassBody.MethodCodeMethodCallerSample;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class MethodCodeMethodCallerTest {

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

		cw.publicMethod(/* V */ "<init>" /**/).code(mv -> {
			mv.LINE();
			mv.LOAD(0);
			mv.SPECIAL(Object.class, "<init>").INVOKE();
			mv.LINE();
			mv.LOAD(0);
			mv.LOADConstByte(10);
			mv.PUTFIELD_OF_THIS("i");

			mv.LINE();
			mv.LOAD(0);
			mv.LOADConstByte(100);
			mv.PUTFIELD_OF_THIS("i");

			mv.LINE();
			mv.RETURN();

		});

		cw.method("method").ACC_PUBLIC().ACC_STATIC().parameter("data", String.class).code(mv -> {
			mv.define("i", int.class);
			mv.define("l", Long.class);
			mv.define("s", String.class);
			mv.define("ls", Clazz.of(List.class,String.class));

			mv.LINE();
			mv.LOADConstByte(10);
			mv.STORE("i");
			mv.LINE();
			mv.LOADConst(Long.valueOf(10L));
			mv.STATIC(Long.class, "valueOf").parameter(long.class).reTurn(Long.class).INVOKE();
			mv.STORE("l");

			mv.LINE();
			mv.LOAD(1);
			mv.STATIC(String.class, "valueOf").parameter(int.class).reTurn(String.class).INVOKE();
			mv.STORE("s");

			mv.LINE();
			mv.NEW("java/lang/StringBuilder");
			mv.DUP();
			mv.SPECIAL(StringBuilder.class, "<init>").INVOKE();
			mv.LOAD("s");
			mv.VIRTUAL(StringBuilder.class, "append").parameter(String.class).reTurn(StringBuilder.class).INVOKE();
			mv.LOAD("i");
			mv.VIRTUAL(StringBuilder.class, "append").parameter(int.class).reTurn(StringBuilder.class).INVOKE();
			mv.LOAD("l");
			mv.VIRTUAL(StringBuilder.class, "append").parameter(Object.class).reTurn(StringBuilder.class).INVOKE();
			mv.VIRTUAL(StringBuilder.class, "toString").reTurn(String.class).INVOKE();
			mv.STORE("s");

			mv.LINE();
			mv.NEW("java/util/ArrayList");
			mv.DUP();
			mv.SPECIAL("java/util/ArrayList", "<init>").INVOKE();
			mv.STORE("ls");

			mv.LINE();
			mv.LOAD("ls");
			mv.LOADConst("first");
			mv.INTERFACE("java/util/List", "add").parameter(Object.class).reTurn(boolean.class).INVOKE();
			mv.POP();

			mv.LINE();
			mv.LOAD("ls");
			mv.LOADConst("second");
			mv.INTERFACE("java/util/List", "add").parameter(Object.class).reTurn(boolean.class).INVOKE();
			mv.POP();

			mv.LINE();
			mv.RETURN();
		});

		// @formatter:on

		String codeActual = TinyAsmTestUtils.toString(clazz,cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

//	@Test
//	public void printClass() {
//		System.out.println(RefineCode.refineCode(toString(clazz)));
//	}

}
