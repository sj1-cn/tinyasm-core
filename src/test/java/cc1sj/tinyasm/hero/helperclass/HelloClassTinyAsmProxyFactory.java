package cc1sj.tinyasm.hero.helperclass;

import cc1sj.tinyasm.HelloClassTinyAsmProxy;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.TinyAsmProxyRuntimeProxyFactory;

public class HelloClassTinyAsmProxyFactory implements TinyAsmProxyRuntimeProxyFactory {
	@Override
	public Object build(MethodCode code, String __referName) {
		HelloClassTinyAsmProxy proxy = new HelloClassTinyAsmProxy();
		proxy.__init(code, __referName);
		return proxy;
	}

}
