package cc1sj.tinyasm;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_NUMBER;
import static cc1sj.tinyasm.Adv.MAGIC_CODES_String;
import static cc1sj.tinyasm.Adv.of;
import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_NATIVE;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.TypePath;
import org.objectweb.asm.signature.SignatureReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdvAsmProxyClassAdvAsmBuilder extends ClassVisitor {
	Logger logger = LoggerFactory.getLogger(getClass());

	public static byte[] dumpClass(Class<?> target, Class<?>[] actualTypeArguments, String proxyClassName) throws Exception {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

		AdvAsmProxyClassAdvAsmBuilder bw = new AdvAsmProxyClassAdvAsmBuilder(Opcodes.ASM9, cw);

		bw.dumpClass(Clazz.of(target), of(t -> Clazz.of(t), actualTypeArguments), proxyClassName);

		return cw.toByteArray();
	}

	public static byte[] dumpClass(Class<?> target, String proxyClassName) throws Exception {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

		AdvAsmProxyClassAdvAsmBuilder bw = new AdvAsmProxyClassAdvAsmBuilder(Opcodes.ASM9, cw);

		bw.dumpClass(Clazz.of(target), new Clazz[] {}, proxyClassName);

		return cw.toByteArray();
	}

	public static byte[] dumpInterface(Class<?> target, Class<?>[] actualTypeArguments, String proxyClassName) throws Exception {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

		AdvAsmProxyClassAdvAsmBuilder bw = new AdvAsmProxyClassAdvAsmBuilder(Opcodes.ASM9, cw);

		bw.dumpInterface(Clazz.of(target), of(t -> Clazz.of(t), actualTypeArguments), proxyClassName);

		return cw.toByteArray();
	}

	public static byte[] dumpInterface(Class<?> target, String proxyClassName) throws Exception {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

		AdvAsmProxyClassAdvAsmBuilder bw = new AdvAsmProxyClassAdvAsmBuilder(Opcodes.ASM9, cw);

		bw.dumpInterface(Clazz.of(target), new Clazz[] {}, proxyClassName);

		return cw.toByteArray();
	}

	ClassBody proxyClassBody;
	String proxyClassName;
	static final String INTERFACE = "INTERFACE";
	static final String VIRTUAL = "VIRTUAL";
	String INTERFACE_OR_VIRTUAL = VIRTUAL;
	boolean withDyncArguemnts = false;
	Clazz[] typeDyncArguments;

	List<LambdaBuilder> proxyLambdas = new ArrayList<>();
	List<BridgeMethod> proxyAllBridgeMethods = new ArrayList<>();
	Map<String, BridgeMethod> proxyDefinedBridgeMethodes = new HashMap<>();
	Map<String, String> proxyDefinedMethodes = new HashMap<>();

	Current current;
	Clazz targetClazz;
	boolean isTargetClazzKnown = true;

	Clazz[] proxyActualTypeArguments;

	class Current {
		Clazz[] actualTypeArguments;
		List<ClazzFormalTypeParameter> classFormalTypeParameters = new ArrayList<>();
		List<BridgeMethod> bridgeMethods = new ArrayList<>();
		public Clazz clazz;
		public String currentName;
	}

	public AdvAsmProxyClassAdvAsmBuilder(int api) {
		super(api);
	}

	public AdvAsmProxyClassAdvAsmBuilder(int api, ClassVisitor classVisitor) {
		super(api, classVisitor);
	}

	protected void dumpClass(ClazzSimple targetClazz, Clazz[] actualTypeArguments, String proxyClassName) throws IOException {
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
		ch.implements_(AdvRuntimeReferNameObject.class);
//		ch.access(access);
		proxyClassBody = ch.body();

		proxyClassBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, MethodHandles.class.getName(), "Lookup");

		proxyClassBody.private_().field("_magicNumber", Clazz.of(byte.class));
		proxyClassBody.private_().field("_contextThreadLocal", Clazz.of(ThreadLocal.class, Clazz.of(AdvContext.class)));

		__init_TargetClass(proxyClassBody, targetClazz);
		_get__MagicNumber(proxyClassBody);
		_set__MagicNumber(proxyClassBody);
		_set__Context(proxyClassBody);
		_get__TargetClazz(proxyClassBody);

		resolveClass(targetClazz, actualTypeArguments);
		doresolveClass(0);

		finish();
	}

	protected void dumpInterface(ClazzSimple targetClazz, Clazz[] actualTypeArguments, String proxyClassName) throws IOException {
		this.proxyClassName = proxyClassName;
		this.targetClazz = targetClazz;
		INTERFACE_OR_VIRTUAL = INTERFACE;

		this.proxyActualTypeArguments = actualTypeArguments;

		ClassHeader ch = ClassBuilder.class_(cv, proxyClassName);
//		if(superName)
		if (actualTypeArguments.length > 0) {
			ch.implements_(Clazz.of(targetClazz, actualTypeArguments));
		} else {
			ch.implements_(targetClazz);
		}
		ch.implements_(AdvRuntimeReferNameObject.class);
//		ch.access(access);
		proxyClassBody = ch.body();

		proxyClassBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, MethodHandles.class.getName(), "Lookup");

		proxyClassBody.private_().field("_magicNumber", Clazz.of(byte.class));
		proxyClassBody.private_().field("_contextThreadLocal", Clazz.of(ThreadLocal.class, Clazz.of(AdvContext.class)));

		__init_TargetClass(proxyClassBody, Clazz.of(Object.class));
		_get__MagicNumber(proxyClassBody);
		_set__MagicNumber(proxyClassBody);
		_set__Context(proxyClassBody);
		_get__TargetClazz(proxyClassBody);

		resolveClass(targetClazz, actualTypeArguments);
		doresolveClass(0);

		finish();
	}

	int lastIndex = 0;

	List<Clazz> resolveTargetClassList = new ArrayList<>();
	List<Clazz[]> resolveactualTypeArgumentsList = new ArrayList<>();

	protected void resolveClass(Clazz target, Clazz[] actualTypeArguments) {
		resolveTargetClassList.add(target);
		resolveactualTypeArgumentsList.add(actualTypeArguments);
	}

	protected void doresolveClass(int index) {
		Clazz target = resolveTargetClassList.get(index);
		Clazz[] actualTypeArguments = resolveactualTypeArgumentsList.get(index);
		Current last = this.current;
		this.current = new Current();
		this.current.clazz = target;
//		current.targetClazz = target;
		current.actualTypeArguments = actualTypeArguments;

		try {
			ClassReader cr = new ClassReader(target.getType().getClassName());
			cr.accept(this, ClassReader.SKIP_CODE);
		} catch (IOException e) {
			throw new UnsupportedOperationException(e);
		}
		this.proxyAllBridgeMethods.addAll(0, current.bridgeMethods);

		this.current = last;

		if (index + 1 < resolveTargetClassList.size()) {
			doresolveClass(index + 1);
		}

	}

	public void finish() {
		for (int i = proxyAllBridgeMethods.size() - 1; i >= 0; i--) {
			proxyAllBridgeMethods.get(i).exec(proxyClassBody);
		}

		for (int i = proxyLambdas.size() - 1; i >= 0; i--) {
			proxyLambdas.get(i).exec(proxyClassBody);
		}
	}

	protected void __init_TargetClass(ClassBody classBody, Clazz targetClazz) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(targetClazz, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		logger.debug("visit( {},  {},  {},  {}, [] exceptions)", access, name, signature, superName);
		current.currentName = name;
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

			for (int i = 0; i < current.classFormalTypeParameters.size(); i++) {// FOR DEBUG DELETE WHEN FINISHED
				ClazzFormalTypeParameter p = current.classFormalTypeParameters.get(i);
				logger.debug("visit {} -> {} {}  {}  {}", name, p.name, p.clazz, p.actualClazz, signature);
			}
			if (!classSignaturewwww.superClazz.getType().getClassName().equals(Object.class.getName())) {
				Clazz superClazz = classSignaturewwww.superClazz;
				if (superClazz instanceof ClazzSimple) {
					resolveClass(superClazz, new Clazz[0]);
				} else if (superClazz instanceof ClazzWithTypeArguments) {
					Clazz[] interfaceClazzTypeArguments = resolveTypeArguments(superClazz);
					resolveClass(superClazz, interfaceClazzTypeArguments);
				}
			}

			if (classSignaturewwww.interfaceClazzes.length > 0) {
				for (Clazz interfaceClazz : classSignaturewwww.interfaceClazzes) {
					logger.debug(interfaceClazz.toString());
					if (interfaceClazz instanceof ClazzWithTypeArguments) {
						Clazz[] interfaceClazzTypeArguments = resolveTypeArguments(interfaceClazz);
						resolveClass(interfaceClazz, interfaceClazzTypeArguments);
					}
				}
			}

		} else {
			if (superName != null && !superName.equals(Type.getType(Object.class).getInternalName())) {
				resolveClass(Clazz.of(Type.getObjectType(superName)), new Clazz[0]);
			}

			if (interfaces != null && interfaces.length > 0) {
				for (String interfaceInternameName : interfaces) {
					resolveClass(Clazz.of(Type.getObjectType(interfaceInternameName)), new Clazz[0]);
				}
			}
		}

	}

	protected Clazz[] resolveTypeArguments(Clazz interfaceClazz) {
		Clazz[] interfaceClazzTypeArguments;
		ClazzTypeArgument[] typeArguments = ((ClazzWithTypeArguments) interfaceClazz).getTypeArguments();
		interfaceClazzTypeArguments = new Clazz[typeArguments.length];
		for (int j = 0; j < typeArguments.length; j++) {
			ClazzTypeArgument clazzTypeArgument = typeArguments[j];

//			logger.debug(clazzTypeArgument.toString());
			Clazz argumentClazz = clazzTypeArgument.clazz;
			if (argumentClazz instanceof ClazzVariable) {
				for (ClazzFormalTypeParameter clazzFormalTypeParameter : current.classFormalTypeParameters) {
					if (clazzFormalTypeParameter.name.equals(((ClazzVariable) argumentClazz).name)) {
						interfaceClazzTypeArguments[j] = clazzFormalTypeParameter.getActualClazz();
						break;
					}
				}
			} else if (argumentClazz instanceof ClazzSimple) {
				interfaceClazzTypeArguments[j] = argumentClazz;
			} else {
				throw new UnsupportedOperationException("暂时还没有支持");
			}
		}
		return interfaceClazzTypeArguments;
	}

	@Override
	public MethodVisitor visitMethod(int access, String methodName, String descriptor, String signature, String[] exceptions) {
		logger.debug("visitMethod(int {}, String {}, String {}, String {}, String[] exceptions)", access, methodName, descriptor, signature);
		if (methodName.equals("<init>") || methodName.equals("<clinit>") || (access & (ACC_STATIC | ACC_PRIVATE | ACC_SYNTHETIC | ACC_NATIVE | ACC_BRIDGE)) != 0) {
			return null;
		}

		for (int i = 0; i < current.classFormalTypeParameters.size(); i++) {// FOR DEBUG DELETE WHEN FINISHED
			ClazzFormalTypeParameter p = current.classFormalTypeParameters.get(i);
			logger.debug("visitMethod {}.{}-> {} {} {} {} ", current.currentName, methodName, p.name, p.clazz, p.actualClazz, signature);
		}

		AdvMethodInfo methodInfo = AdvMethodInfo.parseMethodInfo(descriptor, signature, current.classFormalTypeParameters);

		ClazzFormalTypeParameter[] methodFormalTypeParameters = signature != null ? (ClazzFormalTypeParameter[]) methodInfo.typeParamenterClazzes : new ClazzFormalTypeParameter[0];

		String derivedDescriptor = methodInfo.getDerivedMethodDescriptor();
		String derivedSignature = methodInfo.getDerivedMethodSignature(methodFormalTypeParameters);

		String bridgeMethodTargetReferkey = methodName + derivedDescriptor;
		if (methodInfo.needBridge && methodFormalTypeParameters.length == 0) {
			String bridgeMethodReferkey = methodName + descriptor;
			if (!proxyDefinedMethodes.containsKey(bridgeMethodReferkey)) {
				BridgeMethod bm = new BridgeMethod(methodName, methodInfo.originalReturnType, methodInfo.originalParamTypes, methodInfo.derivedReturnClazz, methodInfo.derivedParamClazzes, exceptions);
				bm.lowestClazz = current.clazz;
				current.bridgeMethods.add(bm);
				proxyDefinedMethodes.put(bridgeMethodReferkey, bridgeMethodReferkey);
				proxyDefinedBridgeMethodes.put(bridgeMethodTargetReferkey, bm);
			}
		}

		BridgeMethod bm = proxyDefinedBridgeMethodes.get(bridgeMethodTargetReferkey);
		if (bm != null) {
			bm.lowestClazz = current.clazz;
		}

		String referkey = methodName + derivedDescriptor + derivedSignature;
		if (proxyDefinedMethodes.containsKey(referkey)) {
			return null;
		}
		proxyDefinedMethodes.put(referkey, referkey);

		Clazz derivedReturnClazz = methodInfo.derivedReturnClazz;

		MethodHeader mh = proxyClassBody.method(ACC_PUBLIC, methodName).return_(derivedReturnClazz);

		if (methodFormalTypeParameters.length > 0) {
			for (ClazzFormalTypeParameter clazz : methodFormalTypeParameters) {
				mh.formalTypeParameter(clazz);
			}
		}

		for (int i = 0; i < methodInfo.derivedParamClazzes.length; i++) {
			mh.parameter("param" + i, methodInfo.derivedParamClazzes[i]);
		}

		if (exceptions != null) for (String e : exceptions) mh.throws_(Clazz.of(Type.getObjectType(e)));

		MethodCode code = mh.begin();

		code_getContext(code);// AdvContext context = _contextThreadLocal.get();
		// resolve parameters ConsumerWithException<MethodCode> eval_param0 =
		// context.resolve(param0);
		for (int i = methodInfo.derivedParamClazzes.length - 1; i >= 0; i--) {
			if (Type.BOOLEAN_TYPE == methodInfo.derivedParamClazzes[i].getType() || Boolean.class.getName().equals(methodInfo.derivedParamClazzes[i].getType().getClassName())) {
				code.LINE();
				code.LOAD("context");
				code.VIRTUAL(AdvContext.class, "getCodeAndPop").return_(ConsumerWithException.class).INVOKE();
				code.STORE("eval_param" + i, Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));
			} else {
				code_resolve("eval_param" + i, code, "param" + i, methodInfo.derivedParamClazzes[i].getType());
			}
		}
		// resolve this
		code_resolve_this("objEval", code);// ConsumerWithException<MethodCode> objEval = context.resolve(this);

		// LOAD All Parameter
		code.LINE();
		code.LOAD("context");
		if (derivedReturnClazz.getType() != Type.VOID_TYPE) {
//			if (!isGenericMethod) {
//				if (isWithTypeArgument) {
//					loadType(code,originalReturnType, signatureReturnClazz);
//				} else {
//					loadType(code, originalReturnType);
//				}
//			} else {
//				loadType(code, derivedReturnClazz);
//			}
			loadType(code, derivedReturnClazz);
		}

		if (!isTargetClazzKnown) {
			code.LOAD("this");
		}

		String[] lambdaEvalParamNames = new String[methodInfo.derivedParamClazzes.length + 1];
		code.LOAD("objEval");
		lambdaEvalParamNames[0] = "objEval";
		for (int i = 0; i < methodInfo.derivedParamClazzes.length; i++) {
			code.LOAD("eval_param" + i);
			lambdaEvalParamNames[i + 1] = "eval_param" + i;
		}

