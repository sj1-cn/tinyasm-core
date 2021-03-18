package cn.sj1.tinyasm.core;

import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Adv {

	static Logger logger = LoggerFactory.getLogger(Adv.class);

	/**********************************************
	 * Class
	 * 
	 * 
	 * 
	 * 
	 * 
	 ***********************************************/
//
//	static public AfterClassName public_class_(String advSample) {
//		AdvClassBuilderImpl builder = new AdvClassBuilderImpl(_contextThreadLocal);
//		builder.access(ACC_PUBLIC);
//		return builder.class_(advSample);
//	}

	static public AdvAfterClassName private_class_(String advSample) {
		AdvClassBuilderImpl builder = new AdvClassBuilderImpl(_contextThreadLocal);
		builder.access(ACC_PRIVATE);
		return builder.class_(advSample);
	}

	static public AdvAfterClassName protected_class_(String advSample) {
		AdvClassBuilderImpl builder = new AdvClassBuilderImpl(_contextThreadLocal);
		builder.access(ACC_PROTECTED);
		return builder.class_(advSample);
	}

	static public AdvAfterClassName package_class_(String advSample) {
		AdvClassBuilderImpl builder = new AdvClassBuilderImpl(_contextThreadLocal);
		builder.access(0);
		return builder.class_(advSample);
	}

	static public AdvAfterClassName public_class_(String advSample) {
		AdvClassBuilderImpl builder = new AdvClassBuilderImpl(_contextThreadLocal);
		builder.access(ACC_PUBLIC);
		return builder.class_(advSample);
	}

	/**********************************************
	 * enter method code
	 * 
	 * 
	 * 
	 * 
	 * 
	 ***********************************************/
	static private ThreadLocal<Stack<AdvContext>> _contextThreadLocalStack = new ThreadLocal<>();
	static ThreadLocal<AdvContext> _contextThreadLocal = new ThreadLocal<>();

	static private ThreadLocal<Stack<AdvClassContext>> _contextClassThreadLocalStack = new ThreadLocal<>();
	static private ThreadLocal<AdvClassContext> _contextClassThreadLocal = new ThreadLocal<>();
//	static void execBlock(MethodCode code, ConsumerWithException<MethodCode> block) throws Exception {
//		AdvContext context = enterCode(code);
//		context.execBlock(block);
//		exitCode();
//	}

	static AdvClassContext enterClass(AdvClassBuilder classBuilder) {
		AdvClassContext newContext = new AdvClassContext(classBuilder);
		if (_contextClassThreadLocal.get() != null) {
			if (_contextClassThreadLocalStack.get() == null) {
				_contextClassThreadLocalStack.set(new Stack<>());
			}
			_contextClassThreadLocalStack.get().push(_contextClassThreadLocal.get());
		}
		_contextClassThreadLocal.set(newContext);
		return newContext;
	}

	static void exitClass() {
//		AdvClassContext currentContext = _contextClassThreadLocal.get();
//		currentContext.clear();
		if (_contextClassThreadLocalStack.get() != null) {
			_contextClassThreadLocal.set(_contextClassThreadLocalStack.get().pop());
		} else {
			_contextClassThreadLocal.set(null);
		}
	}

	static int level = 0;

	static AdvContext enterCode(MethodCode code) {
		level++;
		logger.debug("enter code level {}", level);
		AdvContext newContext = new AdvContext(code);
		if (_contextThreadLocal.get() != null) {
			if (_contextThreadLocalStack.get() == null) {
				_contextThreadLocalStack.set(new Stack<>());
			}
			_contextThreadLocalStack.get().push(_contextThreadLocal.get());
			logger.debug("_contextThreadLocalStack {}", _contextThreadLocalStack.get().size());
		}
		_contextThreadLocal.set(newContext);
		return newContext;
	}

	static void exitCode() {
		AdvContext currentContext = _contextThreadLocal.get();
		currentContext.clear();
		if (_contextThreadLocalStack.get() != null && _contextThreadLocalStack.get().size() > 0) {
			logger.debug("_contextThreadLocalStack {}", _contextThreadLocalStack.get().size());
			_contextThreadLocal.set(_contextThreadLocalStack.get().pop());
		} else {
			_contextThreadLocal.set(null);
		}
		logger.debug("exit  code level {}", level);
		level--;
	}

	static public AdvAfterModifier public_() {
		AdvClassContext classContext = _contextClassThreadLocal.get();
		return classContext.getClassBuilder().public_();
	}

	static public AdvAfterModifier private_() {
		AdvClassContext classContext = _contextClassThreadLocal.get();
		return classContext.getClassBuilder().private_();
	}

	static public AdvAfterModifier protected_() {
		AdvClassContext classContext = _contextClassThreadLocal.get();
		return classContext.getClassBuilder().protected_();
	}

	static public AdvAfterModifier package_() {
		AdvClassContext classContext = _contextClassThreadLocal.get();
		return classContext.getClassBuilder().package_();
	}

	/**********************************************
	 * code
	 * 
	 * 
	 * 
	 * 
	 * 
	 ***********************************************/
	public static final String MAGIC_LOCALS_String = "#MAGIC-LOCALS#";
	public static final String MAGIC_CODES_String = "#MAGIC-CODES#";
	public static final String MAGIC_FIELD_String = "#MAGIC-FIELDS#";

	public static final byte MAGIC_LOCALS_NUMBER = 100;
	public static final byte MAGIC_LOCALS_MAX = 120;

	public static final byte MAGIC_CODES_NUMBER = 80;
	public static final byte MAGIC_CODES_MAX = 99;

	public static final byte MAGIC_FIELDS_NUMBER = 60;
	public static final byte MAGIC_FIELDS_MAX = 79;

	public static final byte MAGIC_STATIC_FIELD_NUMBER = 40;
	public static final byte MAGIC_STATIC_FIELD_MAX = 59;

	static public boolean_ cst(boolean value) {
		AdvContext context = _contextThreadLocal.get();
		int magicNUmber = MAGIC_CODES_NUMBER + context.push(boolean.class, c -> {
			c.LOADConst(value);
		});
		return new boolean_Holder(_contextThreadLocal, (byte) magicNUmber);
	}

	static public byte cst(byte value) {
		AdvContext context = _contextThreadLocal.get();
		return (byte) (MAGIC_CODES_NUMBER + context.push(byte.class, c -> {
			c.LOADConst(value);
		}));
	}

	static public char cst(char value) {
		AdvContext context = _contextThreadLocal.get();
		return (char) (MAGIC_CODES_NUMBER + context.push(char.class, c -> {
			c.LOADConst(value);
		}));
	}

	static public short cst(short value) {
		AdvContext context = _contextThreadLocal.get();
		return (short) (MAGIC_CODES_NUMBER + context.push(short.class, c -> {
			c.LOADConst(value);
		}));
	}

	static public int cst(int value) {
		AdvContext context = _contextThreadLocal.get();
		return (int) (MAGIC_CODES_NUMBER + context.push(int.class, c -> {
			c.LOADConst(value);
		}));
	}

	static public long cst(long value) {
		AdvContext context = _contextThreadLocal.get();
		return (long) (MAGIC_CODES_NUMBER + context.push(long.class, c -> {
			c.LOADConst(value);
		}));
	}

	static public float cst(float value) {
		AdvContext context = _contextThreadLocal.get();
		return (float) (MAGIC_CODES_NUMBER + context.push(float.class, c -> {
			c.LOADConst(value);
		}));
	}

	static public double cst(double value) {
		AdvContext context = _contextThreadLocal.get();
		return (double) (MAGIC_CODES_NUMBER + context.push(double.class, c -> {
			c.LOADConst(value);
		}));
	}

	static public String cst(String value) {
		AdvContext context = _contextThreadLocal.get();
		return MAGIC_CODES_String + context.push(String.class, c -> {
			c.LOADConst(value);
		});
	}

//	static public int inc(int l, int r) {
//		TinyAsmBuilderContext _contextThreadLocal = _contextThreadLocalThreadLocal.get();
//		MethodCode code = _contextThreadLocal.code;
//		code.LINE();
//		int locals = l - MAGIC_int;
//		code.IINC(locals, r);
//		return l;
//	}
//
//	static public <T> T getField(String name, Class<T> clazz) {
//		TinyAsmBuilderContext _contextThreadLocal = _contextThreadLocalThreadLocal.get();
//		MethodCode code = _contextThreadLocal.code;
//		code.LINE();
//		code.LOAD_THIS();
//		code.GETFIELD_OF_THIS(name);
//		return storeTopAndRefer(clazz);
//	}

//
//	static public boolean_ field_boolean(String name) {
//		AdvClassContext context = _contextClassThreadLocal.get();
//		
//		int locals = context.getClassBuilder().(name,boolean.class);
//
//		return new boolean_Holder(_contextThreadLocal, (byte) (MAGIC_FIELDS_NUMBER + locals));
//	}
//
//	static public Boolean__ field_Boolean(String name) {
//		AdvContext context = _contextThreadLocal.get();
//		int locals = context.getCode().codeLocalGetLocals(name);
//
//		return new Boolean__Holder(_contextThreadLocal, (byte) (MAGIC_FIELDS_NUMBER + locals));
//	}
//
//	static public byte field_byte(String name) {
//		AdvContext context = _contextThreadLocal.get();
//		int localsIndex = context.getCode().codeLocalGetLocals(name);
//		return (byte) (MAGIC_FIELDS_NUMBER + localsIndex);
//	}
//
//	static public short field_short(String name) {
//		AdvContext context = _contextThreadLocal.get();
//		int localsIndex = context.getCode().codeLocalGetLocals(name);
//		return (short) (MAGIC_FIELDS_NUMBER + localsIndex);
//	}
//
//	static public int field_int(String name) {
//		AdvContext context = _contextThreadLocal.get();
//		int localsIndex = context.getCode().codeLocalGetLocals(name);
//		return (int) (MAGIC_FIELDS_NUMBER + localsIndex);
//	}
//
//	static public long field_long(String name) {
//		AdvContext context = _contextThreadLocal.get();
//		int localsIndex = context.getCode().codeLocalGetLocals(name);
//		return (long) (MAGIC_FIELDS_NUMBER + localsIndex);
//	}
//
//	static public float field_float(String name) {
//		AdvContext context = _contextThreadLocal.get();
//		int localsIndex = context.getCode().codeLocalGetLocals(name);
//		return (float) (MAGIC_FIELDS_NUMBER + localsIndex);
//	}
//
//	static public double field_double(String name) {
//		AdvContext context = _contextThreadLocal.get();
//		int localsIndex = context.getCode().codeLocalGetLocals(name);
//		return (double) (MAGIC_FIELDS_NUMBER + localsIndex);
//	}
//
//	@SuppressWarnings("unchecked")
//	static public <T> T field(String name, Class<T> t) {
//		AdvContext context = _contextThreadLocal.get();
//		int localsIndex = context.getCode().codeLocalGetLocals(name);
//
//		if (t == Boolean.class) {
//			throw new UnsupportedOperationException("请使用 field_boolean");
//		} else if (t == Byte.class) {
//			Byte key = (byte) (MAGIC_FIELDS_NUMBER + localsIndex);
//			return (T) key;
//		} else if (t == Character.class) {
//			Character key = (char) (MAGIC_FIELDS_NUMBER + localsIndex);
//			return (T) key;
//		} else if (t == Short.class) {
//			Short key = (short) (MAGIC_FIELDS_NUMBER + localsIndex);
//			return (T) key;
//		} else if (t == Integer.class) {
//			Integer key = (int) (MAGIC_FIELDS_NUMBER + localsIndex);
//			return (T) key;
//		} else if (t == Long.class) {
//			Long key = (long) (MAGIC_FIELDS_NUMBER + localsIndex);
//			return (T) key;
//		} else if (t == Float.class) {
//			Double key = (double) (MAGIC_FIELDS_NUMBER + localsIndex);
//			return (T) key;
//		} else if (t == Double.class) {
//			Double key = (double) (MAGIC_FIELDS_NUMBER + localsIndex);
//			return (T) key;
//		} else if (t == String.class) {
//			String key = String.valueOf(MAGIC_LOCALS_String + localsIndex);
//			return (T) key;
//		} else {
//			byte magicNumber = (byte) (MAGIC_FIELDS_NUMBER + localsIndex);
//			T obj = brokerBuilder.buildProxyClass(t, _contextThreadLocal, magicNumber);
//			return (T) obj;
////		} else {
////			throw new UnsupportedOperationException("Only accept tinyasm proxy object");
//		}
//	}

	static public boolean_ param_boolean(String name) {
		AdvContext context = _contextThreadLocal.get();
		int locals = context.getCode().codeLocalGetLocals(name);

		return new boolean_Holder(_contextThreadLocal, (byte) (MAGIC_LOCALS_NUMBER + locals));
	}

	static public Boolean__ param_Boolean(String name) {
		AdvContext context = _contextThreadLocal.get();
		int locals = context.getCode().codeLocalGetLocals(name);

		return new Boolean__Holder(_contextThreadLocal, (byte) (MAGIC_LOCALS_NUMBER + locals));
	}

	static public byte param_byte(String name) {
		AdvContext context = _contextThreadLocal.get();
		int localsIndex = context.getCode().codeLocalGetLocals(name);
		return (byte) (MAGIC_LOCALS_NUMBER + localsIndex);
	}

	static public short param_short(String name) {
		AdvContext context = _contextThreadLocal.get();
		int localsIndex = context.getCode().codeLocalGetLocals(name);
		return (short) (MAGIC_LOCALS_NUMBER + localsIndex);
	}

	static public int param_int(String name) {
		AdvContext context = _contextThreadLocal.get();
		int localsIndex = context.getCode().codeLocalGetLocals(name);
		return (int) (MAGIC_LOCALS_NUMBER + localsIndex);
	}

	static public long param_long(String name) {
		AdvContext context = _contextThreadLocal.get();
		int localsIndex = context.getCode().codeLocalGetLocals(name);
		return (long) (MAGIC_LOCALS_NUMBER + localsIndex);
	}

	static public float param_float(String name) {
		AdvContext context = _contextThreadLocal.get();
		int localsIndex = context.getCode().codeLocalGetLocals(name);
		return (float) (MAGIC_LOCALS_NUMBER + localsIndex);
	}

	static public double param_double(String name) {
		AdvContext context = _contextThreadLocal.get();
		int localsIndex = context.getCode().codeLocalGetLocals(name);
		return (double) (MAGIC_LOCALS_NUMBER + localsIndex);
	}

	@SuppressWarnings("unchecked")
	static public <T> T param(String name, Class<T> t) {
		AdvContext context = _contextThreadLocal.get();
		int localsIndex = context.getCode().codeLocalGetLocals(name);

		if (t == Boolean.class) {
			throw new UnsupportedOperationException("请使用 param_boolean");
		} else if (t == Byte.class) {
			Byte key = (byte) (MAGIC_LOCALS_NUMBER + localsIndex);
			return (T) key;
		} else if (t == Character.class) {
			Character key = (char) (MAGIC_LOCALS_NUMBER + localsIndex);
			return (T) key;
		} else if (t == Short.class) {
			Short key = (short) (MAGIC_LOCALS_NUMBER + localsIndex);
			return (T) key;
		} else if (t == Integer.class) {
			Integer key = (int) (MAGIC_LOCALS_NUMBER + localsIndex);
			return (T) key;
		} else if (t == Long.class) {
			Long key = (long) (MAGIC_LOCALS_NUMBER + localsIndex);
			return (T) key;
		} else if (t == Float.class) {
			Double key = (double) (MAGIC_LOCALS_NUMBER + localsIndex);
			return (T) key;
		} else if (t == Double.class) {
			Double key = (double) (MAGIC_LOCALS_NUMBER + localsIndex);
			return (T) key;
		} else if (t == String.class) {
			String key = String.valueOf(MAGIC_LOCALS_String + localsIndex);
			return (T) key;
		} else {
			byte magicNumber = (byte) (MAGIC_LOCALS_NUMBER + localsIndex);
			T obj = brokerBuilder.buildProxyClass(_contextThreadLocal, t, magicNumber);
			return (T) obj;
//		} else {
//			throw new UnsupportedOperationException("Only accept tinyasm proxy object");
		}
	}

	static public boolean _return(boolean_ value) {
		return doreturn_(value.getMagicNumber()) == 0;
	}

	static public byte _return(byte value) {
		return (byte) doreturn_((int) value);
	}

	static public char _return(char value) {
		return (char) doreturn_((int) value);
	}

	static public short _return(short value) {
		return (short) doreturn_((int) value);
	}

	static public int _return(int value) {
		return doreturn_((int) value);
	}

	static public long _return(long value) {
		return doreturn_((int) value);
	}

	static public float _return(float value) {
		return doreturn_((int) value);
	}

	static public double _return(double value) {
		return doreturn_((int) value);
	}

	static public boolean _return(Boolean__ value) {
		return doreturn_(value.getMagicNumber()) == 0;
	}

	static public int doreturn_(int left) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> leftEval = context.resolve(left);
		context.execLine(c -> {
			leftEval.accept(c);
			c.RETURNTop();
		});
		return 0;
	}

	static public <T> T _return(T left) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> leftEval = context.resolve(left);
		context.execLine(c -> {
			leftEval.accept(c);
			c.RETURNTop();
		});
		return null;
	}

