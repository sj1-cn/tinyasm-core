package cn.sj1.tinyasm.core;

import static cn.sj1.tinyasm.core.Adv.of;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.signature.SignatureReader;

public class AdvAsmProxyMagicClassAdvAsmBuilder extends AdvAsmProxyClassAdvAsmBuilder {
	public static byte[] dumpMagic(Class<?> target, Class<?>[] actualTypeArguments, String proxyClassName) throws Exception {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

		AdvAsmProxyMagicClassAdvAsmBuilder bw = new AdvAsmProxyMagicClassAdvAsmBuilder(Opcodes.ASM9, cw);

		bw.dumpMagicClass(Clazz.of(target), of(t -> Clazz.of(t), actualTypeArguments), proxyClassName);

		return cw.toByteArray();
	}

	public static byte[] dumpMagic(Class<?> target, String proxyClassName) throws Exception {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

		AdvAsmProxyMagicClassAdvAsmBuilder bw = new AdvAsmProxyMagicClassAdvAsmBuilder(Opcodes.ASM9, cw);

		bw.dumpMagicClass(Clazz.of(target), new Clazz[] {}, proxyClassName);

		return cw.toByteArray();
	}

	protected void dumpMagicClass(ClazzSimple targetClazz, Clazz[] actualTypeArguments, String proxyClassName) throws IOException {
		this.isTargetClazzKnown = false;

		this.proxyClassName = proxyClassName;
		this.targetClazz = targetClazz;
		INTERFACE_OR_VIRTUAL = VIRTUAL;

		this.proxyActualTypeArguments = actualTypeArguments;

		ClassHeader ch = ClassBuilder.class_(cv, proxyClassName);
//		if(superName)
		if (actualTypeArguments.length > 0) {
			ch.extends_(Clazz.of(targetClazz, proxyActualTypeArguments));
		} else {
			ch.extends_(targetClazz);
		}
		ch.implements_(AdvMagicRuntime.class);
//		ch.access(access);
		proxyClassBody = ch.body();

		proxyClassBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, MethodHandles.class.getName(), "Lookup");

		proxyClassBody.private_().field("_magicNumber", Clazz.of(byte.class));
		proxyClassBody.private_().field("_contextThreadLocal", Clazz.of(ThreadLocal.class, Clazz.of(AdvContext.class)));
		proxyClassBody.private_().field("_targetClazz", Clazz.of(Clazz.class));

		__init_TargetClass(proxyClassBody, targetClazz);
		_get__MagicNumber(proxyClassBody);
		_set__MagicNumber(proxyClassBody);
		_set__Context(proxyClassBody);
		_set__TargetClazz(proxyClassBody);
		_get__TargetClazz(proxyClassBody);

		resolveClass(targetClazz, actualTypeArguments);
		doresolveClass(0);

		resolveMagicClass(targetClazz, actualTypeArguments);

		// 生成最终文件中的bridge方法。
		for (int i = proxyAllBridgeMethods.size() - 1; i >= 0; i--) {
			AdvAsmProxyBridgeMethod bridgeMethod = proxyAllBridgeMethods.get(i);
			String methodName = bridgeMethod.methodName;
			logger.debug("BridgeMethod -> {} {}", bridgeMethod.methodName, bridgeMethod.lowestClazz);
			if (methodName.startsWith("_") || methodName.startsWith("<") || methodName.startsWith("dump")) continue;
			if (this.targetClazz.getType().getClassName().equals(bridgeMethod.lowestClazz.getType().getClassName())) {
				logger.debug("BridgeMethod -> {}", bridgeMethod.methodName);
				buildBridgeMethodBuilder(proxyClassBody, bridgeMethod);
			}
		}
		finish();
	}

	public AdvAsmProxyMagicClassAdvAsmBuilder(int api) {
		super(api);
	}

	public AdvAsmProxyMagicClassAdvAsmBuilder(int api, ClassVisitor classVisitor) {
		super(api, classVisitor);
	}

//	ClazzSimple magicBuilderClazz;

//	protected <T> void dumpMagicClassWithTypeArguments(Class<T> magicBuilderClazz, TypeVariable<Class<T>>[] vs, String proxyClassName) throws IOException {

