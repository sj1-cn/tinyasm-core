package cn.sj1.tinyasm.core.advmagicbuilder;

import static cn.sj1.tinyasm.core.Adv._block;
import static cn.sj1.tinyasm.core.Adv.clazzOf;

public class RepositoryMagicBuilder<E extends WithIdKey, R> implements Repository<E, R> {

	@Override
	public R update(E t) {
		_block(code -> {
			code.LINE();
			code.LOAD("t");
			code.VIRTUAL(clazzOf(t), "getName").return_(String.class).INVOKE();
			code.RETURNTop();
		});
		return null;
	}

}