//
//	static public <T> void setField(String name, T value) {
//		TinyAsmBuilderContext _contextThreadLocal = _contextThreadLocalThreadLocal.get();
//		MethodCode code = _contextThreadLocal.code;
//		code.LINE();
//		code.LOAD_THIS();
//		resolve(code, value);
//		code.PUTFIELD_OF_THIS(name);
//	}
	static final AdvAsmProxyObjenesisBuilder brokerBuilder = new AdvAsmProxyObjenesisBuilder();
//
//	static public byte cstNull(byte value) {
//		AdvContext context = _contextThreadLocal.get();
//		return (byte)(MAGIC_CODES_NUMBER + context.push(c -> {
//			c.LOADConst(value);
//		}));
//	}

	static public <T> T new_(Class<T> clz) {
		AdvContext context = _contextThreadLocal.get();

		int codeIndex = context.push(clz, c -> {
			c.NEW(clz);
			c.DUP();
			c.SPECIAL(clz, "<init>").INVOKE();
		});

		int magicNumber = MAGIC_CODES_NUMBER + codeIndex;

		T t = brokerBuilder.buildProxyClass(_contextThreadLocal, clz, magicNumber);
		return t;
	}

	public static Object[] params(Object... params) {
		return params;
	}

	public static <T> T new_(Class<?> clz, Class<?> interfaceClass, Class<?> typeParameter) {
		AdvContext context = _contextThreadLocal.get();

		int codeIndex = context.push(clz, c -> {
			c.NEW(clz);
			c.DUP();
			c.SPECIAL(clz, "<init>").INVOKE();
			c.CHECKCAST(Type.getType(interfaceClass));
		});

		int magicNumber = MAGIC_CODES_NUMBER + codeIndex;

		@SuppressWarnings("unchecked")
		T t = (T) brokerBuilder.buildProxyClass(_contextThreadLocal, magicNumber, interfaceClass, typeParameter);
		return t;
	}
