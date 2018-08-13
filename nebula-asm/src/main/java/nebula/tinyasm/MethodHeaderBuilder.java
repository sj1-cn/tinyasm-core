package nebula.tinyasm;

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

import nebula.tinyasm.data.ClassAnnotation;
import nebula.tinyasm.data.ClassField;
import nebula.tinyasm.data.LocalsStack;
import nebula.tinyasm.data.LocalsVariable;

abstract class MethodHeaderBuilder<MC extends MethodCode<MC>> implements MethodHeader<MC> {
	class ThisMethod {
		int access;
		List<ClassAnnotation> annotations = new ArrayList<>();
		// final Type thisType;
		String[] excptions;

		String name;

		List<ClassAnnotation> parameterAnnotations = new ArrayList<>(10);

		List<ClassField> params = new ArrayList<>();

		Type returnType;
		Type type;
		boolean hasEnded = false;
	}

	public static void visitParameterAnnotation(MethodVisitor mv, int parameter, Type annotationType, Object value) {
		AnnotationVisitor av0 = mv.visitParameterAnnotation(parameter, annotationType.getDescriptor(), true);
		if (value != null) {
			AnnotationVisitor av1 = av0.visitArray("value");
			av1.visit(null, value);
			av1.visitEnd();
		}
		av0.visitEnd();
	}

	ThisMethod thisMethod;

	private final ClassVisitor classVisitor;

	protected Label labelCurrent;

	boolean labelHasDefineBegin = false;

	Type stackTopType;

	protected LocalsStack mhLocals = new LocalsStack();

	MethodVisitor mv;

	public MethodHeaderBuilder(ClassVisitor cv, Type thisType, int access, Type returnType, String methodName,
			String[] exceptiones) {
		this.classVisitor = cv;
		thisMethod = new ThisMethod();
		thisMethod.name = methodName;
		thisMethod.access = access;
		thisMethod.returnType = returnType;
		thisMethod.excptions = exceptiones;
		thisMethod.type = thisType;
	}

	@Override
	public MethodHeader<MC> annotation(Type type, Object value) {
		thisMethod.annotations.add(new ClassAnnotation(type, null, value));
		return this;
	}

	@Override
	public MethodHeader<MC> annotation(Type type, String name, Object value) {
		thisMethod.annotations.add(new ClassAnnotation(type, name, value));
		return this;
	}

	@Override
	public MC begin() {
		prapareMethodDefination();
		mv.visitCode();
		preapareMethodWithClazz();
		preapareMethodWithThis();
		preapareMethodWithParams();

		labelCurrent = labelWithoutLineNumber();
		return makeCode(mv);
	}

	@Override
	public void code(Consumer<MC> invocation) {
		MC mc = this.begin();
		invocation.accept(mc);
		this.codeEnd();
	}

	void codeEnd() {
		finishMethod();
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
//
//	public MC line() {
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
//	public MC line(int line) {
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

	abstract MC makeCode(MethodVisitor mv);

	protected void finishMethod() {
		if (thisMethod.hasEnded) return;
		Label endLabel = this.labelWithoutLineNumber();
		for (LocalsVariable var : mhLocals) {
			if (!is(var.access, ACC_SYNTHETIC)) {
				assert mv != null;
				assert var != null;
				assert var.type.getDescriptor() != null;
				mv.visitLocalVariable(var.name, var.type.getDescriptor(), var.signature, var.startFrom, endLabel,
						var.locals);
			}
		}
		mv.visitMaxs(0, 0);
		mv.visitEnd();
		thisMethod.hasEnded = true;
	}

	public void mvAnnotation(MethodVisitor mv, Type annotationType, String name, Object value) {
		AnnotationVisitor av0 = mv.visitAnnotation(annotationType.getDescriptor(), true);
		if (value != null) {
			if (name != null) {
				av0.visit(name, value);
			} else {
				av0.visit("value", value);
			}
		}
		av0.visitEnd();
	}

	@Override
	public MethodHeader<MC> parameter(ClassField field) {
		thisMethod.params.add(field);
		thisMethod.parameterAnnotations.add(null);
		return this;
	}

	@Override
	public MethodHeader<MC> parameter(String fieldName, Type fieldType) {
		thisMethod.params.add(new LocalsVariable(fieldName, fieldType));
		thisMethod.parameterAnnotations.add(null);
		return this;
	}

	@Override
	public MethodHeader<MC> parameterAnnotation(Type annotationType, Object value) {
		thisMethod.parameterAnnotations.set(thisMethod.params.size() - 1,
				new ClassAnnotation(annotationType, null, value));
		return this;
	}

	@Override
	public MethodHeader<MC> parameterGeneric(String fieldName, Type fieldType, String signature) {
		thisMethod.params.add(new LocalsVariable(fieldName, fieldType, signature));
		thisMethod.parameterAnnotations.add(null);
		return this;
	}

	@Override
	public MethodHeader<MC> parameterGenericWithAnnotation(Type annotationType, Object value, String fieldName,
			Type fieldType, String signature) {
		thisMethod.params.add(new LocalsVariable(fieldName, fieldType, signature));
		thisMethod.parameterAnnotations.set(thisMethod.params.size() - 1,
				new ClassAnnotation(annotationType, null, value));
		return this;
	}

	@Override
	public MethodHeader<MC> parameterWithAnnotation(Type annotationType, Object value, String fieldName,
			Type fieldType) {
		thisMethod.params.add(new LocalsVariable(fieldName, fieldType));
		thisMethod.parameterAnnotations.set(thisMethod.params.size() - 1,
				new ClassAnnotation(annotationType, null, value));
		return this;
	}

	protected void prapareMethodDefination() {
		String signature = null;

		boolean definedSignature = false;
		{
			StringBuilder sb = new StringBuilder();
			sb.append("(");
			for (ClassField param : thisMethod.params) {
				if (param.signature != null) {
					sb.append(param.signature);
					definedSignature = true;
				} else {
					sb.append(param.type.getDescriptor());
				}
			}
			sb.append(")");
			sb.append(thisMethod.returnType.getDescriptor());
			String signatureFromParameter = sb.toString();

			if (definedSignature) {
				signature = signatureFromParameter;
			}
		}

		this.mv = classVisitor.visitMethod(thisMethod.access, thisMethod.name,
				Type.getMethodDescriptor(thisMethod.returnType, ClassField.typesOf(thisMethod.params)), signature,
				null);

		assert this.mv != null;
		for (ClassAnnotation annotation : thisMethod.annotations) {
			mvAnnotation(this.mv, annotation.type, annotation.name, annotation.value);
		}
		for (ClassAnnotation annotation : thisMethod.parameterAnnotations) {
			if (annotation != null) {
				visitParameterAnnotation(this.mv, annotation.parameter, annotation.type, annotation.value);
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
	}
}