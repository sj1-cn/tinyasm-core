package nebula.tinyasm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Type;

import nebula.tinyasm.data.ClassField;
import nebula.tinyasm.data.LocalsVariable;

class MethodIndependentInstanceBuilder extends MethodBuilder<MethodIndependentCode>
		implements MethodIndependentCode, MethodHeaderAdv<MethodIndependentCode> {

	public MethodIndependentInstanceBuilder(ClassVisitor cv, Type thisType, int access, String methodName) {
		this(cv, thisType, access, Type.VOID_TYPE, methodName);
	}

	public MethodIndependentInstanceBuilder(ClassVisitor cv, Type thisType, int access, Type returnType,
			String methodName) {
		super(cv, thisType, access, returnType, methodName, new String[0]);
	}

	@Override
	public MethodIndependentCode code() {
		return this;
	}

	@Override
	protected MethodIndependentCode makeMethodBegin() {
		mv.visitCode();

		labelCurrent = labelWithoutLineNumber();
		// TODO add class sign
		locals.push(_THIS, thisMethod.type, labelCurrent);
		for (ClassField field : thisMethod.params) {
			locals.push(new LocalsVariable(field, labelCurrent));
		}

		return code();
	}

}