//
//	public static <T> T newList_(Class<?> clz, Class<?> interfaceClass, Class<?> typeParameter, Object... params) {
//		AdvContext context = _contextThreadLocal.get();
//
//		Constructor<?> constructor = matchConstruct(clz, params);
//		if (constructor == null) throw new UnsupportedOperationException();
//		Class<?>[] paramTypes = constructor.getParameterTypes();
//
//		List<ConsumerWithException<MethodCode>> valueEvals = new ArrayList<>();
//		for (int i = 0; i < params.length; i++) {
//			valueEvals.add(context.resolve(params[i], paramTypes[i]));
//		}
//
//		int codeIndex = context.push(clz, c -> {
////			c.LINE();
//			c.NEW(clz);
//			c.DUP();
//			for (ConsumerWithException<MethodCode> valueEval : valueEvals) {
//				valueEval.accept(c);
//			}
//			c.SPECIAL(clz, "<init>").parameter(constructor.getParameterTypes()).INVOKE();
////			c.CHECKCAST(Type.getType(interfaceClass));
//		});
//
//		int magicNumber = MAGIC_CODES_NUMBER + codeIndex;
//
//		@SuppressWarnings("unchecked")
//		T t = (T) brokerBuilder.buildProxyClass(_contextThreadLocal, magicNumber, interfaceClass, typeParameter);
//		return t;
//	}

	public static <T> T new_(Class<T> clz, Class<?> typeArgument) {
		AdvContext context = _contextThreadLocal.get();

		int codeIndex = context.push(clz, c -> {
			c.NEW(clz);
			c.DUP();
			c.SPECIAL(clz, "<init>").INVOKE();
		});

		int magicNumber = MAGIC_CODES_NUMBER + codeIndex;

		@SuppressWarnings("unchecked")
		T t = (T) brokerBuilder.buildProxyClass(_contextThreadLocal, magicNumber, clz, typeArgument);
		return t;
	}

	public static <T> T new_(Class<?> clz, Class<?> t0, Object[] params) {
		return new_(clz, new Class<?>[] { t0 }, params);
	}

	public static <T> T new_(Class<?> clz, Class<?> t0, Class<?> t1, Object[] params) {
		return new_(clz, of(t0, t1), params);
	}

	public static <T> T new_(Class<?> clz, Class<?> t0, Class<?> t1, Class<?> t2, Object[] params) {
		return new_(clz, of(t0, t1, t2), params);
	}

	public static <T> T new_(Class<?> clz, Class<?>[] typeArguments, Object[] params) {
		AdvContext context = _contextThreadLocal.get();

		Constructor<?> constructor = matchConstruct(clz, params);
		if (constructor == null) throw new UnsupportedOperationException();
		Class<?>[] paramTypes = constructor.getParameterTypes();

		List<ConsumerWithException<MethodCode>> valueEvals = new ArrayList<>();
		for (int i = params.length - 1; i >= 0; i--) {
			valueEvals.add(context.resolve(params[i], paramTypes[i]));
		}

		int codeIndex = context.push(clz, c -> {
//			c.LINE();
			c.NEW(clz);
			c.DUP();
			for (int i = valueEvals.size() - 1; i >= 0; i--) {
				valueEvals.get(i).accept(c);
			}
			c.SPECIAL(clz, "<init>").parameter(constructor.getParameterTypes()).INVOKE();
		});

		int magicNumber = MAGIC_CODES_NUMBER + codeIndex;

		@SuppressWarnings("unchecked")
		T t = (T) brokerBuilder.buildProxyClass(_contextThreadLocal, magicNumber, clz, typeArguments);
		return t;
	}

	static public <T> T new_(Class<T> clz, Object[] params) {

		AdvContext context = _contextThreadLocal.get();

		Constructor<?> constructor = matchConstruct(clz, params);
		if (constructor == null) throw new UnsupportedOperationException();
		Class<?>[] paramTypes = constructor.getParameterTypes();

		List<ConsumerWithException<MethodCode>> valueEvals = new ArrayList<>();
		for (int i = params.length - 1; i >= 0; i--) {
			valueEvals.add(context.resolve(params[i], paramTypes[i]));
		}

		int codeIndex = context.push(clz, c -> {
//			c.LINE();
			c.NEW(clz);
			c.DUP();
			for (int i = valueEvals.size() - 1; i >= 0; i--) {
				valueEvals.get(i).accept(c);
			}
			c.SPECIAL(clz, "<init>").parameter(constructor.getParameterTypes()).INVOKE();
		});

		int magicNumber = MAGIC_CODES_NUMBER + codeIndex;

		T t = brokerBuilder.buildProxyClass(_contextThreadLocal, clz, magicNumber);
		return t;
	}

	protected static Constructor<?> matchConstruct(Class<?> helloclass, Object[] params) {
		Constructor<?> c = null;
		for (Constructor<?> init : helloclass.getConstructors()) {
			if (init.getParameterCount() == params.length) {
				boolean matched = true;
				Class<?>[] definedParams = init.getParameterTypes();
				for (int i = 0; i < params.length; i++) {
					Object param = params[i];
					Class<?> defineParamClass = definedParams[i];
					if (defineParamClass == param.getClass()) {
					} else if (match(defineParamClass, param.getClass())) {
					} else if (matchProxy(param, defineParamClass)) {
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

	protected static boolean matchProxy(Object param, Class<?> defineParamClass) {
		return param instanceof AdvRuntimeReferNameObject && ((AdvRuntimeReferNameObject) param).get__TargetClazz().getType().getClassName().equals(defineParamClass.getName());
	}

	private static boolean match(Class<?> l, Class<?> r) {
		if (l.isPrimitive()) {
			return (l == byte.class && r == Byte.class) || (l == char.class && r == Character.class) || (l == short.class && r == Short.class) || (l == int.class && r == Integer.class) || (l == long.class && r == Long.class)
					|| (l == float.class && r == Float.class) || (l == double.class && r == Double.class);
		}
		return false;
	}

	static public ConsumerWithException<MethodCode> nop() {
		return c -> {
		};
	}

	// 不知道这里干嘛的，想不起来就删掉吧
	static public void referNothing(Object obj) {
		AdvContext context = _contextThreadLocal.get();

		assert /* (codeIndex == 0) && */ (context.getCodeStackSize() == 1) : "堆栈必须只有一个值";
		context.clear();
	}


	/**
	 * Refer 把当前堆栈顶的值保存在指定的local位置中并返回记录local位置的值。
	 * 
	 * @param booleanMagicLocalsIndex
	 * @param v
	 */
	static public void __(boolean_ booleanMagicLocalsIndex, boolean v) {
		byte targetMagicIndex = booleanMagicLocalsIndex.getMagicNumber();
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> ref = context.getCodeAndPop();
		if (MAGIC_LOCALS_NUMBER <= targetMagicIndex && targetMagicIndex <= MAGIC_LOCALS_MAX) {
			context.execLine(c -> {
				ref.accept(c);
				c.STORE(targetMagicIndex - MAGIC_LOCALS_NUMBER);
			});
		} else if (MAGIC_FIELDS_NUMBER <= targetMagicIndex && targetMagicIndex <= MAGIC_FIELDS_MAX) {
			int fieldIndex = targetMagicIndex - MAGIC_FIELDS_NUMBER;
			context.execLine(c -> {
				c.LOAD_THIS();
				ref.accept(c);
				c.PUTFIELD_OF_THIS(fieldIndex);
			});
		}
	}

	static public void __(Boolean__ booleanMagicLocalsIndex, Boolean v) {
		byte targetMagicIndex = booleanMagicLocalsIndex.getMagicNumber();
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> ref = context.getCodeAndPop();
		if (MAGIC_LOCALS_NUMBER <= targetMagicIndex && targetMagicIndex <= MAGIC_LOCALS_MAX) {
			context.execLine(c -> {
				ref.accept(c);
				c.STORE(targetMagicIndex - MAGIC_LOCALS_NUMBER);
			});
		} else if (MAGIC_FIELDS_NUMBER <= targetMagicIndex && targetMagicIndex <= MAGIC_FIELDS_MAX) {
			int fieldIndex = targetMagicIndex - MAGIC_FIELDS_NUMBER;
			context.execLine(c -> {
				c.LOAD_THIS();
				ref.accept(c);
				c.PUTFIELD_OF_THIS(fieldIndex);
			});
		}
	}

	static public void __(byte magicLocalsIndex, byte magicIndex) {
		doSet_(magicLocalsIndex, magicIndex);
	}

	static public void __(short magicLocalsIndex, short magicIndex) {
		doSet_(magicLocalsIndex, magicIndex);

	}

	static public void __(int magicLocalsIndex, int magicIndex) {
		doSet_(magicLocalsIndex, magicIndex);
	}

	protected static void doSet_(int targetMagicIndex, int magicIndex) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> ref = context.resolve(magicIndex);
		if (MAGIC_LOCALS_NUMBER <= targetMagicIndex && targetMagicIndex <= MAGIC_LOCALS_MAX) {
			context.execLine(c -> {
				ref.accept(c);
				c.STORE(targetMagicIndex - MAGIC_LOCALS_NUMBER);
			});
		} else if (MAGIC_FIELDS_NUMBER <= targetMagicIndex && targetMagicIndex <= MAGIC_FIELDS_MAX) {
			int fieldIndex = targetMagicIndex - MAGIC_FIELDS_NUMBER;
			context.execLine(c -> {
				c.LOAD_THIS();
				ref.accept(c);
				c.PUTFIELD_OF_THIS(fieldIndex);
			});
		}
	}

	static public void __(long magicLocalsIndex, long magicIndex) {
		doSet_((int) magicLocalsIndex, (int) magicIndex);
	}

	static public void __(float magicLocalsIndex, float magicIndex) {
		doSet_((int) magicLocalsIndex, (int) magicIndex);
	}

	static public void __(double magicLocalsIndex, double magicIndex) {
		doSet_((int) magicLocalsIndex, (int) magicIndex);
	}

	/**
	 * 把当前堆栈顶端的对象存储到locals中 TODO 需要重构，把对象类型加进去。
	 * 
	 * @param <T>
	 * @param magicNumber
	 * @return
	 */
	@SuppressWarnings("unchecked")
	static public <T> T __(String varname, T magicNumber) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> expr = context.resolve(magicNumber);
		context.clear();
		context.line();
		context.exec(expr);

		if (magicNumber instanceof AdvRuntimeReferNameObject) { // Proxy type
			AdvRuntimeReferNameObject obj = ((AdvRuntimeReferNameObject) magicNumber);

			int locals = context.store(varname, obj.get__TargetClazz());

			byte codeIndex = obj.get__MagicNumber();
			assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";

			byte localsIndex = (byte) (MAGIC_LOCALS_NUMBER + locals);
			obj.set__MagicNumber(localsIndex);
			return (T) obj;
		} else { // Real Type
			Class<?> t = magicNumber.getClass();
			int locals = context.store(varname, Clazz.of(t));
			if (t == Byte.class) {
				int codeIndex = ((Byte) magicNumber).intValue() - MAGIC_CODES_NUMBER;
				assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
				Byte key = (byte) (MAGIC_LOCALS_NUMBER + locals);
				return (T) key;
			} else if (t == Character.class) {
				int codeIndex = ((Character) magicNumber).charValue() - MAGIC_CODES_NUMBER;
				assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
				Character key = (char) (MAGIC_LOCALS_NUMBER + locals);
				return (T) key;
			} else if (t == Short.class) {
				int codeIndex = ((Short) magicNumber).intValue() - MAGIC_CODES_NUMBER;
				assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
				Short key = (short) (MAGIC_LOCALS_NUMBER + locals);
				return (T) key;
			} else if (t == Integer.class) {
				int codeIndex = ((Integer) magicNumber).intValue() - MAGIC_CODES_NUMBER;
				assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
				Integer key = (int) (MAGIC_LOCALS_NUMBER + locals);
				return (T) key;
			} else if (t == Long.class) {
				int codeIndex = ((Long) magicNumber).intValue() - MAGIC_CODES_NUMBER;
				assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
				Long key = (long) (MAGIC_LOCALS_NUMBER + locals);
				return (T) key;
			} else if (t == Float.class) {
				int codeIndex = ((Float) magicNumber).intValue() - MAGIC_CODES_NUMBER;
				assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
				Double key = (double) (MAGIC_LOCALS_NUMBER + locals);
				return (T) key;
			} else if (t == Double.class) {
				int codeIndex = ((Byte) magicNumber).intValue() - MAGIC_CODES_NUMBER;
				assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
				Double key = (double) (MAGIC_LOCALS_NUMBER + locals);
				return (T) key;
			} else if (t == String.class) {
				String key = String.valueOf(MAGIC_LOCALS_String + locals);
				return (T) key;
			} else {
				throw new UnsupportedOperationException("Only accept tinyasm proxy object");
			}
		}

	}

	@SuppressWarnings("unchecked")
	public static <T, R> T __(Class<T> targetClass, String varname, R magicNumber) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> expr = context.resolve(magicNumber);
		context.clear();
		context.line();
		context.exec(expr);
		if (targetClass.isAssignableFrom(magicNumber.getClass())) {

		} else {
			context.exec(code -> {
				code.CHECKCAST(targetClass);
			});
		}
		int locals = context.store(varname, Clazz.of(targetClass));

		Class<?> t = targetClass;

		if (t == boolean.class) {
			throw new UnsupportedOperationException();
		} else if (t == Byte.class) {
			int codeIndex = ((Byte) magicNumber).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
			Byte key = (byte) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Character.class) {
			int codeIndex = ((Character) magicNumber).charValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
			Character key = (char) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Short.class) {
			int codeIndex = ((Short) magicNumber).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
			Short key = (short) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Integer.class) {
			int codeIndex = ((Integer) magicNumber).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
			Integer key = (int) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Long.class) {
			int codeIndex = ((Long) magicNumber).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
			Long key = (long) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Float.class) {
			int codeIndex = ((Float) magicNumber).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
			Double key = (double) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Double.class) {
			int codeIndex = ((Byte) magicNumber).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
			Double key = (double) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == String.class) {
			String key = String.valueOf(MAGIC_LOCALS_String + locals);
			return (T) key;
		} else if (magicNumber instanceof AdvRuntimeReferNameObject) {
			byte localsIndex = (byte) (MAGIC_LOCALS_NUMBER + locals);
			return buildProxyClass(targetClass, localsIndex);
		} else {
			throw new UnsupportedOperationException("Only accept tinyasm proxy object");
		}
	}

	@SuppressWarnings("unchecked")
	public static <T, R> T __(Class<?> targetClass, Class<?> typeArgument, String varname, R magicNumber) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> expr = context.resolve(magicNumber);
		context.clear();
		context.line();
		context.exec(expr);
		if (targetClass.isAssignableFrom(magicNumber.getClass())) {

		} else {
			context.exec(code -> {
				code.CHECKCAST(targetClass);
			});
		}
		int locals = context.store(varname, Clazz.of(targetClass, of(typeArgument)));

		Class<?> t = targetClass;

		if (t == boolean.class) {
			throw new UnsupportedOperationException();
		} else if (t == Byte.class) {
			int codeIndex = ((Byte) magicNumber).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
			Byte key = (byte) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Character.class) {
			int codeIndex = ((Character) magicNumber).charValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
			Character key = (char) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Short.class) {
			int codeIndex = ((Short) magicNumber).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
			Short key = (short) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Integer.class) {
			int codeIndex = ((Integer) magicNumber).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
			Integer key = (int) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Long.class) {
			int codeIndex = ((Long) magicNumber).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
			Long key = (long) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Float.class) {
			int codeIndex = ((Float) magicNumber).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
			Double key = (double) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Double.class) {
			int codeIndex = ((Byte) magicNumber).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.getCodeStackSize() != 1) : "堆栈必须只有一个值";
			Double key = (double) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == String.class) {
			String key = String.valueOf(MAGIC_LOCALS_String + locals);
			return (T) key;
		} else if (magicNumber instanceof AdvRuntimeReferNameObject) {
			byte localsIndex = (byte) (MAGIC_LOCALS_NUMBER + locals);
			return buildProxyClass(targetClass, typeArgument, localsIndex);
		} else {
			throw new UnsupportedOperationException("Only accept tinyasm proxy object");
		}
	}

	static public <T> void __(T target, T src) {
		assert target instanceof AdvRuntimeReferNameObject : "target 必须是内部对象";
		assert src instanceof AdvRuntimeReferNameObject : "src 必须是内部对象";
//		if(src instanceof AdvRuntimeReferNameObject) {
//			
//		}
		int magicLocalsIndex = ((AdvRuntimeReferNameObject) target).get__MagicNumber();

		int magicIndex = ((AdvRuntimeReferNameObject) src).get__MagicNumber();
		doSet_((int) magicLocalsIndex, (int) magicIndex);
	}

