package cn.sj1.tinyasm.core;

import static cn.sj1.tinyasm.core.Adv.MAGIC_CODES_NUMBER;
import static cn.sj1.tinyasm.core.Adv.MAGIC_LOCALS_NUMBER;

public class boolean_Holder implements boolean_ {
	byte magicNumber;
	ThreadLocal<AdvContext> contextThreadLocal;

	public boolean_Holder(ThreadLocal<AdvContext> contextThreadLocal, byte magicNumber) {
		this.magicNumber = magicNumber;
		this.contextThreadLocal = contextThreadLocal;
	}

	@Override
	public boolean load() {
		AdvContext context = contextThreadLocal.get();
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			context.push(boolean.class, context.getCodeAndPop(magicNumber - MAGIC_CODES_NUMBER));
			return false;
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			context.push(boolean.class, c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER));
		} else {
			context.push(boolean.class, c -> c.LOADConst(magicNumber != 0));
		}

		return false;
	}

	@Override
	public byte getMagicNumber() {
		return this.magicNumber;
	}
}
