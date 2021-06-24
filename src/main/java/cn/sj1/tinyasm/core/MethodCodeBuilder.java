package cn.sj1.tinyasm.core;

import static cn.sj1.tinyasm.core.TypeUtils.typeOf;
import static cn.sj1.tinyasm.core.TypeUtils.typesOf;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.sj1.tinyasm.core.LocalsStack.Var;

public class MethodCodeBuilder extends MethodCode {
	Logger logger = LoggerFactory.getLogger(getClass());
	private final MethodVisitor mv;

	final MethodHeaderBuilder mh;

	int lastLineNumber = 0;

	protected Label labelCurrent;
	protected boolean labelHasDefineBegin;

	public MethodCodeBuilder(MethodVisitor mv, MethodHeaderBuilder mh, LocalsStack locals) {
		this.mv = mv;
		this.mh = mh;
		this.locals = locals;
		this.labelHasDefineBegin = mh.labelHasDefineBegin;
		this.labelCurrent = mh.labelCurrent;
	}

	@Override
	public String toString() {
		return "code" + mh.thisMethod.methodName;
	}

	@Override
	public void BLOCK(Consumer<MethodCode> invocation) {
		invocation.accept(this);
	}

	final Stack<Type> stack = new Stack<>();

	@Override
	public Type stackTypeOf(int i) {
		return stack.get(stack.size() - i - 1);
	}

	@Override
	public Type stackPop() {
		Type type = stack.pop();
		printStack(stack);
		return type;
	}

	@Override
	public void stackPush(Type type) {
		stack.push(type);
		printStack(stack);
	}

	//	@Override
	//	public MethodVisitor getMethodVisitor() {
	//		return this.mv;
	//	}

	@Override
	protected int stackSize() {
		return stack.size();
	}

	final protected LocalsStack locals;

	@Override
	public int codeLocalsNextLocal() {
		return locals.locals.size();
	}

	@Override
	protected String codeFieldNameOf(int fieldIndex) {
		return this.mh.getClassVisitor().getFields().get(fieldIndex).name;
	}

	@Override
	public int codeLocalGetLocals(String name) {
		LocalsStack.Var var = locals.get(name);
		if (var != null) {
			//			if(var.startFrom==null) {
			//				var.startFrom = labelCurrent;
			//			}
			return var.locals;
		} else {
			return -1;
		}
	}

	@Override
	public Type localsLoadAccess(int localsIndex) {
		return locals.accessLoadType(localsIndex, labelCurrent);
	}

	Var lastDefinedVar = null;

	@Override
	public Type localsStoreAccess(int localsIndex, Type type) {
		lastDefinedVar = locals.getByLocal(localsIndex);
		return locals.accessStoreType(localsIndex, type, labelCurrent);
	}

	@Override
	public int define(String name, Clazz clazz) {
		return locals.define(name, clazz);
	}

	@Override
	public int define(Annotation annotation, String name, Clazz clazz) {
		return locals.define(annotation, name, clazz);
	}

	@Override
	public Type staticFieldTypeOfThis(String name) {
		assert mh.staticFields.containsKey(name) : "field + " + name + " not exist!";
		return mh.staticFields.get(name).clazz.getType();
	}

	@Override
	public Type fieldTypeOfThis(String name) {
		assert mh.thisMethod.isInstanceMethod;
		assert mh.fields.containsKey(name) : "field + " + name + " not exist!";
		return mh.fields.get(name).clazz.getType();
	}

	boolean hasReturnVoid = false;

	@Override
	public void RETURN() {
		hasReturnVoid = true;
		super.RETURN();
	}

	@Override
	public void END() {
		if (!hasReturnVoid && (this.mh.returnClazz == null || this.mh.returnClazz.getType().getSort() == Type.VOID)) {
			if (mh.thisMethod.methodName.startsWith("<")) {
				super.RETURN();
			} else {
				this.LINE();
				super.RETURN();
			}
		}
		mh.end();
	}

