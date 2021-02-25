package cc1sj.tinyasm.hero.helperclass;

import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.hero.TinyAsmProxyFactory;

public class HelloClassTinyAsmProxyFactory implements TinyAsmProxyFactory {
	@Override
	public Object build(MethodCode code, String __referName) {
		return new HelloClassTinyAsmProxy(code, __referName);
	}

}
