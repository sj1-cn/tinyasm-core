package cc1sj.tinyasm;

import static cc1sj.tinyasm.Adv.*;

public class Boolean__Holder implements Boolean__ {
	byte magicNumber;
	AdvContext context;

	public Boolean__Holder(AdvContext context, byte magicNumber) {
		this.magicNumber = magicNumber;
		this.context = context;
	}

	@Override
	public Boolean load() {
		// Locals
		if (MAGIC_CODES_NUMBER <= magicNumber && magicNumber < MAGIC_LOCALS_NUMBER) {
			context.push(context.getCodeAndPop(magicNumber - MAGIC_CODES_NUMBER));
			return false;
		} else if (MAGIC_LOCALS_NUMBER <= magicNumber && magicNumber <= MAGIC_LOCALS_NUMBER + 20) {
			context.push(c -> c.LOAD(magicNumber - MAGIC_LOCALS_NUMBER));
		} else {
			context.push(c -> c.LOADConst(magicNumber != 0));
		}

		return false;
	}

	@Override
	public byte getLocalsIndex() {
		return this.magicNumber;
	}

}
