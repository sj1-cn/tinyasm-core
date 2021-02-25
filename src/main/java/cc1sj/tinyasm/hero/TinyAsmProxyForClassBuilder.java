package cc1sj.tinyasm.hero;

import static cc1sj.tinyasm.hero.TinyAsmProxyBase._code;
import static cc1sj.tinyasm.hero.TinyAsmProxyBase._invoke;
import static cc1sj.tinyasm.hero.TinyAsmProxyBase._line;
import static cc1sj.tinyasm.hero.TinyAsmProxyBase._parameter;
import static cc1sj.tinyasm.hero.TinyAsmProxyBase._refer;
import static cc1sj.tinyasm.hero.TinyAsmProxyBase._resolveParameter;
import static cc1sj.tinyasm.hero.TinyAsmProxyBase._resolveThis;
import static cc1sj.tinyasm.hero.TinyAsmProxyBase._return;
import static cc1sj.tinyasm.hero.TinyAsmProxyBase._virtual;
import static cc1sj.tinyasm.hero.TinyAsmProxyBase.method_getHero;
import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_NATIVE;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.TypePath;

import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.ClassHeader;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.MethodHeader;

class TinyAsmProxyForClassBuilder extends ClassVisitor implements TinyAsmProxyBase {

	public static byte[] dump(Class<?> targetClass, String suffix) throws Exception {
		Type targetType = Type.getType(targetClass);
		String clazzName = targetType.getClassName() + suffix;
		ClassBody classWriter = ClassBuilder.make(clazzName).eXtend(Clazz.of(targetType))
				.implement(TinyAsmProxyRuntimeReferNameObject.class).access(ACC_PUBLIC | ACC_SUPER).body();

		classWriter.field(ACC_FINAL, "_referName", Clazz.of(String.class));
		classWriter.field(0, "_code", Clazz.of(MethodCode.class));

		classWriter.method("<init>").parameter("code", MethodCode.class).parameter("__referName", String.class).code(code -> {

			code.LINE(14);
			code.LOAD("this");
			code.SPECIAL(Clazz.of(targetClass), "<init>").INVOKE();

			code.LINE(15);
			code.LOAD("this");
			code.LOAD("__referName");
			code.PUTFIELD("_referName", String.class);

			code.LINE(17);
			code.LOAD("this");
			code.LOAD("code");
			code.PUTFIELD("_code", MethodCode.class);

			code.LINE(18);
			code.RETURN();
		});
		method_getHero(classWriter);

		method_getProperty(classWriter, targetType, String.class, "getName");

		method_getProperty(classWriter, targetType, char.class, "getAgeChar");
		method_getProperty(classWriter, targetType, byte.class, "getAgeByte");
		method_getProperty(classWriter, targetType, short.class, "getAgeShort");
		method_getProperty(classWriter, targetType, int.class, "getAgeInt");
		method_getProperty(classWriter, targetType, long.class, "getAgeLong");
		method_getProperty(classWriter, targetType, float.class, "getAgeFloat");
		method_getProperty(classWriter, targetType, double.class, "getAgeDouble");

		method_getProperty(classWriter, targetType, Character.class, "getAgeCharacter");
		method_getProperty(classWriter, targetType, Byte.class, "getAgeByte2");
		method_getProperty(classWriter, targetType, Short.class, "getAgeShort2");
		method_getProperty(classWriter, targetType, Integer.class, "getAgeInteger");
		method_getProperty(classWriter, targetType, Long.class, "getAgeLong2");
		method_getProperty(classWriter, targetType, Float.class, "getAgeFloat2");
		method_getProperty(classWriter, targetType, Double.class, "getAgeDouble2");

		method_setProperty(targetType, classWriter, "setName", String.class);

		method_setProperty(targetType, classWriter, "setAgeChar", char.class);
		method_setProperty(targetType, classWriter, "setAgeByte", byte.class);
		method_setProperty(targetType, classWriter, "setAgeShort", short.class);
		method_setProperty(targetType, classWriter, "setAgeInt", int.class);
		method_setProperty(targetType, classWriter, "setAgeLong", long.class);
		method_setProperty(targetType, classWriter, "setAgeFloat", float.class);
		method_setProperty(targetType, classWriter, "setAgeDouble", double.class);

		method_setProperty(targetType, classWriter, "setAgeCharacter", Character.class);
		method_setProperty(targetType, classWriter, "setAgeByte2", Byte.class);
		method_setProperty(targetType, classWriter, "setAgeShort2", Short.class);
		method_setProperty(targetType, classWriter, "setAgeInteger", Integer.class);
		method_setProperty(targetType, classWriter, "setAgeLong2", Long.class);
		method_setProperty(targetType, classWriter, "setAgeFloat2", Float.class);
		method_setProperty(targetType, classWriter, "setAgeDouble2", Double.class);

		return classWriter.end().toByteArray();
	}

