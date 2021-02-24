package cc1sj.tinyasm.hero;

import java.util.Stack;
import java.util.function.Consumer;

import cc1sj.tinyasm.MethodCode;

public class HeroASMBuilder {
//	<T> T ctor(Class<T> clz) {
//		return null;
//	}

	public static String __TOP__ = "__TOP__";
	public static String __THIS__ = "__THIS__";

//	static Stack<Consumer<MethodCode>> codes = new Stack<Consumer<MethodCode>>();
//	static Map<String, Consumer<MethodCode>> codeBlocks = new HashMap<>();
//	static Stack<String> stack = new Stack<>();
	static MethodCode _code;
//	static Context context = new Context(code);

	public static int MAGIC_VALUE = 3412;
	public static final String MAGICSTRING = "#MAGIC#";
	public static final byte MAGIC_byte = 107;
	public static final char MAGIC_char = '%';
	public static final short MAGIC_short = Short.MAX_VALUE - 107;
	public static final int MAGIC_int = Integer.MAX_VALUE - 107;
	public static final long MAGIC_long = Long.MAX_VALUE - 107;
	public static final float MAGIC_float = Float.MAX_VALUE - 107;
	public static final double MAGIC_double = Double.MAX_VALUE - 107;
	public static int locals = 0;

	static public void attach(MethodCode code) {
		locals = 0;
		HeroASMBuilder._code = code;
	}

	static int add(int l, int r) {
		_code.LINE();
		resolve(_code, l);
		resolve(_code, r);
		_code.ADD();
		return refer(_code, int.class);
	}

	static short add(short l, short r) {
		_code.LINE();
		resolve(_code, l);
		resolve(_code, r);
		_code.ADD();
		_code.CONVERTTO(short.class);
		return refer(_code, short.class);
	}

	static Hello ctor(Class<Hello> helloclass) {
		locals++;
		String key = String.valueOf(MAGICSTRING + locals);
		_code.LINE();
		_code.NEW(helloclass);
		_code.DUP();
		_code.SPECIAL(helloclass, "<init>").INVOKE();
//		String key = refer(code, null)
		_code.STORE(key, helloclass);
		return new HelloInner(_code, key);
	}

//	static <T> T refer(Class<T> clazz) {
//		if (clazz == Hello.class) {
//			try {
//				HelloInnerTinyAsmDump.dump(Type.getType("Lcc1sj/tinyasm/hero/Hello;"));
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw new UnsupportedOperationException();
//			}
//		}
//		return null;
//	}

