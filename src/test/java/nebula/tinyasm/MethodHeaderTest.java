package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Label;

import nebula.tinyasm.data.ClassBody;
import nebula.tinyasm.data.MethodCode;
import nebula.tinyasm.sample.ClassBody.MethodHeaderSample;

public class MethodHeaderTest extends TestBase {

	String clazz = MethodHeaderSample.class.getName();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMath() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz).body();

		cw.constructerEmpty();

		cw.method("throwException").tHrow(IOException.class).code(mv -> {
			mv.define("file", File.class);
			mv.define("fin", FileInputStream.class);

			mv.line();
			mv.NEW("java/io/File");
			mv.DUP();
			mv.LOADConst("./");
			mv.SPECIAL("java/io/File", "<init>").parameter(String.class).INVOKE();
			mv.STORE(1);

			mv.line();
			mv.LOAD(1);
			mv.VIRTUAL("java/io/File", "exists").reTurn(boolean.class).INVOKE();
			Label l2 = mv.codeNewLabel();
			mv.IFEQ(l2);

			mv.line();
			mv.NEW("java/io/FileInputStream");
			mv.DUP();
			mv.LOAD(1);
			mv.SPECIAL("java/io/FileInputStream", "<init>").parameter(File.class).INVOKE();
			mv.STORE(2);

			mv.line();
			mv.LOAD(2);
			mv.VIRTUAL("java/io/FileInputStream", "read").reTurn(int.class).INVOKE();
			mv.POP();

			mv.line();
			mv.LOAD(2);
			mv.VIRTUAL("java/io/FileInputStream", "close").INVOKE();

			mv.codeAccessLabel(l2);
			mv.line();
			mv.RETURN();
		});

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMatsssh() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz).body();

		cw.constructerEmpty();

		MethodCode mv = cw.method("throwException").tHrow(IOException.class).begin();
		mv.define("file", File.class);
		mv.define("fin", FileInputStream.class);

		mv.line();
		mv.NEW("java/io/File");
		mv.DUP();
		mv.LOADConst("./");
		mv.SPECIAL("java/io/File", "<init>").parameter(String.class).INVOKE();
		mv.STORE(1);

		mv.line();
		mv.LOAD(1);
		mv.VIRTUAL("java/io/File", "exists").reTurn(boolean.class).INVOKE();
		Label l2 = mv.codeNewLabel();
		mv.IFEQ(l2);

		mv.line();
		mv.NEW("java/io/FileInputStream");
		mv.DUP();
		mv.LOAD(1);
		mv.SPECIAL("java/io/FileInputStream", "<init>").parameter(File.class).INVOKE();
		mv.STORE(2);

		mv.block(mb -> {
			mv.line();
			mv.LOAD(2);
			mv.VIRTUAL("java/io/FileInputStream", "read").reTurn(int.class).INVOKE();
			mv.POP();
		});

		mv.line();
		mv.LOAD(2);
		mv.VIRTUAL("java/io/FileInputStream", "close").INVOKE();

		mv.codeAccessLabel(l2);
		mv.line();
		mv.RETURN();
		mv.end();

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathW() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz).body();

		cw.constructerEmpty();

		cw.method("throwException").tHrow(IOException.class.getName()).code(mv -> {
			mv.define("file", File.class);
			mv.define("fin", FileInputStream.class);

			mv.line();
			mv.NEW("java/io/File");
			mv.DUP();
			mv.LOADConst("./");
			mv.SPECIAL("java/io/File", "<init>").parameter(String.class).INVOKE();
			mv.STORE(1);

			mv.line();
			mv.LOAD(1);
			mv.VIRTUAL("java/io/File", "exists").reTurn(boolean.class).INVOKE();
			Label l2 = mv.codeNewLabel();
			mv.IFEQ(l2);

			mv.line();
			mv.NEW("java/io/FileInputStream");
			mv.DUP();
			mv.LOAD(1);
			mv.SPECIAL("java/io/FileInputStream", "<init>").parameter(File.class).INVOKE();
			mv.STORE(2);

			mv.line();
			mv.LOAD(2);
			mv.VIRTUAL("java/io/FileInputStream", "read").reTurn(int.class).INVOKE();
			mv.POP();

			mv.line();
			mv.LOAD(2);
			mv.VIRTUAL("java/io/FileInputStream", "close").INVOKE();

			mv.codeAccessLabel(l2);
			mv.line();
			mv.RETURN();
		});

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

//	@Test
//	public void printClass() {
//		System.out.println(RefineCode.refineCode(toString(clazz)));
//	}

}
