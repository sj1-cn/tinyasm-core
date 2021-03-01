package cc1sj.tinyasm.heroadv;

import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.ClassHeader;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.MethodCaller;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.MethodHeader;
import cc1sj.tinyasm.hero.helperclass.HelloClass;

public class HelloClassTinyAsmProxyTinyAsmBuilder {
	ClassBody classBody;

	public static byte[] dump() throws Exception {
		return new HelloClassTinyAsmProxyTinyAsmBuilder().dump("cc1sj.tinyasm.heroadv.HelloClassTinyAsmProxy");
	}

	Type targetType;

	public byte[] dump(String proxyClassName) throws Exception {
		targetType = Clazz.of(HelloClass.class).getType();
		ClassHeader ch = ClassBuilder.make(proxyClassName);
		ch.eXtend(Clazz.of(targetType));
		ch.implement(AdvRuntimeReferNameObject.class);
		ch.access(ACC_PUBLIC | ACC_SUPER);
		classBody = ch.body();
		classBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, MethodHandles.class.getName(), "Lookup");

		classBody.field("_magicNumber", Clazz.of(byte.class));
		classBody.field("_context", Clazz.of(ThreadLocal.class, Clazz.of(AdvContext.class)));
		__init_(classBody);
		_get__MagicNumber(classBody);
		_set__MagicNumber(classBody);
		_set__Context(classBody);
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
		code.GETFIELD_OF_THIS("_magicNumber");
		code.RETURNTop();

