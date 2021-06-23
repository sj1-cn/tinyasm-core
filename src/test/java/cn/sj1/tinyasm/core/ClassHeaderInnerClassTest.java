package cn.sj1.tinyasm.core;

import static org.junit.Assert.assertEquals;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Opcodes;

import cn.sj1.tinyasm.core.sample.ClassHeader.InnerClassSample;
import cn.sj1.tinyasm.tools.TinyAsmTestUtils;

public class ClassHeaderInnerClassTest {

	String clazz = InnerClassSample.class.getName();
	String innerclazz = InnerClassSample.class.getName() + "$Test";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMath() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz).body();

		cw.referInnerClass("Test");

		cw.private_().field("outer", int.class);
		cw.constructerEmpty();

		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testMathInner() throws Exception {
		ClassBody cw = ClassBuilder.class_(clazz + "$Test").access(ACC_SUPER).body();

		cw.referInnerClass("Test");

		cw.private_().field("inner", Clazz.of(int.class));
		cw.field(Opcodes.ACC_FINAL | Opcodes.ACC_SYNTHETIC, "this$0", Clazz.of(clazz));

		cw.method(0, "<init>").parameter(Opcodes.ACC_FINAL | Opcodes.ACC_MANDATED, "this$0", Clazz.of(clazz)).code(mv -> {
			mv.LINE();
			mv.LOAD(0);
			mv.LOAD(1);
			mv.PUTFIELD_OF_THIS("this$0");
			mv.LOAD(0);
			mv.SPECIAL(Object.class, "<init>").INVOKE();
			mv.RETURN();
		});

		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(innerclazz);
		assertEquals("Code", codeExpected, codeActual);
	}

}
