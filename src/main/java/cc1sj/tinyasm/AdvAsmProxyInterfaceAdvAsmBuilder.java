package cc1sj.tinyasm;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_NUMBER;
import static cc1sj.tinyasm.Adv.MAGIC_CODES_String;
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

public class AdvAsmProxyInterfaceAdvAsmBuilder extends ClassVisitor {
	Logger logger = LoggerFactory.getLogger(getClass());

	public static byte[] dump2(Class<?> target, String proxyClassName) throws Exception {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

		AdvAsmProxyInterfaceAdvAsmBuilder bw = new AdvAsmProxyInterfaceAdvAsmBuilder(Opcodes.ASM9, cw, Type.getType(target), proxyClassName);

		resolveClass(target, bw);

		bw.finish();

		return cw.toByteArray();
	}

	protected static void resolveClass(Class<?> target, ClassVisitor bw) throws IOException {
		ClassReader cr = new ClassReader(target.getName());
		cr.accept(bw, ClassReader.SKIP_CODE);

		Class<?> superClass = target.getSuperclass();

		if (superClass != null && superClass != Object.class) {
			resolveClass(superClass, bw);
		}

		for (Class<?> interfaceClass : target.getInterfaces()) {
			resolveClass(interfaceClass, bw);
		}
	}

	ClassBody classBody;
	String proxyClassName;
	Clazz targetClazz;
	Clazz[] typeTypes;

	List<BridgeMethod> bridgeMethods = new ArrayList<>();

	public AdvAsmProxyInterfaceAdvAsmBuilder(int api, Type targetType, String proxyClassName) {
		super(api);
		this.proxyClassName = proxyClassName;
		this.targetClazz = Clazz.of(targetType);
		dump(targetType, proxyClassName);
	}

	public AdvAsmProxyInterfaceAdvAsmBuilder(int api, ClassVisitor classVisitor, Type targetType, String proxyClassName) {
		super(api, classVisitor);
		this.proxyClassName = proxyClassName;
		this.targetClazz = Clazz.of(targetType);

		dump(targetType, proxyClassName);
	}

	protected void dump(Type targetType, String proxyClassName) {
		ClassHeader ch = ClassBuilder.make(cv, proxyClassName);
//		if(superName)
		ch.implement(targetClazz);
		ch.implement(AdvRuntimeReferNameObject.class);
//		ch.access(access);
		classBody = ch.body();

		classBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, MethodHandles.class.getName(), "Lookup");

		classBody.field("_magicNumber", Clazz.of(byte.class));
		classBody.field("_contextThreadLocal", Clazz.of(ThreadLocal.class, Clazz.of(AdvContext.class)));

