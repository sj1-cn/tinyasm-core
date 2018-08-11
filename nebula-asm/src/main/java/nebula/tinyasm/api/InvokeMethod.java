package nebula.tinyasm.api;

import static nebula.tinyasm.api.TypeUtils.arrayOf;
import static nebula.tinyasm.api.TypeUtils.toPropertyGetName;
import static nebula.tinyasm.api.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

import java.util.List;

import org.objectweb.asm.Type;

public interface InvokeMethod<M, C extends MethodCode<M, C>> extends ToType {

	C code();

	default Instance<M, C> get(Field field) {
		return get(field.name, field.type);
	}

	default Instance<M, C> get(String fieldName, Class<?> fieldClass) {
		return get(new Field(fieldName, typeOf(fieldClass)));
	}

	Instance<M, C> get(String fieldName, Type fieldType);

	default Instance<M, C> get(String fieldName, Type fieldType, boolean array) {
		return get(fieldName, arrayOf(fieldType, array));
	}

	default Instance<M, C> getProperty(String fieldName, Type fieldType) {
		return invoke(INVOKEVIRTUAL, fieldType, toPropertyGetName(fieldName, fieldType));
	}

	default Instance<M, C> getStatic(Field field) {
		return getStatic(field.name, field.type);
	}

	default Instance<M, C> getStatic(String fieldName, Class<?> fieldClass) {
		return getStatic(new Field(fieldName, typeOf(fieldClass)));
	}

	Instance<M, C> getStatic(String fieldName, Type fieldType);

	default Instance<M, C> getStatic(String fieldName, Type fieldType, boolean array) {
		return getStatic(fieldName, arrayOf(fieldType, array));
	}

	default void invoke(Class<?> returnClass, String methodName, Class<?>... paramClasses) {
		invoke(INVOKEVIRTUAL, typeOf(returnClass), methodName, typeOf(paramClasses));
	}

	default void invoke(int invoketype, String methodName, Type... params) {
		invoke(invoketype, Type.VOID_TYPE, methodName, params);
	}

	default Instance<M, C> invoke(int invoketype, Type returnType, String methodName, Type... params) {
		invoke(getStackTopType(), invoketype, returnType, methodName, params);
		return topInstance();
	}

	default void invoke(Type objectType, int invoketype, String methodName, Type... params) {
		invoke(objectType, invoketype, Type.VOID_TYPE, methodName, params);
	}

	void invoke(Type objectType, int invoketype, Type returnType, String methodName, Type... params);

	default Instance<M, C> invokeInterface(Class<?> returnClass, String methodName, Class<?>... paramClasses) {
		return invoke(INVOKEINTERFACE, typeOf(returnClass), methodName, typeOf(paramClasses));
	}

	default Instance<M, C> invokeInterface(Class<?> returnClass, String methodName, Type... params) {
		return invoke(INVOKEINTERFACE, typeOf(returnClass), methodName, params);
	}

	default void invokeInterface(String methodName, Class<?>... paramClasses) {
		invoke(INVOKEINTERFACE, methodName, typeOf(paramClasses));
	}

	default void invokeInterface(String methodName, Type... params) {
		invoke(INVOKEINTERFACE, methodName, params);
	}

	default Instance<M, C> invokeInterface(Type returnType, String methodName, Class<?>... paramClasses) {
		return invoke(INVOKEINTERFACE, returnType, methodName, typeOf(paramClasses));
	}

	default Instance<M, C> invokeInterface(Type returnType, String methodName, Type... params) {
		return invoke(INVOKEINTERFACE, returnType, methodName, params);
	}

	default Instance<M, C> invokeSpecial(Class<?> returnClass, String methodName, Class<?>... paramClasses) {
		return invoke(INVOKESPECIAL, typeOf(returnClass), methodName, typeOf(paramClasses));
	}

	default void invokeSpecial(String methodName, Class<?>... paramClasses) {
		invoke(INVOKESPECIAL, methodName, typeOf(paramClasses));
	}

	default void invokeSpecial(String methodName, Field... paramFields) {
		invoke(INVOKESPECIAL, methodName, typeOf(paramFields));
	}

	default void invokeSpecial(String methodName, List<Field> paramFields) {
		invoke(INVOKESPECIAL, methodName, typeOf(paramFields));
	}

	default void invokeSpecial(String methodName, Type... params) {
		invoke(INVOKESPECIAL, methodName, params);
	}

	default Instance<M, C> invokeSpecial(Type returnType, String methodName, Class<?>... paramClasses) {
		return invoke(INVOKESPECIAL, returnType, methodName, typeOf(paramClasses));
	}

	default Instance<M, C> invokeSpecial(Type returnType, String methodName, Type... params) {
		return invoke(INVOKESPECIAL, returnType, methodName, params);
	}