	@SuppressWarnings("unchecked")
	public static <T> T refer(Stack<Consumer<MethodCode>> __codes2, Class<T> t) {
		locals++;
		String strKey = String.valueOf(MAGICSTRING + locals);
		__codes2.add(code -> code.STORE(strKey, t));

		if (t == String.class) {
			String key = String.valueOf(MAGICSTRING + locals);
			return (T) key;
		} else if (t == boolean.class) {
			throw new UnsupportedOperationException();
		} else if (t == Byte.class) {
			Byte key = (byte) (MAGIC_byte + locals);
			return (T) key;
		} else if (t == Character.class) {
			Character key = (char) (MAGIC_char + locals);
			return (T) key;
		} else if (t == Short.class || t == short.class) {
			Short key = (short) (MAGIC_short + locals);
			return (T) key;
		} else if (t == Integer.class) {
			Integer key = (int) (MAGIC_int + locals);
			return (T) key;
		} else if (t == Long.class) {
			Long key = (long) (MAGIC_long + locals);
			return (T) key;
		} else if (t == Float.class) {
			Float key = (float) (MAGIC_float + locals);
			return (T) key;
		} else if (t == Double.class) {
			Double key = (double) (MAGIC_double + locals);
			return (T) key;
		}
		if (t == int.class) {

		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T refer(MethodCode code, Class<T> t) {
		locals++;
		String strKey = String.valueOf(MAGICSTRING + locals);
		code.STORE(strKey, t);

		if (t == String.class) {
			String key = String.valueOf(MAGICSTRING + locals);
			return (T) key;
		} else if (t == boolean.class) {
			throw new UnsupportedOperationException();
		} else if (t == Byte.class) {
			Byte key = (byte) (MAGIC_byte + locals);
			return (T) key;
		} else if (t == Character.class) {
			Character key = (char) (MAGIC_char + locals);
			return (T) key;
		} else if (t == Short.class || t == short.class) {
			Short key = (short) (MAGIC_short + locals);
			return (T) key;
		} else if (t == Integer.class) {
			Integer key = (int) (MAGIC_int + locals);
			return (T) key;
		} else if (t == Long.class) {
			Long key = (long) (MAGIC_long + locals);
			return (T) key;
		} else if (t == Float.class) {
			Float key = (float) (MAGIC_float + locals);
			return (T) key;
		} else if (t == Double.class) {
			Double key = (double) (MAGIC_double + locals);
			return (T) key;
		}
		if (t == int.class) {

		}

		return null;
	}
//	static String cst(String cst) {
//		locals++;
//		String key = String.valueOf(MAGICSTRING + locals);
//		return key;
//	}

//
//	static String var(Class<String> strClass) {
//		locals++;
//		String key = String.valueOf(MAGICSTRING + locals);
//		return key;
//	}
//	
//	static int var(Class<Integer> strClass) {
//		locals++;
//		String key = String.valueOf(MAGICSTRING + locals);
//		return key;
//	}
//	

//	static void applyTo(MethodCode code) {
//		for (Consumer<MethodCode> consumer : codes) {
//			consumer.accept(code);
//		}
//	}
//
//	static void set(String name, String o) {
//		codes.add(wi(resolve(o), code -> code.STORE(name)));
//	}
//
//	@SafeVarargs
//	static Consumer<MethodCode> wi(Consumer<MethodCode>... codes) {
//		return code -> {
//			for (Consumer<MethodCode> consumer : codes) {
//				consumer.accept(code);
//			}
//		};
//	}
//
//	static Consumer<MethodCode> resolve(String name) {
//		if (name.startsWith(MAGICSTRING)) {
//			return code -> code.LOAD(name);
//		} else {
//			return code -> code.LOADConst(name);
//		}
//	}
//
//	static Consumer<MethodCode> resolve(byte magicIndex) {
//		if (magicIndex >= MAGIC_byte) {
//			return code -> code.LOAD(magicIndex - MAGIC_byte);
//		} else {
//			return code -> code.LOADConst(magicIndex);
//		}
//	}
//
//	static Consumer<MethodCode> resolve(short magicIndex) {
//		if (magicIndex >= MAGIC_short) {
//			return code -> code.LOAD(magicIndex - MAGIC_short);
//		} else {
//			return code -> code.LOADConst(magicIndex);
//		}
//	}
//
//	static Consumer<MethodCode> resolve(int magicIndex) {
//		if (magicIndex >= MAGIC_int) {
//			return code -> code.LOAD(magicIndex - MAGIC_int);
//		} else {
//			return code -> code.LOADConst(magicIndex);
//		}
//	}
//
//	static Consumer<MethodCode> resolve(long magicIndex) {
//		if (magicIndex >= MAGIC_long) {
//			return code -> code.LOAD((int) (magicIndex - MAGIC_long));
//		} else {
//			return code -> code.LOADConst(magicIndex);
//		}
//	}
//
//	static Consumer<MethodCode> resolve(float magicIndex) {
//		if (magicIndex >= MAGIC_float) {
//			return code -> code.LOAD((int) (magicIndex - MAGIC_float));
//		} else {
//			return code -> code.LOADConst(magicIndex);
//		}
//	}
//
//	static Consumer<MethodCode> resolve(double magicIndex) {
//		if (magicIndex >= MAGIC_double) {
//			return code -> code.LOAD((int) (magicIndex - MAGIC_double));
//		} else {
//			return code -> code.LOADConst(magicIndex);
//		}
//	}

	static void resolve(MethodCode code, byte magicIndex) {
		if (magicIndex >= MAGIC_byte) {
			code.LOAD(MAGICSTRING + (magicIndex - MAGIC_byte));
		} else {
			code.LOADConst(magicIndex);
		}
	}

	static void resolve(MethodCode code, char magicIndex) {
		if (magicIndex >= MAGIC_char) {
			code.LOAD(MAGICSTRING + (magicIndex - MAGIC_char));
		} else {
			code.LOADConst(magicIndex);
		}
	}

	static void resolve(MethodCode code, short magicIndex) {
		if (magicIndex >= MAGIC_short) {
			code.LOAD(MAGICSTRING + (magicIndex - MAGIC_short));
		} else {
			code.LOADConst(magicIndex);
		}
	}

	static void resolve(MethodCode code, int magicIndex) {
		if (magicIndex >= MAGIC_int) {
			code.LOAD(MAGICSTRING + (magicIndex - MAGIC_int));
		} else {
			code.LOADConst(magicIndex);
		}
	}

	static void resolve(MethodCode code, long magicIndex) {
		if (magicIndex >= MAGIC_long) {
			code.LOAD(MAGICSTRING + ((int) (magicIndex - MAGIC_long)));
		} else {
			code.LOADConst(magicIndex);
		}
	}

	static void resolve(MethodCode code, float magicIndex) {
		if (magicIndex >= MAGIC_float) {
			code.LOAD(MAGICSTRING + ((int) (magicIndex - MAGIC_float)));
		} else {
			code.LOADConst(magicIndex);
		}
	}

	static void resolve(MethodCode code, double magicIndex) {
		if (magicIndex >= MAGIC_double) {
			code.LOAD(MAGICSTRING + ((int) (magicIndex - MAGIC_double)));
		} else {
			code.LOADConst(magicIndex);
		}
	}

	static void resolve(MethodCode code, Character magicIndex) {
		if (magicIndex >= MAGIC_byte) {
			code.LOAD(MAGICSTRING + (magicIndex - MAGIC_byte));
		} else {
			code.LOADConst(magicIndex);
			code.STATIC(Character.class, "valueOf").reTurn(Character.class).parameter(char.class).INVOKE();
		}
	}

	static void resolve(MethodCode code, Byte magicIndex) {
		if (magicIndex >= MAGIC_byte) {
			code.LOAD(MAGICSTRING + (magicIndex - MAGIC_byte));
		} else {
			code.LOADConst((byte) magicIndex);
			code.STATIC(Byte.class, "valueOf").reTurn(Byte.class).parameter(byte.class).INVOKE();
		}
	}

	static void resolve(MethodCode code, Short magicIndex) {
		if (magicIndex >= MAGIC_short) {
			code.LOAD(MAGICSTRING + (magicIndex - MAGIC_short));
		} else {
			code.LOADConst((short) magicIndex);
			code.STATIC(Short.class, "valueOf").reTurn(Short.class).parameter(short.class).INVOKE();
		}
	}

	static void resolve(MethodCode code, Integer magicIndex) {
		if (magicIndex >= MAGIC_int) {
			code.LOAD(MAGICSTRING + (magicIndex - MAGIC_int));
		} else {
			code.LOADConst((int) magicIndex);
			code.STATIC(Integer.class, "valueOf").reTurn(Integer.class).parameter(int.class).INVOKE();
		}
	}

	static void resolve(MethodCode code, Long magicIndex) {
		if (magicIndex >= MAGIC_long) {
			code.LOAD(MAGICSTRING + ((int) (magicIndex - MAGIC_long)));
		} else {
			code.LOADConst((long) magicIndex);
			code.STATIC(Long.class, "valueOf").reTurn(Long.class).parameter(long.class).INVOKE();
		}
	}

	static void resolve(MethodCode code, Float magicIndex) {
		if (magicIndex >= MAGIC_float) {
			code.LOAD(MAGICSTRING + ((int) (magicIndex - MAGIC_float)));
		} else {
			code.LOADConst((float) magicIndex);
			code.STATIC(Float.class, "valueOf").reTurn(Float.class).parameter(float.class).INVOKE();
		}
	}

	static void resolve(MethodCode code, Double magicIndex) {
		if (magicIndex >= MAGIC_double) {
			code.LOAD(MAGICSTRING + ((int) (magicIndex - MAGIC_double)));
		} else {
			code.LOADConst((double) magicIndex);
			code.STATIC(Double.class, "valueOf").reTurn(Double.class).parameter(double.class).INVOKE();
		}
	}

	static void resolve(MethodCode code, String name) {
		if (name.startsWith(MAGICSTRING)) {
			code.LOAD(name);
		} else {
			code.LOADConst(name);
		}
	}
}