		__init_(classBody);
		_get__MagicNumber(classBody);
		_set__MagicNumber(classBody);
		_set__Context(classBody);

	}

	public void finish() {
		for (int i = bridgeMethods.size() - 1; i >= 0; i--) {
			bridgeMethods.get(i).exec(classBody);
		}

		for (int i = lambdas.size() - 1; i >= 0; i--) {
			lambdas.get(i).exec(classBody);
		}
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Clazz.of(Object.class), "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _get__MagicNumber(ClassBody classBody) {
		MethodCode code = classBody.publicMethod(byte.class, "get__MagicNumber").begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_magicNumber");
		code.RETURNTop();

		code.END();
	}

	protected void _set__MagicNumber(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("set__MagicNumber").parameter("_magicNumber", byte.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("_magicNumber");
		code.PUTFIELD_OF_THIS("_magicNumber");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _set__Context(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("set__Context")
				.parameter("_contextThreadLocal", Clazz.of(ThreadLocal.class, Clazz.of(AdvContext.class)))
				.parameter("_magicNumber", byte.class).begin();

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

	List<ClazzFormalTypeParameter> classFormalTypeParameters = new ArrayList<>();

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		logger.debug("visit( {},  {},  {},  {}, [] exceptions)", access, name, signature, superName);
		if (signature != null) {
			ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
			SignatureReader sr = new SignatureReader(signature);
			sr.accept(classSignaturewwww);
			classSignaturewwww.finish();
			for (int i = 0; i < classSignaturewwww.typeParamenterClazzes.length; i++) {
				Clazz clazz = classSignaturewwww.typeParamenterClazzes[i];
				if (clazz instanceof ClazzFormalTypeParameter) {
					ClazzFormalTypeParameter clazzFormalTypeParameter = (ClazzFormalTypeParameter) clazz;
					clazzFormalTypeParameter.setActualClazz(typeTypes[i]);
					classFormalTypeParameters.add(clazzFormalTypeParameter);
				}
			}
		}
	}

	Map<String, String> definedMethodes = new HashMap<>();

	@Override
	public MethodVisitor visitMethod(int access, String methodName, String descriptor, String signature, String[] exceptions) {
		logger.debug("visitMethod(int {}, String {}, String {}, String {}, String[] exceptions)", access, methodName, descriptor,
				signature);
		if (methodName.equals("<init>") || methodName.equals("<clinit>")
				|| (access & (ACC_STATIC | ACC_PRIVATE | ACC_SYNTHETIC | ACC_NATIVE | ACC_BRIDGE)) != 0) {
			return null;
		}

		// Return Type
		Type originReturnType = Type.getReturnType(descriptor);
		// ParamType
		Type[] originParamTypes = Type.getArgumentTypes(descriptor);

		Clazz returnClazz = Clazz.of(originReturnType);
		Clazz[] methodParamClazzes = new Clazz[originParamTypes.length];

		Clazz computedReturnClazz = null;
		ClassSignaturewwww classSignaturewwww = null;
		boolean needBridge = false;
		if (signature != null) {

			classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
			SignatureReader sr = new SignatureReader(signature);
			sr.accept(classSignaturewwww);
			classSignaturewwww.finish();

			for (int i = 0; i < classSignaturewwww.paramsClazzes.length; i++) {
				Clazz clazz = classSignaturewwww.paramsClazzes[i];
				Clazz computedClazz;
				computedClazz = resolveClassVariable(clazz, classFormalTypeParameters);
				methodParamClazzes[i] = computedClazz;
				if (clazz instanceof ClazzVariable) {
					needBridge = true;
				}
			}

			if (classSignaturewwww.returnClazz instanceof ClazzVariable) {
				needBridge = true;
			}
			Clazz originReturnClazz = classSignaturewwww.returnClazz;
			computedReturnClazz = resolveClassVariable(originReturnClazz, classFormalTypeParameters);

			if (computedReturnClazz == null) {
				computedReturnClazz = Clazz.of(Type.VOID_TYPE);
			}

		} else {

			for (int i = 0; i < originParamTypes.length; i++) {
				methodParamClazzes[i] = Clazz.of(originParamTypes[i]);
			}
		}

		final Clazz methodReturnClazz = signature != null ? computedReturnClazz : Clazz.of(originReturnType);

		ClazzFormalTypeParameter[] methodFormalTypeParameters = signature != null
				? (ClazzFormalTypeParameter[]) classSignaturewwww.typeParamenterClazzes
				: new ClazzFormalTypeParameter[0];

		if (needBridge && methodFormalTypeParameters.length == 0) {
			String actualDescriptor = buildBridgeDescriptor(originParamTypes, originReturnType);
			String referkey = methodName + actualDescriptor;
//			logger.debug(referkey);
			if (!definedMethodes.containsKey(referkey)) {
				bridgeMethods.add(new BridgeMethod(methodName, originReturnType, originParamTypes, methodReturnClazz, methodParamClazzes,
						exceptions));
				definedMethodes.put(referkey, referkey);
			}
		}

		String actualDescriptor;
		String actualSignature;
		{
			actualDescriptor = buildDescriptor(methodParamClazzes, methodReturnClazz);
			actualSignature = buildSignature(methodFormalTypeParameters, methodParamClazzes, methodReturnClazz);
		}

		String referkey = methodName + actualDescriptor + actualSignature;
		if (definedMethodes.containsKey(referkey)) {
			return null;
		}
		definedMethodes.put(referkey, referkey);

		MethodHeader mh = classBody.method(ACC_PUBLIC, methodReturnClazz, methodName);
		if (methodFormalTypeParameters.length > 0) {
			for (ClazzFormalTypeParameter clazz : methodFormalTypeParameters) {
				mh.formalTypeParameter(clazz);
			}
		}
//			mh.access(access);
		for (int i = 0; i < methodParamClazzes.length; i++) {
			mh.parameter("param" + i, methodParamClazzes[i]);
		}
		if (exceptions != null) for (String e : exceptions) mh.tHrow(Clazz.of(Type.getObjectType(e)));

		MethodCode code = mh.begin();

		code_getContext(code);
		// resolve parameters
		for (int i = methodParamClazzes.length - 1; i >= 0; i--) {
			if (Type.BOOLEAN_TYPE == methodParamClazzes[i].getType()
					|| Boolean.class.getName().equals(methodParamClazzes[i].getType().getClassName())) {
				code.LINE();
				code.LOAD("context");
				code.VIRTUAL(AdvContext.class, "getCodeAndPop").reTurn(ConsumerWithException.class).INVOKE();
				code.STORE("eval_param" + i, Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));
			} else {
				code_resolve("eval_param" + i, code, "param" + i, methodParamClazzes[i].getType());
			}
		}
		// resolve this
		code_resolve_this("objEval", code);

		// LOAD All Parameter
		code.LINE();
		code.LOAD("context");
		if (methodReturnClazz.getType() != Type.VOID_TYPE) {
//			code.LOADConst(returnType);
			loadType(code, methodReturnClazz);
		}

		String[] lambdaEvalParamNames = new String[methodParamClazzes.length + 1];
		code.LOAD("objEval");
		lambdaEvalParamNames[0] = "objEval";
		for (int i = 0; i < methodParamClazzes.length; i++) {
			code.LOAD("eval_param" + i);
			lambdaEvalParamNames[i + 1] = "eval_param" + i;
		}

		// invoke method
		String lambdaName = pushLambda(lambdaEvalParamNames, methodName, c -> {
			c.LINE();
			c.LOAD("c");
			c.LOADConst(targetClazz);
			c.LOADConst(methodName);
			c.VIRTUAL(MethodCode.class, "INTERFACE").reTurn(MethodCaller.class).parameter(Class.class).parameter(String.class).INVOKE();
			for (Type type : originParamTypes) {
				loadType(c, Clazz.of(type));
				c.INTERFACE(MethodCaller.class, "parameter").reTurn(MethodCaller.class).parameter(Class.class).INVOKE();
			}

			if (originReturnType != Type.VOID_TYPE) {
				loadType(c, returnClazz);
				c.INTERFACE(MethodCaller.class, "reTurn").reTurn(MethodCaller.class).parameter(Class.class).INVOKE();
			}

			c.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

			if (!(methodReturnClazz instanceof ClazzVariable) && originReturnType != Type.VOID_TYPE
					&& !originReturnType.getInternalName().equals(methodReturnClazz.getType().getInternalName())) {
				c.LINE();
				c.LOAD("c");
				c.LOADConst(methodReturnClazz);
				c.VIRTUAL(MethodCode.class, "CHECKCAST").parameter(Class.class).INVOKE();
			}
		});

		dynamicInvoke(code, methodParamClazzes.length, proxyClassName.replace('.', '/'), lambdaName);

		code.stackPush(Type.getType(ConsumerWithException.class));

		if (methodReturnClazz.getType() != Type.VOID_TYPE) {
			code.VIRTUAL(AdvContext.class, "push").reTurn(byte.class).parameter(Class.class).parameter(ConsumerWithException.class)
					.INVOKE();
		} else {
			code.VIRTUAL(AdvContext.class, "execLine").parameter(ConsumerWithException.class).INVOKE();
		}

		// Refer
		if (methodFormalTypeParameters.length == 0 && methodReturnClazz.getType() != Type.VOID_TYPE) {

//				code.CONVERTTO(returnClazz);
			if (Type.BOOLEAN_TYPE == methodReturnClazz.getType()) {
				code.POP();
				code.LINE();
				code.LOADConst(0);
				code.RETURNTop();
			} else if (Boolean.class.getName().equals(methodReturnClazz.getType().getClassName())) {
				code.POP();

				code.LINE();
				code.LOADConst(0);
				code.STATIC(Boolean.class, "valueOf").reTurn(Boolean.class).parameter(boolean.class).INVOKE();
				code.RETURNTop();
			} else if (BoxUnbox.ClazzObjectToPrimitive.containsKey(methodReturnClazz.getType())) {
				code.STORE("codeIndex", byte.class);
				code.LINE();
				code.LOADConst(MAGIC_CODES_NUMBER);
				code.LOAD("codeIndex");
				code.ADD();
				Type primitiveType = BoxUnbox.ClazzObjectToPrimitive.get(methodReturnClazz.getType());
				code.CONVERTTO(primitiveType);
				BoxUnbox.PrimaryToBoxFunc.get(primitiveType).accept(code);
				code.RETURNTop();
			} else if (BoxUnbox.PrimativeToClazzObject.containsKey(methodReturnClazz.getType())) {
				code.STORE("codeIndex", byte.class);
				code.LINE();
				code.LOADConst(MAGIC_CODES_NUMBER);
				code.LOAD("codeIndex");
				code.ADD();
				code.CONVERTTO(methodReturnClazz);
				code.RETURNTop();
			} else if (methodReturnClazz.getType().getSort() == Type.OBJECT
					&& methodReturnClazz.getType().equals(Type.getType(String.class))) {
						code.STORE("codeIndex", byte.class);
						code.LINE();
						code.NEW(StringBuilder.class);
						code.DUP();
						code.LOADConst(MAGIC_CODES_String);
						code.SPECIAL(StringBuilder.class, "<init>").parameter(String.class).INVOKE();
						code.LOAD("codeIndex");
						code.VIRTUAL(StringBuilder.class, "append").reTurn(StringBuilder.class).parameter(int.class).INVOKE();
						code.VIRTUAL(StringBuilder.class, "toString").reTurn(String.class).INVOKE();
						code.RETURNTop();
					} else
				if (methodReturnClazz.getType().getSort() == Type.OBJECT) {
					code.STORE("codeIndex", byte.class);

					if (methodReturnClazz instanceof ClazzType) {

						code.LINE();
						code.LOADConst(80);
						code.LOAD("codeIndex");
						code.ADD();
						code.CONVERTTO(byte.class);
						code.STORE("magicNumber", byte.class);

						code.LINE();
						code.LOADConst(methodReturnClazz);
						code.STATIC(Adv.class, "canProxy").reTurn(boolean.class).parameter(Class.class).INVOKE();
						Label label5OfIFEQ = new Label();
						code.IFEQ(label5OfIFEQ);

						code.LINE();
						code.LOADConst(methodReturnClazz);
						code.LOAD("magicNumber");
						code.STATIC(Adv.class, "buildProxyClass").reTurn(Object.class).parameter(Class.class).parameter(byte.class)
								.INVOKE();
						code.CHECKCAST(methodReturnClazz);
						code.RETURNTop();

						code.visitLabel(label5OfIFEQ);

						code.LINE();
						code.LOADConstNULL();
						code.RETURNTop();
					} else if (methodReturnClazz instanceof ClazzComplex) {

						code.LINE();
						code.LOADConst(80);
						code.LOAD("codeIndex");
						code.ADD();
						code.CONVERTTO(byte.class);
						code.STORE("magicNumber", byte.class);

						Clazz[] genericParameterClazz = ((ClazzComplex) methodReturnClazz).getGenericParameterClazz();

						code.LINE();
						code.LOADConst(methodReturnClazz);
						code.STATIC(Adv.class, "canProxy").reTurn(boolean.class).parameter(Class.class).INVOKE();
						Label label5OfIFEQ = new Label();
						code.IFEQ(label5OfIFEQ);

						code.LINE();
						code.LOADConst(methodReturnClazz);
						Class<?>[] paramsclasses = new Class[genericParameterClazz.length];
						for (int i = 0; i < genericParameterClazz.length; i++) {
							Clazz clazz = genericParameterClazz[i];
							code.LOADConst(((ClazzTypeArgument) clazz).clazz);
							paramsclasses[i] = Class.class;
						}

						code.LOAD("magicNumber");
						code.STATIC(Adv.class, "buildProxyClass").reTurn(Object.class).parameter(Class.class).parameter(paramsclasses)
								.parameter(byte.class).INVOKE();
						code.CHECKCAST(methodReturnClazz);
						code.RETURNTop();

						code.visitLabel(label5OfIFEQ);

						code.LINE();
						code.LOADConstNULL();
						code.RETURNTop();
					} else {
						logger.debug(methodReturnClazz.signatureOf());
					}

				} else if (methodReturnClazz.getType().getSort() == Type.ARRAY) {

					Type elementType = methodReturnClazz.getType().getElementType();

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
						code.STATIC(Boolean.class, "valueOf").reTurn(Boolean.class).parameter(boolean.class).INVOKE();
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
						code.VIRTUAL(StringBuilder.class, "append").reTurn(StringBuilder.class).parameter(int.class).INVOKE();
						code.VIRTUAL(StringBuilder.class, "toString").reTurn(String.class).INVOKE();
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
						code.STATIC(Adv.class, "canProxy").reTurn(boolean.class).parameter(Class.class).INVOKE();
						Label label7OfIFEQ = new Label();
						code.IFEQ(label7OfIFEQ);

						code.LINE();
						code.LOADConst(elementType);
						code.LOAD("magicNumber");
						code.STATIC(Adv.class, "buildProxyClass").reTurn(Object.class).parameter(Class.class).parameter(byte.class)
								.INVOKE();

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
		} else if (methodFormalTypeParameters.length > 0 && methodReturnClazz.getType() != Type.VOID_TYPE) {
			code.STORE("codeIndex", byte.class);

			code.LINE();
			code.LOADConst(MAGIC_CODES_NUMBER);
			code.LOAD("codeIndex");
			code.ADD();
			code.CONVERTTO(byte.class);
			code.STORE("magicNumber", byte.class);

			boolean classResolved = resolveParamArgument(code, classSignaturewwww.typeParamenterClazzes, classSignaturewwww.paramsClazzes);
			if (classResolved) {

				if (methodReturnClazz instanceof ClazzVariable) {
					String targetClassName = "targetClass" + ((ClazzVariable) methodReturnClazz).name;
					if (((ClazzVariable) methodReturnClazz).isarray) {
						code.LINE();
						code.LOAD(targetClassName);
						code.LOADConst(1);
						code.STATIC(Array.class, "newInstance").reTurn(Object.class).parameter(Class.class).parameter(int.class).INVOKE();
						code.CHECKCAST(Object[].class);
						code.STORE("targetArray", Clazz.typeVariableOf("T", true));

						code.LINE();
						code.LOADConstNULL();
						code.STORE("targetElement", Clazz.typeVariableOf("T"));

						code.LINE();
						code.LOAD(targetClassName);
						code.STATIC(Adv.class, "canProxy").reTurn(boolean.class).parameter(Class.class).INVOKE();
						Label label9OfIFEQ = new Label();
						code.IFEQ(label9OfIFEQ);

						code.LINE();
						code.LOAD(targetClassName);
						code.LOAD("magicNumber");
						code.STATIC(Adv.class, "buildProxyClass").reTurn(Object.class).parameter(Class.class).parameter(byte.class)
								.INVOKE();
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
						code.STATIC(Adv.class, "canProxy").reTurn(boolean.class).parameter(Class.class).INVOKE();
						Label label7OfIFEQ = new Label();
						code.IFEQ(label7OfIFEQ);

						code.LINE();
						code.LOAD(targetClassName);
						code.LOAD("magicNumber");
						code.STATIC(Adv.class, "buildProxyClass").reTurn(Object.class).parameter(Class.class).parameter(byte.class)
								.INVOKE();
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

	private String buildBridgeDescriptor(Type[] originParamTypes, Type originReturnType) {
		String actualDescriptor;
		Type[] types1 = new Type[originParamTypes.length];
		for (int i1 = 0; i1 < originParamTypes.length; i1++) {
			types1[i1] = originParamTypes[i1];
		}

		actualDescriptor = Type.getMethodDescriptor(originReturnType, types1);
		return actualDescriptor;
	}

	protected String buildDescriptor(Clazz[] methodParamClazzes, final Clazz methodReturnClazz) {
		String actualDescriptor;
		Type[] types1 = new Type[methodParamClazzes.length];
		for (int i1 = 0; i1 < methodParamClazzes.length; i1++) {
			types1[i1] = methodParamClazzes[i1].getType();
		}

		actualDescriptor = Type.getMethodDescriptor(methodReturnClazz.getType(), types1);
		return actualDescriptor;
	}

	protected String buildSignature(ClazzFormalTypeParameter[] methodFormalTypeParameters, Clazz[] methodParamClazzes,
			final Clazz methodReturnClazz) {
		String actualSignature;
		boolean needSignature = false;
		{
			StringBuilder sb = new StringBuilder();
			if (methodFormalTypeParameters != null && methodFormalTypeParameters.length > 0) {
				sb.append('<');
				for (int i = 0; i < methodFormalTypeParameters.length; i++) {
					ClazzFormalTypeParameter type = methodFormalTypeParameters[i];
					sb.append(type.signatureOf());
				}
				sb.append('>');
				needSignature = true;
			}

			sb.append("(");
			for (Clazz param : methodParamClazzes) {
				if (param.needSignature()) {
					sb.append(param.signatureAnyway());
					needSignature = true;
				} else {
					sb.append(param.getDescriptor());
				}
			}
			sb.append(")");
			needSignature |= methodReturnClazz.needSignature();
			sb.append(methodReturnClazz.signatureAnyway());

			String signatureFromParameter = sb.toString();

			if (needSignature) {
				actualSignature = signatureFromParameter;
			} else {
				actualSignature = null;
			}
		}
		return actualSignature;
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
							code.VIRTUAL(Object.class, "getClass").reTurn(Class.class).INVOKE();
							code.VIRTUAL(Class.class, "getComponentType").reTurn(Class.class).INVOKE();
							code.STORE("targetClass" + name, Clazz.of(Class.class, Clazz.typeUnboundedTypeArgument()));
						} else {
							code.LINE();
							code.LOAD("param0");
							code.VIRTUAL(Object.class, "getClass").reTurn(Class.class).INVOKE();
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

	protected Clazz resolveClassVariable(Clazz clazz, List<ClazzFormalTypeParameter> formalTypeParameters) {
		if (clazz instanceof ClazzVariable) {
			for (int i = 0; i < formalTypeParameters.size(); i++) {
				ClazzFormalTypeParameter formalTypeParameter = formalTypeParameters.get(i);
				if (formalTypeParameter.name.equals(((ClazzVariable) clazz).name)) {
					return formalTypeParameter.getActualClazz();
				}
			}
		} else if (clazz instanceof ClazzComplex) {
			ClazzComplex clazzComplex = (ClazzComplex) clazz;
			Clazz baseClazz = clazzComplex.getBaseClazz();
			boolean changed = false;
			Clazz[] genericParameterClazz = clazzComplex.getGenericParameterClazz();
			Clazz[] genericParameterClazzResolved = new Clazz[genericParameterClazz.length];
			for (int i = 0; i < genericParameterClazz.length; i++) {
				Clazz cl = genericParameterClazz[i];
				Clazz cln = resolveClassVariable(cl, formalTypeParameters);
				if (cl != cln) {
					changed = true;
				}
				genericParameterClazzResolved[i] = cln;
			}
			if (changed) {
				return Clazz.of(baseClazz, genericParameterClazzResolved);
			}
		} else if (clazz instanceof ClazzTypeArgument) {
			ClazzTypeArgument typeArgument = (ClazzTypeArgument) clazz;
			Clazz typeArgumentClazz = typeArgument.getClazz();

			Clazz typeArgumentClazzResolved = resolveClassVariable(typeArgumentClazz, formalTypeParameters);
			if (typeArgumentClazzResolved != typeArgumentClazz) {
				return Clazz.typeArgument(typeArgument.getWildcard(), typeArgumentClazzResolved);
			} else {
				return typeArgument;
			}
		}

		return clazz;
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

	static Map<Type, Type> primitive_BoxedClazz_Maps = asMap(
			new Type[] { Type.BOOLEAN_TYPE/* Boolean.class */, Type.BYTE_TYPE/* Byte.class */, Type.CHAR_TYPE/* Character.class */,
					Type.SHORT_TYPE/* Short.class */, Type.INT_TYPE/* Integer.class */, Type.LONG_TYPE/* Long.class */,
					Type.FLOAT_TYPE/* Float.class */, Type.DOUBLE_TYPE/* Double.class */
			},
			new Type[] { /* boolean.class */Type.getType(Boolean.class), /* byte.class */Type.getType(Byte.class),
					/* char.class */Type.getType(Character.class), /* short.class */Type.getType(Short.class),
					/* int.class */Type.getType(Integer.class), /* long.class */Type.getType(Long.class),
					/* float.class */Type.getType(Float.class), /* double.class */Type.getType(Double.class) });

	static Map<Type, String> primitive_BoxedClassIntValue_Maps = asMap(
			new Type[] { Type.BOOLEAN_TYPE/* Boolean.class */, Type.BYTE_TYPE/* Byte.class */, Type.CHAR_TYPE/* Character.class */,
					Type.SHORT_TYPE/* Short.class */, Type.INT_TYPE/* Integer.class */, Type.LONG_TYPE/* Long.class */,
					Type.FLOAT_TYPE/* Float.class */, Type.DOUBLE_TYPE/* Double.class */
			},
			new String[] { /* boolean.class" */"booleanValue", /* byte.class */ "byteValue", /* char.class */ "charValue",
					/* short.class */ "shortValue", /* int.class */ "intValue", /* long.class */ "longValue",
					/* float.class */ "floatValue", /* double.class */ "doubleValue" });

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

	static void _cast(MethodCode code, Clazz returnType) {
		Clazz returnClazz = Clazz.of(returnType);
		final boolean returnValueNeedBoxing = primitive_BoxedClazz_Maps.containsKey(returnType.getType());
		Type returnValueboxedClazz = returnValueNeedBoxing ? primitive_BoxedClazz_Maps.get(returnType.getType()) : null;
		String returnValueUnboxValueMethodName = returnValueNeedBoxing ? primitive_BoxedClassIntValue_Maps.get(returnType.getType()) : null;
		if (returnValueNeedBoxing) {
			code.CHECKCAST(returnValueboxedClazz);
			code.VIRTUAL(Clazz.of(returnValueboxedClazz), returnValueUnboxValueMethodName).reTurn(returnClazz).INVOKE();
		} else {
			if (!returnClazz.getType().getClassName().equals("java.lang.Object")) {
				code.CHECKCAST(returnClazz);
			}
		}
	}

	static void loadType(MethodCode code, Clazz returnClass) {
		final boolean returnValueNeedBoxing = primitive_BoxedClazz_Maps.containsKey(returnClass.getType());
		Type returnValueboxedClazz = returnValueNeedBoxing ? primitive_BoxedClazz_Maps.get(returnClass.getType()) : null;
		if (returnValueNeedBoxing) code.GETSTATIC(returnValueboxedClazz, "TYPE", Type.getType(Class.class));
		else code.LOADConst(returnClass.getType());
	}

	static Map<String, String> mps = asMap(
			new String[] { Boolean.class.getName(), Character.class.getName(), Byte.class.getName(), Short.class.getName(),
					Integer.class.getName(), Long.class.getName(), Float.class.getName(), Double.class.getName(), String.class.getName() },
			new String[] { Boolean.class.getName(), Character.class.getName(), Byte.class.getName(), Short.class.getName(),
					Integer.class.getName(), Long.class.getName(), Float.class.getName(), Double.class.getName(), String.class.getName() });

	protected void code_contextThreadLocal_execAndPop(MethodCode code) {
		code.LINE();
		code.LOAD("context");
		code.VIRTUAL(AdvContext.class, "execAndPop").INVOKE();
	}

	protected Type[] codeTypes(int paramSize, Class<?>... classes) {
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
		String lambdaRealMethodDesriptor = Type.getMethodDescriptor(Type.VOID_TYPE,
				codeTypes(paramSize, ConsumerWithException.class, MethodCode.class));

		String dontKnowByNowMethodDesriptor = Type.getMethodDescriptor(Type.getType(ConsumerWithException.class),
				codeTypes(paramSize, ConsumerWithException.class));
		dynamicInvokeLambda(code, proxyClassName, lambdaName, dontKnowByNowMethodDesriptor, lambdaRealMethodDesriptor);

		code.stackPop();
		for (int i = 0; i < paramSize; i++) {
			code.stackPop();
		}
	}

	protected void code_getContext(MethodCode code) {
		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("_contextThreadLocal");
		code.VIRTUAL(ThreadLocal.class, "get").reTurn(Object.class).INVOKE();
		code.CHECKCAST(AdvContext.class);
		code.STORE("context", AdvContext.class);
	}

	protected void code_resolve_this(String thisBlockName, MethodCode code) {
		code.LINE();
		code.LOAD("context");
		code.LOAD("this");
		code.VIRTUAL(AdvContext.class, "resolve").reTurn(ConsumerWithException.class).parameter(Object.class).INVOKE();
		code.STORE(thisBlockName, Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));
	}

	protected void code_resolve(String codeBlockName, MethodCode code, String paramName, Type paramClass) {
		code.LINE();
		code.LOAD("context");
		code.LOAD(paramName);
		if (paramClass.getSort() == Type.ARRAY) {
			Type type = paramClass.getElementType();

			if (type.getSort() == Type.OBJECT && !BoxUnbox.ClazzObjectToPrimitive.containsKey(type)
					&& !type.equals(Type.getType(String.class))) {
				code.VIRTUAL(AdvContext.class, "resolve").reTurn(ConsumerWithException.class).parameter(Clazz.of(Object.class, true))
						.INVOKE();
				code.STORE(codeBlockName, Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));
			} else {
				code.VIRTUAL(AdvContext.class, "resolve").reTurn(ConsumerWithException.class).parameter(Clazz.of(paramClass)).INVOKE();
				code.STORE(codeBlockName, Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));
			}
		} else {
			Type type = paramClass;
			if (type.getSort() == Type.OBJECT && !BoxUnbox.ClazzObjectToPrimitive.containsKey(type)
					&& !type.equals(Type.getType(String.class))) {
				code.VIRTUAL(AdvContext.class, "resolve").reTurn(ConsumerWithException.class).parameter(Clazz.of(Object.class)).INVOKE();
				code.STORE(codeBlockName, Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));
			} else {
				code.VIRTUAL(AdvContext.class, "resolve").reTurn(ConsumerWithException.class).parameter(Clazz.of(paramClass)).INVOKE();
				code.STORE(codeBlockName, Clazz.of(ConsumerWithException.class, Clazz.of(MethodCode.class)));
			}
		}
	}

	protected void dynamicInvokeLambda(MethodCode code, String objClass, String lambdaName, String dontKnowByNowMethodDesriptor,
			String lambdaRealMethodDesriptor) {

		Type lambdaDefinedMethodDescriptor = Type.getType(Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(MethodCode.class)));
		code.visitInvokeDynamicInsn("accept", dontKnowByNowMethodDesriptor, new Handle(Opcodes.H_INVOKESTATIC,
				"java/lang/invoke/LambdaMetafactory", "metafactory",
				"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
				false),
				new Object[] { Type.getType("(Ljava/lang/Object;)V"),
						new Handle(Opcodes.H_INVOKESTATIC, objClass, lambdaName, lambdaRealMethodDesriptor, false),
						lambdaDefinedMethodDescriptor });
	}

	List<LambdaBuilder> lambdas = new ArrayList<>();

	public String pushLambda(String[] params, String methodName, Consumer<MethodCode> lambdaInvokeSuperMethod) {
		String name = "lambda$" + methodName + "$" + this.lambdas.size();
		lambdas.add(new LambdaBuilder(name, params, lambdaInvokeSuperMethod));
		return name;
	}

	class LambdaBuilder {
		String name;// "lambda$0""lambda$0",
		String[] params;
		Consumer<MethodCode> lambdaInvokeSuperMethod;

		public void exec(ClassBody classBody) {

			MethodHeader methodHeader = classBody.staticMethod(ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC, name).tHrow(Exception.class);
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

		public BridgeMethod(String methodName, Type originReturnType, Type[] originParamTypes, Clazz targetReturnClazz,
				Clazz[] targetParamClazzes, String[] exceptions) {
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
			if (originReturnType != Type.VOID_TYPE) methodHeader.reTurn(Clazz.of(originReturnType));
			if (exceptions != null) methodHeader.tHrow(exceptions);

			for (int i = 0; i < originParamTypes.length; i++) {
				methodHeader.parameter("params" + i, Clazz.of(originParamTypes[i]));
			}
			MethodCode code = methodHeader.begin();

			code.LINE();
			code.LOAD("this");

			for (int i = 0; i < originParamTypes.length; i++) {
				code.LOAD("params" + i);
				if (targetParamClazzes[i].getType().getSort() != Type.INT) {
					code.CHECKCAST(targetParamClazzes[i]);
				}
			}

			if (this.targetParamClazzes.length > 0)
				code.VIRTUAL(methodName).reTurn(targetReturnClazz).parameter(this.targetParamClazzes).INVOKE();
			else code.VIRTUAL(methodName).reTurn(targetReturnClazz).INVOKE();

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
}
