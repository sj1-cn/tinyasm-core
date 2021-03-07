package cc1sj.tinyasm.hero.advasmproxy;
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
import cc1sj.tinyasm.sourceconverter.ReferedObject;
import java.lang.Object;
@SuppressWarnings("unused")
public class AdvAsmProxyWithReferRefferSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new AdvAsmProxyWithReferRefferSampleTinyAsmDump().dump("cc1sj.tinyasm.hero.helperclass.AdvAsmProxyWithReferRefferSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_getRefer(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, "<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _getRefer(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, ReferedObject.class, "getRefer").begin();

		code.LINE();
		code.NEW(ReferedObject.class);
		code.DUP();
		code.SPECIAL(ReferedObject.class, "<init>").INVOKE();
		code.RETURNTop();

		code.END();
	}

}
