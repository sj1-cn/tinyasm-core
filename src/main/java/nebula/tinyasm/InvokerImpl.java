package nebula.tinyasm;

import static nebula.tinyasm.TypeUtils.typeOf;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.objectweb.asm.Type;

public class InvokerImpl implements InvokerPrepare, Invoker {

	final MethodCodeAdv mv;
	final int invokeType;
	final Type objectType;
	final String methodName;
	List<Type> paramsRepected = new ArrayList<>();
	boolean definedParams = false;
	List<Type> paramsActual = new ArrayList<>();
	Type returnClazz;

	public InvokerImpl(MethodCodeAdv mv, int invokeType, Type objectType, String methodName) {
		super();
		this.mv = mv;
		this.invokeType = invokeType;
		this.objectType = objectType;
		this.methodName = methodName;
	}

	public InvokerImpl(MethodCodeAdv mv, int invokeType, Type objectType, String methodName, Type type) {
		this(mv, invokeType, objectType, methodName);

		paramsRepected.add(type);
	}

	@Override
	public InvokerPrepare parameter(Clazz clazz) {
		definedParams = true;
		paramsRepected.add(clazz.getType());
		return this;
	}

	@Override
	public void invokeVoid(String... varname) {
		for (String var : varname) {
			mv.load(var);
			Type type = this.mv.stackTypeOf(0);
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
	public void invokeVoid(Consumer<MethodCodeAdv>[] invocations) {
		for (Consumer<? super MethodCodeAdv> consumer : invocations) {
			consumer.accept(this.mv);
			Type type = this.mv.stackTypeOf(0);
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
	public Invoker returnObject(Clazz returnClazz) {
		this.returnClazz = typeOf(returnClazz);
		return this;
	}

	@Override
	public Instance invoke(Consumer<MethodCodeAdv>[] invocations) {
		for (Consumer<? super MethodCodeAdv> consumer : invocations) {
			consumer.accept(mv);
			paramsActual.add(mv.stackTypeOf(0));
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
			paramsActual.add(mv.stackTypeOf(0));
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
