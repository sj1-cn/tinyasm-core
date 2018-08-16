package nebula.tinyasm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

class MethodHeaderInstanceBuilder extends MethodHeaderBuilder<MethodCodeInstance> {

	public MethodHeaderInstanceBuilder(ClassBuilderImpl cv, Type thisType, int access, Type returnType,
			String methodName, String[] exceptiones) {
		super(cv, thisType, access, returnType, methodName, exceptiones);
	}

	@Override
	public MethodCodeInstance makeCode(MethodVisitor mv) {
		return new MethodCodeInstanceBuilder(mv, this, super.mhLocals);
	}

	@Override
	protected void preapareMethodWithThis() {
		mhLocals.push("this", GenericClazz.clazz(thisMethod.type.getClassName()), labelCurrent);
	}

}