	@Override
	public Label codeNewLabel() {
		Label label = new Label();
		return label;
	}

	@Override
	public void visitLabel(Label label) {
		super.visitLabel(label);
		labelCurrent = label;
		mv.visitLabel(label);
		logger.trace("mv.visitLabel({}; in visitLabel(Label label)", label);
	}

	@Override
	public void visitLabel(Label label, int line) {
		labelCurrent = label;
		mv.visitLabel(label);
		logger.trace("mv.visitLabel({},{}); in visitLabel(Label label, int line)", label, line);
		//		labelHasDefineBegin = true;
		//		mv.visitLineNumber(line, label);
	}

	public void LINE() {
		lastLineNumber = lastLineNumber + 1;
		LINE(lastLineNumber);
	}

	public void LINE(int line) {
		lastLineNumber = line;
		Label label;
		if (!labelHasDefineBegin) {
			label = new Label();
			labelCurrent = null;
			mv.visitLabel(label);
			logger.trace("mv.visitLabel({});in LINE()", label);

		} else {
			label = labelCurrent;
			labelHasDefineBegin = false;
		}
		logger.trace("mv.visitLineNumber({}, {}); in LINE()", lastLineNumber, label);
		mv.visitLineNumber(lastLineNumber, label);
		if (lastDefinedVar != null && lastDefinedVar.startFrom == null) {
			lastDefinedVar.startFrom = label;
			lastDefinedVar = null;
		}
		labelCurrent = label;
	}

	@Override
	protected void visitFieldInsn(int opcode, Type ownerType, String fieldName, Type fieldType) {
		mv.visitFieldInsn(opcode, ownerType.getInternalName(), fieldName, fieldType.getDescriptor());
	}

	@Override
	protected void visitInsn(int opcode) {
		mv.visitInsn(opcode);
	}

	@Override
	protected void visitVarInsn(int opcode, int var) {
		mv.visitVarInsn(opcode, var);
	}

	@Override
	protected void visitIntInsn(int opcode, int operand) {
		//		if (opcode == BIPUSH && -1 <= operand && operand <= 5) {
		//			mv.visitInsn(ICONST_0 + operand);
		//		} else {
		mv.visitIntInsn(opcode, operand);
		//		}
	}

	@Override
	protected void visitIincInsn(int var, int increment) {
		mv.visitIincInsn(var, increment);
	}

	@Override
	protected void visitMethodInsn(int opcode, Type objectType, Type returnType, String methodName, Type... paramTypes) {
		mv.visitMethodInsn(opcode, objectType.getInternalName(), methodName, Type.getMethodDescriptor(returnType, paramTypes),
				opcode == INVOKEINTERFACE);
	}

	@Override
	protected void visitTryCatchBlock(Label start, Label end, Label handler, Type exctpionClazz) {
		// TODO Auto-generated method stub
		mv.visitTryCatchBlock(start, end, handler, exctpionClazz.getInternalName());
	}

	@Override
	protected void visitJumpInsn(int opcode, Label label) {
		mv.visitJumpInsn(opcode, label);
	}

	@Override
	protected void visitInvokeDynamicInsn(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
		mv.visitInvokeDynamicInsn(name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments);
	}

	@Override
	protected void visitLdcInsn(Object cst) {
		mv.visitLdcInsn(cst);
	}

	@Override
	protected void visitTypeInsn(int opcode, Type type) {
		mv.visitTypeInsn(opcode, type.getInternalName());
	}

	private void printStack(Stack<Type> stack) {
		if (logger.isTraceEnabled()) {
			StringBuffer sb = new StringBuffer();
			sb.append(mh.thisMethod.methodName).append(" : ");
			for (Type type : stack) {
				sb.append(type);
				sb.append(" > ");
			}
			sb.setCharAt(sb.length() - 2, ' ');
			logger.trace("{}", sb.toString());
		}
	}

