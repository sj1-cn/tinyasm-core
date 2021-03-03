package cc1sj.tinyasm;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.objectweb.asm.Label;
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

	static public AfterClassModifier public_() {
		AdvClassBuilderImpl builder = new AdvClassBuilderImpl();
		builder.access(ACC_PUBLIC);
		return builder;
	}

	static public AfterClassModifier private_() {
		AdvClassBuilderImpl builder = new AdvClassBuilderImpl();
		builder.access(ACC_PUBLIC);
		return builder;
	}

	static public AfterClassModifier protected_() {
		AdvClassBuilderImpl builder = new AdvClassBuilderImpl();
		builder.access(ACC_PUBLIC);
		return builder;
	}

	static public AfterClassModifier package_() {
		AdvClassBuilderImpl builder = new AdvClassBuilderImpl();
		builder.access(0);
		return builder;
	}

	/**********************************************
	 * enter method code
	 * 
	 * 
	 * 
	 * 
	 * 
	 ***********************************************/
	static ThreadLocal<Stack<AdvContext>> _contextStack = new ThreadLocal<>();
	static private ThreadLocal<AdvContext> _context = new ThreadLocal<>();

	static AdvContext enterCode(MethodCode code) {
		AdvContext newContext = new AdvContext(code);
		if (_context.get() != null) {
			if (_contextStack.get() == null) {
				_contextStack.set(new Stack<>());
			}
			_contextStack.get().push(_context.get());
		}
		_context.set(newContext);
		return newContext;
	}

	static void exitCode() {
		AdvContext currentContext = _context.get();
		currentContext.clear();
		if (_contextStack.get() != null) {
			_context.set(_contextStack.get().pop());
		} else {
			_context.set(null);
		}
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

	public static final byte MAGIC_LOCALS_NUMBER = 100;
	public static final byte MAGIC_LOCALS_MAX = 120;

	public static final byte MAGIC_CODES_NUMBER = 80;
	public static final byte MAGIC_CODES_MAX = 99;

	public static final byte MAGIC_FIELD_NUMBER = 40;
	public static final byte MAGIC_FIELD_MAX = 79;

	static public boolean_ cst(boolean value) {
		AdvContext context = _context.get();
		int magicNUmber = MAGIC_CODES_NUMBER + context.push(c -> {
			c.LOADConst(value);
		});
		return new boolean_Holder(context, (byte) magicNUmber);
	}

	static public byte cst(byte value) {
		AdvContext context = _context.get();
		return (byte) (MAGIC_CODES_NUMBER + context.push(c -> {
			c.LOADConst(value);
		}));
	}

	static public char cst(char value) {
		AdvContext context = _context.get();
		return (char) (MAGIC_CODES_NUMBER + context.push(c -> {
			c.LOADConst(value);
		}));
	}

	static public short cst(short value) {
		AdvContext context = _context.get();
		return (short) (MAGIC_CODES_NUMBER + context.push(c -> {
			c.LOADConst(value);
		}));
	}

	static public int cst(int value) {
		AdvContext context = _context.get();
		return (int) (MAGIC_CODES_NUMBER + context.push(c -> {
			c.LOADConst(value);
		}));
	}

	static public long cst(long value) {
		AdvContext context = _context.get();
		return (long) (MAGIC_CODES_NUMBER + context.push(c -> {
			c.LOADConst(value);
		}));
	}

	static public float cst(float value) {
		AdvContext context = _context.get();
		return (float) (MAGIC_CODES_NUMBER + context.push(c -> {
			c.LOADConst(value);
		}));
	}

	static public double cst(double value) {
		AdvContext context = _context.get();
		return (double) (MAGIC_CODES_NUMBER + context.push(c -> {
			c.LOADConst(value);
		}));
	}

	static final private AdvAsmProxyObjenesisBuilder brokerBuilder = new AdvAsmProxyObjenesisBuilder();
//
//	static public byte cstNull(byte value) {
//		AdvContext context = _context.get();
//		return (byte)(MAGIC_CODES_NUMBER + context.push(c -> {
//			c.LOADConst(value);
//		}));
//	}

	static public <T> T ctor(Class<T> clz) {
		AdvContext context = _context.get();

		int codeIndex = context.push(c -> {
			c.NEW(clz);
			c.DUP();
			c.SPECIAL(clz, "<init>").INVOKE();
		});

		int magicNumber = MAGIC_CODES_NUMBER + codeIndex;

		T t = brokerBuilder.builder(clz, _context, magicNumber);
		return t;
	}

	static public <T> T ctor(Class<T> clz, Object... params) {

		AdvContext context = _context.get();

		Constructor<?> constructor = matchConstruct(clz, params);
		if (constructor == null) throw new UnsupportedOperationException();
		Class<?>[] paramTypes = constructor.getParameterTypes();

		List<ConsumerWithException<MethodCode>> valueEvals = new ArrayList<>();
		for (int i = 0; i < params.length; i++) {
			valueEvals.add(context.resolve(params[i], paramTypes[i]));
		}

		int codeIndex = context.push(c -> {
			c.LINE();
			c.NEW(clz);
			c.DUP();
			for (ConsumerWithException<MethodCode> valueEval : valueEvals) {
				valueEval.accept(c);
			}
			c.SPECIAL(clz, "<init>").parameter(constructor.getParameterTypes()).INVOKE();
		});

		int magicNumber = MAGIC_CODES_NUMBER + codeIndex;

		T t = brokerBuilder.builder(clz, _context, magicNumber);
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

	static public ConsumerWithException<MethodCode> nop() {
		return c -> {
		};
	}

	static public void referNothing(Object obj) {
		AdvContext context = _context.get();

		assert /* (codeIndex == 0) && */ (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		context.pop();
	}

	/**
	 * Refer 把当前堆栈顶的值保存在指定的local位置中并返回记录local位置的值。
	 * 
	 * @param magicIndex
	 * @return
	 */
	/**
	 * set
	 * 
	 * @param booleanMagicLocalsIndex
	 * @param magicIndex
	 */
	static public void __(boolean_ booleanMagicLocalsIndex, boolean magicIndex) {
		AdvContext context = _context.get();

		byte magicLocalsIndex = booleanMagicLocalsIndex.getLocalsIndex();
		assert MAGIC_LOCALS_NUMBER <= magicLocalsIndex && magicLocalsIndex <= MAGIC_LOCALS_MAX : "必须是locals index";
		assert /* (magicIndex == 0) && */ (context.stackSize() == 1) : "堆栈必须只有一个值";

		context.popAndExec();
		context.store(magicLocalsIndex - MAGIC_LOCALS_NUMBER);
	}

	static public void __(Boolean__ booleanMagicLocalsIndex, Boolean v) {
		AdvContext context = _context.get();

		byte magicLocalsIndex = booleanMagicLocalsIndex.getLocalsIndex();
		assert MAGIC_LOCALS_NUMBER <= magicLocalsIndex && magicLocalsIndex <= MAGIC_LOCALS_MAX : "必须是locals index";
		assert /* (magicIndex == 0) && */ (context.stackSize() == 1) : "堆栈必须只有一个值";

		context.popAndExec();
		context.store(magicLocalsIndex - MAGIC_LOCALS_NUMBER);
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

	protected static void doSet_(int magicLocalsIndex, int magicIndex) {
		AdvContext context = _context.get();

		assert MAGIC_LOCALS_NUMBER <= magicLocalsIndex && magicLocalsIndex <= MAGIC_LOCALS_MAX : "必须是locals index";
		assert MAGIC_CODES_NUMBER <= magicIndex && magicIndex <= MAGIC_CODES_MAX : "必须是code index";

		ConsumerWithException<MethodCode> ref = context.resolve(magicIndex);

		context.push(c -> {
			ref.accept(c);
			c.STORE(magicLocalsIndex - MAGIC_LOCALS_NUMBER);
		});
		context.popAndExec();

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
	 * Refer 把当前堆栈顶的值保存在新的local位置中并返回记录local位置的值。
	 * 
	 * @param magicIndex
	 * @return
	 */
	static public boolean_ __(boolean magicIndex) {
		AdvContext context = _context.get();
		assert /* (codeIndex == 0) && */ (context.stackSize() == 1) : "堆栈必须只有一个值";
//		//context.line();
		context.popAndExec();
		int referIndex = context.store();

		return new boolean_Holder(context, (byte) (MAGIC_LOCALS_NUMBER + referIndex));
	}

	static public Boolean__ __(Boolean v) {
		AdvContext context = _context.get();
		assert /* (codeIndex == 0) && */ (context.stackSize() == 1) : "堆栈必须只有一个值";
//		//context.line();
		context.popAndExec();
		int referIndex = context.store();

		return new Boolean__Holder(context, (byte) (MAGIC_LOCALS_NUMBER + referIndex));
	}

	static public byte __(byte magicIndex) {
		int referIndex = doReferByte((int) magicIndex);
		return (byte) (MAGIC_LOCALS_NUMBER + referIndex);
	}

	static public short __(short magicIndex) {
		int referIndex = doReferByte((int) magicIndex);
		return (short) (MAGIC_LOCALS_NUMBER + referIndex);
	}

	static public int __(int magicIndex) {
		int referIndex = doReferByte((int) magicIndex);
		return (int) (MAGIC_LOCALS_NUMBER + referIndex);
	}

	static public long __(long magicIndex) {
		int referIndex = doReferByte((int) magicIndex);
		return (long) (MAGIC_LOCALS_NUMBER + referIndex);
	}

	static public float __(float magicIndex) {
		int referIndex = doReferByte((int) magicIndex);
		return (float) (MAGIC_LOCALS_NUMBER + referIndex);
	}

	static public double __(double magicIndex) {
		int referIndex = doReferByte((int) magicIndex);
		return (double) (MAGIC_LOCALS_NUMBER + referIndex);
	}

	protected static int doReferByte(int magicIndex) {
		AdvContext context = _context.get();
		assert MAGIC_CODES_NUMBER <= magicIndex && magicIndex <= MAGIC_CODES_MAX : "必须是code index";
		int codeIndex = (int) magicIndex - MAGIC_CODES_NUMBER;
		assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";

		context.popAndExec();
		int referIndex = context.store();

		return referIndex;
	}

	/**
	 * 把当前堆栈顶端的对象存储到locals中
	 * 
	 * @param <T>
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	static public <T> T __(T value) {
		AdvContext context = _context.get();
		context.popAndExec();
		int locals = context.store();

		Class<?> t = value.getClass();

		if (t == boolean.class) {
			throw new UnsupportedOperationException();
		} else if (t == Byte.class) {
			int codeIndex = ((Byte) value).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.stackSize() != 1) : "堆栈必须只有一个值";
			Byte key = (byte) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Character.class) {
			int codeIndex = ((Character) value).charValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.stackSize() != 1) : "堆栈必须只有一个值";
			Character key = (char) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Short.class) {
			int codeIndex = ((Short) value).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.stackSize() != 1) : "堆栈必须只有一个值";
			Short key = (short) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Integer.class) {
			int codeIndex = ((Integer) value).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.stackSize() != 1) : "堆栈必须只有一个值";
			Integer key = (int) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Long.class) {
			int codeIndex = ((Long) value).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.stackSize() != 1) : "堆栈必须只有一个值";
			Long key = (long) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Float.class) {
			int codeIndex = ((Float) value).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.stackSize() != 1) : "堆栈必须只有一个值";
			Double key = (double) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Double.class) {
			int codeIndex = ((Byte) value).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex != 0) && (context.stackSize() != 1) : "堆栈必须只有一个值";
			Double key = (double) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == String.class) {
			String key = String.valueOf(MAGIC_LOCALS_String + locals);
			return (T) key;
		} else if (value instanceof AdvRuntimeReferNameObject) {
			AdvRuntimeReferNameObject obj = ((AdvRuntimeReferNameObject) value);
			byte codeIndex = obj.get__MagicNumber();

			assert (codeIndex != 0) && (context.stackSize() != 1) : "堆栈必须只有一个值";

			byte localsIndex = (byte) (MAGIC_LOCALS_NUMBER + locals);
			obj.set__MagicNumber(localsIndex);
			return (T) obj;
		} else {
			throw new UnsupportedOperationException("Only accept tinyasm proxy object");
		}
	}

	static public int add(int left, int right) {
		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> rightEval = context.resolve(right);
		ConsumerWithException<MethodCode> leftEval = context.resolve(left);
		return MAGIC_CODES_NUMBER + context.push(c -> {
			leftEval.accept(c);
			rightEval.accept(c);
			c.ADD();
		});
	}

	static public AfterIf ifTrue_(boolean beGood) {
		return if_(isTrue(beGood));
	}

	static public AfterIf ifFalse_(boolean beGood) {
		return if_(isFalse(beGood));
	}

	static public AfterIf if_(CompareEval eval) {
		AdvContext context = _context.get();

		IfBuilder builder = new IfBuilder(context, eval);
		context.push(builder);
		return builder;
	}

	static AfterWhile whileTrue_(boolean eval) {
		return while_(isTrue(eval));
	}

	static AfterWhile whileFalse_(boolean eval) {
		return while_(isFalse(eval));
	}

	static public AfterWhile while_(CompareEval eval) {
		WhileBuilder builder = new WhileBuilder(_context, eval);
//		context.push(builder);
		return builder;
	}

	static public AfterDo do_(ConsumerWithException<MethodCode> block) {
		DoWhileBuilder builder = new DoWhileBuilder(_context, block);
		return builder;
	}

	static public CompareEval isLessThen(int left, int right) {
		AdvContext context = _context.get();
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

	static public CompareEval isGreaterThen(int left, int right) {
		AdvContext context = _context.get();
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
		AdvContext context = _context.get();
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
		AdvContext context = _context.get();
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

	static public CompareEval isGreaterAndEqual(int left, int right) {
		AdvContext context = _context.get();
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

	static public CompareEval isLessAndEqual(int left, int right) {
		AdvContext context = _context.get();
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
		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> leftEval = context.getCodeAndPopTop();
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
		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> leftEval = context.getCodeAndPopTop();

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
		AdvContext context = _context.get();
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
		AdvContext context = _context.get();
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
}
