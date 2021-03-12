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
import cc1sj.tinyasm.hero.helperclass.PojoClassSample;
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
@SuppressWarnings("unused")
public class GenericMethodInterfaceSampleAdvAsmProxyTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new GenericMethodInterfaceSampleAdvAsmProxyTinyAsmDump().dump("cc1sj.tinyasm.hero.advasmproxy.GenericMethodInterfaceSampleAdvAsmProxy");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className, Clazz.of(Object.class),Clazz.of(GenericMethodInterface.class,Clazz.of(PojoClassSample.class)),Clazz.of(AdvRuntimeReferNameObject.class))
			.access(ACC_PUBLIC | ACC_SUPER).body();

classBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, "java.lang.invoke.MethodHandles", "Lookup");

		classBody.private_().field("_magicNumber", Clazz.of(byte.class));
		classBody.private_().field("_contextThreadLocal",Clazz.of(ThreadLocal.class,Clazz.of(AdvContext.class)));
		__init_(classBody);
		_get__MagicNumber(classBody);
		_set__MagicNumber(classBody);
		_set__Context(classBody);
		_arrayToArray(classBody);
		_arrayToObject(classBody);
		_objectToObject(classBody);
		_objectToArray(classBody);
		_lambda$objectToArray$3(classBody);
		_lambda$objectToObject$2(classBody);
		_lambda$arrayToObject$1(classBody);
		_lambda$arrayToArray$0(classBody);

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

	protected void _get__MagicNumber(ClassBody classBody) {
		MethodCode code = classBody.public_().method("get__MagicNumber")
			.return_(byte.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_magicNumber");
		code.RETURNTop();

		code.END();
	}

	protected void _set__MagicNumber(ClassBody classBody) {
		MethodCode code = classBody.public_().method("set__MagicNumber")
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
		MethodCode code = classBody.public_().method("set__Context")
			.return_(Clazz.of(void.class) )
			.parameter("_contextThreadLocal",Clazz.of(ThreadLocal.class,Clazz.of(AdvContext.class)))
			.parameter("_magicNumber",Clazz.of(byte.class)).begin();

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

	protected void _arrayToArray(ClassBody classBody) {
		MethodCode code = classBody.public_().method("arrayToArray")
			.return_(Clazz.typeVariableOf("T",true) )
			.formalTypeParameter("T",Clazz.of(Object.class) )
			.parameter("param0",Clazz.typeVariableOf("T",true)).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_contextThreadLocal");
		code.VIRTUAL(ThreadLocal.class, "get")
			.return_(Object.class).INVOKE();
		code.CHECKCAST(AdvContext.class);
		code.STORE("context",AdvContext.class);

		code.LINE();
		code.LOAD("context");
		code.LOAD("param0");
		code.VIRTUAL(AdvContext.class, "resolve")
			.return_(ConsumerWithException.class)
			.parameter(Object[].class).INVOKE();
		code.STORE("eval_param0",Clazz.of(ConsumerWithException.class,Clazz.of(MethodCode.class)));

		code.LINE();
		code.LOAD("context");
		code.LOAD("this");
		code.VIRTUAL(AdvContext.class, "resolve")
			.return_(ConsumerWithException.class)
			.parameter(Object.class).INVOKE();
		code.STORE("objEval",Clazz.of(ConsumerWithException.class,Clazz.of(MethodCode.class)));

		code.LINE();
		code.LOAD("context");
		code.LOADConst(Type.getType("[Ljava/lang/Object;"));
		code.LOAD("objEval");
		code.LOAD("eval_param0");
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/GenericMethodInterfaceSampleAdvAsmProxy", "lambda$arrayToArray$0", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "push")
			.return_(byte.class)
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
		code.LOAD("param0");
		code.VIRTUAL(Object.class, "getClass")
			.return_(Class.class).INVOKE();
		code.VIRTUAL(Class.class, "getComponentType")
			.return_(Class.class).INVOKE();
		code.STORE("targetClassT",Clazz.of(Class.class, Clazz.typeUnboundedTypeArgument()));

		code.LINE();
		code.LOAD("targetClassT");
		code.LOADConst(1);
		code.STATIC(Array.class, "newInstance")
			.return_(Object.class)
			.parameter(Class.class)
			.parameter(int.class).INVOKE();
		code.CHECKCAST(Object[].class);
		code.STORE("targetArray",Clazz.typeVariableOf("T",true));

		code.LINE();
		code.LOADConstNULL();
		code.STORE("targetElement",Clazz.typeVariableOf("T"));

		code.LINE();
		code.LOAD("targetClassT");
		code.STATIC(Adv.class, "canProxy")
			.return_(boolean.class)
			.parameter(Class.class).INVOKE();
		Label label9OfIFEQ = new Label();
		code.IFEQ(label9OfIFEQ);

		code.LINE();
		code.LOAD("targetClassT");
		code.LOAD("magicNumber");
		code.STATIC(Adv.class, "buildProxyClass")
			.return_(Object.class)
			.parameter(Class.class)
			.parameter(byte.class).INVOKE();
		code.STORE("targetElement");

		code.LINE();
		code.LOAD("targetArray");
		code.LOADConst(0);
		code.LOAD("targetElement");
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("targetArray");
		code.RETURNTop();

		code.visitLabel(label9OfIFEQ);

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _arrayToObject(ClassBody classBody) {
		MethodCode code = classBody.public_().method("arrayToObject")
			.return_(Clazz.typeVariableOf("T") )
			.formalTypeParameter("T",Clazz.of(Object.class) )
			.parameter("param0",Clazz.typeVariableOf("T",true)).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_contextThreadLocal");
		code.VIRTUAL(ThreadLocal.class, "get")
			.return_(Object.class).INVOKE();
		code.CHECKCAST(AdvContext.class);
		code.STORE("context",AdvContext.class);

		code.LINE();
		code.LOAD("context");
		code.LOAD("param0");
		code.VIRTUAL(AdvContext.class, "resolve")
			.return_(ConsumerWithException.class)
			.parameter(Object[].class).INVOKE();
		code.STORE("eval_param0",Clazz.of(ConsumerWithException.class,Clazz.of(MethodCode.class)));

		code.LINE();
		code.LOAD("context");
		code.LOAD("this");
		code.VIRTUAL(AdvContext.class, "resolve")
			.return_(ConsumerWithException.class)
			.parameter(Object.class).INVOKE();
		code.STORE("objEval",Clazz.of(ConsumerWithException.class,Clazz.of(MethodCode.class)));

		code.LINE();
		code.LOAD("context");
		code.LOADConst(Type.getType("Ljava/lang/Object;"));
		code.LOAD("objEval");
		code.LOAD("eval_param0");
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/GenericMethodInterfaceSampleAdvAsmProxy", "lambda$arrayToObject$1", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "push")
			.return_(byte.class)
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
		code.LOAD("param0");
		code.VIRTUAL(Object.class, "getClass")
			.return_(Class.class).INVOKE();
		code.VIRTUAL(Class.class, "getComponentType")
			.return_(Class.class).INVOKE();
		code.STORE("targetClassT",Clazz.of(Class.class, Clazz.typeUnboundedTypeArgument()));

		code.LINE();
		code.LOAD("targetClassT");
		code.STATIC(Adv.class, "canProxy")
			.return_(boolean.class)
			.parameter(Class.class).INVOKE();
		Label label7OfIFEQ = new Label();
		code.IFEQ(label7OfIFEQ);

		code.LINE();
		code.LOAD("targetClassT");
		code.LOAD("magicNumber");
		code.STATIC(Adv.class, "buildProxyClass")
			.return_(Object.class)
			.parameter(Class.class)
			.parameter(byte.class).INVOKE();
		code.RETURNTop();

		code.visitLabel(label7OfIFEQ);

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _objectToObject(ClassBody classBody) {
		MethodCode code = classBody.public_().method("objectToObject")
			.return_(Clazz.typeVariableOf("T") )
			.formalTypeParameter("T",Clazz.of(Object.class) )
			.parameter("param0",Clazz.typeVariableOf("T")).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_contextThreadLocal");
		code.VIRTUAL(ThreadLocal.class, "get")
			.return_(Object.class).INVOKE();
		code.CHECKCAST(AdvContext.class);
		code.STORE("context",AdvContext.class);

		code.LINE();
		code.LOAD("context");
		code.LOAD("param0");
		code.VIRTUAL(AdvContext.class, "resolve")
			.return_(ConsumerWithException.class)
			.parameter(Object.class).INVOKE();
		code.STORE("eval_param0",Clazz.of(ConsumerWithException.class,Clazz.of(MethodCode.class)));

		code.LINE();
		code.LOAD("context");
		code.LOAD("this");
		code.VIRTUAL(AdvContext.class, "resolve")
			.return_(ConsumerWithException.class)
			.parameter(Object.class).INVOKE();
		code.STORE("objEval",Clazz.of(ConsumerWithException.class,Clazz.of(MethodCode.class)));

		code.LINE();
		code.LOAD("context");
		code.LOADConst(Type.getType("Ljava/lang/Object;"));
		code.LOAD("objEval");
		code.LOAD("eval_param0");
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/GenericMethodInterfaceSampleAdvAsmProxy", "lambda$objectToObject$2", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "push")
			.return_(byte.class)
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
		code.LOAD("param0");
		code.VIRTUAL(Object.class, "getClass")
			.return_(Class.class).INVOKE();
		code.STORE("targetClassT",Clazz.of(Class.class, Clazz.typeUnboundedTypeArgument()));

		code.LINE();
		code.LOAD("targetClassT");
		code.STATIC(Adv.class, "canProxy")
			.return_(boolean.class)
			.parameter(Class.class).INVOKE();
		Label label7OfIFEQ = new Label();
		code.IFEQ(label7OfIFEQ);

		code.LINE();
		code.LOAD("targetClassT");
		code.LOAD("magicNumber");
		code.STATIC(Adv.class, "buildProxyClass")
			.return_(Object.class)
			.parameter(Class.class)
			.parameter(byte.class).INVOKE();
		code.RETURNTop();

		code.visitLabel(label7OfIFEQ);

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _objectToArray(ClassBody classBody) {
		MethodCode code = classBody.public_().method("objectToArray")
			.return_(Clazz.typeVariableOf("T",true) )
			.formalTypeParameter("T",Clazz.of(Object.class) )
			.parameter("param0",Clazz.typeVariableOf("T")).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_contextThreadLocal");
		code.VIRTUAL(ThreadLocal.class, "get")
			.return_(Object.class).INVOKE();
		code.CHECKCAST(AdvContext.class);
		code.STORE("context",AdvContext.class);

		code.LINE();
		code.LOAD("context");
		code.LOAD("param0");
		code.VIRTUAL(AdvContext.class, "resolve")
			.return_(ConsumerWithException.class)
			.parameter(Object.class).INVOKE();
		code.STORE("eval_param0",Clazz.of(ConsumerWithException.class,Clazz.of(MethodCode.class)));

		code.LINE();
		code.LOAD("context");
		code.LOAD("this");
		code.VIRTUAL(AdvContext.class, "resolve")
			.return_(ConsumerWithException.class)
			.parameter(Object.class).INVOKE();
		code.STORE("objEval",Clazz.of(ConsumerWithException.class,Clazz.of(MethodCode.class)));

		code.LINE();
		code.LOAD("context");
		code.LOADConst(Type.getType("[Ljava/lang/Object;"));
		code.LOAD("objEval");
		code.LOAD("eval_param0");
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/GenericMethodInterfaceSampleAdvAsmProxy", "lambda$objectToArray$3", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "push")
			.return_(byte.class)
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
		code.LOAD("param0");
		code.VIRTUAL(Object.class, "getClass")
			.return_(Class.class).INVOKE();
		code.STORE("targetClassT",Clazz.of(Class.class, Clazz.typeUnboundedTypeArgument()));

		code.LINE();
		code.LOAD("targetClassT");
		code.LOADConst(1);
		code.STATIC(Array.class, "newInstance")
			.return_(Object.class)
			.parameter(Class.class)
			.parameter(int.class).INVOKE();
		code.CHECKCAST(Object[].class);
		code.STORE("targetArray",Clazz.typeVariableOf("T",true));

		code.LINE();
		code.LOADConstNULL();
		code.STORE("targetElement",Clazz.typeVariableOf("T"));

		code.LINE();
		code.LOAD("targetClassT");
		code.STATIC(Adv.class, "canProxy")
			.return_(boolean.class)
			.parameter(Class.class).INVOKE();
		Label label9OfIFEQ = new Label();
		code.IFEQ(label9OfIFEQ);

		code.LINE();
		code.LOAD("targetClassT");
		code.LOAD("magicNumber");
		code.STATIC(Adv.class, "buildProxyClass")
			.return_(Object.class)
			.parameter(Class.class)
			.parameter(byte.class).INVOKE();
		code.STORE("targetElement");

		code.LINE();
		code.LOAD("targetArray");
		code.LOADConst(0);
		code.LOAD("targetElement");
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("targetArray");
		code.RETURNTop();

		code.visitLabel(label9OfIFEQ);

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _lambda$objectToArray$3(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$objectToArray$3")
			.throws_(Exception.class )
			.parameter("objEval",ConsumerWithException.class)
			.parameter("eval_param0",ConsumerWithException.class)
			.parameter("c",MethodCode.class).begin();

		code.LINE();
		code.LOAD("objEval");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("eval_param0");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/GenericMethodInterface;"));
		code.LOADConst("objectToArray");
		code.VIRTUAL(MethodCode.class, "INTERFACE")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("Ljava/lang/Object;"));
		code.INTERFACE(MethodCaller.class, "parameter")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.LOADConst(Type.getType("[Ljava/lang/Object;"));
		code.INTERFACE(MethodCaller.class, "return_")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$objectToObject$2(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$objectToObject$2")
			.throws_(Exception.class )
			.parameter("objEval",ConsumerWithException.class)
			.parameter("eval_param0",ConsumerWithException.class)
			.parameter("c",MethodCode.class).begin();

		code.LINE();
		code.LOAD("objEval");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("eval_param0");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/GenericMethodInterface;"));
		code.LOADConst("objectToObject");
		code.VIRTUAL(MethodCode.class, "INTERFACE")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("Ljava/lang/Object;"));
		code.INTERFACE(MethodCaller.class, "parameter")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.LOADConst(Type.getType("Ljava/lang/Object;"));
		code.INTERFACE(MethodCaller.class, "return_")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$arrayToObject$1(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$arrayToObject$1")
			.throws_(Exception.class )
			.parameter("objEval",ConsumerWithException.class)
			.parameter("eval_param0",ConsumerWithException.class)
			.parameter("c",MethodCode.class).begin();

		code.LINE();
		code.LOAD("objEval");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("eval_param0");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/GenericMethodInterface;"));
		code.LOADConst("arrayToObject");
		code.VIRTUAL(MethodCode.class, "INTERFACE")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("[Ljava/lang/Object;"));
		code.INTERFACE(MethodCaller.class, "parameter")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.LOADConst(Type.getType("Ljava/lang/Object;"));
		code.INTERFACE(MethodCaller.class, "return_")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$arrayToArray$0(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$arrayToArray$0")
			.throws_(Exception.class )
			.parameter("objEval",ConsumerWithException.class)
			.parameter("eval_param0",ConsumerWithException.class)
			.parameter("c",MethodCode.class).begin();

		code.LINE();
		code.LOAD("objEval");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("eval_param0");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/GenericMethodInterface;"));
		code.LOADConst("arrayToArray");
		code.VIRTUAL(MethodCode.class, "INTERFACE")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("[Ljava/lang/Object;"));
		code.INTERFACE(MethodCaller.class, "parameter")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.LOADConst(Type.getType("[Ljava/lang/Object;"));
		code.INTERFACE(MethodCaller.class, "return_")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
