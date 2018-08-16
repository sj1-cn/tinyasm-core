package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.internalNamesOf;
import static nebula.tinyasm.util.TypeUtils.is;
import static nebula.tinyasm.util.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import nebula.tinyasm.data.Annotation;
import nebula.tinyasm.data.ArrayListMap;
import nebula.tinyasm.data.GenericClazz;
import nebula.tinyasm.data.MethodCode;
import nebula.tinyasm.data.MethodHeader;

class MethodHeaderBuilder implements MethodHeader {
	class ThisMethod {

		String name;

		Type type;
		boolean hasEnded = false;
		boolean instanceMethod = true;
	}

	ThisMethod thisMethod;
	int access;

	final private ClassVisitor classVisitor;

	protected Label labelCurrent;

	boolean labelHasDefineBegin = false;

	Type stackTopType;

	final LocalsStack mhLocals = new LocalsStack();
	final ArrayListMap<LocalsVariable> params = new ArrayListMap<>();
	final List<Annotation> annotations = new ArrayList<>();
	final ArrayListMap<ClassField> fields;
	final ArrayListMap<ClassField> staticFields;

	MethodVisitor mv;

	final List<GenericClazz> exceptions = new ArrayList<>();
	GenericClazz returnClazz = null;

	public MethodHeaderBuilder(ClassBodyImpl cv, boolean isInstanceMethod, String className, int access,
			String returnType, String methodName) {
		this(cv, isInstanceMethod, className, access, methodName);
		this.returnClazz = returnType != null ? GenericClazz.clazz(returnType) : null;
	}

	public MethodHeaderBuilder(ClassBodyImpl cv, boolean instanceMethod, String className, int access,
			String methodName) {
		this.classVisitor = cv;
		thisMethod = new ThisMethod();
		thisMethod.name = methodName;
		this.access = access;
		thisMethod.type = typeOf(className);
		thisMethod.instanceMethod = instanceMethod;
		this.fields = cv.fields;
		this.staticFields = cv.staticFields;
	}
//
//	@Override
//	public MethodHeader annotation(String clazz, Object value) {
//		thisMethod.annotations.add(new ClassAnnotation(type, null, value));
//		return this;
//	}

	@Override
	public MethodHeader annotation(String clazz, Object defaultValue, String[] names, Object[] values) {
		annotations.add(new Annotation(clazz, defaultValue, names, values));
		return this;
	}

//	@Override
//	public MethodHeader annotation(Type type, Object value) {
//		thisMethod.annotations.add(new ClassAnnotation(type, null, value));
//		return this;
//	}
//
//	@Override
//	public MethodHeader annotation(Type type, String name, Object value) {
//		thisMethod.annotations.add(new ClassAnnotation(type, name, value));
//		return this;
//	}

	@Override
	public MethodCode begin() {
		prapareMethodDefination();
		mv.visitCode();
		labelCurrent = labelWithoutLineNumber();
		preapareMethodWithClazz();
		preapareMethodWithThis();
		preapareMethodWithParams();

		return makeCode(mv);
	}

	@Override
	public void code(Consumer<MethodCode> invocation) {
		MethodCode mc = this.begin();
		invocation.accept(mc);
		this.codeEnd();
	}

	void codeEnd() {
		finishMethod();
	}

	protected void finishMethod() {
		if (thisMethod.hasEnded) return;
		Label endLabel = this.labelWithoutLineNumber();
		for (LocalsVariable var : mhLocals) {
			if (!is(var.access, ACC_SYNTHETIC)) {
				assert mv != null;
				assert var != null;
				assert var.clazz.getDescriptor() != null;
				Label labelfrom = var.startFrom != null ? var.startFrom : labelCurrent;
				mv.visitLocalVariable(var.name, var.clazz.getDescriptor(), var.clazz.signatureWhenNeed(), labelfrom,
						endLabel, var.locals);
			}
		}
		mv.visitMaxs(0, 0);
		mv.visitEnd();
		thisMethod.hasEnded = true;
	}

	protected Label labelWithoutLineNumber() {
		Label label = new Label();
		labelCurrent = label;
		mv.visitLabel(label);
		return label;
	}

	MethodCode makeCode(MethodVisitor mv) {
		return new MethodCodeBuilder(mv, this, mhLocals);
	}

	@Override
	public MethodHeader annotation(Annotation annotation) {
		annotations.add(annotation);
		return this;
	}

	@Override
	public MethodHeader parameter(String name, GenericClazz clazz) {
		LocalsVariable param = new LocalsVariable(name, clazz);
		params.push(param.name, param);
		return this;
	}

	@Override
	public MethodHeader parameter(Annotation annotation, String name, GenericClazz clazz) {
		LocalsVariable param = new LocalsVariable(annotation, name, clazz);
		params.push(param.name, param);
		return this;
	}

	protected void prapareMethodDefination() {
		{
			int access = this.access;
			String name = thisMethod.name;

			Type returnType;
			if (returnClazz != null) returnType = Type.getType(returnClazz.getDescriptor());
			else
				returnType = Type.VOID_TYPE;

			String desc = Type.getMethodDescriptor(returnType, ClassField.typesOf(params.list()));
			String signature = null;
			boolean needSignature = false;
			{
				StringBuilder sb = new StringBuilder();
				sb.append("(");
				for (ClassField param : params) {
					if (param.clazz.needSignature()) {
						sb.append(param.clazz.signatureAnyway());
						needSignature = true;
					} else {
						sb.append(param.clazz.getDescriptor());
					}
				}
				sb.append(")");
				if (returnClazz != null) {
					needSignature |= returnClazz.needSignature();
					sb.append(returnClazz.signatureAnyway());
				} else {
					sb.append(returnType.getDescriptor());

				}
				String signatureFromParameter = sb.toString();

				if (needSignature) {
					signature = signatureFromParameter;
				}
			}
			String[] exceptions = internalNamesOf(this.exceptions);

			this.mv = classVisitor.visitMethod(access, name, desc, signature, exceptions);
		}

		assert this.mv != null;
		for (Annotation annotation : annotations) {
			Annotation.visitAnnotation(this.mv, annotation);
		}
		for (int i = 0; i < params.size(); i++) {
			LocalsVariable param = params.get(i);
			if (param.annotation != null) {
				Annotation.visitParameterAnnotation(this.mv, i, param.annotation);
			}
		}
	}

	protected void preapareMethodWithClazz() {
	}

	protected void preapareMethodWithParams() {
		for (ClassField field : params) {
			mhLocals.push(new LocalsVariable(field, labelCurrent));
		}
	}

	protected void preapareMethodWithThis() {
		if (thisMethod.instanceMethod) {
			mhLocals.push("this", GenericClazz.clazz(thisMethod.type.getClassName()), labelCurrent);
		}
	}

	@Override
	public MethodHeader tHrow(GenericClazz clazz) {
		exceptions.add(clazz);
		return this;
	}

	@Override
	public MethodHeader access(int access) {
		this.access |= access;
		return this;
	}

	@Override
	public MethodHeader reTurn(GenericClazz clazz) {
		this.returnClazz = clazz;
		return this;
	}

//
//	@Override
//	public MethodHeader tHrow(String... clazzes) {
//		for (String clazz : clazzes) {
//			exceptions.add(clazz, null));
//		}
//		return this;
//	}
}