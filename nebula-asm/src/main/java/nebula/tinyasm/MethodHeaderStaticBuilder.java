package nebula.tinyasm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

class MethodHeaderStaticBuilder extends MethodHeaderBuilder<MethodCodeStatic> {

	public MethodHeaderStaticBuilder(ClassBuilderImpl cv, Type thisType, int access, Type returnType, String methodName,
			String[] exceptionClasses) {
		super(cv, thisType, access, returnType, methodName, exceptionClasses);
	}

	@Override
	public MethodCodeStatic makeCode(MethodVisitor mv) {
		return new MethodCodeStaticBuilder(mv, this, super.mhLocals);
	}

}