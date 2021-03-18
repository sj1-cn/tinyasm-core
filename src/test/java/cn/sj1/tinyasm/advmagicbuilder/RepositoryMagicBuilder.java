package cn.sj1.tinyasm.advmagicbuilder;

import static cn.sj1.tinyasm.Adv._block;
import static cn.sj1.tinyasm.Adv.clazzOf;

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