//
//		resolveMagicClass(this.magicBuilderClazz, typeArguments);
//
////		for (int i = proxyBridgeMethods.size() - 1; i >= 0; i--) {
////			BridgeMethod bridgeMethod = proxyBridgeMethods.get(i);
////			String methodName = bridgeMethod.methodName;
////			if (methodName.startsWith("_") || methodName.startsWith("<") || methodName.startsWith("dump")) continue;
////			if (this.magicBuilderClazz.getType().getClassName().equals(bridgeMethod.lowestClazz.getType().getClassName())) {
////				logger.debug("BridgeMethod -> {}", bridgeMethod.methodName);
////				buildBridgeMethodBuilder(proxyClassBody, bridgeMethod);
////			}
////		}
//
//		finish();
//	}

	protected void resolveMagicClass(Clazz target, Clazz[] actualTypeArguments) {
		Current last = this.current;
		this.current = new Current();
		current.clazz = targetClazz;
		current.actualTypeArguments = actualTypeArguments;

		try {
			ClassReader cr = new ClassReader(target.getType().getClassName());
			cr.accept(new ClassVisitor(Opcodes.ASM9) {

				@Override
				public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
					logger.debug("visit( {},  {},  {},  {}, [] exceptions)", access, name, signature, superName);
					if (signature != null) {
						ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
						SignatureReader sr = new SignatureReader(signature);
						sr.accept(classSignaturewwww);
						classSignaturewwww.finish();
						if (current.actualTypeArguments.length > 0) {
							for (int i = 0; i < classSignaturewwww.typeParamenterClazzes.length; i++) {
								Clazz clazz = classSignaturewwww.typeParamenterClazzes[i];
								if (clazz instanceof ClazzFormalTypeParameter) {
									ClazzFormalTypeParameter clazzFormalTypeParameter = (ClazzFormalTypeParameter) clazz;
									clazzFormalTypeParameter.setActualTypeArgument(current.actualTypeArguments[i]);
									current.classFormalTypeParameters.add(clazzFormalTypeParameter);
								}
							}
						}
					}
				}

				@Override
				public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
					if (name.startsWith("_") || name.startsWith("<") || access != ACC_PUBLIC) return null;

					AdvMethodInfo methodInfo = AdvMethodInfo.parseMethodInfo(descriptor, signature, current.classFormalTypeParameters);
					Clazz derivedReturnClazz = methodInfo.derivedReturnClazz;

					String derivedDescriptor = methodInfo.getDerivedMethodDescriptor();// AdvMethodInfo.getMethodDescriptor(derivedReturnClazz,
																						// methodInfo.derivedParamClazzes);

					String bridgeMethodTargetReferkey = name + derivedDescriptor;

					AdvAsmProxyBridgeMethod bm = proxyDefinedBridgeMethodes.get(bridgeMethodTargetReferkey);
					if (bm != null) {
						bm.lowestClazz = current.clazz;
					}

					MethodHeader mh = proxyClassBody.method(access, "$_" + name);

					mh.return_(derivedReturnClazz);

					for (int i = 0; i < methodInfo.originalParamTypes.length; i++) {
						mh.parameter("param" + i, methodInfo.derivedParamClazzes[i]);
					}
					if (exceptions != null && exceptions.length > 0) {
						mh.throws_(exceptions);
					}
					// if(ex)

					MethodCode code = mh.begin();
					code.LINE();
					code.LOAD("this");
					Clazz[] originalParamClazzes = new Clazz[methodInfo.originalParamTypes.length];
					for (int i = 0; i < methodInfo.originalParamTypes.length; i++) {
						originalParamClazzes[i] = Clazz.of(methodInfo.originalParamTypes[i]);
					}

					for (int i = 0; i < methodInfo.derivedParamClazzes.length; i++) {
						code.LOAD("param" + i);
						// if(params[i].getSort() == Type.LONG) {
						// code.CHECKCAST(long.class);
						// }
					}
					if (derivedReturnClazz.getType() != Type.VOID_TYPE) {
						code.SPECIAL(targetClazz, name).parameter(originalParamClazzes).return_(Clazz.of(methodInfo.originalReturnType)).INVOKE();
						if (!(derivedReturnClazz instanceof ClazzVariable) && methodInfo.originalReturnType != Type.VOID_TYPE && !methodInfo.originalReturnType.getInternalName().equals(derivedReturnClazz.getType().getInternalName())) {
							code.CHECKCAST(derivedReturnClazz);
						}
						code.RETURNTop();
					} else {
						code.SPECIAL(targetClazz, name).parameter(methodInfo.derivedParamClazzes).INVOKE();
						code.LINE();
						code.RETURN();
					}
					code.END();
					return null;
				}

			}, ClassReader.SKIP_CODE);
		} catch (IOException e) {
			throw new UnsupportedOperationException(e);
		}

		this.current = last;
	}

	@Override
	public MethodVisitor visitMethod(int access, String methodName, String descriptor, String signature, String[] exceptions) {
		if (methodName.startsWith("_") || methodName.startsWith("<") || methodName.startsWith("dump")) return null;

		return super.visitMethod(access, methodName, descriptor, signature, exceptions);
	}

	public void buildBridgeMethodBuilder(ClassBody classBody, AdvAsmProxyBridgeMethod bridgeMethod) {
		String methodName = bridgeMethod.methodName;
		Type originReturnType = bridgeMethod.originReturnType;
		Type[] originParamTypes = bridgeMethod.originParamTypes;
		Clazz targetReturnClazz = bridgeMethod.targetReturnClazz;
		Clazz[] targetParamClazzes = bridgeMethod.targetParamClazzes;
		String[] exceptions = bridgeMethod.exceptions;

		MethodCode code = classBody.public_().method("_" + methodName).parameter("classBody", ClassBody.class).begin();

		code_method(code, methodName);

		if (originReturnType != Type.VOID_TYPE) code_method_return(code, originReturnType);
//		if (exceptions != null) methodHeader.throws_(exceptions);
		if (originParamTypes != null) {
			for (int i = 0; i < originParamTypes.length; i++) {
				code_method_parameter(code, "params" + i, originParamTypes[i]);
			}
		}
		if (exceptions != null) {
			for (int i = 0; i < exceptions.length; i++) {
				String exceptionClassName = exceptions[i];
				code_method_throws(code, exceptionClassName);
			}
		}
		code_begin(code);

		code_line(code);
		code_load_this(code);

		if (originParamTypes != null) {
			for (int i = 0; i < originParamTypes.length; i++) {
				code_load(code, "params" + i);

				Type originType = originParamTypes[i];
				Clazz targetClazz = targetParamClazzes[i];
				if (!originType.equals(targetClazz.getType())) {
					code_checkcastParamType(code, targetClazz.getType());
				}
			}
		}

		code_invoke_virtual(methodName, code);
		if (targetParamClazzes != null) {
			for (int i = 0; i < targetParamClazzes.length; i++) {
				code_invoke_parameter(code, targetParamClazzes[i].getType());
			}
		}
		if (originReturnType != Type.VOID_TYPE) {
			code_invoke_return(code, targetReturnClazz.getType());
		}
		code_invoke_invoke(code);

		if (originReturnType != Type.VOID_TYPE) {
			code_returnTop(code);
		} else {
			code_returnVoid(code);

		}
		end(code);

		code.LINE();
		code.RETURN();

		code.END();

	}

	@SuppressWarnings("unchecked")
	static Type[] types = Adv.of(c -> Type.getType(c), boolean.class, char.class, byte.class, short.class, int.class, float.class, long.class, double.class);

	Type checkType(Type type) {
		int sort = type.getSort();
		if (Type.BOOLEAN <= sort && sort <= Type.DOUBLE) {
			return types[sort - 1];
		} else {
			return type;
		}
	}

	protected void code_returnTop(MethodCode code) {
		code.LINE();
		code.LOAD("code");
		code.VIRTUAL(MethodCode.class, "RETURNTop").INVOKE();
	}

	protected void code_begin(MethodCode code) {
		code.INTERFACE(MethodHeader.class, "begin").return_(MethodCode.class).INVOKE();
		code.STORE("code", MethodCode.class);
	}

	protected void code_method(MethodCode code, String methodName) {
		code.LINE();
		code.LOAD("classBody");
		code.LOADConst(4161);
		code.LOADConst(methodName);
		code.INTERFACE(ClassBody.class, "method").return_(MethodHeader.class).parameter(int.class).parameter(String.class).INVOKE();
	}

	protected void code_invoke_invoke(MethodCode code) {
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();
	}

	protected void code_invoke_return(MethodCode code, Type type) {
		_type(code, type);
		code.INTERFACE(MethodCaller.class, "return_").return_(MethodCaller.class).parameter(Class.class).INVOKE();
	}

	protected void code_invoke_virtual(String methodName, MethodCode code) {
		code.LINE();
		code.LOAD("code");
		code.LOADConst(methodName);
		code.VIRTUAL(MethodCode.class, "VIRTUAL").return_(MethodCaller.class).parameter(String.class).INVOKE();
	}

	protected void code_method_return(MethodCode code, Type type) {
		_type(code, type);
		code.INTERFACE(MethodHeader.class, "return_").return_(MethodHeader.class).parameter(Class.class).INVOKE();
	}

	protected void end(MethodCode code) {
		code.LINE();
		code.LOAD("code");
		code.VIRTUAL(MethodCode.class, "END").INVOKE();
	}

	protected void code_returnVoid(MethodCode code) {
		code.LINE();
		code.LOAD("code");
		code.VIRTUAL(MethodCode.class, "RETURN").INVOKE();
	}

	protected void code_invoke_parameter(MethodCode code, Type type) {
		_type(code, type);
		code.INTERFACE(MethodCaller.class, "parameter").return_(MethodCaller.class).parameter(Class.class).INVOKE();
	}

	protected void code_checkcastParamType(MethodCode code, Type type) {
		code.LINE();
		code.LOAD("code");
		_type(code, type);
		code.VIRTUAL(MethodCode.class, "CHECKCAST").parameter(Class.class).INVOKE();
	}

	protected void code_load(MethodCode code, String paramname) {
		code.LINE();
		code.LOAD("code");
		code.LOADConst(paramname);
		code.VIRTUAL(MethodCode.class, "LOAD").parameter(String.class).INVOKE();
	}

	protected void code_method_parameter(MethodCode code, String paramname, Type type) {
		code.LOADConst(paramname);
		_type(code, type);
		code.INTERFACE(MethodHeader.class, "parameter").return_(Object.class).parameter(String.class).parameter(Class.class).INVOKE();
		code.CHECKCAST(MethodHeader.class);
	}

	protected void _type(MethodCode code, Type type) {

		switch (type.getSort()) {
		case Type.BOOLEAN:
			code.GETSTATIC(Boolean.class, "TYPE", Class.class);
			break;
		case Type.BYTE:
			code.GETSTATIC(Byte.class, "TYPE", Class.class);
			break;
		case Type.CHAR:
			code.GETSTATIC(Character.class, "TYPE", Class.class);
			break;
		case Type.SHORT:
			code.GETSTATIC(Short.class, "TYPE", Class.class);
			break;
		case Type.INT:
			code.GETSTATIC(Integer.class, "TYPE", Class.class);
			break;
		case Type.FLOAT:
			code.GETSTATIC(Float.class, "TYPE", Class.class);
			break;
		case Type.LONG:
			code.GETSTATIC(Long.class, "TYPE", Class.class);
			break;
		case Type.DOUBLE:
			code.GETSTATIC(Double.class, "TYPE", Class.class);
			break;
		default:
			code.LOADConst(type);
		}

	}

	protected void code_method_throws(MethodCode code, String exceptionClassName) {
		code.LOADConst(exceptionClassName);
		code.INTERFACE(MethodHeader.class, "throws_").return_(MethodHeader.class).parameter(String.class).INVOKE();
	}

	protected void code_load_this(MethodCode code) {
		code.LINE();
		code.LOAD("code");
		code.LOADConst("this");
		code.VIRTUAL(MethodCode.class, "LOAD").parameter(String.class).INVOKE();
	}

	protected void code_line(MethodCode code) {
		code.LINE();
		code.LOAD("code");
		code.VIRTUAL(MethodCode.class, "LINE").INVOKE();
	}

	// protected <T> void dumpMagicClassWithTypeArguments(Class<T>
	// magicBuilderClazz, TypeVariable<Class<T>>[] vs, String proxyClassName) throws
	// IOException {

	//
	// resolveMagicClass(this.magicBuilderClazz, typeArguments);
	//
	//// for (int i = proxyBridgeMethods.size() - 1; i >= 0; i--) {
	//// BridgeMethod bridgeMethod = proxyBridgeMethods.get(i);
	//// String methodName = bridgeMethod.methodName;
	//// if (methodName.startsWith("_") || methodName.startsWith("<") ||
	// methodName.startsWith("dump")) continue;
	//// if
	// (this.magicBuilderClazz.getType().getClassName().equals(bridgeMethod.lowestClazz.getType().getClassName()))
	// {
	//// logger.debug("BridgeMethod -> {}", bridgeMethod.methodName);
	//// buildBridgeMethodBuilder(proxyClassBody, bridgeMethod);
	//// }
	//// }
	//
	// finish();
	// }

	protected void _set__TargetClazz(ClassBody classBody) {
		MethodCode code = classBody.public_().method("set__TargetClazz").parameter("_targetClazz", Clazz.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("_targetClazz");
		code.PUTFIELD_OF_THIS("_targetClazz");

		code.LINE();
		code.RETURN();

		code.END();
	}

	// protected <T> void dumpMagicClassWithTypeArguments(Class<T>
	// magicBuilderClazz, TypeVariable<Class<T>>[] vs, String proxyClassName) throws
	// IOException {

	//
	// resolveMagicClass(this.magicBuilderClazz, typeArguments);
	//
	//// for (int i = proxyBridgeMethods.size() - 1; i >= 0; i--) {
	//// BridgeMethod bridgeMethod = proxyBridgeMethods.get(i);
	//// String methodName = bridgeMethod.methodName;
	//// if (methodName.startsWith("_") || methodName.startsWith("<") ||
	// methodName.startsWith("dump")) continue;
	//// if
	// (this.magicBuilderClazz.getType().getClassName().equals(bridgeMethod.lowestClazz.getType().getClassName()))
	// {
	//// logger.debug("BridgeMethod -> {}", bridgeMethod.methodName);
	//// buildBridgeMethodBuilder(proxyClassBody, bridgeMethod);
	//// }
	//// }
	//
	// finish();
	// }

	// protected <T> void dumpMagicClassWithTypeArguments(Class<T>
	// magicBuilderClazz, TypeVariable<Class<T>>[] vs, String proxyClassName) throws
	// IOException {

	//
	// resolveMagicClass(this.magicBuilderClazz, typeArguments);
	//
	//// for (int i = proxyBridgeMethods.size() - 1; i >= 0; i--) {
	//// BridgeMethod bridgeMethod = proxyBridgeMethods.get(i);
	//// String methodName = bridgeMethod.methodName;
	//// if (methodName.startsWith("_") || methodName.startsWith("<") ||
	// methodName.startsWith("dump")) continue;
	//// if
	// (this.magicBuilderClazz.getType().getClassName().equals(bridgeMethod.lowestClazz.getType().getClassName()))
	// {
	//// logger.debug("BridgeMethod -> {}", bridgeMethod.methodName);
	//// buildBridgeMethodBuilder(proxyClassBody, bridgeMethod);
	//// }
	//// }
	//
	// finish();
	// }

	protected void _get__TargetClazz(ClassBody classBody) {
		MethodCode code = classBody.public_().method("get__TargetClazz").return_(Clazz.class).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_targetClazz");
		code.RETURNTop();
		code.END();
	}

	protected void _set__TypeArgument(ClassBody classBody) {
		MethodCode code = classBody.public_().method("set__TypeArgument").parameter("_arguments", Clazz.of(Clazz.of(Class.class, true), Clazz.typeArgument('*'))).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("_arguments");
		code.PUTFIELD_OF_THIS("_arguments");

		code.LINE();
		code.RETURN();

		code.END();
	}

}