//		Clazz targetClazz = current.targetClazz;

		// invoke method
		String lambdaName = pushLambda(lambdaEvalParamNames, methodName, c -> {
			if (isTargetClazzKnown) {
				c.LINE();
				c.LOAD("c");
				c.LOADConst(targetClazz);
				c.LOADConst(methodName);
				c.VIRTUAL(MethodCode.class, INTERFACE_OR_VIRTUAL).return_(MethodCaller.class).parameter(Class.class).parameter(String.class).INVOKE();
			} else {
				c.LINE();
				c.LOAD("c");
				c.LOAD("this");
				c.GETFIELD_OF_THIS("_targetClazz");
				c.LOADConst(methodName);
				c.VIRTUAL(MethodCode.class, INTERFACE_OR_VIRTUAL).return_(MethodCaller.class).parameter(Clazz.class).parameter(String.class).INVOKE();
			}
			if (this.proxyActualTypeArguments.length > 0) {
				for (int i = 0; i < methodInfo.originalParamTypes.length; i++) {
					Type originalParamType = methodInfo.originalParamTypes[i];
//					Clazz signatureParamType = signatureParamsClazzes[i];
					Clazz derivedParamType = methodInfo.derivedParamClazzes[i];
					logger.debug("original: {} derived: {} ", originalParamType, derivedParamType);
					loadType(c, originalParamType);
					c.INTERFACE(MethodCaller.class, "parameter").return_(MethodCaller.class).parameter(Class.class).INVOKE();
				}
			} else {
				for (Clazz type : methodInfo.derivedParamClazzes) {
					loadType(c, type);
					c.INTERFACE(MethodCaller.class, "parameter").return_(MethodCaller.class).parameter(Class.class).INVOKE();
				}
			}

			if (this.proxyActualTypeArguments.length > 0) {
				if (methodInfo.originalReturnType != Type.VOID_TYPE) {
					loadType(c, methodInfo.originalReturnType);
					c.INTERFACE(MethodCaller.class, "return_").return_(MethodCaller.class).parameter(Class.class).INVOKE();
				}
			} else {
				if (methodInfo.originalReturnType != Type.VOID_TYPE) {
					loadType(c, derivedReturnClazz);
					c.INTERFACE(MethodCaller.class, "return_").return_(MethodCaller.class).parameter(Class.class).INVOKE();
				}
			}

			c.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();
//			if (INTERFACE_OR_VIRTUAL == INTERFACE) {
			if (this.proxyActualTypeArguments.length > 0) {
				if (!(derivedReturnClazz instanceof ClazzVariable) && methodInfo.originalReturnType != Type.VOID_TYPE && !methodInfo.originalReturnType.getInternalName().equals(derivedReturnClazz.getType().getInternalName())) {
					c.LINE();
					c.LOAD("c");
					c.LOADConst(derivedReturnClazz);
					c.VIRTUAL(MethodCode.class, "CHECKCAST").parameter(Class.class).INVOKE();
				}
			}
//			}
		});

		if (isTargetClazzKnown) {
			dynamicInvoke(code, methodInfo.derivedParamClazzes.length, proxyClassName.replace('.', '/'), lambdaName);
		} else {
			dynamicInvokeWithThis(code, methodInfo.derivedParamClazzes.length, proxyClassName.replace('.', '/'), lambdaName);
		}

		code.stackPush(Type.getType(ConsumerWithException.class));

		if (derivedReturnClazz.getType() != Type.VOID_TYPE) {
			code.VIRTUAL(AdvContext.class, "push").return_(byte.class).parameter(Class.class).parameter(ConsumerWithException.class).INVOKE();
		} else {
			code.VIRTUAL(AdvContext.class, "execLine").parameter(ConsumerWithException.class).INVOKE();
		}

		// Refer
		if (methodFormalTypeParameters.length == 0 && derivedReturnClazz.getType() != Type.VOID_TYPE) {
			if (!(derivedReturnClazz instanceof ClazzVariable)) {
//				code.CONVERTTO(returnClazz);
				if (Type.BOOLEAN_TYPE == derivedReturnClazz.getType()) {
					code.POP();
					code.LINE();
					code.LOADConst(0);
					code.RETURNTop();
				} else if (Boolean.class.getName().equals(derivedReturnClazz.getType().getClassName())) {
					code.POP();

					code.LINE();
					code.LOADConst(0);
					code.STATIC(Boolean.class, "valueOf").return_(Boolean.class).parameter(boolean.class).INVOKE();
					code.RETURNTop();
				} else if (BoxUnbox.ClazzObjectToPrimitive.containsKey(derivedReturnClazz.getType())) {
					code.STORE("codeIndex", byte.class);
					code.LINE();
					code.LOADConst(MAGIC_CODES_NUMBER);
					code.LOAD("codeIndex");
					code.ADD();
					Type primitiveType = BoxUnbox.ClazzObjectToPrimitive.get(derivedReturnClazz.getType());
					code.CONVERTTO(primitiveType);
					BoxUnbox.PrimaryToBoxFunc.get(primitiveType).accept(code);
					code.RETURNTop();
				} else if (BoxUnbox.PrimativeToClazzObject.containsKey(derivedReturnClazz.getType())) {
					code.STORE("codeIndex", byte.class);
					code.LINE();
					code.LOADConst(MAGIC_CODES_NUMBER);
					code.LOAD("codeIndex");
					code.ADD();
					code.CONVERTTO(derivedReturnClazz);
					code.RETURNTop();
				} else if (derivedReturnClazz.getType().getSort() == Type.OBJECT && derivedReturnClazz.getType().equals(Type.getType(String.class))) {
					code.STORE("codeIndex", byte.class);
					code.LINE();
					code.NEW(StringBuilder.class);
					code.DUP();
					code.LOADConst(MAGIC_CODES_String);
					code.SPECIAL(StringBuilder.class, "<init>").parameter(String.class).INVOKE();
					code.LOAD("codeIndex");
					code.VIRTUAL(StringBuilder.class, "append").return_(StringBuilder.class).parameter(int.class).INVOKE();
					code.VIRTUAL(StringBuilder.class, "toString").return_(String.class).INVOKE();
					code.RETURNTop();
				} else if (derivedReturnClazz.getType().getSort() == Type.OBJECT) {
					code.STORE("codeIndex", byte.class);

					if (derivedReturnClazz instanceof ClazzSimple) {
						code.LINE();
						code.LOADConst(80);
						code.LOAD("codeIndex");
						code.ADD();
						code.CONVERTTO(byte.class);
						code.STORE("magicNumber", byte.class);

						code.LINE();
						code.LOADConst(derivedReturnClazz);
						code.STATIC(Adv.class, "canProxy").return_(boolean.class).parameter(Class.class).INVOKE();
						Label label5OfIFEQ = new Label();
						code.IFEQ(label5OfIFEQ);

						code.LINE();
						code.LOADConst(derivedReturnClazz);
						code.LOAD("magicNumber");
						code.STATIC(Adv.class, "buildProxyClass").return_(Object.class).parameter(Class.class).parameter(byte.class).INVOKE();
						code.CHECKCAST(derivedReturnClazz);
						code.RETURNTop();

						code.visitLabel(label5OfIFEQ);

						code.LINE();
						code.LOADConstNULL();
						code.RETURNTop();
					} else if (derivedReturnClazz instanceof ClazzWithTypeArguments) {

						code.LINE();
						code.LOADConst(80);
						code.LOAD("codeIndex");
						code.ADD();
						code.CONVERTTO(byte.class);
						code.STORE("magicNumber", byte.class);

						ClazzTypeArgument[] genericParameterClazz = ((ClazzWithTypeArguments) derivedReturnClazz).getTypeArguments();

						code.LINE();
						code.LOADConst(derivedReturnClazz);
						code.STATIC(Adv.class, "canProxy").return_(boolean.class).parameter(Class.class).INVOKE();
						Label label5OfIFEQ = new Label();
						code.IFEQ(label5OfIFEQ);

						code.LINE();
						code.LOADConst(derivedReturnClazz);
						Class<?>[] paramsclasses = new Class[genericParameterClazz.length];
						for (int i = 0; i < genericParameterClazz.length; i++) {
							ClazzTypeArgument clazz = genericParameterClazz[i];
							code.LOADConst(((ClazzTypeArgument) clazz).clazz);
							paramsclasses[i] = Class.class;
						}

						code.LOAD("magicNumber");
						code.STATIC(Adv.class, "buildProxyClass").return_(Object.class).parameter(Class.class).parameter(paramsclasses).parameter(byte.class).INVOKE();
						code.CHECKCAST(derivedReturnClazz);
						code.RETURNTop();

						code.visitLabel(label5OfIFEQ);

						code.LINE();
						code.LOADConstNULL();
						code.RETURNTop();
					} else {
						logger.debug(derivedReturnClazz.signatureOf());
					}

				} else if (derivedReturnClazz.getType().getSort() == Type.ARRAY) {

					Type elementType = derivedReturnClazz.getType().getElementType();

					if (Type.BOOLEAN_TYPE == elementType) {
						code.POP();

						code.LINE();
						code.LOADConst(1);
						code.NEWARRAY(elementType);
						code.STORE("tarray");

						code.LINE();
						code.LOAD("tarray");
						code.LOADConst(0);
						code.LOADConst(0);
						code.ARRAYSTORE();

						code.LINE();
						code.LOAD("tarray");
						code.RETURNTop();
					} else if (Boolean.class.getName().equals(elementType.getClassName())) {
//					code.STORE("codeIndex", byte.class);
						code.POP();

						code.LINE();
						code.LOADConst(1);
						code.NEWARRAY(elementType);
						code.STORE("tarray");

						code.LINE();
						code.LOAD("tarray");
						code.LOADConst(0);
						code.LOADConst(0);
						code.STATIC(Boolean.class, "valueOf").return_(Boolean.class).parameter(boolean.class).INVOKE();
						code.ARRAYSTORE();

						code.LINE();
						code.LOAD("tarray");
						code.RETURNTop();
					} else if (BoxUnbox.ClazzObjectToPrimitive.containsKey(elementType)) {
						code.STORE("codeIndex", byte.class);

						code.LINE();
						code.LOADConst(MAGIC_CODES_NUMBER);
						code.LOAD("codeIndex");
						code.ADD();
						code.STORE("magicNumber", int.class);

						code.LINE();
						code.LOADConst(1);
						code.NEWARRAY(elementType);
						code.STORE("tarray");

						code.LINE();
						code.LOAD("tarray");
						code.LOADConst(0);
						code.LOAD("magicNumber");
						Type primitiveType = BoxUnbox.ClazzObjectToPrimitive.get(elementType);
						code.CONVERTTO(primitiveType);
						BoxUnbox.PrimaryToBoxFunc.get(primitiveType).accept(code);
						code.ARRAYSTORE();

						code.LINE();
						code.LOAD("tarray");
						code.RETURNTop();
					} else if (BoxUnbox.PrimativeToClazzObject.containsKey(elementType)) {
						code.STORE("codeIndex", byte.class);

						code.LINE();
						code.LOADConst(MAGIC_CODES_NUMBER);
						code.LOAD("codeIndex");
						code.ADD();
						code.STORE("magicNumber");

						code.LINE();
						code.LOADConst(1);
						code.NEWARRAY(elementType);
						code.STORE("tarray");

						code.LINE();
						code.LOAD("tarray");
						code.LOADConst(0);
						code.LOAD("magicNumber");
						code.CONVERTTO(elementType);
						code.ARRAYSTORE();

						code.LINE();
						code.LOAD("tarray");
						code.RETURNTop();
					} else if (elementType.getSort() == Type.OBJECT && elementType.equals(Type.getType(String.class))) {
						code.STORE("codeIndex", byte.class);

						code.LINE();
						code.NEW(StringBuilder.class);
						code.DUP();
						code.LOADConst(MAGIC_CODES_String);
						code.SPECIAL(StringBuilder.class, "<init>").parameter(String.class).INVOKE();
						code.LOAD("codeIndex");
						code.VIRTUAL(StringBuilder.class, "append").return_(StringBuilder.class).parameter(int.class).INVOKE();
						code.VIRTUAL(StringBuilder.class, "toString").return_(String.class).INVOKE();
						code.STORE("magicNumber", String.class);

						code.LINE();
						code.LOADConst(1);
						code.NEWARRAY(String.class);
						code.STORE("tarray", String[].class);

						code.LINE();
						code.LOAD("tarray");
						code.LOADConst(0);
						code.LOAD("magicNumber");
						code.ARRAYSTORE();

						code.LINE();
						code.LOAD("tarray");
						code.RETURNTop();
					} else if (elementType.getSort() == Type.OBJECT) {
						code.STORE("codeIndex", byte.class);

						code.LINE();
						code.LOADConst(MAGIC_CODES_NUMBER);
						code.LOAD("codeIndex");
						code.ADD();
						code.CONVERTTO(byte.class);
						code.STORE("magicNumber", byte.class);

						code.LINE();
						code.LOADConstNULL();
						code.STORE("simplePojoClassSample", elementType);

						code.LINE();
						code.LOADConst(1);
						code.NEWARRAY(elementType);
						code.STORE("tarray");

						code.LINE();
						code.LOADConst(elementType);
						code.STATIC(Adv.class, "canProxy").return_(boolean.class).parameter(Class.class).INVOKE();
						Label label7OfIFEQ = new Label();
						code.IFEQ(label7OfIFEQ);

						code.LINE();
						code.LOADConst(elementType);
						code.LOAD("magicNumber");
						code.STATIC(Adv.class, "buildProxyClass").return_(Object.class).parameter(Class.class).parameter(byte.class).INVOKE();

						if (!elementType.getClassName().equals("java.lang.Object")) {
							code.CHECKCAST(elementType);
						}
						code.STORE("simplePojoClassSample", elementType);

						code.LINE();
						code.LOAD("tarray");
						code.LOADConst(0);
						code.LOAD("simplePojoClassSample");
						code.ARRAYSTORE();

						code.LINE();
						code.LOAD("tarray");
						code.RETURNTop();

						code.visitLabel(label7OfIFEQ);

						code.LINE();
						code.LOADConstNULL();
						code.RETURNTop();
					}

				} else {
					throw new UnsupportedOperationException();
				}
			} else {
				code.STORE("codeIndex", byte.class);

				code.LINE();
				code.LOADConst(MAGIC_CODES_NUMBER);
				code.LOAD("codeIndex");
				code.ADD();
				code.CONVERTTO(byte.class);
				code.STORE("magicNumber", byte.class);

				code.LINE();
				loadType(code, derivedReturnClazz);
				code.LOAD("magicNumber");
				code.STATIC(Adv.class, "proxyReturn").return_(Object.class).parameter(Class.class).parameter(byte.class).INVOKE();
				code.RETURNTop();
			}
		} else if (methodFormalTypeParameters.length > 0 && derivedReturnClazz.getType() != Type.VOID_TYPE) {
			code.STORE("codeIndex", byte.class);

			code.LINE();
			code.LOADConst(MAGIC_CODES_NUMBER);
			code.LOAD("codeIndex");
			code.ADD();
			code.CONVERTTO(byte.class);
			code.STORE("magicNumber", byte.class);

			boolean classResolved = resolveParamArgument(code, methodInfo.typeParamenterClazzes, methodInfo.signatureParamsClazzes);
			if (classResolved) {

				if (derivedReturnClazz instanceof ClazzVariable) {
					String targetClassName = "targetClass" + ((ClazzVariable) derivedReturnClazz).name;
					if (((ClazzVariable) derivedReturnClazz).isarray) {
						code.LINE();
						code.LOAD(targetClassName);
						code.LOADConst(1);
						code.STATIC(Array.class, "newInstance").return_(Object.class).parameter(Class.class).parameter(int.class).INVOKE();
						code.CHECKCAST(Object[].class);
						code.STORE("targetArray", Clazz.typeVariableOf("T", true));

						code.LINE();
						code.LOADConstNULL();
						code.STORE("targetElement", Clazz.typeVariableOf("T"));

						code.LINE();
						code.LOAD(targetClassName);
						code.STATIC(Adv.class, "canProxy").return_(boolean.class).parameter(Class.class).INVOKE();
						Label label9OfIFEQ = new Label();
						code.IFEQ(label9OfIFEQ);

						code.LINE();
						code.LOAD(targetClassName);
						code.LOAD("magicNumber");
						code.STATIC(Adv.class, "buildProxyClass").return_(Object.class).parameter(Class.class).parameter(byte.class).INVOKE();
						code.STORE("targetElement");

						code.LINE();
						code.LOAD("targetArray");
						code.LOADConst(0);
						code.LOAD("targetElement");
						code.ARRAYSTORE();

						code.LINE();
						code.LOAD("targetArray");
						code.RETURNTop();

						code.visitLabel(label9OfIFEQ);

						code.LINE();
						code.LOADConstNULL();
						code.RETURNTop();
					} else {
						code.LINE();
						code.LOAD(targetClassName);
						code.STATIC(Adv.class, "canProxy").return_(boolean.class).parameter(Class.class).INVOKE();
						Label label7OfIFEQ = new Label();
						code.IFEQ(label7OfIFEQ);

						code.LINE();
						code.LOAD(targetClassName);
						code.LOAD("magicNumber");
						code.STATIC(Adv.class, "buildProxyClass").return_(Object.class).parameter(Class.class).parameter(byte.class).INVOKE();
						code.RETURNTop();

						code.visitLabel(label7OfIFEQ);

						code.LINE();
						code.LOADConstNULL();
						code.RETURNTop();

					}
				}
			} else {

				code.LINE();
				code.LOADConstNULL();
				code.RETURNTop();
			}
		} else {
//			code.POP();

//			code.LINE();
//			code.LOAD("context");
//			code.VIRTUAL(AdvContext.class, "popAndExec").INVOKE();

			code.LINE();
			code.RETURN();
		}

		code.END();

		// TODO Auto-generated method stub
		return null;

	}

	private boolean resolveParamArgument(MethodCode code, ClazzFormalTypeParameter[] typeParamenterClazzes, Clazz[] paramsClazzes) {
		boolean resolvedAll = true;
		for (int j = 0; j < typeParamenterClazzes.length; j++) {
			boolean resolved = false;
			for (int i = 0; i < paramsClazzes.length; i++) {
				Clazz clazz = paramsClazzes[i];
				if (clazz instanceof ClazzVariable) {
					boolean isarray = ((ClazzVariable) clazz).isarray;
					String name = ((ClazzVariable) clazz).name;
					if (name.equals(typeParamenterClazzes[j].name)) {
						if (isarray) {
							code.LINE();
							code.LOAD("param0");
							code.VIRTUAL(Object.class, "getClass").return_(Class.class).INVOKE();
							code.VIRTUAL(Class.class, "getComponentType").return_(Class.class).INVOKE();
							code.STORE("targetClass" + name, Clazz.of(Class.class, Clazz.typeUnboundedTypeArgument()));
						} else {
							code.LINE();
							code.LOAD("param0");
							code.VIRTUAL(Object.class, "getClass").return_(Class.class).INVOKE();
							code.STORE("targetClass" + name, Clazz.of(Class.class, Clazz.typeUnboundedTypeArgument()));
						}
						resolved = true;
						break;
					}
				}
			}
			resolvedAll = resolvedAll && resolved;
		}
//		if (!resolvedAll) throw new UnsupportedOperationException("当前是简单的版本，不是所有的参数都解开了");
		return resolvedAll;
	}

	protected Class<?> toClass(final Clazz methodReturnClazz) {
		try {
			return Class.forName(methodReturnClazz.getType().getClassName());
		} catch (ClassNotFoundException e1) {
			throw new UnsupportedOperationException(e1);
		}
	}

	@Override
	public void visitSource(String source, String debug) {
//		super.visitSource(source.replaceAll("[.]java", this.suffix + ".java"), debug);
	}

	@Override
	public ModuleVisitor visitModule(String name, int access, String version) {
//		return super.visitModule(name, access, version);
		return null;
	}

	@Override
	public void visitOuterClass(String owner, String name, String descriptor) {
//		super.visitOuterClass(owner, name, descriptor);
	}

	@Override
	public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
