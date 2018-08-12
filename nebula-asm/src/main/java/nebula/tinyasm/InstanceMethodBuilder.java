package nebula.tinyasm;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import nebula.tinyasm.api.ClassThisInstance;
import nebula.tinyasm.api.Field;
import nebula.tinyasm.api.InstanceMethodCode;
import nebula.tinyasm.api.MethodCallerInInstanceMethod;
import nebula.tinyasm.api.MethodHeader;

class InstanceMethodBuilder extends
		AbstractInstanceMethodVisitor<MethodHeader<InstanceMethodCode>, MethodCallerInInstanceMethod, InstanceMethodCode>
		implements MethodHeader<InstanceMethodCode>, InstanceMethodCode, Opcodes {
	class MethodCallerInInstanceMethodImpl extends AbstractMethodCaller implements MethodCallerInInstanceMethod {

		public MethodCallerInInstanceMethodImpl(Type objectType) {
			super(objectType);
		}

		@Override
		MethodCallerInInstanceMethod caller() {
			return this;
		}
	}

	@Deprecated
	class ThisInstanceImpl extends ThisInstance implements ClassThisInstance {
		ThisInstanceImpl() {
		}

		@Override
		public Field fieldOf(String fieldName) {
			return cv.fieldOfThis(fieldName);
		}
	}

	ClassBuilderImpl cv;

	public InstanceMethodBuilder(ClassBuilderImpl cv, Type thisType, int access, Type returnType, String methodName,
			String[] exceptionClasses) {
		super(cv, thisType, access, returnType, methodName, exceptionClasses);
		this.cv = cv;
	}

	@Override
	public InstanceMethodCode code() {
		return this;
	}

}
