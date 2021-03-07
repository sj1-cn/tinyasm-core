package cc1sj.tinyasm;

import static cc1sj.tinyasm.Adv.*;

public class Boolean__Holder implements Boolean__ {
	byte magicNumber;
	ThreadLocal<AdvContext> contextThreadLocal;

	public Boolean__Holder(ThreadLocal<AdvContext> contextThreadLocal, byte magicNumber) {
		this.magicNumber = magicNumber;
		this.contextThreadLocal = contextThreadLocal;
	}

	@Override
	public Boolean load() {
		AdvContext context = contextThreadLocal.get();
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			context.push(Boolean.class, context.getCodeAndPop(magicNumber - MAGIC_CODES_NUMBER));
			return false;
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			context.push(Boolean.class, c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER));
		} else {
			context.push(Boolean.class,  c -> c.LOADConst(magicNumber != 0));
		}
		return false;
	}

	@Override
	public byte getMagicNumber() {
		return this.magicNumber;
	}

}
