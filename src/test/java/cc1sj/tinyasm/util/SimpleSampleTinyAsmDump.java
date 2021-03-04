package cc1sj.tinyasm.util;
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
import java.lang.Object;
@SuppressWarnings("unused")
public class SimpleSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new SimpleSampleTinyAsmDump().dump("cc1sj.tinyasm.util.SimpleSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.field("i", Clazz.of(int.class));
		__init_(classBody);
		_dd(classBody);
		_methodWith1Param(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, "<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();

		code.LINE();
		code.LOAD("this");
		code.LOADConst(0);
		code.PUTFIELD_OF_THIS("i");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _dd(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, "dd").begin();

		code.LINE();
		code.LOADConst(1);
		code.STORE("j",int.class);

		code.LINE();
		code.LOADConst(1);
		code.STORE("k",int.class);

		code.LINE();
		code.LOAD("j");
		code.LOADConst(10);
		code.ADD();
		code.STORE("k1",int.class);

		code.LINE();
		code.LOAD("k1");
		code.LOADConst(10);
		code.ADD();
		code.STORE("j1",int.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _methodWith1Param(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC, "methodWith1Param")
			.parameter("i",int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("i");
		code.PUTFIELD_OF_THIS("i");

		code.LINE();
		code.RETURN();

		code.END();
	}

}
