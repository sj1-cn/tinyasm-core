package cc1sj.tinyasm;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Opcodes;

import cc1sj.tinyasm.sample.ClassHeader.InnerClassSample;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

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
		ClassBody cw = ClassBuilder.make(clazz).body();

		cw.referInnerClass("Test");

		cw.field("outer", int.class);
		cw.constructerEmpty();

		String codeActual = TinyAsmTestUtils.toString(clazz,cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void testMathInner() throws Exception {
		ClassBody cw = ClassBuilder.make(clazz + "$Test").ACC_SUPER().body();

		cw.referInnerClass("Test");

		cw.field("inner", Clazz.of(int.class));
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

		String codeActual = TinyAsmTestUtils.toString(clazz,cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(innerclazz);
		assertEquals("Code", codeExpected, codeActual);
	}

//	@Test
//	public void printClass() {
//		System.out.println(RefineCode.refineCode(toString(innerclazz)));
//	}

}