	@Override
	public MethodCaller STATIC(Clazz objectType, String methodName) {
		return new MethodCallerImpl(Opcodes.INVOKESTATIC, objectType, methodName);
	}

	@Override
	public MethodCaller INTERFACE(Clazz objectType, String methodName) {
		return new MethodCallerImpl(Opcodes.INVOKEINTERFACE, objectType, methodName);
	}

	@Override
	public MethodCaller SPECIAL(Clazz objectType, String methodName) {
		return new MethodCallerImpl(Opcodes.INVOKESPECIAL, Clazz.of(objectType), methodName);
	}

	@Override
	public MethodCaller VIRTUAL(Clazz objectType, String methodName) {
		return new MethodCallerImpl(Opcodes.INVOKEVIRTUAL, objectType, methodName);
	}

	@Override
	public MethodCallerAfterDynamic DYNAMIC(Clazz objectType, String methodName) {
		return new MethodCallerAfterDynamicImpl(objectType, methodName);
	}

	class MethodCallerAfterDynamicImpl implements MethodCallerAfterDynamic {
		List<Clazz> params = new ArrayList<>();
		Clazz returnClazz;

		final Clazz resideClazz;
		final String methodName;

		public MethodCallerAfterDynamicImpl(Clazz resideClazz, String methodName) {
			super();
			this.resideClazz = resideClazz;
			this.methodName = methodName;
		}

		@Override
		public MethodCallerAfterDynamic parameter(Clazz clazz) {
			params.add(clazz);
			return this;
		}

		@Override
		public MethodCallerAfterDynamic return_(Clazz clazz) {
			returnClazz = clazz;
			return this;
		}

		@Override
		public LamdaMethodCaller LAMBDA(String targetClazz, String targetMethodName) {
			String[] genericParameterClazz = {};
			return new LAMBDAImpl(this, Clazz.of(targetClazz, genericParameterClazz), targetMethodName);
		}
	}

	class LAMBDAImpl implements LamdaMethodCaller {
		List<Clazz> params = new ArrayList<>();
		Clazz returnClazz;

		final Clazz dynamicClazz;
		final String methodName;
		final MethodCallerAfterDynamicImpl lamdaMethod;

		public LAMBDAImpl(MethodCallerAfterDynamicImpl targetMethod, Clazz resideClazz, String methodName) {
			//			super(0, resideClazz, methodName);
			this.dynamicClazz = resideClazz;
			this.methodName = methodName;
			this.lamdaMethod = targetMethod;
		}

		@Override
		public LamdaMethodCaller parameter(Clazz clazz) {
			params.add(clazz);
			return this;
		}

		@Override
		public LamdaMethodCaller return_(Clazz clazz) {
			returnClazz = clazz;
			return this;
		}

