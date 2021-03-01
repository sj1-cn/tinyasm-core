package cc1sj.tinyasm.heroadv;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.MethodHeader;

import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.heroadv.AdvRuntimeReferNameObject;
import java.lang.ThreadLocal;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
public class HelloClassTinyAsmProxyTinyAsmBuilder implements TinyAsmProxyBase {

	public static byte[] dump() throws Exception {
		return new HelloClassTinyAsmProxyTinyAsmBuilder().dump("cc1sj.tinyasm.heroadv.HelloClassTinyAsmProxy");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className, HelloClass.class, AdvRuntimeReferNameObject.class).access(ACC_PUBLIC | ACC_SUPER)
				.body();
		classBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, MethodHandles.class.getName(), "Lookup");
//		classBody.visitInnerClass("java/lang/invoke/MethodHandles$Lookup", "java/lang/invoke/MethodHandles", "Lookup",
//				ACC_PUBLIC | ACC_FINAL | ACC_STATIC);

		classBody.field("magicNumber", Clazz.of(byte.class));
		classBody.field("_context", Clazz.of(ThreadLocal.class, Clazz.of(AdvContext.class)));
		__init_(classBody);
		_get__MagicNumber(classBody);
		_set__MagicNumber(classBody);
		___init(classBody);
		_getAgeInt(classBody);
		_setAgeInt(classBody);

		for (LambdaBuilder lambdaBuilder : lambdas) {
			lambdaBuilder.exec(classBody);
		}

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

//		ConsumerWithException<MethodCode>
		String objClass = "cc1sj/tinyasm/heroadv/HelloClassTinyAsmProxy";
		String lambdaName = "lambda$0";
		String dontKnowByNowMethodDesriptor = Type.getMethodDescriptor(Type.getType(ConsumerWithException.class),
				Type.getType(ConsumerWithException.class));
		String lambdaRealMethodDesriptor = Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(ConsumerWithException.class),
				Type.getType(MethodCode.class));// "(Lcc1sj/tinyasm/heroadv/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V";
		code.stackPop();

		dynamicInvokeLambda(code, objClass, lambdaName, dontKnowByNowMethodDesriptor, lambdaRealMethodDesriptor);

		push("lambda$0", 1, c -> {
			c.LINE();
			c.LOAD("c");
			c.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClassChild;"));
			c.LOADConst("getAgeInt");
			c.VIRTUAL(MethodCode.class, "VIRTUAL").reTurn(MethodCaller.class).parameter(Class.class).parameter(String.class).INVOKE();
			c.GETSTATIC(Integer.class, "TYPE", Class.class);
			c.INTERFACE(MethodCaller.class, "reTurn").reTurn(MethodCaller.class).parameter(Class.class).INVOKE();
			c.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();
		});

		code.stackPush(Type.getType(ConsumerWithException.class));

		code.VIRTUAL(AdvContext.class, "push").reTurn(byte.class).parameter(ConsumerWithException.class).INVOKE();
		code.ADD();

		code.RETURNTop();

		code.END();
	}

	protected void dynamicInvokeLambda(MethodCode code, String objClass, String lambdaName, String dontKnowByNowMethodDesriptor,
			String lambdaRealMethodDesriptor) {

		Type lambdaDefinedMethodDescriptor = Type.getType(Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(MethodCode.class)));
		code.visitInvokeDynamicInsn("accept", dontKnowByNowMethodDesriptor, new Handle(Opcodes.H_INVOKESTATIC,
				"java/lang/invoke/LambdaMetafactory", "metafactory",
				"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
				false),
				new Object[] { Type.getType("(Ljava/lang/Object;)V"),
						new Handle(Opcodes.H_INVOKESTATIC, objClass, lambdaName, lambdaRealMethodDesriptor, false),
						lambdaDefinedMethodDescriptor });
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

		String objClass = "cc1sj/tinyasm/heroadv/HelloClassTinyAsmProxy";
		String lambdaName = "lambda$1";
		String lambdaRealMethodDesriptor = Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(ConsumerWithException.class),
				Type.getType(ConsumerWithException.class), Type.getType(MethodCode.class));// "(Lcc1sj/tinyasm/heroadv/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V";

		String dontKnowByNowMethodDesriptor = Type.getMethodDescriptor(Type.getType(ConsumerWithException.class),
				Type.getType(ConsumerWithException.class), Type.getType(ConsumerWithException.class));

		code.stackPop();
		code.stackPop();

		dynamicInvokeLambda(code, objClass, lambdaName, dontKnowByNowMethodDesriptor, lambdaRealMethodDesriptor);

		push("lambda$1", 2, c -> {
			c.LINE();
			c.LOAD("c");
			c.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClassChild;"));
			c.LOADConst("setAgeInt");
			c.VIRTUAL(MethodCode.class, "VIRTUAL").reTurn(MethodCaller.class).parameter(Class.class).parameter(String.class).INVOKE();
			c.GETSTATIC(Integer.class, "TYPE", Class.class);
			c.INTERFACE(MethodCaller.class, "parameter").reTurn(MethodCaller.class).parameter(Class.class).INVOKE();
			c.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();
		});

