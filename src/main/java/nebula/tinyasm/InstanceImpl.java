package nebula.tinyasm;

import java.util.function.Consumer;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import nebula.tinyasm.data.GenericClazz;
import nebula.tinyasm.data.Instance;
import nebula.tinyasm.data.InvokerPrepare;
import nebula.tinyasm.data.MethodCode;
import nebula.tinyasm.util.TypeUtils;

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
	public void setTo(String varname) {
		mv.store(varname);
	}

	@Override
	public void setElement(int index, Consumer<MethodCode> p0) {
		Type arrayType = mv.codeGetStackType(0);
		assert arrayType.getSort() == Type.ARRAY;

		mv.LOADConst(index);
		p0.accept(mv);
		mv.ARRAYSTORE();
	}

	@Override
	public Instance loadElement(int index) {
		Type arrayType = mv.codeGetStackType(0);
		assert arrayType.getSort() == Type.ARRAY;

		mv.LOADConst(index);
		mv.ARRAYLOAD(arrayType.getElementType());
		return mv.topInstance();
	}

	@Override
	public Instance boxWhenNeed() {
		BoxUnbox.box(instanceType.getClassName()).accept(mv);
		return mv.topInstance();
	}

	@Override
	public Instance unbox() {
		BoxUnbox.unbox(instanceType.getClassName()).accept(mv);
		return mv.topInstance();
	}

	@Override
	public void pop() {
		mv.POP();
	}

	@Override
	public void returnValue() {
		mv.RETURNTop();
	}

	@Override
	public Instance checkcast(GenericClazz clazz) {
		mv.CHECKCAST(TypeUtils.typeOf(clazz));
		return mv.topInstance();
	}
}
