package cc1sj.tinyasm.heroadv;

import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.heroadv.AdvRuntimeReferNameObject;
import java.lang.ThreadLocal;
import cc1sj.tinyasm.heroadv.AdvContext;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.MethodCaller;
import cc1sj.tinyasm.hero.helperclass.HelloClass;
import java.lang.Object;
import java.lang.Class;
import java.lang.String;
import java.lang.Integer;
import cc1sj.tinyasm.heroadv.ConsumerWithException;
import java.lang.Exception;

@SuppressWarnings("unused")
public class HelloClassTinyAsmProxyTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new HelloClassTinyAsmProxyTinyAsmDump().dump("cc1sj.tinyasm.heroadv.HelloClassTinyAsmProxy");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className, HelloClass.class, AdvRuntimeReferNameObject.class).access(ACC_PUBLIC | ACC_SUPER)
				.body();

		classBody.field("magicNumber", Clazz.of(byte.class));
		classBody.field("_context", Clazz.of(ThreadLocal.class, Clazz.of(AdvContext.class)));
		__init_(classBody);
		_get__MagicNumber(classBody);
		_set__MagicNumber(classBody);
		___init(classBody);
		_getAgeInt(classBody);
		_setAgeInt(classBody);
		_lambda$0(classBody);
		_lambda$1(classBody);

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

	protected void _get__MagicNumber(ClassBody classBody) {
		MethodCode code = classBody.method(byte.class, "get__MagicNumber").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("magicNumber");
		code.RETURNTop();

		code.END();
	}

	protected void _set__MagicNumber(ClassBody classBody) {
		MethodCode code = classBody.method("set__MagicNumber").parameter("magicNumber", byte.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("magicNumber");
		code.PUTFIELD_OF_THIS("magicNumber");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void ___init(ClassBody classBody) {
		MethodCode code = classBody.method("__init").parameter("context", Clazz.of(ThreadLocal.class, Clazz.of(AdvContext.class)))
				.parameter("magicNumber", byte.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("context");
		code.PUTFIELD_OF_THIS("_context");

		code.LINE();
		code.LOAD("this");
		code.LOAD("magicNumber");
		code.PUTFIELD_OF_THIS("magicNumber");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getAgeInt(ClassBody classBody) {
		MethodCode code = classBody.method(int.class, "getAgeInt").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_context");
		code.VIRTUAL(ThreadLocal.class, "get").reTurn(Object.class).INVOKE();
		code.CHECKCAST(AdvContext.class);
		code.STORE("context", AdvContext.class);

		code.LINE();
		code.LOAD("context");
		code.LOAD("this");
		code.VIRTUAL(AdvContext.class, "resolve").reTurn(ConsumerWithException.class).parameter(Object.class).INVOKE();
		code.STORE("objEval", Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));

		code.LINE();
		code.LOADConst(80);
		code.LOAD("context");
		code.LOAD("objEval");
		code.visitInvokeDynamicInsn("accept",
				"(Lcc1sj/tinyasm/heroadv/ConsumerWithException;)Lcc1sj/tinyasm/heroadv/ConsumerWithException;",
				new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory",
						"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
						false),
				new Object[] { Type.getType("(Ljava/lang/Object;)V"),
						new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/heroadv/HelloClassTinyAsmProxy", "lambda$0",
								"(Lcc1sj/tinyasm/heroadv/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false),
						Type.getType("(Lcc1sj/tinyasm/MethodCode;)V") });
		code.VIRTUAL(AdvContext.class, "push").reTurn(byte.class).parameter(ConsumerWithException.class).INVOKE();
		code.ADD();
		code.RETURNTop();

		code.END();
	}

	protected void _setAgeInt(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeInt").parameter("value", int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_context");
		code.VIRTUAL(ThreadLocal.class, "get").reTurn(Object.class).INVOKE();
		code.CHECKCAST(AdvContext.class);
		code.STORE("context", AdvContext.class);

		code.LINE();
		code.LOAD("context");
		code.LOAD("this");
		code.VIRTUAL(AdvContext.class, "resolve").reTurn(ConsumerWithException.class).parameter(Object.class).INVOKE();
		code.STORE("objEval", Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));

		code.LINE();
		code.LOAD("context");
		code.LOAD("value");
		code.VIRTUAL(AdvContext.class, "resolve").reTurn(ConsumerWithException.class).parameter(int.class).INVOKE();
		code.STORE("objValue", Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));

		code.LINE();
		code.LOAD("context");
		code.LOAD("objEval");
		code.LOAD("objValue");
		code.visitInvokeDynamicInsn("accept",
				"(Lcc1sj/tinyasm/heroadv/ConsumerWithException;Lcc1sj/tinyasm/heroadv/ConsumerWithException;)Lcc1sj/tinyasm/heroadv/ConsumerWithException;",
				new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory",
						"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
						false),
				new Object[] { Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC,
						"cc1sj/tinyasm/heroadv/HelloClassTinyAsmProxy", "lambda$1",
						"(Lcc1sj/tinyasm/heroadv/ConsumerWithException;Lcc1sj/tinyasm/heroadv/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V",
						false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V") });
		code.VIRTUAL(AdvContext.class, "push").reTurn(byte.class).parameter(ConsumerWithException.class).INVOKE();
		code.POP();

		code.LINE();
		code.LOAD("context");
		code.VIRTUAL(AdvContext.class, "execAndPop").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$0(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$0").tHrow(Exception.class)
				.parameter("var0", ConsumerWithException.class).parameter("c", MethodCode.class).begin();

		code.LINE();
		code.LOAD("var0");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept").parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClassChild;"));
		code.LOADConst("getAgeInt");
		code.VIRTUAL(MethodCode.class, "VIRTUAL").reTurn(MethodCaller.class).parameter(Class.class).parameter(String.class).INVOKE();
		code.GETSTATIC(Integer.class, "TYPE", Class.class);
		code.INTERFACE(MethodCaller.class, "reTurn").reTurn(MethodCaller.class).parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$1(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$1").tHrow(Exception.class)
				.parameter("var0", ConsumerWithException.class).parameter("var1", ConsumerWithException.class)
				.parameter("c", MethodCode.class).begin();

		code.LINE();
		code.LOAD("var0");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept").parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("var1");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept").parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClassChild;"));
		code.LOADConst("setAgeInt");
		code.VIRTUAL(MethodCode.class, "VIRTUAL").reTurn(MethodCaller.class).parameter(Class.class).parameter(String.class).INVOKE();
		code.GETSTATIC(Integer.class, "TYPE", Class.class);
		code.INTERFACE(MethodCaller.class, "parameter").reTurn(MethodCaller.class).parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
