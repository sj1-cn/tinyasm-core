package cn.sj1.tinyasm.core.sample.MethodCode;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import org.junit.Test;

import cn.sj1.tinyasm.core.ClassBody;
import cn.sj1.tinyasm.core.ClassBuilder;
import cn.sj1.tinyasm.core.MethodCode;

public class MethodCodeOtherTest {
	@Test
	public void testOther() {
		String className = "MethodCodeOtherTest";
		ClassBody classBody = ClassBuilder.class_(className)
				.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.constructerEmpty();

		MethodCode code = classBody.public_().method("getAll").begin();

		code.LINE();
		code.LOADConst(1);
		code.STORE("i", int.class);

		code.LINE();
		code.LOADConst(1L);
		code.STORE("l", long.class);

		code.LOAD("i");
		code.DUP();
		code.ADD();

		code.STORE("i2");

		code.LOAD("l");
		code.DUP();
		code.DIV();
		code.STORE("l2");

		code.LOAD("i");
		code.STORE("i3", int.class);

		code.LOAD("l");
		code.STORE("l3", long.class);

		code.NOP();

		code.END();

		classBody.end().toByteArray();
	}
}
