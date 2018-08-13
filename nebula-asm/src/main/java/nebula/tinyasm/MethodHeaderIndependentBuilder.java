package nebula.tinyasm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

class MethodHeaderIndependentBuilder extends MethodHeaderBuilder<MethodCodeIndependent> {

	public MethodHeaderIndependentBuilder(ClassVisitor cv, Type thisType, int access, Type returnType, String methodName,
			String[] exceptiones) {
		super(cv, thisType, access, returnType, methodName, exceptiones);
	}

	@Override
	public MethodCodeIndependent makeCode(MethodVisitor mv) {
		return new MethodCodeIndependentBuilder(mv, this, super.mhLocals);
	}

}