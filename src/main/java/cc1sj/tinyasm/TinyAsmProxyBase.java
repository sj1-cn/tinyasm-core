package cc1sj.tinyasm;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.Type;

public interface TinyAsmProxyBase {

	static Map<Type, Type> primativeToBoxedClazzMaps = asMap(
			new Type[] { Type.BOOLEAN_TYPE/* Boolean.class */, Type.BYTE_TYPE/* Byte.class */, Type.CHAR_TYPE/* Character.class */,
					Type.SHORT_TYPE/* Short.class */, Type.INT_TYPE/* Integer.class */, Type.LONG_TYPE/* Long.class */,
					Type.FLOAT_TYPE/* Float.class */, Type.DOUBLE_TYPE/* Double.class */
			},
			new Type[] { /* boolean.class */Type.getType(Boolean.class), /* byte.class */Type.getType(Byte.class),
					/* char.class */Type.getType(Character.class), /* short.class */Type.getType(Short.class),
					/* int.class */Type.getType(Integer.class), /* long.class */Type.getType(Long.class),
					/* float.class */Type.getType(Float.class), /* double.class */Type.getType(Double.class) });
	static Map<Type, String> primativeToValueMaps = asMap(new Type[] { Type.BOOLEAN_TYPE/* Boolean.class */, Type.BYTE_TYPE/* Byte.class */,
			Type.CHAR_TYPE/* Character.class */, Type.SHORT_TYPE/* Short.class */, Type.INT_TYPE/* Integer.class */,
			Type.LONG_TYPE/* Long.class */, Type.FLOAT_TYPE/* Float.class */, Type.DOUBLE_TYPE/* Double.class */
	}, new String[] { /* boolean.class" */"booleanValue", /* byte.class */ "byteValue", /* char.class */ "charValue",
			/* short.class */ "shortValue", /* int.class */ "intValue", /* long.class */ "longValue", /* float.class */ "floatValue",
			/* double.class */ "doubleValue"

	});

	static <K, V> Map<K, V> asMap(K[] keys, V[] values) {
		Map<K, V> maps = new HashMap<>();
		for (int i = 0; i < keys.length; i++) {
			maps.put(keys[i], values[i]);
		}
		return maps;
	}

	static void _cast(Clazz returnType, MethodCode code) {
		Clazz returnClazz = Clazz.of(returnType);
		final boolean returnValueNeedBoxing = primativeToBoxedClazzMaps.containsKey(returnType.getType());
		Type returnValueboxedClazz = returnValueNeedBoxing ? primativeToBoxedClazzMaps.get(returnType.getType()) : null;
		String returnValueUnboxValueMethodName = returnValueNeedBoxing ? primativeToValueMaps.get(returnType.getType()) : null;
		if (returnValueNeedBoxing) {
			code.CHECKCAST(returnValueboxedClazz);
			code.VIRTUAL(Clazz.of(returnValueboxedClazz), returnValueUnboxValueMethodName).reTurn(returnClazz).INVOKE();
		} else {
			code.CHECKCAST(returnClazz);
		}
	}

	static void _parameter(MethodCode code) {
		code.INTERFACE(MethodCaller.class, "parameter").reTurn(MethodCaller.class).parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();
	}

	static void _virtual(MethodCode code, Type targetType, String methodName) {
		code.LOADConst(targetType);
		code.LOADConst(methodName);
		code.VIRTUAL(MethodCode.class, "VIRTUAL").reTurn(MethodCaller.class).parameter(Class.class).parameter(String.class).INVOKE();
	}

	static void _interface(MethodCode code, Type targetType, String methodName) {
		code.LOADConst(targetType);
		code.LOADConst(methodName);
		code.VIRTUAL(MethodCode.class, "INTERFACE").reTurn(MethodCaller.class).parameter(Class.class).parameter(String.class).INVOKE();
	}
	
	static void _return(MethodCode code) {
		code.INTERFACE(MethodCaller.class, "reTurn").reTurn(MethodCaller.class).parameter(Class.class).INVOKE();
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();
	}

	static void _type(MethodCode code, Clazz returnClass) {
		final boolean returnValueNeedBoxing = primativeToBoxedClazzMaps.containsKey(returnClass.getType());
		Type returnValueboxedClazz = returnValueNeedBoxing ? primativeToBoxedClazzMaps.get(returnClass.getType()) : null;
		if (returnValueNeedBoxing) code.GETSTATIC(returnValueboxedClazz, "TYPE", Type.getType(Class.class));
		else code.LOADConst(returnClass.getType());
	}

	static void _code(MethodCode code) {
		code.LINE(61);
		code.LOAD("this");
		code.GETFIELD("_code", MethodCode.class);
	}

	static void _resolveParameter(MethodCode code, String param1, Clazz paramsClass) {
		code.LINE(184);
		code.LOAD("this");
		code.GETFIELD("_code", MethodCode.class);
		code.LOAD(param1);
		code.STATIC(TinyAsmBuilder.class, "resolve").parameter(MethodCode.class).parameter(paramsClass).INVOKE();
	}

	static void _resolveThis(MethodCode code) {
		code.LINE(183);
		code.LOAD("this");
		code.GETFIELD("_code", MethodCode.class);
		code.LOAD("this");
		code.GETFIELD("_referName", String.class);
		code.STATIC(TinyAsmBuilder.class, "resolve").parameter(MethodCode.class).parameter(String.class).INVOKE();
	}

	static void _line(MethodCode code) {
		code.LINE(182);
		code.LOAD("this");
		code.GETFIELD("_code", MethodCode.class);
		code.VIRTUAL(MethodCode.class, "LINE").INVOKE();
	}

	static void get___ReferName(ClassBody classWriter) {
		classWriter.method(String.class, "get___ReferName").code(code -> {

			code.LINE(38);
			code.LOAD("this");
			code.GETFIELD("_referName", String.class);
			code.RETURNTop();
		});
	}

	static void _return(MethodCode code, Clazz returnClass) {
		_type(code, returnClass);
		code.INTERFACE(MethodCaller.class, "reTurn").reTurn(MethodCaller.class).parameter(Class.class).INVOKE();
	}

	static void _parameter(MethodCode code, Clazz paramsClass) {
		_type(code, paramsClass);
		code.INTERFACE(MethodCaller.class, "parameter").reTurn(MethodCaller.class).parameter(Class.class).INVOKE();
	}

	static void _storeTopAndRefer(MethodCode code, Clazz returnClass) {
		_code(code);
		_type(code, returnClass);
		code.STATIC(TinyAsmBuilder.class, "storeTopAndRefer").reTurn(Object.class).parameter(MethodCode.class).parameter(Class.class).INVOKE();
		_cast(returnClass, code);
	}

	static void _invoke(MethodCode code) {
		code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();
	}

}
