package cc1sj.tinyasm;

import static cc1sj.tinyasm.TypeUtils.typeOf;
import static cc1sj.tinyasm.TypeUtils.typesOf;
import static org.objectweb.asm.Opcodes.BIPUSH;
import static org.objectweb.asm.Opcodes.ICONST_0;
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

public class MethodCodeBuilder extends MethodCode {
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

	@Override
	public void visitLabel(Label label) {
		labelCurrent = label;
		mv.visitLabel(label);
	}

	@Override
	public void visitLabel(Label label, int line) {
		labelCurrent = label;
		mv.visitLabel(label);
		mv.visitLineNumber(line, label);
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

	@Override
	int stackSize() {
		return stack.size();
	}

	final protected LocalsStack locals;

	@Override
	public int codeLocalGetLocals(String name) {
		LocalsStack.Var var = locals.get(name);
		return var != null ? locals.get(name).locals : -1;
	}

	@Override
	public Type localsLoadAccess(int localsIndex) {
		return locals.accessLoadType(localsIndex, labelCurrent);
	}

	@Override
	public Type localsStoreAccess(int localsIndex, Type type) {
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
	public Type codeThisClassFieldType(String name) {
		assert mh.staticFields.containsKey(name) : "field + " + name + " not exist!";
		return mh.staticFields.get(name).clazz.getType();
	}

	@Override
	public Type codeThisFieldType(String name) {
		assert mh.thisMethod.instanceMethod;
		assert mh.fields.containsKey(name) : "field + " + name + " not exist!";
		return mh.fields.get(name).clazz.getType();
	}

	@Override
	public Label codeNewLabel() {
		Label label = new Label();
		return label;
	}

	boolean hasReturnVoid = false;

	@Override
	public void RETURN() {
		hasReturnVoid = true;
		super.RETURN();
	}

	@Override
	public void END() {
		if (!hasReturnVoid && this.mh.returnClazz == null) {
			if (mh.thisMethod.methodName.startsWith("<")) {
				super.RETURN();
			} else {
				this.LINE();
				super.RETURN();
			}
		}
		mh.end();
	}

	public void LINE() {
		Label label;
		if (!labelHasDefineBegin) {
			label = new Label();
			labelCurrent = label;
			mv.visitLabel(label);
		} else {
			label = labelCurrent;
		}
		lastLineNumber = lastLineNumber + 1;
		mv.visitLineNumber(lastLineNumber, label);
	}

	public void LINE(int line) {
		Label label;
		if (!labelHasDefineBegin) {
			label = new Label();
			labelCurrent = label;
			mv.visitLabel(label);
		} else {
			label = labelCurrent;
		}
		lastLineNumber = line;
		mv.visitLineNumber(line, label);
	}

	@Override
	public void visitFieldInsn(int opcode, Type ownerType, String fieldName, Type fieldType) {
		mv.visitFieldInsn(opcode, ownerType.getInternalName(), fieldName, fieldType.getDescriptor());
	}

	@Override
	public void visitInsn(int opcode) {
		mv.visitInsn(opcode);
	}

	@Override
	public void visitVarInsn(int opcode, int var) {
		mv.visitVarInsn(opcode, var);
	}

	@Override
	public void visitInsn(int opcode, int operand) {
		if (opcode == BIPUSH && -1 <= operand && operand <= 5) {
			mv.visitInsn(ICONST_0 + operand);
		} else {
			mv.visitIntInsn(opcode, operand);
		}
	}

	@Override
	void visitIincInsn(int var, int increment) {
		mv.visitIincInsn(var, increment);
	}

	@Override
	public void visitMethodInsn(int opcode, Type objectType, Type returnType, String methodName, Type... paramTypes) {
		mv.visitMethodInsn(opcode, objectType.getInternalName(), methodName, Type.getMethodDescriptor(returnType, paramTypes),
				opcode == INVOKEINTERFACE);
	}

	@Override
	public void visitTryCatchBlock(Label start, Label end, Label handler, Type exctpionClazz) {
		// TODO Auto-generated method stub
		mv.visitTryCatchBlock(start, end, handler, exctpionClazz.getInternalName());
	}

	@Override
	public void visitJumpInsn(int opcode, Label label) {
		mv.visitJumpInsn(opcode, label);
	}

	@Override
	public void visitInvokeDynamicInsn(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
		mv.visitInvokeDynamicInsn(name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments);
	}

	@Override
	public void visitLdcInsn(Object cst) {
		mv.visitLdcInsn(cst);
	}

	@Override
	public void visitTypeInsn(int opcode, Type type) {
		mv.visitTypeInsn(opcode, type.getInternalName());
	}

	private void printStack(Stack<Type> stack) {
//		StringBuffer sb = new StringBuffer();
//		sb.append(thisMethod.name).append(" : ");
//		for (Type type : stack) {
//			sb.append(type);
//			sb.append(" > ");
//		}
//		sb.setCharAt(sb.length() - 2, '\n');
//		System.out.println(sb.toString());
	}

	@Override
	public MethodCaller<MethodCode> STATIC(Clazz objectType, String methodName) {
		return new MethodCallerImpl(Opcodes.INVOKESTATIC, objectType, methodName);
	}

	@Override
	public MethodCaller<MethodCode> INTERFACE(Clazz objectType, String methodName) {
		return new MethodCallerImpl(Opcodes.INVOKEINTERFACE, objectType, methodName);
	}

	@Override
	public MethodCaller<MethodCode> SPECIAL(Clazz objectType, String methodName) {
		return new MethodCallerImpl(Opcodes.INVOKESPECIAL, Clazz.of(objectType), methodName);
	}

	@Override
	public MethodCaller<MethodCode> VIRTUAL(Clazz objectType, String methodName) {
		return new MethodCallerImpl(Opcodes.INVOKEVIRTUAL, objectType, methodName);
	}

//	@Override
//	public MethodCaller<MethodCode> VIRTUAL(String methodName) {
//		return new MethodCallerImpl(Opcodes.INVOKEVIRTUAL, Clazz.of(this.mh.thisMethod.clazzType), methodName);
//	}

	class LAMBDAImpl extends MethodCallerImpl implements MethodCaller<MethodCode> {
		List<Clazz> params = new ArrayList<>();
		Clazz returnClazz;

		final int opcode;
		final Clazz resideClazz;
		final String methodName;
		final MethodCallerImpl originMethod;

		public LAMBDAImpl(int opcode, MethodCallerImpl targetMethod, Clazz resideClazz, String methodName) {
			super(opcode, resideClazz, methodName);
			this.opcode = opcode;
			this.resideClazz = resideClazz;
			this.methodName = methodName;
			this.originMethod = targetMethod;
		}

		@Override
		public MethodCaller<MethodCode> parameter(Clazz clazz) {
			params.add(clazz);
			return this;
		}

		@Override
		public MethodCaller<MethodCode> reTurn(Clazz clazz) {
			returnClazz = clazz;
			return this;
		}

		@Override
		public void INVOKE() {
//			MethodCodeBuilder.this.INVOKE(opcode, typeOf(resideClazz), typeOf(returnClazz), methodName,
//					typesOf(params));

			Type clazzType = mh.thisMethod.clazzType.getType();

			String originDescriptor = Type.getMethodDescriptor(typeOf(originMethod.returnClazz), typesOf(originMethod.params));
			String originSignature = Type.getMethodDescriptor(typeOf(originMethod.returnClazz), typesOf(originMethod.params));

			String lambdaDescriptor = Type.getMethodDescriptor(typeOf(returnClazz), typesOf(this.params));
			@SuppressWarnings("unused")
			String lambdaSignature = Type.getMethodDescriptor(typeOf(this.returnClazz.signatureAnyway()), typesOf(this.params));

			List<Clazz> resultMethodParams = new ArrayList<>();
			resultMethodParams.addAll(this.params);
			resultMethodParams.addAll(originMethod.params);

			String resultDescriptor = Type.getMethodDescriptor(typeOf(originMethod.returnClazz), typesOf(resultMethodParams));

//			String resultMethodDescriptor ;

			mv.visitInvokeDynamicInsn(methodName, lambdaDescriptor, new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory",
					"metafactory",
					"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
					false),
					new Object[] { Type.getType(originDescriptor), new Handle(Opcodes.H_INVOKESTATIC, clazzType.getInternalName(),
							originMethod.methodName, resultDescriptor, false), Type.getType(originSignature) });
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

			stackPush(typeOf(this.returnClazz));
		}

	}

	class MethodCallerImpl implements MethodCaller<MethodCode> {
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
		public MethodCaller<MethodCode> parameter(Clazz clazz) {
			params.add(clazz);
			return this;
		}

		@Override
		public MethodCaller<MethodCode> reTurn(Clazz clazz) {
			returnClazz = clazz;
			return this;
		}

		@Override
		public void INVOKE() {
			MethodCodeBuilder.this.INVOKE(opcode, typeOf(resideClazz), typeOf(returnClazz), methodName, typesOf(params));
		}

		@Override
		public MethodCaller<MethodCode> LAMBDA(String targetClazz, String targetMethodName) {
			String[] genericParameterClazz = {};
			return new LAMBDAImpl(this.opcode, this, Clazz.of(targetClazz, genericParameterClazz), targetMethodName);
		}

	}

	@Override
	protected Type typeOfThis() {
		return this.mh.thisMethod.clazzType.getType();
	}

}