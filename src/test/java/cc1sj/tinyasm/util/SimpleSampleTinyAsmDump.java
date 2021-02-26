package cc1sj.tinyasm.util;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.lang.Object;
@SuppressWarnings("unused")
public class SimpleSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new SimpleSampleTinyAsmDump().__dump__("cc1sj.tinyasm.util.SimpleSample");
	}

	public byte[] __dump__(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className).access(ACC_PUBLIC | ACC_SUPER).body();

classBody.field("i", Clazz.of(int.class));
		__init_(classBody);
		_dd(classBody);
		_methodWith1Param(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method("<init>").begin();

		code.LINE(6);
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();

		code.LINE(4);
		code.LOAD("this");
		code.LOADConst(0);
		code.PUTFIELD("i", int.class);

		code.LINE(8);
		code.RETURN();

		code.END();
	}

	protected void _dd(ClassBody classBody) {
		MethodCode code = classBody.method("dd").begin();

		code.LINE(11);
		code.LOADConst(1);
		code.STORE("j",int.class);

		code.LINE(12);
		code.LOADConst(1);
		code.STORE("k",int.class);

		code.LINE(13);
		code.LOAD("j");
		code.LOADConst(10);
		code.ADD();
		code.STORE("k1",int.class);

		code.LINE(14);
		code.LOAD("k1");
		code.LOADConst(10);
		code.ADD();
		code.STORE("j1",int.class);

		code.LINE(15);
		code.RETURN();

		code.END();
	}

	protected void _methodWith1Param(ClassBody classBody) {
		MethodCode code = classBody.method("methodWith1Param")
		.parameter("i",int.class).begin();

		code.LINE(18);
		code.LOAD("this");
		code.LOAD("i");
		code.PUTFIELD("i", int.class);

		code.LINE(19);
		code.RETURN();

		code.END();
	}

}
