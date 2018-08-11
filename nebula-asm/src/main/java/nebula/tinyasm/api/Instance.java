package nebula.tinyasm.api;

import static nebula.tinyasm.api.TypeUtils.typeOf;

public interface Instance<M, C extends MethodCode<M, C>> extends InvokeMethod<M, C>, ToType {

	@Deprecated
	C code();

	@Deprecated
	default Instance<M, C> getProperty(Field field) {
		return getProperty(field.name, field.type);
	}

	@Deprecated
	default Instance<M, C> getProperty(String fieldName, Class<?> fieldClass) {
		return getProperty(new Field(fieldName, typeOf(fieldClass)));
	}

	@Deprecated
	C put(String varName, Field field);

//	default void store(int varIndex) {
//		code().storeTop(varIndex);
//	}

	@Deprecated
	default void store(String varName) {
		code().storeStackTopTo(varName);
	}

	@Deprecated
	M use();
}