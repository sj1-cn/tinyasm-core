package nebula.tinyasm.api;

import java.util.function.Consumer;
import java.util.function.Function;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;

import nebula.tinyasm.SmartOpcode;

import static nebula.tinyasm.api.TypeUtils.*;

public interface MethodCode<M, C extends MethodCode<M, C>> extends SmartOpcode {

	C accessLabel(Label label);

	C accessLabel(Label label, int line);

	C block(Consumer<C> invocation);

	@Deprecated
	C checkCast(Type type);

	C code();

	default C def(Field field) {
		return def(field.name, field.type);
	}

	default C def(String fieldName, Class<?> clz) {
		return def(fieldName, typeOf(clz));
	}

	default C def(String fieldName, Class<?> clz, Class<?>... signatureClasses) {
		return def(fieldName, typeOf(clz), typeOf(signatureClasses));
	}

	default C def(String fieldName, Class<?> clz, String signature) {
		return def(fieldName, typeOf(clz), signature);
	}

	default C def(String fieldName, Class<?> clz, Type... signatureTypes) {
		return def(fieldName, typeOf(clz), signatureTypes);
	}

	default C def(String fieldName, Type fieldType, boolean array) {
		return def(fieldName, arrayOf(fieldType, array));
	}

	C def(String fieldName, Type fieldType, String signature);

	default C def(String fieldName, Type fieldType, Type... signatureTypes) {
		String signature = null;
		if (signatureTypes != null && signatureTypes.length > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("L");
			sb.append(fieldType.getInternalName());
			sb.append("<");
			for (Type signatureType : signatureTypes) {
				sb.append(signatureType.getDescriptor());
			}
			sb.append(">;");
			signature = sb.toString();
		}
		return def(fieldName, fieldType, signature);
	}

	@Deprecated
	C deperatedInsn(int d);

	@Deprecated
	M depetatedUse(String... varNames);

	void end();

	@Deprecated
	C intInsn(int bipush, int i);

	@Deprecated
	C jumpInsn(int ifgt, Label label);

	@Deprecated
	void ldcInsn(Object cst);

	C line(int line);

	@Deprecated
	void load(String... varNames);

	@Deprecated
	Instance<M, C> loadObject(String variableName);

	@Deprecated
	default Instance<M, C> newInstace(Class<?> clz) {
		return newInstace(typeOf(clz));
	}

	@Deprecated
	Instance<M, C> newInstace(Type type);

	Label newLabel();

	@Deprecated
	void opcodeDup();

	@Deprecated
	void opcodePop();

	@Deprecated
	C putTopTo(Field field);

	@Deprecated
	void returnObject();

	@Deprecated
	default void returnTop(Class<?> returnClass) {
		returnTop(typeOf(returnClass));
	}

	@Deprecated
	void returnTop(Type type);

	@Deprecated
	void returnVoid();

	@Deprecated
	C storeStackTopTo(String varName);

	@Deprecated
	Type thisType();

	@Deprecated
	default Instance<M, C> type(Class<?> objectClass) {
		return type(typeOf(objectClass));
	}

	@Deprecated
	Instance<M, C> type(Type objectType);

	@Deprecated
	default void typeInsn(int opcode, Class<?> clz) {
		typeInsn(opcode, typeOf(clz));
	}

	@Deprecated
	void typeInsn(int opcode, Type type);

	@Deprecated
	default Instance<M, C> typeThis() {
		return type(thisType());
	};

	@Deprecated
	default M use(Function<C, ToType> func) {
		ToType toType = func.apply(code());
		return useStackTop(toType.getStackTopType());
	}

	@Deprecated
	M useStackTop(Type type);
}