//		return super.visitAnnotation(descriptor, visible);
		return null;
	}

	@Override
	public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
//		return super.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
		return null;
	}

	@Override
	public void visitAttribute(Attribute attribute) {
//		super.visitAttribute(attribute);
	}

	@Override
	public void visitInnerClass(String name, String outerName, String innerName, int access) {
//		super.visitInnerClass(name, outerName, innerName, access);
	}

	@Override
	public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
//		return super.visitField(access, name, descriptor, signature, value);
		return null;
	}

	@Override
	public void visitEnd() {
//		super.visitEnd();
//		int.class.isPrimitive()
	}

	/********************************************************************************************************************************************
	 * 
	 * 
	 * 共同部分代码，简化主函数逻辑
	 * 
	 * 
	 * 
	 ********************************************************************************************************************************************/

	static Map<Type, Type> primitive_BoxedClazz_Maps = asMap(new Type[] { Type.BOOLEAN_TYPE/* Boolean.class */, Type.BYTE_TYPE/* Byte.class */, Type.CHAR_TYPE/* Character.class */, Type.SHORT_TYPE/* Short.class */,
			Type.INT_TYPE/* Integer.class */, Type.LONG_TYPE/* Long.class */, Type.FLOAT_TYPE/* Float.class */, Type.DOUBLE_TYPE/* Double.class */
	}, new Type[] { /* boolean.class */Type.getType(Boolean.class), /* byte.class */Type.getType(Byte.class), /* char.class */Type.getType(Character.class), /* short.class */Type.getType(Short.class),
			/* int.class */Type.getType(Integer.class), /* long.class */Type.getType(Long.class), /* float.class */Type.getType(Float.class), /* double.class */Type.getType(Double.class) });

	static Map<Type, String> primitive_BoxedClassIntValue_Maps = asMap(new Type[] { Type.BOOLEAN_TYPE/* Boolean.class */, Type.BYTE_TYPE/* Byte.class */, Type.CHAR_TYPE/* Character.class */, Type.SHORT_TYPE/* Short.class */,
			Type.INT_TYPE/* Integer.class */, Type.LONG_TYPE/* Long.class */, Type.FLOAT_TYPE/* Float.class */, Type.DOUBLE_TYPE/* Double.class */
	}, new String[] { /* boolean.class" */"booleanValue", /* byte.class */ "byteValue", /* char.class */ "charValue", /* short.class */ "shortValue", /* int.class */ "intValue", /* long.class */ "longValue", /* float.class */ "floatValue",
			/* double.class */ "doubleValue" });

