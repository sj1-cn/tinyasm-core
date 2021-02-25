package cc1sj.tinyasm.hero;

import cc1sj.tinyasm.MethodCode;

public interface TinyAsmProxyFactory {
	Object build(MethodCode code, String __referName);
}
