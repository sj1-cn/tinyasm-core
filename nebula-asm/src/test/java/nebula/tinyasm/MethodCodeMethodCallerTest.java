package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nebula.tinyasm.data.ClassBody;
import nebula.tinyasm.data.GenericClazz;
import nebula.tinyasm.sample.ClassBody.MethodCodeMethodCallerSample;

public class MethodCodeMethodCallerTest extends TestBase {

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

		cw.method(/* V */ "<init>" /**/).code(mv -> {
			mv.line();
			mv.LOAD(0);
			mv.SPECIAL(Object.class, "<init>").INVOKE();
			mv.line();
			mv.LOAD(0);
			mv.LOADConstByte(10);
			mv.PUTFIELD_OF_THIS("i");

			mv.line();
			mv.LOAD(0);
			mv.LOADConstByte(100);
			mv.PUTFIELD_OF_THIS("i");

			mv.line();
			mv.RETURN();

		});

		cw.method("method").ACC_PUBLIC().ACC_STATIC().parameter("data", String.class).code(mv -> {
			mv.define("i", int.class);
			mv.define("l", Long.class);
			mv.define("s", String.class);
			mv.define("ls", GenericClazz.clazz(List.class, String.class));

			mv.line();
			mv.LOADConstByte(10);
			mv.STORE("i");
			mv.line();
			mv.LOADConst(new Long(10L));
			mv.STATIC(Long.class, "valueOf").param(long.class).reTurn(Long.class).INVOKE();
			mv.STORE("l");

			mv.line();
			mv.LOAD(1);
			mv.STATIC(String.class, "valueOf").param(int.class).reTurn(String.class).INVOKE();
			mv.STORE("s");

			mv.line();
			mv.NEW("java/lang/StringBuilder");
			mv.DUP();
			mv.SPECIAL(StringBuilder.class, "<init>").INVOKE();
			mv.LOAD("s");
			mv.VIRTUAL(StringBuilder.class, "append").param(String.class).reTurn(StringBuilder.class).INVOKE();
			mv.LOAD("i");
			mv.VIRTUAL(StringBuilder.class, "append").param(int.class).reTurn(StringBuilder.class).INVOKE();
			mv.LOAD("l");
			mv.VIRTUAL(StringBuilder.class, "append").param(Object.class).reTurn(StringBuilder.class).INVOKE();
			mv.VIRTUAL(StringBuilder.class, "toString").reTurn(String.class).INVOKE();
			mv.STORE("s");

			mv.line();
			mv.NEW("java/util/ArrayList");
			mv.DUP();
			mv.SPECIAL("java/util/ArrayList", "<init>").INVOKE();
			mv.STORE("ls");

			mv.line();
			mv.LOAD("ls");
			mv.LOADConst("first");
			mv.INTERFACE("java/util/List", "add").param(Object.class).reTurn(boolean.class).INVOKE();
			mv.POP();

			mv.line();
			mv.LOAD("ls");
			mv.LOADConst("second");
			mv.INTERFACE("java/util/List", "add").param(Object.class).reTurn(boolean.class).INVOKE();
			mv.POP();

			mv.line();
			mv.RETURN();
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
