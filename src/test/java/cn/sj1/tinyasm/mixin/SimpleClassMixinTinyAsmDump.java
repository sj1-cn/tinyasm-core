package cn.sj1.tinyasm.mixin;
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
import java.lang.StringBuffer;
import cn.sj1.tinyasm.mixin.SimpleClass;
import java.lang.String;
@SuppressWarnings("unused")
public class SimpleClassMixinTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new SimpleClassMixinTinyAsmDump().dump("cn.sj1.tinyasm.mixin.SimpleClassMixin");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className, SimpleClass.class)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_getName(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(SimpleClass.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _getName(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getName")
			.return_(String.class )
			.parameter("name",String.class).begin();

		code.LINE();
		code.NEW(StringBuffer.class);
		code.DUP();
		code.LOAD("name");
		code.SPECIAL(StringBuffer.class, "<init>")
			.parameter(String.class).INVOKE();
		code.LOADConst("++");
		code.VIRTUAL(StringBuffer.class, "append")
			.return_(StringBuffer.class)
			.parameter(String.class).INVOKE();
		code.VIRTUAL(StringBuffer.class, "toString")
			.return_(String.class).INVOKE();
		code.STORE("name");

		code.LINE();
		code.LOAD("name");
		code.RETURNTop();

		code.END();
	}

}
