package cc1sj.tinyasm;

import static cc1sj.tinyasm.TypeUtils.every;
import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

class MethodHeaderBuilder implements MethodHeader {
	class ThisMethod {

		String methodName;

		Clazz clazzType;
		boolean hasEnded = false;
		boolean instanceMethod = true;
	}

	ThisMethod thisMethod;
	int methodAccess;

	final private ClassBodyImpl classVisitor;

	protected Label labelCurrent;

	boolean labelHasDefineBegin = false;

	Type stackTopType;

	final LocalsStack mhLocals = new LocalsStack();
	final List<LocalsVariable> params = new ArrayList<>();
	final List<Annotation> annotations = new ArrayList<>();
	final FieldList fields;
	final FieldList staticFields;

	MethodVisitor mv;

	final List<Clazz> exceptions = new ArrayList<>();
	Clazz returnClazz = null;

	public MethodHeaderBuilder(ClassBodyImpl cv, Clazz clazzType, int access, Clazz returnType, String methodName) {
		this(cv, clazzType, access, methodName);
		this.returnClazz = returnType;
	}

	public MethodHeaderBuilder(ClassBodyImpl cv, Clazz clazzType, int access, String methodName) {
		this.classVisitor = cv;
		thisMethod = new ThisMethod();
		thisMethod.methodName = methodName;
		thisMethod.clazzType = clazzType;
		this.methodAccess = access;
		this.fields = cv.fields;
		this.staticFields = cv.staticFields;
	}

//	@Override
//	public MethodHeader annotation(String clazz, Object value) {
//		thisMethod.annotations.add(new ClassAnnotation(type, null, value));
//		return this;
//	}

//	@Override
//	public MethodHeader annotation(String clazz, Object defaultValue, String[] names, Object[] values) {
//		annotations.add(new Annotation(clazz, defaultValue, names, values));
//		return this;
//	}

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

	boolean entered = false;

	@Override
	public MethodCode begin() {
		prapareMethodDefination();
		mv.visitCode();
		labelCurrent = labelWithoutLineNumber();
		preapareMethodWithClazz();
		preapareMethodWithThis();
		preapareMethodWithParams();

		MethodCode code = makeCode(mv);
		if (!entered) TinyAsmBuilder.enterCode(code);
		entered = true;
		return code;
	}

	@Override
	public MethodVisitor getMethodVisitor() {
		return this.mv;
	}

	@Override
	public void code(Consumer<MethodCode> invocation) {
		MethodCode mc = this.begin();
		invocation.accept(mc);
		this.end();
	}

//	@Override
//	public MethodCode code() {
//		MethodCode mc = this.begin();
//		return mc;
//	}

//	@Override
//	public MethodHeader friendly(Consumer<MethodCodeAdv> invocation) {
//		MethodCode mc = this.begin();
//		invocation.accept((MethodCodeAdv)mc);
//		this.codeEnd();
//		return this;
//	}
	boolean exited = false;

	public void end() {
		finishMethod();
		if (!exited) TinyAsmBuilder.exitCode();
		exited = true;
	}

	protected void finishMethod() {
		if (thisMethod.hasEnded) return;
		if (!((this.methodAccess & ACC_SYNTHETIC) > 0)) {
			Label endLabel = this.labelWithoutLineNumber();
			for (LocalsStack.Var var : mhLocals) {
				if (!((var.access & ACC_SYNTHETIC) > 0)) {
					assert mv != null;
					assert var != null;
					assert var.clazz.getDescriptor() != null;
					Label labelfrom = var.startFrom != null ? var.startFrom : labelCurrent;

					String varname = var.name != null ? var.name : "var" + var.locals;

					mv.visitLocalVariable(varname, var.clazz.getDescriptor(), var.clazz.signatureWhenNeed(), labelfrom, endLabel,
							var.locals);
				}
			}
		} else if ((this.methodAccess & ACC_SYNTHETIC) > 0 && (this.methodAccess & ACC_BRIDGE) > 0) {
			Label endLabel = this.labelWithoutLineNumber();
			LocalsStack.Var var = mhLocals.getByLocal(0);
			assert mv != null;
			assert var != null;
			assert var.clazz.getDescriptor() != null;
			Label labelfrom = var.startFrom != null ? var.startFrom : labelCurrent;
			mv.visitLocalVariable(var.name, var.clazz.getDescriptor(), var.clazz.signatureWhenNeed(), labelfrom, endLabel, var.locals);
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
	public MethodHeader parameter(int access, String name, Clazz clazz) {
		LocalsVariable param = new LocalsVariable(access, name, clazz);
		params.add(param);
		return this;
	}

	@Override
	public MethodHeader parameter(int access, Annotation annotation, String name, Clazz clazz) {
		LocalsVariable param = new LocalsVariable(annotation, name, clazz);
		params.add(param);
		return this;
	}

	protected void prapareMethodDefination() {
		{
			int access = this.methodAccess;
			String name = thisMethod.methodName;

			thisMethod.instanceMethod = (access & Opcodes.ACC_STATIC) == 0;

			Type returnType;
			if (returnClazz != null) returnType = returnClazz.getType();
			else returnType = Type.VOID_TYPE;

			Type[] types1 = new Type[params.size()];
			for (int i1 = 0; i1 < params.size(); i1++) {
				types1[i1] = params.get(i1).clazz.getType();
			}

			String desc = Type.getMethodDescriptor(returnType, types1);
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

			this.mv = classVisitor.visitMethod(access, name, desc, signature,
					every(String.class, exceptions, e -> e.getType().getInternalName()));
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
			mv.visitParameter(param.name, param.access);
		}
	}

	protected void preapareMethodWithClazz() {
	}

	protected void preapareMethodWithParams() {
		for (ClassField field : params) {
			mhLocals.pushParameter(field.name, field.clazz, labelCurrent);
		}
	}

	protected void preapareMethodWithThis() {
		if (thisMethod.instanceMethod) {
			mhLocals.pushParameter("this", thisMethod.clazzType, labelCurrent);
		}
	}

	@Override
	public MethodHeader tHrow(Clazz clazz) {
		exceptions.add(clazz);
		return this;
	}

	@Override
	public MethodHeader access(int access) {
		this.methodAccess |= access;
		return this;
	}

	@Override
	public MethodHeader reTurn(Clazz clazz) {
		this.returnClazz = clazz;
		return this;
	}
//
//	
//	@Override
//	public void makeBridgeMathod() {
//
//		MethodHeader mh = this.classVisitor.method(this.access | ACC_BRIDGE + ACC_SYNTHETIC, this.returnClazz.classname,
//				this.thisMethod.name);
//		for (GenericClazz exClazz : exceptions) {
//			mh.tHrow(exClazz);
//		}
//		for (ClassField field : this.params) {
//			mh.parameter(field.name, field.clazz.classname);
//		}
//		mh.code(mv -> {
//			mv.LINE();
//			mv.LOAD(0);
//
//			for (ClassField field : this.params) {
//				mv.LOAD(field.name);
//			}
//			mv.VIRTUAL(this.classVisitor.getName(), this.thisMethod.name)
//				.param(ClassField.genericOf(this.params.list()))
//				.reTurn(this.returnClazz)
//				.INVOKE();
//			if (this.returnClazz != null) {
//				mv.RETURNTop();
//			} else {
//				mv.RETURN();
//			}
//		});
//	}

//
//	@Override
//	public MethodHeader tHrow(String... clazzes) {
//		for (String clazz : clazzes) {
//			exceptions.add(clazz, null));
//		}
//		return this;
//	}
}