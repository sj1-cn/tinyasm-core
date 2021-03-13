package cc1sj.tinyasm.hero.helperclass;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import java.util.Iterator;
import java.util.Spliterator;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.MethodCode;
@SuppressWarnings("unused")
public class UsingIterableTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new UsingIterableTinyAsmDump().dump("cc1sj.tinyasm.hero.helperclass.UsingIterable");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_say(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _say(ClassBody classBody) {
		MethodCode code = classBody.public_().method("say")
			.return_(Clazz.of(void.class) )
			.parameter("in",Clazz.of(Iterable.class,Clazz.of(PojoClassSample.class))).begin();

		code.LINE();
		code.LOAD("in");
		code.STORE("hello",Clazz.of(Iterable.class,Clazz.of(PojoClassSample.class)));

		code.LINE();
		code.LOAD("in");
		code.INTERFACE(Iterable.class, "iterator")
			.return_(Iterator.class).INVOKE();
		code.STORE("iterator",Clazz.of(Iterator.class,Clazz.of(PojoClassSample.class)));

		code.LINE();
		code.LOAD("in");
		code.INTERFACE(Iterable.class, "spliterator")
			.return_(Spliterator.class).INVOKE();
		code.STORE("spliterator",Clazz.of(Spliterator.class,Clazz.of(PojoClassSample.class)));

		code.LINE();
		code.RETURN();

		code.END();
	}

}
