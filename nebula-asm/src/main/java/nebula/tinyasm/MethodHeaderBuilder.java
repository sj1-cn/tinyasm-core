package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.internalNamelOf;
import static nebula.tinyasm.util.TypeUtils.is;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.objectweb.asm.AnnotationVisitor;
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
		int access;
		List<Annotation> annotations = new ArrayList<>();
		// final Type thisType;
		String[] excptions;

		String name;

		ArrayListMap<LocalsVariable> params = new ArrayListMap<>();
		ArrayListMap<ClassField> fields;

		Type returnType;
		Type type;
		boolean hasEnded = false;
		boolean instanceMethod = true;
	}

	ThisMethod thisMethod;

	final private ClassVisitor classVisitor;

	protected Label labelCurrent;

	boolean labelHasDefineBegin = false;

	Type stackTopType;

	protected LocalsStack mhLocals = new LocalsStack();

	MethodVisitor mv;

	final List<GenericClazz> exceptions = new ArrayList<>();

	public MethodHeaderBuilder(ClassBodyImpl cv, boolean instanceMethod, Type thisType, int access, Type returnType,
			String methodName, String[] exceptiones) {
		this.classVisitor = cv;
		thisMethod = new ThisMethod();
		thisMethod.name = methodName;
		thisMethod.access = access;
		thisMethod.returnType = returnType;
		thisMethod.excptions = exceptiones;
		thisMethod.type = thisType;
		thisMethod.fields = cv.fields;
		thisMethod.instanceMethod = instanceMethod;
	}
//
//	@Override
//	public MethodHeader annotation(String clazz, Object value) {
//		thisMethod.annotations.add(new ClassAnnotation(type, null, value));
//		return this;
//	}

	@Override
	public MethodHeader annotation(String clazz, Object defaultValue, String[] names, Object[] values) {
		thisMethod.annotations.add(new Annotation(clazz, defaultValue, names, values));
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
				mv.visitLocalVariable(var.name, var.clazz.getDescriptor(), var.clazz.signatureWhenNeed(), var.startFrom,
						endLabel, var.locals);
			}
		}
		mv.visitMaxs(0, 0);
		mv.visitEnd();
		thisMethod.hasEnded = true;
	}

	protected Type getStackTopType() {
		return stackTopType;
	}

	protected Label labelWithoutLineNumber() {
		Label label = new Label();
		labelCurrent = label;
		mv.visitLabel(label);
		return label;
	}
//O
//	public MethodCode line() {
//		Label label;
//		if (!labelHasDefineBegin) {
//			label = new Label();
//			labelCurrent = label;
//			mv.visitLabel(label);
//		} else {
//			label = labelCurrent;
//		}
//		lastLineNumber = lastLineNumber + 1;
//		mv.visitLineNumber(lastLineNumber, label);
//		return code();
//	}
//
//	public MethodCode line(int line) {
//		Label label;
//		if (!labelHasDefineBegin) {
//			label = new Label();
//			labelCurrent = label;
//			mv.visitLabel(label);
//		} else {
//			label = labelCurrent;
//		}
//		lastLineNumber = line;
//		mv.visitLineNumber(line, label);
//		return code();
//	}

	MethodCode makeCode(MethodVisitor mv) {
		return new MethodCodeBuilder(mv, this, mhLocals);
	}

	public static void visitAnnotation(MethodVisitor mv, Annotation annotation) {
		AnnotationVisitor av0 = mv.visitAnnotation(annotation.getDescriptor(), true);
		if (annotation.defaultValue != null) {
			av0.visit("value", annotation.defaultValue);
		}
		if (annotation.names != null) {
			for (int i = 0; i < annotation.names.length; i++) {
				av0.visit(annotation.names[i], annotation.values[i]);
			}
		}
		av0.visitEnd();
	}

	public static void visitParameterAnnotation(MethodVisitor mv, int parameter, Annotation annotation) {
		AnnotationVisitor av0 = mv.visitParameterAnnotation(parameter, annotation.getDescriptor(), true);
		if (annotation.defaultValue != null) {
			av0.visit("value", annotation.defaultValue);
		}
		if (annotation.names != null) {
			for (int i = 0; i < annotation.names.length; i++) {
				av0.visit(annotation.names[i], annotation.values[i]);
			}
		}
		av0.visitEnd();
	}

	@Override
	public MethodHeader annotation(Annotation annotation) {
		thisMethod.annotations.add(annotation);
		return this;
	}

	@Override
	public MethodHeader parameter(String name, GenericClazz clazz) {
		LocalsVariable param = new LocalsVariable(name, clazz);
		thisMethod.params.push(param.name, param);
		return this;
	}

	@Override
	public MethodHeader parameter(Annotation annotation, String name, GenericClazz clazz) {
		LocalsVariable param = new LocalsVariable(annotation, name, clazz);
		thisMethod.params.push(param.name, param);
		return this;
	}

	protected void prapareMethodDefination() {
		{
			int access = thisMethod.access;
			String name = thisMethod.name;
			String desc = Type.getMethodDescriptor(thisMethod.returnType, ClassField.typesOf(thisMethod.params.list()));
			String signature = null;
			boolean needSignature = false;
			{
				StringBuilder sb = new StringBuilder();
				sb.append("(");
				for (ClassField param : thisMethod.params) {
					if (param.clazz.needSignature()) {
						sb.append(param.clazz.signatureAnyway());
						needSignature = true;
					} else {
						sb.append(param.clazz.getDescriptor());
					}
				}
				sb.append(")");
				sb.append(thisMethod.returnType.getDescriptor());
				String signatureFromParameter = sb.toString();

				if (needSignature) {
					signature = signatureFromParameter;
				}
			}
			String[] exceptions = internalNamelOf(this.thisMethod.excptions);

			this.mv = classVisitor.visitMethod(access, name, desc, signature, exceptions);
		}

		assert this.mv != null;
		for (Annotation annotation : thisMethod.annotations) {
			visitAnnotation(this.mv, annotation);
		}
		for (int i = 0; i < thisMethod.params.size(); i++) {
			LocalsVariable param = thisMethod.params.get(i);
			if (param.annotation != null) {
				visitParameterAnnotation(this.mv, i, param.annotation);
			}
		}
	}

	protected void preapareMethodWithClazz() {
	}

	protected void preapareMethodWithParams() {
		for (ClassField field : thisMethod.params) {
			mhLocals.push(new LocalsVariable(field, labelCurrent));
		}
	}

	protected void preapareMethodWithThis() {
		if (thisMethod.instanceMethod) {
			mhLocals.push("this", GenericClazz.clazz(thisMethod.type.getClassName()), labelCurrent);
		}
	}

	@Override
	public MethodHeader reTurn(String clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MethodHeader tHrow(String... clazzes) {
		for (String clazz : clazzes) {
			exceptions.add(new GenericClazz(clazz, null));
		}
		return this;
	}
}