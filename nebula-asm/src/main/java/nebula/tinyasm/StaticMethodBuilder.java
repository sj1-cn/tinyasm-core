package nebula.tinyasm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Type;

class StaticMethodBuilder extends MethodBuilder<MethodStaticCode>
		implements MethodStaticCode, MethodHeaderAdv<MethodStaticCode> {

	public StaticMethodBuilder(ClassVisitor cv, Type thisType, int access, Type returnType, String methodName,
			String[] exceptionClasses) {
		super(cv, thisType, access, returnType, methodName, exceptionClasses);
	}

	@Override
	public MethodStaticCode code() {
		return this;
	}

}