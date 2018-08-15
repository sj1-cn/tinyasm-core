package nebula.tinyasm;

import static org.objectweb.asm.Opcodes.BIPUSH;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;

import java.util.Stack;
import java.util.function.Consumer;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import nebula.tinyasm.data.LocalsStack;
import nebula.tinyasm.data.LocalsVariable;
import nebula.tinyasm.data.LocalsVariable.VarType;

abstract class MethodCodeBuilder<MC extends MethodCode<MC>> implements MethodCode<MC> {
	private final MethodVisitor mv;

	final protected LocalsStack locals;
	final Stack<Type> stack = new Stack<>();
	final MethodHeaderBuilder<MC> mh;

	int lastLineNumber = 0;

	protected Label labelCurrent;
	protected boolean labelHasDefineBegin;

	public MethodCodeBuilder(MethodVisitor mv, MethodHeaderBuilder<MC> mh, LocalsStack locals) {
		this.mv = mv;
		this.mh = mh;
		this.locals = locals;
		this.labelHasDefineBegin = mh.labelHasDefineBegin;
		this.labelCurrent = mh.labelCurrent;
	}

	@Override
	public MC block(Consumer<MC> invocation) {
		invocation.accept(code());
		return code();
	}

	abstract public MC code();

	@Override
	public void labelHere(Label label) {
		labelCurrent = label;
		mv.visitLabel(label);
	}

	@Override
	public void codeAccessLabel(Label label, int line) {
		labelCurrent = label;
		mv.visitLabel(label);
		mv.visitLineNumber(line, label);
	}

	@Override
	public Type codeGetStack(int i) {
		return stack.get(stack.size() - i - 1);
	}

	@Override
	public int codeLocalLoadAccess(String name) {
		return locals.accessLoad(name, labelCurrent).locals;
	}

	@Override
	public Type codeLocalLoadAccessType(String name) {
		return locals.accessLoad(name, labelCurrent).type;
	}

	@Override
	public Type codeLocalLoadAccessType(int index) {
		return locals.accessLoad(index, labelCurrent).type;
	}

	@Override
	public Type codeLocalStoreAccessType(int index) {
		return locals.accessLoad(index, labelCurrent).type;
	}

	@Override
	public int codeLocalStoreAccess(String name) {
		return locals.accessStore(name, labelCurrent).locals;
	}

	@Override
	public Type codeLocalStoreAccessType(String name) {
		return locals.accessStore(name, labelCurrent).type;
	}

	@Override
	public Type codeThisFieldType(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Label codeNewLabel() {
		Label label = new Label();
		return label;
	}

	@Override
	public Type codePopStack() {
		Type type = stack.pop();
		printStack(stack);
		return type;
	}

	@Override
	public void codePush(Type type) {
		stack.push(type);
		printStack(stack);
	}

	@Override
	public MC vmVar(String name, Type type, String signature) {
		locals.push(new LocalsVariable(VarType.LOCAL, name, type, signature));
//		recomputerLocals();
		return code();
	}

	@Override
	public void end() {
		mh.finishMethod();
	}

	protected Label labelWithoutLineNumber() {
		Label label = new Label();
		labelCurrent = label;
		mv.visitLabel(label);
		return label;
	}

	public MC line() {
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
		return code();
	}

	public MC line(int line) {
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
		return code();
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
	public void mvFieldInsn(int opcode, Type ownerType, String fieldName, Type fieldType) {
		mv.visitFieldInsn(opcode, ownerType.getInternalName(), fieldName, fieldType.getDescriptor());
	}

	@Override
	public void mvInst(int opcode) {
		mv.visitInsn(opcode);
	}

	@Override
	public void mvInst(int opcode, int var) {
		mv.visitVarInsn(opcode, var);
	}

	@Override
	public void mvIntInsn(int opcode, int operand) {
		if (opcode == BIPUSH && -1 <= operand && operand <= 5) {
			mv.visitInsn(ICONST_0 + operand);
		} else {
			mv.visitIntInsn(opcode, operand);
		}
	}

	@Override
	public void mvInvoke(int opcode, Type objectType, Type returnType, String methodName, Type... paramTypes) {
		mv.visitMethodInsn(opcode, objectType.getInternalName(), methodName,
				Type.getMethodDescriptor(returnType, paramTypes), opcode == INVOKEINTERFACE);

	}

	@Override
	public void mvJumpInsn(int opcode, Label label) {
		mv.visitJumpInsn(opcode, label);
	}

	@Override
	public void mvLdcInsn(Object cst) {
		mv.visitLdcInsn(cst);
	}

	@Override
	public void mvTypeInsn(int opcode, Type type) {
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

}