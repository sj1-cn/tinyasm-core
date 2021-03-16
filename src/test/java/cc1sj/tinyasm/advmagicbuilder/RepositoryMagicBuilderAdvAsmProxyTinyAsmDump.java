package cc1sj.tinyasm.advmagicbuilder;
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
import cc1sj.tinyasm.advmagicbuilder.WithIdKey;
import java.lang.ThreadLocal;
import cc1sj.tinyasm.AdvContext;
import cc1sj.tinyasm.advmagicbuilder.RepositoryMagicBuilder;
import java.lang.Exception;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.MethodCaller;
import cc1sj.tinyasm.AdvMagicRuntimeWithTypeArgument;
import cc1sj.tinyasm.advmagicbuilder.RepositoryMagicBuilderAdvAsmProxy;
import cc1sj.tinyasm.Adv;
import java.lang.Object;
import java.lang.Class;
import cc1sj.tinyasm.ConsumerWithException;
import java.lang.String;
import cc1sj.tinyasm.Clazz;
@SuppressWarnings("unused")
public class RepositoryMagicBuilderAdvAsmProxyTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new RepositoryMagicBuilderAdvAsmProxyTinyAsmDump().dump("cc1sj.tinyasm.advmagicbuilder.RepositoryMagicBuilderAdvAsmProxy");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className, Clazz.of(RepositoryMagicBuilder.class,Clazz.typeArgument(Clazz.typeVariableOf("E")),Clazz.typeArgument(Clazz.typeVariableOf("R"))),Clazz.of(AdvMagicRuntimeWithTypeArgument.class)).formalTypeParameter("E",Clazz.of(WithIdKey.class)).formalTypeParameter("R",Clazz.of(Object.class))
			.access(ACC_PUBLIC | ACC_SUPER).body();

classBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, "java.lang.invoke.MethodHandles", "Lookup");

		classBody.private_().field("_magicNumber", Clazz.of(byte.class));
		classBody.private_().field("_contextThreadLocal",Clazz.of(ThreadLocal.class,Clazz.of(AdvContext.class)));
		classBody.private_().field("_targetClazz", Clazz.of(Clazz.class));
		classBody.private_().field("_arguments",Clazz.of(Class[].class, Clazz.typeUnboundedTypeArgument()));
		__init_(classBody);
		_get__MagicNumber(classBody);
		_set__MagicNumber(classBody);
		_set__Context(classBody);
		_set__TargetClazz(classBody);
		_get__TargetClazz(classBody);
		_set__TypeArgument(classBody);
		_update(classBody);
		_$_update(classBody);
		_bridge_update(classBody);
		_lambda$update$0(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(RepositoryMagicBuilder.class, "<init>").INVOKE();
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

	protected void _set__TargetClazz(ClassBody classBody) {
		MethodCode code = classBody.public_().method("set__TargetClazz")
			.parameter("_targetClazz",Clazz.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("_targetClazz");
		code.PUTFIELD_OF_THIS("_targetClazz");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _get__TargetClazz(ClassBody classBody) {
		MethodCode code = classBody.public_().method("get__TargetClazz")
			.return_(Clazz.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_targetClazz");
		code.RETURNTop();

		code.END();
	}

	protected void _set__TypeArgument(ClassBody classBody) {
		MethodCode code = classBody.public_().method("set__TypeArgument")
			.return_(Clazz.of(void.class) )
			.parameter("_arguments",Clazz.of(Class[].class, Clazz.typeUnboundedTypeArgument())).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("_arguments");
		code.PUTFIELD_OF_THIS("_arguments");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _update(ClassBody classBody) {
		MethodCode code = classBody.public_().method("update")
			.return_(Clazz.typeVariableOf("R") )
			.parameter("param0",Clazz.typeVariableOf("E")).begin();

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
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_arguments");
		code.LOADConst(1);
		code.ARRAYLOAD();
		code.LOAD("this");
		code.LOAD("objEval");
		code.LOAD("eval_param0");
		code.visitInvokeDynamicInsn("accept", "(Lcc1sj/tinyasm/advmagicbuilder/RepositoryMagicBuilderAdvAsmProxy;Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;)Lcc1sj/tinyasm/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESPECIAL, "cc1sj/tinyasm/advmagicbuilder/RepositoryMagicBuilderAdvAsmProxy", "lambda$update$0", "(Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/ConsumerWithException;Lcc1sj/tinyasm/MethodCode;)V", false), Type.getType("(Lcc1sj/tinyasm/MethodCode;)V")});
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
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_arguments");
		code.LOADConst(1);
		code.ARRAYLOAD();
		code.LOAD("magicNumber");
		code.STATIC(Adv.class, "proxyReturn")
			.return_(Object.class)
			.parameter(Class.class)
			.parameter(byte.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _$_update(ClassBody classBody) {
		MethodCode code = classBody.public_().method("$_update")
			.return_(Clazz.typeVariableOf("R") )
			.parameter("param0",Clazz.typeVariableOf("E")).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("param0");
		code.SPECIAL(RepositoryMagicBuilder.class, "update")
			.return_(Object.class)
			.parameter(WithIdKey.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _bridge_update(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC | ACC_BRIDGE | ACC_SYNTHETIC, "update")
			.return_(Object.class )
			.parameter("var1",Object.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("var1");
		code.CHECKCAST(WithIdKey.class);
		code.VIRTUAL("update")
			.return_(Object.class)
			.parameter(WithIdKey.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _lambda$update$0(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PRIVATE | ACC_SYNTHETIC, "lambda$update$0")
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
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_targetClazz");
		code.LOADConst("update");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.return_(MethodCaller.class)
			.parameter(Clazz.class)
			.parameter(String.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_arguments");
		code.LOADConst(0);
		code.ARRAYLOAD();
		code.INTERFACE(MethodCaller.class, "parameter")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_arguments");
		code.LOADConst(1);
		code.ARRAYLOAD();
		code.INTERFACE(MethodCaller.class, "return_")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
