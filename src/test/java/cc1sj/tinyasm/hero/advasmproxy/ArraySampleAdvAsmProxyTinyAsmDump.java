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
import cc1sj.tinyasm.AdvContext;
import cc1sj.tinyasm.hero.helperclass.ArraySample;
import java.lang.Exception;
import cc1sj.tinyasm.ClazzSimple;
import cc1sj.tinyasm.hero.helperclass.SimplePojoClassSample;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.MethodCaller;
import cc1sj.tinyasm.AdvRuntimeReferNameObject;
import java.lang.Short;
import cc1sj.tinyasm.Adv;
import java.lang.Class;
import java.lang.Object;
import java.lang.StringBuilder;
import cc1sj.tinyasm.ConsumerWithException;
import java.lang.String;
import cc1sj.tinyasm.Clazz;
@SuppressWarnings("unused")
public class ArraySampleAdvAsmProxyTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new ArraySampleAdvAsmProxyTinyAsmDump().dump("cc1sj.tinyasm.hero.advasmproxy.ArraySampleAdvAsmProxy");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className, ArraySample.class, AdvRuntimeReferNameObject.class)
			.access(ACC_PUBLIC | ACC_SUPER).body();

classBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, "java.lang.invoke.MethodHandles", "Lookup");

		classBody.private_().field("_magicNumber", Clazz.of(byte.class));
		classBody.private_().field("_contextThreadLocal",Clazz.of(ThreadLocal.class,Clazz.of(AdvContext.class)));
		__init_(classBody);
		_get__MagicNumber(classBody);
		_set__MagicNumber(classBody);
		_set__Context(classBody);
		_get__TargetClazz(classBody);
		_getByteArray(classBody);
		_getShortArray(classBody);
		_getIntArray(classBody);
		_getShort2Array(classBody);
		_getStringArray(classBody);
		_getSimplePojoClassSampleArray(classBody);
		_setByteArray(classBody);
		_setShortArray(classBody);
		_setIntArray(classBody);
		_setShort2Array(classBody);
		_setStringArray(classBody);
		_setSimplePojoClassSampleArray(classBody);
		_lambda$setSimplePojoClassSampleArray$11(classBody);
		_lambda$setStringArray$10(classBody);
		_lambda$setShort2Array$9(classBody);
		_lambda$setIntArray$8(classBody);
		_lambda$setShortArray$7(classBody);
		_lambda$setByteArray$6(classBody);
		_lambda$getSimplePojoClassSampleArray$5(classBody);
		_lambda$getStringArray$4(classBody);
		_lambda$getShort2Array$3(classBody);
		_lambda$getIntArray$2(classBody);
		_lambda$getShortArray$1(classBody);
		_lambda$getByteArray$0(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(ArraySample.class, "<init>").INVOKE();
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
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/ArraySample;"));
		code.STATIC(Clazz.class, "of")
			.return_(ClazzSimple.class)
			.parameter(Class.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getByteArray(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getByteArray")
			.return_(byte[].class ).begin();

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
		code.LOADConst(Type.getType("[B"));
		code.LOAD("objEval");
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/ArraySampleAdvAsmProxy", "lambda$getByteArray$0", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "push")
			.return_(byte.class)
			.parameter(Class.class)
			.parameter(ConsumerWithException.class).INVOKE();
		code.STORE("codeIndex",byte.class);

		code.LINE();
		code.LOADConst(80);
		code.LOAD("codeIndex");
		code.ADD();
		code.STORE("magicNumber",int.class);

		code.LINE();
		code.LOADConst(1);
		code.NEWARRAY(byte.class);
		code.STORE("tarray",byte[].class);

		code.LINE();
		code.LOAD("tarray");
		code.LOADConst(0);
		code.LOAD("magicNumber");
		code.CONVERTTO(byte.class);
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("tarray");
		code.RETURNTop();

		code.END();
	}

	protected void _getShortArray(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getShortArray")
			.return_(short[].class ).begin();

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
		code.LOADConst(Type.getType("[S"));
		code.LOAD("objEval");
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/ArraySampleAdvAsmProxy", "lambda$getShortArray$1", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "push")
			.return_(byte.class)
			.parameter(Class.class)
			.parameter(ConsumerWithException.class).INVOKE();
		code.STORE("codeIndex",byte.class);

		code.LINE();
		code.LOADConst(80);
		code.LOAD("codeIndex");
		code.ADD();
		code.STORE("magicNumber",int.class);

		code.LINE();
		code.LOADConst(1);
		code.NEWARRAY(short.class);
		code.STORE("tarray",short[].class);

		code.LINE();
		code.LOAD("tarray");
		code.LOADConst(0);
		code.LOAD("magicNumber");
		code.CONVERTTO(short.class);
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("tarray");
		code.RETURNTop();

		code.END();
	}

	protected void _getIntArray(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getIntArray")
			.return_(int[].class ).begin();

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
		code.LOADConst(Type.getType("[I"));
		code.LOAD("objEval");
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/ArraySampleAdvAsmProxy", "lambda$getIntArray$2", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "push")
			.return_(byte.class)
			.parameter(Class.class)
			.parameter(ConsumerWithException.class).INVOKE();
		code.STORE("codeIndex",byte.class);

		code.LINE();
		code.LOADConst(80);
		code.LOAD("codeIndex");
		code.ADD();
		code.STORE("magicNumber",int.class);

		code.LINE();
		code.LOADConst(1);
		code.NEWARRAY(int.class);
		code.STORE("tarray",int[].class);

		code.LINE();
		code.LOAD("tarray");
		code.LOADConst(0);
		code.LOAD("magicNumber");
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("tarray");
		code.RETURNTop();

		code.END();
	}

	protected void _getShort2Array(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getShort2Array")
			.return_(Short[].class ).begin();

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
		code.LOADConst(Type.getType("[Ljava/lang/Short;"));
		code.LOAD("objEval");
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/ArraySampleAdvAsmProxy", "lambda$getShort2Array$3", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "push")
			.return_(byte.class)
			.parameter(Class.class)
			.parameter(ConsumerWithException.class).INVOKE();
		code.STORE("codeIndex",byte.class);

		code.LINE();
		code.LOADConst(80);
		code.LOAD("codeIndex");
		code.ADD();
		code.STORE("magicNumber",int.class);

		code.LINE();
		code.LOADConst(1);
		code.NEWARRAY(Short.class);
		code.STORE("tarray",Short[].class);

		code.LINE();
		code.LOAD("tarray");
		code.LOADConst(0);
		code.LOAD("magicNumber");
		code.CONVERTTO(short.class);
		code.STATIC(Short.class, "valueOf")
			.return_(Short.class)
			.parameter(short.class).INVOKE();
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("tarray");
		code.RETURNTop();

		code.END();
	}

	protected void _getStringArray(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getStringArray")
			.return_(String[].class ).begin();

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
		code.LOADConst(Type.getType("[Ljava/lang/String;"));
		code.LOAD("objEval");
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/ArraySampleAdvAsmProxy", "lambda$getStringArray$4", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "push")
			.return_(byte.class)
			.parameter(Class.class)
			.parameter(ConsumerWithException.class).INVOKE();
		code.STORE("codeIndex",byte.class);

		code.LINE();
		code.NEW(StringBuilder.class);
		code.DUP();
		code.LOADConst("#MAGIC-CODES#");
		code.SPECIAL(StringBuilder.class, "<init>")
			.parameter(String.class).INVOKE();
		code.LOAD("codeIndex");
		code.VIRTUAL(StringBuilder.class, "append")
			.return_(StringBuilder.class)
			.parameter(int.class).INVOKE();
		code.VIRTUAL(StringBuilder.class, "toString")
			.return_(String.class).INVOKE();
		code.STORE("magicNumber",String.class);

		code.LINE();
		code.LOADConst(1);
		code.NEWARRAY(String.class);
		code.STORE("tarray",String[].class);

		code.LINE();
		code.LOAD("tarray");
		code.LOADConst(0);
		code.LOAD("magicNumber");
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("tarray");
		code.RETURNTop();

		code.END();
	}

	protected void _getSimplePojoClassSampleArray(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getSimplePojoClassSampleArray")
			.return_(SimplePojoClassSample[].class ).begin();

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
		code.LOADConst(Type.getType("[Lcc1sj/tinyasm/hero/helperclass/SimplePojoClassSample;"));
		code.LOAD("objEval");
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/ArraySampleAdvAsmProxy", "lambda$getSimplePojoClassSampleArray$5", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
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
		code.LOADConstNULL();
		code.STORE("simplePojoClassSample",SimplePojoClassSample.class);

		code.LINE();
		code.LOADConst(1);
		code.NEWARRAY(SimplePojoClassSample.class);
		code.STORE("tarray",SimplePojoClassSample[].class);

		code.LINE();
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/SimplePojoClassSample;"));
		code.STATIC(Adv.class, "canProxy")
			.return_(boolean.class)
			.parameter(Class.class).INVOKE();
		Label label7OfIFEQ = new Label();
		code.IFEQ(label7OfIFEQ);

		code.LINE();
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/SimplePojoClassSample;"));
		code.LOAD("magicNumber");
		code.STATIC(Adv.class, "buildProxyClass")
			.return_(Object.class)
			.parameter(Class.class)
			.parameter(byte.class).INVOKE();
		code.CHECKCAST(SimplePojoClassSample.class);
		code.STORE("simplePojoClassSample");

		code.LINE();
		code.LOAD("tarray");
		code.LOADConst(0);
		code.LOAD("simplePojoClassSample");
		code.ARRAYSTORE();

		code.LINE();
		code.LOAD("tarray");
		code.RETURNTop();

		code.visitLabel(label7OfIFEQ);

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _setByteArray(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setByteArray")
			.parameter("param0",byte[].class).begin();

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
			.parameter(byte[].class).INVOKE();
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
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/ArraySampleAdvAsmProxy", "lambda$setByteArray$6", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "execLine")
			.parameter(ConsumerWithException.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setShortArray(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setShortArray")
			.parameter("param0",short[].class).begin();

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
			.parameter(short[].class).INVOKE();
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
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/ArraySampleAdvAsmProxy", "lambda$setShortArray$7", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "execLine")
			.parameter(ConsumerWithException.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setIntArray(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setIntArray")
			.parameter("param0",int[].class).begin();

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
			.parameter(int[].class).INVOKE();
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
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/ArraySampleAdvAsmProxy", "lambda$setIntArray$8", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "execLine")
			.parameter(ConsumerWithException.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setShort2Array(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setShort2Array")
			.parameter("param0",Short[].class).begin();

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
			.parameter(Short[].class).INVOKE();
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
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/ArraySampleAdvAsmProxy", "lambda$setShort2Array$9", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "execLine")
			.parameter(ConsumerWithException.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setStringArray(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setStringArray")
			.parameter("param0",String[].class).begin();

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
			.parameter(String[].class).INVOKE();
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
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/ArraySampleAdvAsmProxy", "lambda$setStringArray$10", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "execLine")
			.parameter(ConsumerWithException.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setSimplePojoClassSampleArray(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setSimplePojoClassSampleArray")
			.parameter("param0",SimplePojoClassSample[].class).begin();

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
		code.LOAD("objEval");
		code.LOAD("eval_param0");
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, "cc1sj/tinyasm/hero/advasmproxy/ArraySampleAdvAsmProxy", "lambda$setSimplePojoClassSampleArray$11", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
		code.VIRTUAL(AdvContext.class, "execLine")
			.parameter(ConsumerWithException.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$setSimplePojoClassSampleArray$11(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$setSimplePojoClassSampleArray$11")
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
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/ArraySample;"));
		code.LOADConst("setSimplePojoClassSampleArray");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("[Lcc1sj/tinyasm/hero/helperclass/SimplePojoClassSample;"));
		code.INTERFACE(MethodCaller.class, "parameter")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$setStringArray$10(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$setStringArray$10")
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
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/ArraySample;"));
		code.LOADConst("setStringArray");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("[Ljava/lang/String;"));
		code.INTERFACE(MethodCaller.class, "parameter")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$setShort2Array$9(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$setShort2Array$9")
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
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/ArraySample;"));
		code.LOADConst("setShort2Array");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("[Ljava/lang/Short;"));
		code.INTERFACE(MethodCaller.class, "parameter")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$setIntArray$8(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$setIntArray$8")
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
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/ArraySample;"));
		code.LOADConst("setIntArray");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("[I"));
		code.INTERFACE(MethodCaller.class, "parameter")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$setShortArray$7(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$setShortArray$7")
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
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/ArraySample;"));
		code.LOADConst("setShortArray");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("[S"));
		code.INTERFACE(MethodCaller.class, "parameter")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$setByteArray$6(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$setByteArray$6")
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
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/ArraySample;"));
		code.LOADConst("setByteArray");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("[B"));
		code.INTERFACE(MethodCaller.class, "parameter")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$getSimplePojoClassSampleArray$5(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$getSimplePojoClassSampleArray$5")
			.throws_(Exception.class )
			.parameter("objEval",ConsumerWithException.class)
			.parameter("c",MethodCode.class).begin();

		code.LINE();
		code.LOAD("objEval");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/ArraySample;"));
		code.LOADConst("getSimplePojoClassSampleArray");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("[Lcc1sj/tinyasm/hero/helperclass/SimplePojoClassSample;"));
		code.INTERFACE(MethodCaller.class, "return_")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$getStringArray$4(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$getStringArray$4")
			.throws_(Exception.class )
			.parameter("objEval",ConsumerWithException.class)
			.parameter("c",MethodCode.class).begin();

		code.LINE();
		code.LOAD("objEval");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/ArraySample;"));
		code.LOADConst("getStringArray");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("[Ljava/lang/String;"));
		code.INTERFACE(MethodCaller.class, "return_")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$getShort2Array$3(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$getShort2Array$3")
			.throws_(Exception.class )
			.parameter("objEval",ConsumerWithException.class)
			.parameter("c",MethodCode.class).begin();

		code.LINE();
		code.LOAD("objEval");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/ArraySample;"));
		code.LOADConst("getShort2Array");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("[Ljava/lang/Short;"));
		code.INTERFACE(MethodCaller.class, "return_")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$getIntArray$2(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$getIntArray$2")
			.throws_(Exception.class )
			.parameter("objEval",ConsumerWithException.class)
			.parameter("c",MethodCode.class).begin();

		code.LINE();
		code.LOAD("objEval");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/ArraySample;"));
		code.LOADConst("getIntArray");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("[I"));
		code.INTERFACE(MethodCaller.class, "return_")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$getShortArray$1(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$getShortArray$1")
			.throws_(Exception.class )
			.parameter("objEval",ConsumerWithException.class)
			.parameter("c",MethodCode.class).begin();

		code.LINE();
		code.LOAD("objEval");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/ArraySample;"));
		code.LOADConst("getShortArray");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("[S"));
		code.INTERFACE(MethodCaller.class, "return_")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$getByteArray$0(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$getByteArray$0")
			.throws_(Exception.class )
			.parameter("objEval",ConsumerWithException.class)
			.parameter("c",MethodCode.class).begin();

		code.LINE();
		code.LOAD("objEval");
		code.LOAD("c");
		code.INTERFACE(ConsumerWithException.class, "accept")
			.parameter(Object.class).INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/ArraySample;"));
		code.LOADConst("getByteArray");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.return_(MethodCaller.class)
			.parameter(Class.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("[B"));
		code.INTERFACE(MethodCaller.class, "return_")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
