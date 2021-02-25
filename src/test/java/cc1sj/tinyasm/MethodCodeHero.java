package cc1sj.tinyasm;

import java.util.function.Consumer;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethodCodeHero extends MethodCode {
	Logger log = LoggerFactory.getLogger(MethodCodeHero.class);
	
	@Override
	public void BLOCK(Consumer<MethodCode> mc) {
		log.debug("BLOCK(Consumer<MethodCode> mc) ");
		
	}

	@Override
	public void LINE() {
		log.debug("");
		
	}

	@Override
	public void LINE(int line) {
		log.debug("");
		
	}

	@Override
	public MethodCaller<MethodCode> STATIC(Clazz objectType, String methodName) {
		log.debug("");
		return null;
	}

	@Override
	public MethodCaller<MethodCode> INTERFACE(Clazz objectType, String methodName) {
		log.debug("");
		return null;
	}

	@Override
	public MethodCaller<MethodCode> SPECIAL(Clazz objectType, String methodName) {
		log.debug("");
		return null;
	}

	@Override
	public MethodCaller<MethodCode> VIRTUAL(Clazz objectType, String methodName) {
		log.debug("");
		return null;
	}

	@Override
	public void define(String name, Clazz clazz) {
		log.debug("");
		
	}

	@Override
	public void define(Annotation annotation, String name, Clazz clazz) {
		log.debug("");
		
	}

	@Override
	public void visitLabel(Label label) {
		log.debug("");
		
	}

	@Override
	void visitLabel(Label label, int line) {
		log.debug("");
		
	}

	@Override
	public void visitInsn(int opcode) {
		log.debug("");
		
	}

	@Override
	void visitVarInsn(int opcode, int index) {
		log.debug("");
		
	}

	@Override
	void visitInsn(int opcode, int operand) {
		log.debug("");
		
	}

	@Override
	void visitFieldInsn(int opcode, Type ownerType, String name, Type fieldType) {
		log.debug("");
		
	}

	@Override
	void visitMethodInsn(int opcode, Type objectType, Type returnType, String methodName, Type... paramTypes) {
		log.debug("");
		
	}

	@Override
	void visitTryCatchBlock(Label start, Label end, Label handler, Type exctpionClazz) {
		log.debug("");
		
	}

	@Override
	void visitLdcInsn(Object cst) {
		log.debug("");
		
	}

	@Override
	void visitTypeInsn(int opcode, Type type) {
		log.debug("");
		
	}

	@Override
	void visitJumpInsn(int opcode, Label label) {
		log.debug("");
		
	}

	@Override
	void visitIincInsn(int var, int increment) {
		log.debug("");
		
	}

	@Override
	protected Type typeOfThis() {
		log.debug("");
		return null;
	}

	@Override
	protected Type codeThisFieldType(String name) {
		log.debug("");
		return null;
	}

	@Override
	protected Type codeThisClassFieldType(String name) {
		log.debug("");
		return null;
	}

	@Override
	protected int codeLocalGetLocals(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected Type localsLoadAccess(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Type localsStoreAccess(int index, Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Type stackTypeOf(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Type stackPop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void stackPush(Type type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void END() {
		// TODO Auto-generated method stub
		
	}

	@Override
	Label codeNewLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