//	static Map<Type, Class<?>> primitive_ToValueClassMaps = asMap(
//			new Type[] { Type.BOOLEAN_TYPE/* Boolean.class */, Type.BYTE_TYPE/* Byte.class */, Type.CHAR_TYPE/* Character.class */,
//					Type.SHORT_TYPE/* Short.class */, Type.INT_TYPE/* Integer.class */, Type.LONG_TYPE/* Long.class */,
//					Type.FLOAT_TYPE/* Float.class */, Type.DOUBLE_TYPE/* Double.class */
//			},
//			new Class<?>[] { boolean.class /* "booleanValue" */, byte.class /* "byteValue" */, char.class /* "charValue" */,
//					short.class /* "shortValue" */, int.class /* "intValue" */, long.class /* "longValue" */,
//					float.class /* "floatValue" */, double.class /* "doubleValue" */ });

	static <K, V> Map<K, V> asMap(K[] keys, V[] values) {
		Map<K, V> maps = new HashMap<>();
		for (int i = 0; i < keys.length; i++) {
			maps.put(keys[i], values[i]);
		}
		return maps;
	}

	static void _cast(MethodCode code, Clazz returnClazz) {
		final boolean returnValueNeedBoxing = primitive_BoxedClazz_Maps.containsKey(returnClazz.getType());
		Type returnValueboxedClazz = returnValueNeedBoxing ? primitive_BoxedClazz_Maps.get(returnClazz.getType()) : null;
		String returnValueUnboxValueMethodName = returnValueNeedBoxing ? primitive_BoxedClassIntValue_Maps.get(returnClazz.getType()) : null;
		if (returnValueNeedBoxing) {
			code.CHECKCAST(returnValueboxedClazz);
			code.VIRTUAL(Clazz.of(returnValueboxedClazz), returnValueUnboxValueMethodName).return_(returnClazz).INVOKE();
		} else {
			if (!returnClazz.getType().getClassName().equals("java.lang.Object")) {
				code.CHECKCAST(returnClazz);
			}
		}
	}

	private void loadType(MethodCode code, Type originalReturnType) {
		final boolean returnValueNeedBoxing = primitive_BoxedClazz_Maps.containsKey(originalReturnType);
		Type returnValueboxedClazz = returnValueNeedBoxing ? primitive_BoxedClazz_Maps.get(originalReturnType) : null;
		if (returnValueNeedBoxing) code.GETSTATIC(returnValueboxedClazz, "TYPE", Type.getType(Class.class));
		else code.LOADConst(originalReturnType);
	}

	void loadType(MethodCode code, Clazz returnClass) {
		if (returnClass instanceof ClazzSimple || returnClass instanceof ClazzWithTypeArguments) {
			final boolean returnValueNeedBoxing = primitive_BoxedClazz_Maps.containsKey(returnClass.getType());
			Type returnValueboxedClazz = returnValueNeedBoxing ? primitive_BoxedClazz_Maps.get(returnClass.getType()) : null;
			if (returnValueNeedBoxing) code.GETSTATIC(returnValueboxedClazz, "TYPE", Type.getType(Class.class));
			else code.LOADConst(returnClass.getType());
		} else if (returnClass instanceof ClazzVariable) {
			if (withDyncArguemnts) {
				int local = -1;
				for (int i = 0; i < typeDyncArguments.length; i++) {
					Clazz clazz = typeDyncArguments[i];
					if (clazz == returnClass) {
						local = i;
						break;
					}
				}
				if (local >= 0) {
					code.LOAD("this");
					code.GETFIELD_OF_THIS("_arguments");
					code.LOADConst(local);
					code.ARRAYLOAD();
				} else {
					code.LOADConst(Type.getType(Object.class));
				}
			} else {
				if (((ClazzVariable) returnClass).isarray) {
					code.LOADConst(Type.getType(Object[].class));
				} else {

					code.LOADConst(Type.getType(Object.class));
				}
			}
		}

//		final boolean returnValueNeedBoxing = primitive_BoxedClazz_Maps.containsKey(returnClass.getType());
//		Type returnValueboxedClazz = returnValueNeedBoxing ? primitive_BoxedClazz_Maps.get(returnClass.getType()) : null;
//		if (returnValueNeedBoxing) code.GETSTATIC(returnValueboxedClazz, "TYPE", Type.getType(Class.class));
//		else code.LOADConst(returnClass.getType());
	}

	static Map<String, String> mps = asMap(
			new String[] { Boolean.class.getName(), Character.class.getName(), Byte.class.getName(), Short.class.getName(), Integer.class.getName(), Long.class.getName(), Float.class.getName(), Double.class.getName(),
					String.class.getName() },
			new String[] { Boolean.class.getName(), Character.class.getName(), Byte.class.getName(), Short.class.getName(), Integer.class.getName(), Long.class.getName(), Float.class.getName(), Double.class.getName(),
					String.class.getName() });

	protected void code_contextThreadLocal_execAndPop(MethodCode code) {
		code.LINE();
		code.LOAD("context");
		code.VIRTUAL(AdvContext.class, "execAndPop").INVOKE();
	}

	protected Type[] codeTypes(Type proxyType, int paramSize, Class<?>... classes) {
		Type[] typesLambda = new Type[1 + paramSize + classes.length];
		typesLambda[0] = proxyType;
		for (int i = 0; i < paramSize; i++) {
			typesLambda[i + 1] = Type.getType(ConsumerWithException.class);
		}
		for (int i = 0; i < classes.length; i++) {
			typesLambda[paramSize + i + 1] = Type.getType(classes[i]);
		}
		return typesLambda;
	}

	protected Type[] codeTypesdontKnow(int paramSize, Class<?>... classes) {
		Type[] typesLambda = new Type[paramSize + classes.length];
		for (int i = 0; i < paramSize; i++) {
			typesLambda[i] = Type.getType(ConsumerWithException.class);
		}
		for (int i = 0; i < classes.length; i++) {
			typesLambda[paramSize + i] = Type.getType(classes[i]);
		}
		return typesLambda;
	}

	protected void dynamicInvoke(MethodCode code, int paramSize, String proxyClassName, String lambdaName) {
		String lambdaRealMethodDesriptor = Type.getMethodDescriptor(Type.VOID_TYPE, codeTypesdontKnow(paramSize, ConsumerWithException.class, MethodCode.class));

		String dontKnowByNowMethodDesriptor = Type.getMethodDescriptor(Type.getType(ConsumerWithException.class), codeTypesdontKnow(paramSize, ConsumerWithException.class));
		dynamicInvokeLambdaStatic(code, proxyClassName, lambdaName, dontKnowByNowMethodDesriptor, lambdaRealMethodDesriptor);

		code.stackPop();
		for (int i = 0; i < paramSize; i++) {
			code.stackPop();
		}
	}

	protected void dynamicInvokeWithThis(MethodCode code, int paramSize, String proxyClassName, String lambdaName) {
		Type proxyType = Clazz.of(this.proxyClassName).getType();
		String lambdaRealMethodDesriptor = Type.getMethodDescriptor(Type.VOID_TYPE, codeTypesdontKnow(paramSize, ConsumerWithException.class, MethodCode.class));

		String dontKnowByNowMethodDesriptor = Type.getMethodDescriptor(Type.getType(ConsumerWithException.class), codeTypes(proxyType, paramSize, ConsumerWithException.class));
		dynamicInvokeLambdaWithThis(code, proxyClassName, lambdaName, dontKnowByNowMethodDesriptor, lambdaRealMethodDesriptor);

		code.stackPop();
		for (int i = 0; i < paramSize; i++) {
			code.stackPop();
		}
	}

	protected void code_getContext(MethodCode code) {
		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_contextThreadLocal");
		code.VIRTUAL(ThreadLocal.class, "get").return_(Object.class).INVOKE();
		code.CHECKCAST(AdvContext.class);
		code.STORE("context", AdvContext.class);
	}

	protected void code_resolve_this(String thisBlockName, MethodCode code) {
		code.LINE();
		code.LOAD("context");
		code.LOAD("this");
		code.VIRTUAL(AdvContext.class, "resolve").return_(ConsumerWithException.class).parameter(Object.class).INVOKE();
		code.STORE(thisBlockName, Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));
	}

	protected void code_resolve(String codeBlockName, MethodCode code, String paramName, Type paramClass) {
		code.LINE();
		code.LOAD("context");
		code.LOAD(paramName);
		if (paramClass.getSort() == Type.ARRAY) {
			Type type = paramClass.getElementType();

			if (type.getSort() == Type.OBJECT && !BoxUnbox.ClazzObjectToPrimitive.containsKey(type) && !type.equals(Type.getType(String.class))) {
				code.VIRTUAL(AdvContext.class, "resolve").return_(ConsumerWithException.class).parameter(Clazz.of(Object.class, true)).INVOKE();
				code.STORE(codeBlockName, Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));
			} else {
				code.VIRTUAL(AdvContext.class, "resolve").return_(ConsumerWithException.class).parameter(Clazz.of(paramClass)).INVOKE();
				code.STORE(codeBlockName, Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));
			}
		} else {
			Type type = paramClass;
			if (type.getSort() == Type.OBJECT && !BoxUnbox.ClazzObjectToPrimitive.containsKey(type) && !type.equals(Type.getType(String.class))) {
				code.VIRTUAL(AdvContext.class, "resolve").return_(ConsumerWithException.class).parameter(Clazz.of(Object.class)).INVOKE();
				code.STORE(codeBlockName, Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));
			} else {
				code.VIRTUAL(AdvContext.class, "resolve").return_(ConsumerWithException.class).parameter(Clazz.of(paramClass)).INVOKE();
				code.STORE(codeBlockName, Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));
			}
		}
	}

	protected void dynamicInvokeLambdaStatic(MethodCode code, String objClass, String lambdaName, String dontKnowByNowMethodDesriptor, String lambdaRealMethodDesriptor) {

		Type lambdaDefinedMethodDescriptor = Type.getType(Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(MethodCode.class)));
		code.visitInvokeDynamicInsn("accept", dontKnowByNowMethodDesriptor,
				new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory",
						"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false),
				new Object[] { Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESTATIC, objClass, lambdaName, lambdaRealMethodDesriptor, false), lambdaDefinedMethodDescriptor });
	}

	protected void dynamicInvokeLambdaWithThis(MethodCode code, String objClass, String lambdaName, String dontKnowByNowMethodDesriptor, String lambdaRealMethodDesriptor) {

		Type lambdaDefinedMethodDescriptor = Type.getType(Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(MethodCode.class)));
		code.visitInvokeDynamicInsn("accept", dontKnowByNowMethodDesriptor,
				new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory",
						"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false),
				new Object[] { Type.getType("(Ljava/lang/Object;)V"), new Handle(Opcodes.H_INVOKESPECIAL, objClass, lambdaName, lambdaRealMethodDesriptor, false), lambdaDefinedMethodDescriptor });
	}

	public String pushLambda(String[] params, String methodName, Consumer<MethodCode> lambdaInvokeSuperMethod) {
		String name = "lambda$" + methodName + "$" + this.proxyLambdas.size();
		proxyLambdas.add(new LambdaBuilder(name, params, lambdaInvokeSuperMethod));
		return name;
	}

	class LambdaBuilder {
		String name;// "lambda$0""lambda$0",
		String[] params;
		Consumer<MethodCode> lambdaInvokeSuperMethod;

		public void exec(ClassBody classBody) {
			int access;
			if (isTargetClazzKnown) {
				access = ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC;
			} else {
				access = ACC_PRIVATE | ACC_SYNTHETIC;
			}
			MethodHeader methodHeader = classBody.method(access, name).throws_(Exception.class);
			for (int i = 0; i < params.length; i++) {
				methodHeader.parameter(params[i], ConsumerWithException.class);
			}
			methodHeader.parameter("c", MethodCode.class);
			MethodCode code = methodHeader.begin();

			for (int i = 0; i < params.length; i++) {
				code_param_eval_accept(params[i], "c", code);
			}

			lambdaInvokeSuperMethod.accept(code);

			code.LINE();
			code.RETURN();
			code.END();
		}

		public LambdaBuilder(String name, String[] params, Consumer<MethodCode> lambdaInvokeSuperMethod) {
			super();
			this.name = name;
			this.params = params;
			this.lambdaInvokeSuperMethod = lambdaInvokeSuperMethod;
		}
	}

	class BridgeMethod {
		String methodName;
		Type originReturnType;
		Type[] originParamTypes;
		Clazz targetReturnClazz;
		Clazz[] targetParamClazzes;
		String[] exceptions;
		Clazz lowestClazz;

		public BridgeMethod(String methodName, Type originReturnType, Type[] originParamTypes, Clazz targetReturnClazz, Clazz[] targetParamClazzes, String[] exceptions) {
			super();
			this.methodName = methodName;
			this.originReturnType = originReturnType;
			this.originParamTypes = originParamTypes;
			this.targetReturnClazz = targetReturnClazz;
			this.targetParamClazzes = targetParamClazzes;
			this.exceptions = exceptions;
		}

		public void exec(ClassBody classBody) {
			logger.debug("BridgeMethod {}", methodName);
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

	}

	protected void code_param_eval_accept(String var1, String c, MethodCode code) {
		code.LINE();
		code.LOAD(var1);
		code.LOAD(c);
		code.INTERFACE(ConsumerWithException.class, "accept").parameter(Object.class).INVOKE();
	}

	protected void _set__Context(ClassBody classBody) {
		MethodCode code = classBody.public_().method("set__Context").parameter("_contextThreadLocal", Clazz.of(ThreadLocal.class, Clazz.of(AdvContext.class))).parameter("_magicNumber", byte.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("_contextThreadLocal");
		code.PUTFIELD_OF_THIS("_contextThreadLocal");

		code.LINE();
		code.LOAD("this");
		code.LOAD("_magicNumber");
		code.PUTFIELD_OF_THIS("_magicNumber");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _get__MagicNumber(ClassBody classBody) {
		MethodCode code = classBody.public_().method("get__MagicNumber").return_(byte.class).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_magicNumber");
		code.RETURNTop();

		code.END();
	}

	protected void _set__MagicNumber(ClassBody classBody) {
		MethodCode code = classBody.public_().method("set__MagicNumber").parameter("_magicNumber", byte.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("_magicNumber");
		code.PUTFIELD_OF_THIS("_magicNumber");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _get__TargetClazz(ClassBody classBody) {
		MethodCode code = classBody.public_().method("get__TargetClazz").return_(Clazz.class).begin();

		if (isTargetClazzKnown) {
			code.LINE();
			code.LOADConst(targetClazz);
			code.STATIC(Clazz.class, "of").parameter(Class.class).return_(ClazzSimple.class).INVOKE();
			code.RETURNTop();

		} else {
			code.LINE();
			code.LOADConst(targetClazz.getType().getClassName());
			code.STATIC(Clazz.class, "of").parameter(String.class).return_(ClazzSimple.class).INVOKE();
			code.RETURNTop();
		}

		code.END();
	}

//	@Override
//	public Clazz get__TargetClazz() {
//		return Clazz.of(ReferSimplePojoClassSample.class);
//	}
}
