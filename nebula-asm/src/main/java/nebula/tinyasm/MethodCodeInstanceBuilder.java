package nebula.tinyasm;

import org.objectweb.asm.MethodVisitor;

import nebula.tinyasm.data.LocalsStack;

public class MethodCodeInstanceBuilder extends MethodCodeBuilder<MethodCodeInstance> implements MethodCodeInstance {

	public MethodCodeInstanceBuilder(MethodVisitor mv, MethodHeaderBuilder<MethodCodeInstance> mh, LocalsStack locals) {
		super(mv, mh, locals);
	}

	@Override
	public MethodCodeInstance code() {
		return this;
	}

}
