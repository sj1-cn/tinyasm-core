package cn.sj1.tinyasm.mixin;

import cn.sj1.tinyasm.core.MethodCode;

public class SimpleClassLambda {
	public static void lambda_getName_0(MethodCode code) throws Exception {
		code.NEW(StringBuffer.class);
		code.DUP();
		code.LOAD("name");
		code.SPECIAL(StringBuffer.class, "<init>").parameter(String.class).INVOKE();
		code.LOADConst("++");
		code.VIRTUAL(StringBuffer.class, "append").parameter(String.class).return_(StringBuffer.class).INVOKE();
		code.VIRTUAL(StringBuffer.class, "toString").return_(String.class).INVOKE();
		code.STORE("name");
	}
}
