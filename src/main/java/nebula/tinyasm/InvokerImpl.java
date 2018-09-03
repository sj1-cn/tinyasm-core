package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.typeOf;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.objectweb.asm.Type;

import nebula.tinyasm.data.GenericClazz;
import nebula.tinyasm.data.Instance;
import nebula.tinyasm.data.Invoker;
import nebula.tinyasm.data.InvokerPrepare;
import nebula.tinyasm.data.MethodCode;

public class InvokerImpl implements InvokerPrepare, Invoker {

	final MethodCode mv;
	final int invokeType;
	final Type objectType;
	final String methodName;
	List<Type> paramsRepected = new ArrayList<>();
	boolean definedParams = false;
	List<Type> paramsActual = new ArrayList<>();
	Type returnClazz;

	public InvokerImpl(MethodCode mv, int invokeType, Type objectType, String methodName) {
		super();
		this.mv = mv;
		this.invokeType = invokeType;
		this.objectType = objectType;
		this.methodName = methodName;
	}

	public InvokerImpl(MethodCode mv, int invokeType, Type objectType, String methodName, Type type) {
		this(mv, invokeType, objectType, methodName);

		paramsRepected.add(type);
	}

	@Override
	public InvokerPrepare parameter(GenericClazz clazz) {
		definedParams = true;
		paramsRepected.add(typeOf(clazz));
		return this;
	}

	@Override
	public void invokeVoid(String... varname) {
		for (String var : varname) {
			mv.load(var);
			Type type = this.mv.codeGetStackType(0);
			paramsActual.add(type);
		}

		Type[] params;
		if (definedParams) {
			params = paramsRepected.toArray(new Type[0]);
		} else {
			params = paramsActual.toArray(new Type[0]);
		}
		mv.INVOKE(invokeType, objectType, Type.VOID_TYPE, methodName, params);

	}

	@Override
	public void invokeVoid(Consumer<MethodCode>[] invocations) {
		for (Consumer<? super MethodCode> consumer : invocations) {
			consumer.accept(this.mv);
			Type type = this.mv.codeGetStackType(0);
			paramsActual.add(type);
		}

		Type[] params;
		if (definedParams) {
			params = paramsRepected.toArray(new Type[0]);
		} else {
			params = paramsActual.toArray(new Type[0]);
		}
		mv.INVOKE(invokeType, objectType, Type.VOID_TYPE, methodName, params);
	}

	@Override
	public Invoker returnObject(GenericClazz returnClazz) {
		this.returnClazz = typeOf(returnClazz);
		return this;
	}

	@Override
	public Instance invoke(Consumer<MethodCode>[] invocations) {
		for (Consumer<? super MethodCode> consumer : invocations) {
			consumer.accept(mv);
			paramsActual.add(mv.codeGetStackType(0));
		}
		Type[] params;
		if (definedParams) {
			params = paramsRepected.toArray(new Type[0]);
		} else {
			params = paramsActual.toArray(new Type[0]);
		}
		mv.INVOKE(invokeType, objectType, returnClazz, methodName, params);

		return new InstanceImpl(mv, returnClazz);
	}

	@Override
	public Instance invoke(String... varname) {
		for (String string : varname) {
			mv.load(string);
			paramsActual.add(mv.codeGetStackType(0));
		}
		Type[] params;
		if (definedParams) {
			params = paramsRepected.toArray(new Type[0]);
		} else {
			params = paramsActual.toArray(new Type[0]);
		}
		mv.INVOKE(invokeType, objectType, returnClazz, methodName, params);

		return new InstanceImpl(mv, returnClazz);
	}

	@Override
	public Instance invoke() {
		mv.INVOKE(invokeType, objectType, returnClazz, methodName, new Type[0]);
		return new InstanceImpl(mv, returnClazz);
	}

}