//	/**
//	 * Refer 把当前堆栈顶的值保存在新的local位置中并返回记录local位置的值。
//	 * 
//	 * @param magicIndex
//	 * @return
//	 */
	static public boolean_ _b(String varname, boolean magicIndex) {
		AdvContext context = _contextThreadLocal.get();
		assert /* (codeIndex == 0) && */ (context.getCodeStackSize() == 1) : "堆栈必须只有一个值";

		ConsumerWithException<MethodCode> expr = context.getCodeAndPop();
		context.clear();
		context.line();
		context.exec(expr);
		int localsIndex = context.store(varname);

		return new boolean_Holder(_contextThreadLocal, (byte) (MAGIC_LOCALS_NUMBER + localsIndex));
	}

	static public Boolean__ _b(String varname, Boolean v) {
		AdvContext context = _contextThreadLocal.get();
		assert /* (codeIndex == 0) && */ (context.getCodeStackSize() == 1) : "堆栈必须只有一个值";

		ConsumerWithException<MethodCode> expr = context.getCodeAndPop();
		context.clear();
		context.line();
		context.exec(expr);
		int localsIndex = context.store(varname);

		return new Boolean__Holder(_contextThreadLocal, (byte) (MAGIC_LOCALS_NUMBER + localsIndex));
	}

	static public byte __(String varname, byte magicIndex) {
		int localsIndex = doReferByte(varname, (int) magicIndex);
		return (byte) (MAGIC_LOCALS_NUMBER + localsIndex);
	}

	static public short __(String varname, short magicIndex) {
		int localsIndex = doReferByte(varname, (int) magicIndex);
		return (short) (MAGIC_LOCALS_NUMBER + localsIndex);
	}

	static public int __(String varname, int magicIndex) {
		int localsIndex = doReferByte(varname, (int) magicIndex);
		return (int) (MAGIC_LOCALS_NUMBER + localsIndex);
	}

	static public long __(String varname, long magicIndex) {
		int localsIndex = doReferByte(varname, (int) magicIndex);
		return (long) (MAGIC_LOCALS_NUMBER + localsIndex);
	}

	static public float __(String varname, float magicIndex) {
		int localsIndex = doReferByte(varname, (int) magicIndex);
		return (float) (MAGIC_LOCALS_NUMBER + localsIndex);
	}

	static public double __(String varname, double magicIndex) {
		int localsIndex = doReferByte(varname, (int) magicIndex);
		return (double) (MAGIC_LOCALS_NUMBER + localsIndex);
	}

	protected static int doReferByte(String varname, int magicIndex) {
		AdvContext context = _contextThreadLocal.get();
//		context.resolve(null)
//		assert MAGIC_CODES_NUMBER <= magicIndex && magicIndex <= MAGIC_CODES_MAX : "必须是code index";
//		int codeIndex = (int) magicIndex - MAGIC_CODES_NUMBER;
//		assert codeIndex == context.stackSize() - 1 : "必须在堆栈顶";

		ConsumerWithException<MethodCode> expr = context.resolve(magicIndex);
		context.clear();
		context.line();
		context.exec(expr);
		int localsIndex = context.store(varname);

		return localsIndex;
	}

	@SuppressWarnings("unchecked")
	static public <T> T null_(Class<T> clazz) {
		AdvContext context = _contextThreadLocal.get();
//		ConsumerWithException<MethodCode> expr = context.resolve(magicNumber);
//		context.clear();
		int codeIndex = context.push(clazz, c -> {
			c.LOADConstNULL();
		});

		Class<?> t = clazz;
		if (t == boolean.class) {
			throw new UnsupportedOperationException();
		} else if (t == Byte.class) {
			Byte key = (byte) (MAGIC_CODES_NUMBER + codeIndex);
			return (T) key;
		} else if (t == Character.class) {
			Character key = (char) (MAGIC_CODES_NUMBER + codeIndex);
			return (T) key;
		} else if (t == Short.class) {
			Short key = (short) (MAGIC_CODES_NUMBER + codeIndex);
			return (T) key;
		} else if (t == Integer.class) {
			Integer key = (int) (MAGIC_CODES_NUMBER + codeIndex);
			return (T) key;
		} else if (t == Long.class) {
			Long key = (long) (MAGIC_CODES_NUMBER + codeIndex);
			return (T) key;
		} else if (t == Float.class) {
			Double key = (double) (MAGIC_CODES_NUMBER + codeIndex);
			return (T) key;
		} else if (t == Double.class) {
			Double key = (double) (MAGIC_CODES_NUMBER + codeIndex);
			return (T) key;
		} else if (t == String.class) {
			String key = String.valueOf(MAGIC_LOCALS_String + codeIndex);
			return (T) key;
		} else if (canProxy(t)) {
			byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
			return buildProxyClass(clazz, magicNumber);
		} else {
			throw new UnsupportedOperationException("Only accept tinyasm proxy object");
		}
	}

