package cc1sj.tinyasm.hero.helperclass;
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
import cc1sj.tinyasm.hero.helperclass.PojoClassChildSample;
import cc1sj.tinyasm.hero.helperclass.GenericInterface;
import java.lang.Object;
import cc1sj.tinyasm.hero.helperclass.PojoClassSample;
@SuppressWarnings("unused")
public class GenericInterfaceImplSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new GenericInterfaceImplSampleTinyAsmDump().dump("cc1sj.tinyasm.hero.helperclass.GenericInterfaceImplSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className, Clazz.of(Object.class),Clazz.of(GenericInterface.class,Clazz.of(PojoClassSample.class)))
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
		MethodCode code = classBody.publicMethod("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _getT(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(PojoClassSample.class, "getT").begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _getPojoClassChildSample(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(PojoClassChildSample.class, "getPojoClassChildSample").begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _setT(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setT")
			.parameter("t",PojoClassSample.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setPojoClassChildSample(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setPojoClassChildSample")
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
		MethodCode code = classBody.method(ACC_PUBLIC | ACC_BRIDGE | ACC_SYNTHETIC, Object.class, "getT").begin();

		code.LINE();
		code.LOAD("this");
		code.VIRTUAL("getT")
			.reTurn(PojoClassSample.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

}
