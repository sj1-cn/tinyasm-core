package cc1sj.tinyasm;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.MethodCaller;
import cc1sj.tinyasm.hero.helperclass.HelloClass;
import cc1sj.tinyasm.tinyasmproxy.TinyAsmBuilder;
import cc1sj.tinyasm.tinyasmproxy.TinyAsmBuilderContext;
import cc1sj.tinyasm.tinyasmproxy.TinyAsmProxyRuntimeReferNameObject;

import java.lang.Class;
import java.lang.Object;
import java.lang.String;
import java.lang.Integer;
@SuppressWarnings("unused")
public class HelloClassTinyAsmProxyTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new HelloClassTinyAsmProxyTinyAsmDump().dump("cc1sj.tinyasm.HelloClassTinyAsmProxy");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className, HelloClass.class, TinyAsmProxyRuntimeReferNameObject.class)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.field("_referName", Clazz.of(String.class));
		classBody.field("_contextThreadLocal", Clazz.of(TinyAsmBuilderContext.class));
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

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloClass.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _get__ReferName(ClassBody classBody) {
		MethodCode code = classBody.method(String.class, "get__ReferName").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_referName");
		code.RETURNTop();

		code.END();
	}

	protected void ___init(ClassBody classBody) {
		MethodCode code = classBody.method("__init")
			.parameter("context",TinyAsmBuilderContext.class)
			.parameter("name",String.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("context");
		code.PUTFIELD_OF_THIS("_contextThreadLocal");

		code.LINE();
		code.LOAD("this");
		code.LOAD("context");
		code.GETFIELD("code", MethodCode.class);
		code.PUTFIELD_OF_THIS("_code");

		code.LINE();
		code.LOAD("this");
		code.LOAD("name");
		code.PUTFIELD_OF_THIS("_referName");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getAgeInt(ClassBody classBody) {
		MethodCode code = classBody.method(int.class, "getAgeInt").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_code");
		code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_code");
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_referName");
		code.STATIC(TinyAsmBuilder.class, "resolve")
			.parameter(MethodCode.class)
			.parameter(String.class).INVOKE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_code");
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

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_code");
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

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_code");
		code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_code");
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_referName");
		code.STATIC(TinyAsmBuilder.class, "resolve")
			.parameter(MethodCode.class)
			.parameter(String.class).INVOKE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_code");
		code.LOAD("value");
		code.STATIC(TinyAsmBuilder.class, "resolve")
			.parameter(MethodCode.class)
			.parameter(int.class).INVOKE();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_code");
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

		code.LINE();
		code.RETURN();

		code.END();
	}

}
