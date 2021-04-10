package cn.sj1.tinyasm.core;

import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
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

public class MixinLambdaAdvAsmBuilder extends ClassVisitor {
	Logger logger = LoggerFactory.getLogger(getClass());

	public static MixinLambdaAdvAsmBuilder dumpMagic(Class<?> target, String proxyClassName) {
		try {
			ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

			MixinLambdaAdvAsmBuilder bw = new MixinLambdaAdvAsmBuilder(Opcodes.ASM8, cw, target, proxyClassName);

			bw.dumpMagicClass(new Clazz[] {});

			return bw;
		} catch (IOException e) {
			throw new UnsupportedOperationException(e);
		}
	}

	private final String mOldName;
	private final String mNewName;
	private String mOldBase;
	private String mNewBase;

	private void dumpMagicClass(Clazz[] actualTypeArguments) throws IOException {
//		this.isTargetClazzKnown = false;
		ClassHeader ch = ClassBuilder.class_(cv, proxyClassName);
		proxyClassBody = ch.body();

		__init_TargetClass(proxyClassBody, Clazz.of(Object.class));

		resolveClass(targetClazz, actualTypeArguments);
		doresolveClass(0);

		finish();
	}

	final Class<?> target;
	ClassWriter classWriter;

	public MixinLambdaAdvAsmBuilder(int api, ClassWriter classWriter, Class<?> target, String proxyClassName) {
		super(api, classWriter);
		this.classWriter = classWriter;
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

	public byte[] toByteArray() {
		return this.classWriter.toByteArray();
	}

	Map<String, List<String>> methodLocals = new HashMap<String, List<String>>();

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {

		if (name.startsWith("<")) return null;

		if ((access & (ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC)) == 0) {

			List<String> locals = new ArrayList<>();
			methodLocals.put(name + desc, locals);

			return new MethodVisitor(Opcodes.ASM8) {

				@Override
				public void visitLocalVariable(String name, String descriptor, String signature, Label start, Label end, int index) {
					if (index >= locals.size()) {
						for (int i = locals.size(); i < index; i++) {
							locals.add(null);
						}
					}
					locals.add(name);

					super.visitLocalVariable(name, descriptor, signature, start, end, index);
				}

			};
		} else {
			access = ACC_PUBLIC | ACC_STATIC;

			desc = renameMethodDesc(desc);
			signature = renameTypeSignature(signature);
			MethodVisitor mw = super.visitMethod(access, name.replace('$', '_'), desc, signature, exceptions);
			return new RenameMethodAdapter(mw);
		}

	}

	/**
	 * A method visitor that renames all references from an old class name to a new
	 * class name.
	 */
	public class RenameMethodAdapter extends MethodVisitor {

		/**
		 * Creates a method visitor that renames all references from a given old name to
		 * a given new name. The method visitor will also rename all inner classes. The
		 * names must be full qualified internal ASM names (e.g.
		 * com/blah/MyClass$InnerClass).
		 */
		public RenameMethodAdapter(MethodVisitor mv) {
			super(Opcodes.ASM8, mv);
		}

		@Override
		public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
			desc = renameTypeDesc(desc);

			return super.visitAnnotation(desc, visible);
		}

		@Override
		public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
			desc = renameTypeDesc(desc);

			return super.visitParameterAnnotation(parameter, desc, visible);
		}

		@Override
		public void visitTypeInsn(int opcode, String type) {
			type = renameInternalType(type);

			super.visitTypeInsn(opcode, type);
		}

		@Override
		public void visitFieldInsn(int opcode, String owner, String name, String desc) {
			owner = renameInternalType(owner);
			desc = renameTypeDesc(desc);

			super.visitFieldInsn(opcode, owner, name, desc);
		}

		@Override
		public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
			owner = renameInternalType(owner);
			desc = renameMethodDesc(desc);

			super.visitMethodInsn(opcode, owner, name, desc, itf);
		}

		@Override
		public void visitLdcInsn(Object cst) {
			// If cst is a Type, this means the code is trying to pull the
			// .class constant
			// for this class, so it needs to be renamed too.
			if (cst instanceof Type) {
				cst = renameTypeAsType((Type) cst);
			}
			super.visitLdcInsn(cst);
		}

		@Override
		public void visitMultiANewArrayInsn(String desc, int dims) {
			desc = renameTypeDesc(desc);

			super.visitMultiANewArrayInsn(desc, dims);
		}

		@Override
		public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
			type = renameInternalType(type);

			super.visitTryCatchBlock(start, end, handler, type);
		}

		@Override
		public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
			desc = renameTypeDesc(desc);
			signature = renameFieldSignature(signature);

			super.visitLocalVariable(name, desc, signature, start, end, index);
		}

	}

	private ClassBody proxyClassBody;
	private String proxyClassName;

	private Current current;
	private final Clazz targetClazz;

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

	private void finish() {
	}

	private void __init_TargetClass(ClassBody classBody, Clazz targetClazz) {
		classBody.constructerEmpty();
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
