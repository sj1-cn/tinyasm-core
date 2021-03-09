package cc1sj.tinyasm;

import org.objectweb.asm.Type;
import static cc1sj.tinyasm.TypeUtils.arrayOf;

public class ClazzVariable implements Clazz {
	final String name;
	final boolean isarray;

	ClazzVariable(String name) {
		this.name = name;
		this.isarray = false;
	}

	public ClazzVariable(String name, boolean isarray) {
		this.name = name;
		this.isarray = isarray;
	}

	@Override
	public Type getType() {
		return arrayOf(Type.getType(Object.class), isarray);
	}

	@Override
	public String signatureAnyway() {
		return signatureOf();
	}

	@Override
	public String signatureWhenNeed() {
		return signatureOf();
	}

	@Override
	public boolean needSignature() {
		return false;
	}

	@Override
	public String getDescriptor() {
		return this.signatureOf();
	}

	@Override
	public String signatureOf() {
		return isarray ? "[T" + name + ";" : "T" + name + ";";
	}

	@Override
	public String toString() {
		return signatureOf();
	}

}
