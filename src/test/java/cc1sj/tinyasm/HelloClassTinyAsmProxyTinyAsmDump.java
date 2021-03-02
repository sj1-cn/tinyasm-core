package cc1sj.tinyasm;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

import org.objectweb.asm.Type;

import cc1sj.tinyasm.hero.helperclass.HelloClass;

public class HelloClassTinyAsmProxyTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new HelloClassTinyAsmProxyTinyAsmDump().dump("cc1sj.tinyasm.HelloClassTinyAsmProxy");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className, HelloClass.class, TinyAsmProxyRuntimeReferNameObject.class)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.field("_referName", Clazz.of(String.class));
		classBody.field("_context", Clazz.of(TinyAsmBuilderContext.class));
		classBody.field("_code", Clazz.of(MethodCode.class));
		__init_(classBody);
		_get__ReferName(classBody);
		___init(classBody);
		_getAgeInt(classBody);
		_setAgeInt(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method("<init>").begin();

		code.LINE(10);
		code.LOAD("this");
		code.SPECIAL(HelloClass.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _get__ReferName(ClassBody classBody) {
		MethodCode code = classBody.method(String.class, "get__ReferName").begin();

		code.LINE(18);
		code.LOAD("this");
		code.GETFIELD("_referName", String.class);
		code.RETURNTop();

		code.END();
	}

	protected void ___init(ClassBody classBody) {
		MethodCode code = classBody.method("__init")
			.parameter("context",TinyAsmBuilderContext.class)
			.parameter("name",String.class).begin();

		code.LINE(23);
		code.LOAD("this");
		code.LOAD("context");
		code.PUTFIELD("_context", TinyAsmBuilderContext.class);

		code.LINE(24);
		code.LOAD("this");
		code.LOAD("context");
		code.GETFIELD("code", MethodCode.class);
		code.PUTFIELD("_code", MethodCode.class);

		code.LINE(25);
		code.LOAD("this");
		code.LOAD("name");
		code.PUTFIELD("_referName", String.class);

		code.LINE(26);
		code.RETURN();

		code.END();
	}

	protected void _getAgeInt(ClassBody classBody) {
		MethodCode code = classBody.method(int.class, "getAgeInt").begin();

		code.LINE(62);
		code.LOAD("this");
		code.GETFIELD("_code", MethodCode.class);
		code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

		code.LINE(63);
		code.LOAD("this");
		code.GETFIELD("_code", MethodCode.class);
		code.LOAD("this");
		code.GETFIELD("_referName", String.class);
		code.STATIC(TinyAsmBuilder.class, "resolve")
			.parameter(MethodCode.class)
			.parameter(String.class).INVOKE();

		code.LINE(64);
		code.LOAD("this");
		code.GETFIELD("_code", MethodCode.class);
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
		code.LOADConst("getAgeInt");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.reTurn(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.GETSTATIC(Integer.class, "TYPE", Class.class);
		code.INTERFACE(MethodCaller.class, "reTurn")
			.reTurn(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE(65);
		code.LOAD("this");
		code.GETFIELD("_code", MethodCode.class);
		code.GETSTATIC(Integer.class, "TYPE", Class.class);
		code.STATIC(TinyAsmBuilder.class, "storeTopAndRefer")
			.reTurn(Object.class)
			.parameter(MethodCode.class)
			.parameter(Class.class).INVOKE();
		code.CHECKCAST(Integer.class);
		code.VIRTUAL(Integer.class, "intValue")
			.reTurn(int.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _setAgeInt(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeInt")
			.parameter("value",int.class).begin();

		code.LINE(194);
		code.LOAD("this");
		code.GETFIELD("_code", MethodCode.class);
		code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

		code.LINE(195);
		code.LOAD("this");
		code.GETFIELD("_code", MethodCode.class);
		code.LOAD("this");
		code.GETFIELD("_referName", String.class);
		code.STATIC(TinyAsmBuilder.class, "resolve")
			.parameter(MethodCode.class)
			.parameter(String.class).INVOKE();

		code.LINE(196);
		code.LOAD("this");
		code.GETFIELD("_code", MethodCode.class);
		code.LOAD("value");
		code.STATIC(TinyAsmBuilder.class, "resolve")
			.parameter(MethodCode.class)
			.parameter(int.class).INVOKE();

		code.LINE(197);
		code.LOAD("this");
		code.GETFIELD("_code", MethodCode.class);
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
		code.LOADConst("setAgeInt");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.reTurn(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.GETSTATIC(Integer.class, "TYPE", Class.class);
		code.INTERFACE(MethodCaller.class, "parameter")
			.reTurn(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE(198);
		code.RETURN();

		code.END();
	}

}
