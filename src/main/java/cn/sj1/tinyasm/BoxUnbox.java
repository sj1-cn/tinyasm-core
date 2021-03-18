package cn.sj1.tinyasm;

import static cn.sj1.tinyasm.TypeUtils.typeOf;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.objectweb.asm.Type;

public class BoxUnbox {

	public static Map<Type, Consumer<MethodCode>> PrimaryToBoxFunc = new HashMap<>();
	public static Map<Type, Consumer<MethodCode>> ClassObjectToUnboxFunc = new HashMap<>();
	public static Map<Type, Type> PrimativeToClazzObject = new HashMap<>();
	public static Map<Type, Type> ClazzObjectToPrimitive = new HashMap<>();
	public static Consumer<MethodCode> doNothing = f -> {
	};

	private static void register(Class<?> objectClazz, Class<?> primaryClazz, Consumer<MethodCode> convert, Consumer<MethodCode> revert) {
		ClazzObjectToPrimitive.put(typeOf(objectClazz), typeOf(primaryClazz));
		PrimativeToClazzObject.put(typeOf(primaryClazz), typeOf(objectClazz));
		ClassObjectToUnboxFunc.put(typeOf(objectClazz), convert);
		PrimaryToBoxFunc.put(typeOf(primaryClazz), revert);
	}

	static Consumer<MethodCode> box(Type primaryClazz) {
		if (!PrimaryToBoxFunc.containsKey(primaryClazz)) return doNothing;
		return PrimaryToBoxFunc.get(primaryClazz);
	}

	static Consumer<MethodCode> unbox(Type primaryClazz) {
		if (!ClassObjectToUnboxFunc.containsKey(primaryClazz)) return doNothing;
		return ClassObjectToUnboxFunc.get(primaryClazz);
	}

	static Consumer<MethodCode> checkcastAndUnbox(final Type objectClazz) {
		final Type primaryClazz = ClazzObjectToPrimitive.get(objectClazz);
		if (primaryClazz != null) {
			return m -> {
				m.CHECKCAST(objectClazz);
				ClassObjectToUnboxFunc.get(objectClazz).accept(m);
			};
		} else {
			return m -> {
				if (objectClazz.getSort() == Type.OBJECT) m.CHECKCAST(objectClazz);
			};
		}
	}

	public static Consumer<MethodCode> unboxToWhenNeed(final Class<?> primaryClazz) {
		return unboxToWhenNeed(typeOf(primaryClazz));
	}
	public static Consumer<MethodCode> unboxToWhenNeed(final Type primaryClazz) {
		final Type objectClazz = PrimativeToClazzObject.get(primaryClazz);
		if (objectClazz != null) {
			return m -> {
				m.CHECKCAST(objectClazz);
				ClassObjectToUnboxFunc.get(objectClazz).accept(m);
			};
		} else {
			return m -> {
				m.CHECKCAST(primaryClazz);
			};
		}
	}

	static {
		register(Character.class, char.class, mv -> {
			mv.VIRTUAL(Character.class, "charValue").return_(char.class).INVOKE();
		}, mv -> {
			mv.STATIC(Character.class, "valueOf").parameter(char.class).return_(Character.class).INVOKE();
		});

		register(Boolean.class, boolean.class, mv -> {
			mv.VIRTUAL(Boolean.class, "booleanValue").return_(boolean.class).INVOKE();
		}, mv -> {
			mv.STATIC(Boolean.class, "valueOf").parameter(boolean.class).return_(Boolean.class).INVOKE();
		});

		register(Byte.class, byte.class, mv -> {
			mv.VIRTUAL(Byte.class, "byteValue").return_(byte.class).INVOKE();
		}, mv -> {
			mv.STATIC(Byte.class, "valueOf").parameter(byte.class).return_(Byte.class).INVOKE();
		});

		register(Short.class, short.class, mv -> {
			mv.VIRTUAL(Short.class, "shortValue").return_(short.class).INVOKE();
		}, mv -> {
			mv.STATIC(Short.class, "valueOf").parameter(short.class).return_(Short.class).INVOKE();
		});

		register(Integer.class, int.class, mv -> {
			mv.VIRTUAL(Integer.class, "intValue").return_(int.class).INVOKE();
		}, mv -> {
			mv.STATIC(Integer.class, "valueOf").parameter(int.class).return_(Integer.class).INVOKE();
		});

		register(Long.class, long.class, mv -> {
			mv.VIRTUAL(Long.class, "longValue").return_(long.class).INVOKE();
		}, mv -> {
			mv.STATIC(Long.class, "valueOf").parameter(long.class).return_(Long.class).INVOKE();
		});

		register(Float.class, float.class, mv -> {
			mv.VIRTUAL(Float.class, "floatValue").return_(float.class).INVOKE();
		}, mv -> {
			mv.STATIC(Float.class, "valueOf").parameter(float.class).return_(Float.class).INVOKE();
		});

		register(Double.class, double.class, mv -> {
			mv.VIRTUAL(Double.class, "doubleValue").return_(double.class).INVOKE();
		}, mv -> {
			mv.STATIC(Double.class, "valueOf").parameter(double.class).return_(Double.class).INVOKE();
		});

	}

}
