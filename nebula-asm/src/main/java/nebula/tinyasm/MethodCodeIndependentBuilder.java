package nebula.tinyasm;

import org.objectweb.asm.MethodVisitor;

import nebula.tinyasm.data.LocalsStack;

public class MethodCodeIndependentBuilder extends MethodCodeBuilder<MethodCodeIndependent>
		implements MethodCodeIndependent {

	public MethodCodeIndependentBuilder(MethodVisitor mv, MethodHeaderBuilder<MethodCodeIndependent> mh,
			LocalsStack locals) {
		super(mv, mh, locals);
	}

	@Override
	public MethodCodeIndependent code() {
		return this;
	}

}
