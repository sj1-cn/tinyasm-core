package nebula.tinyasm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Type;

import nebula.tinyasm.api.MethodHeader;
import nebula.tinyasm.api.StaticMethodCode;

class StaticMethodBuilder
		extends AbstractMethodBuilder<MethodHeader<StaticMethodCode>, StaticMethodCode>
		implements StaticMethodCode, MethodHeader<StaticMethodCode> {

	public StaticMethodBuilder(ClassVisitor cv, Type thisType, int access, Type returnType, String methodName,
			String[] exceptionClasses) {
		super(cv, thisType, access, returnType, methodName, exceptionClasses);
	}

	@Override
	public StaticMethodCode code() {
		return this;
	}

}