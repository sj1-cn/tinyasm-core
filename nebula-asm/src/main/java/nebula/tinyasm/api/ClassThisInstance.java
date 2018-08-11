package nebula.tinyasm.api;

import static nebula.tinyasm.api.TypeUtils.typeOf;

import org.objectweb.asm.Type;

@Deprecated
public interface ClassThisInstance extends Instance<MethodCallerInInstanceMethod, InstanceMethodCode> {
	Field fieldOf(String fieldName);

	default Instance<MethodCallerInInstanceMethod, InstanceMethodCode> get(String fieldName) {
		return get(fieldOf(fieldName));
	}

	default Instance<MethodCallerInInstanceMethod, InstanceMethodCode> getProperty(String fieldName) {
		return getProperty(fieldOf(fieldName));
	}

	default InstanceMethodCode put(String varName, String fieldName) {
		return put(varName, fieldOf(fieldName));
	}

	default InstanceMethodCode putTopTo(String fieldName) {
		return code().putTopTo(fieldOf(fieldName));
	}

	default InstanceMethodCode putTopTo(String fieldName, Class<?> fieldClass) {
		return code().putTopTo(new Field(fieldName, typeOf(fieldClass)));
	}

	default InstanceMethodCode putTopTo(String fieldName, Type fieldType) {
		return code().putTopTo(new Field(fieldName, fieldType));
	}
}