//		code.visitInvokeDynamicInsn("accept",
//				"(Lcc1sj/tinyasm/heroadv/ConsumerWithException;Lcc1sj/tinyasm/heroadv/ConsumerWithException;)Lcc1sj/tinyasm/heroadv/ConsumerWithException;",
//				new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory",
//						"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
//						false),
//				new Object[] { Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC,
//						"cc1sj/tinyasm/heroadv/HelloClassTinyAsmProxy", "lambda$1",
//						"(Lcc1sj/tinyasm/heroadv/ConsumerWithException;Lcc1sj/tinyasm/heroadv/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V",
//						false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V") });
//
//		code.stackPop();
//		code.stackPop();
		code.stackPush(Type.getType(ConsumerWithException.class));

		code.VIRTUAL(AdvContext.class, "push").reTurn(byte.class).parameter(ConsumerWithException.class).INVOKE();
		code.POP();

		code.LINE();
		code.LOAD("context");
		code.VIRTUAL(AdvContext.class, "execAndPop").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	List<LambdaBuilder> lambdas = new ArrayList<>();

	public void push(String name, int params, Consumer<MethodCode> lambdaInvokeSuperMethod) {
		lambdas.add(new LambdaBuilder(name, params, lambdaInvokeSuperMethod));
	}

	class LambdaBuilder {
		String name;// "lambda$0"
		int params;
		Consumer<MethodCode> lambdaInvokeSuperMethod;

		public void exec(ClassBody classBody) {

			MethodHeader methodHeader = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, name).tHrow(Exception.class);
			for (int i = 0; i < params; i++) {
				methodHeader.parameter("var" + i, ConsumerWithException.class);
			}
			methodHeader.parameter("c", MethodCode.class);
			MethodCode code = methodHeader.begin();

			for (int i = 0; i < params; i++) {
				evalAccept("var" + i, "c", code);
			}

			lambdaInvokeSuperMethod.accept(code);

			code.LINE();
			code.RETURN();
			code.END();
		}

		public LambdaBuilder(String name, int params, Consumer<MethodCode> lambdaInvokeSuperMethod) {
			super();
			this.name = name;
			this.params = params;
			this.lambdaInvokeSuperMethod = lambdaInvokeSuperMethod;
		}
	}

	protected void _lambda$0(ClassBody classBody) {

	}

	protected void _lambda$1(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$1").tHrow(Exception.class)
				.parameter("var0", ConsumerWithException.class).parameter("var1", ConsumerWithException.class)
				.parameter("c", MethodCode.class).begin();

		evalAccept("var0", "c", code);

		evalAccept("var1", "c", code);

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

	protected void evalAccept(String var1, String c, MethodCode code) {
		code.LINE();
		code.LOAD(var1);
		code.LOAD(c);
		code.INTERFACE(ConsumerWithException.class, "accept").parameter(Object.class).INVOKE();
	}

}
