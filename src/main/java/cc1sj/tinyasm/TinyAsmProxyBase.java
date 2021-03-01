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

	static void _type(MethodCode code, Clazz returnClass) {
		final boolean returnValueNeedBoxing = primativeToBoxedClazzMaps.containsKey(returnClass.getType());
		Type returnValueboxedClazz = returnValueNeedBoxing ? primativeToBoxedClazzMaps.get(returnClass.getType()) : null;
		if (returnValueNeedBoxing) code.GETSTATIC(returnValueboxedClazz, "TYPE", Type.getType(Class.class));
		else code.LOADConst(returnClass.getType());
	}

	static Map<String, String> mps = asMap(
			new String[] { Boolean.class.getName(), Character.class.getName(), Byte.class.getName(), Short.class.getName(),
					Integer.class.getName(), Long.class.getName(), Float.class.getName(), Double.class.getName(), String.class.getName() },
			new String[] { Boolean.class.getName(), Character.class.getName(), Byte.class.getName(), Short.class.getName(),
					Integer.class.getName(), Long.class.getName(), Float.class.getName(), Double.class.getName(), String.class.getName() });

}
