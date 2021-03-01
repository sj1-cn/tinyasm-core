package cc1sj.tinyasm.heroadv;

import static cc1sj.tinyasm.heroadv.Adv.*;

import java.util.Iterator;
import java.util.Stack;

import cc1sj.tinyasm.MethodCode;

public class AdvContext {

	private MethodCode code;
	Stack<ConsumerWithException<MethodCode>> stack = new Stack<>();

	public AdvContext(MethodCode code) {

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
		assert stack.size() == 1 : "应该最多缓存一个执行语句。如果大于一个，一定是哪里出错了";
		popAndExec();
	}

	protected void execBlock(ConsumerWithException<MethodCode> block) throws Exception {
		int lastStackSize = code.advStackSize();
		int lastContextStack = this.stackSize();
		block.accept(code);
		while (code.advStackSize() > lastStackSize) {
			code.POP();
		}
		while (this.stackSize() > lastContextStack) {
			this.popAndExec();
		}
	}

	public void popAndExec() {
		ConsumerWithException<MethodCode> c = stack.pop();
		try {
			c.accept(code);
		} catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public int stackSize() {
		return this.stack.size();
	}

	public int store() {
//		code?
		return 10;

	}

	public void store(int referIndex) {
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
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
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
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(byte magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop(magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(char magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop(magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(short magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop(magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(int magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop(magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(long magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop((int) magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			return c -> c.LOAD((int) magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(float magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop((int) magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			return c -> c.LOAD((int) magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(double magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop((int) magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
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
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop(magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(Character magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop((int) magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(Short magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop((int) magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(Integer magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop((int) magicNumber - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			return c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(Long magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop(((Long) magicNumber).intValue() - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			return c -> c.LOAD(((Long) magicNumber).intValue() - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(Float magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop(((Float) magicNumber).intValue() - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			return c -> c.LOAD(((Float) magicNumber).intValue() - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}

	public ConsumerWithException<MethodCode> resolve(Double magicNumber) {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			return getCodeAndPop(((Double) magicNumber).intValue() - MAGIC_CODES_NUMBER);
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			return c -> c.LOAD(((Double) magicNumber).intValue() - MAGIC_LOCALS_NUMBER);
		} else {
			return c -> c.LOADConst(magicNumber);
		}
	}
}
