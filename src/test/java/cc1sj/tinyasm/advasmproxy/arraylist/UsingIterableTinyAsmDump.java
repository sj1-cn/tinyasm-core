package cc1sj.tinyasm.advasmproxy.arraylist;
import org.objectweb.asm.Label;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.util.Iterator;
import java.lang.Object;
import cc1sj.tinyasm.advasmproxy.simple.PojoClass;
import java.util.Spliterator;
import java.lang.Iterable;
@SuppressWarnings("unused")
public class UsingIterableTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new UsingIterableTinyAsmDump().dump("cc1sj.tinyasm.advasmproxy.arraylist.UsingIterable");
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
			.parameter("in",Clazz.of(Iterable.class,Clazz.of(PojoClass.class))).begin();

		code.LINE();
		code.LOAD("in");
		code.STORE("hello",Clazz.of(Iterable.class,Clazz.of(PojoClass.class)));

		code.LINE();
		code.LOAD("in");
		code.INTERFACE(Iterable.class, "iterator")
			.return_(Iterator.class).INVOKE();
		code.STORE("iterator",Clazz.of(Iterator.class,Clazz.of(PojoClass.class)));

		code.LINE();
		code.LOAD("in");
		code.INTERFACE(Iterable.class, "spliterator")
			.return_(Spliterator.class).INVOKE();
		code.STORE("spliterator",Clazz.of(Spliterator.class,Clazz.of(PojoClass.class)));

		code.LINE();
		code.RETURN();

		code.END();
	}

}
