package nebula.tinyasm;

import java.util.Stack;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class SmartOpcodeImpl implements SmartOpcode {

	final MethodVisitor mv;
	final LocalsStack locals;
	final Stack<Type> stack = new Stack<>();

	public SmartOpcodeImpl(MethodVisitor mv, LocalsStack locals) {
		this.mv = mv;
		this.locals = locals;
	}

	@Override
	public Type codeGetStack(int i) {
		return stack.get(stack.size() - i - 1);
	}

	@Override
	public void codeInst(int opcode) {
		mv.visitInsn(opcode);
	}

	@Override
	public void visitInvoke(int opcode, Type objectType, Type returnType, String methodName, Type... paramTypes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void codeInst(int opcode, int var) {
		mv.visitVarInsn(opcode, var);
	}

	@Override
	public int codeLocals(String name) {
		return locals.get(name).locals;
	}

	@Override
	public Type codeLocalsType(String name) {
		return locals.get(name).type;
	}

	@Override
	public Type codePopStack() {
		return stack.pop();
	}

	@Override
	public void codePush(Type type) {
		stack.push(type);
	}

	@Override
	public void visitTypeInsn(int opcode, Type type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitFieldInsn(int opcode, Type ownerType, String name, Type fieldType) {
		// TODO Auto-generated method stub
		
	}

}
