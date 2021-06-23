package cn.sj1.tinyasm.core.sample.MethodCode;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;

import cn.sj1.tinyasm.core.Annotation;
import cn.sj1.tinyasm.core.ClassBody;
import cn.sj1.tinyasm.core.ClassBuilder;
import cn.sj1.tinyasm.core.Clazz;
import cn.sj1.tinyasm.core.LamdaMethodCaller;
import cn.sj1.tinyasm.core.MethodCode;

import java.io.PrintStream;
import java.util.function.Function;

@SuppressWarnings("unused")
public class MethodCodeMethodCallerLAMBDASampleTinyAsmBuilder {

	public static byte[] dump() throws Exception {
		return new MethodCodeMethodCallerLAMBDASampleTinyAsmBuilder().build("cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeMethodCallerLAMBDASample");
	}

	public byte[] build(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className)
				.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, "java.lang.invoke.MethodHandles", "Lookup");

		__init_(classBody);
		_exec(classBody);
		_method(classBody);
		_lambda$0(classBody);

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

	protected void _exec(ClassBody classBody) {
		MethodCode code = classBody.public_().method("exec").begin();

		code.LINE();
		//		code.LOAD("this");
		//		code.visitInvokeDynamicInsn("apply", "()Ljava/util/function/Function;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), new Object[]{Type.getType("(Ljava/lang/Object;)Ljava/lang/Object;"), new Handle(Opcodes.H_INVOKESTATIC, "cn/sj1/tinyasm/core/sample/MethodCode/MethodCodeMethodCallerLAMBDASample", "lambda$0", "(Ljava/lang/String;)Ljava/lang/String;", false), Type.getType("(Ljava/lang/String;)Ljava/lang/String;")});

		//		((LamdaMethodCaller) 
		code.VIRTUAL("lambda$0").parameter(String.class).return_(String.class)
				.LAMBDA(MethodCodeMethodCallerLAMBDASample.class, "apply").return_(Function.class)
				//						.lamdaType(Function.class)
				.INVOKE();

		code.STORE("func", Clazz.of(Function.class, Clazz.of(String.class), Clazz.of(String.class)));

		code.LINE();
		code.LOAD("this");
		code.LOAD("func");
		code.VIRTUAL("method")
				.parameter(Function.class).INVOKE();

		//		code.POP();
		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _method(ClassBody classBody) {
		MethodCode code = classBody.public_().method("method")
				.return_(Clazz.of(void.class))
				.parameter("data", Clazz.of(Function.class, Clazz.of(String.class), Clazz.of(String.class))).begin();

		code.LINE();
		code.LOAD("data");
		code.LOADConst("test");
		code.INTERFACE(Function.class, "apply")
				.return_(Object.class)
				.parameter(Object.class).INVOKE();
		code.CHECKCAST(String.class);
		code.STORE("s", String.class);

		code.LINE();
		code.GETSTATIC(System.class, "out", PrintStream.class);
		code.LOAD("s");
		code.VIRTUAL(PrintStream.class, "println")
				.parameter(String.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _lambda$0(ClassBody classBody) {
		MethodCode code = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, "lambda$0")
				.return_(String.class)
				.parameter("s", String.class).begin();

		code.LINE();
		code.LOAD("s");
		code.LOADConst(0);
		code.LOADConst(2);
		code.VIRTUAL(String.class, "substring")
				.return_(String.class)
				.parameter(int.class)
				.parameter(int.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

}