	private static void method_setProperty(Type targetType, ClassBody classWriter, String methodName, Class<?> paramsClass) {
		String param1 = "value";

		MethodHeader mh = classWriter.method(methodName).parameter(param1, paramsClass);

		MethodCode code = mh.begin();

		_line(code);

		_resolveThis(code);

		_resolveParameter(code, param1, Clazz.of(paramsClass));

		_code(code);
		_virtual(code, targetType, methodName);
		_parameter(code, Clazz.of(paramsClass));
		_invoke(code);

		code.LINE();
		code.RETURN();

		mh.end();
	}

	private static void method_getProperty(ClassBody classWriter, Type targetType, Class<?> returnClass, String methodName) {
		method_getProperty(classWriter, targetType, Clazz.of(returnClass), methodName);

	}

	private static void method_getProperty(ClassBody classWriter, Type targetType, Clazz returnClass, String methodName) {

		MethodHeader mh = classWriter.method(returnClass, methodName);
		MethodCode code = mh.begin();
//		 = mh.code();
		_line(code);
		// prepare this
		_resolveThis(code);

		// invoke method
		_code(code);
		_virtual(code, targetType, methodName);
		_return(code, returnClass);
		_invoke(code);

		// Refer
		_refer(code, returnClass);

		code.RETURNTop();
		mh.end();
	}

	public static byte[] dump2(Class<?> target, String suffix) throws Exception {
		ClassReader cr = new ClassReader(target.getName());
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

		ClassVisitor bw;
//		target.getConstructor();
		bw = new TinyAsmProxyForClassBuilder(Opcodes.ASM5, cw, suffix);
		cr.accept(bw, ClassReader.SKIP_CODE);
		return cw.toByteArray();
	}

	ClassBody classWriter;
	String suffix;
	Type targetType;
	Type objectType;

	public TinyAsmProxyForClassBuilder(int api, String suffix) {
		super(api);
		this.suffix = suffix;
	}

	public TinyAsmProxyForClassBuilder(int api, ClassVisitor classVisitor, String suffix) {
		super(api, classVisitor);
		this.suffix = suffix;
	}

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
//		super.visit(version, access, name, signature, superName, interfaces);

		targetType = Type.getObjectType(name);
		String proxyClassName = targetType.getClassName() + this.suffix;
		objectType = Type.getObjectType(name + this.suffix);
		ClassHeader ch = ClassBuilder.make(cv, proxyClassName);
//		if(superName)
		ch.eXtend(Clazz.of(targetType));
		ch.implement(TinyAsmProxyRuntimeReferNameObject.class);
//		ch.access(access);
		classWriter = ch.body();

		classWriter.field(ACC_FINAL, "_referName", Clazz.of(String.class));
		classWriter.field(0, "_code", Clazz.of(MethodCode.class));

