package cc1sj.tinyasm;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;

class TinyAsmProxyFactoryAsmBuilder {

	public static byte[] dump(String proxyClassName,String suffix) throws Exception {
		String proxyBuilderClassName = proxyClassName + suffix;
		ClassBody classBody = ClassBuilder.make(proxyBuilderClassName, null, TinyAsmProxyRuntimeProxyFactory.class).access(ACC_PUBLIC | ACC_SUPER).body();

		{
			MethodCode code = classBody.method("<init>").begin();

			code.LINE(5);
			code.LOAD("this");
			code.SPECIAL(Object.class, "<init>").INVOKE();
			code.RETURN();
			code.END();
		}

		{
			MethodCode code = classBody.method(Object.class, "build").parameter("code", MethodCode.class)
					.parameter("__referName", String.class).begin();

			code.LINE(8);
			code.NEW(proxyClassName);
			code.DUP();
			code.LOAD("code");
			code.LOAD("__referName");
			code.SPECIAL(proxyClassName, "<init>").parameter(MethodCode.class).parameter(String.class).INVOKE();
			code.RETURNTop();
			code.END();
		}

		return classBody.end().toByteArray();
	}
}
