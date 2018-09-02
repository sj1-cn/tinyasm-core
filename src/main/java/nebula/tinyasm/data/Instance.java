package nebula.tinyasm.data;

import java.util.function.Consumer;

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
		return checkcast(GenericClazz.generic(clazz));
	}

	default Instance checkcast(String clazz) {
		return checkcast(GenericClazz.generic(clazz));
	}

	Instance checkcast(GenericClazz clazz);
}
