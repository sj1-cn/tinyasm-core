package nebula.tinyasm;

import java.util.function.Consumer;

import nebula.tinyasm.util.GenericClazz;
import nebula.tinyasm.util.TypeUtils;

public interface Instance {
	InvokerPrepare inter(String methodName);

	InvokerPrepare virtual(String methodName);

	InvokerPrepare special(String methodName);

	void setTo(String varname);

	void setElement(int index, Consumer<MethodCode> p0);

	Instance loadElement(int index);

	Instance boxWhenNeed();

	Instance unbox();

	void returnValue();

	void pop();

	default Instance checkcast(Class<?> clazz) {
		return checkcast(TypeUtils.generic(clazz));
	}

	default Instance checkcast(String clazz) {
		return checkcast(TypeUtils.generic(clazz));
	}

	Instance checkcastAndUnbox(GenericClazz clazz);

	default Instance checkcastAndUnbox(Class<?> clazz) {
		return checkcastAndUnbox(TypeUtils.generic(clazz));
	}

	default Instance checkcastAndUnbox(String clazz) {
		return checkcastAndUnbox(TypeUtils.generic(clazz));
	}

	Instance checkcast(GenericClazz clazz);

	Instance add(String varname);

	Instance add(int intvalue);

	Instance add(long longValue);

	Instance add(Consumer<MethodCode> p0);

	Instance convertTo(String clazz);

	Instance convertTo(Class<?> clazz);

}
