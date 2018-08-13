package nebula.tinyasm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import nebula.tinyasm.data.Field;
import nebula.tinyasm.data.LocalsStack;
import nebula.tinyasm.util.ArrayListMap;

public class MethodCodeInstanceBuilder extends MethodCodeBuilder<MethodCodeInstance> implements MethodCodeInstance {

	ArrayListMap<Field> fields;

	public MethodCodeInstanceBuilder(MethodVisitor mv, MethodHeaderBuilder<MethodCodeInstance> mh, LocalsStack locals) {
		super(mv, mh, locals);
		this.fields = super.mh.thisMethod.fields;
	}

	@Override
	public MethodCodeInstance code() {
		return this;
	}

	@Override
	public Type codeThisFieldType(String name) {
		assert this.fields.containsKey(name) : "field + " + name + " not exist!";
		return this.fields.get(name).type;
	}

}
