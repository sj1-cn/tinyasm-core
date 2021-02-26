package cc1sj.tinyasm;

import static cc1sj.tinyasm.TinyAsmProxyBase._code;
import static cc1sj.tinyasm.TinyAsmProxyBase._interface;
import static cc1sj.tinyasm.TinyAsmProxyBase._invoke;
import static cc1sj.tinyasm.TinyAsmProxyBase._line;
import static cc1sj.tinyasm.TinyAsmProxyBase._parameter;
import static cc1sj.tinyasm.TinyAsmProxyBase._refer;
import static cc1sj.tinyasm.TinyAsmProxyBase._resolveParameter;
import static cc1sj.tinyasm.TinyAsmProxyBase._resolveThis;
import static cc1sj.tinyasm.TinyAsmProxyBase._return;
import static cc1sj.tinyasm.TinyAsmProxyBase._virtual;
import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
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

class TinyAsmProxyForInterfaceAsmBuilder extends ClassVisitor implements TinyAsmProxyBase {

	public static byte[] dump(Class<?> targetClass, String suffix) throws Exception {
		Type targetType = Type.getType(targetClass);
		String clazzName = targetType.getClassName() + suffix;
		ClassBody classBody = ClassBuilder.make(clazzName).eXtend(Clazz.of(targetType)).implement(TinyAsmProxyRuntimeReferNameObject.class)
				.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.field(ACC_PRIVATE, "_referName", Clazz.of(String.class));
		classBody.field(ACC_PRIVATE, "_code", Clazz.of(MethodCode.class));

		init(classBody, targetClass);

		get__ReferName(classBody);

		__init(classBody);

		method_getProperty(classBody, targetType, String.class, "getName");

		method_getProperty(classBody, targetType, char.class, "getAgeChar");
		method_getProperty(classBody, targetType, byte.class, "getAgeByte");
		method_getProperty(classBody, targetType, short.class, "getAgeShort");
		method_getProperty(classBody, targetType, int.class, "getAgeInt");
		method_getProperty(classBody, targetType, long.class, "getAgeLong");
		method_getProperty(classBody, targetType, float.class, "getAgeFloat");
		method_getProperty(classBody, targetType, double.class, "getAgeDouble");

		method_getProperty(classBody, targetType, Character.class, "getAgeCharacter");
		method_getProperty(classBody, targetType, Byte.class, "getAgeByte2");
		method_getProperty(classBody, targetType, Short.class, "getAgeShort2");
		method_getProperty(classBody, targetType, Integer.class, "getAgeInteger");
		method_getProperty(classBody, targetType, Long.class, "getAgeLong2");
		method_getProperty(classBody, targetType, Float.class, "getAgeFloat2");
		method_getProperty(classBody, targetType, Double.class, "getAgeDouble2");

		method_setProperty(targetType, classBody, "setName", String.class);

		method_setProperty(targetType, classBody, "setAgeChar", char.class);
		method_setProperty(targetType, classBody, "setAgeByte", byte.class);
		method_setProperty(targetType, classBody, "setAgeShort", short.class);
		method_setProperty(targetType, classBody, "setAgeInt", int.class);
		method_setProperty(targetType, classBody, "setAgeLong", long.class);
		method_setProperty(targetType, classBody, "setAgeFloat", float.class);
		method_setProperty(targetType, classBody, "setAgeDouble", double.class);

		method_setProperty(targetType, classBody, "setAgeCharacter", Character.class);
		method_setProperty(targetType, classBody, "setAgeByte2", Byte.class);
		method_setProperty(targetType, classBody, "setAgeShort2", Short.class);
		method_setProperty(targetType, classBody, "setAgeInteger", Integer.class);
		method_setProperty(targetType, classBody, "setAgeLong2", Long.class);
		method_setProperty(targetType, classBody, "setAgeFloat2", Float.class);
		method_setProperty(targetType, classBody, "setAgeDouble2", Double.class);

		return classBody.end().toByteArray();
	}

	protected static void init(ClassBody classBody, Class<?> targetClass) {
		{
			MethodCode code = classBody.method("<init>").begin();

			code.LINE(14);
			code.LOAD("this");
			code.SPECIAL(Clazz.of(targetClass), "<init>").INVOKE();

			code.RETURN();
			code.END();
		}
	}

