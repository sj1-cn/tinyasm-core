package cc1sj.tinyasm;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Label;

import cc1sj.tinyasm.sample.ClassBody.MethodHeaderSample;
import cc1sj.tinyasm.util.RefineCode;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class MethodHeaderTest  {

	String clazz = MethodHeaderSample.class.getName();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMath() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		cw.publicMethod("throwException").tHrow(IOException.class).code(mv -> {
			mv.define("file", File.class);
			mv.define("fileInputStream", FileInputStream.class);

			mv.LINE();
			mv.NEW("java/io/File");
			mv.DUP();
			mv.LOADConst("./");
			mv.SPECIAL("java/io/File", "<init>").parameter(String.class).INVOKE();
			mv.STORE("file");

			mv.LINE();
			mv.LOAD("file");
			mv.VIRTUAL("java/io/File", "exists").reTurn(boolean.class).INVOKE();
			Label l2 = mv.codeNewLabel();
			mv.IFEQ(l2);

			mv.LINE();
			mv.NEW("java/io/FileInputStream");
			mv.DUP();
			mv.LOAD("file");
			mv.SPECIAL("java/io/FileInputStream", "<init>").parameter(File.class).INVOKE();
			mv.STORE("fileInputStream");

			mv.LINE();
			mv.LOAD("fileInputStream");
			mv.VIRTUAL("java/io/FileInputStream", "read").reTurn(int.class).INVOKE();
			mv.POP();

			mv.LINE();
			mv.LOAD("fileInputStream");
			mv.VIRTUAL("java/io/FileInputStream", "close").INVOKE();

			mv.visitLabel(l2);
			mv.LINE();
			mv.RETURN();
		});

		String codeActual = RefineCode.excludeLocalVariable(TinyAsmTestUtils.toString(clazz,cw.end().toByteArray()));
		String codeExpected = RefineCode.excludeLocalVariable(TinyAsmTestUtils.toString(clazz));
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMatsssh() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		MethodCode mv = cw.publicMethod("throwException").tHrow(IOException.class).begin();
		mv.define("file", File.class);
		mv.define("fileInputStream", FileInputStream.class);

		mv.LINE();
		mv.NEW("java/io/File");
		mv.DUP();
		mv.LOADConst("./");
		mv.SPECIAL("java/io/File", "<init>").parameter(String.class).INVOKE();
		mv.STORE("file");

		mv.LINE();
		mv.LOAD("file");
		mv.VIRTUAL("java/io/File", "exists").reTurn(boolean.class).INVOKE();
		Label l2 = mv.codeNewLabel();
		mv.IFEQ(l2);

		mv.LINE();
		mv.NEW("java/io/FileInputStream");
		mv.DUP();
		mv.LOAD("file");
		mv.SPECIAL("java/io/FileInputStream", "<init>").parameter(File.class).INVOKE();
		mv.STORE("fileInputStream");

		mv.BLOCK(mb -> {
			mv.LINE();
			mv.LOAD("fileInputStream");
			mv.VIRTUAL("java/io/FileInputStream", "read").reTurn(int.class).INVOKE();
			mv.POP();
		});

		mv.LINE();
		mv.LOAD("fileInputStream");
		mv.VIRTUAL("java/io/FileInputStream", "close").INVOKE();

		mv.visitLabel(l2);
		mv.LINE();
		mv.RETURN();
		mv.END();

		String codeActual = RefineCode.excludeLocalVariable(TinyAsmTestUtils.toString(clazz,cw.end().toByteArray()));
		String codeExpected = RefineCode.excludeLocalVariable(TinyAsmTestUtils.toString(clazz));
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMathW() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.constructerEmpty();

		cw.publicMethod("throwException").tHrow(IOException.class.getName()).code(mv -> {
			mv.define("file", File.class);
			mv.define("fileInputStream", FileInputStream.class);

			mv.LINE();
			mv.NEW("java/io/File");
			mv.DUP();
			mv.LOADConst("./");
			mv.SPECIAL("java/io/File", "<init>").parameter(String.class).INVOKE();
			mv.STORE("file");

			mv.LINE();
			mv.LOAD("file");
			mv.VIRTUAL("java/io/File", "exists").reTurn(boolean.class).INVOKE();
			Label l2 = mv.codeNewLabel();
			mv.IFEQ(l2);

			mv.LINE();
			mv.NEW("java/io/FileInputStream");
			mv.DUP();
			mv.LOAD("file");
			mv.SPECIAL("java/io/FileInputStream", "<init>").parameter(File.class).INVOKE();
			mv.STORE("fileInputStream");

			mv.LINE();
			mv.LOAD("fileInputStream");
			mv.VIRTUAL("java/io/FileInputStream", "read").reTurn(int.class).INVOKE();
			mv.POP();

			mv.LINE();
			mv.LOAD("fileInputStream");
			mv.VIRTUAL("java/io/FileInputStream", "close").INVOKE();

			mv.visitLabel(l2);
			mv.LINE();
			mv.RETURN();
		});

		String codeActual = RefineCode.excludeLocalVariable(TinyAsmTestUtils.toString(clazz,cw.end().toByteArray()));
		String codeExpected = RefineCode.excludeLocalVariable(TinyAsmTestUtils.toString(clazz));
		assertEquals("Code", codeExpected, codeActual);
	}
}
