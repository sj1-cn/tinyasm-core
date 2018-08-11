package nebula.tinyasm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import nebula.tinyasm.api.MethodHeader;
import nebula.tinyasm.api.StaticMethodCode;
import nebula.tinyasm.api.MethodCallerInStaticMethod;

class StaticMethodBuilder
		extends AbstractMethodBuilder<MethodHeader<StaticMethodCode>, MethodCallerInStaticMethod, StaticMethodCode>
		implements StaticMethodCode, MethodHeader<StaticMethodCode> {

	class MethodCallerInStaticMethodImpl extends AbstractMethodCaller implements MethodCallerInStaticMethod {
		public MethodCallerInStaticMethodImpl(MethodVisitor mv, Type objectType) {
			super(objectType);
		}

		@Override
		MethodCallerInStaticMethod caller() {
			return this;
		}

		@Override
		public StaticMethodCode code() {
			return StaticMethodBuilder.this;
		}
	}

	public StaticMethodBuilder(ClassVisitor cv, Type thisType, int access, Type returnType, String methodName,
			String[] exceptionClasses) {
		super(cv, thisType, access, returnType, methodName, exceptionClasses);
	}

	@Override
	public Type thisType() {
		return thisMethod.type;
	}

	@Override
	public StaticMethodCode code() {
		return this;
	}

	@Override
	public MethodCallerInStaticMethod useStackTop(Type type) {
		return new MethodCallerInStaticMethodImpl(mv, type);
	}

	@Override
	public void visitFieldInsn(int opcode, Type ownerType, String name, Type fieldType) {
		// TODO Auto-generated method stub
		
	}
}