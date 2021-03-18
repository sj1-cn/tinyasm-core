package cc1sj.tinyasm.advmagicbuilder;

import static cc1sj.tinyasm.Adv.*;

import cc1sj.tinyasm.AdvMagic;

public class RepositoryMagicBuilder<E extends WithIdKey, R> implements Repository<E, R> {

	@SuppressWarnings("unused")
	@Override
	public R update(E t) {
		E tt = __("tt", t);

		_line(code -> {
			code.LOAD("tt");
			code.VIRTUAL(AdvMagic.clazzOf(t), "getName").return_(String.class).INVOKE();
			code.RETURNTop();
		});
		return null;
	}

}
