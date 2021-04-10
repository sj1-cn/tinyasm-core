package cn.sj1.tinyasm.core;

import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import org.objectweb.asm.signature.SignatureVisitor;
import org.objectweb.asm.signature.SignatureWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MixinAdvAsmBuilder extends ClassVisitor {
	Logger logger = LoggerFactory.getLogger(getClass());

	public static byte[] dumpMagic(Class<?> target, String proxyClassName) throws Exception {
		return dumpMagic(target, proxyClassName, new Class<?>[0], new Object[0]);
	}

	public static byte[] dumpMagic(Class<?> target, String proxyClassName, Class<?>[] typeArguemntes) throws Exception {

		return dumpMagic(target, proxyClassName, typeArguemntes, new Object[0]);
	}

	public static byte[] dumpMagic(Class<?> target, String proxyClassName, Object[] params) throws Exception {

		return dumpMagic(target, proxyClassName, new Class<?>[0], params);
	}

	public static byte[] dumpMagic(Class<?> target, String proxyClassName, Class<?>[] typeArguemntes, Object[] params) throws Exception {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

		MixinAdvAsmBuilder bw = new MixinAdvAsmBuilder(Opcodes.ASM8, cw, target, proxyClassName);

		bw.dumpMagicClass(Clazz.of(typeArguemntes), params);

		return cw.toByteArray();
	}

	public MixinAdvAsmBuilder(int api, ClassVisitor classVisitor, Class<?> target, String proxyClassName) {
		super(api, classVisitor);
		this.target = target;
		this.proxyClassName = proxyClassName;
		this.targetClazz = Clazz.of(target);
		this.mOldName = target.getName().replace('.', '/');
		this.mNewName = proxyClassName.replace('.', '/');
		int pos = mOldName.indexOf('$');
		if (pos > 0) {
			mOldBase = mOldName.substring(0, pos);
		}
		pos = mNewName.indexOf('$');
		if (pos > 0) {
			mNewBase = mNewName.substring(0, pos);
		}
	}

	private final String mOldName;
	private final String mNewName;
	private String mOldBase;
	private String mNewBase;

	private Class<?> classLambda;

	Map<String, List<String>> methodLocals;

	private void dumpMagicClass(Clazz[] actualTypeArguments) throws Exception {

		String lambdaClassName = this.target.getName() + "$Lambda";
		MixinLambdaAdvAsmBuilder mixinLambdaAdvAsmBuilder = MixinLambdaAdvAsmBuilder.dumpMagic(this.target, lambdaClassName);
		byte[] lambdaCode = mixinLambdaAdvAsmBuilder.toByteArray();
		this.methodLocals = mixinLambdaAdvAsmBuilder.methodLocals;

		classLambda = TinyAsmClassLoader.defineClass(lambdaClassName, lambdaCode);
		TinyAsmClassLoader.doResolveClass(classLambda);

		this.proxyActualTypeArguments = actualTypeArguments;

		ClassHeader ch = ClassBuilder.class_(cv, proxyClassName);
//		if(superName)
		if (actualTypeArguments.length > 0) {
			ch.extends_(Clazz.of(targetClazz, proxyActualTypeArguments));
		} else {
			ch.extends_(targetClazz);
		}

		proxyClassBody = ch.body();
//
		__init_TargetClass(proxyClassBody, targetClazz);

		resolveClass(targetClazz, actualTypeArguments);
		doresolveClass(0);
		finish();
	}

	Object[] params;

	private void dumpMagicClass(Clazz[] actualTypeArguments, Object[] params) throws Exception {
		this.params = params;

		String lambdaClassName = this.target.getName() + "$Lambda";
		MixinLambdaAdvAsmBuilder mixinLambdaAdvAsmBuilder = MixinLambdaAdvAsmBuilder.dumpMagic(this.target, lambdaClassName);
		byte[] lambdaCode = mixinLambdaAdvAsmBuilder.toByteArray();
		this.methodLocals = mixinLambdaAdvAsmBuilder.methodLocals;

		classLambda = TinyAsmClassLoader.defineClass(lambdaClassName, lambdaCode);
		TinyAsmClassLoader.doResolveClass(classLambda);

		this.proxyActualTypeArguments = actualTypeArguments;

		ClassHeader ch = ClassBuilder.class_(cv, proxyClassName);
//		if(superName)
		if (actualTypeArguments.length > 0) {
			ch.extends_(Clazz.of(targetClazz, proxyActualTypeArguments));
		} else {
			ch.extends_(targetClazz);
		}

		proxyClassBody = ch.body();

		__init_TargetClass(proxyClassBody, targetClazz);

		resolveClass(targetClazz, actualTypeArguments);
		doresolveClass(0);
		finish();
	}

	final Class<?> target;

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {

		if (name.startsWith("<")) return null;

		if ((access & (ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC)) > 0 && "(Lcn/sj1/tinyasm/core/MethodCode;)V".equals(desc)) {
			return null;
		}

		AdvMethodInfo methodInfo = AdvMethodInfo.parseMethodInfo(desc, signature, current.classFormalTypeParameters);
		Clazz derivedReturnClazz = methodInfo.derivedReturnClazz;

		MethodHeader mh = proxyClassBody.method(access, name);

		mh.return_(derivedReturnClazz);

		List<String> locals = methodLocals.get(name + desc);
		assert locals != null : "方法名称应该存在";

		if (exceptions != null && exceptions.length > 0) {
			mh.throws_(exceptions);
		}

		desc = renameMethodDesc(desc);
		signature = renameTypeSignature(signature);

		return new MixinMethodAdapter(mh, methodInfo, locals);

	}

	/**
	 * A method visitor that renames all references from an old class name to a new
	 * class name.
	 */
	public class MixinMethodAdapter extends MethodVisitor {
		MethodCode code;
		MethodVisitor cv;
		final MethodHeader mh;
		final AdvMethodInfo methodInfo;
		final List<String> locals;

		/**
		 * 
		 * @param mh
		 * @param methodInfo
		 * @param locals
		 */
		public MixinMethodAdapter(MethodHeader mh, AdvMethodInfo methodInfo, List<String> locals) {
			super(Opcodes.ASM8);
			this.mh = mh;
			this.methodInfo = methodInfo;
			this.locals = locals;
		}

		int parameterIndex = 0;

		@Override
		public void visitParameter(String name, int access) {
			logger.debug("visitParameter {}", name);
			mh.parameter(name, methodInfo.derivedParamClazzes[parameterIndex]);
			parameterIndex++;
		}

		@Override
		public AnnotationVisitor visitAnnotationDefault() {
			return cv.visitAnnotationDefault();
		}

		@Override
		public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
			return cv.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
		}

		@Override
		public void visitAnnotableParameterCount(int parameterCount, boolean visible) {
			cv.visitAnnotableParameterCount(parameterCount, visible);
		}

		@Override
		public void visitAttribute(Attribute attribute) {
			cv.visitAttribute(attribute);
		}

		@Override
		public void visitCode() {
			if (parameterIndex < methodInfo.derivedParamClazzes.length) {
				for (int i = parameterIndex; i < proxyActualTypeArguments.length; i++) {
					mh.parameter("param" + i, methodInfo.derivedParamClazzes[parameterIndex]);
				}
			}
			this.code = mh.begin();
			this.cv = code.getMethodVisitor();
			Mixin.enterCode(code, params);
		}

		@Override
		public void visitFrame(int type, int numLocal, Object[] local, int numStack, Object[] stack) {
			cv.visitFrame(type, numLocal, local, numStack, stack);
		}

		@Override
		public void visitInsn(int opcode) {
			cv.visitInsn(opcode);
		}

		@Override
		public void visitIntInsn(int opcode, int operand) {
			cv.visitIntInsn(opcode, operand);
		}

		@Override
		public void visitVarInsn(int opcode, int var) {
			cv.visitVarInsn(opcode, var);
		}

		String lastDynamicName;

		@Override
		public void visitInvokeDynamicInsn(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
			logger.debug("", name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments);
			if ("()Lcn/sj1/tinyasm/core/ConsumerWithException;".equals(descriptor)) {
				Handle handle = (Handle) bootstrapMethodArguments[1];
				lastDynamicName = handle.getName();
			} else {
				cv.visitInvokeDynamicInsn(name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments);
			}
		}

		@Override
		public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
			if (opcode == INVOKESTATIC && name.equals("__") && desc.equals("(Lcn/sj1/tinyasm/core/ConsumerWithException;)V")) {
				try {
					Method method = classLambda.getMethod(lastDynamicName.replace('$', '_'), MethodCode.class);
					method.invoke(null, code);
				} catch (Exception e) {
					throw new UnsupportedOperationException(e);
				}

			} else {
				owner = renameInternalType(owner);
				desc = renameMethodDesc(desc);
				cv.visitMethodInsn(opcode, owner, name, desc, itf);
			}
		}

		@Override
		public void visitJumpInsn(int opcode, Label label) {
			cv.visitJumpInsn(opcode, label);
		}

		@Override
		public void visitLabel(Label label) {
			cv.visitLabel(label);
		}

		@Override
		public void visitIincInsn(int var, int increment) {
			cv.visitIincInsn(var, increment);
		}

		@Override
		public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
			cv.visitTableSwitchInsn(min, max, dflt, labels);
		}

		@Override
		public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
			cv.visitLookupSwitchInsn(dflt, keys, labels);
		}

		@Override
		public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
			return cv.visitInsnAnnotation(typeRef, typePath, descriptor, visible);
		}

		@Override
		public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
			return cv.visitTryCatchAnnotation(typeRef, typePath, descriptor, visible);
		}

		@Override
		public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String descriptor, boolean visible) {
			return cv.visitLocalVariableAnnotation(typeRef, typePath, start, end, index, descriptor, visible);
		}

		@Override
		public void visitLineNumber(int line, Label start) {
			cv.visitLineNumber(line, start);
		}

		@Override
		public void visitMaxs(int maxStack, int maxLocals) {
			cv.visitMaxs(maxStack, maxLocals);
		}

		@Override
		public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
			desc = renameTypeDesc(desc);

			return cv.visitAnnotation(desc, visible);
		}

		@Override
		public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
			desc = renameTypeDesc(desc);

			return cv.visitParameterAnnotation(parameter, desc, visible);
		}

		@Override
		public void visitTypeInsn(int opcode, String type) {
			type = renameInternalType(type);

			cv.visitTypeInsn(opcode, type);
		}

		@Override
		public void visitFieldInsn(int opcode, String owner, String name, String desc) {
			owner = renameInternalType(owner);
			desc = renameTypeDesc(desc);

			cv.visitFieldInsn(opcode, owner, name, desc);
		}

		@Override
		public void visitLdcInsn(Object cst) {
			// If cst is a Type, this means the code is trying to pull the
			// .class constant
			// for this class, so it needs to be renamed too.
			if (cst instanceof Type) {
				cst = renameTypeAsType((Type) cst);
			}
			cv.visitLdcInsn(cst);
		}

		@Override
		public void visitMultiANewArrayInsn(String desc, int dims) {
			desc = renameTypeDesc(desc);

			cv.visitMultiANewArrayInsn(desc, dims);
		}

		@Override
		public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
			type = renameInternalType(type);

			cv.visitTryCatchBlock(start, end, handler, type);
		}

		@Override
		public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