		classWriter.method("<init>").parameter("code", MethodCode.class).parameter("__referName", String.class).code(code -> {

			code.LINE(14);
			code.LOAD("this");
			code.SPECIAL(Clazz.of(targetType), "<init>").INVOKE();

			code.LINE(15);
			code.LOAD("this");
			code.LOAD("__referName");
			code.PUTFIELD("_referName", String.class);

			code.LINE(17);
			code.LOAD("this");
			code.LOAD("code");
			code.PUTFIELD("_code", MethodCode.class);

			code.LINE(18);
			code.RETURN();
		});
		method_getHero(classWriter);

	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {

//		stringBuilder.setLength(0);
////		stringBuilder.append("{\n");
//		if (!methodIsStatic) {
//			stringBuilder.append("classWriter.method(");
//			if (access != (ACC_PUBLIC)) {
//				appendAccessFlags(access);
//				stringBuilder.append(", ");
//			}
//		} else {
//			stringBuilder.append("classWriter.staticMethod(");
//			if (access != (ACC_PUBLIC | ACC_STATIC)) {
//				appendAccessFlags(access);
//				stringBuilder.append(", ");
//			}
//		}

		// Return Type

		Type returnType = Type.getReturnType(descriptor);
		Clazz returnClazz = Clazz.of(returnType);

		// ParamType
		Type[] methodParamTypes = Type.getArgumentTypes(descriptor);

//		List<StringBuilder> methodParamClazzes = null;
//		if (signature == null) {
//			if (returnType != Type.VOID_TYPE) {
//				stringBuilder.append(clazzOf(returnType));
//				stringBuilder.append(", ");
//			}
//			appendConstant(name);
//		} else {
//			SignatureReader sr = new SignatureReader(signature);
//			ClassSignature signatureVistor = new ClassSignature(Opcodes.ASM5);
//			sr.accept(signatureVistor);
//			stringBuilder.append(signatureVistor.returnClass.toString());
//			stringBuilder.append(", ");
//			appendConstant(name);
//			methodParamClazzes = signatureVistor.paramsClass;
////			stringBuilder.append(", ");
////			stringBuilder.append(signatureVistor.paramsClass.toString());
//		}

		// Exception

//		if (exceptions != null && exceptions.length > 0) {
////			stringBuilder.append("new String[] {");
//			for (int i = 0; i < exceptions.length; ++i) {
//				stringBuilder.append("\n\t.tHrow(");
//				stringBuilder.append(clazzOf(Type.getObjectType(exceptions[i])));
//				stringBuilder.append(" )");
//			}
//		}

		// param type
//		if (methodParamTypes.length > 0) {
//			for (int i = 0; i < methodParamTypes.length; i++) {
//				methodLocals.pushDefined("", methodParamTypes[i]);
//			}
//		}

		if (!!!name.equals("<init>") && !!!name.equals("<clinit>")
				&& (access & (ACC_STATIC | ACC_PRIVATE | ACC_SYNTHETIC | ACC_NATIVE | ACC_BRIDGE)) == 0) {

			MethodHeader mh = classWriter.method(returnClazz, name);
//			mh.access(access);
			for (int i = 0; i < methodParamTypes.length; i++) {
				mh.parameter("param" + i, Clazz.of(methodParamTypes[i]));
			}
			if (exceptions != null) for (String e : exceptions) mh.tHrow(Clazz.of(Type.getObjectType(e)));

			MethodCode code = mh.begin();
			// = mh.code();
			_line(code);
			// prepare this
			_resolveThis(code);
			for (int i = 0; i < methodParamTypes.length; i++) {
				_resolveParameter(code, "param" + i, Clazz.of(methodParamTypes[i]));
			}
			// invoke method
			_code(code);
			_virtual(code, targetType, name);
			for (Type type : methodParamTypes) {
				_parameter(code, Clazz.of(type));
			}

			if (returnType != Type.VOID_TYPE) _return(code, returnClazz);

			_invoke(code);

			// Refer
			if (returnType != Type.VOID_TYPE) {
				_refer(code, returnClazz);
				code.RETURNTop();
			} else {
				code.LINE();
				code.RETURN();
			}

			mh.end();

		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visitSource(String source, String debug) {
		super.visitSource(source.replaceAll("[.]java", this.suffix + ".java"), debug);
	}

	@Override
	public ModuleVisitor visitModule(String name, int access, String version) {
		return super.visitModule(name, access, version);
	}

	@Override
	public void visitNestHostExperimental(String nestHost) {
//		super.visitNestHostExperimental(nestHost);
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
		super.visitAttribute(attribute);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void visitNestMemberExperimental(String nestMember) {
		super.visitNestMemberExperimental(nestMember);
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
	}

}
