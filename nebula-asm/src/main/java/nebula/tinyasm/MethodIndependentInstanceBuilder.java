package nebula.tinyasm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import nebula.tinyasm.api.MethodHeader;
import nebula.tinyasm.api.MethodInstanceMethodCode;
import nebula.tinyasm.data.ClassField;
import nebula.tinyasm.data.LocalsVariable;

interface IndependentMethodCode extends MethodInstanceMethodCode<IndependentMethodCode> {

}

class MethodIndependentInstanceBuilder extends
		MethodBuilder<MethodHeader<IndependentMethodCode>,  IndependentMethodCode>
		implements IndependentMethodCode, MethodHeader<IndependentMethodCode>, Opcodes {

//	class IndependentMethodCallerImpl extends AbstractMethodCaller implements IndependentMethodCaller {
//		public IndependentMethodCallerImpl(Type objectType) {
//			super(objectType);
//		}
//
//		@Override
//		IndependentMethodCaller caller() {
//			return this;
//		}
//
//		@Override
//		public IndependentMethodCode code() {
//			return IndependentInstanceMethodBuilder.this;
//		}
//	}

	public MethodIndependentInstanceBuilder(ClassVisitor cv, Type thisType, int access, String methodName) {
		this(cv, thisType, access, Type.VOID_TYPE, methodName);
	}

	public MethodIndependentInstanceBuilder(ClassVisitor cv, Type thisType, int access, Type returnType,
			String methodName) {
		super(cv, thisType, access, returnType, methodName, new String[0]);
	}

	@Override
	public IndependentMethodCode code() {
		return this;
	}

	@Override
	protected IndependentMethodCode makeMethodBegin() {
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