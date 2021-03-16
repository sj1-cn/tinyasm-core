package cc1sj.tinyasm;

import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.TypeVariable;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class AdvAsmProxyMagicClassAdvAsmBuilder extends AdvAsmProxyClassAdvAsmBuilder {

	public static byte[] dumpMagic(Class<?> magicBuilderClass, String proxyClassName) throws Exception {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

		AdvAsmProxyMagicClassAdvAsmBuilder bw = new AdvAsmProxyMagicClassAdvAsmBuilder(Opcodes.ASM9, cw);

		bw.dumpMagicClass(magicBuilderClass, proxyClassName);

		return cw.toByteArray();
	}

	public AdvAsmProxyMagicClassAdvAsmBuilder(int api) {
		super(api);
	}

	public AdvAsmProxyMagicClassAdvAsmBuilder(int api, ClassVisitor classVisitor) {
		super(api, classVisitor);
	}

	ClazzSimple magicBuilderClazz;

	protected <T> void dumpMagicClass(Class<T> magicBuilderClazz, String proxyClassName) throws IOException {
		TypeVariable<Class<T>>[] vs = magicBuilderClazz.getTypeParameters();
		if (vs.length > 0) {
			dumpMagicClassWithTypeArguments(magicBuilderClazz, vs, proxyClassName);
		} else {
			dumpMagicSimpleClass(magicBuilderClazz, proxyClassName);
		}
	}

	protected <T> void dumpMagicSimpleClass(Class<T> magicBuilderClazz, String proxyClassName) throws IOException {
		this.isTargetClazzKnown = false;
		this.proxyClassName = proxyClassName;
		this.magicBuilderClazz = Clazz.of(magicBuilderClazz);
		INTERFACE_OR_VIRTUAL = VIRTUAL;

		ClassHeader ch = ClassBuilder.class_(cv, proxyClassName);
		ch.extends_(magicBuilderClazz);
		Clazz[] actualTypeArguments = new Clazz[0];

		ch.extends_(magicBuilderClazz);

		ch.implements_(AdvMagicRuntime.class);

		proxyClassBody = ch.body();

		proxyClassBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, MethodHandles.class.getName(), "Lookup");

		proxyClassBody.private_().field("_magicNumber", Clazz.of(byte.class));
		proxyClassBody.private_().field("_contextThreadLocal", Clazz.of(ThreadLocal.class, Clazz.of(AdvContext.class)));
		proxyClassBody.private_().field("_targetClazz", Clazz.of(Clazz.class));

		__init_TargetClass(proxyClassBody, this.magicBuilderClazz);
		_get__MagicNumber(proxyClassBody);
		_set__MagicNumber(proxyClassBody);
		_set__Context(proxyClassBody);
		_set__TargetClazz(proxyClassBody);
		_get__TargetClazz(proxyClassBody);

		resolveClass(this.magicBuilderClazz, actualTypeArguments);

		resolveMagicClass(this.magicBuilderClazz, actualTypeArguments);
//
//		for (int i = proxyBridgeMethods.size() - 1; i >= 0; i--) {
//			BridgeMethod bridgeMethod = proxyBridgeMethods.get(i);
//			String methodName = bridgeMethod.methodName;
//			if (methodName.startsWith("_") || methodName.startsWith("<") || methodName.startsWith("dump")) continue;
//			if (this.magicBuilderClazz.getType().getClassName().equals(bridgeMethod.lowestClazz.getType().getClassName())) {
//				logger.debug("BridgeMethod -> {}", bridgeMethod.methodName);
//				buildBridgeMethodBuilder(proxyClassBody, bridgeMethod);
//			}
//		}

		finish();
	}

	protected <T> void dumpMagicClassWithTypeArguments(Class<T> magicBuilderClazz, TypeVariable<Class<T>>[] vs, String proxyClassName) throws IOException {
		this.isTargetClazzKnown = false;
		this.proxyClassName = proxyClassName;
		this.magicBuilderClazz = Clazz.of(magicBuilderClazz);
//		this.targetClazz = magicBuilderClazz;
//		this.targetClazz = Clazz.of(targetClassName);
		INTERFACE_OR_VIRTUAL = VIRTUAL;

		ClassHeader ch = ClassBuilder.class_(cv, proxyClassName);
		ch.extends_(magicBuilderClazz);
		Clazz[] typeArguments = new Clazz[0];
		Clazz[] tva = new Clazz[vs.length];
		typeArguments = new Clazz[vs.length];
		for (int i = 0; i < vs.length; i++) {
			TypeVariable<Class<T>> typeVariable = vs[i];

			java.lang.reflect.Type[] types = typeVariable.getBounds();
			logger.debug("typeVariable {}", types[0]);

			ch.formalTypeParameter(typeVariable.getName(), Clazz.of(types[0]));
			tva[i] = Clazz.typeVariableOf(typeVariable.getName());
			typeArguments[i] = Clazz.typeVariableOf(typeVariable.getName(), Clazz.of(types[0]));
		}
		this.withArguemnts = true;
		this.typeArguments = typeArguments;
		ch.extends_(Clazz.of(Clazz.of(magicBuilderClazz), tva));

		ch.implements_(AdvMagicRuntimeWithTypeArgument.class);

		proxyClassBody = ch.body();

		proxyClassBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, MethodHandles.class.getName(), "Lookup");

		proxyClassBody.private_().field("_magicNumber", Clazz.of(byte.class));
		proxyClassBody.private_().field("_contextThreadLocal", Clazz.of(ThreadLocal.class, Clazz.of(AdvContext.class)));
		proxyClassBody.private_().field("_targetClazz", Clazz.of(Clazz.class));
		proxyClassBody.private_().field("_arguments", Clazz.of(Clazz.of(Class.class,true),Clazz.typeArgument('*')));

		__init_TargetClass(proxyClassBody, this.magicBuilderClazz);
		_get__MagicNumber(proxyClassBody);
		_set__MagicNumber(proxyClassBody);
		_set__Context(proxyClassBody);
		_set__TargetClazz(proxyClassBody);
		_get__TargetClazz(proxyClassBody);
		_set__TypeArgument(proxyClassBody);

		resolveClass(this.magicBuilderClazz, typeArguments);

		resolveMagicClass(this.magicBuilderClazz, typeArguments);

