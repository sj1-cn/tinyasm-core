package nebula.tinyasm;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import nebula.tinyasm.data.MethodCode;

public class BoxUnbox {

	static Map<String, Consumer<MethodCode>> box = new HashMap<>();
	static Map<String, Consumer<MethodCode>> unbox = new HashMap<>();
	static Consumer<MethodCode> doNothing = f -> {
	};

	static void register(Class<?> objectClazz, Class<?> primaryClazz, Consumer<MethodCode> convert, Consumer<MethodCode> revert) {
		unbox.put(objectClazz.getName(), convert);
		box.put(primaryClazz.getName(), revert);
	}

	static Consumer<MethodCode> box(String primaryClazz) {
		if (!box.containsKey(primaryClazz)) return doNothing;
		return box.get(primaryClazz);
	}

	static Consumer<MethodCode> unbox(String primaryClazz) {
		if (!unbox.containsKey(primaryClazz)) return doNothing;
		return unbox.get(primaryClazz);
	}

	static {
		register(Character.class, char.class, mv -> {
			mv.VIRTUAL(Character.class, "charValue").reTurn(char.class).INVOKE();
		}, mv -> {
			mv.STATIC(Character.class, "valueOf").parameter(char.class).reTurn(Character.class).INVOKE();
		});

		register(Boolean.class, boolean.class, mv -> {
			mv.VIRTUAL(Boolean.class, "booleanValue").reTurn(boolean.class).INVOKE();
		}, mv -> {
			mv.STATIC(Boolean.class, "valueOf").parameter(boolean.class).reTurn(Boolean.class).INVOKE();
		});

		register(Byte.class, byte.class, mv -> {
			mv.VIRTUAL(Byte.class, "byteValue").reTurn(byte.class).INVOKE();
		}, mv -> {
			mv.STATIC(Byte.class, "valueOf").parameter(byte.class).reTurn(Byte.class).INVOKE();
		});

		register(Short.class, short.class, mv -> {
			mv.VIRTUAL(Short.class, "shortValue").reTurn(short.class).INVOKE();
		}, mv -> {
			mv.STATIC(Short.class, "valueOf").parameter(short.class).reTurn(Short.class).INVOKE();
		});

		register(Integer.class, int.class, mv -> {
			mv.VIRTUAL(Integer.class, "intValue").reTurn(int.class).INVOKE();
		}, mv -> {
			mv.STATIC(Integer.class, "valueOf").parameter(int.class).reTurn(Integer.class).INVOKE();
		});

		register(Long.class, long.class, mv -> {
			mv.VIRTUAL(Long.class, "longValue").reTurn(long.class).INVOKE();
		}, mv -> {
			mv.STATIC(Long.class, "valueOf").parameter(long.class).reTurn(Long.class).INVOKE();
		});

		register(Float.class, float.class, mv -> {
			mv.VIRTUAL(Float.class, "floatValue").reTurn(float.class).INVOKE();
		}, mv -> {
			mv.STATIC(Float.class, "valueOf").parameter(float.class).reTurn(Float.class).INVOKE();
		});

		register(Double.class, double.class, mv -> {
			mv.VIRTUAL(Double.class, "doubleValue").reTurn(double.class).INVOKE();
		}, mv -> {
			mv.STATIC(Double.class, "valueOf").parameter(double.class).reTurn(Double.class).INVOKE();
		});

	}

}