		code.END();
	}

	protected void _set__MagicNumber(ClassBody classBody) {
		MethodCode code = classBody.method("set__MagicNumber").parameter("_magicNumber", byte.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("_magicNumber");
		code.PUTFIELD_OF_THIS("_magicNumber");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _set__Context(ClassBody classBody) {
		MethodCode code = classBody.method("set__Context").parameter("context", Clazz.of(ThreadLocal.class, Clazz.of(AdvContext.class)))
				.parameter("_magicNumber", byte.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("context");
		code.PUTFIELD_OF_THIS("_context");

		code.LINE();
		code.LOAD("this");
		code.LOAD("_magicNumber");
		code.PUTFIELD_OF_THIS("_magicNumber");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getAgeInt(ClassBody classBody) {
		MethodCode code = classBody.method(int.class, "getAgeInt").begin();

		code_getContext(code);

		code_resolve_this("objEval", code);

		code.LINE();
		code.LOAD("context");
		code.LOAD("objEval");

//		ConsumerWithException<MethodCode>
		String objClass = "cc1sj/tinyasm/heroadv/HelloClassTinyAsmProxy";
		String dontKnowByNowMethodDesriptor = Type.getMethodDescriptor(Type.getType(ConsumerWithException.class),
				Type.getType(ConsumerWithException.class));
		String lambdaRealMethodDesriptor = Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(ConsumerWithException.class),
				Type.getType(MethodCode.class));// "(Lcc1sj/tinyasm/heroadv/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V";

		String lambdaName = push(1, c -> {
			c.LINE();
			c.LOAD("c");
			c.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClassChild;"));
			c.LOADConst("getAgeInt");
			c.VIRTUAL(MethodCode.class, "VIRTUAL").reTurn(MethodCaller.class).parameter(Class.class).parameter(String.class).INVOKE();
			c.GETSTATIC(Integer.class, "TYPE", Class.class);
			c.INTERFACE(MethodCaller.class, "reTurn").reTurn(MethodCaller.class).parameter(Class.class).INVOKE();
			c.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();
		});

		dynamicInvokeLambda(code, objClass, lambdaName, dontKnowByNowMethodDesriptor, lambdaRealMethodDesriptor);
		code.stackPop();

		code.stackPush(Type.getType(ConsumerWithException.class));

		code.VIRTUAL(AdvContext.class, "push").reTurn(byte.class).parameter(ConsumerWithException.class).INVOKE();
		code.STORE("codeIndex", int.class);

		code.LINE();
		code.LOADConst(80);
		code.LOAD("codeIndex");
		code.ADD();
		code.RETURNTop();

		code.END();
	}

	protected void _setAgeInt(ClassBody classBody) {
		Type targetType = Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClassChild;");
		Class<Integer> paramClass = int.class;
		String methodName = "setAgeInt";
		String paramName = "value";
		String objClass = "cc1sj/tinyasm/heroadv/HelloClassTinyAsmProxy";

		int paramSize = 1;

		// Return Type
		Type returnType = Type.VOID_TYPE;
		Clazz returnClazz = Clazz.of(returnType);
		// ParamType
		Type[] methodParamTypes = new Type[] { Type.getType(int.class) };

		MethodHeader mh = classBody.method(returnClazz, methodName);
//			mh.access(access);
		for (int i = 0; i < methodParamTypes.length; i++) {
			mh.parameter("param" + i, Clazz.of(methodParamTypes[i]));
		}
//			if (exceptions != null) for (String e : exceptions) mh.tHrow(Clazz.of(Type.getObjectType(e)));

		MethodCode code = mh.begin();

		code_getContext(code);

		// resolve this
		code_resolve_this("objEval", code);
		// resolve parameters
		for (int i = 0; i < methodParamTypes.length; i++) {
			code_resolve("eval_param" + i, code, "param" + i, methodParamTypes[i]);
		}

		// LOAD All Parameter
		code.LINE();
		code.LOAD("context");
		code.LOAD("objEval");
		for (int i = 0; i < methodParamTypes.length; i++) {
			code.LOAD("eval_param" + i);
		}

		// invoke method
		String lambdaName = push(1 + methodParamTypes.length, c -> {
			c.LINE();
			c.LOAD("c");
			c.LOADConst(targetType);
			c.LOADConst(methodName);
			c.VIRTUAL(MethodCode.class, "VIRTUAL").reTurn(MethodCaller.class).parameter(Class.class).parameter(String.class).INVOKE();

			for (Type type : methodParamTypes) {
				_type(c, Clazz.of(type));
				c.INTERFACE(MethodCaller.class, "parameter").reTurn(MethodCaller.class).parameter(Class.class).INVOKE();
			}

			if (returnType != Type.VOID_TYPE) {
				_type(c, returnClazz);
				c.INTERFACE(MethodCaller.class, "reTurn").reTurn(MethodCaller.class).parameter(Class.class).INVOKE();
			}

			c.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();
		});

		dynamicInvoke(code, methodParamTypes.length, objClass, lambdaName);

		code.stackPush(Type.getType(ConsumerWithException.class));

		code.VIRTUAL(AdvContext.class, "push").reTurn(byte.class).parameter(ConsumerWithException.class).INVOKE();

		// Refer
		if (returnType != Type.VOID_TYPE) {
			code.STORE("codeIndex", int.class);

			code.LINE();
			code.LOADConst(80);
			code.LOAD("codeIndex");
			code.ADD();
			code.RETURNTop();
		} else {
			code.POP();

			code.LINE();
			code.LOAD("context");
			code.VIRTUAL(AdvContext.class, "execAndPop").INVOKE();

			code.LINE();
			code.RETURN();
		}

		code.END();
	}

	/********************************************************************************************************************************************
	 * 
	 * 
	 * 共同部分代码，简化主函数逻辑
	 * 
	 * 
	 * 
	 ********************************************************************************************************************************************/

	static Map<Type, Type> primativeToBoxedClazzMaps = asMap(
			new Type[] { Type.BOOLEAN_TYPE/* Boolean.class */, Type.BYTE_TYPE/* Byte.class */, Type.CHAR_TYPE/* Character.class */,
					Type.SHORT_TYPE/* Short.class */, Type.INT_TYPE/* Integer.class */, Type.LONG_TYPE/* Long.class */,
					Type.FLOAT_TYPE/* Float.class */, Type.DOUBLE_TYPE/* Double.class */
			},
			new Type[] { /* boolean.class */Type.getType(Boolean.class), /* byte.class */Type.getType(Byte.class),
					/* char.class */Type.getType(Character.class), /* short.class */Type.getType(Short.class),
					/* int.class */Type.getType(Integer.class), /* long.class */Type.getType(Long.class),
					/* float.class */Type.getType(Float.class), /* double.class */Type.getType(Double.class) });
	static Map<Type, String> primativeToValueMaps = asMap(new Type[] { Type.BOOLEAN_TYPE/* Boolean.class */, Type.BYTE_TYPE/* Byte.class */,
			Type.CHAR_TYPE/* Character.class */, Type.SHORT_TYPE/* Short.class */, Type.INT_TYPE/* Integer.class */,
			Type.LONG_TYPE/* Long.class */, Type.FLOAT_TYPE/* Float.class */, Type.DOUBLE_TYPE/* Double.class */
	}, new String[] { /* boolean.class" */"booleanValue", /* byte.class */ "byteValue", /* char.class */ "charValue",
			/* short.class */ "shortValue", /* int.class */ "intValue", /* long.class */ "longValue", /* float.class */ "floatValue",
			/* double.class */ "doubleValue"

	});

	static <K, V> Map<K, V> asMap(K[] keys, V[] values) {
		Map<K, V> maps = new HashMap<>();
		for (int i = 0; i < keys.length; i++) {
			maps.put(keys[i], values[i]);
		}
		return maps;
	}

	static void _cast(Clazz returnType, MethodCode code) {
		Clazz returnClazz = Clazz.of(returnType);
		final boolean returnValueNeedBoxing = primativeToBoxedClazzMaps.containsKey(returnType.getType());
		Type returnValueboxedClazz = returnValueNeedBoxing ? primativeToBoxedClazzMaps.get(returnType.getType()) : null;
		String returnValueUnboxValueMethodName = returnValueNeedBoxing ? primativeToValueMaps.get(returnType.getType()) : null;
		if (returnValueNeedBoxing) {
			code.CHECKCAST(returnValueboxedClazz);
			code.VIRTUAL(Clazz.of(returnValueboxedClazz), returnValueUnboxValueMethodName).reTurn(returnClazz).INVOKE();
		} else {
			code.CHECKCAST(returnClazz);
		}
	}

	static void _type(MethodCode code, Clazz returnClass) {
		final boolean returnValueNeedBoxing = primativeToBoxedClazzMaps.containsKey(returnClass.getType());
		Type returnValueboxedClazz = returnValueNeedBoxing ? primativeToBoxedClazzMaps.get(returnClass.getType()) : null;
		if (returnValueNeedBoxing) code.GETSTATIC(returnValueboxedClazz, "TYPE", Type.getType(Class.class));
		else code.LOADConst(returnClass.getType());
	}

	static Map<String, String> mps = asMap(
			new String[] { Boolean.class.getName(), Character.class.getName(), Byte.class.getName(), Short.class.getName(),
					Integer.class.getName(), Long.class.getName(), Float.class.getName(), Double.class.getName(), String.class.getName() },
			new String[] { Boolean.class.getName(), Character.class.getName(), Byte.class.getName(), Short.class.getName(),
					Integer.class.getName(), Long.class.getName(), Float.class.getName(), Double.class.getName(), String.class.getName() });

	protected void code_context_execAndPop(MethodCode code) {
		code.LINE();
		code.LOAD("context");
		code.VIRTUAL(AdvContext.class, "execAndPop").INVOKE();
	}

	protected Type[] codeTypes(int paramSize, Class<?>... classes) {
		Type[] typesLambda = new Type[paramSize + classes.length];
		for (int i = 0; i < paramSize; i++) {
			typesLambda[i] = Type.getType(ConsumerWithException.class);
		}
		for (int i = 0; i < classes.length; i++) {
			typesLambda[paramSize + i] = Type.getType(classes[i]);
		}
		return typesLambda;
	}

	protected void dynamicInvoke(MethodCode code, int paramSize, String objClass, String lambdaName) {
		String lambdaRealMethodDesriptor = Type.getMethodDescriptor(Type.VOID_TYPE,
				codeTypes(paramSize, ConsumerWithException.class, MethodCode.class));

		String dontKnowByNowMethodDesriptor = Type.getMethodDescriptor(Type.getType(ConsumerWithException.class),
				codeTypes(paramSize, ConsumerWithException.class));
		dynamicInvokeLambda(code, objClass, lambdaName, dontKnowByNowMethodDesriptor, lambdaRealMethodDesriptor);

		code.stackPop();
		for (int i = 0; i < paramSize; i++) {
			code.stackPop();
		}
	}

	protected void code_getContext(MethodCode code) {
		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_context");
		code.VIRTUAL(ThreadLocal.class, "get").reTurn(Object.class).INVOKE();
		code.CHECKCAST(AdvContext.class);
		code.STORE("context", AdvContext.class);
	}

	protected void code_resolve_this(String thisBlockName, MethodCode code) {
		code.LINE();
		code.LOAD("context");
		code.LOAD("this");
		code.VIRTUAL(AdvContext.class, "resolve").reTurn(ConsumerWithException.class).parameter(Object.class).INVOKE();
		code.STORE(thisBlockName, Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));
	}

	protected void code_resolve(String codeBlockName, MethodCode code, String paramName, Type paramClass) {
		code.LINE();
		code.LOAD("context");
		code.LOAD(paramName);
		code.VIRTUAL(AdvContext.class, "resolve").reTurn(ConsumerWithException.class).parameter(Clazz.of(paramClass)).INVOKE();
		code.STORE(codeBlockName, Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));
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

	List<LambdaBuilder> lambdas = new ArrayList<>();

	public String push(int params, Consumer<MethodCode> lambdaInvokeSuperMethod) {
		String name = "lambda$" + this.lambdas.size();
		lambdas.add(new LambdaBuilder(name, params, lambdaInvokeSuperMethod));
		return name;
	}

	class LambdaBuilder {
		String name;// "lambda$0""lambda$0",
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
				code_param_eval_accept("var" + i, "c", code);
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

	protected void code_param_eval_accept(String var1, String c, MethodCode code) {
		code.LINE();
		code.LOAD(var1);
		code.LOAD(c);
		code.INTERFACE(ConsumerWithException.class, "accept").parameter(Object.class).INVOKE();
	}

}