//		for (int i = proxyBridgeMethods.size() - 1; i >= 0; i--) {
//			BridgeMethod bridgeMethod = proxyBridgeMethods.get(i);
//			String methodName = bridgeMethod.methodName;
//			if (methodName.startsWith("_") || methodName.startsWith("<") || methodName.startsWith("dump")) continue;
//			if (this.magicBuilderClazz.getType().getClassName().equals(bridgeMethod.lowestClazz.getType().getClassName())) {
//				logger.debug("BridgeMethod -> {}", bridgeMethod.methodName);
//				buildBridgeMethodBuilder(proxyClassBody, bridgeMethod);
//			}
//		}

		finish();
	}

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
	
	protected void _set__TypeArgument(ClassBody classBody) {
		MethodCode code = classBody.public_().method("set__TypeArgument").parameter("_arguments", Clazz.of(Clazz.of(Class.class,true),Clazz.typeArgument('*'))).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("_arguments");
		code.PUTFIELD_OF_THIS("_arguments");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _get__TargetClazz(ClassBody classBody) {
		MethodCode code = classBody.public_().method("get__TargetClazz").return_(Clazz.class).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_targetClazz");
		code.RETURNTop();
		code.END();
	}

	protected void resolveMagicClass(Clazz target, Clazz[] actualTypeArguments) {
		Current last = this.current;
		this.current = new Current();
//		current.targetClazz = target;
		current.actualTypeArguments = actualTypeArguments;

		try {
			ClassReader cr = new ClassReader(target.getType().getClassName());
			cr.accept(new ClassVisitor(Opcodes.ASM9) {

				@Override
				public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
					if (name.startsWith("_") || name.startsWith("<")) return null;
					extracted(access, name, descriptor, exceptions);
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

	protected void extracted(int access, String methodName, String descriptor, String[] exceptions) {
		if (access == ACC_PUBLIC) {
			MethodHeader mh = proxyClassBody.method(access, "$_" + methodName);

			Type returnType = Type.getReturnType(descriptor);
			Type[] params = Type.getArgumentTypes(descriptor);

			mh.return_(Clazz.of(returnType));

			for (int i = 0; i < params.length; i++) {
				mh.parameter("param" + i, Clazz.of(params[i]));
			}
			if (exceptions != null && exceptions.length > 0) {
				mh.throws_(exceptions);
			}
//			if(ex)

			MethodCode code = mh.begin();
			code.LINE();
			code.LOAD("this");
			Clazz[] clazzes = new Clazz[params.length];
			for (int i = 0; i < params.length; i++) {
				code.LOAD("param" + i);
				clazzes[i] = Clazz.of(params[i]);
//				if(params[i].getSort() == Type.LONG) {
//					code.CHECKCAST(long.class);
//				}
			}
			if (returnType != Type.VOID_TYPE) {
				code.SPECIAL(magicBuilderClazz, methodName).parameter(clazzes).return_(Clazz.of(returnType)).INVOKE();
				code.RETURNTop();
			} else {
				code.SPECIAL(magicBuilderClazz, methodName).parameter(clazzes).INVOKE();
				code.LINE();
				code.RETURN();
			}
			code.END();
		}
	}

	public void buildBridgeMethodBuilder(ClassBody classBody, BridgeMethod bridgeMethod) {
		String methodName = bridgeMethod.methodName;
		Type originReturnType = bridgeMethod.originReturnType;
		Type[] originParamTypes = bridgeMethod.originParamTypes;
		Clazz targetReturnClazz = bridgeMethod.targetReturnClazz;
		Clazz[] targetParamClazzes = bridgeMethod.targetParamClazzes;
		String[] exceptions = bridgeMethod.exceptions;

		MethodCode code = classBody.public_().method("$_" + methodName).parameter("classBody", ClassBody.class).begin();

		method(code, methodName);

		if (originReturnType != Type.VOID_TYPE) method_return(code, originReturnType);
//		if (exceptions != null) methodHeader.throws_(exceptions);
		if (originParamTypes != null) {
			for (int i = 0; i < originParamTypes.length; i++) {
				method_parameter(code, "params" + i, originParamTypes[i]);
			}
		}
		if (exceptions != null) {
			for (int i = 0; i < exceptions.length; i++) {
				String exceptionClassName = exceptions[i];
				method_throws(code, exceptionClassName);
			}
		}
		begin(code);

		line(code);
		load_this(code);

		if (originParamTypes != null) {
			for (int i = 0; i < originParamTypes.length; i++) {
				load(code, "params" + i);

				Type originType = originParamTypes[i];
				Clazz targetClazz = targetParamClazzes[i];
				if (!originType.equals(targetClazz.getType())) {
					checkcastParamType(code, targetClazz.getType());
				}
			}
		}

		invoke_virtual(methodName, code);
		if (targetParamClazzes != null) {
			for (int i = 0; i < targetParamClazzes.length; i++) {
				invoke_parameter(code, targetParamClazzes[i].getType());
			}
		}
		if (originReturnType != Type.VOID_TYPE) {
			invoke_return(code, targetReturnClazz.getType());
		}
		invoke_invoke(code);

		if (originReturnType != Type.VOID_TYPE) {
			returnTop(code);
		} else {
			returnVoid(code);

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

	protected void returnTop(MethodCode code) {
		code.LINE();
		code.LOAD("code");
		code.VIRTUAL(MethodCode.class, "RETURNTop").INVOKE();
	}

	protected void begin(MethodCode code) {
		code.INTERFACE(MethodHeader.class, "begin").return_(MethodCode.class).INVOKE();
		code.STORE("code", MethodCode.class);
	}

	protected void method(MethodCode code, String methodName) {
		code.LINE();
		code.LOAD("classBody");
		code.LOADConst(4161);
		code.LOADConst(methodName);
		code.INTERFACE(ClassBody.class, "method").return_(MethodHeader.class).parameter(int.class).parameter(String.class).INVOKE();
	}

	protected void invoke_invoke(MethodCode code) {
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();
	}

	protected void invoke_return(MethodCode code, Type type) {
		_type(code, type);
		code.INTERFACE(MethodCaller.class, "return_").return_(MethodCaller.class).parameter(Class.class).INVOKE();
	}

	protected void invoke_virtual(String methodName, MethodCode code) {
		code.LINE();
		code.LOAD("code");
		code.LOADConst(methodName);
		code.VIRTUAL(MethodCode.class, "VIRTUAL").return_(MethodCaller.class).parameter(String.class).INVOKE();
	}

	protected void method_return(MethodCode code, Type type) {
		_type(code, type);
		code.INTERFACE(MethodHeader.class, "return_").return_(MethodHeader.class).parameter(Class.class).INVOKE();
	}

	protected void end(MethodCode code) {
		code.LINE();
		code.LOAD("code");
		code.VIRTUAL(MethodCode.class, "END").INVOKE();
	}

	protected void returnVoid(MethodCode code) {
		code.LINE();
		code.LOAD("code");
		code.VIRTUAL(MethodCode.class, "RETURN").INVOKE();
	}

	protected void invoke_parameter(MethodCode code, Type type) {
		_type(code, type);
		code.INTERFACE(MethodCaller.class, "parameter").return_(MethodCaller.class).parameter(Class.class).INVOKE();
	}

	protected void checkcastParamType(MethodCode code, Type type) {
		code.LINE();
		code.LOAD("code");
		_type(code, type);
		code.VIRTUAL(MethodCode.class, "CHECKCAST").parameter(Class.class).INVOKE();
	}

	protected void load(MethodCode code, String paramname) {
		code.LINE();
		code.LOAD("code");
		code.LOADConst(paramname);
		code.VIRTUAL(MethodCode.class, "LOAD").parameter(String.class).INVOKE();
	}

	protected void method_parameter(MethodCode code, String paramname, Type type) {
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

	protected void method_throws(MethodCode code, String exceptionClassName) {
		code.LOADConst(exceptionClassName);
		code.INTERFACE(MethodHeader.class, "throws_").return_(MethodHeader.class).parameter(String.class).INVOKE();
	}

	protected void load_this(MethodCode code) {
		code.LINE();
		code.LOAD("code");
		code.LOADConst("this");
		code.VIRTUAL(MethodCode.class, "LOAD").parameter(String.class).INVOKE();
	}

	protected void line(MethodCode code) {
		code.LINE();
		code.LOAD("code");
		code.VIRTUAL(MethodCode.class, "LINE").INVOKE();
	}

}
