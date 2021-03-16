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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MethodHeaderBuilder implements MethodHeader {
	Logger logger = LoggerFactory.getLogger(getClass());

	class ThisMethod {

		String methodName;

		Clazz clazzType;
		boolean hasEnded = false;
		boolean isInstanceMethod = true;
	}

	ThisMethod thisMethod;
	int methodAccess;

	final ClassBodyImpl classVisitor;

	public ClassBodyImpl getClassVisitor() {
		return classVisitor;
	}

	protected Label labelCurrent;

	boolean labelHasDefineBegin = false;

	Type stackTopType;

	final LocalsStack mhLocals = new LocalsStack();
	final List<LocalsVariable> params = new ArrayList<>();
	final List<Annotation> annotations = new ArrayList<>();
	final List<ClazzFormalTypeParameter> methodFormalTypeParameters111 = new ArrayList<>();
	final List<ClazzFormalTypeParameter> methodAllFormalTypeParameters = new ArrayList<>();
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

	@Override
	public MethodHeader access(int access) {
		this.methodAccess |= access;
		return this;
	}

	@Override
	public MethodHeader formalTypeParameter(ClazzFormalTypeParameter clazz) {
		methodFormalTypeParameters111.add(clazz);
		return this;
	}

	@Override
	public MethodHeader annotation(Annotation annotation) {
		annotations.add(annotation);
		return this;
	}

	@Override
	public MethodHeader return_(Clazz clazz) {
		this.returnClazz = clazz;
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

	@Override
	public MethodHeader throws_(Clazz clazz) {
		exceptions.add(clazz);
		return this;
	}

	protected void prapareMethodDefination() {
		{
			int access = this.methodAccess;
			String name = thisMethod.methodName;

			thisMethod.isInstanceMethod = (access & Opcodes.ACC_STATIC) == 0;

			methodAllFormalTypeParameters.addAll(this.classVisitor.header.classFormalTypeParameters);
			methodAllFormalTypeParameters.addAll(this.methodFormalTypeParameters111);

			if (returnClazz == null) {
				returnClazz = Clazz.of(Type.VOID_TYPE);
			}

			Clazz[] paramClazzes = new Clazz[params.size()];
			for (int i1 = 0; i1 < params.size(); i1++) {
				paramClazzes[i1] = params.get(i1).clazz;
			}

			String descriptor = buildDescriptor(paramClazzes, returnClazz, methodAllFormalTypeParameters); // Type.getMethodDescriptor(returnType, types1);

			String signature = null;
			boolean needSignature = false;
			{
				StringBuilder sb = new StringBuilder();
				if (methodFormalTypeParameters111 != null && methodFormalTypeParameters111.size() > 0) {
					sb.append('<');
					for (int i = 0; i < methodFormalTypeParameters111.size(); i++) {
						ClazzFormalTypeParameter type = methodFormalTypeParameters111.get(i);
						sb.append(type.signatureOf());
					}
					sb.append('>');
					needSignature = true;
				}

				sb.append("(");
				for (ClassField param : params) {
					needSignature |= param.clazz.needSignature();
					sb.append(param.clazz.signatureOf());
				}
				sb.append(")");
				needSignature |= returnClazz.needSignature();
				sb.append(returnClazz.signatureOf());
				String signatureFromParameter = sb.toString();
 
				if (needSignature) {
					signature = signatureFromParameter;
				}
			}

			this.mv = classVisitor.visitMethod(access, name, descriptor, signature, every(String.class, exceptions, e -> e.getType().getInternalName()));
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

	protected String buildDescriptor(Clazz[] methodParamClazzes, final Clazz methodReturnClazz) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append('(');
		for (Clazz argumentType : methodParamClazzes) {
			stringBuilder.append(argumentType.getDescriptor());
		}
		stringBuilder.append(')');
		stringBuilder.append(methodReturnClazz.getDescriptor());
		return stringBuilder.toString();
	}

	protected String buildDescriptor(Clazz[] methodParamClazzes, final Clazz methodReturnClazz, List<ClazzFormalTypeParameter> clazzFormalTypeParameters) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append('(');
		for (Clazz argumentType : methodParamClazzes) {
			stringBuilder.append(argumentType.getDescriptor(clazzFormalTypeParameters));
		}
		stringBuilder.append(')');
		stringBuilder.append(methodReturnClazz.getDescriptor(clazzFormalTypeParameters));
		return stringBuilder.toString();
	}

	protected Type resolveVariable(Clazz returnClazz, List<ClazzFormalTypeParameter> clazzFormalTypeParameters) {
		if (returnClazz instanceof ClazzSimple || returnClazz instanceof ClazzWithTypeArguments) {
			return returnClazz.getType();
		} else if (returnClazz instanceof ClazzVariable) {
			ClazzVariable clazzVariable = (ClazzVariable) returnClazz;
			for (ClazzFormalTypeParameter clazzFormalTypeParameter : clazzFormalTypeParameters) {
				if (clazzFormalTypeParameter.name == clazzVariable.name) {
					if (clazzFormalTypeParameter.getActualClazz() != null) {
						return clazzFormalTypeParameter.getActualClazz().getType();
					} else {
						return clazzFormalTypeParameter.clazz.getType();
					}
				}
			}
			if (clazzVariable.isarray) {
				return Clazz.of(Object.class, true).getType();
			} else {
				return Clazz.of(Object.class).getType();
			}
		}
		throw new UnsupportedOperationException(returnClazz.toString());
	}

	protected void preapareMethodWithClazz() {
	}

	protected void preapareMethodLocalVarOfThis() {
		if (thisMethod.isInstanceMethod) {
			mhLocals.pushParameter("this", thisMethod.clazzType, labelCurrent);
		}
	}

	protected void preapareMethodLocalVarOfParams() {
		for (ClassField field : params) {
			mhLocals.pushParameter(field.name, field.clazz, labelCurrent);
		}
	}

	MethodCode methodCode = null;

	boolean enteredMethodCode = false;

	MethodCode enterMethodCode(MethodVisitor mv) {

		logger.debug("enter method {}", thisMethod.methodName);
		if (!enteredMethodCode) {
			enteredMethodCode = true;
			methodCode = new MethodCodeBuilder(mv, this, mhLocals);
//			TinyAsmBuilder.enterCode(methodCode);
			return methodCode;
		}
		return null;
	}

	@Override
	public MethodCode begin() {
		prapareMethodDefination();
		mv.visitCode();
		labelCurrent = labelWithoutLineNumber();
		preapareMethodWithClazz();
		preapareMethodLocalVarOfThis();
		preapareMethodLocalVarOfParams();

		return enterMethodCode(mv);
	}

	@Override
	public MethodVisitor getMethodVisitor() {
		return this.mv;
	}

	@Override
	public void code(Consumer<MethodCode> invocation) {
		MethodCode mc = this.begin();
		invocation.accept(mc);
		mc.END();
	}

	void end() {
		exitMethod();
//		if (!exited) TinyAsmBuilder.exitCode();
		exited = true;
	}

	protected Label labelWithoutLineNumber() {
		Label label = new Label();
		labelCurrent = label;
		mv.visitLabel(label);
		return label;
	}

	boolean exited = false;

	protected void exitMethod() {
		if (thisMethod.hasEnded) return;
		if ((this.methodAccess & (ACC_BRIDGE | ACC_SYNTHETIC)) == (ACC_BRIDGE | ACC_SYNTHETIC)) {
			Label endLabel = this.labelWithoutLineNumber();
			LocalsStack.Var var = mhLocals.getByLocal(0);
			assert mv != null;
			assert var != null;
			assert var.clazz.getDescriptor() != null;
			Label labelfrom = var.startFrom != null ? var.startFrom : labelCurrent;
			mv.visitLocalVariable(var.name, var.clazz.getDescriptor(methodAllFormalTypeParameters), var.clazz.signatureWhenNeed(), labelfrom, endLabel, var.locals);
		} else {// if (!((this.methodAccess & ACC_SYNTHETIC) > 0)) {
			Label endLabel = this.labelWithoutLineNumber();
			for (LocalsStack.Var var : mhLocals) {
				if (!((var.access & ACC_SYNTHETIC) > 0)) {
					assert mv != null;
					assert var != null;
					assert var.clazz.getDescriptor() != null : var.clazz.toString();
					Label labelfrom = var.startFrom != null ? var.startFrom : labelCurrent;

					String varname = var.name != null ? var.name : "var" + var.locals;

					mv.visitLocalVariable(varname, var.clazz.getDescriptor(methodAllFormalTypeParameters), var.clazz.signatureWhenNeed(), labelfrom, endLabel, var.locals);
				}
			}
		}
		mv.visitMaxs(0, 0);
		mv.visitEnd();
		thisMethod.hasEnded = true;

		logger.debug("exit  method {}", thisMethod.methodName);
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
}