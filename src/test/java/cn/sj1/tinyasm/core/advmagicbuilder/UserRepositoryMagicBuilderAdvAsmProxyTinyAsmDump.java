package cn.sj1.tinyasm.core.advmagicbuilder;
import org.objectweb.asm.Label;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import cn.sj1.tinyasm.core.ClassBody;
import cn.sj1.tinyasm.core.ClassBuilder;
import cn.sj1.tinyasm.core.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cn.sj1.tinyasm.core.Annotation;
import cn.sj1.tinyasm.core.Clazz;
import cn.sj1.tinyasm.core.ConsumerWithException;
import java.lang.ThreadLocal;
import cn.sj1.tinyasm.core.advmagicbuilder.WithIdKey;
import cn.sj1.tinyasm.core.ClassBody;
import cn.sj1.tinyasm.core.AdvContext;
import java.lang.Exception;
import cn.sj1.tinyasm.core.Clazz;
import cn.sj1.tinyasm.core.advmagicbuilder.RepositoryMagicBuilder;
import cn.sj1.tinyasm.core.MethodCode;
import cn.sj1.tinyasm.core.MethodHeader;
import java.lang.Object;
import java.lang.Class;
import java.lang.StringBuilder;
import java.lang.String;
import cn.sj1.tinyasm.core.AdvMagicRuntime;
import cn.sj1.tinyasm.core.advmagicbuilder.User;
import cn.sj1.tinyasm.core.MethodCaller;
@SuppressWarnings("unused")
public class UserRepositoryMagicBuilderAdvAsmProxyTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new UserRepositoryMagicBuilderAdvAsmProxyTinyAsmDump().dump("cn.sj1.tinyasm.core.advmagicbuilder.UserRepositoryMagicBuilderAdvAsmProxy");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className, Clazz.of(RepositoryMagicBuilder.class,Clazz.of(User.class),Clazz.of(String.class)),Clazz.of(AdvMagicRuntime.class))
			.access(ACC_PUBLIC | ACC_SUPER).body();

classBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, "java.lang.invoke.MethodHandles", "Lookup");

		classBody.private_().field("_magicNumber", Clazz.of(byte.class));
		classBody.private_().field("_contextThreadLocal",Clazz.of(ThreadLocal.class,Clazz.of(AdvContext.class)));
		classBody.private_().field("_targetClazz", Clazz.of(Clazz.class));
		__init_(classBody);
		_get__MagicNumber(classBody);
		_set__MagicNumber(classBody);
		_set__Context(classBody);
		_set__TargetClazz(classBody);
		_get__TargetClazz(classBody);
		_update(classBody);
		_$_update(classBody);
		__update(classBody);
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

	protected void _update(ClassBody classBody) {
		MethodCode code = classBody.public_().method("update")
			.return_(String.class )
			.parameter("param0",User.class).begin();

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
		code.LOADConst(Type.getType("Ljava/lang/String;"));
		code.LOAD("this");
		code.LOAD("objEval");
		code.LOAD("eval_param0");
		code.visitInvokeDynamicInsn("accept", "(Lcn/sj1/tinyasm/core/advmagicbuilder/UserRepositoryMagicBuilderAdvAsmProxy;Lcn/sj1/tinyasm/core/ConsumerWithException;Lcn/sj1/tinyasm/core/ConsumerWithException;)Lcn/sj1/tinyasm/core/ConsumerWithException;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESPECIAL, "cn/sj1/tinyasm/core/advmagicbuilder/UserRepositoryMagicBuilderAdvAsmProxy", "lambda$update$0", "(Lcn/sj1/tinyasm/core/ConsumerWithException;Lcn/sj1/tinyasm/core/ConsumerWithException;Lcn/sj1/tinyasm/core/MethodCode;)V", false), Type.getType("(Lcn/sj1/tinyasm/core/MethodCode;)V")});
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
		code.RETURNTop();

		code.END();
	}

	protected void _$_update(ClassBody classBody) {
		MethodCode code = classBody.public_().method("$_update")
			.return_(String.class )
			.parameter("param0",User.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("param0");
		code.SPECIAL(RepositoryMagicBuilder.class, "update")
			.return_(Object.class)
			.parameter(WithIdKey.class).INVOKE();
		code.CHECKCAST(String.class);
		code.RETURNTop();

		code.END();
	}

	protected void __update(ClassBody classBody) {
		MethodCode code = classBody.public_().method("_update")
			.parameter("classBody",ClassBody.class).begin();

		code.LINE();
		code.LOAD("classBody");
		code.LOADConst(4161);
		code.LOADConst("update");
		code.INTERFACE(ClassBody.class, "method")
			.return_(MethodHeader.class)
			.parameter(int.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("Ljava/lang/Object;"));
		code.INTERFACE(MethodHeader.class, "return_")
			.return_(MethodHeader.class)
			.parameter(Class.class).INVOKE();
		code.LOADConst("params0");
		code.LOADConst(Type.getType("Lcn/sj1/tinyasm/core/advmagicbuilder/WithIdKey;"));
		code.INTERFACE(MethodHeader.class, "parameter")
			.return_(Object.class)
			.parameter(String.class)
			.parameter(Class.class).INVOKE();
		code.CHECKCAST(MethodHeader.class);
		code.INTERFACE(MethodHeader.class, "begin")
			.return_(MethodCode.class).INVOKE();
		code.STORE("code",MethodCode.class);

		code.LINE();
		code.LOAD("code");
		code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

		code.LINE();
		code.LOAD("code");
		code.LOADConst("this");
		code.VIRTUAL(MethodCode.class, "LOAD")
			.parameter(String.class).INVOKE();

		code.LINE();
		code.LOAD("code");
		code.LOADConst("params0");
		code.VIRTUAL(MethodCode.class, "LOAD")
			.parameter(String.class).INVOKE();

		code.LINE();
		code.LOAD("code");
		code.LOADConst(Type.getType("Lcn/sj1/tinyasm/core/advmagicbuilder/User;"));
		code.VIRTUAL(MethodCode.class, "CHECKCAST")
			.parameter(Class.class).INVOKE();

		code.LINE();
		code.LOAD("code");
		code.LOADConst("update");
		code.VIRTUAL(MethodCode.class, "VIRTUAL")
			.return_(MethodCaller.class)
			.parameter(String.class).INVOKE();
		code.LOADConst(Type.getType("Lcn/sj1/tinyasm/core/advmagicbuilder/User;"));
		code.INTERFACE(MethodCaller.class, "parameter")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.LOADConst(Type.getType("Ljava/lang/String;"));
		code.INTERFACE(MethodCaller.class, "return_")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.LOAD("code");
		code.VIRTUAL(MethodCode.class, "RETURNTop").INVOKE();

		code.LINE();
		code.LOAD("code");
		code.VIRTUAL(MethodCode.class, "END").INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _bridge_update(ClassBody classBody) {
		MethodCode code = classBody.method(ACC_PUBLIC | ACC_BRIDGE | ACC_SYNTHETIC, "update")
			.return_(Object.class )
			.parameter(ACC_SYNTHETIC,"param0",WithIdKey.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("param0");
		code.CHECKCAST(User.class);
		code.VIRTUAL("update")
			.return_(String.class)
			.parameter(User.class).INVOKE();
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
		code.LOADConst(Type.getType("Lcn/sj1/tinyasm/core/advmagicbuilder/WithIdKey;"));
		code.INTERFACE(MethodCaller.class, "parameter")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.LOADConst(Type.getType("Ljava/lang/Object;"));
		code.INTERFACE(MethodCaller.class, "return_")
			.return_(MethodCaller.class)
			.parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

		code.LINE();
		code.LOAD("c");
		code.LOADConst(Type.getType("Ljava/lang/String;"));
		code.VIRTUAL(MethodCode.class, "CHECKCAST")
			.parameter(Class.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
