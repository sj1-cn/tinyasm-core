package cc1sj.tinyasm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Stack;
import java.util.function.Consumer;

import org.objectweb.asm.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TinyAsmBuilder {
//	<T> T ctor(Class<T> clz) {
//		return null;
//	}

//	static String __TOP__ = "__TOP__";
	static String __THIS__ = "this";

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
//	static int _localsLast;
	static ThreadLocal<Stack<TinyAsmBuilderContext>> _contextStackThreadLocal = new ThreadLocal<>();
	static private ThreadLocal<TinyAsmBuilderContext> _contextThreadLocal = new ThreadLocal<>();

	static Logger logger = LoggerFactory.getLogger(TinyAsmBuilder.class);

	static void enterCode(MethodCode code) {
		TinyAsmBuilderContext newContext = new TinyAsmBuilderContext(code);
		if (TinyAsmBuilder._contextThreadLocal.get() != null) {
			TinyAsmBuilderContext lastContext = _contextThreadLocal.get();
			if (_contextStackThreadLocal.get() == null) {
				_contextStackThreadLocal.set(new Stack<>());
			}
			_contextStackThreadLocal.get().push(lastContext);
		}
		TinyAsmBuilder._contextThreadLocal.set(newContext);
	}

	static void exitCode() {
//		TinyAsmBuilderContext context = _context;
//		MethodCode code = _code;
		if (_contextStackThreadLocal.get() != null && _contextStackThreadLocal.get().size() > 0) {
			TinyAsmBuilder._contextThreadLocal.set(_contextStackThreadLocal.get().pop());
		}
//		logger.trace("exit to {} from {} {}", code, code, codes.size());
	}

	static public <T> T var(Class<T> t) {
		TinyAsmBuilderContext _context = _contextThreadLocal.get();
		MethodCode code = _context.code;
		int locals = code.define(String.valueOf("V" + (_context._localsLast + 1)), t);
		_context._localsLast = locals;
		return refer(code, t, locals);
	}

	static public int cst(int i) {
		TinyAsmBuilderContext _context = _contextThreadLocal.get();
		MethodCode code = _context.code;

		code.LINE();
		code.LOADConst(i);
		return storeTopAndRefer(_context.code, int.class);
	}

	static public void initThis() {
		TinyAsmBuilderContext _context = _contextThreadLocal.get();
		MethodCode code = _context.code;
		code.LINE();
		code.LOAD(__THIS__);
		code.SPECIAL(Object.class, "<init>").INVOKE();
	}

	static public int inc(int l, int r) {
		TinyAsmBuilderContext _context = _contextThreadLocal.get();
		MethodCode code = _context.code;
		code.LINE();
		int locals = l - MAGIC_int;
		code.IINC(locals, r);
		return l;
	}

	static public <T> T getField(String name, Class<T> clazz) {
		TinyAsmBuilderContext _context = _contextThreadLocal.get();
		MethodCode code = _context.code;
		code.LINE();
		code.LOAD_THIS();
		code.GET_THIS_FIELD(name);
		return storeTopAndRefer(clazz);
	}

	static public <T> T param(String name, Class<T> clazz) {
		TinyAsmBuilderContext _context = _contextThreadLocal.get();
		MethodCode code = _context.code;
		int locals = code.codeLocalGetLocals(name);
		return refer(_context.code, clazz, locals);
	}

	static public <T> void ret(T value) {
		TinyAsmBuilderContext _context = _contextThreadLocal.get();
		MethodCode code = _context.code;
		resolve(code, value);
		code.RETURNTop();
	}

	static public <T> void setField(String name, T value) {
		TinyAsmBuilderContext _context = _contextThreadLocal.get();
		MethodCode code = _context.code;
		code.LINE();
		code.LOAD_THIS();
		resolve(code, value);
		code.PUTFIELD_OF_THIS(name);
	}

	static public int add(int l, int r) {
		TinyAsmBuilderContext _context = _contextThreadLocal.get();
		MethodCode code = _context.code;
		code.LINE();
		resolve(code, l);
		resolve(code, r);
		code.ADD();
		return storeTopAndRefer(code, int.class);
	}

	static public long add(long l, long r) {
		TinyAsmBuilderContext _context = _contextThreadLocal.get();
		MethodCode code = _context.code;
		code.LINE();
		resolve(code, l);
		resolve(code, r);
		code.ADD();
		return storeTopAndRefer(code, long.class);
	}

	@SuppressWarnings("unchecked")
	static public <T> T add(T l, T r) {

		TinyAsmBuilderContext _context = _contextThreadLocal.get();
		MethodCode code = _context.code;
		code.LINE();
		resolve(code, l);
		resolve(code, r);
		code.ADD();
		return (T) storeTopAndRefer(code, l.getClass());
	}

	static public short add(short l, short r) {

		TinyAsmBuilderContext _context = _contextThreadLocal.get();
		MethodCode code = _context.code;
		code.LINE();
		resolve(code, l);
		resolve(code, r);
		code.ADD();
		code.CONVERTTO(short.class);
		return storeTopAndRefer(code, short.class);
	}

	static public CompareEval cmpTrue(EvalBoolean<MethodCode, Boolean> eval) {
		return new CompareEval() {

			@Override
			public boolean gotoWhenSucceed(MethodCode code, Label label) {
				try {
					eval.apply(code);
					code.IFNE(label);
					return false;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}

			}

			@Override
			public boolean gotoWhenFail(MethodCode code, Label label) {
				try {
					eval.apply(code);
					code.IFEQ(label);
					return false;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
		};
	}

	static public CompareEval cmpLt(int left, int right) {
		return new CompareEval() {

			@Override
			public boolean gotoWhenSucceed(MethodCode code, Label label) {

				resolve(code, left);
				resolve(code, right);
				code.IF_ICMPLT(label);
				return false;

			}

			@Override
			public boolean gotoWhenFail(MethodCode code, Label label) {

				resolve(code, left);
				resolve(code, right);
				code.IF_ICMPGE(label);
				return false;
			}
		};
	}

	static public CompareEval cmpGt(int left, int right) {
		return new CompareEval() {

			@Override
			public boolean gotoWhenSucceed(MethodCode code, Label label) {

				resolve(code, left);
				resolve(code, right);
				code.IF_ICMPGT(label);
				return false;

			}

			@Override
			public boolean gotoWhenFail(MethodCode code, Label label) {

				resolve(code, left);
				resolve(code, right);
				code.IF_ICMPLE(label);
				return false;
			}
		};
	}

	static public CompareEval cmpEq(int left, int right) {
		return new CompareEval() {

			@Override
			public boolean gotoWhenSucceed(MethodCode code, Label label) {

				resolve(code, left);
				resolve(code, right);
				code.IF_ICMPEQ(label);
				return false;

			}

			@Override
			public boolean gotoWhenFail(MethodCode code, Label label) {

				resolve(code, left);
				resolve(code, right);
				code.IF_ICMPNE(label);
				return false;
			}
		};
	}

	static public CompareEval cmpNe(int left, int right) {
		return new CompareEval() {

			@Override
			public boolean gotoWhenSucceed(MethodCode code, Label label) {

				resolve(code, left);
				resolve(code, right);
				code.IF_ICMPNE(label);
				return false;

			}

			@Override
			public boolean gotoWhenFail(MethodCode code, Label label) {

				resolve(code, left);
				resolve(code, right);
				code.IF_ICMPEQ(label);
				return false;
			}
		};
	}

	static public CompareEval cmpGe(int left, int right) {
		return new CompareEval() {

			@Override
			public boolean gotoWhenSucceed(MethodCode code, Label label) {

				resolve(code, left);
				resolve(code, right);
				code.IF_ICMPGE(label);
				return false;

			}

			@Override
			public boolean gotoWhenFail(MethodCode code, Label label) {

				resolve(code, left);
				resolve(code, right);
				code.IF_ICMPLT(label);
				return false;
			}
		};
	}

	static public CompareEval cmpLe(int left, int right) {
		return new CompareEval() {

			@Override
			public boolean gotoWhenSucceed(MethodCode code, Label label) {

//				
				resolve(code, left);
				resolve(code, right);
				code.IF_ICMPLE(label);
				return false;

			}

			@Override
			public boolean gotoWhenFail(MethodCode code, Label label) {

//				
				resolve(code, left);
				resolve(code, right);
				code.IF_ICMPGT(label);
				return false;
			}
		};

	}

	interface CompareEval {
		boolean gotoWhenSucceed(MethodCode code, Label label);

		boolean gotoWhenFail(MethodCode code, Label label);
	}

	public interface EvalBoolean<T, R> {
		R apply(T t) throws Exception;
	}

	public interface BlockConsumer<T> {
		void accept(T t) throws Exception;
	}

	static final private TinyAsmProxyObjenesisBuilder brokerBuilder = new TinyAsmProxyObjenesisBuilder();

	static public void ifEval(CompareEval compareEval, Consumer<MethodCode> blockThen) {

		TinyAsmBuilderContext _context = _contextThreadLocal.get();
		MethodCode code = _context.code;

		code.LINE();
		Label labelThenEnd = new Label();
		compareEval.gotoWhenFail(code, labelThenEnd);

		blockThen.accept(code);

		code.visitLabel(labelThenEnd);

	}

	static public void ifEval(CompareEval compareEval, BlockConsumer<MethodCode> blockThen, BlockConsumer<MethodCode> blockElse) {

		try {
			TinyAsmBuilderContext _context = _contextThreadLocal.get();
			MethodCode code = _context.code;

//			code.LINE();
//			Label labelThenEnd = new Label();
//			compareEval.gotoWhenFail(code, labelThenEnd);
//
//			blockThen.accept(code);
//
//			code.LINE();
//			Label labelElseEnd = new Label();
//			code.GOTO(labelElseEnd);
//
//			code.visitLabel(labelThenEnd);
//
//			blockElse.accept(code);
//
//			code.visitLabel(labelElseEnd);

			code.LINE(39);
			Label labelElse = new Label();

			compareEval.gotoWhenFail(code, labelElse);

			{
				int lastStackSize = code.stackSize();
				blockThen.accept(code);
				while (code.stackSize() > lastStackSize) {
					code.POP();
				}
			}

			Label label4OfGOTO = new Label();
			code.GOTO(label4OfGOTO);

			code.visitLabel(labelElse);

			{
				int lastStackSize = code.stackSize();
				blockElse.accept(code);
				while (code.stackSize() > lastStackSize) {
					code.POP();
				}
			}

			code.visitLabel(label4OfGOTO);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static public void whileEval(CompareEval compareEval, BlockConsumer<MethodCode> block) {

		try {
			TinyAsmBuilderContext _context = _contextThreadLocal.get();
			MethodCode code = _context.code;

//			
//			code.LINE();
//			Label labelEvalCause = new Label();
//			code.GOTO(labelEvalCause);
//			Label labelBlockBegin = new Label();
//			code.visitLabel(labelBlockBegin);
//			int lastStackSize = code.stackSize();
//			block.accept(code);
//			while (code.stackSize() > lastStackSize) {
//				code.POP();
//			}
//			code.LINE();
//			code.visitLabel(labelEvalCause);
//			compareEval.gotoWhenSucceed(code, labelBlockBegin);

			Label firtGtFirst = new Label();

			code.visitLabel(firtGtFirst);

			Label firstGtEnd = new Label();
			code.LINE();
			compareEval.gotoWhenFail(code, firstGtEnd);
			{
				int lastStackSize = code.stackSize();
				block.accept(code);
				while (code.stackSize() > lastStackSize) {
					code.POP();
				}
			}
			code.GOTO(firtGtFirst);
			code.visitLabel(firstGtEnd);

//			methodVisitor.visitJumpInsn(IF_ICMPLE, label2);
//			methodVisitor.visitIincInsn(1, -1);
//			methodVisitor.visitJumpInsn(GOTO, label1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	static public void whileLt(int left, int right, Consumer<MethodCode> block) {
//		
	TinyAsmBuilderContext _context = _contextThreadLocal.get();
	MethodCode code = _context.code;
//		code.LINE();
//		Label labelBlockEnd = new Label();
//		code.GOTO(labelBlockEnd);
//		Label labelBlockBegin = new Label();
//		code.visitLabel(labelBlockBegin);
//
//		block.accept(code);
//
//		code.visitLabel(labelBlockEnd);
//
//		code.LINE();
//		resolve(code, left);
//		resolve(code, right);
//		code.IF_ICMPLT(labelBlockBegin);
//	}

	static public <T> T ctor(Class<T> helloclass) {

		TinyAsmBuilderContext _context = _contextThreadLocal.get();
		MethodCode code = _context.code;
//		_locals++;
//		String key = String.valueOf(MAGICSTRING + _locals);
		code.LINE();
		code.NEW(helloclass);
		code.DUP();
		code.SPECIAL(helloclass, "<init>").INVOKE();

		int locals = code.define(String.valueOf("V" + (_context._localsLast + 1)), helloclass);
		_context._localsLast = locals;
		code.STORE(locals);
		String strKey = String.valueOf(MAGICSTRING + locals);

		T t = brokerBuilder.builder(helloclass, _context, strKey);
		return t;
	}

	static public <T> T ctor(Class<T> helloclass, Object... params) {

		TinyAsmBuilderContext _context = _contextThreadLocal.get();
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

		int locals = code.define(String.valueOf("V" + (_context._localsLast + 1)), helloclass);
		_context._localsLast = locals;
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

	public static <T> T storeTopAndRefer(Class<T> t) {
		TinyAsmBuilderContext _context = _contextThreadLocal.get();
		MethodCode code = _context.code;
		return storeTopAndRefer(code, t);
	}

	public static <T> T storeTopAndRefer(MethodCode code, Class<T> t) {
		if (t == boolean.class) {
			return (T) Boolean.valueOf(false);
		} else {
			TinyAsmBuilderContext _context = _contextThreadLocal.get();
			int locals = code.define(String.valueOf("V" + (_context._localsLast + 1)), t);
			_context._localsLast = locals;
			code.STORE(locals);
			return refer(code, t, locals);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T refer(MethodCode code, Class<T> t, int locals) {
		TinyAsmBuilderContext _context = _contextThreadLocal.get();

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

	static public void resolveBasic(MethodCode code, Object obj) {
		Class<?> vc = obj.getClass();
		if (vc.isPrimitive()) {
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
			}
		} else {
			if (vc == Byte.class) {
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
