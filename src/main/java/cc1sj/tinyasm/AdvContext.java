package cc1sj.tinyasm;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_MAX;
import static cc1sj.tinyasm.Adv.MAGIC_CODES_NUMBER;
import static cc1sj.tinyasm.Adv.MAGIC_CODES_String;
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

	public byte push(ConsumerWithException<MethodCode> c) {
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

	public ConsumerWithException<MethodCode> getCodeAndPopTop() {
//		assert i == this.stack.size() - 1 : "必须在堆栈顶部，不然一定有一个环节错了";
		return stack.pop();
	}

	public void clear() {
		assert stack.size() <= 1 : "应该最多缓存一个执行语句。如果大于一个，一定是哪里出错了";
		if (stack.size() > 0) execAndPop();
	}

	protected void execBlock(ConsumerWithException<MethodCode> block) throws Exception {
		int lastStackSize = code.advStackSize();
		int lastContextStack = this.stackSize();
		block.accept(code);
		while (code.advStackSize() > lastStackSize) {
			code.POP();
		}
		while (this.stackSize() > lastContextStack) {
			this.execAndPop();
		}
	}

	public void execAndPop() {
		assert stack.size() > 0 : "堆栈中必须有东西可以执行";
		if (stack.size() > 0) {
			ConsumerWithException<MethodCode> c = stack.pop();
			try {
				c.accept(code);
			} catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public int stackSize() {
		return this.stack.size();
	}

	public int store() {
		int localsIndex = code.codeLocalsNextLocal();
		code.STORE(localsIndex);
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
		return getCodeAndPopTop();
	}

	public ConsumerWithException<MethodCode> resolve(boolean_ magicBooleanNumber) {
		byte magicNumber = magicBooleanNumber.getReferIndex();
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
		byte magicNumber = magicBooleanNumber.getReferIndex();
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
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
			return getCodeAndPop(magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(long magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
			return getCodeAndPop((int) magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD((int) magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(float magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
			return getCodeAndPop((int) magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD((int) magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(double magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
			return getCodeAndPop((int) magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD((int) magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(Boolean magicNumber) {
		return getCodeAndPopTop();
	}

	public ConsumerWithException<MethodCode> resolve(Byte magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
			return getCodeAndPop(magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(Character magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
			return getCodeAndPop((int) magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(Short magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
			return getCodeAndPop((int) magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(Integer magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
			return getCodeAndPop((int) magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(Long magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
			return getCodeAndPop(((Long) magicNumber).intValue() - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD(((Long) magicNumber).intValue() - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(Float magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
			return getCodeAndPop(((Float) magicNumber).intValue() - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD(((Float) magicNumber).intValue() - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(Double magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
			return getCodeAndPop(((Double) magicNumber).intValue() - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
			return c -> c.LOAD(((Double) magicNumber).intValue() - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(String magicString) {
		// Locals
		if (magicString.startsWith(MAGIC_CODES_String)) {
			int magicNumber = Integer.valueOf(magicString.substring(MAGIC_CODES_String.length()));
			return getCodeAndPop(magicNumber);
		} else if (magicString.startsWith(MAGIC_LOCALS_String)) {
			int magicNumber = Integer.valueOf(magicString.substring(MAGIC_CODES_String.length()));
			return c -> c.LOAD(magicNumber);
		} else {
			return c -> c.LOADConst(magicString);
		}
	}

	public <T> ConsumerWithException<MethodCode> resolve(T t) {
		if (t instanceof AdvRuntimeReferNameObject) {
			byte magicNumber = ((AdvRuntimeReferNameObject) t).get__MagicNumber();
			if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_CODES_MAX) {
				return getCodeAndPop(magicNumber);
			} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_MAX) {
				return c -> c.LOAD(magicNumber);
			} else {
				throw new UnsupportedOperationException();
			}
		} else {
			throw new UnsupportedOperationException();
		}
	}

	
	 public <T> void resolve(T obj, Class<?> vc) {
//		Class<?> vc = obj.getClass();
		if (vc == byte.class) {
			resolve(((Byte) obj).byteValue());
		} else if (vc == char.class) {
			resolve(((Character) obj).charValue());
		} else if (vc == short.class) {
			resolve(((Short) obj).shortValue());
		} else if (vc == int.class) {
			resolve(((Integer) obj).intValue());
		} else if (vc == long.class) {
			resolve(((Long) obj).longValue());
		} else if (vc == float.class) {
			resolve(((Float) obj).floatValue());
		} else if (vc == double.class) {
			resolve(((Double) obj).doubleValue());
		} else if (vc == Byte.class) {
			resolve(((Byte) obj));
		} else if (vc == Character.class) {
			resolve(((Character) obj));
		} else if (vc == Short.class) {
			resolve(((Short) obj));
		} else if (vc == Integer.class) {
			resolve(((Integer) obj));
		} else if (vc == Long.class) {
			resolve(((Long) obj));
		} else if (vc == Float.class) {
			resolve(((Float) obj));
		} else if (vc == Double.class) {
			resolve(((Double) obj));
		} else if (vc == Byte.class) {
			resolve(((Byte) obj));
		} else if (vc == Byte.class) {
			resolve(((Byte) obj));
		} else if (obj instanceof TinyAsmProxyRuntimeReferNameObject) {
			String name = ((TinyAsmProxyRuntimeReferNameObject) obj).get__ReferName();
			code.LOAD(name);
		} else {
			throw new UnsupportedOperationException("Only accept tinyasm proxy object");
		}
	}
	public void line() {
		code.LINE();
	}
}
