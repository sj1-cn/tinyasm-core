package nebula.tinyasm;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class ClazzReferenceImpl implements ClazzReference{
	final MethodCode mv;
	final Type clazz;

	public ClazzReferenceImpl(MethodCode mv, Type clazz) {
		super();
		this.mv = mv;
		this.clazz = clazz;
	}

	@Override
	public InvokerPrepare call(String methodName) {
		return new InvokerImpl(mv, Opcodes.INVOKESTATIC, clazz, methodName);
	}

}
