package nebula.tinyasm;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import nebula.tinyasm.data.Clazz;
import nebula.tinyasm.data.InvokerPrepare;
import nebula.tinyasm.data.MethodCode;

public class ClazzImpl implements Clazz{
	final MethodCode mv;
	final Type clazz;

	public ClazzImpl(MethodCode mv, Type clazz) {
		super();
		this.mv = mv;
		this.clazz = clazz;
	}

	@Override
	public InvokerPrepare call(String methodName) {
		return new InvokerImpl(mv, Opcodes.INVOKESTATIC, clazz, methodName);
	}

}
