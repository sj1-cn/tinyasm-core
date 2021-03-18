package cn.sj1.tinyasm;

import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;

import org.objectweb.asm.Type;

class AdvAsmProxyBridgeMethod {
	final String methodName;
	final Type originReturnType;
	final Type[] originParamTypes;
	final Clazz targetReturnClazz;
	final Clazz[] targetParamClazzes;
	final String[] exceptions;
	// TODO need remove from here
	public Clazz lowestClazz;

	public AdvAsmProxyBridgeMethod(String methodName, Type originReturnType, Type[] originParamTypes, Clazz targetReturnClazz, Clazz[] targetParamClazzes, String[] exceptions) {
		super();
		this.methodName = methodName;
		this.originReturnType = originReturnType;
		this.originParamTypes = originParamTypes;
		this.targetReturnClazz = targetReturnClazz;
		this.targetParamClazzes = targetParamClazzes;

		this.exceptions = exceptions;
	}

	public AdvAsmProxyBridgeMethod(String methodName, String description, String targetDescription, String[] exceptions) {
		super();
		this.methodName = methodName;
		this.originReturnType = Type.getReturnType(description);
		this.originParamTypes = Type.getArgumentTypes(description);
		this.targetReturnClazz = Clazz.of(Type.getReturnType(targetDescription));
		this.targetParamClazzes = Adv.of(t -> Clazz.of(t), Type.getArgumentTypes(targetDescription));

		this.exceptions = exceptions;
	}

	public void exec(ClassBody classBody) {
//			logger.debug("BridgeMethod {}", methodName);
		MethodHeader methodHeader = classBody.method(ACC_PUBLIC | ACC_BRIDGE | ACC_SYNTHETIC, methodName);
		if (originReturnType != Type.VOID_TYPE) methodHeader.return_(Clazz.of(originReturnType));
		if (exceptions != null) methodHeader.throws_(exceptions);

		for (int i = 0; i < originParamTypes.length; i++) {
			methodHeader.parameter("params" + i, Clazz.of(originParamTypes[i]));
		}
		MethodCode code = methodHeader.begin();

		code.LINE();
		code.LOAD("this");

		for (int i = 0; i < originParamTypes.length; i++) {
			code.LOAD("params" + i);

			Type originType = originParamTypes[i];
			Clazz targetClazz = targetParamClazzes[i];
			if (!originType.equals(targetClazz.getType())) {
				code.CHECKCAST(targetClazz);
			}
		}

		if (this.targetParamClazzes.length > 0) code.VIRTUAL(methodName).return_(targetReturnClazz).parameter(this.targetParamClazzes).INVOKE();
		else code.VIRTUAL(methodName).return_(targetReturnClazz).INVOKE();

		if (originReturnType != Type.VOID_TYPE) {
			code.RETURNTop();
		} else {
			code.RETURN();

		}

		code.END();
	}

	public static void makeBridgeMethod(ClassBody classBody, String methodName, String description, String targetDescription, String[] exceptions) {
		new AdvAsmProxyBridgeMethod(methodName, description, targetDescription, exceptions).exec(classBody);
	}

}