	default Instance<M, C> invokeStatic(Class<?> returnClass, String methodName) {
		return invoke(INVOKESTATIC, typeOf(returnClass), methodName);
	}

	default Instance<M, C> invokeStatic(Class<?> returnClass, String methodName, Class<?>... paramClasses) {
		return invoke(INVOKESTATIC, typeOf(returnClass), methodName, typeOf(paramClasses));
	}

	default Instance<M, C> invokeStatic(Class<?> returnClass, String methodName, Type... params) {
		return invoke(INVOKESTATIC, typeOf(returnClass), methodName, params);
	}

	default void invokeStatic(String methodName, Class<?>... paramClasses) {
		invoke(INVOKESTATIC, methodName, typeOf(paramClasses));
	}

	default void invokeStatic(String methodName, Field... paramFields) {
		invoke(INVOKESTATIC, methodName, typeOf(paramFields));
	}

	default void invokeStatic(String methodName, List<Field> paramFields) {
		invoke(INVOKESTATIC, methodName, typeOf(paramFields));
	}

	default void invokeStatic(String methodName, Type... params) {
		invoke(INVOKESTATIC, methodName, params);
	}

	default Instance<M, C> invokeStatic(Type returnType, String methodName) {
		return invoke(INVOKESTATIC, returnType, methodName);
	}

	default Instance<M, C> invokeStatic(Type returnType, String methodName, Class<?>... paramClasses) {
		return invoke(INVOKESTATIC, returnType, methodName, typeOf(paramClasses));
	}

	default Instance<M, C> invokeStatic(Type returnType, String methodName, Field... paramFields) {
		return invoke(INVOKESTATIC, returnType, methodName, typeOf(paramFields));
	}

	default Instance<M, C> invokeStatic(Type returnType, String methodName, Type... params) {
		return invoke(INVOKESTATIC, returnType, methodName, params);
	}

	default Instance<M, C> invokeVirtual(Class<?> returnClass, String methodName) {
		return invoke(INVOKEVIRTUAL, typeOf(returnClass), methodName);
	}

	default Instance<M, C> invokeVirtual(Class<?> returnClass, String methodName, Class<?>... paramClasses) {
		return invoke(INVOKEVIRTUAL, typeOf(returnClass), methodName, typeOf(paramClasses));
	}

	default Instance<M, C> invokeVirtual(Class<?> returnClass, String methodName, Type... params) {
		return invoke(INVOKEVIRTUAL, typeOf(returnClass), methodName, params);
	}

	default void invokeVirtual(String methodName, Class<?>... paramClasses) {
		invoke(INVOKEVIRTUAL, methodName, typeOf(paramClasses));
	}

	default void invokeVirtual(String methodName, Field... paramFields) {
		invoke(INVOKEVIRTUAL, methodName, typeOf(paramFields));
	}

	default void invokeVirtual(String methodName, List<Field> paramFields) {
		invoke(INVOKEVIRTUAL, methodName, typeOf(paramFields));
	}

	default void invokeVirtual(String methodName, Type... params) {
		invoke(INVOKEVIRTUAL, methodName, params);
	}

	default Instance<M, C> invokeVirtual(Type returnType, String methodName) {
		return invoke(INVOKEVIRTUAL, returnType, methodName);
	}

	default Instance<M, C> invokeVirtual(Type returnType, String methodName, Class<?>... paramClasses) {
		return invoke(INVOKEVIRTUAL, returnType, methodName, typeOf(paramClasses));
	}

	default Instance<M, C> invokeVirtual(Type returnType, String methodName, Field... paramFields) {
		return invoke(INVOKEVIRTUAL, returnType, methodName, typeOf(paramFields));
	}

	default Instance<M, C> invokeVirtual(Type returnType, String methodName, Type... params) {
		return invoke(INVOKEVIRTUAL, returnType, methodName, params);
	}

	default C putStaticTo(Field field) {
		return putStaticTo(field.name, field.type);
	}

	default C putStaticTo(String fieldName, Class<?> fieldClass) {
		return putStaticTo(new Field(fieldName, typeOf(fieldClass)));
	}

	C putStaticTo(String fieldName, Type fieldType);

	default C putStaticTo(String fieldName, Type fieldType, boolean array) {
		return putStaticTo(fieldName, arrayOf(fieldType, array));
	}

	default C putTo(Field field) {
		return putTo(field.name, field.type);
	}

	default C putTo(String fieldName, Class<?> fieldClass) {
		return putTo(new Field(fieldName, typeOf(fieldClass)));
	}

	C putTo(String fieldName, Type fieldType);

	default C putTo(String fieldName, Type fieldType, boolean array) {
		return putTo(fieldName, arrayOf(fieldType, array));
	}

	default Instance<M, C> topInstance() {
		return code().type(getStackTopType());
	}

}
