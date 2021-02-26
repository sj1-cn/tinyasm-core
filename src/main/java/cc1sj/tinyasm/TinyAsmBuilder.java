package cc1sj.tinyasm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TinyAsmBuilder {
//	<T> T ctor(Class<T> clz) {
//		return null;
//	}

	static String __TOP__ = "__TOP__";
	static String __THIS__ = "__THIS__";

//	static public Stack<Consumer<MethodCode>> codes = new Stack<Consumer<MethodCode>>();
//	static public Map<String, Consumer<MethodCode>> codeBlocks = new HashMap<>();
//	static public Stack<String> stack = new Stack<>();
//	static public Context context = new Context(code);

	static private final String MAGICSTRING = "#MAGIC#";
	static private final byte MAGIC_byte = 37;
	static private final char MAGIC_char = '%';
	static private final short MAGIC_short = Short.MAX_VALUE - 107;
	static private final int MAGIC_int = Integer.MAX_VALUE - 107;
	static private final long MAGIC_long = Long.MAX_VALUE - 107;
	static private final float MAGIC_float = Float.MAX_VALUE - 107;
	static private final double MAGIC_double = Double.MAX_VALUE - 107;

	// Need Change to ThreadLocal
	static int _localsLast;
	static Stack<TinyAsmBuilderContext> _contextStack = new Stack<>();
	static private TinyAsmBuilderContext _context;

	static Logger logger = LoggerFactory.getLogger(TinyAsmBuilder.class);

	static void enterCode(MethodCode code) {
//		logger.trace("current code {} enter {} {}", code, code, codes.size());

		TinyAsmBuilderContext context = new TinyAsmBuilderContext(code);
		if (TinyAsmBuilder._context != null) {
			_contextStack.push(_context);
//			localsStack.push(_locals);
		}
//		codes.push(code);
		TinyAsmBuilder._context = context;
//		TinyAsmBuilder._locals = 10;
	}

	static void exitCode() {
		TinyAsmBuilderContext context = _context;
//		MethodCode code = _code;
		if (_contextStack.size() > 0) {
			TinyAsmBuilder._context = _contextStack.pop();
		}
//		logger.trace("exit to {} from {} {}", code, code, codes.size());
	}

	static public int cst(int i) {
		MethodCode code = _context.code;
		code.LINE();
		code.LOADConst(i);
		return refer(_context.code, int.class);
	}

//	static public <T> T getField(T obj, String name, Class<T> clazz) {
//		code.LINE();
//		code.LOAD_THIS();
//		code.GET_THIS_FIELD(name);
//		return refer(clazz);
//	}

	static public <T> T getField(String name, Class<T> clazz) {
		MethodCode code = _context.code;
		code.LINE();
		code.LOAD_THIS();
		code.GET_THIS_FIELD(name);
		return refer(clazz);
	}

	static public <T> T param(String name, Class<T> clazz) {
		MethodCode code = _context.code;
		int locals = code.codeLocalGetLocals(name);
		return refer(_context.code, clazz, locals);
	}

	static public <T> void setField(String name, T value) {
		MethodCode code = _context.code;
		code.LINE();
		code.LOAD_THIS();
		resolve(code, value);
		code.PUTFIELD_OF_THIS(name);
	}

	static public int add(int l, int r) {
		MethodCode code = _context.code;
		code.LINE();
		resolve(code, l);
		resolve(code, r);
		code.ADD();
		return refer(code, int.class);
	}

	static public long add(long l, long r) {
		MethodCode code = _context.code;
		code.LINE();
		resolve(code, l);
		resolve(code, r);
		code.ADD();
		return refer(code, long.class);
	}

	@SuppressWarnings("unchecked")
	static public <T> T add(T l, T r) {
		MethodCode code = _context.code;
		code.LINE();
		resolve(code, l);
		resolve(code, r);
		code.ADD();
		return (T) refer(code, l.getClass());
	}

	static public short add(short l, short r) {
		MethodCode code = _context.code;
		code.LINE();
		resolve(code, l);
		resolve(code, r);
		code.ADD();
		code.CONVERTTO(short.class);
		return refer(code, short.class);
	}

	static final private TinyAsmProxyObjenesisBuilder brokerBuilder = new TinyAsmProxyObjenesisBuilder();

	static public <T> T ctor(Class<T> helloclass) {
		MethodCode code = _context.code;
//		_locals++;
//		String key = String.valueOf(MAGICSTRING + _locals);
		code.LINE();
		code.NEW(helloclass);
		code.DUP();
		code.SPECIAL(helloclass, "<init>").INVOKE();

		int locals = code.define(String.valueOf("V" + (_localsLast + 1)), helloclass);
		code.STORE(locals);
		String strKey = String.valueOf(MAGICSTRING + locals);

		T t = brokerBuilder.builder(helloclass, _context, strKey);
		return t;
	}

	static public <T> T ctor(Class<T> helloclass, Object... params) {
		MethodCode code = _context.code;
		Constructor<?> c = matchConstruct(helloclass, params);
		if (c == null) throw new UnsupportedOperationException();

		code.LINE();
		code.NEW(helloclass);
		code.DUP();

		Class<?>[] paramTypes = c.getParameterTypes();

		for (int i = 0; i < params.length; i++) {
			resolve(code, paramTypes[i], params[i]);
		}

		code.SPECIAL(helloclass, "<init>").parameter(c.getParameterTypes()).INVOKE();

		int locals = code.define(String.valueOf("V" + (_localsLast + 1)), helloclass);
		code.STORE(locals);
		String strKey = String.valueOf(MAGICSTRING + locals);

		T t = brokerBuilder.builder(helloclass, _context, strKey);
		return t;
	}

	protected static Constructor<?> matchConstruct(Class<?> helloclass, Object... params) {
		Constructor<?> c = null;
		for (Constructor<?> init : helloclass.getConstructors()) {
			if (init.getParameterCount() == params.length) {
				boolean matched = true;
				Class<?>[] definedParams = init.getParameterTypes();
				for (int i = 0; i < params.length; i++) {
					if (definedParams[i].getClass() == params[i].getClass()) {

					} else if (match(definedParams[i], params[i].getClass())) {

					} else {
						matched = false;
						break;
					}
				}
				if (matched) c = init;
			}
		}
		return c;
	}

	private static boolean match(Class<?> l, Class<?> r) {
		if (l.isPrimitive()) {
			return (l == byte.class && r == Byte.class) || (l == char.class && r == Character.class)
					|| (l == short.class && r == Short.class) || (l == int.class && r == Integer.class)
					|| (l == long.class && r == Long.class) || (l == float.class && r == Float.class)
					|| (l == double.class && r == Double.class);
		}
		return false;
	}

	public static <T> T refer(Class<T> t) {
		MethodCode code = _context.code;
		return refer(code, t);
	}

	public static <T> T refer(MethodCode code, Class<T> t) {
		int locals = code.define(String.valueOf("V" + (_localsLast + 1)), t);
		code.STORE(locals);
		return refer(code, t, locals);
	}

	@SuppressWarnings("unchecked")
	public static <T> T refer(MethodCode code, Class<T> t, int locals) {

		if (t.isPrimitive()) {
			if (t == boolean.class) {
				return (T) Boolean.valueOf(false);
			} else if (t == byte.class) {
				Byte key = (byte) (MAGIC_byte + locals);
				return (T) key;
			} else if (t == char.class) {
				Character key = (char) (MAGIC_char + locals);
				return (T) key;
			} else if (t == short.class) {
				Short key = (short) (MAGIC_short + locals);
				return (T) key;
			} else if (t == int.class) {
				Integer key = (int) (MAGIC_int + locals);
				return (T) key;
			} else if (t == long.class) {
				Long key = (long) (MAGIC_long + locals);
				return (T) key;
			} else if (t == float.class) {
				Float key = (float) (MAGIC_float + locals);
				return (T) key;
			} else if (t == double.class) {
				Double key = (double) (MAGIC_double + locals);
				return (T) key;
			}
		} else {
			if (t == boolean.class) {
				throw new UnsupportedOperationException();
			} else if (t == Byte.class) {
				Byte key = (byte) (MAGIC_byte + locals);
				return (T) key;
			} else if (t == Character.class) {
				Character key = (char) (MAGIC_char + locals);
				return (T) key;
			} else if (t == Short.class) {
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
			} else if (t == String.class) {
				String key = String.valueOf(MAGICSTRING + locals);
				return (T) key;
			} else if (t.isInterface()) {
				String strKey = String.valueOf(MAGICSTRING + locals);
				T proxy = brokerBuilder.builder(t, _context, strKey);
				return proxy;
			} else if (!Modifier.isFinal(t.getModifiers())) {
				String strKey = String.valueOf(MAGICSTRING + locals);
				T proxy = brokerBuilder.builder(t, _context, strKey);
				return proxy;
			} else {
				return null;
			}

		}

		return null;
	}

	static public void resolve(MethodCode code, byte magicIndex) {
		if (magicIndex >= MAGIC_byte) {
			code.LOAD((magicIndex - MAGIC_byte));
		} else {
			code.LOADConst(magicIndex);
		}
	}

	static public void resolve(MethodCode code, char magicIndex) {
		if (magicIndex >= MAGIC_char) {
			code.LOAD((magicIndex - MAGIC_char));
		} else {
			code.LOADConst(magicIndex);
		}
	}

	static public void resolve(MethodCode code, short magicIndex) {
		if (magicIndex >= MAGIC_short) {
			code.LOAD((magicIndex - MAGIC_short));
		} else {
			code.LOADConst(magicIndex);
		}
	}

	static public void resolve(MethodCode code, int magicIndex) {
		if (magicIndex >= MAGIC_int) {
			code.LOAD((magicIndex - MAGIC_int));
		} else {
			code.LOADConst(magicIndex);
		}
	}

	static public void resolve(MethodCode code, long magicIndex) {
		if (magicIndex >= MAGIC_long) {
			code.LOAD(((int) (magicIndex - MAGIC_long)));
		} else {
			code.LOADConst(magicIndex);
		}
	}

	static public void resolve(MethodCode code, float magicIndex) {
		if (magicIndex >= MAGIC_float) {
			code.LOAD(((int) (magicIndex - MAGIC_float)));
		} else {
			code.LOADConst(magicIndex);
		}
	}

	static public void resolve(MethodCode code, double magicIndex) {
		if (magicIndex >= MAGIC_double) {
			code.LOAD(((int) (magicIndex - MAGIC_double)));
		} else {
			code.LOADConst(magicIndex);
		}
	}

	static public void resolve(MethodCode code, Character magicIndex) {
		if (magicIndex >= MAGIC_byte) {
			code.LOAD((magicIndex - MAGIC_byte));
		} else {
			code.LOADConst(magicIndex);
			code.STATIC(Character.class, "valueOf").reTurn(Character.class).parameter(char.class).INVOKE();
		}
	}

	static public void resolve(MethodCode code, Byte magicIndex) {
		if (magicIndex >= MAGIC_byte) {
			code.LOAD((magicIndex - MAGIC_byte));
		} else {
			code.LOADConst((byte) magicIndex);
			code.STATIC(Byte.class, "valueOf").reTurn(Byte.class).parameter(byte.class).INVOKE();
		}
	}

	static public void resolve(MethodCode code, Short magicIndex) {
		if (magicIndex >= MAGIC_short) {
			code.LOAD((magicIndex - MAGIC_short));
		} else {
			code.LOADConst((short) magicIndex);
			code.STATIC(Short.class, "valueOf").reTurn(Short.class).parameter(short.class).INVOKE();
		}
	}

	static public void resolve(MethodCode code, Integer magicIndex) {
		if (magicIndex >= MAGIC_int) {
			code.LOAD((magicIndex - MAGIC_int));
		} else {
			code.LOADConst((int) magicIndex);
			code.STATIC(Integer.class, "valueOf").reTurn(Integer.class).parameter(int.class).INVOKE();
		}
	}

	static public void resolve(MethodCode code, Long magicIndex) {
		if (magicIndex >= MAGIC_long) {
			code.LOAD(((int) (magicIndex - MAGIC_long)));
		} else {
			code.LOADConst((long) magicIndex);
			code.STATIC(Long.class, "valueOf").reTurn(Long.class).parameter(long.class).INVOKE();
		}
	}

	static public void resolve(MethodCode code, Float magicIndex) {
		if (magicIndex >= MAGIC_float) {
			code.LOAD(((int) (magicIndex - MAGIC_float)));
		} else {
			code.LOADConst((float) magicIndex);
			code.STATIC(Float.class, "valueOf").reTurn(Float.class).parameter(float.class).INVOKE();
		}
	}

	static public void resolve(MethodCode code, Double magicIndex) {
		if (magicIndex >= MAGIC_double) {
			code.LOAD(((int) (magicIndex - MAGIC_double)));
		} else {
			code.LOADConst((double) magicIndex);
			code.STATIC(Double.class, "valueOf").reTurn(Double.class).parameter(double.class).INVOKE();
		}
	}

	static public void resolve(MethodCode code, String name) {
		if (name.startsWith(MAGICSTRING)) {
			int locals = Integer.valueOf(name.substring(MAGICSTRING.length()));
			code.LOAD(locals);
		} else {
			code.LOADConst(name);
		}
	}

	static public void resolve(MethodCode code, Class<?> vc, Object obj) {
//		Class<?> vc = obj.getClass();
		if (vc == byte.class) {
			resolve(code, ((Byte) obj).byteValue());
		} else if (vc == char.class) {
			resolve(code, ((Character) obj).charValue());
		} else if (vc == short.class) {
			resolve(code, ((Short) obj).shortValue());
		} else if (vc == int.class) {
			resolve(code, ((Integer) obj).intValue());
		} else if (vc == long.class) {
			resolve(code, ((Long) obj).longValue());
		} else if (vc == float.class) {
			resolve(code, ((Float) obj).floatValue());
		} else if (vc == double.class) {
			resolve(code, ((Double) obj).doubleValue());
		} else if (vc == Byte.class) {
			resolve(code, ((Byte) obj));
		} else if (vc == Character.class) {
			resolve(code, ((Character) obj));
		} else if (vc == Short.class) {
			resolve(code, ((Short) obj));
		} else if (vc == Integer.class) {
			resolve(code, ((Integer) obj));
		} else if (vc == Long.class) {
			resolve(code, ((Long) obj));
		} else if (vc == Float.class) {
			resolve(code, ((Float) obj));
		} else if (vc == Double.class) {
			resolve(code, ((Double) obj));
		} else if (vc == Byte.class) {
			resolve(code, ((Byte) obj));
		} else if (vc == Byte.class) {
			resolve(code, ((Byte) obj));
		} else if (obj instanceof TinyAsmProxyRuntimeReferNameObject) {
			String name = ((TinyAsmProxyRuntimeReferNameObject) obj).get__ReferName();
			code.LOAD(name);
		} else {
			throw new UnsupportedOperationException("Only accept tinyasm proxy object");
		}
	}

	static public void resolve(MethodCode code, Object obj) {
		Class<?> vc = obj.getClass();
		if (vc == byte.class) {
			resolve(code, ((Byte) obj).byteValue());
		} else if (vc == char.class) {
			resolve(code, ((Character) obj).charValue());
		} else if (vc == short.class) {
			resolve(code, ((Short) obj).shortValue());
		} else if (vc == int.class) {
			resolve(code, ((Integer) obj).intValue());
		} else if (vc == long.class) {
			resolve(code, ((Long) obj).longValue());
		} else if (vc == float.class) {
			resolve(code, ((Float) obj).floatValue());
		} else if (vc == double.class) {
			resolve(code, ((Double) obj).doubleValue());
		} else if (vc == Byte.class) {
			resolve(code, ((Byte) obj));
		} else if (vc == Character.class) {
			resolve(code, ((Character) obj));
		} else if (vc == Short.class) {
			resolve(code, ((Short) obj));
		} else if (vc == Integer.class) {
			resolve(code, ((Integer) obj));
		} else if (vc == Long.class) {
			resolve(code, ((Long) obj));
		} else if (vc == Float.class) {
			resolve(code, ((Float) obj));
		} else if (vc == Double.class) {
			resolve(code, ((Double) obj));
		} else if (vc == Byte.class) {
			resolve(code, ((Byte) obj));
		} else if (vc == Byte.class) {
			resolve(code, ((Byte) obj));
		} else if (obj instanceof TinyAsmProxyRuntimeReferNameObject) {
			String name = ((TinyAsmProxyRuntimeReferNameObject) obj).get__ReferName();
			int locals = Integer.valueOf(name.substring(MAGICSTRING.length()));
			code.LOAD(locals);
		} else {
			throw new UnsupportedOperationException("Only accept tinyasm proxy object");
		}
	}
}
