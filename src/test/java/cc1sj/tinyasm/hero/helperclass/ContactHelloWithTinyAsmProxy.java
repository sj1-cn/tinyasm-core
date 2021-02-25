package cc1sj.tinyasm.hero.helperclass;

import static cc1sj.tinyasm.hero.HeroBuilder.*;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;

public class ContactHelloWithTinyAsmProxy {

	public static byte[] dump() {
		ClassBody classWriter = ClassBuilder.make("cc1sj.tinyasm.hero.helperclass.ContactHello").access(ACC_PUBLIC | ACC_SUPER).body();

		classWriter.method("<init>").code(code -> {

			code.LINE(3);
			code.LOAD("this");
			code.SPECIAL(Object.class, "<init>").INVOKE();
			code.RETURN();
		});
		{
			MethodCode code = classWriter.method("say").begin();

			HelloClass hello = ctor(HelloClass.class);
			hello.setName("wangshilian");
			String name = hello.getName();
			hello.setName(name);
			hello.setAgeShort((short) 10);

			short age = hello.getAgeShort();
			hello.setAgeShort(age);
			short age2 = add(age, (short) 10);
			hello.setAgeShort(age2);

			hello.setAgeShort2((short) 10);
			Short ageShort2 = hello.getAgeShort2();
			hello.setAgeShort2(ageShort2);

			code.LINE(7);
			code.RETURN();

			code.END();
		}
		return classWriter.end().toByteArray();
	}

	public static void say(MethodCode code) {

	}

}
