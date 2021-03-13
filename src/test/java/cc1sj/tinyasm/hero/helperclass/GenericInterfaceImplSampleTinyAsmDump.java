package cc1sj.tinyasm.hero.helperclass;
import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.MethodCode;
@SuppressWarnings("unused")
public class GenericInterfaceImplSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new GenericInterfaceImplSampleTinyAsmDump().dump("cc1sj.tinyasm.hero.helperclass.GenericInterfaceImplSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className, Clazz.of(Object.class),Clazz.of(GenericInterface.class,Clazz.of(PojoClassSample.class)))
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_getT(classBody);
		_getPojoClassChildSample(classBody);
		_setT(classBody);
		_setPojoClassChildSample(classBody);
		_bridge_setT(classBody);
		_bridge_getT(classBody);

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

	protected void _getT(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getT")
			.return_(PojoClassSample.class ).begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _getPojoClassChildSample(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getPojoClassChildSample")
			.return_(PojoClassChildSample.class ).begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _setT(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setT")
			.parameter("t",PojoClassSample.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setPojoClassChildSample(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setPojoClassChildSample")
			.parameter("classSample",PojoClassChildSample.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _bridge_setT(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC | ACC_BRIDGE | ACC_SYNTHETIC, "setT")
			.parameter("var1",Object.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("var1");
		code.CHECKCAST(PojoClassSample.class);
		code.VIRTUAL("setT")
			.parameter(PojoClassSample.class).INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _bridge_getT(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC | ACC_BRIDGE | ACC_SYNTHETIC, "getT")
			.return_(Object.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.VIRTUAL("getT")
			.return_(PojoClassSample.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

}