		@Override
		public void INVOKE() {

			//			methodVisitor.visitInvokeDynamicInsn("apply", "(Ljava/lang/String;)Ljava/util/function/Function;", 
			//new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), 
			//new Object[]{Type.getType("(Ljava/lang/Object;)Ljava/lang/Object;"), 
			//new Handle(Opcodes.H_INVOKESTATIC, "cn/sj1/tinyasm/core/sample/MethodCode/MethodCodeMethodCallerLAMBDASample", "lambda$exec2$0", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", false), 
			//Type.getType("(Ljava/lang/String;)Ljava/lang/String;")});
			String lamdaOwner = lamdaMethod.resideClazz.getType().getInternalName();// "cn/sj1/tinyasm/core/sample/MethodCode/MethodCodeMethodCallerLAMBDASample";
			String lamdaMethodName = lamdaMethod.methodName;// "lambda$exec2$0"
			String lamdaMethodDescriptor = Type.getMethodDescriptor(typeOf(lamdaMethod.returnClazz), typesOf(lamdaMethod.params));// "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"

			List<Clazz> dynamicImplParams = lamdaMethod.params.subList(0, lamdaMethod.params.size() - this.params.size());
			List<Clazz> dynamicActualMethodMethodParams = lamdaMethod.params.subList(lamdaMethod.params.size() - this.params.size(), lamdaMethod.params.size());

			String dynamicImplDescriptor = Type.getMethodDescriptor(typeOf(dynamicClazz), typesOf(dynamicImplParams));// (Ljava/lang/String;)Ljava/util/function/Function;;
			String dynamicName = this.methodName; //"apply"
			Type dynamicOriginalMethodDescriptor = Type.getMethodType(typeOf(returnClazz), typesOf(this.params));//Type.getType("(Ljava/lang/Object;)Ljava/lang/Object;"
			Type dynamicActualMethodMethodDescripter = Type.getMethodType(typeOf(lamdaMethod.returnClazz), typesOf(dynamicActualMethodMethodParams));//Type.getType("(Ljava/lang/String;)Ljava/lang/String;")

			//			mv.visitInvokeDynamicInsn(dyncName, dyncDescriptor,
			//					new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory",
			//							"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
			//							false),
			//					new Object[] { Type.getType(dyncMethodDescriptor), new Handle(Opcodes.H_INVOKESTATIC, lamdaOwner, lamdaMethodName, lamdaMethodDescriptor, false),
			//							Type.getType(lamdaMethodDescriptor) });

			mv.visitInvokeDynamicInsn(dynamicName,
					dynamicImplDescriptor,
					new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory",
							"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
							false),
					new Object[] {
							dynamicOriginalMethodDescriptor,
							new Handle(Opcodes.H_INVOKESTATIC, lamdaOwner, lamdaMethodName, lamdaMethodDescriptor, false),
							dynamicActualMethodMethodDescripter });

			//			mv.visitInvokeDynamicInsn(methodName, lambdaDescriptor, new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory",
			//					"metafactory",
			//					"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
			//					false),
			//					new Object[] { Type.getType(originDescriptor), new Handle(Opcodes.H_INVOKESTATIC, clazzType.getInternalName(),
			//							originMethod.methodName, resultDescriptor, false), Type.getType(originSignature) });
			/*
			 * mv.visitInvokeDynamicInsn("withHandle",
			 * "()Lorg/jdbi/v3/core/HandleCallback;", new Handle(Opcodes.H_INVOKESTATIC,
			 * "java/lang/invoke/LambdaMetafactory", "metafactory",
			 * "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;"
			 * ), new Object[]{Type.getType("(Lorg/jdbi/v3/core/Handle;)Ljava/util/List;"),
			 * * new Handle(Opcodes.H_INVOKESTATIC, "nebula/module/UserRepository",
			 * "lambda$0", "(Lorg/jdbi/v3/core/Handle;)Ljava/util/List;"),
			 * Type.getType("(Lorg/jdbi/v3/core/Handle;)Ljava/util/List;")});
			 */

			stackPush(typeOf(this.dynamicClazz));
		}

	}

	class MethodCallerImpl implements MethodCaller {
		List<Clazz> params = new ArrayList<>();
		Clazz returnClazz;

		final int opcode;
		final Clazz resideClazz;
		final String methodName;

		public MethodCallerImpl(int opcode, Clazz resideClazz, String methodName) {
			super();
			this.opcode = opcode;
			this.resideClazz = resideClazz;
			this.methodName = methodName;
		}

		@Override
		public MethodCaller parameter(Clazz clazz) {
			params.add(clazz);
			return this;
		}

		@Override
		public MethodCaller return_(Clazz clazz) {
			returnClazz = clazz;
			return this;
		}

		@Override
		public void INVOKE() {
			MethodCodeBuilder.this.INVOKE(opcode, typeOf(resideClazz), typeOf(returnClazz), methodName, typesOf(params));
		}

	}

	@Override
	public Type typeOfThis() {
		return this.mh.thisMethod.clazzType.getType();
	}

}