//	@SuppressWarnings("unchecked")
//	static public <T> T _null(Class<T> clazz, String varname) {
//		AdvContext context = _contextThreadLocal.get();
////		ConsumerWithException<MethodCode> expr = context.resolve(magicNumber);
//		context.clear();
//		context.line();
//		context.exec(c -> {
//			c.LOADConstNULL();
//		});
//		int locals = context.store(varname);
//
//		Class<?> t = clazz;
//		if (t == boolean.class) {
//			throw new UnsupportedOperationException();
//		} else if (t == Byte.class) {
//			Byte key = (byte) (MAGIC_LOCALS_NUMBER + locals);
//			return (T) key;
//		} else if (t == Character.class) {
//			Character key = (char) (MAGIC_LOCALS_NUMBER + locals);
//			return (T) key;
//		} else if (t == Short.class) {
//			Short key = (short) (MAGIC_LOCALS_NUMBER + locals);
//			return (T) key;
//		} else if (t == Integer.class) {
//			Integer key = (int) (MAGIC_LOCALS_NUMBER + locals);
//			return (T) key;
//		} else if (t == Long.class) {
//			Long key = (long) (MAGIC_LOCALS_NUMBER + locals);
//			return (T) key;
//		} else if (t == Float.class) {
//			Double key = (double) (MAGIC_LOCALS_NUMBER + locals);
//			return (T) key;
//		} else if (t == Double.class) {
//			Double key = (double) (MAGIC_LOCALS_NUMBER + locals);
//			return (T) key;
//		} else if (t == String.class) {
//			String key = String.valueOf(MAGIC_LOCALS_String + locals);
//			return (T) key;
//		} else if (canProxy(t)) {
//			byte magicNumber = (byte) (MAGIC_LOCALS_NUMBER + locals);
//			return buildProxyClass(clazz, magicNumber);
//		} else {
//			throw new UnsupportedOperationException("Only accept tinyasm proxy object");
//		}
//	}

	static public int add(int left, int right) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> rightEval = context.resolve(right);
		ConsumerWithException<MethodCode> leftEval = context.resolve(left);
		return MAGIC_CODES_NUMBER + context.push(int.class, c -> {
			leftEval.accept(c);
			rightEval.accept(c);
			c.ADD();
		});
	}

	// TODO INC 比较特殊 尽量不要使用
	static public void _inc(int left, int right) {
		AdvContext context = _contextThreadLocal.get();
		int magicNumber = left;
		assert (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) : "第一个参数必须是locals位置";
		int localsIndex = magicNumber - MAGIC_LOCALS_NUMBER;
		context.execLine(c -> {
			c.IINC(localsIndex, right);
		});
	}

	static public AdvAfterIf ifTrue_(boolean beGood) {
		return _if(isTrue(beGood));
	}

	static public AdvAfterIf ifFalse_(boolean beGood) {
		return _if(isFalse(beGood));
	}

	static public AdvAfterFor _for(CompareEval eval, ConsumerWithException<MethodCode> execEveryLoop) {
		AdvContext context = _contextThreadLocal.get();
		context.clear();

		AdvForBuilder builder = new AdvForBuilder(_contextThreadLocal, eval, execEveryLoop);
//		context.push(builder);
		return builder;
	}

	static public AdvAfterIf _if(CompareEval eval) {
		AdvContext context = _contextThreadLocal.get();
		context.clear();

		AdvIfBuilder builder = new AdvIfBuilder(_contextThreadLocal, eval);
		context.pushIf(builder);
		return builder;
	}

	static AdvAfterWhile whileTrue_(boolean eval) {
		return _while(isTrue(eval));
	}

	static AdvAfterWhile whileFalse_(boolean eval) {
		return _while(isFalse(eval));
	}

	static public AdvAfterWhile _while(CompareEval eval) {
		AdvWhileBuilder builder = new AdvWhileBuilder(_contextThreadLocal, eval);
//		context.push(builder);
		return builder;
	}

	static public AdvAfterDo _do(ConsumerWithException<MethodCode> block) {
		AdvDoWhileBuilder builder = new AdvDoWhileBuilder(_contextThreadLocal, block);
		return builder;
	}

	public static CompareEval isEqual(Object left, Object right) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> rightEval = context.resolve(right);
		ConsumerWithException<MethodCode> leftEval = context.resolve(left);
		return new CompareEval() {
			@Override
			public void prepareData(MethodCode code) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
			}

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				code.IF_ACMPEQ(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				code.IF_ACMPNE(label);
			}
		};
	}

	public static CompareEval isNotEqual(Object left, Object right) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> rightEval = context.resolve(right);
		ConsumerWithException<MethodCode> leftEval = context.resolve(left);
		return new CompareEval() {
			@Override
			public void prepareData(MethodCode code) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
			}

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				code.IF_ACMPNE(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				code.IF_ACMPEQ(label);
			}
		};
	}

	static public CompareEval isLessThan(int left, int right) {
		AdvContext context = _contextThreadLocal.get();
		if (right == 0) {
			ConsumerWithException<MethodCode> leftEval = context.resolve(left);
			return new CompareEval() {
				@Override
				public void prepareData(MethodCode code) throws Exception {
					leftEval.accept(code);
				}

				@Override
				public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
					code.IFLT(label);
				}

				@Override
				public void gotoWhenFail(MethodCode code, Label label) throws Exception {
					code.IFGE(label);
				}
			};
		}

		ConsumerWithException<MethodCode> rightEval = context.resolve(right);
		ConsumerWithException<MethodCode> leftEval = context.resolve(left);
		return new CompareEval() {
			@Override
			public void prepareData(MethodCode code) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
			}

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				code.IF_ICMPLT(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				code.IF_ICMPGE(label);
			}
		};

	}

	static public CompareEval isGreaterThan(int left, int right) {
		AdvContext context = _contextThreadLocal.get();
		if (right == 0) {
			ConsumerWithException<MethodCode> leftEval = context.resolve(left);
			return new CompareEval() {
				@Override
				public void prepareData(MethodCode code) throws Exception {
					leftEval.accept(code);
				}

				@Override
				public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
					code.IFGT(label);
				}

				@Override
				public void gotoWhenFail(MethodCode code, Label label) throws Exception {
					code.IFLE(label);
				}
			};
		}

		ConsumerWithException<MethodCode> rightEval = context.resolve(right);
		ConsumerWithException<MethodCode> leftEval = context.resolve(left);
		return new CompareEval() {
			@Override
			public void prepareData(MethodCode code) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
			}

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				code.IF_ICMPGT(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				code.IF_ICMPLE(label);
			}
		};
	}

	static public CompareEval isEqual(int left, int right) {
		AdvContext context = _contextThreadLocal.get();
		if (right == 0) {
			ConsumerWithException<MethodCode> leftEval = context.resolve(left);
			return new CompareEval() {
				@Override
				public void prepareData(MethodCode code) throws Exception {
					leftEval.accept(code);
				}

				@Override
				public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
					code.IFEQ(label);
				}

				@Override
				public void gotoWhenFail(MethodCode code, Label label) throws Exception {
					code.IFNE(label);
				}
			};
		}

		ConsumerWithException<MethodCode> rightEval = context.resolve(right);
		ConsumerWithException<MethodCode> leftEval = context.resolve(left);
		return new CompareEval() {
			@Override
			public void prepareData(MethodCode code) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
			}

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				code.IF_ICMPEQ(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				code.IF_ICMPNE(label);
			}
		};
	}

	static public CompareEval isNotEqual(int left, int right) {
		AdvContext context = _contextThreadLocal.get();
		if (right == 0) {
			ConsumerWithException<MethodCode> leftEval = context.resolve(left);
			return new CompareEval() {
				@Override
				public void prepareData(MethodCode code) throws Exception {
					leftEval.accept(code);
				}

				@Override
				public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
					code.IFNE(label);
				}

				@Override
				public void gotoWhenFail(MethodCode code, Label label) throws Exception {
					code.IFEQ(label);
				}
			};
		}

		ConsumerWithException<MethodCode> rightEval = context.resolve(right);
		ConsumerWithException<MethodCode> leftEval = context.resolve(left);
		return new CompareEval() {
			@Override
			public void prepareData(MethodCode code) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
			}

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				code.IF_ICMPNE(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				code.IF_ICMPEQ(label);
			}
		};
	}

	static public CompareEval isGreaterEqual(int left, int right) {
		AdvContext context = _contextThreadLocal.get();
		if (right == 0) {
			ConsumerWithException<MethodCode> leftEval = context.resolve(left);
			return new CompareEval() {
				@Override
				public void prepareData(MethodCode code) throws Exception {
					leftEval.accept(code);
				}

				@Override
				public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
					code.IFGE(label);
				}

				@Override
				public void gotoWhenFail(MethodCode code, Label label) throws Exception {
					code.IFLT(label);
				}
			};
		}

		ConsumerWithException<MethodCode> rightEval = context.resolve(right);
		ConsumerWithException<MethodCode> leftEval = context.resolve(left);
		return new CompareEval() {
			@Override
			public void prepareData(MethodCode code) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
			}

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				code.IF_ICMPGE(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				code.IF_ICMPLT(label);
			}
		};
	}

	static public CompareEval isLessEqual(int left, int right) {
		AdvContext context = _contextThreadLocal.get();
		if (right == 0) {
			ConsumerWithException<MethodCode> leftEval = context.resolve(left);
			return new CompareEval() {
				@Override
				public void prepareData(MethodCode code) throws Exception {
					leftEval.accept(code);
				}

				@Override
				public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
					code.IFLE(label);
				}

				@Override
				public void gotoWhenFail(MethodCode code, Label label) throws Exception {
					code.IFGT(label);
				}
			};
		}

		ConsumerWithException<MethodCode> rightEval = context.resolve(right);
		ConsumerWithException<MethodCode> leftEval = context.resolve(left);
		return new CompareEval() {
			@Override
			public void prepareData(MethodCode code) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
			}

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				code.IF_ICMPLE(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				code.IF_ICMPGT(label);
			}
		};

	}

	static public CompareEval isTrue(boolean eval) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> leftEval = context.getCodeAndPop();
		return new CompareEval() {
			@Override
			public void prepareData(MethodCode code) throws Exception {
				leftEval.accept(code);
			}

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				code.IFNE(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				code.IFEQ(label);
			}
		};
	}

	static public CompareEval isFalse(boolean eval) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> leftEval = context.getCodeAndPop();

		return new CompareEval() {
			@Override
			public void prepareData(MethodCode code) throws Exception {
				leftEval.accept(code);
			}

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				code.IFEQ(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				code.IFNE(label);
			}
		};
	}

	static public CompareEval isTrue(Boolean__ eval) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> leftEval = context.resolve(eval);
		return new CompareEval() {
			@Override
			public void prepareData(MethodCode code) throws Exception {
				leftEval.accept(code);
			}

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				code.IFNE(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				code.IFEQ(label);
			}
		};
	}

	static public CompareEval isFalse(Boolean__ eval) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> leftEval = context.resolve(eval);
		return new CompareEval() {
			@Override
			public void prepareData(MethodCode code) throws Exception {
				leftEval.accept(code);
			}

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				code.IFEQ(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				code.IFNE(label);
			}
		};
	}

	// is NULL
	static public CompareEval isNull(FunctionWithException<MethodCode, Boolean> beGood) {

		return null;
	}

	// is NOT NULL
	static public CompareEval notNull(FunctionWithException<MethodCode, Boolean> beGood) {

		return null;
	}

	public static boolean canProxy(Class<?> t) {
		return true;
	}

	public static <T> T buildProxyClass(Class<T> t, byte magicNumber) {
		return brokerBuilder.buildProxyClass(_contextThreadLocal, t, magicNumber);
	}

	public static <T> T buildProxyClass(Class<?> t, Class<?> type, byte magicNumber) {
		return brokerBuilder.buildProxyClass(_contextThreadLocal, magicNumber, t, type);
	}

	public static void import_(String string) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public static <T, R> R[] of(Function<T, R> func, T... tarray) {
		if (tarray.length == 0) return null;
		R r = func.apply(tarray[0]);
		R[] rarray = (R[]) Array.newInstance(r.getClass(), tarray.length);
		rarray[0] = r;

		for (int i = 1; i < rarray.length; i++) {
			rarray[i] = func.apply(tarray[i]);
		}
		return rarray;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] of(T t0) {
		T[] rarray = (T[]) Array.newInstance(t0.getClass(), 1);
		rarray[0] = t0;
		return rarray;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] of(T t0, T t1) {
		T[] rarray = (T[]) Array.newInstance(t0.getClass(), 2);
		rarray[0] = t0;
		rarray[1] = t1;
		return rarray;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] of(T t0, T t1, T t2) {
		T[] rarray = (T[]) Array.newInstance(t0.getClass(), 3);
		rarray[0] = t0;
		rarray[1] = t1;
		rarray[2] = t2;
		return rarray;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] of(T t0, T t1, T t2, T t3) {
		T[] rarray = (T[]) Array.newInstance(t0.getClass(), 4);
		rarray[0] = t0;
		rarray[1] = t1;
		rarray[2] = t2;
		rarray[3] = t3;
		return rarray;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] of(T t0, T t1, T t2, T t3, T t4) {
		T[] rarray = (T[]) Array.newInstance(t0.getClass(), 5);
		rarray[0] = t0;
		rarray[1] = t1;
		rarray[2] = t2;
		rarray[3] = t3;
		rarray[4] = t4;
		return rarray;
	}

	static public <T> String join(T[] array, Function<T, String> func) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			sb.append(func.apply(array[i]));
		}
		return sb.toString();
	}

	static public <T> String join(T[] array, Function<T, String> func, String seperator) {
		if (array.length == 0) return "";
		StringBuffer sb = new StringBuffer();
		sb.append(func.apply(array[0]));
		for (int i = 1; i < array.length; i++) {
			sb.append(seperator);
			sb.append(func.apply(array[i]));
		}
		return sb.toString();
	}

	public static void _line(ConsumerWithException<MethodCode> code) {
		AdvContext advContext = _contextThreadLocal.get();
		advContext.execLine(code);
	}	
	public static void _block(ConsumerWithException<MethodCode> code) {
		AdvContext advContext = _contextThreadLocal.get();
		advContext.execCodeBlock(code);
	}

	public static Object _piece(Class<?> clazz, ConsumerWithException<MethodCode> code) {
		AdvContext advContext = _contextThreadLocal.get();
		return advContext.push(clazz, code);
	}

	@SuppressWarnings("unchecked")
	public static <R> R proxyReturn(Class<?> class1, byte magicNumber) {
		if (Adv.canProxy(class1)) {
			return (R) Adv.buildProxyClass(class1, magicNumber);
		} else {
			return null;
		}
	}

	static public <T> Clazz clazzOf(T t) {
		if (t instanceof AdvRuntimeReferNameObject) {
			return ((AdvRuntimeReferNameObject) t).get__TargetClazz();
		} else {
			return Clazz.of(t.getClass());
		}
	}

}
