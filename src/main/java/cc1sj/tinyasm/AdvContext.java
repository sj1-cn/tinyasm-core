package cc1sj.tinyasm;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_MAX;
import static cc1sj.tinyasm.Adv.MAGIC_CODES_NUMBER;
import static cc1sj.tinyasm.Adv.*;
import static cc1sj.tinyasm.Adv.MAGIC_LOCALS_MAX;
import static cc1sj.tinyasm.Adv.MAGIC_LOCALS_NUMBER;
import static cc1sj.tinyasm.Adv.MAGIC_LOCALS_String;

import java.util.Stack;

public class AdvContext {

	private MethodCode code;
	Stack<ConsumerWithException<MethodCode>> stack = new Stack<>();

	public AdvContext(MethodCode code) {
		this.code = code;
	}

	public byte push(Class<?> clz, ConsumerWithException<MethodCode> c) {
		stack.push(c);
		return (byte) (stack.size() - 1);
	}

	public void exec(ConsumerWithException<MethodCode> c) {
		try {
			c.accept(code);
		} catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public MethodCode getCode() {
		return code;
	}
//
//	public ConsumerWithException<MethodCode> getCode(int codeIndex) {
//		return stack.get(codeIndex);
//	}

	public ConsumerWithException<MethodCode> getCodeAndPop(int i) {
		assert i == this.stack.size() - 1 : "必须在堆栈顶部，不然一定有一个环节错了";
		return stack.pop();
	}

	public ConsumerWithException<MethodCode> getCodeAndPop() {
//		assert i == this.stack.size() - 1 : "必须在堆栈顶部，不然一定有一个环节错了";
		return stack.pop();
	}

	public void clear() {
//		assert stack.size() <= 1 : "应该最多缓存一个执行语句。如果大于一个，一定是哪里出错了";
		if (stack.size() > 0) popAndExec();
		if (ifbuilder != null) {
			try {
				code.LINE();
				ifbuilder.accept(code);
			} catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
			ifbuilder = null;
		}
	}

	protected void execBlock(ConsumerWithException<MethodCode> block) throws Exception {
		AdvContext contentBlock = Adv.enterCode(code);
		MethodCode codeBlock = contentBlock.code;

		int lastStackSize = codeBlock.advStackSize();
		block.accept(contentBlock.code);
		if (contentBlock.stackSize() > 0) {
			contentBlock.popAndExec();
		}
		while (codeBlock.advStackSize() > lastStackSize) {
			codeBlock.POP();
		}

	}

	public void execLine(ConsumerWithException<MethodCode> line) {
		clear();
		try {
			code.LINE();
			line.accept(code);
		} catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public void popAndExec() {
		assert stack.size() > 0 : "堆栈中必须有东西可以执行";
		if (stack.size() > 0) {
			ConsumerWithException<MethodCode> c = stack.pop();
			clear();
			try {
				code.LINE();
				c.accept(code);
			} catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public int stackSize() {
		return this.stack.size();
	}

	public int store(String name) {
		int localsIndex = code.STORE(name);
		return localsIndex;

	}

	public void store(int referIndex) {
		code.STORE(referIndex);
	}

	public void popCodeStack() {
		this.stack.pop();
	}

	public void pop() {
		this.code.POP();
	}

	public ConsumerWithException<MethodCode> resolve(boolean magicNumber) {
		return getCodeAndPop();
	}

	public ConsumerWithException<MethodCode> resolve(boolean_ magicBooleanNumber) {
		byte magicNumber = magicBooleanNumber.getMagicNumber();
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop(magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(Boolean__ magicBooleanNumber) {
		byte magicNumber = magicBooleanNumber.getMagicNumber();
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop(magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(byte magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop(magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(char magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop(magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(short magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
			return getCodeAndPop(magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(int magicNumber) {
		// Locals
		return doResolve(magicNumber);
	}

	protected ConsumerWithException<MethodCode> doResolve(int magicNumber) {
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
			int codeIndex = magicNumber - MAGIC_CODES_NUMBER;
			return getCodeAndPop(codeIndex);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			int localsIndex = magicNumber - MAGIC_LOCALS_NUMBER;
			return c -> c.LOAD(localsIndex);
		} else if (MAGIC_FIELDS_NUMBER <= magicNumber && magicNumber <= MAGIC_FIELDS_MAX) {
			int fieldIndex = magicNumber - MAGIC_FIELDS_NUMBER;
			return c -> {
				c.LOAD_THIS();
				c.GETFIELD_OF_THIS(fieldIndex);
			};
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(long magicNumber) {
		return doResolve((int) magicNumber);
	}

	public ConsumerWithException<MethodCode> resolve(float magicNumber) {
		return doResolve((int) magicNumber);
	}

	public ConsumerWithException<MethodCode> resolve(double magicNumber) {
		return doResolve((int) magicNumber);
	}

	public ConsumerWithException<MethodCode> resolve(Boolean magicNumber) {
		return getCodeAndPop();
	}

	public ConsumerWithException<MethodCode> resolve(Byte magicNumber) {
		return doResolve((int) magicNumber);
	}

	public ConsumerWithException<MethodCode> resolve(Character magicNumber) {
		return doResolve((int) magicNumber);
	}

	public ConsumerWithException<MethodCode> resolve(Short magicNumber) {
		return doResolve((int) magicNumber);
	}

	public ConsumerWithException<MethodCode> resolve(Integer magicNumber) {
		return doResolve((int) magicNumber);
	}

	public ConsumerWithException<MethodCode> resolve(Long magicNumber) {
		return doResolve(magicNumber.intValue());
	}

	public ConsumerWithException<MethodCode> resolve(Float magicNumber) {
		return doResolve((int) magicNumber.intValue());
	}

	public ConsumerWithException<MethodCode> resolve(Double magicNumber) {
		return doResolve((int) magicNumber.intValue());
	}

	public ConsumerWithException<MethodCode> resolve(String magicString) {
		// Locals
		if (magicString.startsWith(MAGIC_CODES_String)) {
			int codesIndex = Integer.valueOf(magicString.substring(MAGIC_CODES_String.length()));
			return getCodeAndPop(codesIndex);
		} else if (magicString.startsWith(MAGIC_LOCALS_String)) {
			int localsIndex = Integer.valueOf(magicString.substring(MAGIC_LOCALS_String.length()));
			return c -> c.LOAD(localsIndex);
		} else if (magicString.startsWith(MAGIC_FIELD_String)) {
			int fieldIndex = Integer.valueOf(magicString.substring(MAGIC_FIELD_String.length()));
			return c -> {
				c.LOAD_THIS();
				c.GETFIELD_OF_THIS(fieldIndex);
			};
		} else {
			return c -> c.LOADConst(magicString);
		}
	}

	public ConsumerWithException<MethodCode> resolve(String[] magicStringArray) {
		return resolve(magicStringArray[0]);
	}

	public ConsumerWithException<MethodCode> resolve(byte[] tarray) {
		return resolve((int) tarray[0]);
	}

	public ConsumerWithException<MethodCode> resolve(short[] tarray) {
		return resolve((int) tarray[0]);
	}

	public ConsumerWithException<MethodCode> resolve(int[] tarray) {
		return resolve((int) tarray[0]);
	}

	public ConsumerWithException<MethodCode> resolve(long[] tarray) {
		return resolve((int) tarray[0]);
	}

	public ConsumerWithException<MethodCode> resolve(float[] tarray) {
		return resolve((int) tarray[0]);
	}

	public ConsumerWithException<MethodCode> resolve(double[] tarray) {
		return resolve((int) tarray[0]);
	}

	public ConsumerWithException<MethodCode> resolve(Byte[] tarray) {
		return resolve((int) tarray[0]);
	}

	public ConsumerWithException<MethodCode> resolve(Short[] tarray) {
		return resolve((int) tarray[0]);
	}

	public ConsumerWithException<MethodCode> resolve(Integer[] tarray) {
		return resolve((int) tarray[0]);
	}

	public ConsumerWithException<MethodCode> resolve(Long[] tarray) {
		return resolve((int) (long) tarray[0]);
	}

	public ConsumerWithException<MethodCode> resolve(Float[] tarray) {
		return resolve((int) (float) tarray[0]);
	}

	public ConsumerWithException<MethodCode> resolve(Double[] tarray) {
		return resolve((int) (double) tarray[0]);
	}

	public <T> ConsumerWithException<MethodCode> resolve(T[] tarray) {
		T t = tarray[0];
		if (t instanceof AdvRuntimeReferNameObject) {
			byte magicNumber = ((AdvRuntimeReferNameObject) t).get__MagicNumber();
			if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
				int codeIndex = magicNumber - MAGIC_CODES_NUMBER;
				return getCodeAndPop(codeIndex);
			} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
				int localsIndex = magicNumber - MAGIC_LOCALS_NUMBER;
				return c -> c.LOAD(localsIndex);
			} else if (MAGIC_FIELDS_NUMBER <= magicNumber && magicNumber <= MAGIC_FIELDS_MAX) {
				int fieldIndex = magicNumber - MAGIC_FIELDS_NUMBER;
				return c -> {
					c.LOAD_THIS();
					c.GETFIELD_OF_THIS(fieldIndex);
				};
			} else {
				throw new UnsupportedOperationException();
			}
		}
		if (t.getClass() == String.class) {
			return resolve((String) t);
		} else {
			throw new UnsupportedOperationException();
		}
	}

	public <T> ConsumerWithException<MethodCode> resolve(T t) {
		if (t instanceof AdvRuntimeReferNameObject) {
			byte magicNumber = ((AdvRuntimeReferNameObject) t).get__MagicNumber();
			if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
				int codeIndex = magicNumber - MAGIC_CODES_NUMBER;
				return getCodeAndPop(codeIndex);
			} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
				int localsIndex = magicNumber - MAGIC_LOCALS_NUMBER;
				return c -> c.LOAD(localsIndex);
			} else if (MAGIC_FIELDS_NUMBER <= magicNumber && magicNumber <= MAGIC_FIELDS_MAX) {
				int fieldIndex = magicNumber - MAGIC_FIELDS_NUMBER;
				return c -> {
					c.LOAD_THIS();
					c.GETFIELD_OF_THIS(fieldIndex);
				};
			} else {
				throw new UnsupportedOperationException();
			}
		}
		if (t.getClass() == String.class) {
			return resolve((String) t);
		} else {
			throw new UnsupportedOperationException();
		}
	}

	public <T> ConsumerWithException<MethodCode> resolve(Object obj, Class<T> vc) {
//		Class<?> vc = obj.getClass();
		if (vc == byte.class) {
			return resolve(((Byte) obj).byteValue());
		} else if (vc == char.class) {
			return resolve(((Character) obj).charValue());
		} else if (vc == short.class) {
			return resolve(((Short) obj).shortValue());
		} else if (vc == int.class) {
			return resolve(((Integer) obj).intValue());
		} else if (vc == long.class) {
			return resolve(((Long) obj).longValue());
		} else if (vc == float.class) {
			return resolve(((Float) obj).floatValue());
		} else if (vc == double.class) {
			return resolve(((Double) obj).doubleValue());
		} else if (vc == Byte.class) {
			return resolve(((Byte) obj));
		} else if (vc == Character.class) {
			return resolve(((Character) obj));
		} else if (vc == Short.class) {
			return resolve(((Short) obj));
		} else if (vc == Integer.class) {
			return resolve(((Integer) obj));
		} else if (vc == Long.class) {
			return resolve(((Long) obj));
		} else if (vc == Float.class) {
			return resolve(((Float) obj));
		} else if (vc == Double.class) {
			return resolve(((Double) obj));
		} else if (vc == Byte.class) {
			return resolve(((Byte) obj));
		} else if (vc == Byte.class) {
			return resolve(((Byte) obj));
		} else if (obj instanceof AdvRuntimeReferNameObject) {
			return resolve(((AdvRuntimeReferNameObject) obj));
		} else {
			throw new UnsupportedOperationException("Only accept tinyasm proxy object");
		}
	}

	public void line() {
		code.LINE();
	}

	IfBuilder ifbuilder;

	public void pushIf(IfBuilder builder) {
		this.ifbuilder = builder;
	}
}
