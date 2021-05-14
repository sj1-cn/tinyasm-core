package cn.sj1.tinyasm.mixin;

import cn.sj1.tinyasm.core.Mixin;

public class SimpleGenericClass<T>  extends SimpleClass {
	public String getName(T t) {
		Mixin.__(code -> {
			String newname = Mixin.getParam(String.class);
			code.NEW(StringBuffer.class);
			code.DUP();
			code.LOAD("t");
			code.SPECIAL(StringBuffer.class, "<init>").parameter(String.class).INVOKE();
			code.LOADConst(newname);
			code.VIRTUAL(StringBuffer.class, "append").parameter(String.class).return_(StringBuffer.class).INVOKE();
			code.VIRTUAL(StringBuffer.class, "toString").return_(String.class).INVOKE();
			code.STORE("t");
		});
		return t.toString();
	}
}
