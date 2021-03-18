package cn.sj1.tinyasm.core;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Label;

import cn.sj1.tinyasm.core.sample.ClassBody.MethodHeaderSample;
import cn.sj1.tinyasm.tools.RefineCode;
import cn.sj1.tinyasm.tools.TinyAsmTestUtils;

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

		cw.public_().method("throwException").throws_(IOException.class).code(mv -> {
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
			mv.VIRTUAL("java/io/File", "exists").return_(boolean.class).INVOKE();
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
			mv.VIRTUAL("java/io/FileInputStream", "read").return_(int.class).INVOKE();
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

		MethodCode mv = cw.public_().method("throwException").throws_(IOException.class).begin();
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
		mv.VIRTUAL("java/io/File", "exists").return_(boolean.class).INVOKE();
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
			mv.VIRTUAL("java/io/FileInputStream", "read").return_(int.class).INVOKE();
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

		cw.public_().method("throwException").throws_(IOException.class.getName()).code(mv -> {
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
			mv.VIRTUAL("java/io/File", "exists").return_(boolean.class).INVOKE();
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
			mv.VIRTUAL("java/io/FileInputStream", "read").return_(int.class).INVOKE();
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
