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
import java.lang.ThreadLocal;
import java.lang.reflect.Array;
import cc1sj.tinyasm.AdvContext;
import java.lang.Exception;
import cc1sj.tinyasm.hero.helperclass.GenericMethodInterface;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.MethodCaller;
import cc1sj.tinyasm.AdvRuntimeReferNameObject;
import cc1sj.tinyasm.Adv;
import java.lang.Object;
import java.lang.Class;
import cc1sj.tinyasm.ConsumerWithException;
import java.lang.String;
import cc1sj.tinyasm.Clazz;
@SuppressWarnings("unused")
public class GenericMethodInterfaceSampleAdvAsmProxyTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new GenericMethodInterfaceSampleAdvAsmProxyTinyAsmDump().dump("cc1sj.tinyasm.hero.advasmproxy.GenericMethodInterfaceSampleAdvAsmProxy");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className, Object.class, GenericMethodInterface.class, AdvRuntimeReferNameObject.class)
			.access(ACC_PUBLIC | ACC_SUPER).body();

classBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, "java.lang.invoke.MethodHandles", "Lookup");

		classBody.field("_magicNumber", Clazz.of(byte.class));
		classBody.field("_contextThreadLocal",Clazz.of(ThreadLocal.class,Clazz.of(AdvContext.class)));
		__init_(classBody);
		_get__MagicNumber(classBody);
		_set__MagicNumber(classBody);
		_set__Context(classBody);
		_toArray(classBody);
		_lambda$0(classBody);

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

	protected void _get__MagicNumber(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(byte.class, "get__MagicNumber").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_magicNumber");
		code.RETURNTop();

		code.END();
	}

	protected void _set__MagicNumber(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("set__MagicNumber")
			.parameter("_magicNumber",byte.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("_magicNumber");
		code.PUTFIELD_OF_THIS("_magicNumber");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _set__Context(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("set__Context")
			.parameter("_contextThreadLocal",Clazz.of(ThreadLocal.class,Clazz.of(AdvContext.class)))
			.parameter("_magicNumber",byte.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("_contextThreadLocal");
		code.PUTFIELD_OF_THIS("_contextThreadLocal");

		code.LINE();
		code.LOAD("this");
		code.LOAD("_magicNumber");
		code.PUTFIELD_OF_THIS("_magicNumber");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _toArray(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(Clazz.typeVariableOf("T"), "toArray")
			.parameter("param0",Clazz.typeVariableOf("T")).begin();

		code.LINE();
		code.LOAD("param0");
		code.VIRTUAL(Object.class, "getClass")
			.reTurn(Class.class).INVOKE();
		code.VIRTUAL(Class.class, "getComponentType")
			.reTurn(Class.class).INVOKE();
		code.STORE("elementClass",Clazz.of(Class.class, Clazz.typeUnboundedVariable()));

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_contextThreadLocal");
		code.VIRTUAL(ThreadLocal.class, "get")
			.reTurn(Object.class).INVOKE();
		code.CHECKCAST(AdvContext.class);
		code.STORE("context",AdvContext.class);

		code.LINE();
		code.LOAD("context");
		code.LOAD("param0");
		code.VIRTUAL(AdvContext.class, "resolve")
			.reTurn(ConsumerWithException.class)
			.parameter(Object[].class).INVOKE();
		code.STORE("eval_param0",Clazz.of(ConsumerWithException.class,Clazz.of(MethodCode.class)));

		code.LINE();
		code.LOAD("context");
		code.LOAD("this");
		code.VIRTUAL(AdvContext.class, "resolve")
			.reTurn(ConsumerWithException.class)
			.parameter(Object.class).INVOKE();
		code.STORE("objEval",Clazz.of(ConsumerWithException.class,Clazz.of(MethodCode.class)));

		code.LINE();
		code.LOAD("context");
		code.LOADConst(Type.getType("[Ljava/lang/Object;"));
		code.LOAD("objEval");
		code.LOAD("eval_param0");
		code.LOAD("elementClass");
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;Ljava/lang/Class;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/GenericMethodInterfaceSampleAdvAsmProxy", "lambda$0", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;Ljava/lang/Class;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "push")
			.reTurn(byte.class)
			.parameter(Class.class)
			.parameter(ConsumerWithException.class).INVOKE();
		code.STORE("codeIndex",byte.class);

		code.LINE();
		code.LOADConst(80);
		code.LOAD("codeIndex");
		code.ADD();
		code.CONVERTTO(byte.class);
		code.STORE("magicNumber",byte.class);

		code.LINE();
		code.LOADConstNULL();
		code.STORE("simplePojoClassSample",Clazz.typeVariableOf("T"));

		code.LINE();
		code.LOAD("elementClass");
		code.LOADConst(1);
		code.STATIC(Array.class, "newInstance")
			.reTurn(Object.class)
			.parameter(Class.class)
			.parameter(int.class).INVOKE();
		code.CHECKCAST(Object[].class);
		code.STORE("tarray",Object[].class);

		code.LINE();
		code.LOAD("elementClass");
		code.STATIC(Adv.class, "canProxy")
			.reTurn(boolean.class)
			.parameter(Class.class).INVOKE();
		Label label9OfIFEQ = new Label();
		code.IFEQ(label9OfIFEQ);

		code.LINE();
		code.LOAD("elementClass");
		code.LOAD("magicNumber");
		code.STATIC(Adv.class, "buildProxyClass")
			.reTurn(Object.class)
			.parameter(Class.class)
			.parameter(byte.class).INVOKE();
		code.STORE("simplePojoClassSample");

		code.LINE();
		code.LOAD("tarray");
		code.LOADConst(0);
		code.LOAD("simplePojoClassSample");
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("tarray");
		code.RETURNTop();

		code.visitLabel(label9OfIFEQ);

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _lambda$0(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$0")
			.tHrow(Exception.class )
			.parameter("var0",ConsumerWithException.class)
			.parameter("var1",ConsumerWithException.class)
			.parameter("var2",Class.class)
			.parameter("c",MethodCode.class).begin();

		code.LINE();
		code.LOAD("var0");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("var1");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/GenericMethodInterface;"));
		code.LOADConst("toArray");
		code.VIRTUAL(MethodCode.class, "INTERFACE")
			.reTurn(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("[Ljava/lang/Object;"));
		code.INTERFACE(MethodCaller.class, "parameter")
			.reTurn(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.LOADConst(Type.getType("[Ljava/lang/Object;"));
		code.INTERFACE(MethodCaller.class, "reTurn")
			.reTurn(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOAD("var2");
		code.LOADConst(1);
		code.STATIC(Clazz.class, "of")
			.reTurn(Clazz.class)
			.parameter(Class.class)
			.parameter(boolean.class).INVOKE();
		code.VIRTUAL(MethodCode.class, "CHECKCAST")
			.parameter(Clazz.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