	protected static void __init(ClassBody classBody) {
		{
			MethodCode code = classBody.method("__init").parameter("code", MethodCode.class).parameter("name", String.class).begin();

			code.LINE(21);
			code.LOAD("this");
			code.LOAD("code");
			code.PUTFIELD("_code", MethodCode.class);

			code.LINE(22);
			code.LOAD("this");
			code.LOAD("name");
			code.PUTFIELD("_referName", String.class);

			code.LINE(23);
			code.RETURN();
			code.END();
		}
	}

	protected static void get__ReferName(ClassBody classBody) {
		{
			MethodCode code = classBody.method(String.class, "get__ReferName").begin();

			code.LINE(16);
			code.LOAD("this");
			code.GETFIELD("_referName", String.class);
			code.RETURNTop();
			code.END();
		}
	}

	private static void method_setProperty(Type targetType, ClassBody classBody, String methodName, Class<?> paramsClass) {
		String param1 = "value";

		MethodHeader mh = classBody.method(methodName).parameter(param1, paramsClass);

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

	private static void method_getProperty(ClassBody classBody, Type targetType, Class<?> returnClass, String methodName) {
		method_getProperty(classBody, targetType, Clazz.of(returnClass), methodName);

	}

	private static void method_getProperty(ClassBody classBody, Type targetType, Clazz returnClass, String methodName) {

		MethodHeader mh = classBody.method(returnClass, methodName);
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

	public static byte[] dump2(Class<?> target, String proxyClassName) throws Exception {
		ClassReader cr = new ClassReader(target.getName());
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

		ClassVisitor bw;
//		target.getConstructor();
		bw = new TinyAsmProxyForInterfaceAsmBuilder(Opcodes.ASM5, cw,Type.getType(target).getInternalName(), proxyClassName);
		cr.accept(bw, ClassReader.SKIP_CODE);

		Class<?> superClass = target.getSuperclass();
		while(superClass!=null && superClass != Object.class) {
			cr = new ClassReader(superClass.getName());
			cr.accept(bw, ClassReader.SKIP_CODE);
			
			superClass = superClass.getSuperclass();
		}
		
//		String[] is = cr.getInterfaces();
//		for (String s : is) {
//			cr = new ClassReader(s);
//			cr.accept(bw, ClassReader.SKIP_CODE);
//		}
//		
		
		return cw.toByteArray();
	}

	ClassBody classBody;
	String proxyClassName;
	Type targetType;
	Type objectType;

	public TinyAsmProxyForInterfaceAsmBuilder(int api, String name, String proxyClassName) {
		super(api);
		this.proxyClassName = proxyClassName;
		mkProxyClass(name);
	}

	public TinyAsmProxyForInterfaceAsmBuilder(int api, ClassVisitor classVisitor, String name, String proxyClassName) {
		super(api, classVisitor);
		this.proxyClassName = proxyClassName;

		mkProxyClass(name);
	}

	protected void mkProxyClass(String name) {
		targetType = Type.getObjectType(name);
		objectType = Type.getObjectType(proxyClassName.replace('.', '/'));
		ClassHeader ch = ClassBuilder.make(cv, proxyClassName);
//		if(superName)
//		ch.eXtend(Clazz.of(targetType));
		ch.implement(Clazz.of(targetType));
		ch.implement(TinyAsmProxyRuntimeReferNameObject.class);
//		ch.access(access);
		classBody = ch.body();

		classBody.field(ACC_PRIVATE, "_referName", Clazz.of(String.class));
		classBody.field(ACC_PRIVATE, "_code", Clazz.of(MethodCode.class));

		{
			MethodCode code1 = classBody.method("<init>").begin();

			code1.LINE(14);
			code1.LOAD("this");
			code1.SPECIAL(Clazz.of(Object.class), "<init>").INVOKE();

			code1.RETURN();
			code1.END();
		}

		get__ReferName(classBody);

		__init(classBody);
	}

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
//		super.visit(version, access, name, signature, superName, interfaces);

	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {

//		stringBuilder.setLength(0);
////		stringBuilder.append("{\n");
//		if (!methodIsStatic) {
//			stringBuilder.append("classBody.method(");
//			if (access != (ACC_PUBLIC)) {
//				appendAccessFlags(access);
//				stringBuilder.append(", ");
//			}
//		} else {
//			stringBuilder.append("classBody.staticMethod(");
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

			MethodHeader mh = classBody.method(returnClazz, name);
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
			_interface(code, targetType, name);
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
		super.visitAttribute(attribute);
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
