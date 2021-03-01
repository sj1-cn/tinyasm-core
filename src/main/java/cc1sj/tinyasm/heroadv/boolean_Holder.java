package cc1sj.tinyasm.heroadv;

import static cc1sj.tinyasm.heroadv.Adv.MAGIC_CODES_NUMBER;
import static cc1sj.tinyasm.heroadv.Adv.MAGIC_LOCALS_NUMBER;

public class boolean_Holder implements boolean_ {
	byte magicNumber;
	AdvContext context;

	public boolean_Holder(AdvContext context, byte magicNumber) {
		this.magicNumber = magicNumber;
		this.context = context;
	}

	@Override
	public boolean load() {
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
	public byte getReferIndex() {
		return this.magicNumber;
	}
}
