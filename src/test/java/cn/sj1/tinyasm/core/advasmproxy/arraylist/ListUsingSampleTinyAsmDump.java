package cn.sj1.tinyasm.core.advasmproxy.arraylist;
import org.objectweb.asm.Label;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import cn.sj1.tinyasm.core.ClassBody;
import cn.sj1.tinyasm.core.ClassBuilder;
import cn.sj1.tinyasm.core.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cn.sj1.tinyasm.core.Annotation;
import cn.sj1.tinyasm.core.Clazz;
import java.util.List;
import java.util.Iterator;
import java.lang.Object;
import cn.sj1.tinyasm.core.advasmproxy.simple.PojoClass;
import java.util.Spliterator;
import java.lang.Iterable;
@SuppressWarnings("unused")
public class ListUsingSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new ListUsingSampleTinyAsmDump().dump("cn.sj1.tinyasm.core.advasmproxy.arraylist.ListUsingSample");
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
			.parameter("in",Clazz.of(List.class,Clazz.of(PojoClass.class))).begin();

		code.LINE();
		code.LOAD("in");
		code.STORE("hello",Clazz.of(Iterable.class,Clazz.of(PojoClass.class)));

		code.LINE();
		code.LOAD("in");
		code.INTERFACE(List.class, "iterator")
			.return_(Iterator.class).INVOKE();
		code.STORE("iterator",Clazz.of(Iterator.class,Clazz.of(PojoClass.class)));

		code.LINE();
		code.LOAD("in");
		code.INTERFACE(List.class, "spliterator")
			.return_(Spliterator.class).INVOKE();
		code.STORE("spliterator",Clazz.of(Spliterator.class,Clazz.of(PojoClass.class)));

		code.LINE();
		code.LOAD("in");
		code.LOADConst(0);
		code.INTERFACE(List.class, "remove")
			.return_(Object.class)
			.parameter(int.class).INVOKE();
		code.CHECKCAST(PojoClass.class);
		code.STORE("pojoClassSample",PojoClass.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
