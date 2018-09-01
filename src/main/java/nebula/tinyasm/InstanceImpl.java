package nebula.tinyasm;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import nebula.tinyasm.data.Instance;
import nebula.tinyasm.data.InvokerPrepare;
import nebula.tinyasm.data.MethodCode;

public class InstanceImpl implements Instance {
	final MethodCode mv;
	final Type instanceType;

	public InstanceImpl(MethodCode mv, Type instanceType) {
		super();
		this.mv = mv;
		this.instanceType = instanceType;
	}

	@Override
	public InvokerPrepare inter(String methodName) {
		return new InvokerImpl(mv, Opcodes.INVOKEINTERFACE, instanceType, methodName);
	}

	@Override
	public InvokerPrepare virtual(String methodName) {
		return new InvokerImpl(mv, Opcodes.INVOKEVIRTUAL, instanceType, methodName);
	}

	@Override
	public InvokerPrepare special(String methodName) {
		return new InvokerImpl(mv, Opcodes.INVOKESPECIAL, instanceType, methodName);
	}

	@Override
	public void set(String varname) {
		mv.store(varname);
	}
}
