package nebula.tinyasm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Type;

import nebula.tinyasm.api.ClassField;
import nebula.tinyasm.api.MethodInstanceMethodCode;
import nebula.tinyasm.api.MethodCode;
import nebula.tinyasm.api.MethodHeader;

abstract class AbstractInstanceMethodVisitor<H, M, C extends MethodCode<M, C>>
		extends AbstractMethodBuilder<H, M, C> implements MethodInstanceMethodCode<M, C>, MethodHeader<C> {

	public AbstractInstanceMethodVisitor(ClassVisitor cv, Type thisType, int access, Type returnType, String methodName,
			String[] exceptionClasses) {
		super(cv, thisType, access, returnType, methodName, exceptionClasses);
	}

	@Override
	protected C makeMethodBegin() {
		currentInstance = new ThisInstance();
		mv.visitCode();

		labelCurrent = labelWithoutLineNumber();
		// TODO add class sign
		locals.push(THIS, thisMethod.type, labelCurrent);
		for (ClassField field : thisMethod.params) {
			locals.push(new LocalsVariable(field, labelCurrent));
		}
//		recomputerLocals();

		return code();
	}

	@Override
	@Deprecated
	public Type thisType() {
		return thisMethod.type;
	}

}