//			desc = renameTypeDesc(desc);
//			signature = renameFieldSignature(signature);
//
//			super.visitLocalVariable(name, desc, signature, start, end, index);
		}

		@Override
		public void visitEnd() {
//			cv.visitEnd();
			Mixin.exitCode();
			code.END();
		}

	}

	private ClassBody proxyClassBody;
	private String proxyClassName;
	private Current current;
	private final Clazz targetClazz;
	private Clazz[] proxyActualTypeArguments;
	private List<Clazz> resolveTargetClassList = new ArrayList<>();
	private List<Clazz[]> resolveactualTypeArgumentsList = new ArrayList<>();

	private void resolveClass(Clazz target, Clazz[] actualTypeArguments) {
		resolveTargetClassList.add(target);
		resolveactualTypeArgumentsList.add(actualTypeArguments);
	}

	private void doresolveClass(int index) {
		Clazz target = resolveTargetClassList.get(index);
		Clazz[] actualTypeArguments = resolveactualTypeArgumentsList.get(index);
		Current last = this.current;
		this.current = new Current();
		this.current.clazz = target;
//		current.targetClazz = target;
		current.actualTypeArguments = actualTypeArguments;

		try {
			ClassReader cr = new ClassReader(target.getType().getClassName());
			cr.accept(this, ClassReader.EXPAND_FRAMES);
		} catch (IOException e) {
			throw new UnsupportedOperationException(e);
		}

		this.current = last;

		if (index + 1 < resolveTargetClassList.size()) {
			doresolveClass(index + 1);
		}

	}

	public void finish() {
	}

	private void __init_TargetClass(ClassBody classBody, Clazz targetClazz) {
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
			ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM8);
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

	class Current {
		Clazz[] actualTypeArguments;
		List<ClazzFormalTypeParameter> classFormalTypeParameters = new ArrayList<>();
		List<AdvAsmProxyBridgeMethod> bridgeMethods = new ArrayList<>();
		public Clazz clazz;
		public String currentName;
	}

	/********************************************************************************************************************************************
	 * 
	 * 
	 * 共同部分代码，简化主函数逻辑
	 * 
	 * 
	 * 
	 ********************************************************************************************************************************************/

	public class RenameSignatureAdapter extends SignatureVisitor {

		private final SignatureVisitor mSv;

		public RenameSignatureAdapter(SignatureVisitor sv) {
			super(Opcodes.ASM8);
			mSv = sv;
		}

		public void visitClassType(String name) {
			name = renameInternalType(name);
			mSv.visitClassType(name);
		}

		public void visitInnerClassType(String name) {
			name = renameInternalType(name);
			mSv.visitInnerClassType(name);
		}

		public SignatureVisitor visitArrayType() {
			SignatureVisitor sv = mSv.visitArrayType();
			return new RenameSignatureAdapter(sv);
		}

		public void visitBaseType(char descriptor) {
			mSv.visitBaseType(descriptor);
		}

		public SignatureVisitor visitClassBound() {
			SignatureVisitor sv = mSv.visitClassBound();
			return new RenameSignatureAdapter(sv);
		}

		public void visitEnd() {
			mSv.visitEnd();
		}

		public SignatureVisitor visitExceptionType() {
			SignatureVisitor sv = mSv.visitExceptionType();
			return new RenameSignatureAdapter(sv);
		}

		public void visitFormalTypeParameter(String name) {
			mSv.visitFormalTypeParameter(name);
		}

		public SignatureVisitor visitInterface() {
			SignatureVisitor sv = mSv.visitInterface();
			return new RenameSignatureAdapter(sv);
		}

		public SignatureVisitor visitInterfaceBound() {
			SignatureVisitor sv = mSv.visitInterfaceBound();
			return new RenameSignatureAdapter(sv);
		}

		public SignatureVisitor visitParameterType() {
			SignatureVisitor sv = mSv.visitParameterType();
			return new RenameSignatureAdapter(sv);
		}

		public SignatureVisitor visitReturnType() {
			SignatureVisitor sv = mSv.visitReturnType();
			return new RenameSignatureAdapter(sv);
		}

		public SignatureVisitor visitSuperclass() {
			SignatureVisitor sv = mSv.visitSuperclass();
			return new RenameSignatureAdapter(sv);
		}

		public void visitTypeArgument() {
			mSv.visitTypeArgument();
		}

		public SignatureVisitor visitTypeArgument(char wildcard) {
			SignatureVisitor sv = mSv.visitTypeArgument(wildcard);
			return new RenameSignatureAdapter(sv);
		}

		public void visitTypeVariable(String name) {
			mSv.visitTypeVariable(name);
		}

	}

	/**
	 * Renames a type descriptor, e.g. "Lcom.package.MyClass;" If the type doesn't
	 * need to be renamed, returns the input string as-is.
	 */
	String renameTypeDesc(String desc) {
		if (desc == null) {
			return null;
		}

		return renameType(Type.getType(desc));
	}

	/**
	 * Renames an object type, e.g. "Lcom.package.MyClass;" or an array type that
	 * has an object element, e.g. "[Lcom.package.MyClass;" If the type doesn't need
	 * to be renamed, returns the internal name of the input type.
	 */
	String renameType(Type type) {
		if (type == null) {
			return null;
		}

		if (type.getSort() == Type.OBJECT) {
			String in = type.getInternalName();
			return "L" + renameInternalType(in) + ";";
		} else if (type.getSort() == Type.ARRAY) {
			StringBuilder sb = new StringBuilder();
			for (int n = type.getDimensions(); n > 0; n--) {
				sb.append('[');
			}
			sb.append(renameType(type.getElementType()));
			return sb.toString();
		}
		return type.getDescriptor();
	}

	/**
	 * Renames an object type, e.g. "Lcom.package.MyClass;" or an array type that
	 * has an object element, e.g. "[Lcom.package.MyClass;". This is like
	 * renameType() except that it returns a Type object. If the type doesn't need
	 * to be renamed, returns the input type object.
	 */
	Type renameTypeAsType(Type type) {
		if (type == null) {
			return null;
		}

		if (type.getSort() == Type.OBJECT) {
			String in = type.getInternalName();
			String newIn = renameInternalType(in);
			if (newIn != in) {
				return Type.getType("L" + newIn + ";");
			}
		} else if (type.getSort() == Type.ARRAY) {
			StringBuilder sb = new StringBuilder();
			for (int n = type.getDimensions(); n > 0; n--) {
				sb.append('[');
			}
			sb.append(renameType(type.getElementType()));
			return Type.getType(sb.toString());
		}
		return type;
	}

	/**
	 * Renames an internal type name, e.g. "com.package.MyClass". If the type
	 * doesn't need to be renamed, returns the input string as-is.
	 * <p/>
	 * The internal type of some of the MethodVisitor turns out to be a type
	 * descriptor sometimes so descriptors are renamed too.
	 */
	String renameInternalType(String type) {
		if (type == null) {
			return null;
		}

		if (type.equals(mOldName)) {
			return mNewName;
		}

		if (mOldBase != mOldName && type.equals(mOldBase)) {
			return mNewBase;
		}

		int pos = type.indexOf('$');
		if (mOldBase != null && pos == mOldBase.length() && type.startsWith(mOldBase)) {
			return mNewBase + type.substring(pos);
		}

		// The internal type of some of the MethodVisitor turns out to be a type
		// descriptor sometimes. This is the case with visitTypeInsn(type) and
		// visitMethodInsn(owner). We try to detect it and adjust it here.
		if (type.indexOf(';') > 0) {
			type = renameTypeDesc(type);
		}

		return type;
	}

	/**
	 * Renames a method descriptor, i.e. applies renameType to all arguments and to
	 * the return value.
	 */
	String renameMethodDesc(String desc) {
		if (desc == null) {
			return null;
		}

		Type[] args = Type.getArgumentTypes(desc);

		StringBuilder sb = new StringBuilder("(");
		for (Type arg : args) {
			String name = renameType(arg);
			sb.append(name);
		}
		sb.append(')');

		Type ret = Type.getReturnType(desc);
		String name = renameType(ret);
		sb.append(name);

		return sb.toString();
	}

	/**
	 * Renames the ClassSignature handled by ClassVisitor.visit or the
	 * MethodTypeSignature handled by ClassVisitor.visitMethod.
	 */
	String renameTypeSignature(String sig) {
		if (sig == null) {
			return null;
		}
		SignatureReader reader = new SignatureReader(sig);
		SignatureWriter writer = new SignatureWriter();
		reader.accept(new RenameSignatureAdapter(writer));
		sig = writer.toString();
		return sig;
	}

	/**
	 * Renames the FieldTypeSignature handled by ClassVisitor.visitField or
	 * MethodVisitor.visitLocalVariable.
	 */
	String renameFieldSignature(String sig) {
		if (sig == null) {
			return null;
		}
		SignatureReader reader = new SignatureReader(sig);
		SignatureWriter writer = new SignatureWriter();
		reader.acceptType(new RenameSignatureAdapter(writer));
		sig = writer.toString();
		return sig;
	}

}
