package nebula.tinyasm;

import org.objectweb.asm.MethodVisitor;

import nebula.tinyasm.data.LocalsStack;

public class MethodCodeStaticBuilder extends MethodCodeBuilder<MethodCodeStatic> implements MethodCodeStatic {

	public MethodCodeStaticBuilder(MethodVisitor mv, MethodHeaderBuilder<MethodCodeStatic> mh, LocalsStack locals) {
		super(mv, mh, locals);
	}

	@Override
	public MethodCodeStatic code() {
		return this;
	}

}
