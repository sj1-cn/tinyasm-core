package nebula.tinyasm;

import static nebula.tinyasm.TypeUtils.typeOf;
import static nebula.tinyasm.TypeUtils.typesOf;
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

public class MethodCodeBuilder implements MethodCode {
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
	public MethodCode block(Consumer<MethodCode> invocation) {
		invocation.accept(this);
		return this;
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
	public void define(String name, GenericClazz clazz) {
		locals.define(name, clazz);
	}

	@Override
	public void define(Annotation annotation, String name, GenericClazz clazz) {
		locals.define(annotation, name, clazz);
	}
	
	@Override
	public Type codeThisClassFieldType(String name) {
		assert mh.staticFields.containsKey(name) : "field + " + name + " not exist!";
		return mh.staticFields.get(name).type;
	}

	@Override
	public Type codeThisFieldType(String name) {
		assert mh.thisMethod.instanceMethod;
		assert mh.fields.containsKey(name) : "field + " + name + " not exist!";
		return mh.fields.get(name).type;
	}

	@Override
	public Label codeNewLabel() {
		Label label = new Label();
		return label;
	}

	@Override
	public void end() {
		mh.finishMethod();
	}

	public MethodCode line() {
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
		return this;
	}

	public MethodCode line(int line) {
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
		return this;
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
	public void visitMethodInsn(int opcode, Type objectType, Type returnType, String methodName, Type... paramTypes) {
		mv.visitMethodInsn(opcode, objectType.getInternalName(), methodName, Type.getMethodDescriptor(returnType, paramTypes), opcode == INVOKEINTERFACE);

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
	public MethodCaller<MethodCode> STATIC(String objectType, String methodName) {

		return new MethodCallerImpl(Opcodes.INVOKESTATIC, TypeUtils.generic(objectType), methodName);
	}

	@Override
	public MethodCaller<MethodCode> INTERFACE(String objectType, String methodName) {
		return new MethodCallerImpl(Opcodes.INVOKEINTERFACE, TypeUtils.generic(objectType), methodName);
	}

	@Override
	public MethodCaller<MethodCode> SPECIAL(String objectType, String methodName) {
		return new MethodCallerImpl(Opcodes.INVOKESPECIAL, TypeUtils.generic(objectType), methodName);
	}

	@Override
	public MethodCaller<MethodCode> VIRTUAL(String objectType, String methodName) {
		return new MethodCallerImpl(Opcodes.INVOKEVIRTUAL, TypeUtils.generic(objectType), methodName);
	}

	class LAMBDAImpl extends MethodCallerImpl implements MethodCaller<MethodCode> {
		List<GenericClazz> params = new ArrayList<>();
		GenericClazz returnClazz;

		final int opcode;
		final GenericClazz resideClazz;
		final String methodName;
		final MethodCallerImpl originMethod;

		public LAMBDAImpl(int opcode, MethodCallerImpl targetMethod, GenericClazz resideClazz, String methodName) {
			super(opcode, resideClazz, methodName);
			this.opcode = opcode;
			this.resideClazz = resideClazz;
			this.methodName = methodName;
			this.originMethod = targetMethod;
		}

		@Override
		public MethodCaller<MethodCode> parameter(GenericClazz clazz) {
			params.add(clazz);
			return this;
		}

		@Override
		public MethodCaller<MethodCode> reTurn(GenericClazz clazz) {
			returnClazz = clazz;
			return this;
		}

		@Override
		public void INVOKE() {
//			MethodCodeBuilder.this.INVOKE(opcode, typeOf(resideClazz), typeOf(returnClazz), methodName,
//					typesOf(params));

			Type thisClazzInternalName = mh.thisMethod.type;

			String originDescriptor = Type.getMethodDescriptor(typeOf(originMethod.returnClazz.originclazzName), typesOf(originMethod.params));
			String originSignature = Type.getMethodDescriptor(typeOf(originMethod.returnClazz.genericClazz), typesOf(originMethod.params));

			String lambdaDescriptor = Type.getMethodDescriptor(typeOf(this.returnClazz), typesOf(this.params));
			@SuppressWarnings("unused")
			String lambdaSignature = Type.getMethodDescriptor(typeOf(this.returnClazz.signatureAnyway()), typesOf(this.params));

			List<GenericClazz> resultMethodParams = new ArrayList<>();
			resultMethodParams.addAll(this.params);
			resultMethodParams.addAll(originMethod.params);

			String resultDescriptor = Type.getMethodDescriptor(typeOf(originMethod.returnClazz.genericClazz), typesOf(resultMethodParams));

//			String resultMethodDescriptor ;

			mv.visitInvokeDynamicInsn(methodName, lambdaDescriptor, new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory",
					"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
					false),
					new Object[] { Type.getType(originDescriptor),
							new Handle(Opcodes.H_INVOKESTATIC, thisClazzInternalName.getInternalName(), originMethod.methodName, resultDescriptor, false),
							Type.getType(originSignature) });
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
		List<GenericClazz> params = new ArrayList<>();
		GenericClazz returnClazz;

		final int opcode;
		final GenericClazz resideClazz;
		final String methodName;

		public MethodCallerImpl(int opcode, GenericClazz resideClazz, String methodName) {
			super();
			this.opcode = opcode;
			this.resideClazz = resideClazz;
			this.methodName = methodName;
		}

		@Override
		public MethodCaller<MethodCode> parameter(GenericClazz clazz) {
			params.add(clazz);
			return this;
		}

		@Override
		public MethodCaller<MethodCode> reTurn(GenericClazz clazz) {
			returnClazz = clazz;
			return this;
		}

		@Override
		public void INVOKE() {
			MethodCodeBuilder.this.INVOKE(opcode, typeOf(resideClazz), typeOf(returnClazz), methodName, typesOf(params));
		}

		@Override
		public MethodCaller<MethodCode> LAMBDA(String targetClazz, String targetMethodName) {
			return new LAMBDAImpl(this.opcode, this, TypeUtils.generic(targetClazz), targetMethodName);
		}

	}
}