package cn.sj1.tinyasm.core.advasmproxy.arraylist;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;

import cn.sj1.tinyasm.core.Annotation;
import cn.sj1.tinyasm.core.ClassBody;
import cn.sj1.tinyasm.core.ClassBuilder;
import cn.sj1.tinyasm.core.Clazz;
import cn.sj1.tinyasm.core.MethodCode;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import cn.sj1.tinyasm.core.Adv;
import cn.sj1.tinyasm.core.AdvContext;
import cn.sj1.tinyasm.core.AdvRuntimeReferNameObject;
import cn.sj1.tinyasm.core.Clazz;
import cn.sj1.tinyasm.core.ClazzSimple;
import cn.sj1.tinyasm.core.ConsumerWithException;
import cn.sj1.tinyasm.core.MethodCaller;
import cn.sj1.tinyasm.core.MethodCode;
import cn.sj1.tinyasm.core.advasmproxy.simple.PojoClass;

@SuppressWarnings("unused")
public class IterableAdvAsmProxyTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new IterableAdvAsmProxyTinyAsmDump().build("cn.sj1.tinyasm.core.advasmproxy.arraylist.IterableAdvAsmProxy");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className, Clazz.of(Object.class),Clazz.of(Iterable.class,Clazz.of(PojoClass.class)),Clazz.of(AdvRuntimeReferNameObject.class))
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, "java.lang.invoke.MethodHandles", "Lookup");

		classBody.private_().field("_magicNumber", Clazz.of(byte.class));
		classBody.private_().field("_contextThreadLocal",Clazz.of(ThreadLocal.class,Clazz.of(AdvContext.class)));
		__init_(classBody);
		_get__MagicNumber(classBody);
		_set__MagicNumber(classBody);
		_set__Context(classBody);
		_get__TargetClazz(classBody);
		_iterator(classBody);
		_forEach(classBody);
		_spliterator(classBody);
		_lambda$spliterator$2(classBody);
		_lambda$forEach$1(classBody);
		_lambda$iterator$0(classBody);

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

	protected void _get__TargetClazz(ClassBody classBody) {
		MethodCode code = classBody.public_().method("get__TargetClazz")
			.return_(Clazz.class ).begin();

		code.LINE();
		code.LOADConst(Type.getType("Ljava/lang/Iterable;"));
		code.STATIC(Clazz.class, "of")
			.return_(ClazzSimple.class)
			.parameter(Class.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _iterator(ClassBody classBody) {
		MethodCode code = classBody.public_().method("iterator")
			.return_(Clazz.of(Iterator.class,Clazz.of(PojoClass.class)) ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_contextThreadLocal");
		code.VIRTUAL(ThreadLocal.class, "get")
			.return_(Object.class).INVOKE();
		code.CHECKCAST(AdvContext.class);
		code.STORE("context",AdvContext.class);

		code.LINE();
		code.LOAD("context");
		code.LOAD("this");
		code.VIRTUAL(AdvContext.class, "resolve")
			.return_(ConsumerWithException.class)
			.parameter(Object.class).INVOKE();
		code.STORE("objEval",Clazz.of(ConsumerWithException.class,Clazz.of(MethodCode.class)));

		code.LINE();
		code.LOAD("context");
		code.LOADConst(Type.getType("Ljava/util/Iterator;"));
		code.LOAD("objEval");
		code.visitInvokeDynamicInsn("accept", "(Lcn/sj1/tinyasm/core/ConsumerWithException;)Lcn/sj1/tinyasm/core/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cn/sj1/tinyasm/core/advasmproxy/arraylist/IterableAdvAsmProxy", "lambda$iterator$0", "(Lcn/sj1/tinyasm/core/ConsumerWithException;Lcn/sj1/tinyasm/core/MethodCode;)V", false), Type.getType("(Lcn/sj1/tinyasm/core/MethodCode;)V")});
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
		code.LOADConst(Type.getType("Ljava/util/Iterator;"));
		code.STATIC(Adv.class, "canProxy")
			.return_(boolean.class)
			.parameter(Class.class).INVOKE();
		Label label5OfIFEQ = new Label();
		code.IFEQ(label5OfIFEQ);

		code.LINE();
		code.LOADConst(Type.getType("Ljava/util/Iterator;"));
		code.LOADConst(Type.getType("Lcn/sj1/tinyasm/core/advasmproxy/simple/PojoClass;"));
		code.LOAD("magicNumber");
		code.STATIC(Adv.class, "buildProxyClass")
			.return_(Object.class)
			.parameter(Class.class)
			.parameter(Class.class)
			.parameter(byte.class).INVOKE();
		code.CHECKCAST(Iterator.class);
		code.RETURNTop();

		code.visitLabel(label5OfIFEQ);

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _forEach(ClassBody classBody) {
		MethodCode code = classBody.public_().method("forEach")
			.return_(Clazz.of(void.class) )
			.parameter("param0",Clazz.of(Consumer.class,Clazz.typeArgument('-',PojoClass.class))).begin();

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
		code.LOAD("objEval");
		code.LOAD("eval_param0");
		code.visitInvokeDynamicInsn("accept", "(Lcn/sj1/tinyasm/core/ConsumerWithException;Lcn/sj1/tinyasm/core/ConsumerWithException;)Lcn/sj1/tinyasm/core/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cn/sj1/tinyasm/core/advasmproxy/arraylist/IterableAdvAsmProxy", "lambda$forEach$1", "(Lcn/sj1/tinyasm/core/ConsumerWithException;Lcn/sj1/tinyasm/core/ConsumerWithException;Lcn/sj1/tinyasm/core/MethodCode;)V", false), Type.getType("(Lcn/sj1/tinyasm/core/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "execLine")
			.parameter(ConsumerWithException.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _spliterator(ClassBody classBody) {
		MethodCode code = classBody.public_().method("spliterator")
			.return_(Clazz.of(Spliterator.class,Clazz.of(PojoClass.class)) ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_contextThreadLocal");
		code.VIRTUAL(ThreadLocal.class, "get")
			.return_(Object.class).INVOKE();
		code.CHECKCAST(AdvContext.class);
		code.STORE("context",AdvContext.class);

		code.LINE();
		code.LOAD("context");
		code.LOAD("this");
		code.VIRTUAL(AdvContext.class, "resolve")
			.return_(ConsumerWithException.class)
			.parameter(Object.class).INVOKE();
		code.STORE("objEval",Clazz.of(ConsumerWithException.class,Clazz.of(MethodCode.class)));

		code.LINE();
		code.LOAD("context");
		code.LOADConst(Type.getType("Ljava/util/Spliterator;"));
		code.LOAD("objEval");
		code.visitInvokeDynamicInsn("accept", "(Lcn/sj1/tinyasm/core/ConsumerWithException;)Lcn/sj1/tinyasm/core/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cn/sj1/tinyasm/core/advasmproxy/arraylist/IterableAdvAsmProxy", "lambda$spliterator$2", "(Lcn/sj1/tinyasm/core/ConsumerWithException;Lcn/sj1/tinyasm/core/MethodCode;)V", false), Type.getType("(Lcn/sj1/tinyasm/core/MethodCode;)V")});
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
		code.LOADConst(Type.getType("Ljava/util/Spliterator;"));
		code.STATIC(Adv.class, "canProxy")
			.return_(boolean.class)
			.parameter(Class.class).INVOKE();
		Label label5OfIFEQ = new Label();
		code.IFEQ(label5OfIFEQ);

		code.LINE();
		code.LOADConst(Type.getType("Ljava/util/Spliterator;"));
		code.LOADConst(Type.getType("Lcn/sj1/tinyasm/core/advasmproxy/simple/PojoClass;"));
		code.LOAD("magicNumber");
		code.STATIC(Adv.class, "buildProxyClass")
			.return_(Object.class)
			.parameter(Class.class)
			.parameter(Class.class)
			.parameter(byte.class).INVOKE();
		code.CHECKCAST(Spliterator.class);
		code.RETURNTop();

		code.visitLabel(label5OfIFEQ);

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _lambda$spliterator$2(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$spliterator$2")
			.throws_(Exception.class )
			.parameter(ACC_FINAL | ACC_SYNTHETIC,"objEval",ConsumerWithException.class)
			.parameter(ACC_SYNTHETIC,"c",MethodCode.class).begin();

		code.LINE();
		code.LOAD("objEval");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Ljava/lang/Iterable;"));
		code.LOADConst("spliterator");
		code.VIRTUAL(MethodCode.class, "INTERFACE")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("Ljava/util/Spliterator;"));
		code.INTERFACE(MethodCaller.class, "return_")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$forEach$1(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$forEach$1")
			.throws_(Exception.class )
			.parameter(ACC_FINAL | ACC_SYNTHETIC,"objEval",ConsumerWithException.class)
			.parameter(ACC_FINAL | ACC_SYNTHETIC,"eval_param0",ConsumerWithException.class)
			.parameter(ACC_SYNTHETIC,"c",MethodCode.class).begin();

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
		code.LOADConst(Type.getType("Ljava/lang/Iterable;"));
		code.LOADConst("forEach");
		code.VIRTUAL(MethodCode.class, "INTERFACE")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("Ljava/util/function/Consumer;"));
		code.INTERFACE(MethodCaller.class, "parameter")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$iterator$0(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$iterator$0")
			.throws_(Exception.class )
			.parameter(ACC_FINAL | ACC_SYNTHETIC,"objEval",ConsumerWithException.class)
			.parameter(ACC_SYNTHETIC,"c",MethodCode.class).begin();

		code.LINE();
		code.LOAD("objEval");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Ljava/lang/Iterable;"));
		code.LOADConst("iterator");
		code.VIRTUAL(MethodCode.class, "INTERFACE")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("Ljava/util/Iterator;"));
		code.INTERFACE(MethodCaller.class, "return_")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
