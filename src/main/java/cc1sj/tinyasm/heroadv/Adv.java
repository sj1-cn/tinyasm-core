package cc1sj.tinyasm.heroadv;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

import java.util.Stack;

import org.objectweb.asm.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.TinyAsmProxyRuntimeReferNameObject;

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
		AdvClassBuilder builder = new AdvClassBuilder();
		builder.access(ACC_PUBLIC);
		return builder;
	}

	static public AfterClassModifier private_() {
		AdvClassBuilder builder = new AdvClassBuilder();
		builder.access(ACC_PUBLIC);
		return builder;
	}

	static public AfterClassModifier protected_() {
		AdvClassBuilder builder = new AdvClassBuilder();
		builder.access(ACC_PUBLIC);
		return builder;
	}

	static public AfterClassModifier package_() {
		AdvClassBuilder builder = new AdvClassBuilder();
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

	static void enterCode(MethodCode code) {
		AdvContext newContext = new AdvContext(code);
		if (_context.get() != null) {
			if (_contextStack.get() == null) {
				_contextStack.set(new Stack<>());
			}
			_contextStack.get().push(_context.get());
		}
		_context.set(newContext);
	}

	static void exitCode() {
		_context.set(_contextStack.get().pop());
	}

	/**********************************************
	 * code
	 * 
	 * 
	 * 
	 * 
	 * 
	 ***********************************************/
	static final String MAGIC_LOCALS_String = "#MAGIC-LOCALS#";
	static final String MAGIC_CODES_String = "#MAGIC-CODES#";

	static final byte MAGIC_LOCALS_NUMBER = 100;
	static final byte MAGIC_LOCALS_MAX = 120;

	static final byte MAGIC_CODES_NUMBER = 80;
	static final byte MAGIC_CODES_MAX = 99;

	static final byte MAGIC_FIELD_NUMBER = 40;
	static final byte MAGIC_FIELD_MAX = 79;

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

//
//	static public byte cstNull(byte value) {
//		AdvContext context = _context.get();
//		return (byte)(MAGIC_CODES_NUMBER + context.push(c -> {
//			c.LOADConst(value);
//		}));
//	}

	static public <T> T ctor(Class<T> clz) {
		return null;
	}

	static public ConsumerWithException<MethodCode> nop() {
		return c -> {
		};
	}

	static public void referNothing(Object obj) {
		AdvContext context = _context.get();
		context.clear();
		assert /* (codeIndex == 0) && */ (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		context.pop();
	}

	static public void set_(boolean_ booleanMagicReferIndex, boolean codeIndex) {
		AdvContext context = _context.get();
		context.clear();
		byte magicReferIndex = booleanMagicReferIndex.getReferIndex();
		assert MAGIC_LOCALS_NUMBER <= magicReferIndex && magicReferIndex <= MAGIC_LOCALS_MAX : "必须是locals index";
		assert /* (codeIndex == 0) && */ (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		context.store(magicReferIndex - MAGIC_LOCALS_NUMBER);
	}

	static public void set_(Boolean__ booleanMagicReferIndex, Boolean v) {
		AdvContext context = _context.get();
		context.clear();
		byte magicReferIndex = booleanMagicReferIndex.getReferIndex();
		assert MAGIC_LOCALS_NUMBER <= magicReferIndex && magicReferIndex <= MAGIC_LOCALS_MAX : "必须是locals index";
		assert /* (codeIndex == 0) && */ (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		context.store(magicReferIndex - MAGIC_LOCALS_NUMBER);
	}

	static public void set_(byte magicReferIndex, byte codeIndex) {
		AdvContext context = _context.get();
		context.clear();
		assert MAGIC_LOCALS_NUMBER <= magicReferIndex && magicReferIndex <= MAGIC_LOCALS_MAX : "必须是locals index";
		assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		context.store(magicReferIndex - MAGIC_LOCALS_NUMBER);
	}

	static public void set_(short magicReferIndex, short codeIndex) {
		AdvContext context = _context.get();
		context.clear();
		assert MAGIC_LOCALS_NUMBER <= magicReferIndex && magicReferIndex <= MAGIC_LOCALS_MAX : "必须是locals index";
		assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		context.store(magicReferIndex - MAGIC_LOCALS_NUMBER);

	}

	static public void set_(int magicReferIndex, int codeIndex) {
		AdvContext context = _context.get();
		context.clear();
		assert MAGIC_LOCALS_NUMBER <= magicReferIndex && magicReferIndex <= MAGIC_LOCALS_MAX : "必须是locals index";
		assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		context.store(magicReferIndex - MAGIC_LOCALS_NUMBER);

	}

	static public void set_(long magicReferIndex, long codeIndex) {
		AdvContext context = _context.get();
		context.clear();
		assert MAGIC_LOCALS_NUMBER <= magicReferIndex && magicReferIndex <= MAGIC_LOCALS_MAX : "必须是locals index";
		assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		context.store((byte) magicReferIndex - MAGIC_LOCALS_NUMBER);

	}

	static public void set_(float magicReferIndex, float codeIndex) {
		AdvContext context = _context.get();
		context.clear();
		assert MAGIC_LOCALS_NUMBER <= magicReferIndex && magicReferIndex <= MAGIC_LOCALS_MAX : "必须是locals index";
		assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		context.store((byte) magicReferIndex - MAGIC_LOCALS_NUMBER);

	}

	static public void set_(double magicReferIndex, double codeIndex) {
		AdvContext context = _context.get();
		context.clear();
		assert MAGIC_LOCALS_NUMBER <= magicReferIndex && magicReferIndex <= MAGIC_LOCALS_MAX : "必须是locals index";

		assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		context.store((byte) magicReferIndex - MAGIC_LOCALS_NUMBER);

	}

	static public boolean_ refer_(boolean codeIndex) {
		AdvContext context = _context.get();
		context.clear();
		assert /* (codeIndex == 0) && */ (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		int referIndex = context.store();

		return new boolean_Holder(context, (byte) (MAGIC_LOCALS_NUMBER + referIndex));
	}

	static public Boolean__ refer_(Boolean v) {
		AdvContext context = _context.get();
		context.clear();
		assert /* (codeIndex == 0) && */ (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		int referIndex = context.store();

		return new Boolean__Holder(context, (byte) (MAGIC_LOCALS_NUMBER + referIndex));
	}

	static public byte refer_(byte codeIndex) {
		AdvContext context = _context.get();
		context.clear();
		assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		int referIndex = context.store();

		return (byte) (MAGIC_LOCALS_NUMBER + referIndex);
	}

	static public short refer_(short codeIndex) {
		AdvContext context = _context.get();
		context.clear();
		assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		int referIndex = context.store();

		return (short) (MAGIC_LOCALS_NUMBER + referIndex);
	}

	static public int refer_(int codeIndex) {
		AdvContext context = _context.get();
		context.clear();
		assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		int referIndex = context.store();

		return (int) (MAGIC_LOCALS_NUMBER + referIndex);
	}

	static public long refer_(long codeIndex) {
		AdvContext context = _context.get();
		context.clear();
		assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		int referIndex = context.store();

		return (long) (MAGIC_LOCALS_NUMBER + referIndex);
	}

	static public float refer_(float codeIndex) {
		AdvContext context = _context.get();
		context.clear();
		assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		int referIndex = context.store();

		return (float) (MAGIC_LOCALS_NUMBER + referIndex);
	}

	static public double refer_(double codeIndex) {
		AdvContext context = _context.get();
		context.clear();
		assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
		context.popAndExec();
		int referIndex = context.store();

		return (double) (MAGIC_LOCALS_NUMBER + referIndex);
	}

	/**
	 * 把当前堆栈顶端的对象存储到locals中
	 * 
	 * @param <T>
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	static public <T> T refer_(T value) {
		AdvContext context = _context.get();
		context.clear();
		context.popAndExec();
		int locals = context.store();

		Class<?> t = value.getClass();

		if (t == boolean.class) {
			throw new UnsupportedOperationException();
		} else if (t == Byte.class) {
			int codeIndex = ((Byte) value).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
			Byte key = (byte) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Character.class) {
			int codeIndex = ((Character) value).charValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
			Character key = (char) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Short.class) {
			int codeIndex = ((Short) value).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
			Short key = (short) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Integer.class) {
			int codeIndex = ((Integer) value).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
			Integer key = (int) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Long.class) {
			int codeIndex = ((Long) value).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
			Long key = (long) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Float.class) {
			int codeIndex = ((Float) value).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
			Double key = (double) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == Double.class) {
			int codeIndex = ((Byte) value).intValue() - MAGIC_CODES_NUMBER;
			assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";
			Double key = (double) (MAGIC_LOCALS_NUMBER + locals);
			return (T) key;
		} else if (t == String.class) {

			String name = (String) value;
			assert name.startsWith(MAGIC_CODES_String) : "这里必须返回代码索引";

			int codeIndex = Integer.valueOf(name.substring(MAGIC_CODES_String.length()));
			assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";

			String key = String.valueOf(MAGIC_LOCALS_String + locals);
			return (T) key;
		} else if (value instanceof TinyAsmProxyRuntimeReferNameObject) {
			AdvRuntimeReferNameObject obj = ((AdvRuntimeReferNameObject) value);
			String name = obj.get__ReferName();

			assert name.startsWith(MAGIC_CODES_String) : "这里必须返回代码索引";

			int codeIndex = Integer.valueOf(name.substring(MAGIC_CODES_String.length()));
			assert (codeIndex == 0) && (context.stackSize() == 1) : "堆栈必须只有一个值";

			String key = String.valueOf(MAGIC_LOCALS_String + locals);
			obj.set__ReferName(key);
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
		AdvContext context = _context.get();
		return if_(isTrue(beGood));
	}

	static public AfterIf ifFalse_(boolean beGood) {
		AdvContext context = _context.get();
		assert /* (codeIndex == 0) && */ (context.stackSize() == 1) : "堆栈必须只有一个值";
		return if_(isFalse(beGood));
	}

	static public AfterIf if_(CompareEval eval) {
		AdvContext context = _context.get();
		context.clear();
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
		AdvContext context = _context.get();
		context.clear();
		WhileBuilder builder = new WhileBuilder(context, eval);
		context.push(builder);
		return builder;
	}

	static public AfterDo do_(ConsumerWithException<MethodCode> block) {
		AdvContext context = _context.get();
		context.clear();
		DoWhileBuilder builder = new DoWhileBuilder(context, block);
		context.push(builder);
		return builder;
	}

	static public CompareEval isLessThan(int left, int right) {
		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> rightEval = context.resolve(right);
		ConsumerWithException<MethodCode> leftEval = context.resolve(left);
		return new CompareEval() {

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
				code.IF_ICMPLT(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
				code.IF_ICMPGE(label);
			}
		};
	}

	static public CompareEval isGreaterThan(int left, int right) {
		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> rightEval = context.resolve(right);
		ConsumerWithException<MethodCode> leftEval = context.resolve(left);
		return new CompareEval() {

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
				code.IF_ICMPGT(label);

			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
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
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
				code.IF_ICMPEQ(label);

			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
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
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
				code.IF_ICMPNE(label);

			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
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
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
				code.IF_ICMPGE(label);

			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
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
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
				code.IF_ICMPLE(label);

			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				rightEval.accept(code);
				code.IF_ICMPGT(label);

			}
		};

	}

	static public CompareEval isTrue(boolean eval) {
		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> leftEval = context.getCodeAndPopTop();
		return new CompareEval() {

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				code.IFNE(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				code.IFEQ(label);

			}
		};
	}

	static public CompareEval isFalse(boolean eval) {
		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> leftEval = context.getCodeAndPopTop();

		return new CompareEval() {

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				code.IFEQ(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				code.IFNE(label);
			}
		};
	}

	static public CompareEval isTrue(Boolean__ eval) {
		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> leftEval = context.resolve(eval);
		return new CompareEval() {

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				code.IFNE(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				code.IFEQ(label);

			}
		};
	}

	static public CompareEval isFalse(Boolean__ eval) {
		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> leftEval = context.resolve(eval);
		return new CompareEval() {

			@Override
			public void gotoWhenSucceed(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
				code.IFEQ(label);
			}

			@Override
			public void gotoWhenFail(MethodCode code, Label label) throws Exception {
				leftEval.accept(code);
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
