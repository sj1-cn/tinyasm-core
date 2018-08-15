package nebula.tinyasm.data;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;

public class LocalsVariable extends ClassField {
	public Label startFrom;

	public Object value;

	public static enum VarType {
		LOCAL, PARAM, FIELD
	}

	final public VarType varType;

	public LocalsVariable(VarType varType, ClassField field, Label startFrom) {
		super(field.access, field.name, field.type, field.signature, null);
		this.startFrom = startFrom;
		this.varType = varType;
	}

	public LocalsVariable(VarType varType, String name, Type type) {
		super(0, name, type, null, null);
		this.varType = varType;
	}

	public LocalsVariable(VarType varType, String name, Type type, Label startFrom) {
		super(0, name, type, null, startFrom);
		this.varType = varType;
	}

	public LocalsVariable(VarType varType, String name, Type type, String signature) {
		super(0, name, type, signature, null);
		this.varType = varType;
	}

	public LocalsVariable(VarType varType, String name, Type type, String signature, Label startFrom) {
		super(0, name, type, signature, null);
		this.startFrom = startFrom;
		this.varType = varType;
	}

	public int locals = 0;
}